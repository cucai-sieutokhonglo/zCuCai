package com.example.zcucai.adapter_view_day6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zcucai.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<MySong> {

    private ArrayList<MySong> mListSongs;
    private Context mContext;
    private int mResourceID;
    private String TAG = "CustomeAdapter";

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<MySong> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResourceID = resource;
        this.mListSongs = objects;
    }

    @Override
    public int getCount() {
        return mListSongs.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        MyViewHolder myViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceID, parent, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        } else
            myViewHolder = (MyViewHolder) convertView.getTag();

        MySong mySong = mListSongs.get(position);
        if (mySong != null) {
//            ImageView imgViewIcon = view.findViewById(R.id.image_icon);
//            TextView tvName = view.findViewById(R.id.tv_title_song);
//            TextView tvauthor = view.findViewById(R.id.tv_author_song);
            myViewHolder.imageView.setImageResource( mySong.getResourceID());
            myViewHolder.tvName.setText(mySong.getName());
            myViewHolder.tvAuthor.setText(mySong.getAuthor());
        }
        return convertView;
    }

    class MyViewHolder {
        ImageView imageView;
        TextView tvName;
        TextView tvAuthor;

        public MyViewHolder(View itemView) {
            this.imageView = itemView.findViewById(R.id.image_icon);
            this.tvName = itemView.findViewById(R.id.tv_title_song);
            this.tvAuthor = itemView.findViewById(R.id.tv_author_song);
        }
    }
}
