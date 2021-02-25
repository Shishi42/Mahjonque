package CoreUI;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import Core.Tuile;

public class TuileUI {

    private final int WIDTH;
    private final int HEIGHT;

    private final int rowCount;
    private final int colCount;

    private final int width;
    private final int height;

    private int x;
    private int y;

    private Bitmap image;

    private Tuile tuile;
    private long lastDrawNanoTime;

    public TuileUI(Bitmap image, int rowCount, int colCount, int x, int y, Tuile tuile)  {

        this.tuile = tuile;

        this.image = image;
        this.rowCount= rowCount;
        this.colCount= colCount;

        this.x= x;
        this.y= y;

        this.WIDTH = image.getWidth();
        this.HEIGHT = image.getHeight();

        this.width = this.WIDTH/ colCount;
        this.height= this.HEIGHT/ rowCount;

    }

    public Bitmap createSubImageAt(int row, int col)  {
        Bitmap subImage = Bitmap.createBitmap(image, col* width, row* height ,width,height);
        return subImage;
    }
    public void update()  {
        this.y += 1;
    }

    public void draw(Canvas canvas)  {
        Bitmap bitmap = this.image;
        canvas.drawBitmap(bitmap, x, y, null);
    }

}
