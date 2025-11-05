
# 🎾 Tennis Portfolio — Simulación de un Partido de Tenis (UML + Java)

> **Proyecto educativo-profesional** orientado a demostrar dominio en **Análisis y Diseño Orientado a Objetos (OOAD)** siguiendo el enfoque metodológico de **Grady Booch**.  
> Desarrollado en **Java** y modelado mediante **diagramas UML**, con principios de **POO, encapsulación, herencia, composición y SOLID**.

---

## 🧠 Contexto del Dominio

El dominio del sistema se centra en la **simulación de un partido de tenis**, abarcando tanto la lógica del juego como sus componentes estructurales: jugadores, reglas, puntuaciones, sets, árbitros y torneos.  
Su propósito no es solo representar un partido, sino **capturar su complejidad como un sistema de objetos interactuantes**, tal como lo plantea Grady Booch en su enfoque de modelado orientado a objetos.

En este contexto, cada fase del proyecto representa un avance evolutivo en el entendimiento del dominio:
- Desde el **modelo de entidades base** (jugadores, equipos, estadísticas)
- Hasta la **implementación progresiva de las reglas del juego, los sets, los marcadores y el torneo completo**.

---

## 🧩 Enfoque Metodológico — Grady Booch

El proyecto sigue los principios descritos por **Grady Booch en “Análisis y Diseño Orientado a Objetos con Aplicaciones”**, aplicando:

1. **Identificación de clases y objetos del dominio**  
   (Participante, Jugador, Equipo, RegistroEstadísticas, Game, Set, Partido, etc.)

2. **Modelado conceptual mediante UML**  
   (Diagramas de clases, composición, agregación, dependencias e interfaces)

3. **Implementación evolutiva y modular**  
   Cada fase se construye sobre la anterior, permitiendo refactorizar, extender y validar comportamientos.

4. **Aplicación de principios SOLID y patrones de diseño**  
   Fomentando bajo acoplamiento y alta cohesión en la estructura del código.

---

## 🧭 Arquitectura General del Sistema

El modelo conceptual representa la arquitectura completa del sistema de simulación de tenis, incluyendo sus entidades principales, relaciones y módulos de expansión.

### 🧱 Diagrama UML — Modelo Completo

> **Sistema de Partido de Tenis — Modelo Modular (Basado en Grady Booch)**

![UML del Sistema de Tenis](https://uml.planttext.com/plantuml/png/bLPDSjis5DxZ56_dT2pPKoyv7YMqpT78iMmDoLsc2uY05IGam02a9stZPRSzGMPw2E-RcVecFK6Fa0S2a0X5NdGZaG_lv_lU7_Z6T5HtVLCJSdf4_ltw1_ppRQMVdpwBHa5BZNfDLjJGHXcWxvMcGA6c89gsvWsN7Qt4yvC4pMaDNC8rVQ15fKNRGQCOrrATGCcXrQfLSgE0cuw3qWnL6T_taf3BcXfkO8s_2Lpt6ygKda3sgHUjci0AWOfAj5Hsd6IcqttLzOY8yHgHuXbJ2SnfmoTGy6u2fU0N2EoZjsJA6b4c37gXPW9BgYiN8TLhqMb5bizFhA-HAeBZdp6G6N11gRJaY22dygEG6tpW6uHAZau9wKHNS_Zlhp__XW9TyyO22X7jOycbC3259IQaLd2fBEjEmQzMqjTK4t84gpGl5vUBLNfRPWMXQsH7gmugZ69YuaxaamE_4q3NKZLhZIahEetm1X4VKKqiNdpMQfm0ykXzkVnwLn-SOsws1NXtzWkgZZ70-PVfD1mVE74EBQsiADEhHO7Kqi97EmJ5nwQL3IjavnXexN04GQj5mxKo1VtKx-J7s7o3HwhJYh_wAO479LXya5bNXuzMWzF1vIkChn4KTj5QgPfJ6ImUISZtT3exd4makqppo_JgBYS8ZEjxz0QBq6C3msE4Z9cYEaWZI5ZldjRYDyJKuqXys749XGfcTan4fVQbIaQ8zhJXvEJBR0U8l62shuQyvkaomsbQP1Tvbhx5uSfA7zeEcwzTYvWL5cL9s_DnHqnicMPR2c4c_vyLZhCts614rBz1jESs-coGTjvhilMFfjjGqoaoiih4-h4LZ5ws9aWrpIyMPNxdm_gryDAG7SC3rekvUgcebgPlkNuGXkhhdc_Kg99Xrgz2aB0fV496IVWvYIT___pimBdXNKWFydFPQNmjar5PXt5pz9Bj-jlj3HIwfd12FQmxjFTxRzJA4Urx8Lq7ZmW7VZRLqQf8OhAdPv4gee_UTz37qe1yB0l08siFVBkIGlQzyijxTAZaFQACnHLjyT9YbBarDDIrlCjli-3ONHal--tNE6sLK3AIZZCIwZXEscodnLIam9GT5nzrFzS_oDcmdVFqzktYTXuMixlSGYCgN1e8Z_lftDx6ms36-yfRZeeUVDc0uPwm0RFv3Lu4e_tewkAt8-FOG4BFgRG6Lxp69h1EzxhyWA8Tw1yq7tSt3lwxDOWzC1Q6sR-XUgD8hEWteU-S0_gn0dd39SFlgEy0)

---

## 🚀 Evolución por Fases

| Fase | Enfoque | Descripción |
|------|----------|-------------|
| **Fase 1 — Modelo de Dominio** | Entidades base | Se modelan las clases fundamentales: `Participante`, `Jugador`, `Equipo` y `RegistroEstadísticas`. |
| **Fase 2 — Game** | Reglas del juego | Implementación de `Game`, `IReglasGame` y `ReglasClásicasGame`. Se simula la lógica de puntos. |
| **Fase 3 — Set y TieBreak** | Nivel intermedio | Se define la estructura de `Set`, incluyendo el tie-break y sus condiciones de finalización. |
| **Fase 4 — Partido (Match)** | Integración | Unión de múltiples sets bajo las reglas del partido. Se incorpora árbitro y marcador. |
| **Fase 5 — Torneo** | Escalamiento | Administración de múltiples partidos y ranking general de jugadores. |

---

## 🛠️ Tecnologías y Herramientas

- **Lenguaje:** Java 17
- **Build Tool:** Apache Maven 3.8+
- **IDE:** IntelliJ IDEA
- **Diagramas:** PlantUML / PlantText
- **Control de Versiones:** Git & GitHub
- **Metodología:** Grady Booch (OOAD)
- **Principios:** SOLID, POO, Diseño Evolutivo

---

## 👨‍💻 Autor

**Andersson Fuentes**  
Estudiante de Ingeniería de Software | Desarrollador Backend Java | Apasionado por el diseño orientado a objetos y la arquitectura de software.  
📍 Proyecto educativo-evolutivo documentado públicamente en GitHub.  
💼 [LinkedIn](https://www.linkedin.com/in/anderssonfuentes/)  
📦 [Repositorio del proyecto](https://github.com/AnderssonFuentes/tennis-portfolio)

---

## 🧾 Licencia

Este proyecto está bajo la **Licencia MIT**, lo que permite su uso, modificación y distribución con fines educativos y profesionales.

---

> 💬 *“Un buen diseño de software no se escribe, se modela primero.  
> Cada clase cuenta una historia dentro del dominio.”* — Inspirado en *Grady Booch*
EOF
