import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

public class BearTest{
  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    salmon = new Salmon(); 
    human = new Human();
    chicken = new Chicken();
  }

  @Test
  public void hasName() {
    assertEquals( "Baloo", bear.getName()); 
  }

  @Test
  public void bellyStartsEmpty() {
    assertEquals( 0, bear.foodCount());
  }

  @Test
  public void canEatSalmon() {
    bear.eat(salmon);
    assertEquals(1, bear.foodCount());
  }

  @Test 
  public void canEatChicken(){
    bear.eat(chicken);
    assertEquals(1, bear.foodCount());
  }

  @Test 
  public void canEatHuman() {
    bear.eat(human);
    assertEquals(1, bear.foodCount());
  }

  // @Test
  // public void bellyIsFull(){
  //   for(int i = 0; i<5; i++){
  //     bear.eat(salmon);
  //   }
  //   assertEquals(bear.bellyFull(), true);
  // }

  // @Test
  // public void canNotEatSalmonWhenBellyFull(){
  //   for(int i = 0; i<10; i++){
  //     bear.eat(salmon);
  //   }
  //   assertEquals(bear.foodCount(), 5);
  // }

  @Test
  public void shouldEmptyBellyAfterSleeping() {
    bear.eat(salmon);
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }

  @Test
  public void canThrowUp(){
    bear.eat(salmon);
    Edible food = bear.throwUp(); 
    assertNotNull(food);
  }

  @Test
  public void canGetSalmonBack(){
    bear.eat(salmon);
    Edible food = bear.throwUp();
    Salmon original = (Salmon) food;
    assertEquals("swim like a fish", original.swim());
  }

  @Test 
  public void edibleHumanCanSwim(){
    bear.eat(human);
    Edible food = bear.throwUp();
    String result = food.swim();
    assertEquals("swim like a dog", result);
  }
  
  @Test
  public void chickenCanCluck(){
    assertEquals("cluck!", chicken.speak());
  }

  @Test 
  public void canGetChickenBack(){
    bear.eat(chicken);
    Edible food = bear.throwUp();
    Chicken original = (Chicken) food;
    assertEquals(original.speak(), "cluck!");
  }

  @Test
  public void chickenHasNutritionValue(){
    bear.eat(chicken);
    Edible food = bear.throwUp();
    int nutritionValue = food.nutritionValue();
    assertEquals(10, nutritionValue);
  }

  @Test
  public void totalValueInBelly(){
    bear.eat(chicken);
    bear.eat(human);
    bear.eat(salmon);
    int totalValue = bear.totalNutrition();
    assertEquals(45, totalValue);
  }


}










