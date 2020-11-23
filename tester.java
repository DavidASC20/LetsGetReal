public class tester {
    private static int gcd(int a, int b){
        int temp = Math.min(a, b);
        int tempNum = 0;
        for(int i = 1; i <= temp; i++){
            if(a % i == 0 && b % i == 0){
                tempNum = i;
            }
        }return tempNum;
      }
    public static void main(String[] args) {
        RealNumber x = new RealNumber(0.03);
        RealNumber y = new RealNumber(0.005);
        System.out.println(x.equals(y));
        System.out.println(x.add(y));
        RationalNumber bruh = new RationalNumber(3, 5);
        System.out.println(bruh.getValue());
        System.out.println(bruh.getNumerator());
        System.out.println(bruh.getDenominator());
        System.out.println(gcd(210,45));
    }
}
