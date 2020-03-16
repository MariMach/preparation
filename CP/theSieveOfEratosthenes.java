import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class theSieveOfEratosthenes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arrnp = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
			for(int j = 2; j<= n; j++) {
				int np = n;
				while(n%j == 0) {
					arrnp.add(j);
					n/=j;
				}
			}		
		for(int i = 0; i <arrnp.size(); i++) {
			System.out.println(arrnp.get(i));
		}
	}

}
