import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    double ay = 9.81 * MyWorld.scale;
    double dt = 0.0;
    double dy;
    double vx, vy;
    double startX,startY;
    double cooldown = 200;
    double angle;

    public Projectile(double dy, double vi, double angle, double startX, double startY){
        this.dy = dy;
        this.angle = angle;
        double inRad = angle * Math.PI / 180.0;
        this.vx = vi*Math.cos(inRad);
        this.vy = 0.0 - vi*Math.sin(inRad);
        this.startX = startX;
        this.startY = startY;
    }

    public void act(){
        if(cooldown <= 0){
            if(isTouching(Platform.class)){
                if(MyWorld.pos < 500){
                    getWorld().showText(angle + "degrees takes " + (dt/1000.0) + "seconds", 640, MyWorld.pos);
                    MyWorld.pos += 50;
                }
                getWorld().removeObject(this);
            }else{
                double cx, cy;
                cx = (dt/1000.0) * vx;
                cy = (dt/1000.0) * vy + (0.5 * ay * (dt/1000.0) * (dt/1000.0));
                dt += 1;
                //getWorld().showText((dt/1000.0) + "", 300, 50);
                setLocation((int) (startX + cx), (int) (startY + cy));
            }
        }else{
            cooldown--;
            double cx, cy;
            cx = (dt/1000.0) * vx;
            cy = (dt/1000.0) * vy + (0.5 * ay * (dt/1000.0) * (dt/1000.0));
            dt += 1;
            //getWorld().showText((dt/1000.0) + "", 300, 50);
            setLocation((int) (startX + cx), (int) (startY + cy));
        }
    }
}
