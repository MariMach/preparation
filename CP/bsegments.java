import java.io.*;
import java.util.*;
import static java.lang.System.out;
class bsegments {
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               //Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(br.readLine());
       // int t = sc.nextInt();
        for(int e = 0; e < t; e++){
            int n = Integer.parseInt(br.readLine());
            //int n = sc.nextInt();
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                //arr[i] = sc.nextInt();
            }
            int[] left = new int[n];
            int[] right = new int[n];
            for(int i = 1; i < n-1; i++) {
                 for(int j=i-1, b = i + 1; (j >= 0) && (b < n); j--, b++){
                    if(arr[j+1] >= arr[j]){
                        left[i]++;
                    } else {
                        break;
                    }
              // }
                // for(int b=i+1;b<n;b++) {
                    if(arr[b]<arr[b-1]) {
                        right[i]++;
                    } else {
                        break;
                    }
                }
            }
            int count = 0;
            for(int i=0; i < n ;i++) {
                int x = Math.min(left[i],right[i]);
                count+=x;
            }
            out.println(count);
        }
    }
}
