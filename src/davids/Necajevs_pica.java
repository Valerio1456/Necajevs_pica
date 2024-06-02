package davids;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Necajevs_pica {
	
	public static String sveiciens(){
		String sveicien = "Sveicinati labakaja picerija!";
		return sveicien;
	}
	
	public static void main(String[] args) {
		String izvele;
		String darbibas[] = {"Nopirkt picu", "Pasutit picu", "Aiziet", "Apskatit jau izveidotas picas", "Apturet"};
		
		String vards= "";
		String adrese = "Uz vietas";
		
		double izmersCena = 0;
		double merceCena = 0;
		double piedevasCena = 0;
		double summa = 0;
		
		
		String izmers = "";
		int izmeri;
		String merce = "";
		String merces[] = {"kecupa - 1$", "kiploku 1.5$", "pesto 2$"};
		String piedevas = "";
		String piedevasM[] = {};
		
		
		String siers = "";
		List<String> atlautieSieri = Arrays.asList("mocarella", "cedara", "provolone");
		
		ArrayList<Lietotajs> picas = new ArrayList<Lietotajs>();
		
		ImageIcon mocarellaIcon = new ImageIcon("mocarella.png");
		ImageIcon cedaraIcon = new ImageIcon("cedara.png");
		ImageIcon provoloneIcon = new ImageIcon("provolone.png");
		
		Image mocarellaImage = mocarellaIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image cedaraImage = cedaraIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image provoloneImage = provoloneIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		// Создание новых ImageIcon с измененными размерами
		ImageIcon resizedMocarellaIcon = new ImageIcon(mocarellaImage);
		ImageIcon resizedCedaraIcon = new ImageIcon(cedaraImage);
		ImageIcon resizedProvoloneIcon = new ImageIcon(provoloneImage);
		
		
		
		boolean majas = false;
		
		JOptionPane.showMessageDialog(null, sveiciens(), "Picerija", JOptionPane.INFORMATION_MESSAGE);
		do{
			izvele =(String)JOptionPane.showInputDialog(null, "Darbibas izvele", null, JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			switch(izvele){
			case "Nopirkt picu":
				
				if(majas==false) {
				do {
				 vards =(String)JOptionPane.showInputDialog(null, "Ievadi savu vardu", null, JOptionPane.QUESTION_MESSAGE);
				}while(vards.isBlank());
				 izmeri = JOptionPane.showOptionDialog(null, "Cik lielu picu velies?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						 null, new String[] {"20cm - 5.99$", "30cm - 6.99$", "50cm - 8.99$"}, null);
				 switch(izmeri){
		   			case 0:
		   				izmers = "20cm - 5.99$";
		                izmersCena = 5.99;
		                break;
		            case 1:
		                izmers = "30cm - 6.99$";
		                izmersCena = 6.99;
		                break;
		            case 2:
		                izmers = "50cm - 8.99$";
		                izmersCena = 8.99;
		                break;
		        }
				
				 merce = (String)JOptionPane.showInputDialog(null, "Kadu merci velies?", null, JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
				 
				do {
				    siers = (String) JOptionPane.showInputDialog(null, "Ieraksti picas sieru (mocarella, cedara, provolone)", "mocarella; cedara; provolone", JOptionPane.QUESTION_MESSAGE, null, atlautieSieri.toArray(), atlautieSieri.get(0));
				    if (!atlautieSieri.contains(siers)) {
				        JOptionPane.showMessageDialog(null, "Tads siers neeksiste", null, JOptionPane.ERROR_MESSAGE);
				    }
				} while (!atlautieSieri.contains(siers));
				
				ImageIcon selectedIcon = null;
				switch (siers) {
				    case "mocarella":
				        selectedIcon = resizedMocarellaIcon;
				        break;
				    case "cedara":
				        selectedIcon = resizedCedaraIcon;
				        break;
				    case "provolone":
				        selectedIcon = resizedProvoloneIcon;
				        break;
				}
				JOptionPane.showMessageDialog(null, siers, null, JOptionPane.INFORMATION_MESSAGE, selectedIcon);
				 
				 do {
				 piedevas = (String)JOptionPane.showInputDialog(null, "Kadas piedevas picai?(Ar komatu atdali) - 1$", null, JOptionPane.QUESTION_MESSAGE);
				}while(piedevas.isBlank());
			     piedevasM = piedevas.split(",");
			     System.out.println(piedevasM.length);
	     
			     
			     piedevasCena = piedevasM.length * 1; //katra jauna pildījuma +1 eiro!
			     
			     if(merce == merces[0]) {
			    	 merceCena = 1;
			     }else if(merce == merces[1]) {
			    	 merceCena = 1.50;
			     }else {
			    	 merceCena = 2; }
			   
			     summa = izmersCena + merceCena + 1.5 + piedevasCena; 
			     String summaStepByStep = 
			    		 "Izmers: " + izmersCena + "$" + 
			    		 "\nMerce: " + merceCena + "$" + 
			    		 "\nSiers: " + 1.5 + "$" + 
			    		 "\nPiedavas: " + piedevasCena + "$" +
			    		 "\n\nTOATAL: "+ summa + "$";
				 JOptionPane.showMessageDialog(null, summaStepByStep);
			     
			     PicaOrder pica = new PicaOrder(izmers, merce, piedevas, siers, summa);
			    
			     Lietotajs lietotajs = new Lietotajs(vards, adrese, pica);
			     picas.add(lietotajs);
			     JOptionPane.showMessageDialog(null, lietotajs.ceks(), "Pica nopirkta", JOptionPane.INFORMATION_MESSAGE);
			     try {
					 FileWriter writer = new FileWriter("picas.txt", true);
				 	 writer.write(lietotajs.toString()+"\n");
				 	 writer.close();
				 	 JOptionPane.showMessageDialog(null, "Pica ievietota txt faila", null, JOptionPane.INFORMATION_MESSAGE);
				 }catch(Exception e) {
					 JOptionPane.showMessageDialog(null, "Kluda", "error", JOptionPane.ERROR_MESSAGE);
				 }
				}else	JOptionPane.showMessageDialog(null, "Jus neesiet uz vietas picerija, pameginiet pasutit picu", "error", JOptionPane.ERROR_MESSAGE);
				
				break;
                    
                case "Pasutit picu":
                	if(majas==true){
    					do {
    					 vards =(String)JOptionPane.showInputDialog(null, "Ievadi savu vardu", null, JOptionPane.QUESTION_MESSAGE);
    				}while(vards.isBlank());
    					do {
    					 adrese =(String)JOptionPane.showInputDialog(null, "Ievadi savu adresi", null, JOptionPane.QUESTION_MESSAGE);
    					}while(adrese.isBlank());
    					 izmeri = JOptionPane.showOptionDialog(null, "Cik lielu picu velies?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
    							 null, new String[] {"20cm - 5.99$", "30cm - 6.99$", "50cm - 8.99$"}, null);
    					 switch(izmeri){
    			   			case 0:
    			   				izmers = "20cm - 5.99$";
    			                izmersCena = 5.99;
    			                break;
    			            case 1:
    			                izmers = "30cm - 6.99$";
    			                izmersCena = 6.99;
    			                break;
    			            case 2:
    			                izmers = "50cm - 8.99$";
    			                izmersCena = 8.99;
    			                break;
    			        }
    					 merce = (String)JOptionPane.showInputDialog(null, "Kadu merci velies?", null, JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
    						do {
    						    siers = (String) JOptionPane.showInputDialog(null, "Ieraksti picas sieru (mocarella, cedara, provolone)", "mocarella; cedara; provolone", JOptionPane.QUESTION_MESSAGE, null, atlautieSieri.toArray(), atlautieSieri.get(0));
    						    if (!atlautieSieri.contains(siers)) {
    						        JOptionPane.showMessageDialog(null, "Tads siers neeksiste", null, JOptionPane.ERROR_MESSAGE);
    						    }
    						} while (!atlautieSieri.contains(siers));
    						
    						ImageIcon selectedIcon = null;
    						switch (siers) {
    					    case "mocarella":
    					        selectedIcon = resizedMocarellaIcon;
    					        break;
    					    case "cedara":
    					        selectedIcon = resizedCedaraIcon;
    					        break;
    					    case "provolone":
    					        selectedIcon = resizedProvoloneIcon;
    					        break;
    						}
    						JOptionPane.showMessageDialog(null, siers, null, JOptionPane.INFORMATION_MESSAGE, selectedIcon);
    					 do {
    					 piedevas = (String)JOptionPane.showInputDialog(null, "Kadas piedevas picai? (Ar komatu atdali) - 1$", null, JOptionPane.QUESTION_MESSAGE);
    					}while(piedevas.isBlank());
    				     piedevasM = piedevas.split(",");
    				     
    				     piedevasCena = piedevasM.length * 1; //katra jauna pildījuma +1 eiro
    				     
    				     if(merce == merces[0]) {
    				    	 merceCena = 1;
    				     }else if(merce == merces[1]) {
    				    	 merceCena = 1.50;
    				     }else {
    				    	 merceCena = 2; }	
    				     
    				     
    					    JOptionPane.showMessageDialog(null, "Par piegadi samaksajat 3 eiro");
    					    	 //Piegade 3 eiro
    					     summa = izmersCena + merceCena + 1.5 + piedevasCena + 3; 
    					     String summaStepByStep = 
    					    		 "Izmers: " + izmersCena + "$" + 
    							    		 "\nMerce: " + merceCena + "$" + 
    							    		 "\nSiers: " + 1.5 + "$" + 
    							    		 "\nPiedavas: " + piedevasCena + "$" +
    							    		 "\nPiegade: " + 3 + "$" +
    							    		 "\n\nTOATAL: "+ summa + "$";
    					 JOptionPane.showMessageDialog(null, summaStepByStep);
    					     
    				     PicaOrder pica = new PicaOrder(izmers, merce, piedevas, siers, summa);
    				     Lietotajs lietotajs = new Lietotajs(vards, adrese, pica);
    				     picas.add(lietotajs);
    					 JOptionPane.showMessageDialog(null, lietotajs.ceks(), "Veiksmigi pasutita", JOptionPane.INFORMATION_MESSAGE);
    					 
    					 try {
    						 FileWriter writer = new FileWriter("picas.txt", true);
    					 	 writer.write(lietotajs.toString()+"\n");
    					 	 writer.close();
    					 	 JOptionPane.showMessageDialog(null, "Pica ievietota txt faila", null, JOptionPane.INFORMATION_MESSAGE);
    					 }catch(Exception e) {
    						 JOptionPane.showMessageDialog(null, "Kluda", "error", JOptionPane.ERROR_MESSAGE);
    					 }
    				     
    				     
                	}else 	JOptionPane.showMessageDialog(null, "Jus neesiet majas, pameginiet nopirkt picu", "error", JOptionPane.ERROR_MESSAGE);
                	
    				break;
    				
    			case "Aiziet":
    				if(majas==false){
    					majas = true;
    					JOptionPane.showMessageDialog(null, "Jus aizgajat majas", null, JOptionPane.INFORMATION_MESSAGE);
    				}else{
    					majas = false;
    					JOptionPane.showMessageDialog(null, "Jus aizgajat uz piceriju", null, JOptionPane.INFORMATION_MESSAGE);
    					JOptionPane.showMessageDialog(null, sveiciens(), "Picerija", JOptionPane.INFORMATION_MESSAGE);
    				}
    				break;
    				
    			case "Apskatit jau izveidotas picas":
    				StringBuilder stringBuilder = new StringBuilder("Picas:\n");
    			    try {
    			        BufferedReader reader = new BufferedReader(new FileReader("picas.txt"));
    			        String line;
    			        while ((line = reader.readLine()) != null) {
    			            stringBuilder.append(line).append("\n");
    			        }
    			        reader.close();
    			        if (stringBuilder.length() == 6) {
    			            JOptionPane.showMessageDialog(null, "Nav vēl veikti pasūtījumi", null, JOptionPane.ERROR_MESSAGE);
    			        } else {
    			            JOptionPane.showMessageDialog(null, stringBuilder.toString(), "Pasūtījumi", JOptionPane.INFORMATION_MESSAGE);
    			        }
    			    } catch (Exception e) {
    			        JOptionPane.showMessageDialog(null, "Kļūda ielādējot iepriekšējos pasūtījumus", "error", JOptionPane.ERROR_MESSAGE);
    			    }
    			}
			
    		}while(!izvele.equalsIgnoreCase("Apturet"));
    }
}