class Circulo implements Figura{
	float x0, y0, raio;

	public Circulo(){
		this(0.0f,0.0f,1.0f);
	}
	public Circulo(float raio){
		this(0.0f,0.0f,raio);
	}

	public Circulo(float d, float raio){
		this(d,d,raio);
	}
//*/

	public Circulo(float x0, float y0, float raio){
		this.x0 = x0;
		this.y0 = y0;
		this.raio = raio;
	}

	public String toString(){
		return "Circulo";
	}

	public	String desenhar(){
		return super.toString() + ": " + this.toString();
	}

	public void mover(float dx, float dy){
		this.x0 += dx;
		this.y0 += dy;

	}

	public float calculaArea(){
		return (3.14f)*(this.raio)*(this.raio);
	}

}
