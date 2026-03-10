
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

---

# Micro-avance 06A #8 — Servidor del `Game` actual visible en el marcador

## Contexto

Dentro de la fase `06A — Marcador`, este micro-avance tuvo como propósito hacer visible en el `MarcadorClasico` quién es el servidor del `Game` actual, manteniendo una regla de diseño muy importante:

> El marcador no debe contener lógica de negocio del saque; solo debe consultar el modelo y mostrar el estado actual.

Este ajuste parece pequeño a nivel visual, pero es relevante desde el punto de vista del diseño orientado a objetos, porque refuerza la separación de responsabilidades entre el dominio y la vista.

---

## Objetivo

Lograr que el marcador muestre una salida como esta:

```text
Sirve: Roger Federer
Puntaje: 15 - 30
```

sin calcular el saque desde el marcador y sin introducir reglas nuevas dentro de la vista.

---

## Intención de diseño

La idea principal de este micro-avance fue que el `MarcadorClasico` deje de “navegar” manualmente la estructura interna del partido para averiguar quién sirve y, en cambio, consulte al modelo de forma más limpia.

La comunicación esperada entre objetos queda así:

```text
MarcadorClasico -> Partido -> Game actual -> servidor
```

Más detalladamente:

```text
MarcadorClasico -> Partido.getGameActual()
MarcadorClasico -> Game.getServidor()
MarcadorClasico -> imprime "Sirve: X"
```

Este enfoque mantiene el sistema alineado con un diseño KISS y con una distribución sana de responsabilidades.

---

## Estado previo del sistema

Antes de este micro-avance, el sistema ya contaba con varias piezas importantes:

- `Game` ya tenía un atributo `servidor`.
- `Game` ya validaba que el servidor no fuera nulo y que perteneciera a los participantes del game.
- `Game` ya exponía el método `getServidor()`.
- `MarcadorClasico` ya mostraba información del partido, del set actual, del game actual y del tie-break.
- `Partido` ya contenía una lista de sets.
- `Set` ya contenía una lista de games.

Es decir, el dato ya existía bien ubicado en el dominio.  
Lo que faltaba era pulir la forma en que el marcador llegaba a ese dato.

---

## Problema detectado

Aunque el marcador ya podía llegar al servidor del game actual, lo hacía navegando manualmente la estructura interna del modelo.

Conceptualmente, el acceso era así:

```text
partido.getSets() -> último set -> getGames() -> último game -> getServidor()
```

Esto funcionaba, pero generaba dos detalles mejorables:

1. El marcador conocía demasiado sobre la estructura interna de `Partido` y `Set`.
2. La intención del código no estaba tan expresiva como podía estarlo.

En otras palabras, el código era funcional, pero podía quedar mejor encapsulado.

---

## Solución aplicada

Se decidió mejorar el acceso al estado actual del dominio agregando métodos más expresivos en el modelo, de manera que el marcador preguntara directamente por el `Set` actual y por el `Game` actual.

Con esto, el flujo pasó a ser:

```text
partido.getSetActual()
partido.getGameActual()
gameActual.getServidor()
```

De esa manera, el marcador sigue siendo una vista de solo lectura, pero ahora con menos acoplamiento estructural.

---

## Archivos modificados

### 1. `src/main/java/com/tenis/dominio/Set.java`

Se agregó un método para exponer de manera explícita el `Game` actual del set.

### Método agregado

```java
public Game getGameActual() {
    if (games.isEmpty()) {
        return null;
    }
    return games.get(games.size() - 1);
}
```

### Responsabilidad del cambio

`Set` es quien conoce su colección de `Game`.  
Por lo tanto, es el lugar natural para responder cuál es el game actual.

---

### 2. `src/main/java/com/tenis/dominio/Partido.java`

Se agregaron dos métodos de acceso al estado actual:

```java
public Set getSetActual() {
    if (sets.isEmpty()) {
        return null;
    }
    return sets.get(sets.size() - 1);
}

public Game getGameActual() {
    Set setActual = getSetActual();
    if (setActual == null) {
        return null;
    }
    return setActual.getGameActual();
}
```

### Responsabilidad del cambio

`Partido` actúa como coordinador del estado general del encuentro.  
No calcula quién sirve ni decide reglas del game; solo ofrece un acceso ordenado al estado actual del dominio.

Esto permite que otras partes del sistema, como el marcador, consulten la información sin depender de detalles internos innecesarios.

---

### 3. `src/main/java/com/tenis/marcador/MarcadorClasico.java`

Se refactorizó la obtención del set y del game actual para que el marcador consulte al `Partido` de forma directa, en lugar de navegar manualmente listas internas.

Además, se ajustó la salida visible para que el texto del score en curso sea más natural:

- Antes: `Game actual: 15 - 30`
- Después: `Puntaje: 15 - 30`

Y se consolidó la línea:

```text
Sirve: Roger Federer
```

### Comportamiento actual del marcador

- Si el game actual está en curso, muestra:
   - `Sirve: X`
   - `Puntaje: X - Y`

- Si el game actual ya terminó, muestra:
   - `Sirve: X`
   - `Game actual: TERMINADO (ganó X)`

- Si todavía no hay sets cargados en el partido, muestra:
   - `[Set actual]`
   - `Aún no hay sets agregados al partido.`

