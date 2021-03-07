package Utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.LinkedList;
import java.util.List;

public abstract class Panel {

    private List<Panel> panels;

    public Panel() {
        this.panels = new LinkedList<Panel>();
    }

    public void add(Panel panel) {
        this.panels.add(panel);
    }

    public void remove(Panel panel) {
        this.panels.remove(panel);
    }

    public void draw(Canvas canvas) {

        this.panels.forEach(p -> canvas.drawBitmap(p.getBitmap(), p.getX(), p.getY(), null));

    }

    public abstract Bitmap getBitmap();
    public abstract int getX();
    public abstract int getY();

}
