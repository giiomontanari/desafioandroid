package com.example.giovanni.desafioandroidnovo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Giovanni on 11/04/2017.
 */

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.ViewHolder> {


    private List<GitHubModel> ModelList;

    private Context mContext;

    public GitHubAdapter(List<GitHubModel> modelList, Context mContext) {
        ModelList = modelList;
        this.mContext = mContext;
    }

    public Context getmContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView id;
        public TextView name;
        public TextView fullname;


        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            id   = (TextView) itemView.findViewById(R.id.list_name);
            name = (TextView) itemView.findViewById(R.id.list_name);
            fullname = (TextView) itemView.findViewById(R.id.list_name);
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View ModelView = inflater.inflate(R.layout.item_lista, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(ModelView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        GitHubModel modellist = ModelList.get(position);
    }

    @Override
    public int getItemCount() {
        return ModelList.size();
    }

}
