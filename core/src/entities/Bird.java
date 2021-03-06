package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

public class Bird {

    public static final float BOUND_RADIUS = 100f;
    public static final float SIZE = 2*BOUND_RADIUS;

    public static Sprite birdSprite;
    public float x,y,staticY;

    public float xSpeed = 30f;

    public Circle bounds;
    public Plane plane;

    public Circle getBoundingCircle(){
        return bounds;
    }


    public Bird(float x, float y, Sprite birdSprite, Plane plane){
        bounds = new Circle(x,y, BOUND_RADIUS);
        this.x = x;
        this.staticY = y;
        this.birdSprite = birdSprite;
        this.plane = plane;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
        updateBounds();
    }

    public void update(float delta){
        if(plane.xVel == 0){
            setPosition((x + (xSpeed * delta)),0-plane.y+staticY);
        }
        else
            setPosition((x + (xSpeed * delta) - (plane.xVel * 5 * delta)),0-plane.y+staticY);
        Gdx.app.log("Bird","Bird X/Y\t" + x + "\t" + y);
    }

    // returns the absolute x, y coordinates of the bird
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    // return the render-offset x, y coordinates of the bird
    public float getRenderX(){
        return (this.getBoundingCircle().x - this.birdSprite.getWidth()/2);
    }
    public float getRenderY(){
        return (this.getBoundingCircle().y - this.birdSprite.getHeight()/2);
    }

    public void updateBounds(){
        bounds.setPosition(x,y);
    }

    public float getWidth(){return SIZE;}


}
