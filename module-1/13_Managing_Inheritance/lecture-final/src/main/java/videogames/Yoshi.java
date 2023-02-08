package videogames;
import com.techelevator.farm.Egg;

public class Yoshi extends Character{
    @Override
    public void jump() {
        System.out.println("Flutters away");
        Egg egg = new Egg();
    }
}
