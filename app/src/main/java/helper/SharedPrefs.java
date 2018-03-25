package helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.rahmani.remindme.R;

/**
 * Created by aftab on 7/8/17.
 */

public class SharedPrefs {

    private static final String THEME = "theme";
    private static final String THEME_BLUE = "candy_blue";
    private static final String THEME_PURPLE = "candy_purple";
    public static SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefs(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(THEME, 0);
    }

    public void setNewTheme(String theme) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("newtheme", theme);
        editor.apply();
    }


    public String getNewTheme() {
        return sharedPreferences.getString("newtheme", "");
    }
}
