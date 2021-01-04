public class RationalNumber extends Number {
  private int numerator, denominator;

  public RationalNumber(int nume, int deno) {
    //super(((double) nume) / deno);
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else if (nume == 0) {
      numerator = 0;
      denominator = 1;
    }
    else if (deno < 0) {
      numerator = nume * -1;
      denominator = deno * -1;
      this.reduce();
    }
    else {
      numerator = nume;
      denominator = deno;
      this.reduce();
    }
  }

  public double getValue() {
    return (((double)numerator)/denominator);
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public RationalNumber reciprocal() {
    RationalNumber flip = new RationalNumber(
    this.getDenominator(), this.getNumerator());
    return flip;
  }

  public boolean equals(RationalNumber other) {
    boolean answer = false;
    if (this.getNumerator() == other.getNumerator() &&
    this.getDenominator() == other.getDenominator()) {
      answer = true;
    }
    return answer;
  }

  public String toString() {
    String newstr = "";
    if (numerator == 0) newstr = "0";
    else if (denominator == 1) newstr = newstr + numerator;
    else {
      newstr = numerator+"/"+denominator;
    }
    return newstr;
  }

  private static int gcd(int a, int b) {
    int answer = 0;
    if (a<0 || b<0) {
      a = Math.abs(a);
      b = Math.abs(b);
      if (a>=b) {
        int remainder = a%b;
        while (remainder != 0) {
          a = b;
          b = remainder;
          remainder = a%b;
        }
        answer = b;
      }
      else {
        int remainder = b%a;
        while (remainder != 0) {
          b = a;
          a = remainder;
          remainder = b%a;
        }
        answer = a;
      }
    }
    else {
      if (a>=b) {
        int remainder = a%b;
        while (remainder != 0) {
          a = b;
          b = remainder;
          remainder = a%b;
        }
        answer = b;
      }
      else {
        int remainder = b%a;
        while (remainder != 0) {
          b = a;
          a = remainder;
          remainder = b%a;
        }
        answer = a;
      }
    }
    return answer;
  }

  private void reduce() {
    int c = gcd(this.getNumerator(), this.getDenominator());
    numerator = numerator / c;
    denominator = denominator / c;
  }

  public RationalNumber multiply(RationalNumber other) {
    RationalNumber product = new
    RationalNumber(this.getNumerator()*other.getNumerator(),
    this.getDenominator()*other.getDenominator());
    return product;
  }

  public RationalNumber divide(RationalNumber other) {
    RationalNumber quotient = new
    RationalNumber(this.getNumerator()*other.getDenominator(),
    this.getDenominator()*other.getNumerator());
    return quotient;
  }

  public RationalNumber add(RationalNumber other) {
    int denom = this.getDenominator()*other.getDenominator();
    RationalNumber sum = new RationalNumber(
    (this.getNumerator()*other.getDenominator())+
    (other.getNumerator()*this.getDenominator()), denom);
    return sum;
  }

  public RationalNumber subtract(RationalNumber other) {
    int denom = this.getDenominator()*other.getDenominator();
    RationalNumber diff = new RationalNumber(
    (this.getNumerator()*other.getDenominator())-
    (other.getNumerator()*this.getDenominator()), denom);
    return diff;
  }

}