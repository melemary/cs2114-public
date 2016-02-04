/**
 * 
 */
package collections;

/**
 * @author Mostafa
 *
 */
public class MovieCollectionTest extends student.TestCase {
    
    public void testAdd()
    {
        String testString = "Hello!";
        
        if(!container.contains(testString))
            assertTrue(container.add(testString));
        else
            assertFalse(container.add(testString));
    }
    
    public void testContains()
    {
        assertFalse(container.contains("apple"));
        container.add("banana");
        assertTrue(container.contains("banana"));
        assertFalse(container.contains("orange"));
    }
    
    public void testIsEmpty()
    {
        container.add("banana");
        assertFalse(container.isEmpty());
        assertTrue(containerTwo.isEmpty());
    }
    
    public void testSize()
    {
        assertEquals(container.size(),0);
        container.add("strawberry");
        assertEquals(container.size(),1);
        container.add("strawberry");
        assertEquals(container.size(),1);
        container.remove();
        assertEquals(container.size(),0);
    }
    
    public void testExpandCapacity()
    {
        for(int i = 0; i < 10; i++)
        {
            container.add("String #" + i);
        }
        container.add("Overflowing String");
        assertEquals(container.capacity(),20);
    }

}
