// implement a stack that supports a max operation, uses O(n) space in addition to the data storeage, and has O(1) operation time.

// solution: have a stack of max elements. when you pop, if your element equals the peek() from the max stack, pop it off.


public class P1 {

	private static class Stack {
		
		public Integer length ;
		private Integer[] data ;

		public Stack() {
			length = 0 ;
			data = new Integer[5] ;
		}

		private void allocMoreData() {
		    Integer[] newArray = new Integer[data.length + 5];
		    System.arraycopy(data, 0, newArray, 0, data.length);
		    data = newArray;
		}

		public  void push(Integer x) {
			if ( length  >=  data.length) {
				allocMoreData() ;
			}
			data[length] = x;
			length += 1 ;
			
		}

		public Integer pop() throws RuntimeException {
			if (length <= 0 ) {
				throw new RuntimeException("empty") ;
			}
			length =  length - 1 ;
			return data[length] ;
		}


	}

	private static class MaxStack extends Stack {
		Stack max ;
		
		public MaxStack() {
			super() ;
			max = new Stack() ;
		}

		public void push(Integer x) {
			super.push(x) ;
			if (max.length == 0) {
				max.push(x) ;
				return ;
			}

			Integer currMax = max.pop() ;
			max.push(currMax);

			if (x >= currMax) {
				max.push(x) ;
			}
		}

		public Integer pop() throws RuntimeException {
			Integer x = super.pop() ;
			Integer m = max.pop() ;
			if (x < m) {
				max.push(m) ;
			}
			return x ;
		}

		public Integer max() {
			Integer m = max.pop() ;
			max.push(m) ;
			return m ;
		}

		

	}

	public static void main(String[] args) {
		
		MaxStack m = new MaxStack() ;
		m.push(1) ;
		System.out.println(m.max() == 1 ) ;
		m.push(2) ;
		System.out.println(m.max() == 2) ;
		System.out.println(m.pop() == 2) ;
		System.out.println(m.max() == 1) ;
		m.push(73);
		m.push(1) ;
		System.out.println(m.max() == 73) ;
		System.out.println(m.pop() == 1) ;
		System.out.println(m.max() == 73) ;
	}
}

