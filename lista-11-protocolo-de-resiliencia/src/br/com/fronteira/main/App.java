package br.com.fronteira.main;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * DESAFIO EXTRA - Demonstra controle de fluxo e tratamento de exceções:
 * uma senha incorreta faz o padding do AES falhar e lança BadPaddingException,
 * que é simplesmente ignorada para que o laço continue testando a próxima.
 *
 * Formato do OpenSSL: Base64( "Salted__" (8 bytes) + salt (8 bytes) + cifrado ).
 * Derivação: PBKDF2 (HMAC-SHA256), 1000 iterações -> 48 bytes = 32 (key) + 16 (iv).
 */
public class App {
    public static void main(String[] args) {
        String encryptedB64 = "U2FsdGVkX1/Jz86x4/Ydu3FZFw5pSo86xHG1MwpCFX/"
                + "Dnn9uCMDd3xLNn61XZouvQy6G2FIhyQXAQwvTWn3/01JGIoIh5RN4NXgs+kdpcf6afHmSMvCZu0EiiiXlVpB2EQGIKDLIAU9c1aQx6bzEgQ==";

        // Limpa possíveis quebras de linha do Base64
        encryptedB64 = encryptedB64.replaceAll("\\s", "");

        // 1. Decodifica o Base64 para bytes
        byte[] cipherData = Base64.getDecoder().decode(encryptedB64);

        // 2. Extrai o Salt (bytes 8..15) e o texto cifrado (16 em diante)
        byte[] salt = Arrays.copyOfRange(cipherData, 8, 16);
        byte[] cipherText = Arrays.copyOfRange(cipherData, 16, cipherData.length);

        String charset = "abcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println("Iniciando ataque de forca bruta no link da NexusTech...");
        long startTime = System.currentTimeMillis();

        // 3. Força bruta: combinando os dois últimos caracteres ("javXX")
        for (char c1 : charset.toCharArray()) {
            for (char c2 : charset.toCharArray()) {
                String testPass = "jav" + c1 + c2;
                try {
                    // PBKDF2 gera Key + IV juntos: 32 bytes (key) + 16 bytes (iv) = 48 bytes
                    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                    PBEKeySpec spec = new PBEKeySpec(testPass.toCharArray(), salt, 1000, 48 * 8);
                    byte[] keyAndIv = factory.generateSecret(spec).getEncoded();

                    byte[] key = Arrays.copyOfRange(keyAndIv, 0, 32);
                    byte[] iv = Arrays.copyOfRange(keyAndIv, 32, 48);

                    // Prepara o motor do AES-256-CBC
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(Cipher.DECRYPT_MODE,
                            new SecretKeySpec(key, "AES"),
                            new IvParameterSpec(iv));

                    // Tenta descriptografar. Se a chave estiver errada, o padding falha e lança Exception.
                    byte[] decrypted = cipher.doFinal(cipherText);
                    String result = new String(decrypted, StandardCharsets.UTF_8);

                    // 4. Checa se revelou o link com sucesso
                    if (result.contains("http")) {
                        long endTime = System.currentTimeMillis();
                        System.out.println("\nSUCESSO! A criptografia foi quebrada!");
                        System.out.println("Senha encontrada: " + testPass);
                        System.out.println("Link revelado: " + result.trim());
                        System.out.println("Tempo de execucao: " + (endTime - startTime) + "ms");
                        return; // Interrompe a execução após achar a senha
                    }
                } catch (Exception e) {
                    // Uma senha incorreta aciona a BadPaddingException.
                    // Nós simplesmente ignoramos o erro e o laço continua testando a próxima!
                }
            }
        }
        System.out.println("\nForca bruta concluida. Senha nao encontrada.");
    }
}
