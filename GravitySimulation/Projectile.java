import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    double ay = 0.0 - (9.81 * MyWorld.scale);
    double dt = 0.0;
    double dy;
    double vx, vy;
    double startX,startY;
    double cooldown = 200;
    double angle;
    double cx, cy;

    public Projectile(double dy, double vi, double angle, double startX, double startY){
        this.dy = dy;
        this.angle = angle;
        double inRad = angle * Math.PI / 180.0;
        this.vx = vi*Math.cos(inRad);
        this.vy = vi*Math.sin(inRad);
        this.startX = startX;
        this.startY = startY;

        
        
        GreenfootImage img = new GreenfootImage("proj.png");
        img.scale(10,10);
        setImage(img);
    }

    public void move(){
        cx = (dt/1000.0) * vx;
        cy = (dt/1000.0) * vy + (0.5 * ay * (dt/1000.0) * (dt/1000.0));
        dt += 5;
        setLocation((int) (startX + cx - 5.0), (int) (startY - cy - 5.0));
    }

    public void act(){
        if(cooldown <= 0){
            if(isTouching(Platform.class)){
                if(MyWorld.pos < 500){
                    double time = (-vy-Math.sqrt((vy*vy)-4*(0.5*ay)*(-MyWorld.dy)))/(ay);
                    MyWorld.distances.add(time * vx);
                    System.out.println(angle + "degrees takes " + time + "seconds");
                    getWorld().showText(angle + "degrees takes " + time + "seconds", 640, MyWorld.pos);
                    MyWorld.pos += 50;
                }
                getWorld().removeObject(this);
                return;
            }else{
                move();
            }
        }else{
            cooldown--;
            move();
        }
        if(this.getY() > 720){
            getWorld().removeObject(this);
        }
    }
}
