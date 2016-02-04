/**
 * 
 */
package project1;

import bag.Bag; 
import bag.BagInterface;
import CS2114.TextShape; 
import java.util.Random;
import CS2114.Window; 
import CS2114.Button; 
import CS2114.WindowSide;

/**
 * @author Mostafa Elemary
 *
 */
public class DisplayCollection {

    public BagInterface <String> itemBag;
    public static final String[] STRINGS = {"red circle", "blue circle", "red square", "blue square"};
    
    public DisplayCollection()
    {
        this.itemBag = new Bag<>();
        
        Random random = new Random();
        int count = random.nextInt(11) + 5;
        
        for(int i = 0; i < count; i++)
        {
            this.itemBag.add(DisplayCollection.STRINGS[random.nextInt(4)]);
        }
        
    }

    public BagInterface<String> getItemBag() {
        
        return this.itemBag;
    }    
}
