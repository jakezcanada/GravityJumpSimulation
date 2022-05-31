import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    public Platform(int w, int l){
        GreenfootImage b1 = new GreenfootImage(w, l);
        b1.setColor(Color.BLACK);
        b1.fillRect(0, 0, w, l);
        setImage(b1);
    }
}
