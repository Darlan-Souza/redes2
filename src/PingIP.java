
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import tp2.redes.EnderecoFora;

public class PingIP {

    public static EnderecoFora enderecoOff = new EnderecoFora();
    int pktSend = 0;
    int pktEntregue = 0;
    int pktPerdidos = 0;
    int timeRelatorio = 30;
    //boolean static isOnline = true;
    int cont = 0;

    public static void runSystemCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            
            // String s = "";
            // reading output stream of the command
            String s;
            long start;
            long end;
            String frase = "";
            while (true) {
                start = System.currentTimeMillis();
                s = inputStream.readLine();
                System.out.println(s);
                end = System.currentTimeMillis() - start;
                if (end / 1000 > 5) {
                    System.out.println("Ficou off: " + end / 1000 + " segundos");
                    enderecoOff.esteveOff(end / 1000);
                    
                    frase = "Maior tempo off: " + enderecoOff.getBigTimeOff()+" segundos"
                            + "\nVezes off: "+enderecoOff.getVezesOff()+
                            "\nTotal de tempo off: "+enderecoOff.getTotalTimeoff()+" segundos";
                    escritor("relatorio.txt", frase);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void escritor(String path, String linha) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append(linha + "\n\n\n");
        
        buffWrite.close();
    }

    public static void main(String[] args) {
        Frame parent = null;
        testeredesii.configuracoes conf = new testeredesii.configuracoes(parent, true);
        conf.setVisible(true);
        

        String ip = conf.ip;
        runSystemCommand("ping " + ip);

    }
}
