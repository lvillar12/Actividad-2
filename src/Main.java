import java.util.Scanner;

public class Main{
    private final String nombre;
    private final double[] calificaciones;

    public Main(String nombre) {
        this.nombre = nombre;
        calificaciones = new double[5];
    }

    public void ingresarCalificaciones() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese calificaciones del alumno " + nombre + ":");

        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Evaluacion " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextDouble();
        }

        scanner.close();
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    public void imprimirResultados() {
        System.out.println("Nombre del alumno: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificacion " + (i + 1) + ": " + calificaciones[i]);
        }

        double promedio = calcularPromedio();
        char calificacionFinal = obtenerCalificacionFinal(promedio);

        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación final: " + calificacionFinal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del alumno: ");
        String nombreEstudiante = scanner.nextLine();

        Main alumno = new Main(nombreEstudiante);

        alumno.ingresarCalificaciones();

        alumno.imprimirResultados();

        scanner.close();
    }
}