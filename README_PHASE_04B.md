# Phase 4B — Integración básica de estadísticas en Game

**Estado:** Implementado (rama: `phase/04b-estadisticas-game`)  
**Objetivo de la fase:** Conectar el modelo de estadísticas (Phase 4A) con el flujo real del juego, permitiendo que `Game` registre eventos estadísticos de forma simple y opcional (KISS).

---

## 🧭 Descripción

En Phase 4A se modelaron las estadísticas como parte del dominio (`TipoEstadistica`, `RegistroEstadisticas`).  
En esta fase (4B) se habilita una integración mínima con el partido:

- `Game` permite registrar un punto y opcionalmente registrar un evento estadístico asociado.
- El registro se delega al `Jugador` y su `RegistroEstadisticas`.

> Nota: en esta fase NO inferimos automáticamente eventos como "ace" o "error".  
> Solo se habilita el canal de registro (simple y controlado).

---

## ✅ Cambios realizados

- Se añade una sobrecarga en `Game`:
    - `registrarPunto(Participante p)`
    - `registrarPunto(Participante p, TipoEstadistica evento)`
- Si el participante es un `Jugador`, se registra el evento en `Jugador.getEstadisticas()`.

---

## 📦 Archivos modificados

- `src/main/java/com/tenis/dominio/Game.java`
- (opcional) `src/main/java/com/tenis/app/MainGameDemo.java` o demo nueva para mostrar registro

---

![UML Phase 4B](https://uml.planttext.com/plantuml/png/XLDBRjH04Dtx5AMiF0IF169beIW3c2WGcC61TLHZLvmIThVLtJCI0YHEa1LxJi0LiibDE057eBepux4dHl76zglNhrvz-jWwD6xLr95ZLnFy_NLz0uihj0JFNi2V7p_X11i2GnLRPn1eJSff2oJdojlVrd4XVx7bfgrf4aKj5f-n8ZWeT3DrfDXEIzsmOdq0NwC8WDIgWO_Swimhi1T0YO0yivTPU6TvFi_3ro8_VPVb5-Up3v-oY_dR-zZhsTdPxDLS0j-zE2wzoS91KQEri93IkE0MbQDDZWIKRfQ6KZXtXbKLm4EeoBqFU3pfHOBcdTIRLOMbDfqAxTpR5FAxzlHhiZlbFkhr_yFkPHjZR58VThCmiPCsfllDb0HhpULGC0nnwxrzaWvQiuMVZiAIhlOrdkRXmolj6rciP2VYTdXyv-DXxkFDNZrK30lNN691VJTTOwxmomagFwQu4ZmDLOl2KkkQK6rOUYbhIMQKkLT-o3bOekVVacIx2nBRRiKZGKUdAfnWCKcEziKxVDZO04-dH_VkI0gnRWlM2kj9dpUwAwcikUDBVsxDs3cMWev9bVww_mC0)
> 🧠 Reflexión:
Esta fase refuerza el diseño incremental: primero se modela el dominio (4A) y luego se conecta al flujo del juego (4B) sin acoplar reglas ni añadir complejidad innecesaria.

> 🚀 Próximo paso:
Enriquecer el registro para que ciertos eventos se registren de forma más natural durante el flujo real del partido (sin romper KISS).