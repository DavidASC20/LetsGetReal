public class RationalNumber extends Number{

  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored! 
    if(deno == 0 || nume == 0){
      numerator = 0;
      denominator = 1;
    }numerator = nume;
    denominator = deno;
    reduce();
    if(numerator < 0 && denominator < 0){
      numerator = numerator * -1;
      denominator = denominator * -1;
    }if(numerator > 0 && denominator < 0){
      numerator = numerator * -1;
      denominator = denominator * -1;
    }
  }

  public double getValue(){
    if(denominator == 0){
      return numerator;
    }else{
    return numerator / denominator;
    }
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return this.numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return this.denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber temp = new RationalNumber(0, 0);
    temp.numerator = denominator;
    temp.denominator = numerator;
    return temp;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if(numerator == other.numerator && denominator == other.denominator){
      return true;
    }return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
    private static int gcd(int a, int b){
      int x = Math.abs(a);
      int y = Math.abs(b);
        int temp = Math.min(x, y);
        int tempNum = 1;
        for(int i = 1; i <= temp; i++){
            if(x % i == 0 && y % i == 0){
                tempNum = i;
            }
        }return tempNum;
      }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if(denominator == 0){
      denominator = 1;
      numerator = 0;
    }else{
    int temp = gcd(numerator, denominator);
    numerator = numerator / temp;
    denominator = denominator / temp;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber temp = new RationalNumber(0, 0);
    temp.numerator = this.getNumerator() * other.getNumerator();
    temp.denominator = this.getDenominator() * other.getDenominator();
    temp.reduce();
    return temp;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber temp = new RationalNumber(0, 0);
    if(other.getNumerator() == 0 || other.getDenominator() == 0){
      temp.numerator = 0;
      temp.denominator = 0;
    }else{
    temp.numerator = this.getNumerator() * other.getDenominator();
    temp.denominator = this.getDenominator() * other.getNumerator();
  }temp.reduce();
    return temp;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other) {
    int denom = this.getDenominator()*other.getDenominator();
    RationalNumber sum = new RationalNumber(
    (this.getNumerator()*other.getDenominator())+
    (other.getNumerator()*this.getDenominator()), denom);
    return sum;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int denom = this.getDenominator()*other.getDenominator();
    RationalNumber temp = new RationalNumber(this.getNumerator()*other.getDenominator() -
    other.getNumerator()*this.getDenominator(), denom);
    return temp;
  }

  
} 