package com.example.a17010304.gymnotify;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.List;

public class CustomTutorialsAdapter extends RecyclerView.Adapter<CustomTutorialsAdapter.VideoViewHolder> {

    List<TutorialsClass> vidLists;
    public CustomTutorialsAdapter(){

    }

    @NonNull
    @Override
    public CustomTutorialsAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_tutorials_list_view, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomTutorialsAdapter.VideoViewHolder holder, int position) {
        holder.wv.loadData( vidLists.get(position).getYtURl(), "text/html" , "utf-8" );
        holder.tv.setText(vidLists.get(position).getGymWorkoutName());

    }

    @Override
    public int getItemCount() {

        return vidLists.size();
    }

    public CustomTutorialsAdapter(List<TutorialsClass> vidLists){
        this.vidLists = vidLists;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView wv;
        TextView tv;

        public VideoViewHolder(View itemView) {
            super(itemView);

            wv = itemView.findViewById(R.id.wvTutorials);
            tv = itemView.findViewById(R.id.textViewTutorials);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.setBackgroundColor(Color.rgb(0,0,0));
            wv.setWebChromeClient(new WebChromeClient(){

            });
        }
    }


}
