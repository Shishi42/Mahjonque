package CoreUI;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mahjong.R;

import Core.Tile;
import Utils.Panel;

/**
 * @deprecated
 */
public class TileUI extends Panel {

    private final int WIDTH;
    private final int HEIGHT;

    private final int rowCount;
    private final int colCount;

    private final int width;
    private final int height;

    private int x;
    private int y;

    private Bitmap image;

    private Tile tile;
    private long lastDrawNanoTime;

    public TileUI(Resources res, int x, int y, Tile tile)  {


        this.image = BitmapFactory.decodeResource(res, R.drawable.example_black);


        this.tile = tile;

        this.rowCount = 4;
        this.colCount = 10;

        this.x = x;
        this.y = y;

        this.WIDTH = image.getWidth();
        this.HEIGHT = image.getHeight();

        this.width = this.WIDTH / colCount;
        this.height = this.HEIGHT / rowCount;

    }

    @Override
    public Bitmap getBitmap() {

        int row = this.tile.getType().getNum();
        int col = this.tile.getHeight().getNum();
        Bitmap subImage = Bitmap.createBitmap(this.image, col* width, row* height , width, height);

        return subImage;

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


}
