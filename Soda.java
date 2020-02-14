/**
* Soda class for Project 1 and Project 2, CISY 254 Data Structures
* @author Sohan Patel
*/
public class Soda implements Comparable<Soda>{

 private String sodaName;

 private double sodaPrice;

 private int sodaCalories;
 /**
 * Constructor
 * @param initalPartName value for sodaName field
 * @param initalPrice value for sodaPrice field
 * @peram initalCalories value for sodaCalolires field
 */
 public Soda(String initalSodaName, double initalPrice, int initalCalories )
 {
 sodaName = initalSodaName;
 sodaPrice = initalPrice;
 sodaCalories = initalCalories;
 }
 /**
 * getSodaName method returns value from sodaName field
 * @return value from sodaName field
 */
 public String getSodaName()
 {
 return sodaName;
 }
 /**
 * getSodaPrice method returns value in sodaPrize field
 * @return value in sodaPrice field
 */
 public double getSodaPrice()
 {
 return sodaPrice;
 }
 
  /**
 * getSodaCalories method returns value in sodaCalories field
 * @return value in sodaCalories field
 */
 public int getSodaCalories()
 {
 return sodaCalories;
 }
 /**
 * setSodaName sets a new value for sodaName field
 * @param newSodaName new value for sodaName field
 */
 public void setSodaName(String newSodaName)
 {
 sodaName = newSodaName;
}


 /**
 * setSodaPrice method sets a new value in sodaPrice field
 * @param newSodaPrice new value for sodaPrice field
 */
 public void setSodaPrice(double newSodaPrice)
 {
 sodaPrice = newSodaPrice;
 }
  /**
 * setSodaCalories method sets a new value in sodaCalories field
 * @param newSodaPrice new value for sodaCalories field
 */
 public void setSodaCalories(int newSodaCalories)
 {
 sodaCalories = newSodaCalories;
 }
public int compareTo(Soda anotherSoda)
{
    if (!(anotherSoda instanceof Soda))
            throw new ClassCastException("A Car object expected.");

        if (getSodaPrice() <anotherSoda.getSodaPrice())
            return -1;
        else if (getSodaPrice() > anotherSoda.getSodaPrice())
            return 1;
        else
            return sodaName.compareToIgnoreCase(anotherSoda.getSodaName());
    }


/**
 *   if (!(anotherCar instanceof Car))
            throw new ClassCastException("A Car object expected.");

        if (getSodaName() < anotherSoda.getSodaName())
            return -1;
        else if (getSodaPrice() > anotherSoda.getSodaPrice())
            return 1;
        else
            return make.compareToIgnoreCase(anotherSoda.getPrice());
    }
 * 
 * 
 * 
 * 
 * 
 */
 /**
      The equals method compares this Soda to another Object .
      @param The object to test for equality.
      @return boolean with result of test for equality.
   */
public boolean equals(Object obj){

if (!(obj instanceof Soda))
  return false;
Soda in = (Soda)obj;
if(in.getSodaName().equals(sodaName) && in.getSodaCalories() == sodaCalories && in.getSodaPrice() == sodaPrice){
  return true;
}

return false;

}
}

