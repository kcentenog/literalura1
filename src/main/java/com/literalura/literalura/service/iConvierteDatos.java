package com.literalura.literalura.service;

public interface iConvierteDatos {
    public interface IConvierteDatos {
        <T> T obtenerDatos(String json, Class<T> clase);
    }
}
