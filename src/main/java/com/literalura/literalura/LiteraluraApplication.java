package com.literalura.literalura;

import com.literalura.literalura.model.Libro;
import com.literalura.literalura.service.ConsumoAPI;
import com.literalura.literalura.service.ConvierteDatos;
import com.literalura.literalura.service.DatosLibro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	private ConsumoAPI consumoApi = new ConsumoAPI();
	private ConvierteDatos conversor = new ConvierteDatos();


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String json = consumoApi.consumoAPI();

		DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
		Libro libro = new Libro(datos.results().get(0));
	}
}
