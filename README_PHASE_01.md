# 🎾 Tennis Portfolio — Simulación de Partido de Tenis (UML + Java) ![Java](https://img.shields.io/badge/Java-17-blue) ![Maven](https://img.shields.io/badge/Maven-3.8-green)
## 📘 Descripción General


Este proyecto es una **simulación progresiva de un partido de tenis**, desarrollada en **Java** siguiendo principios de **Programación Orientada a Objetos (POO)** y utilizando **diagramas UML** para modelar su dominio.
Su objetivo es demostrar una comprensión sólida de conceptos de **encapsulación, herencia, composición y principios SOLID**, con un enfoque evolutivo por fases.


---


## 🧩 Fase 1 — Modelo de Dominio


### 🎯 Objetivo
Modelar las entidades principales de un partido de tenis, representando jugadores, equipos y estadísticas básicas.


### 🏗️ Clases implementadas


| Clase | Descripción |
|-------|--------------|
| **Participante** | Clase base abstracta que define los atributos y comportamientos comunes de cualquier participante del partido. |
| **Jugador** | Representa a un jugador individual. Hereda de `Participante` y contiene su propio `RegistroEstadisticas`. |
| **Equipo** | Agrupa jugadores para modalidades dobles o mixtas. Implementa composición de `Jugador`. |
| **RegistroEstadisticas** | Registra estadísticas básicas como aces, errores no forzados y primeros saques acertados. |


---


## 🧠 Diagrama UML (Fase 1)


---


![Fase 1 - Modelo de Dominio (Tenis)](https://uml.planttext.com/plantuml/svg/TLBBJiD03BplLrWvfLHxA4TKLKLgE5I0AieFk8aLBKhMgNV31VXtDa-QaXvtPkmPswkspgFukYoKDxuWU497i08DBvnHmP0HxBWqrZ34xsIDMoY59-S5KmzfWSx18JGmgQdGUe8l1Q7OSdaIWWSuUZ4s3zWISlAlBHmlfeGRYQkoHlV99bC_IdLM-ph7ZALteP0zCowOemlIDyh3GpYvW0VdIwprdnMFFicvDXNV74R3HnU46j_dKBxkasq6m_qWQDrc9V-tCVhFfUlJODgQ6kkx7OZqCGQa4bEIi3lYkIRtc9A47lodM89qtL426OzBdZ19q_O6TsWDslOnzks3yCHS4Df9ZUTkigiX9pzc_QtrS5ZLBpvQHN0NuEW-6gdXzbflvg-djcIpvYV_0W00)


---





