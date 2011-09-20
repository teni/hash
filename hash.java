
public class hash {
	
	int m; // the tablesize
	double  A = (Math.sqrt(5) - 1 ) /2; // A in the multiplicative algorithm.
	public hash(){
		m = 100;
		// the default arg constructor with a default table size of m
		// with slots 0 to m-1.
	}
	
	public hash(int tablesize){
		m = tablesize;
	}

	// This is the hash class and it will implement 
	// the multiplicative and division algorithms for hashing
	
	public int hash_div(int key){
		return key % m;
	}
	public int hash_mul(int key){
		double h = (key*A )%1;
		h = Math.floor(m*h);
		return (int) h;
	}
	
	
	
}
