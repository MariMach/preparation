
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class F {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = 0;
		n = Integer.parseInt(br.readLine());
		String s = "CARScarsIuVEJxTXsUvOHhngyZKfAYmaqolMNtGQibwdjPrCpekFWzLaySBaPybRMgzYMynY";// letters in Martian
		String so = "UnilEPFLvpVZzBNtLSCubWmaocIYneAPqxDshRkMGgJfHrFUQTjXOwdPolyProgisawesome";
		HashMap<Character, Character> mapp = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			mapp.put(s.charAt(i), so.charAt(i));
		}
		String c = "", newc = "";
		StringBuilder r = new StringBuilder();
		StringTokenizer stc = new StringTokenizer(br.readLine());
		for (int j = 0; j < n; j++) {
			c = stc.nextToken();
			for (int k = 0; k < c.length(); k++) {
				if (mapp.containsKey(c.charAt(k))) {
					newc = newc + mapp.get(c.charAt(k));
				} else {
					newc = newc + c.charAt(k);
				}
			}
			r.append(newc);
			if (j < n - 1) {
				r.append(" ");
			}
			newc = "";
			// r = newc + " ";
		}
		bw.write(r.toString() + "\n");
		bw.flush();

		bw.close();
		br.close();
		return;
	}
	// vpVZzBNtL SCubWma ocIYneAPqxDs
}
