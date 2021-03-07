package CoreUI;

        import android.content.res.Resources;

        import com.example.mahjong.MainActivity;
        import com.example.mahjong.R;

        import Core.Game;


public class GameUI {


    private Game game;
    private MainActivity controller;


    public GameUI(Game game, MainActivity controller)  {

        this.game = game;
        this.controller = controller;

    }


}
