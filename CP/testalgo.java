package maths;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
class testalgo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n;
        
        while(true){
            try{
                n = Long.parseLong(br.readLine());
                bw.write(Long.toString(n,2)+"\n");
            } catch(NumberFormatException ex){
                break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}