class EuclideanAlgorithm {
    public static void main(String args[]) {
        int num1 = 48;
        int num2 = 36;

        int gcd = findGCD(num1, num2);
        System.out.println("The GCD of" + " " + num1 + " " + "and" + " " + num2 + " " + "is:" + gcd);
    }

    public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) {
            return b;
        }

        while (a != 0) {
            int remainder = b % a;
            b = a;
            a = remainder;
        }

        return b;
    }
}
