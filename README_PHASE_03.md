# 🎾 FASE 03 — Implementación del Set
📂 Proyecto: **Sistema de Partido de Tenis (Modelado UML + Java)**  
📘 Enfoque: *Análisis y Diseño Orientado a Objetos con Aplicaciones* — **Grady Booch**

---

## 🧩 CONTEXTO DEL DOMINIO

En esta tercera fase, el proyecto evoluciona hacia un nivel superior del modelo del partido: el **Set**.  
En el tenis, un *Set* representa una colección de *Games* (juegos) y constituye la unidad que define el avance del jugador hacia la victoria final del partido.

Siguiendo el enfoque de *Grady Booch*, se busca capturar la **estructura y comportamiento** de este elemento del dominio, manteniendo los principios de **bajo acoplamiento**, **alta cohesión** y **claridad conceptual**.

---

## 🧱 ELEMENTOS DEL MODELO UML

En esta fase, el diseño UML introduce nuevas clases que amplían la arquitectura general del sistema:

- **`Set`**  
  Clase principal que representa una colección de *Games*.  
  Gestiona la secuencia de juegos, lleva el conteo de victorias por jugador y determina cuándo un set ha sido ganado.

- **`IReglasSet` (Interfaz)**  
  Define las operaciones para determinar el ganador del set y validar si debe jugarse un *tie-break*.

- **`ReglasClasicasSet`**  
  Implementa las reglas tradicionales del tenis: un jugador gana el set al obtener 6 juegos con una ventaja mínima de 2.  
  Si el marcador llega a 6–6, se activa el *tie-break*.

- **`MainSetDemo`**  
  Clase de demostración que permite probar en consola la lógica implementada del *Set* bajo las reglas clásicas.

---

## 📊 DIAGRAMA UML — FASE 03

![Fase 3 - Set](https://uml.planttext.com/plantuml/png/nLJDJjmm4BxdAKPS6bHsXTJRQhi2KK2BYe12JrKFiydKk8r_P3j8g4NY8VecF09lmfDqxD2jiqkZQY-r54VnDvyzCz_dxFc0BhIgAO8C3S4HUeBTD_1q_nFcoZQaI0UivEE3XfeQkAJ0RxWYBNrHl8AtmuCZplSlFXvU7KwWCceS8c_iI3Je_u5TMAo-eI3OMYLlmVS2U4WTo7t1Yc3-8G4nmGwAupKiZ6a8DLpZxJ5gh8qhtqiVfiUeQ0Q2Px-TXPzpDsGbBVA-O1Py9BbXtbsHNXMVxQ7BuO0VMVs7NE8OmIdQQSxTWJdFWjoCDM0rNUJvRYS_k1Dt5spBbAzqPercAr3Poyhk39scq6AlIPb6qn_ZyNgxYhkDJLKR9RKq6xhgcVtRLfsQVVr6iDgg3CegUtRt7nrviLp3Sw5lZAm11GETDcMSqX7Rm-xvgri4XPTYyW9Y1DTGlk3Y26IV-SvHe5Z4Q3JBQvv0wt49fFGdoMoIJRjSxwKuYPQEC1UQCjrOURHsGzMPsLVy5ANcRD-HChsRcnHI39QNmKajFdq6T6Bv1-2cvCnOQzULoX72BLZNqWBNOavQaGfVNL-_5iCHIQzYZtGTV-I_0000)
---

## ⚙️ DETALLES TÉCNICOS

- **Lenguaje:** Java 21
- **Paradigma:** Programación Orientada a Objetos (POO)
- **Principios aplicados:**
    - Encapsulamiento
    - Composición (un Set está compuesto por varios Games)
    - Uso de Interfaces para desacoplar las reglas del dominio
- **IDE:** IntelliJ IDEA
- **Gestor de dependencias:** Maven
- **Control de versiones:** Git y GitHub
- **Modelado:** PlantUML

---

## 💡 REFLEXIÓN

Esta fase consolida la capacidad del sistema para **modelar comportamientos acumulativos** dentro del partido, mostrando cómo un *Game* individual se convierte en parte de una estructura mayor (*Set*).

El diseño orientado a objetos de *Grady Booch* nos recuerda que los sistemas deben evolucionar de forma **modular, comprensible y extensible**, priorizando el dominio sobre la implementación.

---

## 🚀 PRÓXIMO PASO

Implementar la **Fase 04: TieBreak**, donde se definirán las reglas especiales que se activan al empatar 6–6, extendiendo el comportamiento del *Set* y acercándonos a la estructura completa del partido.

---

## 📚 REFERENCIAS

- Booch, Grady. *Object-Oriented Analysis and Design with Applications*. Addison-Wesley.
- Documentación oficial de Java 21.
- UML — *Unified Modeling Language* (PlantUML).

---

👨‍💻 **Andersson Fuentes**  
*Estudiante de Ingeniería de Software | Java | Spring Boot*  
📦 Repositorio: [tennis-portfolio (GitHub)](https://github.com/AnderssonFuentes/tennis-portfolio)
