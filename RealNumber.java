public class RealNumber extends Number{
    private double value;
  
    public RealNumber(double v){
      value = v;
    }
  
    public double getValue(){
      return value;
    }
  
    public String toString(){
      return ""+value;
    }
    //---------ONLY EDIT BELOW THIS LINE------------
  
    public RealNumber add(RealNumber other){
      RealNumber temp = new RealNumber(0.0);
      temp.value = value + other.value;
       return temp;
    }
  
    /*
    *Return a new RealNumber that has the value of:
    *the product of this and the other
    */
    public RealNumber multiply(RealNumber other){
          RealNumber temp = new RealNumber(0.0);
          temp.value = value * other.value;
          return temp;
    }
  
    /*
    *Return a new RealNumber that has the value of:
    *this divided by the other
    */
    public RealNumber divide(RealNumber other){
      if(other.value == 0){
        throw new ArithmeticException(other.value + " cannot be equal to zero");
      }
          RealNumber temp = new RealNumber(0.0);
          temp.value = value / other.value;
          return temp;
    }
  
    /*
    *Return a new RealNumber that has the value of:
    *this minus the other
    */
    public RealNumber subtract(RealNumber other){
      RealNumber temp = new RealNumber(0.0);
      temp.value = value - other.value;
      return temp;
    }
  }