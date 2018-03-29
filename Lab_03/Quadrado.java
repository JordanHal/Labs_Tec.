public class Quadrado extends Colorida implements Figura{
	float x1, y1, x2, y2;
	
	public Quadrado(){
		this(0,0,1);
	}

	public Quadrado(float p){
		this(p,p,1);
	}
	public Quadrado(float p1,float p2){
		this(p1,p2,1);
	}//*/
	
	public Quadrado(float d1,float d2,float base){
		this.x1 = d1;
		this.y1 = d2;
		this.x2 = d1 + base;
		this.y2 = d2 + base;
	}
	
	public String toString(){
		return "Quadrado";
	}

	public String desenhar(){
		return super.toString() + ": " + this.toString();
	}

	public void mover(float dx, float dy){
		this.x1 += dx;
		this.y1 += dy;
		this.x2 += dx;
		this.y2 += dy;

	}

	public float calculaArea(){
		return (this.x2 - this.x1) * (this.y2 - this.y1);
	}

	
}
