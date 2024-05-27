package davids;

import javax.swing.JOptionPane;

public class Necajevs_pica {
    public static void main(String[] args) {
        String izvele;
        String darbibas[] = {"Nopirkt picu", "Pasutit picu", "Aiziet", "Apskatit jau izveidotas picas", "Apturet"};
        
        String vards = "";
        String adrese = "Uz vietas";
        
        double izmersCena = 0;
        double merceCena = 0;
        double piedevasCena = 0;
        double summa = 0;
        
        String izmers = "";
        int izmeri;
        String merce = "";
        String merces[] = {"kecupa", "kiploku", "pesto"};
        String piedevas = "";
        String piedevasM[] = {};
        
        String siers = "";
        
        boolean majas = false;
        
        do {
            izvele = (String)JOptionPane.showInputDialog(null, "Darbibas izvele", null, JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
            switch (izvele) {
                case "Nopirkt picu":
                    if (!majas) {
                        do {
                            vards = (String)JOptionPane.showInputDialog(null, "Ievadi savu vardu", null, JOptionPane.QUESTION_MESSAGE);
                        } while (vards.isBlank());
                        
                        izmeri = JOptionPane.showOptionDialog(null, "Cik lielu picu velies?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, new String[] {"20cm", "30cm", "50cm"}, null);
                        switch (izmeri) {
                            case 0:
                                izmers = "20cm";
                                izmersCena = 5.99;
                                break;
                            case 1:
                                izmers = "30cm";
                                izmersCena = 6.99;
                                break;
                            case 2:
                                izmers = "50cm";
                                izmersCena = 8.99;
                                break;
                        }
                        
                        merce = (String)JOptionPane.showInputDialog(null, "Izvelies picai merce", null, JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
                        switch (merce) {
                            case "kecupa":
                                merceCena = 0.99;
                                break;
                            case "kiploku":
                                merceCena = 1.49;
                                break;
                            case "pesto":
                                merceCena = 1.99;
                                break;
                        }
                        
                        piedevas = (String)JOptionPane.showInputDialog(null, "Ievadi piedevas (atdala ar komatu)", null, JOptionPane.QUESTION_MESSAGE);
                        if (!piedevas.isBlank()) {
                            String[] piedevasList = piedevas.split(",");
                            piedevasCena = piedevasList.length * 0.5;
                        }
                        
                        summa = izmersCena + merceCena + piedevasCena;
                        
                    }
                    break;
                    
                case "Pasutit picu":
                    break;
                    
                case "Aiziet":
                    break;
                    
                case "Apskatit jau izveidotas picas":
                    break;
                    
                case "Apturet":
                    break;
            }
        } while (!"Apturet".equals(izvele));
    }
}