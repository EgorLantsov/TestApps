import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject {

    Handler handler;
    Random random = new Random();
    int choose = 0;
    int hp = 100;

    private BufferedImage [] enemy_image = new BufferedImage[3];
    Animation anim;

    public Enemy(int x, int y, ID id, Handler handler, SpriteSheet ss) {
        super(x, y, id, ss);
        this.handler = handler;

        enemy_image[0] = ss.gradImage(4, 1, 32,32);
        enemy_image[1] = ss.gradImage(5, 1, 32,32);
        enemy_image[2] = ss.gradImage(6, 1, 32,32);

        anim = new Animation(3, enemy_image[0], enemy_image[1], enemy_image[2]);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        choose = random.nextInt(10);

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ID.Block){
                if(getBoundsBig().intersects(tempObject.getBounds())){
                    x += (velX*2) * -1;
                    y += (velY*2) * -1;
                    velX *= -1;
                    velY *= -1;
                } else if(choose == 0) {
                    velX = (random.nextInt(4 - -4) + -4);
                    velY = (random.nextInt(4 - -4) + -4);
                }
            }

            if(tempObject.getId() == ID.Bullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    hp -= 50;
                    handler.removeObject(tempObject);
                }

            }
        }
        anim.runAnimation();
        if(hp <= 0) handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        anim.drawAnimation(g, x, y, 0);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }

    public Rectangle getBoundsBig() {
        return new Rectangle(x-16,y-16,64,64);
    }
}
