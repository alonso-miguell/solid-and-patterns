package abstractfactory;

/*
Impelmentamos la AbstractFactory en tantas clases sea necesario dependiendo los diferentes tipos
de clases que necesitemos encapsular, ej:

    AbstractFactory factory=new FactoryEn();
    Preguntas preguntas = factory.createPreguntas();

    Aqui el tipo de retorno para Preguntas preguntas, ya esta decidido al momento de la instanciacion en new FactoryEn();
 */

public class FactoryEn implements AbstractFactory {


    @Override
    public Preguntas createPreguntas() {
        return new PreguntasEn();
    }

    @Override
    public Saludos createSaludos() {
        return new SaludosEn();
    }
}
