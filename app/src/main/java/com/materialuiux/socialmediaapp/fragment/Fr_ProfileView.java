package com.materialuiux.socialmediaapp.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.materialuiux.socialmediaapp.R;
import com.materialuiux.socialmediaapp.adapter.Ad_Gallery;
import com.materialuiux.socialmediaapp.adapter.Ad_Main;
import com.materialuiux.socialmediaapp.model.Post;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_ProfileView extends Fragment {


    private Context mContext;
    RecyclerView recyclerView, RecyclerViewPhoto;
    NestedScrollView nestedScrollView;
    LinearLayout linearLayout;

    public Fr_ProfileView() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_profile_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        linearLayout = view.findViewById(R.id.l1);

        nestedScrollView = view.findViewById(R.id.scrollView);
        recyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerViewPhoto = view.findViewById(R.id.RecyclerViewPhoto);

        RecyclerViewPhoto.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        Ad_Gallery ad_gallery = new Ad_Gallery(mContext, getImages());
        RecyclerViewPhoto.setFocusable(false);
        RecyclerViewPhoto.setAdapter(ad_gallery);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        Ad_Main ad_main = new Ad_Main(mContext, getData());
        recyclerView.setAdapter(ad_main);
        nestedScrollView.scrollTo(0, 0);
        linearLayout.requestFocus();
        RecyclerViewPhoto.setFocusable(false);
        recyclerView.setFocusable(false);


    }

    private ArrayList<String> getImages() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://f4.bcbits.com/img/a0942274282_16.jpg");
        arrayList.add("https://www.anime-planet.com/images/anime/screenshots/fight-league-gear-gadget-generators-12359-1.jpg");
        arrayList.add("https://honeysanime.com/wp-content/uploads/2016/08/1-episode-3-Kill-la-Kill-Capture-500x400.jpg");
        arrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4ZhmFkgBEiaN58oW-WzVBnlXTJsiGZGD6ZRgYpghqPT2PId4LbQ");
        arrayList.add("https://wallpaperplay.com/walls/full/0/e/d/72534.jpg");
        arrayList.add("https://wallpaperplay.com/walls/full/9/9/0/72533.jpg");
        arrayList.add("https://i.ytimg.com/vi/35aItMl6MCQ/maxresdefault.jpg");
        arrayList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHi6gwyQf4Q08vwxP8my-KxtJtL6dRVbv04YpQzcbHt5hVgBPi0w");
        return arrayList;
    }

    private ArrayList<Post> getData() {
        ArrayList<Post> arrayList = new ArrayList<>();
        arrayList.add(new Post("", R.drawable.post2, "", 0));
        arrayList.add(new Post("", R.drawable.post3, "", 0));
        arrayList.add(new Post("", R.drawable.post4, "", 0));
        arrayList.add(new Post("", R.drawable.profile, "", 0));
        arrayList.add(new Post("https://www.radiantmediaplayer.com/media/bbb-360p.mp4", 0, "", 1));
        return arrayList;
    }
}
