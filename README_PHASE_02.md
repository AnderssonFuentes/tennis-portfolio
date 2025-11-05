# 🎾 Fase 02 — Implementación del **Game** y Lógica de Reglas Clásicas

> Proyecto: **Sistema de Partido de Tenis**  
> Enfoque: *Análisis y Diseño Orientado a Objetos con Aplicaciones* — **Grady Booch**  
> Fase: 02

---

## 📘 Contexto del Dominio

El **dominio del tenis** es un sistema regido por reglas bien definidas: cada punto, juego, set y partido siguen una jerarquía estructurada.  
En esta fase, nos enfocamos en el **microcomportamiento** del sistema: el **Game**, la unidad mínima de puntuación dentro de un set.

Desde el enfoque de **Grady Booch**, esta etapa representa el paso de la *abstracción conceptual (modelo del dominio)* hacia la *abstracción de diseño*; es decir, cuando las clases comienzan a asumir **responsabilidad, colaboración y estructura** en el sistema orientado a objetos.

---

## 🧩 Objetivo de la Fase 2

Implementar la **clase `Game`** y el conjunto de **reglas asociadas**, garantizando:
- Bajo acoplamiento y alta cohesión.
- Delegación de la lógica de puntuación a una interfaz de reglas (`IReglasGame`).
- Uso de composición para representar la flexibilidad de las reglas (principio: *“preferir composición sobre herencia”*).

---

## 🧱 Clases Implementadas

| Clase | Tipo | Responsabilidad Principal |
|-------|------|-----------------------------|
| `IReglasGame` | Interfaz | Define el contrato para la lógica de puntuación de un Game. |
| `ReglasClasicasGame` | Implementación de `IReglasGame` | Contiene la lógica de puntuación tradicional del tenis (0, 15, 30, 40, ventaja, game). |
| `Game` | Clase de dominio | Gestiona el estado del juego (puntos por jugador, ganador) y delega en las reglas. |
| `MainGameDemo` | Clase de prueba | Simula un juego entre dos jugadores para validar la interacción de las clases. |

---

## 🧠 Diagrama UML — Fase 2

![Diagrama UML](https://uml.planttext.com/plantuml/png/pPBBQiCm44M_OFvXbWc90_6wX43JX1GCfLsMBYRsH5NGmqXoeQz_h-Gu8NRQVHSoykZewWpIqWToeT4A8CYW6Ezq7Tvn9KauqfZXcZpd04isLQIMP_n8frNC8rROYfN5-C7xXeN5qOOqZm6a2UpsL39k7raeygcEdp1vix92tsXo3uq9TlGKd3G23usWohenJBg2tGKst49qu6jiPwrYClXAQsb8oOzO7rrjtv19V5pu1YYZXiUZpcqSikoqfAuLQpR13sopWkgRO-8Kjx4bmMw1THBt_w2La-Mbj6kdaFLFcGyBEKmIVfQPJ_4qpQTu7JZksatR_sgt1RJrmP4ho9L3tOAaIP4hrZOz1Ht_kvJd5oGdV0ktfsRPuj82VhcrsUohp_JoKq1RxPxm3m00)

---

| Principio                      | Aplicación                                                                                                                                                            |
| ------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Composición sobre herencia** | `Game` delega el comportamiento de las reglas a `IReglasGame`, lo que permite cambiar dinámicamente el tipo de reglas (por ejemplo, tie-break, reglas rápidas, etc.). |
| **Abierto / Cerrado (SOLID)**  | Se pueden agregar nuevas reglas implementando la interfaz `IReglasGame` sin modificar el código existente.                                                            |
| **Alta cohesión**              | Cada clase tiene una única responsabilidad clara.                                                                                                                     |
| **Bajo acoplamiento**          | Las clases dependen de abstracciones, no de implementaciones concretas.                                                                                               |

---
🚀 Próximos pasos

🔹 Fase 03 — Implementación del Set y TieBreak

En la siguiente fase avanzaremos hacia la estructura del partido, conectando múltiples Games dentro de un Set y gestionando la transición entre juegos.
También se incluirá el manejo de TieBreaks, validaciones de ganadores de set y la integración con las clases base Participante y RegistroEstadísticas.

📚 Referencias

Grady Booch — Análisis y Diseño Orientado a Objetos con Aplicaciones, 3.ª ed.

UML 2.5 Specification, Object Management Group (OMG).

Documentación oficial de Oracle Java 17.

💡 Nota del autor:
Este proyecto se desarrolla como parte de un proceso de consolidación de fundamentos en modelado orientado a objetos y diseño de software, siguiendo un enfoque incremental (por fases) y manteniendo la trazabilidad entre el modelo UML y la implementación en código.