---

## Archivo revisado pero no modificado conceptualmente

### `src/main/java/com/tenis/dominio/Game.java`

No fue necesario rediseñar esta clase porque ya estaba correctamente preparada para este micro-avance.

La clase ya contenía:

- el atributo `servidor`,
- su validación en el constructor,
- y el método `getServidor()`.

Esto confirmó que la decisión previa de modelado fue correcta:

> El servidor pertenece al `Game`.

---

## Cambios funcionales logrados

Con este micro-avance, el sistema quedó capaz de mostrar en el marcador el servidor del game actual sin introducir lógica de saque dentro de la vista.

### Ejemplo de salida — game en curso

```text
Sirve: Roger Federer
Puntaje: 15 - 30
```

### Ejemplo de salida — game terminado

```text
Sirve: Roger Federer
Game actual: TERMINADO (ganó Rafael Nadal)
```

### Ejemplo de salida — partido sin sets aún

```text
[Set actual]
Aún no hay sets agregados al partido.
```

---

## Validación realizada

La validación del micro-avance se hizo con dos demos del proyecto.

---

### Demo 1 — `MainRotacionSaqueDemo`

Salida observada:

```text
Game 1 servidor: Nadal
Game 2 servidor: Federer
Game 3 servidor: Nadal
Game 4 servidor: Federer
```

### Qué valida esta salida

Esta salida confirma que:

- cada `Game` mantiene correctamente su servidor,
- la alternancia de saque entre games está reflejada en el modelo,
- el dato del servidor está persistiendo donde corresponde,
- la rotación no depende del marcador.

---

### Demo 2 — `MainPartidoDemo`

Salida observada, entre otras líneas:

```text
Sirve: Roger Federer
Puntaje: 15 - 30
```

Y también:

```text
Sirve: Roger Federer
Game actual: TERMINADO (ganó Rafael Nadal)
```

### Qué valida esta salida

Esta salida confirma que:

- el marcador consulta correctamente el game actual,
- el marcador obtiene desde el modelo quién es el servidor,
- el marcador muestra el estado en curso del game con una etiqueta más clara (`Puntaje`),
- el marcador sigue funcionando también cuando el game ya terminó.

---

## Comunicación entre objetos

Este micro-avance refuerza una comunicación entre objetos más limpia y más expresiva.

### Antes

```text
MarcadorClasico
  -> partido.getSets()
  -> último Set
  -> set.getGames()
  -> último Game
  -> game.getServidor()
```

### Después

```text
MarcadorClasico
  -> partido.getGameActual()
  -> game.getServidor()
```

Y, cuando se requiere el set actual:

```text
MarcadorClasico
  -> partido.getSetActual()
```

La diferencia es importante porque reduce el conocimiento estructural que tiene el marcador sobre el dominio.

---

## Beneficios del cambio

### 1. Mejor encapsulación

El marcador deja de depender de cómo están almacenados los sets y los games internamente.

### 2. Mejor legibilidad

Las llamadas `getSetActual()` y `getGameActual()` expresan mucho mejor la intención del código.

### 3. Responsabilidades más claras

- `Game` sabe quién sirve.
- `Set` sabe cuál es su game actual.
- `Partido` sabe cuál es su set actual y cuál es su game actual.
- `MarcadorClasico` solo consulta y muestra.

### 4. Mejor base para evolución futura

Este cambio deja preparado el sistema para próximos micro-avances relacionados con la vista del marcador, por ejemplo:

- mostrar quién recibe,
- mostrar más detalles del game actual,
- enriquecer la vista sin romper el principio de solo lectura.

---

## Qué no se hizo en este micro-avance

Para mantener el alcance controlado y pequeño, este micro-avance no incluyó:

- nuevas reglas de rotación del saque,
- lógica del receptor,
- lógica especial de servidor en tie-break,
- cambios en estadísticas,
- cambios en reglas de set o partido,
- rediseños grandes del dominio.

El foco estuvo únicamente en hacer visible el servidor del `Game` actual desde el marcador y mejorar la forma de acceso a ese estado.

---

## Resumen técnico

Este micro-avance consolidó una mejora pequeña, pero valiosa, en la fase del marcador:

- el servidor siguió perteneciendo al `Game`,
- el `Partido` pasó a exponer mejor el estado actual del dominio,
- el `Set` pasó a exponer explícitamente su `Game` actual,
- y el `MarcadorClasico` muestra `Sirve: X` y `Puntaje: X - Y` de forma más limpia y más alineada con OOAD.

Desde la perspectiva del diseño, el resultado principal fue reforzar algo simple pero importante:

> el marcador no decide el saque; el marcador solo lo consulta y lo muestra.

---

## Rama de trabajo

```text
micro/06a-08-servidor-visible
```

---

## Commit del micro-avance

Commit funcional del cambio:

```bash
git commit -m "feat(marcador): mostrar servidor y puntaje del game actual"
```

Commit documental del README:

```bash
git commit -m "docs(marcador): documentar micro-avance 06A #8"
```

---

## Próximo paso natural

A partir de este punto, un siguiente micro-avance coherente podría ser:

- mostrar también quién recibe en el game actual,
- o seguir enriqueciendo el marcador con más información de solo lectura, sin mover reglas del dominio hacia la vista.