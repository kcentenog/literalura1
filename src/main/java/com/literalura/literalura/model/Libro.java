package com.literalura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.lang.reflect.Array;

@Entity
@Table(name = "Libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String lenguaje;
    private Integer descargas;
    @OneToOne(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libro(Libro libro) {this.titulo = CadenasUtil.limitarLongitud(libro.title(), 200);
        this.descargas = libro.download();
        if (!libro.languages().isEmpty())
            this.lenguaje = libro.languages().get(0);
        if (!libro.autores().isEmpty()) {
            for (Autor autor : libro.autores()) {
                this.autor = new Autor(autor);
                break;
            }
        }
    }
}
