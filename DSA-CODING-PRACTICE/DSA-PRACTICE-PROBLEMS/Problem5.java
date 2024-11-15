import java.math.BigInteger;
import java.util.Scanner;

public class Problem5{
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Factorial of " + number + " is:\n" + factorial(number));

        scanner.close();
    }
}
