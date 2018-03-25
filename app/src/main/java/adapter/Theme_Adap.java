package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.rahmani.remindme.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import databinder.ThemeData;

/**
 * Created by aftab on 7/8/17.
 */

public class Theme_Adap extends RecyclerView.Adapter<Theme_Adap.MyViewHolder> {
    private static final String TAG = Theme_Adap.class.getSimpleName();
    private Context mContext;
    private ArrayList<ThemeData> list;
    Theme_Adap.OnItemClickListener mOnItemClickListener;

    public Theme_Adap(Context mContext, ArrayList<ThemeData> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public Theme_Adap.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_theme, parent, false);
        Theme_Adap.MyViewHolder myViewHolder = new Theme_Adap.MyViewHolder(itemview, mContext, list);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final Theme_Adap.MyViewHolder holder, int position) {
        //ReminderSublist rd = this.list.get(position);
        //holder.reminder_name.setText(rd.getName());

        ThemeData td = this.list.get(position);
        holder.tv_theme.setText(td.getName());
        holder.color1.setBackgroundColor(td.getColor1());
        holder.color2.setBackgroundColor(td.getColor2());
        holder.color3.setBackgroundColor(td.getColor3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ArrayList<ThemeData> list;
        public TextView tv_theme;
        public LinearLayout color1, color2, color3;

        public MyViewHolder(View view, Context context, ArrayList<ThemeData> list) {
            super(view);
            this.list = list;
            mContext = context;
            tv_theme = (TextView) view.findViewById(R.id.tv_theme);
            color1 = (LinearLayout) view.findViewById(R.id.color1);
            color2 = (LinearLayout) view.findViewById(R.id.color2);
            color3 = (LinearLayout) view.findViewById(R.id.color3);
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
    public void setOnItemClickListner(final Theme_Adap.OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }
}