package com.example.giovanni.desafioandroidnovo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Giovanni on 11/04/2017.
 */

public class GitHubViewHolder extends RecyclerView.ViewHolder {

    final TextView id;
    final TextView name;
    final TextView fullname;


    public GitHubViewHolder(View view) {
        super(view);

        id = (TextView) view.findViewById(R.id.recycler_recyclerteste);
        name = (TextView) view.findViewById(R.id.recycler_recyclerteste);
        fullname = (TextView) view.findViewById(R.id.recycler_recyclerteste);

    }


}
