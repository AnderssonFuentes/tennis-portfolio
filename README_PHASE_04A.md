# Phase 4A — Estadísticas (Domain Model)

**Estado:** Implementado (rama: `phase/04a-estadisticas`)  
**Objetivo de la fase:** Modelar el módulo de *Estadísticas* como parte del dominio, manteniendo el diseño simple (KISS) y orientado a objetos, siguiendo el enfoque de modelado de Grady Booch.

---

## 🧭 Contexto del dominio

En tenis, además del marcador, existen **eventos** que describen el rendimiento del jugador:
- **Aces**
- **Errores**
- **Primer saque (acertado / fallado)**

En esta fase, el sistema aprende a **registrar y representar** esos eventos sin afectar todavía la lógica de `Game`, `Set` o `TieBreak`.

---

## ✅ Qué se añadió en esta fase

- `TipoEstadistica` (enum): lenguaje del dominio para representar eventos estadísticos.
- `RegistroEstadisticas.registrar(TipoEstadistica)`: método unificado para registrar eventos sin usar strings.
- Demo en consola: `MainEstadisticasDemo` para verificar el comportamiento.

---

## 📦 Archivos incluidos

- `src/main/java/com/tenis/dominio/TipoEstadistica.java`
- `src/main/java/com/tenis/dominio/RegistroEstadisticas.java` *(se añade método `registrar(TipoEstadistica)` )*
- `src/main/java/com/tenis/app/MainEstadisticasDemo.java`

---

## 🧩 UML (Phase 4A — Estadísticas)

![UML Phase 4A](https://uml.planttext.com/plantuml/png/TLCxJiD04ErzYb4g1nHBI5GMGh68aO2460VgQ6EFp0fxr-okQG294r3HSm8gUfhSX1Dm1CPEdDZvkDdLUpFlpSoE-zemPOeijGmtASBVv_iF1FTC8nnxyFls0Jv5nFClRNZ4DDWZ6MCg8KOOo8mBBhkMbRFeWIK8dKXcZa71jHClo0uyMnO0YYA3MvxBIenNMiG0VTwPNvr-68x3wXQ45oC_d4wycpj_EhxQniwzuT0RZ8buBSNPJ1l58WDHohI6WFhX4S-PCBZqw86GsKoX2nEZk4Wgy10IDDSLRdSt6BrYseaKzoHvN3il32-BXCLIhRnmtQDs8SI4xghPkLxxDz6oYZtH3RTT4Ijh5Y5PSc7gKfIIgWtbYcUef9wmnmAr5w4Y7Ta8EGIri62AM7lTSeloI-LzP51vL0usMpguC9CoHIRsvDY6riFTN9ADWRVUzkIbrwk7Jrpz30U4xXoI2vqZi6b5Swb9PFujkXtAsndhEATR--f2ePb5TVHHnEKVymy0)
> Nota: uso composición (*--) porque el RegistroEstadisticas vive “dentro” del Jugador (si no existe el jugador, no tiene sentido ese registro).

---

## 🧠 Reflexión (aprendizaje)

Esta fase consolida el dominio con un lenguaje explícito de eventos (`TipoEstadistica`) y mantiene la responsabilidad donde corresponde (**GRASP – Information Expert**):  
`RegistroEstadisticas` es quien sabe cómo contar y representar las estadísticas.

Siguiendo el enfoque de *Grady Booch*, el dominio se modela primero con claridad, y luego se integra de forma incremental con el resto del sistema.

---

## 🚀 Próximo paso

Integrar estas estadísticas con la ejecución real del partido (por ejemplo, registrar `ACE` o `ERROR` desde `Game`) manteniendo el diseño simple y con bajo acoplamiento.

