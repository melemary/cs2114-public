/**
 * 
 */
package project1;

import bag.Bag; 
import bag.BagInterface;
import CS2114.TextShape;

import java.awt.Color;
import java.util.Random;
import CS2114.Window; 
import CS2114.Button; 
import CS2114.WindowSide;

/**
 * @author Mostafa Elemary
 *
 */
public class ShapeWindow {
    
    public Window window;
    public TextShape textShape;
    public Button quitButton, chooseButton;
    public BagInterface <String> itemBag;

    public ShapeWindow(BagInterface<String> inputBag)
    {
        this.window = new Window();
        window.setTitle("Project 1");
        
        this.itemBag = inputBag;
        
        this.quitButton = new Button ("Quit");
        quitButton.onClick(this, "clickedQuit");
        
        window.addButton(quitButton, WindowSide.NORTH);
        
        this.chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        
        window.addButton(chooseButton, WindowSide.SOUTH);
        
        this.textShape = new TextShape(0,0,"");
        
        window.addShape(textShape);
    }
    
    public void clickedQuit(Button inputButton)
    {
        System.exit(0);
    }
    
    public void clickedChoose(Button inputButton)
    {
        if(!this.itemBag.isEmpty())
            this.textShape.setText(this.itemBag.remove());
        else
            this.textShape.setText("No more items.");
        
        colorText();
        
        centerText();
    }
    
    public void colorText()
    {
        if(textShape.getText().contains("red"))
            textShape.setForegroundColor(Color.RED);
        else if(textShape.getText().contains("blue"))
            textShape.setForegroundColor(Color.BLUE);
        else
            textShape.setForegroundColor(Color.BLACK);
    }
    
    public void centerText()
    {
        int windowHeight = window.getGraphPanelHeight();
        int windowWidth = window.getGraphPanelWidth();
        
        int textHeight = textShape.getHeight();
        int textWidth = textShape.getWidth();
        
        textShape.moveTo((windowWidth - textWidth)/2, (windowHeight - textHeight)/2);
    }
}








