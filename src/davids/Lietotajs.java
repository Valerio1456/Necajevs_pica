package davids;

public class Lietotajs {
	private String vards, adrese;
	PicaOrder pica;
	public Lietotajs(String vards, String adrese, PicaOrder pica){
		this.vards=vards;
		this.adrese=adrese;
		this.pica=pica;
	}
	public String getVards(){
		return vards;
	}
	public String getAdrese(){
		return adrese;
	}
}
