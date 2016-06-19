// By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

class P2 {

	public static void main(String[] args) {
		
		Integer f_n_minus_1 = 1 ;
		Integer f_n = 1;
		Integer temp = 0 ;
		Integer total = 0 ;
		while (f_n < 4000000) {
			temp = f_n_minus_1 ;
			f_n_minus_1 = f_n ;
			f_n = f_n + temp ;

			if (f_n % 2 == 0) {
				total = total + f_n ;
			}
		}
		System.out.println(total) ;

	}
}
