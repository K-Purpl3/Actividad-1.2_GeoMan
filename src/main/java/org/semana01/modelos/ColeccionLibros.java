package org.semana01.modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColeccionLibros {

    private List<Libro> libros;

    public ColeccionLibros() {
        this.libros = new ArrayList<>();
    }

    //metodo para agregar libros a la colección
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    //Metodo 1: Cantidad de libros con más de 500 paginas
    public long cantidadLibrosMas500Paginas() {
        return libros.stream()
                .filter(libro -> libro.getPaginas() > 500)
                .count();
    }

    //Metodo 2: Cantidad de libros con menos de 300 paginas
    public long cantidadLibrosMenos300Paginas() {
        return libros.stream()
                .filter(libro -> libro.getPaginas() < 300)
                .count();
    }

    //Metodo 3: Titulos de libros con mas de 500 paginas
    public List<String> listarLibrosMas500Paginas() {
        return libros.stream()
                .filter(libro -> libro.getPaginas() > 500)
                .map(Libro::getTitulo)
                .collect(Collectors.toList());
    }

    //Metodo 4: Titulos de los 3 libros con mas paginasq
    public List<String> listarTresLibrosMasPaginas() {
        return libros.stream()
                .sorted(Comparator.comparingInt(Libro::getPaginas).reversed())
                .limit(3)
                .map(Libro::getTitulo)
                .collect(Collectors.toList());
    }

    //Metodo 5: Suma de páginas de todos los libros
    public int sumaTotalPaginas() {
        return libros.stream()
                .mapToInt(Libro::getPaginas)
                .sum();
    }

    //Metodo 6: Libros que superan el promedio de páginas
    public List<Libro> listarLibrosMasPaginasPromedio() {
        double promedio = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0);

        return libros.stream()
                .filter(libro -> libro.getPaginas() > promedio)
                .collect(Collectors.toList());
    }

    //Metodo 7: Autores sin repetir
    public Set<String> listarAutores() {
        return libros.stream()
                .map(Libro::getAutor)
                .collect(Collectors.toSet());
    }

    //Metodo 8: Libro con mayor numero de páginas
    public Libro libroMasPaginas() {
        return libros.stream()
                .max(Comparator.comparingInt(Libro::getPaginas))
                .orElse(null);
    }

    //Metodo 9: Titulos de los libros
    public List<String> listarTitulos() {
        return libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.toList());
    }

    //Metodo 10: Autores con más de un libro
    public Set<String> listarAutoresConMasDeUnLibro() {
        return libros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
