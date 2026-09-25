package br.com.technexus.desafio;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * DESAFIO DE ENGENHARIA / SEGURANÇA.
 *
 * Recupera a senha de 6 caracteres (prefixo conhecido "lam" + 3 caracteres
 * de [a-z0-9]) por força bruta. Uma senha incorreta faz o padding do AES
 * falhar (BadPaddingException); o erro é ignorado e o laço testa a próxima.
 *
 * Formato OpenSSL: Base64( "Salted__" (8) + salt (8) + cifrado ).
 * Derivação: PBKDF2 (HMAC-SHA256), 1000 iterações -> 48 bytes = 32 (key) + 16 (iv).
 */
public class ForcaBruta {

    public static void main(String[] args) {
        String encryptedB64 = "U2FsdGVkX189CvKETNa+k2wHIMpbCwNk7HKB3nBRzOD9bBaPt2nFMCdElvKoRfTmmqVv41Trh37ORXFWRVNOX3"
                + "vpgPHULkkaoyh9DfmzrGBXkGnu/SJfQkGuU08zbgMQNSwCGTwoIHkUMzRFQELN0Q==";

        encryptedB64 = encryptedB64.replaceAll("\\s", "");
        byte[] cipherData = Base64.getDecoder().decode(encryptedB64);

        byte[] salt = Arrays.copyOfRange(cipherData, 8, 16);
        byte[] cipherText = Arrays.copyOfRange(cipherData, 16, cipherData.length);

        String charset = "abcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println("Iniciando forca bruta (prefixo 'lam' + 3 caracteres)...");
        long startTime = System.currentTimeMillis();

        // Combina os 3 últimos caracteres: de "lam000" até "lamzzz"
        for (char c1 : charset.toCharArray()) {
            for (char c2 : charset.toCharArray()) {
                for (char c3 : charset.toCharArray()) {
                    String testPass = "lam" + c1 + c2 + c3;
                    try {
                        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                        PBEKeySpec spec = new PBEKeySpec(testPass.toCharArray(), salt, 1000, 48 * 8);
                        byte[] keyAndIv = factory.generateSecret(spec).getEncoded();

                        byte[] key = Arrays.copyOfRange(keyAndIv, 0, 32);
                        byte[] iv = Arrays.copyOfRange(keyAndIv, 32, 48);

                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(Cipher.DECRYPT_MODE,
                                new SecretKeySpec(key, "AES"),
                                new IvParameterSpec(iv));

                        byte[] decrypted = cipher.doFinal(cipherText);
                        String result = new String(decrypted, StandardCharsets.UTF_8);

                        if (result.contains("http")) {
                            long endTime = System.currentTimeMillis();
                            System.out.println("\nSUCESSO! Cofre aberto!");
                            System.out.println("Senha encontrada: " + testPass);
                            System.out.println("URL revelada: " + result.trim());
                            System.out.println("Tempo: " + (endTime - startTime) + "ms");
                            return;
                        }
                    } catch (Exception e) {
                        // Senha incorreta -> BadPaddingException ignorada; continua o laço.
                    }
                }
            }
        }
        System.out.println("\nForca bruta concluida. Senha nao encontrada.");
    }
}
