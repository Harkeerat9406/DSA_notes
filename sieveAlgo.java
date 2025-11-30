/* SIMPLE SIEVE ALGORITHM
 *  This algorithm is used to find the primes upto n. Instead of checking every number for prime, we mark out the multiples of prime numbers.
 *  We make an array of size n+1 and set arr[0]=arr[1]= false and all the values from 2 to n as true.
 *  Then we run a for loop from 0 to i*i<=n.
 */

// import java.util.Arrays;
// import java.util.Scanner;

// public class sieveAlgo
// {
//     public static void main(String[] args)
//     {
//         Scanner sc= new Scanner(System.in);
//         int n= sc.nextInt();
//         boolean isPrime[]= new boolean[n+1];
//         Arrays.fill(isPrime, true);
//         isPrime[0] = isPrime[1] = false;
//         int count = n-1;

//         for(int i=2; i*i<=n; i++)     // i*i because all numbers above √n are passed by smaller numbers
//         {
//             if(isPrime[i])
//             {
//                 for(int multiple=i*i; multiple<=n; multiple+=i) //i*i as all previous multiples of i are already passed by smaller primes
//                 {
//                     if(isPrime[multiple])            // We check if multiple is already not marked false. Like 12 comes for 2 and 3 both
//                     {
//                         isPrime[multiple]= false;
//                         count--;
//                     }
//                 }
//             }
//         }

//         for(int i=0; i<=n; i++)
//         {
//             if(isPrime[i])
//             System.out.print(i+"\t");
//         }
//         sc.close();
//     }
// }

/* There is a way to optimize the above code by removing the check for all even numbers>2
    We will store 0 at index=0 and make boolean index of len= n/2 + n%2
    num= index*2 + 1
    index= num/2
 */
// import java.util.Arrays;

// public class sieveAlgo {
//     public static void main(String[] args) {
//         int n = 100;
//         int len = n / 2 + n % 2;
//         boolean[] isPrime = new boolean[len];
//         Arrays.fill(isPrime, true);

//         if (len > 0)
//             isPrime[0] = false;

//         for (int i = 1; i <= len; i++) {
//             if (isPrime[i]) {
//                 int p = 2 * i + 1;          // actual odd prime
//                 int start = (p * p) / 2;    // index of the square of prime number. Example- when p=3,  9 will be at index 4
//                 for (int j = start; j < len; j += p) {
//                     isPrime[j] = false;
//                 }
//             }
//         }

//         // (Handle 2 separately when you output or count)
//         // Example printing:
//         if (n >= 2)
//             System.out.print(2 + " ");
//         for (int i = 1; i < len; i++) {
//             if (isPrime[i])
//                 System.out.print((2 * i + 1) + " ");
//         }
//     }

// }




/*  There is another better version of simple sieve called segmented sieve.
    The idea is that for a number n, all composite numbers<n are multiples of primes<√n. So we find all primes upto √n and then mark 
    multiples of these primes in the give range (L,R)

 *  To find the first multiple of a prime in the range(L,R), we use the formula     start= max(p*p, ((L+p-1)/p)*p)
 */