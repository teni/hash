import java.util.ArrayList;


public class compare_hash {
	/**
	 * The idea is to allocate an array of size m.
	 * Generate keys...... may be multiples of 3 up to 10000
	 * or all primes below 1 million.
	 * 
	 *Then apply the hash to those keys....using chaining
	 *as collision resolution policy
	 *Meaning that the array will have each element as a list..
	 *
	 *We then measure the number of collisions...
	 *Number of empty slots
	 *And attempt to dump the entire table to give us an idea 
	 *of the distribution of filled slots within the hashtable.
	 *
	 * 
	 * 
	 */
	
	public void test(int num_of_keys , int m){
		hash hashobj = new hash(m);
		int [] keys = getKeys(num_of_keys);
		ArrayList[] hashTable_mul = new ArrayList[m];
		for ( int g = 0 ; g < hashTable_mul.length ; g++)
			hashTable_mul[g] = new ArrayList();
		
		ArrayList[] hashTable_div = new ArrayList[m];
		for ( int g = 0 ; g < hashTable_div.length ; g++)
			hashTable_div[g] = new ArrayList();
		
		
		for (int i = 0 ; i < keys.length; i++){
			// hash and store it in the hash table
			//System.out.println(hashobj.hash_mul(keys[i]));
			hashTable_div[hashobj.hash_div(keys[i])].add(keys[i]);
		}
		
		for (int i = 0 ; i < keys.length; i++){
			// hash and store it in the hash table
			//System.out.println(hashobj.hash_mul(keys[i]));
			hashTable_mul[hashobj.hash_mul(keys[i])].add(keys[i]);
		}
		System.out.println("\n\n\n\nHashtable using Multiplicative Algorithm");
		printTable(hashTable_mul);
		getTestDetails(hashTable_mul);
		System.out.println("\n\n\n\nHashtable using Division Algorithm");
		printTable(hashTable_div);
               getTestDetails(hashTable_div); 
		
	}
	public void printTable(ArrayList [] table){
	      System.out.println("Address : key") ;	
              for(int i = 0 ; i < table.length ; i++){
			System.out.printf("%d :", i);
			 // iterate over the chain
			  for (int j = 0 ; j < table[i].size(); j++){
				  System.out.printf(" -> %d",table[i].get(j));
			  }
			  System.out.printf("\n");
		}
	
}
   public void getTestDetails( ArrayList  [] map){
   int  empty = 0;
   int collisions =  0 ;
   	for(int i = 0 ; i <   map.length ; i++){
		int size =    map[i].size();
                  if (size == 0 ){
                   empty++;
                }
                else{ 
                collisions+= size -1;
                } 
			  }
      System.out.println("Number of collisions is "+collisions+ " and the number of empty slots is "+empty);

   }  


	public int [] getKeys(int HowMany){
		int [] keys = new int[HowMany];
		for (int i = 0 ; i < HowMany ; i++){
			keys[i] = i*3;
		}
		return keys;
		
	}
	public static void main (String [] i){
		compare_hash a = new compare_hash();
	

	        a.test(100, 80);
	}
	

}
