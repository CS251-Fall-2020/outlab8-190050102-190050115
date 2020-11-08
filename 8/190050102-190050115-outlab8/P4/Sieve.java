import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve{

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n;
        n = sc.nextInt();

        Boolean [] prime = new Boolean[n+1];
        Arrays.fill(prime, true);

        IntStream.range(2, (int)(Math.sqrt(n)+1)).boxed().collect(Collectors.toList()).stream()
            .forEach(x->{
                if(prime[x]==true){
                    IntStream.range(x, n/x+1).boxed().collect(Collectors.toList()).stream()
                        .forEach(y->{
                            prime[x*y] = false;
                        });
                }
            });

        IntStream.range(2, n+1).boxed().collect(Collectors.toList()).stream()
            .forEach(x->{
                if(prime[x] == true){
                    System.out.printf("%d ", x);
                }
            });
        
        System.out.println("");

        sc.close();
    }
}