package com.example.nishantsikri.microdoctor.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

//Part of Recycler View
/**
 * Created by nishantsikri on 5/11/17.
 */

public class TitleCreator {
    static TitleCreator _titleCreator;
    List<TitleParent> _titleParents;

    public TitleCreator(Context context, String title1, String title2 ,String title3, String title4) {
        _titleParents = new ArrayList<>();
        //for(int i=1;i<=4;i++)
        //{
            TitleParent title = new TitleParent(String.format(title1));
            _titleParents.add(title);
            title = new TitleParent(String.format(title2));
            _titleParents.add(title);
            title = new TitleParent(String.format(title3));
            _titleParents.add(title);
            title = new TitleParent(String.format(title4));
            _titleParents.add(title);
        //}
//            TitleParent title = new TitleParent(String.format(actual_title));
//            _titleParents.add(title);
    }

    public static TitleCreator get(Context context, String title1, String title2, String title3, String title4)
    {
        if(_titleCreator == null)
            _titleCreator = new TitleCreator(context,title1,title2,title3,title4);
        return _titleCreator;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}