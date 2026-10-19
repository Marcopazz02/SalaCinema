SalaCinema/
├── docs/                               # Documentação exigida pelo trabalho
│   ├── decisoes.md                     # Registro das decisões arquiteturais e alternativas descartadas
│   └── diagrama-classes.png            # Diagrama UML atualizado
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cinemaapp/
│   │   │           ├── App.java        # Classe principal com o método main
│   │   │           ├── domain/         # Núcleo de regras de negócio puras
│   │   │           │   ├── exception/  # Exceções tratáveis personalizadas
│   │   │           │   ├── model/      # Entidades e Value Objects (Assento, Cliente, Reserva, Periodo)[cite: 1]
│   │   │           │   ├── policy/     # Padrões Strategy (regras de precificação e cancelamento)[cite: 1]
│   │   │           │   └── repository/ # Interfaces abstratas (ex: Repositorio<T, ID>)[cite: 1]
│   │   │           ├── infrastructure/ # Detalhes técnicos e de entrada/saída
│   │   │           │   └── persistence/# Implementação de salvamento/leitura em JSON[cite: 1]
│   │   │           ├── service/        # Gestão de ciclo de vida, regras de período e Streams[cite: 1]
│   │   │           └── ui/             # Interface de linha de comando (CLI)[cite: 1]
│   │   └── resources/                  # Arquivos estáticos e dados padrão
│   └── test/
│       └── java/
│           └── com/
│               └── cinemaapp/          # Estrutura espelhada para suíte de testes (JUnit)[cite: 1]
│                   ├── domain/         # Testes de invariantes, modelos e estratégias[cite: 1]
│                   ├── infrastructure/ # Testes de serialização e restauração em JSON[cite: 1]
│                   └── service/        # Testes de fluxos e validações de conflito[cite: 1]
├── IA_USAGE.md                         # Histórico de utilização de Inteligência Artificial[cite: 1]
├── README.md                           # Explicação da variante, regras do domínio e execução[cite: 1]
├── mvnw                                # Executável do Maven Wrapper (Linux/macOS)[cite: 1]
├── mvnw.cmd                            # Executável do Maven Wrapper (Windows)[cite: 1]
└── pom.xml                             # Arquivo de gerenciamento de dependências Maven[cite: 1]