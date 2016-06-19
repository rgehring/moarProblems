//Find the sum of all the multiples of 3 or 5 below 1000.

// brute force - iterate all numbers, test if multiples, and add if so. This is O(1000).
// factorization approach. 3(1+2+3+4+5+6+...+FLOOR(1000/3) + 5(1+2+...+FLOOR(1000/3) - 15(1+2+...+FLOOR(1000/15)))
// we know the sum of n consecutive integers is given by n(n+1)/2
// so we can solve in O(1)


class P1 {

    public static Integer calcSubtotal(int n) {
    	Integer out = (n * (n+1))/2 ;
    	return out ;
    }

	public static Integer run(int n) {
		Integer threesN = n / 3;
		Integer fivesN = n / 5 ;
		Integer fifteensN = n / 15   ;
		Integer out = 3*P1.calcSubtotal(threesN) 
			+ 5*P1.calcSubtotal(fivesN)
			- 15*P1.calcSubtotal(fifteensN)
		;

		return out ;
	}

	// find all multiples of 3 and 5
	public static void main(String[] args) {
		int n = 999;
		System.out.println(P1.run(n));
	}
}