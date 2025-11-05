# 🎮 Sistema de Partido de Tenis – Fase 2: Modelo del Juego (Game)

> **Autor:** Andersson Fuentes  
> **Proyecto de Portafolio:** Sistema de Partido de Tenis  
> **Enfoque:** Análisis y Diseño Orientado a Objetos con Aplicaciones – *Grady Booch*  
> **Tecnologías:** Java 21 · UML (PlantUML) · IntelliJ IDEA · Git & GitHub

---

## 🧭 Contexto del Dominio

En esta segunda fase, el proyecto evoluciona desde el **modelo del dominio** (Fase 1) hacia la **modelación del comportamiento del juego**.  
Siguiendo el enfoque de *Grady Booch*, esta etapa se centra en **dar vida al modelo**, representando las **reglas y dinámicas** que rigen un *Game* dentro de un partido de tenis.

> *“El dominio define las piezas; el comportamiento les da propósito.”*

---

## 🎾 Objetivo de la Fase 2

Modelar la estructura y el flujo de un **juego de tenis individual (Game)**, donde dos jugadores compiten aplicando reglas clásicas, como la secuencia de puntos *(Love, 15, 30, 40, Deuce, Advantage, Game)*.

Esta fase busca **desacoplar la lógica del juego de sus reglas**, aplicando principios de diseño orientado a objetos.

---

## 🧩 Estructura del Modelo

### **Clases principales**
| Clase | Descripción |
|:--|:--|
| `Game` | Representa una unidad de juego entre dos jugadores. Coordina la puntuación y determina el ganador del game. |
| `IReglasGame` | Interfaz que define el contrato de las reglas del juego. |
| `ReglasClasicasGame` | Implementación concreta de las reglas tradicionales del tenis. |
| `MainGameDemo` | Clase de demostración que ejecuta y valida el flujo del juego. |

---

## ⚙️ Conceptos de Diseño Aplicados

- **Abstracción y Polimorfismo:** separación entre la lógica del juego y la implementación de reglas.
- **Interfaces (IReglasGame):** contrato que favorece la extensibilidad (permite futuras variantes de reglas).
- **Bajo acoplamiento y alta cohesión:** cada clase cumple una responsabilidad clara.
- **Patrón de Diseño:** *Strategy Pattern* (incipiente), para intercambiar reglas dinámicamente.
- **Principio de Sustitución de Liskov (L en SOLID):** las implementaciones de reglas pueden sustituirse sin alterar el funcionamiento del `Game`.

---

## 📈 Diagrama UML – Fase 2
> *(Este diagrama muestra las relaciones entre `Game`, `IReglasGame`, y `ReglasClasicasGame`.)*  
> 📄 Generado con **PlantUML**

![Diagrama UML](https://uml.planttext.com/plantuml/png/pPBBQiCm44M_OFvXbWc90_6wX43JX1GCfLsMBYRsH5NGmqXoeQz_h-Gu8NRQVHSoykZewWpIqWToeT4A8CYW6Ezq7Tvn9KauqfZXcZpd04isLQIMP_n8frNC8rROYfN5-C7xXeN5qOOqZm6a2UpsL39k7raeygcEdp1vix92tsXo3uq9TlGKd3G23usWohenJBg2tGKst49qu6jiPwrYClXAQsb8oOzO7rrjtv19V5pu1YYZXiUZpcqSikoqfAuLQpR13sopWkgRO-8Kjx4bmMw1THBt_w2La-Mbj6kdaFLFcGyBEKmIVfQPJ_4qpQTu7JZksatR_sgt1RJrmP4ho9L3tOAaIP4hrZOz1Ht_kvJd5oGdV0ktfsRPuj82VhcrsUohp_JoKq1RxPxm3m00)
---

---

## 🧠 Aprendizaje

Durante esta fase comprendí que **el comportamiento del sistema es lo que transforma un modelo estático en un modelo vivo**.  
Al diseñar interfaces y reglas desacopladas, el código deja de ser rígido y comienza a adaptarse a posibles variaciones del dominio.

> “En el diseño orientado a objetos, pensar en cómo se comportan los objetos  
> es tan importante como definir quiénes son.”

---

## 🚀 Próximo Paso – Fase 3

Modelar la **estructura del Set y TieBreak**, aplicando:
- Composición entre *Game* y *Set*
- Manejo de resultados y estadísticas acumuladas
- Aplicación de principios de *Composite Pattern*
- Extensión del modelo UML a nivel de torneo

---

## 🧰 Tecnologías y Herramientas

- Java 21
- UML (PlantUML)
- IntelliJ IDEA
- Git & GitHub

---

## 📎 Recursos y Referencias

- *Grady Booch*, **Análisis y Diseño Orientado a Objetos con Aplicaciones**
- [PlantUML Documentation](https://plantuml.com/)
- [Repositorio del Proyecto](https://github.com/AnderssonFuentes/tennis-portfolio)

---

© 2025 Andersson Fuentes · Proyecto educativo y de portafolio profesional.

