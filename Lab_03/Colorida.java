public abstract class Colorida implements Figura{
		String cor;			
		String desenhar(String cor){
			this.cor = cor;
			return super.toString() + ": " + this.toString() +" " + cor;
	}
}
