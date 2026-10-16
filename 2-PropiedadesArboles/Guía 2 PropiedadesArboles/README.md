# Guía 2 – Anatomía y propiedades de un árbol

**Asignatura:** Estructura de Datos II  
**Programas:** Ingeniería de Software – Ingeniería de Sistemas  
**Semestre:** IV  
**Ecosistema:** Java / GitHub

## Objetivo

Identificar y calcular correctamente raíz, hojas, nodos internos, grado, nivel, profundidad, altura y caminos en estructuras arbóreas.

## Convenciones usadas

- La raíz tiene profundidad **0**.
- El nivel se toma igual a la profundidad.
- Una hoja tiene altura **0**.
- La altura se mide en **número de aristas**.
- El grado de un nodo es su número de hijos.
- El grado del árbol es el mayor grado entre todos sus nodos.

## Árbol usado

```text
Universidad
├── Facultad de Ingeniería
│   ├── Ingeniería de Sistemas
│   │   ├── Semillero IA
│   │   └── Semillero Datos
│   ├── Ingeniería de Software
│   │   └── Laboratorio Móvil
│   └── Ingeniería Industrial
├── Ciencias Administrativas
│   ├── Administración
│   └── Contaduría
└── Bienestar Universitario
    ├── Deportes
    └── Cultura
```

El ejemplo tiene **14 nodos y 4 niveles**.

## Archivos

- `NodoGeneral.java`: estructura de cada nodo.
- `MetricasArbol.java`: algoritmos recursivos para altura, profundidad, grado, caminos y conteos.
- `Main.java`: construcción del árbol y pruebas.
- `tabla_metricas_manual.csv`: valores esperados para comparar con Java.
- `salida_esperada.txt`: ejemplo de salida del programa.

## Compilar y ejecutar

```bash
javac NodoGeneral.java MetricasArbol.java Main.java
java Main
```

## Conceptos importantes

### Grado de un nodo

Número de hijos directos.

```java
public static int gradoNodo(NodoGeneral<?> nodo) {
    return nodo.getHijos().size();
}
```

### Altura

La hoja tiene altura 0. Para un nodo interno:

```text
altura(nodo) = 1 + máxima altura de sus hijos
```

### Profundidad

Distancia desde la raíz hasta un nodo, expresada en número de aristas.

### Grado del árbol

Mayor grado encontrado entre todos los nodos.

## Ejercicios de la guía

1. Calcular la profundidad de cada hoja.
2. Encontrar dos caminos distintos y determinar su longitud.
3. Agregar un nuevo nivel y explicar cómo cambia la altura.

### Reto sugerido

Agregue un nodo `Proyecto IA Generativa` como hijo de `Semillero IA`.

Antes:

```text
altura del árbol = 3
```

Después:

```text
altura del árbol = 4
```

El número de niveles pasa de 4 a 5.
