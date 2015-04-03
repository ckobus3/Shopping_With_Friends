package com.shoppingwithfriends.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
@SuppressWarnings("ALL")
public class AddItemFragment extends Fragment {

    public AddItemFragment() {
    }

    /**
     * Called when the activity is starting
     * @param savedInstanceState
     */
    @SuppressWarnings("JavaDoc")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return rootView
     */
    @SuppressWarnings("JavaDoc")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_item, container, false);
    }

}
