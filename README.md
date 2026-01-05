# Mentali Games 🎮

**Mentali Games** é uma coleção de jogos de console desenvolvida em **Java**, com foco em desafios de lógica e raciocínio rápido.  
Atualmente, o projeto conta com **dois jogos**:

1. **Número Secreto** – Adivinhe o número gerado entre 1 e 100.
2. **Palavra Sinuosa** – Descubra palavras embaralhadas de diferentes categorias.

---

## 🎯 Jogos Disponíveis

### 1. Número Secreto

**Objetivo:** Adivinhar um número secreto gerado aleatoriamente entre 1 e 100.

**Como funciona:**
- O sistema gera um número aleatório.
- Você faz um palpite.
- O jogo dá dicas se o número secreto é **maior** ou **menor** que o seu palpite.
- Continue tentando até acertar!

**Pontuação:**
- **+10 pontos** ao acertar.
- **-1 ponto** a cada palpite errado.

---

### 2. Palavra Sinuosa

**Objetivo:** Adivinhar palavras embaralhadas de diferentes categorias.

**Categorias disponíveis:**
- 🍎 **Frutas**
- 🔧 **Objetos**
- 🚗 **Marcas de Carro**

**Como funciona:**
- O sistema embaralha as letras de uma palavra.
- Você tenta adivinhar a palavra original.
- Se errar, pode tentar novamente ou pular para a próxima.

**Pontuação:**
- **+20 pontos** ao acertar.
- **-2 pontos** a cada erro.

---

## 🗂 Estrutura do Projeto

```text
src/
└─ mentali/
   ├─ Mentali.java           # Classe principal (menu e seleção de jogos)
   ├─ JogoBase.java          # Classe abstrata base para os jogos
   ├─ NumeroSecreto.java     # Lógica do jogo Número Secreto
   └─ PalavraSinuosa.java    # Lógica do jogo Palavra Sinuosa

palavras/
├─ frutas.txt                # Lista de frutas
├─ objetos.txt               # Lista de objetos
└─ marcas.txt                # Lista de marcas de carro
