
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

	public static void main(String[] argv) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int k = 0; k < n; k++) {

			br.readLine();
			String c = br.readLine();

			char tab[] = c.toCharArray();

			int i = 0, l, flag = 0;

			while (i < tab.length - 2) {
				l = i;
				if (tab[i] == 'A' && tab[i + 1] == 'K' && tab[i + 2] == 'A') {
					tab[i] = '*';
					tab[i + 1] = '*';
					tab[i + 2] = '*';
					l = i + 3;
					while (l + 1 < tab.length && tab[l] == 'K' && tab[l + 1] == 'A') {
						tab[l] = '*';
						tab[l + 1] = '*';
						l = l + 2;
					}
					i = l;
				} else {
					i = l + 1;
					l++;
				}
			}
			String resu = "";
			for (int m = 0; m < tab.length; m++) {

				if (tab[m] != '*') {

					// System.out.println(new String(tab));
					// System.out.print((char)tab[m]);
					resu += Character.toString(tab[m]);
					flag = 1;
				}

			}
			if (flag == 0)
				System.out.println("EMPTY");
			else
				System.out.println(resu);

		}

	}

}