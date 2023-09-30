public class Persona {

	private String nombre;
	private int edad;
	private String municipio;
	private String colegio;
	private String lugarTrabajo;
	
	private Persona() {}
	
	
	public static class Builder {
		private Persona persona;
		
		public Builder(String nombre) {
			persona = new Persona();
			persona.nombre = nombre;
		}
		
		public Builder setMunicipio (String municipio) {
			persona.municipio = municipio;
			return this;
		}
		
//		public BuilderMayor setMayor(int edad, String lugarTrabajo) {
		public BuilderMayor setMayor(int edad) {
			if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
			persona.edad = edad;

//			persona.lugarTrabajo = lugarTrabajo;
//			persona.colegio = null;
//			return this;

			return new BuilderMayor(persona);
		}
		
		public BuilderMenor setMenor(int edad) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;

//			persona.colegio = colegio;
//			persona.lugarTrabajo = null;
			return new BuilderMenor(persona);
		}
	
		public Persona build() {
			return persona;
		}

	}


	/*
	BUIlders agregados, Mayor y menor
	Al no tener setColegio en BuilderMayor, fallara en tiempo de compilacion.
	De la misma manera al no tener un metodo setLuharTrabajo fallara en BuilderMenor
	 */

	public static class BuilderMenor {
		private Persona persona;

		public BuilderMenor(Persona persona){
			this.persona=persona;
		}

		public BuilderMenor setColegio(String colegio){
			persona.colegio=colegio;
			return this;
		}

		public Persona build(){
			return persona;
		}
	}

	public static class BuilderMayor {
		private Persona persona;

		public BuilderMayor(Persona persona){
			this.persona=persona;
		}

		public BuilderMayor setLugarTrabajo(String lugarTrabajo){
			persona.lugarTrabajo=lugarTrabajo;
			return this;
		}

		public Persona build(){
			return persona;
		}
	}


}
