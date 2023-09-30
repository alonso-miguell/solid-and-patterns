import abstractfactory.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMultiIdioma {
	/*
	Basicamente Abstract Factory es una capa adicional más de abstraccion,
	para encapsular o delegar el tipo de instanciacion en una unica linea y en un unico punto dentro del flujo del programa en vez de varias.

	Ej:
	Conviene usar:
		 AbstractFactory factory=new FactoryEn();
		 Preguntas preguntas = factory.createPreguntas();
		 Saludos saludos = factory.createSaludos();

	 En vez de:
	 	Preguntas preguntas = new PreguntasEs();
		Saludos saludos = new SaludosEs();
	 */

	@Test
	public void test_es() {
		AbstractFactory factory= new FactoryEs();
//		Preguntas preguntas = new PreguntasEs();

		Preguntas preguntas = factory.createPreguntas();

		assertEquals("¿qué hora es?", preguntas.preguntaHora() );
		assertEquals("¿qué tiempo hace?", preguntas.preguntaTiempo() );
		
//		Saludos saludos = new SaludosEs();
		Saludos saludos = factory.createSaludos();

		assertEquals("buenos días", saludos.buenosDias());
		assertEquals("buenas tardes", saludos.buenasTardes());
	}
	
	@Test
	public void test_en() {
		AbstractFactory factory=new FactoryEn();

//		Preguntas preguntas = new PreguntasEn();
		Preguntas preguntas = factory.createPreguntas();

		assertEquals("what time is it?", preguntas.preguntaHora() );
		assertEquals("how is the weather?", preguntas.preguntaTiempo() );
		
//		Saludos saludos = new SaludosEn();
		Saludos saludos= factory.createSaludos();

		assertEquals("good morning", saludos.buenosDias());
		assertEquals("good afternoon", saludos.buenasTardes());
	}

}
