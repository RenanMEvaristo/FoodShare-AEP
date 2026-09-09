FoodShare - Central de Gerenciamento de Doações

Atividade de Estudo Programada (AEP) - 4º Semestre (2026.2)
Cursos Integrados: Engenharia de Software / Análise e Desenvolvimento de Sistemas
Instituição: UniCesumar

---

Integrantes da Equipe
- Renan Madeira Evaristo - RA: 25011033-2
- Samuel Felipe Narciso - RA: 25247839-2
- José Carlos de Mello Junior - RA: 25357053-2


---

1. Concepção e Alinhamento com a ODS

ODS Vinculada: ODS 2 - Fome Zero e Agricultura Sustentável.

Problema Identificado (Dor): Grandes volumes de alimentos perdem o valor comercial antes do término da sua data de validade ou por padrões estéticos, resultando em descarte precoce. Paralelamente, entidades assistenciais e cozinhas comunitárias sofrem com escassez de mantimentos por falta de um canal centralizado que indique onde e quando buscar esses donativos em tempo hábil.

Solução Proposta: O projeto FoodShare é uma aplicação para ambiente de console que conecta estabelecimentos comerciais doadores a instituições receptoras cadastradas, gerenciando prazos de validade, categorias de perecibilidade e o status da coleta dos donativos.

---

Lista de Requisitos do Projeto

1. O sistema deve permitir o cadastro de doadores comerciais (Razão Social, Nome Fantasia, CNPJ, Endereço, Telefone e E-mail de contato).
2. O sistema deve permitir o cadastro de instituições receptoras (Nome da Instituição, CNPJ, Responsável, Endereço, Telefone e Capacidade diária de recebimento).
3. O sistema deve permitir o cadastro de itens para doação (Descrição, Categoria Perecível ou Não Perecível, Quantidade e Data de Validade).
4. O sistema deve permitir a consulta e listagem de doações disponíveis filtrando por categoria de alimento (Perecível / Não Perecível).
5. O sistema deve permitir a atualização do status da doação (Disponível, Em Trânsito, Finalizada ou Cancelada).
6. O sistema deve emitir alertas automáticos no terminal através de método polimórfico conforme o perfil do usuário (Doador ou Instituição).

---

2. Justificativa Técnica e Arquitetura

Linguagem: Java. Adotada pela tipagem estática e pelo suporte nativo aos pilares da Programação Orientada a Objetos (POO), permitindo a implementação de classes abstratas, interfaces, herança e polimorfismo exigidos pelas diretrizes.

Banco de Dados: MySQL. Escolhido pela estabilidade, confiabilidade relacional e garantia de integridade referencial através de chaves estrangeiras vinculando usuários, perfis e doações. A comunicação com o Java é realizada nativamente via JDBC (PreparedStatement e ResultSet).

Padrão Arquitetural: MVC (Model-View-Controller). A camada Model contempla as regras de domínio e classes DAO de persistência, a View trata a interface de interação via console, e o Controller centraliza as validações e intermediação do fluxo.

---

3. Cronograma de Execução

| Período    | Atividade        | Responsável                                                                        |
| :---       | :---             | :---                                                                               |
| Bimestre 1 - Semanas 1 e 2    | Concepção, levantamento de requisitos e alinhamento ODS | Todos os Integrantes     |
| Bimestre 1 - Semana 3         | Criação do repositório no GitHub, estrutura de pastas e README | Renan             |
| Bimestre 1 - Semana 4         | Modelagem do Diagrama de Classes (POO) | Samuel                                    |
| Bimestre 1 - Semana 5         | Modelagem do DER e criação do script SQL (schema.sql) | José                       |
| Bimestre 1 - Semana 6         | Consolidação e entrega do Relatório Técnico em PDF | Todos os integrantes          |
| Bimestre 2 - Semanas 1 e 2    | Implementação das classes de modelo (POO), herança e interface | Renan             |
| Bimestre 2 - Semanas 3 e 4    | Desenvolvimento do CRUD completo e conexão ativa via JDBC | Samuel                 |
| Bimestre 2 - Semana 5         | Construção das camadas View (Terminal) e Controller | José                         |
| Bimestre 2 - Semana 6         | Testes finais integrados, gravação do vídeo e entrega final | Todos os integrantes |

---

4. Estrutura de Diretórios do Repositório

foodshare-aep/
├── /docs/
│   ├── diagrama_classes.png
│   ├── diagrama_der.png
│   └── relatorio_aep_etapa1.pdf
├── /database/
│   ├── schema.sql
│   └── seeds.sql
├── /src/
├── .gitignore
└── README.md
