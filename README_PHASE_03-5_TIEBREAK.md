# Phase 03.5 — TieBreak (Integración en Set)

**Estado:** Implementado (rama: `phase/03-5-tiebreak`)  
**Objetivo de la fase:** Añadir la lógica del *TieBreak* y su integración con `Set`, manteniendo el diseño orientado a objetos, bajo acoplamiento y KISS.

---

## 🧭 Descripción general

En esta fase hemos añadido:

- `TieBreak` (dominio): almacenamiento y conteo de puntos del tie-break.
- `IReglasTieBreak` (interfaz): contrato para definir el ganador del tie-break.
- `ReglasClasicasTieBreak` (implementación): reglas clásicas (ganar con ≥7 y diferencia ≥2).
- Integración en `Set`: `Set` detecta 6–6, crea `TieBreak`, delega el registro de puntos y consulta al tie-break para determinar el ganador final del set.
- Ejemplo ejecutable: `MainSetDemo` con una simulación simple 6–6 → tie-break 7–5.

---

## 📦 Archivos claves añadidos o modificados

- `src/main/java/com/tenis/dominio/TieBreak.java`
- `src/main/java/com/tenis/reglas/IReglasTieBreak.java`
- `src/main/java/com/tenis/reglas/ReglasClasicasTieBreak.java`
- `src/main/java/com/tenis/dominio/Set.java` (modificado para soportar tie-break)
- `src/main/java/com/tenis/app/MainSetDemo.java` (demo de la fase)

---

## 🧩 Relación entre clases (vista conceptual)

- El tie-break amplía el comportamiento del set sin romper su diseño principal:

- Set decide cuándo usar TieBreak.

- TieBreak decide cómo se juega el desempate.

- ReglasClasicasTieBreak decide quién gana según las reglas oficiales.

- La lógica está desacoplada, es extensible y sigue los principios de Booch.

> Esto permite agregar en el futuro variantes como:
• tie-break largo a 10 puntos
• super tie-break
• reglas ATP/ITF específicas
sin modificar el núcleo del Set.

## 🔍 Diagrama (fase 3.5)

![UML fase 1-3 full diagram](https://uml.planttext.com/plantuml/png/nLF1JeD04BtlLypDDaeJDLvCRKeR96XhICl5umWZ4YcGPNimQk8NUFBkd_WnVe6VuEvsMvQKcmT9c8Gtyzw-cLd6jK0krgkSYKpa13-VxrzmYJN1wU0Cljy-O5ucb9UG44GPJJZX8sC7S24V2Dr554o3qBs9lAM6M9nZNKCeDRCugx0GPA2hTOf9oHcpSp1ySPmcPMHzT-x1BKI1DrbuxhKjxEEAu9a1EAqpe3hkm4uqDiTgQED74CYO4Xz1jIv4MSkgG-2KPhNWo4E5zMn2NnSyu9EFXVBPwv_3NLdcX8NEf2IiJAlrLsPyRqTdlF-pfvqRntaPwPdkPh_m_9bhTfd9SdwFCK6me5JseIltqEPQR7hTe5FvPh7XT2KQsZu11WDfp3wrczkgQmIrXEEq5QocEoYc_QKNsTTjIS9iR2OtCLGw8qXbh3MuanHR7JLxJENYaAlYdWf_svMoe1ph7hOVZUyn5OdwUty1)

> Nota: la imagen es la representación general del modelo; el TieBreak es la extensión que se conecta a `Set` como movimiento un especial para llegar al desempate.

---

## 🧠 Reflexión de la fase

- Esta fase reforzó varios principios fundamentales del diseño orientado a objetos:

- El dominio real dicta la estructura del software.
El tie-break no es un condicional dentro del set, sino una entidad completa con identidad propia.

- Las reglas pertenecen a objetos, no a condicionales.
ReglasClasicasTieBreak encapsula las reglas del dominio y permite variantes sin modificar el modelo.

- El diseño crece por extensión, no por modificación.
El set no pierde claridad; simplemente incorpora un colaborador especializado.

> Con esta fase, el modelo del partido es mucho más fiel al tenis real y queda listo para evolucionar hacia funcionalidades más avanzadas (estadísticas completas, partidos dobles, sets con variantes, etc.).

---