package abstractfactory;

public class FactoryEs implements AbstractFactory {


    @Override
    public Preguntas createPreguntas() {
        return new PreguntasEs();
    }

    @Override
    public Saludos createSaludos() {
        return new SaludosEs();
    }
}
