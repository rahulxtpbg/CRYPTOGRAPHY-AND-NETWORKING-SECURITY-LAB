class AdvancedEuclideanAlgorithm {
    public static void main(String args[]) {
        int num1 = 48;
        int num2 = 36;

        int[] result = findGCD(num1, num2);
        int gcd = result[0];
        int coeffA = result[1];
        int coeffB = result[2];
        System.out.println("The GCD of" + " " + num1 + " " + "and" + " " + num2 + " " + "is:" + gcd);
        System.out.println("The coefficients are:" + coeffA + "," + coeffB);
    }

    public static int[] findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        int prevCoeffA = 1;
        int prevCoeffB = 0;
        int coeffA = 0;
        int coeffB = 1;

        if (a == 0) {
            return new int[] { b, 0, 1 };
        }

        while (a != 0) {
            int quotient = b / a;
            int remainder = b % a;
            b = a;
            a = remainder;

            int temp = coeffA;
            coeffA = prevCoeffA - quotient * coeffA;
            prevCoeffA = temp;

            temp = coeffB;
            coeffB = prevCoeffB - quotient * coeffB;
            prevCoeffB = temp;
        }

        return new int[] { b, coeffA, coeffB };
    }
}
