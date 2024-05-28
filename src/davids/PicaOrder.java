package davids;

public class PicaOrder {
	
	private String izmers, merce, piedevas, siers;
	private double summa;
public PicaOrder(String izmers, String merce, String piedevas, String siers, double summa){
		this.izmers=izmers; 
		this.merce=merce;
		this.piedevas=piedevas;
		this.siers=siers;
		this.summa=summa;
	}

	
	public String getIzmers(){
		return izmers;
	}
	
	public String getMerce(){
		return merce;
	}
	
	public String getPiedevas(){
		return piedevas;
	}
	public String getSiers(){
		return siers;
	}
	
	public double getSumma(){
		return summa;
	}
	
}
