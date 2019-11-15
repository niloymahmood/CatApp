package com.example.catapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FavouritesRecyclerFragment extends Fragment {
    private OnFragmentInteractionListener listener;
    public TextView favouritesTextView;


    public FavouritesRecyclerFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false  );
        favouritesTextView = view.findViewById(R.id.favourite_list);

        for (int i = 0; i < MainActivity.favouritesList.size(); i++) {
            favouritesTextView.setText(favouritesTextView.getText() + " " + MainActivity.favouritesList.get(i)); }
        return view;

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String string);
    }
};





