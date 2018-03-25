package databinder;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by aftab on 7/8/17.
 */

public class ThemeData {
    String name;
    int color1,color2,color3;

    public ThemeData(String name, int color1, int color2, int color3) {
        this.name = name;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    public String getName() {
        return name;
    }

    public int getColor1() {
        return color1;
    }

    public int getColor2() {
        return color2;
    }

    public int getColor3() {
        return color3;
    }
}
