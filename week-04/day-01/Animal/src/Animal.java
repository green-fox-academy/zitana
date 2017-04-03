public class Animal {
  //  Every animal has a hunger value, which is a whole number
//  Every animal has a thirst value, which is a whole number
//  when creating a new animal object these values are created with the default 50 value
//  Every animal can eat() which decreases their hunger by one
//  Every animal can drink() which decreases their thirst by one
//  Every animal can play() which increases both by one
  public int hunger;
  public int thirst;
  
  public Animal() {
    hunger = 50;
    thirst = 50;
  }
  
  public void eat() {
    this.hunger -= 1;
  }
  
  public void drink () {
    this.thirst -= 1;
  }
  
  public void play () {
    this.hunger += 1;
    this.thirst += 1;
  }
  
  @Override
  public String toString() {
    return "Animal{" +
            "hunger=" + hunger +
            ", thirst=" + thirst +
            '}';
  }
}
