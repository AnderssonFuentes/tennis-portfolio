# Phase 05A — Partido (Orquestación mínima)

**Estado:** Implementado  
**Rama:** `phase/05a-partido`  
**Enfoque:** Programación Orientada a Objetos · UML · KISS  
**Referencia conceptual:** Grady Booch — *Análisis y Diseño Orientado a Objetos con Aplicaciones*

---

## 🎯 Objetivo de la fase

Introducir la clase **`Partido`** como **orquestador principal del dominio**, conectando los elementos ya existentes (`Set`, `Game`, `TieBreak`) sin agregar lógica de reglas ni cálculos adicionales.

En esta fase, `Partido` **coordina**, pero **no decide**.

---

## 🧠 Contexto de diseño

Hasta las fases anteriores, el proyecto modelaba correctamente:

- Puntos → `Game`
- Games → `Set`
- Desempate → `TieBreak`
- Reglas → `IReglas*`

Sin embargo, faltaba una entidad que representara el **evento real del tenis**:  
el **Partido**, entendido como una **composición de Sets** y no como una unidad de juego.

Siguiendo el enfoque de Booch:
> *Un objeto debe representar un concepto real del dominio y asumir una responsabilidad clara.*

---

## 🧩 Rol de la clase `Partido`

`Partido` cumple el rol de **coordinador**:

- Mantiene referencia a los participantes
- Mantiene una colección de `Set`
- Consulta a los `Set` para determinar:
    - si hay ganador
    - quién es el ganador

📌 **No realiza**:
- conteo de puntos
- aplicación de reglas
- lógica de tie-break

Toda esa responsabilidad permanece encapsulada en las clases especializadas.

---

## 📐 UML — Phase 05A
![UML Phase 4B](https://uml.planttext.com/plantuml/png/dPAnJiCm48PtFyMfKmAab4ei5ghAn8949PxWcfnIIuaTx2iIGaWy0HCxJy34pj8tuGbu12ukAMbWOlFTz_l_JsVF0wFdTLqfDbmHVBuylSDYXO5WSdeE7u_Fi121AHmaL_vcJQBFpURDGhrvjQR6LAcymX1sidi5a47JLhbfq3ATw2tyBd_nwHyy40SDboRmsJNnJ7g7NKBI30oFe1bOf55lhDJearJ3hJD5x67fgKGldeb4Q9137w_mxW8j5YxUMZfN4Tf8Ik8U6SmRiLY5blqC_Q0KBWDxp1bwI-hkRLkYZ3lxPxXaT9lFijaU0xt_3CVJdTIrsj5aF3uOnG5qNBXISx95-nc-0000)

---

## 🔄 Comunicación entre objetos (resumen)

Durante la ejecución de `MainPartidoDemo` ocurre el siguiente flujo:

1. El cliente crea `Partido`
2. El cliente crea y resuelve un `Set`
3. El `Set` decide internamente su ganador (por games o *tie-break*)
4. El `Set` se agrega al `Partido`
5. `Partido` consulta:
    - `set.hayGanador()`
    - `set.getGanador()`

Esto refuerza:

- Bajo acoplamiento
- Delegación de responsabilidades
- Comunicación clara entre objetos

---

## 📦 Archivos incluidos en esta fase

- `src/main/java/com/tenis/dominio/Partido.java`
- `src/main/java/com/tenis/app/MainPartidoDemo.java`
- `README_PHASE_05A.md`

---

## 🧠 Aprendizajes clave

- Separación clara entre orquestación y lógica de dominio
- Uso de composición para modelar conceptos reales
- Comunicación entre objetos mediante mensajes simples
- El UML cobra sentido cuando se refleja en el flujo real del código

Esta fase consolida el entendimiento de cómo los objetos colaboran dentro de un sistema orientado a objetos.

---

## 🚀 Próximo paso

Extender el modelo del `Partido` para manejar múltiples sets (ej. *mejor de 3*) y preparar el terreno para integrar **Marcador** y **Árbitro** en fases posteriores.
