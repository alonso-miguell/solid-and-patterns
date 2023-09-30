package abstractfactory;


/*
Creamos un abstract factory que será la interface intermediaria por medio d ela cual despues concretaremos el tipo d eobjeto a utilizar,
ej:
AbstractFactory factory= new FactoryEs();

 */
public interface AbstractFactory {

    Preguntas createPreguntas();

    Saludos createSaludos();
}
