import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static double scale = 30;
    public static int pos = 100;
    
    double dx = 5.0 * scale;
    double dy = -5.0 * scale;
    double x = 0.0;
    double y = 360.0;
    double w = 30.0;
    double l = 360.0;   
    double angle = 45.0;
    double vi = 10.0 * scale;
    
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        Platform b1 = new Platform((int) (w), (int) (l));
        Platform b2 = new Platform((int) (getWidth()-w-dx), (int) (getHeight()-l-dy));
        addObject(b1, (int) (x+(w/2.0)), (int) (y+(l/2.0)));
        addObject(b2, (int) (x+dx+w+((getWidth()-w-dx)/2.0)), (int) (getHeight()-dy-l+((getHeight()-l-dy)/2.0)));
        for(int i = 0; i <= 90; i++){
            addObject(new Projectile(dy, vi, i, w, l), (int) w, (int) l);
        }
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            if(getObjects(Projectile.class).size() == -1){
                addObject(new Projectile(dy, vi, angle, w, l), (int) w, (int) l);
            } 
        }
    }
}
