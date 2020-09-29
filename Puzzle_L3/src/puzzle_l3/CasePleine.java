/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_l3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author kerya
 */
public class CasePleine extends Tile{
    
    
    private PosDouble posGraphic;

    private Image image;
    private Color highlight;
    private boolean isHighlighted

 
    public boolean move()
    {
        
    }
    
    public void setHighlightColor(Color col)
    {
        highlight=col;
    }
    
    public void toggleHighlight(boolean toggled)
    {
        isHighlighted=toggled;
    }
    
    public void draw(GraphicsContext context)
    {
        
    }
}
