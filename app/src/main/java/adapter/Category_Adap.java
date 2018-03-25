package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rahmani.remindme.R;

import java.util.ArrayList;

import databinder.CategoryData;
import databinder.ThemeData;
import rminterface.UpdateValuesCallBack;

/**
 * Created by ashfaque on 14/8/17.
 */

public class Category_Adap extends RecyclerView.Adapter<Category_Adap.MyViewHolder> {
    private static final String TAG = Category_Adap.class.getSimpleName();
    private Context mContext;
    private ArrayList<CategoryData> list;

    Theme_Adap.OnItemClickListener mOnItemClickListener;
    UpdateValuesCallBack updateValuesCallBack;


    public Category_Adap(Context mContext, ArrayList<CategoryData> list, UpdateValuesCallBack updateValuesCallBack) {
        this.mContext = mContext;
        this.list = list;
        this.updateValuesCallBack=updateValuesCallBack;
    }


    @Override
    public Category_Adap.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_categories, parent, false);
        Category_Adap.MyViewHolder myViewHolder = new Category_Adap.MyViewHolder(itemview, mContext, list);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final Category_Adap.MyViewHolder holder, int position) {
        CategoryData cd = this.list.get(position);
        holder.category_name.setText(cd.getCategory_name());
        holder.image.setImageDrawable(mContext.getResources().getDrawable(cd.getImage()));

        updateValuesCallBack =new UpdateValuesCallBack() {
            @Override
            public void ItemNewValue(int position, String value) {
                holder.category_val.setText(value);
            }
        };
      /*  CategoryData catdata=this.list2.get(0);
        Toast.makeText(mContext,""+catdata.getCategory_val(),Toast.LENGTH_SHORT).show();
        if (catdata.getCategory_val()==null){
            holder.category_val.setText("dd/mm/yy");
        }else{
            holder.category_val.setText(catdata.getCategory_val());
        }*/
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ArrayList<CategoryData> list;
        public TextView category_name, category_val;
        ImageView image;

        public MyViewHolder(View view, Context context, ArrayList<CategoryData> list) {
            super(view);
            this.list = list;
            mContext = context;
            category_val = (TextView) view.findViewById(R.id.category_val);
            category_name = (TextView) view.findViewById(R.id.category_name);
            image = (ImageView) view.findViewById(R.id.image);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getPosition());

            }

        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListner(final Theme_Adap.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

   /* private void bind(final Category_Adap.MyViewHolder  holder) {
        holder.category_val.setText("item " + holder.getAdapterPosition());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = holder.getAdapterPosition();
                //Log.d("butt", "click " + position);
                Category_Adap.this.notifyItemChanged(position, "payload " + position);
            }
        });
    }*/
}