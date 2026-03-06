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

---

## ✅ Micro-avance #7 (06A #7) — Rotación de saque por game

### 🎯 Objetivo
Implementar una regla real del tenis:

> **Cuando se crea un nuevo Game dentro de un Set, el servidor alterna respecto al Game anterior.**

Esto significa que el Set no solo contiene games, sino que **orquesta** su creación aplicando reglas del dominio.

---

## 🧠 Regla del dominio (Tenis real)

- El saque **no cambia punto a punto**.
- El saque cambia **game a game**.
- Esta regla depende del **orden de los games** dentro del set.

✅ Por eso esta regla pertenece a `Set`, no a `Game`, no al marcador.

---

## 🧩 Diseño OO (responsabilidades)

### `Game`
Responsable de:
- representar un game individual
- conocer su servidor (`getServidor()`)

### `Set`
Responsable de:
- administrar la secuencia de games
- aplicar la regla: **alternar servidor en cada nuevo game**
- crear games de forma controlada (para garantizar la regla)

---

## 🔧 Implementación (cambio mínimo y KISS)

### Problema inicial
En la versión anterior, los `Game` se creaban por fuera y luego se agregaban con `set.agregarGame(game)`.

Eso hace difícil garantizar la regla de alternancia, porque `Set` no controla la creación.

### Solución aplicada
Se añadieron métodos “fábrica” en `Set` para crear los games desde el set:

- `crearPrimerGame(IReglasGame reglasGame, Participante servidorInicial)`
  - Crea el primer game con servidor explícito.
  - Evita iniciar si ya hay games.

- `crearSiguienteGame(IReglasGame reglasGame)`
  - Crea el siguiente game alternando automáticamente el servidor.

- `calcularServidorSiguienteGame()`
  - Regla KISS de alternancia:
    - si el servidor anterior fue `participante1` → ahora sirve `participante2`
    - si fue `participante2` → ahora sirve `participante1`

### Validaciones añadidas (mínimas)
- Validar que el set tenga participantes conocidos (`participante1` y `participante2`)
- Validar que el servidor inicial sea uno de los participantes

---

## 🔄 Comunicación entre objetos (modelo)

Cuando se pide crear un game:

1. `Set` revisa si existen games previos.
2. Si es el primer game:
  - usa el servidor inicial explícito.
3. Si no es el primero:
  - toma el servidor del último game (`ultimo.getServidor()`).
  - calcula el opuesto.
4. `Set` crea el nuevo `Game(...)`.
5. `Set` lo agrega usando `agregarGame(g)`.

✅ La vista/console solo imprime lo que ya está resuelto en el modelo.

---

## 🧪 Demo de verificación

Se creó el demo:

- `MainRotacionSaqueDemo`

### Escenario
- `p1 = Nadal`
- `p2 = Federer`
- `primer servidor = Nadal`

Se crean 4 games consecutivos desde el set:

- Game 1: Nadal
- Game 2: Federer
- Game 3: Nadal
- Game 4: Federer

### Output esperado

Game 1 servidor: Nadal
Game 2 servidor: Federer
Game 3 servidor: Nadal
Game 4 servidor: Federer


> Nota KISS: en el demo se imprime el nombre con cast a `Jugador`:
> `((Jugador) g.getServidor()).getNombre()`
> Esto se mantiene simple para singles. Más adelante se mejorará para soportar `Equipo` de forma polimórfica.

---

## ✅ Resultado del micro #7
Con este micro avance:

- El `Set` se convierte en el **orquestador** real de la secuencia de games.
- La regla del dominio (alternancia del saque) queda en el lugar correcto.
- El marcador puede mostrar el servidor sin introducir lógica.

---

## 📌 Archivos involucrados

### Modificados
- `src/main/java/com/tenis/dominio/Set.java`
  - se agregaron métodos para crear games y alternar servidor

### Nuevos
- `src/main/java/com/tenis/app/MainRotacionSaqueDemo.java`
  - demo para validar rotación de saque

---

## ✅ Checklist final (micro #7)

- [x] `Game` conoce su servidor (micro #6)
- [x] `Set` crea games y alterna servidor automáticamente
- [x] demo de consola valida alternancia real del tenis

---

## 🧭 Próximo paso (cuando toque, sin prisa)

Una vez cerrado este micro, el siguiente paso natural sería:

- Mostrar automáticamente en el marcador quién sirve en el game actual.

Pero eso se hará **sin meter lógica al marcador**: el marcador solo consulta al modelo.

---