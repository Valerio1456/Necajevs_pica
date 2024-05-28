package davids;

public class Lietotajs {
	private String vards, adrese;
	PicaOrder pica;
	public Lietotajs(String vards, String adrese, PicaOrder pica){
		this.vards=vards;
		this.adrese=adrese;
		this.pica=pica;
	}
	
	//Prieks izveidotam picam
	public String izvadit() {
		
		if(adrese == "Uz vietas") {
			String izvade = "\nSanemts picerija\nPasutitajs "+vards+"\nPicas izmers "+pica.getIzmers()+"\nPicas merce "+pica.getMerce()+"\nPicas siers "+pica.getSiers()+
					"\nPicas piedevas "+pica.getPiedevas()+"\n\nKopa samaksajat: "+pica.getSumma()+"$\n---------------------------------------------------------";
			return izvade;
		
		}else {
			String izvade = "\nPasutita uz "+adrese+"\nMaksa par piegadi 3$\nPasutitajs: "+vards+"\nPicas izmers "+pica.getIzmers()+"\nPicas merce "+pica.getMerce()+"\nPicas siers "+pica.getSiers()+
					"\nPicas piedevas "+pica.getPiedevas()+"\n\nKopa samaksajat: "+pica.getSumma()+"$\n---------------------------------------------------------";
			return izvade;
		}
	}
	
	public String ceks(){
		if(adrese == "Uz vietas") {
			String izvade = "\nSanemts picerija\nPasutitajs "+vards+"\nPicas izmers "+pica.getIzmers()+"\nPicas merce "+pica.getMerce()+"\nPicas siers "+pica.getSiers()+
					"\nPicas piedevas "+pica.getPiedevas()+"\n\nKopa samaksajat: "+pica.getSumma()+"$";
			return izvade;
		}else{
			String izvade = "\nPasutita uz "+adrese+"\nMaksa par piegadi 3$\nPasutitajs: "+vards+"\nPicas izmers "+pica.getIzmers()+"\nPicas merce "+pica.getMerce()+"\nPicas siers "+pica.getSiers()+
					"\nPicas piedevas "+pica.getPiedevas()+"\n\nKopa samaksajat: "+pica.getSumma()+"$";
			return izvade;
		}
		
	}
	
	//Prieks txt faila
	public String toString(){
		if(adrese == "Uz vietas") {
			String izvade = vards+" nopirka "+pica.getIzmers()+" picu ar "+pica.getMerce()+" merci ar "+pica.getSiers()+" sieru un "+pica.getPiedevas()+" piedevam un samaksaja "+pica.getSumma()+"$";
			return izvade;
		}else{
			String izvade = vards+" pasutija uz adresi "+adrese+" "+pica.getIzmers()+" picu ar "+pica.getMerce()+" merci ar "+pica.getSiers()+" sieru un "+pica.getPiedevas()+" piedevam un samaksaja "+pica.getSumma()+"$";
			return izvade;
		}
		
	}
	
	
	
	
	public String getVards(){
		return vards;
	}
	public String getAdrese(){
		return adrese;
	}
}
