package somename;

public class prelab2 {

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true; //could be false; says should only return true if TWO objects have same title
        }
        else if(other == null)
        {
            return false;
        }
        else if(other.getClass() == this.getClass())
        {
            other = new Book;
            if(other.title() == this.title())
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
}

/**
 * prelab questions
 * 
 * 1. false
 * 2. true
 * 3. false
 * 4. true
 * 5. false
 * 6. true //possibly false
 */
