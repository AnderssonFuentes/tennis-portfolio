# Phase 06A — Marcador (KISS) · Micro-avance #1

**Estado:** Implementado  
**Rama:** `phase/06a-marcador`  
**Enfoque:** POO básica + UML + KISS (sin patrones avanzados)  
**Referencia conceptual:** Grady Booch — *Análisis y Diseño Orientado a Objetos con Aplicaciones*

---

## 🎯 Objetivo de esta fase

Agregar un **Marcador** simple al sistema (scoreboard por consola) que permita **visualizar el estado del partido** sin alterar la lógica del dominio.

Este micro-avance introduce la capa mínima de “presentación” (en consola), manteniendo la separación de responsabilidades:

- El **dominio** decide (Partido / Set / Game / TieBreak).
- El **marcador** muestra (consulta y presenta información).

---

## 🧭 ¿Qué se implementó en el micro-avance #1?

### ✅ Nuevos elementos

- `IMarcador` (interfaz): contrato mínimo para iniciar el marcador y mostrar el estado.
- `MarcadorClasico` (implementación): salida por consola, simple y KISS.

### ✅ Integración mínima

- `Partido` puede asociar un marcador (`setMarcador/getMarcador`) sin depender de una implementación concreta.
- `MainPartidoDemo` invoca al marcador en momentos clave para imprimir el estado del partido.

---

## 🧩 Responsabilidades (POO real)

### `Partido` (dominio)
- Orquesta el partido.
- Conoce la regla de Best-of-3 (`setsParaGanar`).
- Determina si hay ganador y quién es el ganador.
- Protege invariantes (por ejemplo: no aceptar más sets cuando ya terminó).

### `IMarcador` / `MarcadorClasico` (presentación por consola)
- **No modifica** el dominio.
- Solo pregunta y muestra:
    - sets jugados
    - si hay ganador del partido
    - ganador si existe

Esto mantiene bajo acoplamiento: el `Partido` depende de la abstracción (`IMarcador`), no del marcador concreto.

---

## 🔄 Comunicación entre objetos (flujo de mensajes)

Cuando se ejecuta:

```java
marcador.mostrarEstado(partido);

```

#### ocurre lo siguiente:

- MarcadorClasico recibe el objeto Partido.

- Consulta (solo lectura):

- partido.getSets().size()

- partido.hayGanador()

- partido.getGanador() (si aplica)

- Imprime el estado por consola.

📌 Importante:
El marcador no calcula el ganador, solo lo consulta.

---
## 📐 UML (Phase 06A · Micro #1)
![Phase 06A — Marcador (KISS)](https://uml.planttext.com/plantuml/svg/hPB1IWCn48RlUOevxbAsUF8GIgb8aQ92OPzWJA8To6QM91L41H_29_H9pCPc6thsbim_Czy_cMn2H1-FWnMHeZMmFs0mS7Lz0pzVt_28Ng5c3ytzhkzR8SX5uvzH6TZDshi0M00vKeI-H9jMmYkJpjh08NhqsyJIt8m9I9ebxFyE9VDJ26KnX9bwcswa-Fy1ftXkt44mCKXue11NlOdh71jE57cUCuDIxcnWgCJQp4kLqrusI6A2X4ceYGiuuDiTkbBqn6mDkb9IATcxeX7J9gQ9pdjOVIoNbsydogXTjwvM9k4O41eU5R53sugDSNhw1By0)

---

## ✅ Qué se aprendió en este micro-avance

- Separación básica de responsabilidades (dominio vs presentación).

- Bajo acoplamiento usando una interfaz (IMarcador).

- Comunicación entre objetos por mensajes (consultas, no inspección interna).

- Evolución incremental del modelo UML hacia un sistema más completo.

---

## ✅ Micro-avance #2 — Score por sets en el marcador

Se enriqueció `MarcadorClasico` para mostrar el estado “macro” del partido:

- sets jugados
- sets ganados por cada participante
- ganador del partido (si aplica)

El marcador sigue siendo **solo lectura**: consulta a `Partido` y presenta información sin modificar el dominio.

---

---

## ✅ Micro-avance #3 — Estado del set actual + TieBreak (solo lectura)

En este micro-avance se extendió `MarcadorClasico` para mostrar información del **momento actual** del partido, además del score macro por sets.

### 📌 ¿Qué se muestra ahora?

- **Set actual** (último set agregado al partido)
- **Games jugados** en el set actual
- **TieBreak activo** (sí/no)
- Si hay tie-break: **puntos del tie-break** por cada participante

### 🔄 Comunicación entre objetos (flujo de mensajes)

Cuando se ejecuta:

```java
marcador.mostrarEstado(partido);
```

ocurre lo siguiente:

1. MarcadorClasico consulta al Partido (solo lectura):

- partido.getSets()
- partido.getParticipante1() / partido.getParticipante2()

2. Identifica el set actual:

 - setActual = sets.get(sets.size() - 1)

3. Consulta al Set:

- setActual.getGames().size()

- setActual.getTieBreak()

4. Si existe tie-break, consulta al TieBreak:

- tb.puntosDe(p1)

- tb.puntosDe(p2)

📌 Importante: el marcador no modifica el dominio. Solo consulta y muestra información.

✅ Con esto, el marcador ofrece contexto del set actual manteniendo el enfoque KISS y separación de responsabilidades.

---
---

## ✅ Micro-avance #4 — Score del set actual por games ganados

Se extendió `MarcadorClasico` para mostrar el **score del set actual** contado por games ganados:

- Se recorren los `Game` del set actual (`setActual.getGames()`).
- Solo se cuentan games terminados (`game.hayGanador()`).
- Se obtiene el ganador de cada game (`game.getGanador()`) y se acumula el conteo por participante.

El marcador sigue siendo **solo lectura**: consulta a `Partido → Set → Game` y presenta información sin modificar el dominio.

---
## ✅ Micro-avance #5 — Game score del game actual (solo lectura)

- Se extendió `MarcadorClasico` para mostrar el puntaje del game actual en el set actual:

- Se obtiene el set actual (`Partido → Set`).

- Se toma el game actual como el último game agregado (`setActual.getGames()`).

- Si el game ya terminó, se muestra el ganador.

- Si el game está en curso, el marcador consulta el puntaje con `gameActual.puntajePara(p)` y lo presenta (ej:`15 - 30`).

El marcador se mantiene como solo lectura: no modifica reglas ni estado del dominio.

---
## ✅ Micro-avance #6 — Servidor del game actual (solo lectura)

Se añadió el concepto de **servidor** al `Game para poder mostrar en el marcador quién está sacando en el game actual.

- `Game` ahora recibe servidor en su constructor y expone `getServidor()`.

- `MarcadorClasico` muestra `Servidor (game actual)` consultando el último game del set actual.

- El marcador se mantiene como **solo lectura**: no modifica reglas ni estado del dominio.