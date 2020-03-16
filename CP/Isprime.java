
public class Isprime {
	public static void main(String[] args) {
		int n = 88;
		for(int i = 2; i*i < n; i++) {
			if(n%i == 0) {
				n /= i;
			}
		}
		System.out.println(n);
	}

}
