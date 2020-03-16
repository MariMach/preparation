	import java.io.*;
	import java.util.*;
public class maxzeros {



		public static void main(String[] args) throws Exception {
			int cnt=0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine()); 
			StringTokenizer st1 = new StringTokenizer(br.readLine());		
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			ArrayList<String> arr = new ArrayList<String>();
			for(int i=0;i<n;i++) {
				long a = Long.parseLong(st1.nextToken());
				long b = Long.parseLong(st2.nextToken());
				if(a == 0 && b == 0)	cnt++;
				if(a != 0) {			
					String stt = String.format("%.30f", (double)(-b)/(double)a);
					arr.add(stt);
					//System.out.println(stt);
				}
				
			}
			
			int tailleMax=0;
			int taille=0;
			if(arr.size()!=0) {
				tailleMax = 1;
				taille = 1;
				Collections.sort(arr);
				String d1 = arr.get(0);
				for(int i=1;i<arr.size();i++) {
					if(arr.get(i).equals(arr.get(i-1))) {
						taille++;
					}else {
						taille = 1;
					}
					tailleMax = Math.max(tailleMax, taille);
				}
			}
			tailleMax+=cnt;
			System.out.println(tailleMax);
		}
		
	
}
