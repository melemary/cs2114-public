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
public class DisplayCollectionTest extends student.TestCase {
    
    public void setUp()
    {
        // class does not contain any fields; intentionally left blank
    }
    
    public void testBagContents()
    {
        DisplayCollection testCollection = new DisplayCollection();
        
        BagInterface<String> holder = testCollection.getItemBag();
                
        while(!holder.isEmpty())
        {
            String testStatement = holder.remove();
            assertTrue(testStatement == DisplayCollection.STRINGS[0] || 
                    testStatement == DisplayCollection.STRINGS[1] || 
                    testStatement == DisplayCollection.STRINGS[2] ||
                    testStatement == DisplayCollection.STRINGS[3]);
        }
        
    }
    
    public void testBagSize()
    {
        for(int i = 0; i < 20; i++)
        {
            DisplayCollection testCollection = new DisplayCollection();
            
            BagInterface<String> holder = testCollection.getItemBag();
            
            assertTrue(holder.getCurrentSize() <= 15);
            assertTrue(holder.getCurrentSize() >= 5);
        }
        
    }

}
