package com.example.nishantsikri.microdoctor.ViewHolders;

/**
 * Created by nishantsikri on 5/11/17.
 */
//Part of Recycler View

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import com.example.nishantsikri.microdoctor.R;

public class TitleParentViewHolder extends ParentViewHolder {
    public TextView _textView;
    public ImageButton _imageButton;

    public TitleParentViewHolder(View itemView) {
        super(itemView);
        _textView = (TextView)itemView.findViewById(R.id.parentTitle);
        _imageButton = (ImageButton) itemView.findViewById(R.id.expandArrow);
    }
}
