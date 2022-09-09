import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static double scale = 20;
    public static int pos = 100;
    public static List<Double> distances;
    double x = 0.0;
    double y = 360.0;
    double w = 30.0;
    double l = 360.0;
    
    //double dx = 15.2358114 * scale;
    public static double dx = 0 * scale;
    public static double dy = -10.781628 * scale;
    double angle = 29.953608;
    double vi = 7.462868607 * scale;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        pos = 100;
        scale = 20;
        distances = new ArrayList<Double>();
        distances.add(0.0);
        Platform b1 = new Platform((int) (w), (int) (l));
        Platform b2 = new Platform((int) (getWidth()-w-dx), (int) (getHeight()-l-dy));
        addObject(b1, (int) (x+(w/2.0)), (int) (y+(l/2.0)));
        addObject(b2, (int) (x+dx+w+((getWidth()-w-dx)/2.0)), (int) (getHeight()-dy-l+((getHeight()-l-dy)/2.0)));
    }

    public void act(){
        if(Greenfoot.isKeyDown("1")){
            if(getObjects(Projectile.class).size() == 0){
                System.out.println(Collections.max(distances)/20.0);
                for(int i = 0; i<60; i++)
                    addObject(new Projectile(dy, vi, i, w, l), (int) w, (int) l);
            } 
        }
        if(Greenfoot.isKeyDown("2")){
            if(getObjects(Projectile.class).size() == 0){
                simulate();           
            } 
        }
    }
    
    public void simulate(){
        for(int i = 2400; i<2500; i++){
            double inRad = i /100.0 * Math.PI / 180.0;
            double vx = vi*Math.cos(inRad);
            double vy = vi*Math.sin(inRad);
            double startX = w;
            double startY = l;
            double ay = 0.0 - (9.81 * MyWorld.scale);
            
            double time = (-vy-Math.sqrt((vy*vy)-4*(0.5*ay)*(-MyWorld.dy)))/(ay);
            MyWorld.distances.add(time * vx);
            System.out.println((i/100.0) + "degrees takes " + time + "seconds and moves " + (time * vx / 20.0) + "m in the x direction");
        }
    }
}
