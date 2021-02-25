package AndroidUI;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.mahjong.R;

import java.util.LinkedList;
import java.util.List;

import Core.Game;
import Core.Player;
import Core.TileNum;
import Core.Tile;
import Core.TileType;
import CoreUI.TileUI;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread;
    private List<TileUI> tilesUI;

    public GameSurface(Context context)  {
        super(context);

        // Make Game Surface focusable so it can handle events. .
        this.setFocusable(true);

        // Set callback.
        this.getHolder().addCallback(this);

    }

    public void update()  {

        this.tilesUI.forEach(t -> t.update());

    }

    @Override
    public void draw(Canvas canvas)  {

        super.draw(canvas);
        this.tilesUI.forEach(t -> t.draw(canvas));

    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Game game = new Game();
        Player player = new Player(game);
        this.tilesUI = new LinkedList<TileUI>();
        int i = 0;
        for(Tile tile : player.getMain().getTiles()) {
            i+=1;
            this.tilesUI.add(new TileUI(this.getResources(), i * 700, 0, tile));
        }
/*
        this.tilesUI.add(new TileUI(this.getResources(),0,0, Tile.getTile(TileType.BAMBOU, TileNum.ONE)));
        this.tilesUI.add(new TileUI(this.getResources(),700,0, Tile.getTile(TileType.FEU, TileNum.THREE)));
*/
        this.gameThread = new GameThread(this, holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();

    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry= true;
        while(retry) {
            try {
                this.gameThread.setRunning(false);

                // Parent thread must wait until the end of GameThread.
                this.gameThread.join();
            }catch(InterruptedException e)  {
                e.printStackTrace();
            }
            retry= true;
        }
    }

}