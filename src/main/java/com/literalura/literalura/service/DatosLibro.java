package com.literalura.literalura.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.literalura.literalura.model.Autor;
import com.literalura.literalura.model.Libro;

import java.lang.reflect.Array;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)


public record DatosLibro(

        @JsonAlias("results") List<Libro> results
) {
}
