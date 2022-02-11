package borrar;

import java.util.*;
import java.util.function.Function;

public class Curso {

    private String titulo;
    private float duracion;
    private int videos;
    private int alumnos;

    public Curso(String titulo, float duracion, int videos, int alumnos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.videos = videos;
        this.alumnos = alumnos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getVideos() {
        return videos;
    }

    public void setVideos(int videos) {
        this.videos = videos;
    }

    public int getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(int alumnos) {
        this.alumnos = alumnos;
    }


    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        //    Obtener la cantidad de cursos con una duración mayor a 5 horas.
        long cantidadDeCursosMas5Horas = cursos.stream().filter(curso -> curso.getDuracion() > 5f).count();

        //    Obtener la cantidad de cursos con una duración menor a 2 horas.
        long cantidadDeCursosMenos2Horas = cursos.stream().filter(curso -> curso.getDuracion() < 2f).count();

        //    Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
        List<String> listaTitulosConMasDe50Videos = cursos.stream().filter(curso -> curso.getVideos() > 30).map(Curso::getTitulo).toList();

        //    Mostrar en consola el título de los 3 cursos con mayor duración.
        Comparator<Curso> byDuracionAsc = (Curso c1, Curso c2) -> Float.compare(c2.getDuracion(), c1.getDuracion());
        List<String> lista3TitulosConMayorDuracion = cursos.stream().sorted(byDuracionAsc).map(Curso::getTitulo).toList().subList(0, 3);

        //    Mostrar en consola la duración total de todos los cursos.
        double duracionTotalCursos = cursos.stream().mapToDouble(Curso::getDuracion).sum();

        //    Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
        double duracionMediaCursos = cursos.stream().mapToDouble(Curso::getDuracion).average().orElse(Double.NaN);
        List<String> listaTitulosQueDuranMasDeLaMedia = cursos.stream().filter(curso -> curso.getDuracion() > duracionMediaCursos).map(Curso::getTitulo).toList();

        //    Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        List<Float> listaDuracionCursosConMenosDe500Alumnos = cursos.stream().filter(curso -> curso.getAlumnos() < 500).map(Curso::getDuracion).toList();

        //    Obtener el curso con mayor duración.
        String tituloConMayorDuracion = cursos.stream().sorted(byDuracionAsc).map(Curso::getTitulo).toList().get(0);

        //    Crear una lista de Strings con todos los titulos de los cursos.
        List<String> listaTodosTitulosCursos = cursos.stream().map(Curso::getTitulo).toList();

        System.out.println("cantidadDeCursosMas5Horas: "  + cantidadDeCursosMas5Horas);
        System.out.println("cantidadDeCursosMenos2Horas: "  + cantidadDeCursosMenos2Horas);
        System.out.println("listaTitulosConMasDe50Videos: " + listaTitulosConMasDe50Videos);
        System.out.println("lista3TitulosConMayorDuracion: " + lista3TitulosConMayorDuracion);
        System.out.println("duracionTotalCursos: " + duracionTotalCursos);
        System.out.println("listaTitulosQueDuranMasDeLaMedias: " + listaTitulosQueDuranMasDeLaMedia + " " + duracionMediaCursos);
        System.out.println("listaDuracionCursosConMenosDe500Alumnos: " + listaDuracionCursosConMenosDe500Alumnos);
        System.out.println("tituloConMayorDuracion: " + tituloConMayorDuracion);
        System.out.println("listaTodosTitulosCursos: " + listaTodosTitulosCursos);

        Function<String, String> coderFunction = name -> "Coder " + name;
        System.out.println(coderFunction.apply("AA"));
    }



}