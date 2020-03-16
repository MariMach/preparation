import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ABCDE {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = 0;
		String word = "", line1 = "", line2 = "", line3 = "", line4 = "", line5 = "";
		t = Integer.parseInt(br.readLine());
		word = br.readLine();
		for (int i = 0; i < t; i++) {
			if (word.charAt(i) == 'A') {
				line1 = line1 + "***";
				line2 = line2 + "*.*";
				line3 = line3 + "***";
				line4 = line4 + "*.*";
				line5 = line5 + "*.*";

			} else if (word.charAt(i) == 'B') {
				line1 = line1 + "***";
				line2 = line2 + "*.*";
				line3 = line3 + "***";
				line4 = line4 + "*.*";
				line5 = line5 + "***";

			} else if (word.charAt(i) == 'C') {
				line1 = line1 + "***";
				line2 = line2 + "*..";
				line3 = line3 + "*..";
				line4 = line4 + "*..";
				line5 = line5 + "***";

			} else if (word.charAt(i) == 'D') {
				line1 = line1 + "***";
				line2 = line2 + "*.*";
				line3 = line3 + "*.*";
				line4 = line4 + "*.*";
				line5 = line5 + "***";

			} else if (word.charAt(i) == 'E') {
				line1 = line1 + "***";
				line2 = line2 + "*..";
				line3 = line3 + "***";
				line4 = line4 + "*..";
				line5 = line5 + "***";

			} else {
				line1 = line1 + "";
				line2 = line2 + "";
				line3 = line3 + "";
				line4 = line4 + "";
				line5 = line5 + "";
			}
		}

		bw.write(line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5);
		bw.flush();
		bw.close();
		br.close();
	}

}
