# Listas de Exercícios - POO (Java)

| Pasta | Lista | Conteúdo |
|---|---|---|
| `lista-03-04-meu-primeiro-sistema` | Lista 03 (Missão 02) e Lista 04 (Missão 03) | Pacotes, classes `Carro` e `Sistema`; encapsulamento com getters/setters e `.gitignore` |
| `lista-05-operacao-enigma` | Lista 05 (Operação Enigma) | Padrão Strategy: `Decodificador` (Base64, César, Reverso) e `FiltroImagem` (`FiltroVermelhoMagico`) |
| `lista-06-cofre-forte` | Lista 06 (Missão 04) | `Agencia`, `Cliente` e `ContaBancaria` a partir do UML e regras de negócio, com `MainTeste` |

## Como executar

Entre na pasta de cada lista e rode:

```bash
# Listas 03 e 04
cd lista-03-04-meu-primeiro-sistema
javac src/br/com/meusistema/model/*.java src/br/com/meusistema/main/*.java
java -cp src br.com.meusistema.main.Sistema

# Lista 05
cd lista-05-operacao-enigma
javac -d bin src/br/com/enigma/decodificador/*.java src/br/com/enigma/filtro/*.java src/br/com/enigma/main/*.java
java -cp bin br.com.enigma.main.Main

# Lista 06
cd lista-06-cofre-forte
javac -d bin src/br/com/banco/model/*.java src/br/com/banco/main/*.java
java -cp bin br.com.banco.main.MainTeste
```

## Resultado da Operação Enigma

1. Bytes escondidos após o fim do `pista_01.jpg` → Base64 → `Chave_Cesar: 7 | Alvo: mensagem.txt`
2. `mensagem.txt` com César (chave 7) → `Filtre o canal VERMELHO da imagem ruido.bmp. Impar = Preto, Par = Branco`
3. `FiltroVermelhoMagico` em `ruido.bmp` → `arquivos/revelado.png` com a URL do cofre: **bit.ly/POOcript**
