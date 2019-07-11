
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                        String s = inputStream.readLine();
                        int ultimoPing = 0;
                        String pingAtual = "0";
                        s = inputStream.readLine();
			while (true) { 
                                s = inputStream.readLine();
                                pingAtual = s.substring(s.indexOf("icmp") + 9,  s.indexOf("ttl=") - 1);
                                System.out.println(pingAtual);
				if (Integer.parseInt(pingAtual) > ultimoPing) {
                                    ultimoPing = Integer.parseInt(pingAtual);
                                    
                                    System.out.println(s);
				} else {
                                    long start = System.currentTimeMillis();
                                    System.out.println("asdasdas");
                                    while (s.contains("bytes of data")) {
                                        System.out.println("nulo");
                                        
                                    }
                                    long end = System.currentTimeMillis();
					//isOn = false;
					System.out.println(end);
					enderecoOff.esteveOff(end);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String ip = "10.0.103.18";
		runSystemCommand("ping -c 10" + ip);

	}
}