package fr.iut63.a2ddicegameupdate.models;


import android.content.Context;
import android.graphics.Rect;

public class GameUnit extends GameImage
{
    private final int id;
    private static int count = 1;

    public GameUnit(Context context, int drawable)
    {
        super(context, drawable);

        id=count;
        count++;
    }

    public Rect getRect()
    {
        return new Rect((int)mX, (int)mY, ((int)mX + this.getWidth()), ((int)mY + this.getHeight()));
    }

    public boolean getCollision(int x, int y, int width, int height)
    {
        Rect rect = new Rect((int)x, (int)y, ((int)x + width), ((int)y + height));
        return (rect.intersects((int)mX, (int)mY, ((int)mX + getWidth()), ((int)mY + getHeight())));
    }

    public boolean getImpact(int x, int y)
    {
        if ((x >= mX) && (x <= (mX + this.getWidth())))
        {
            return (y >= mY) && (y <= (mY + this.getHeight()));
        }

        return false;
    }

    public static int getCount()
    {
        return count;
    }

    public static void resetCount()
    {
        count = 1;
    }

    public int getId()
    {
        return id;
    }
}