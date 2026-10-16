public class Main {

    public static void main(String[] args) {

        // ============================================================
        // 1. CREACIÓN DE LOS NODOS
        // ============================================================

        NodoGeneral<String> universidad =
                new NodoGeneral<>("Universidad");

        // Nivel 1
        NodoGeneral<String> ingenieria =
                new NodoGeneral<>("Facultad de Ingeniería");

        NodoGeneral<String> administrativas =
                new NodoGeneral<>("Ciencias Administrativas");

        NodoGeneral<String> bienestar =
                new NodoGeneral<>("Bienestar Universitario");

        // Nivel 2
        NodoGeneral<String> sistemas =
                new NodoGeneral<>("Ingeniería de Sistemas");

        NodoGeneral<String> software =
                new NodoGeneral<>("Ingeniería de Software");

        NodoGeneral<String> industrial =
                new NodoGeneral<>("Ingeniería Industrial");

        NodoGeneral<String> administracion =
                new NodoGeneral<>("Administración");

        NodoGeneral<String> contaduria =
                new NodoGeneral<>("Contaduría");

        NodoGeneral<String> deportes =
                new NodoGeneral<>("Deportes");

        NodoGeneral<String> cultura =
                new NodoGeneral<>("Cultura");

        // Nivel 3
        NodoGeneral<String> semilleroIA =
                new NodoGeneral<>("Semillero IA");

        NodoGeneral<String> semilleroDatos =
                new NodoGeneral<>("Semillero Datos");

        NodoGeneral<String> laboratorioMovil =
                new NodoGeneral<>("Laboratorio Móvil");

        // ============================================================
        // 2. CONSTRUCCIÓN DE LA JERARQUÍA
        // ============================================================

        universidad.agregarHijo(ingenieria);
        universidad.agregarHijo(administrativas);
        universidad.agregarHijo(bienestar);

        ingenieria.agregarHijo(sistemas);
        ingenieria.agregarHijo(software);
        ingenieria.agregarHijo(industrial);

        administrativas.agregarHijo(administracion);
        administrativas.agregarHijo(contaduria);

        bienestar.agregarHijo(deportes);
        bienestar.agregarHijo(cultura);

        sistemas.agregarHijo(semilleroIA);
        sistemas.agregarHijo(semilleroDatos);

        software.agregarHijo(laboratorioMovil);

        // ============================================================
        // 3. MOSTRAR EL ÁRBOL
        // ============================================================

        System.out.println("=== ÁRBOL UNIVERSITARIO ===");
        MetricasArbol.mostrarArbol(universidad, 0);

        // ============================================================
        // 4. PROPIEDADES GENERALES
        // ============================================================

        System.out.println();
        System.out.println("=== PROPIEDADES DEL ÁRBOL ===");

        System.out.println(
                "Raíz: " + universidad.getDato()
        );

        System.out.println(
                "Número total de nodos: "
                        + MetricasArbol.contarNodos(universidad)
        );

        System.out.println(
                "Número de hojas: "
                        + MetricasArbol.contarHojas(universidad)
        );

        System.out.println(
                "Grado del árbol: "
                        + MetricasArbol.gradoArbol(universidad)
        );

        System.out.println(
                "Altura del árbol: "
                        + MetricasArbol.altura(universidad)
        );

        System.out.println(
                "Número de niveles: "
                        + (MetricasArbol.altura(universidad) + 1)
        );

        // ============================================================
        // 5. PROFUNDIDAD DE CINCO NODOS
        // ============================================================

        System.out.println();
        System.out.println("=== PROFUNDIDAD DE CINCO NODOS ===");

        mostrarProfundidad(universidad, ingenieria);
        mostrarProfundidad(universidad, sistemas);
        mostrarProfundidad(universidad, semilleroIA);
        mostrarProfundidad(universidad, administracion);
        mostrarProfundidad(universidad, cultura);

        // ============================================================
        // 6. GRADO DE NODOS
        // ============================================================

        System.out.println();
        System.out.println("=== GRADO DE ALGUNOS NODOS ===");

        mostrarGrado(universidad);
        mostrarGrado(ingenieria);
        mostrarGrado(sistemas);
        mostrarGrado(software);
        mostrarGrado(semilleroIA);

        // ============================================================
        // 7. TABLA COMPLETA DE MÉTRICAS
        // ============================================================

        System.out.println();
        System.out.println("=== TABLA DE MÉTRICAS ===");
        MetricasArbol.mostrarTablaMetricas(universidad);

        // ============================================================
        // 8. DOS CAMINOS Y SU LONGITUD
        // ============================================================

        System.out.println();
        System.out.println("=== CAMINOS ===");

        mostrarCamino(universidad, semilleroDatos);
        mostrarCamino(universidad, contaduria);

        // ============================================================
        // 9. COMPARACIÓN MANUAL VS. CÓDIGO
        // ============================================================

        System.out.println();
        System.out.println("=== COMPARACIÓN ===");

        int alturaManual = 3;
        int alturaCalculada =
                MetricasArbol.altura(universidad);

        System.out.println(
                "Altura calculada manualmente: "
                        + alturaManual
        );

        System.out.println(
                "Altura calculada por Java: "
                        + alturaCalculada
        );

        System.out.println(
                alturaManual == alturaCalculada
                        ? "Resultado: COINCIDEN."
                        : "Resultado: REVISAR CÁLCULO."
        );
    }

    private static void mostrarProfundidad(
            NodoGeneral<?> raiz,
            NodoGeneral<?> nodo) {

        System.out.printf(
                "%-28s -> %d%n",
                nodo.getDato(),
                MetricasArbol.profundidad(raiz, nodo)
        );
    }

    private static void mostrarGrado(
            NodoGeneral<?> nodo) {

        System.out.printf(
                "%-28s -> %d%n",
                nodo.getDato(),
                MetricasArbol.gradoNodo(nodo)
        );
    }

    private static void mostrarCamino(
            NodoGeneral<?> raiz,
            NodoGeneral<?> destino) {

        var ruta =
                MetricasArbol.camino(raiz, destino);

        System.out.println(
                MetricasArbol.rutaComoTexto(ruta)
        );

        System.out.println(
                "Longitud: "
                        + MetricasArbol.longitudCamino(
                                raiz,
                                destino
                        )
                        + " aristas"
        );
    }
}
