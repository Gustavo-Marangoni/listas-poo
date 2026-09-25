# Listas de Exercícios - POO (Java)

| Pasta | Lista | Conteúdo |
|---|---|---|
| `lista-03-04-meu-primeiro-sistema` | Lista 03 (Missão 02) e Lista 04 (Missão 03) | Pacotes, classes `Carro` e `Sistema`; encapsulamento com getters/setters e `.gitignore` |
| `lista-05-operacao-enigma` | Lista 05 (Operação Enigma) | Padrão Strategy: `Decodificador` (Base64, César, Reverso) e `FiltroImagem` (`FiltroVermelhoMagico`) |
| `lista-06-cofre-forte` | Lista 06 (Missão 04) | `Agencia`, `Cliente` e `ContaBancaria` a partir do UML e regras de negócio, com `MainTeste` |
| `lista-07-operacao-refatoracao` | Lista 07 (Operação Refatoração) | Padrão **Strategy** (`EstrategiaFrete`) + exceção customizada `TipoFreteInvalidoException`, eliminando `if/else` (OCP/SOLID) |
| `lista-08-zero-trust` | Lista 08 (Zero Trust) | `equals`/`hashCode` por `codigoHex`, Array (garagem), `List` (catraca) e `HashSet` (cofre anti-clonagem) |
| `lista-09-engenharia-em-acao` | Lista 09 (Engenharia de Software em Ação) | 20 questões (Módulos A–D): encapsulamento, `static`, interface `Pagamento` + polimorfismo e coleções |
| `lista-10-estrutura-de-dados` | Lista 10 (List vs Set) | `ArrayList` vs `HashSet` no controle de acessos da TechCorp, com identidade por matrícula |
| `lista-11-protocolo-de-resiliencia` | Lista 11 (Protocolo de Resiliência) | Tratamento de exceções (checked/unchecked, `try-catch-finally`, custom) + Desafio Extra (AES/CTF) |

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

# Lista 07
cd lista-07-operacao-refatoracao
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out br.com.ecommerce.main.MainTeste

# Lista 08
cd lista-08-zero-trust
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out br.com.cybercorp.main.MainTeste

# Lista 09 (quatro classes executáveis)
cd lista-09-engenharia-em-acao
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out app.MainStreaming     # tambem: app.MainMemoria, app.MainPagamento, app.MainSeguranca

# Lista 10
cd lista-10-estrutura-de-dados
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out br.com.techcorp.main.MainTechCorp

# Lista 11
cd lista-11-protocolo-de-resiliencia
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out br.com.nexustech.main.Main   # Desafio Extra: br.com.fronteira.main.App
```

## Resultado da Operação Enigma

1. Bytes escondidos após o fim do `pista_01.jpg` → Base64 → `Chave_Cesar: 7 | Alvo: mensagem.txt`
2. `mensagem.txt` com César (chave 7) → `Filtre o canal VERMELHO da imagem ruido.bmp. Impar = Preto, Par = Branco`
3. `FiltroVermelhoMagico` em `ruido.bmp` → `arquivos/revelado.png` com a URL do cofre: **bit.ly/POOcript**
