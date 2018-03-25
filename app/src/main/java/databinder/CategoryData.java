package databinder;

import android.content.Context;

/**
 * Created by ashfaque on 14/8/17.
 */

public class CategoryData {
    String category_name, category_val;
    int positon;
    int image;
    Context context;

    public CategoryData() {
    }

    /* public CategoryData(String category_val, int positon, Context context) {
        this.category_val = category_val;
        this.positon = positon;
        this.context = context;
    }*/

    public CategoryData(String category_name, int image) {
        this.category_name = category_name;
        this.image = image;
    }

    public void setCategory_val(String category_val) {
        this.category_val = category_val;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }

    public int getImage() {
        return image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_val() {
        return category_val;
    }

    public int getPositon() {
        return positon;
    }
}
