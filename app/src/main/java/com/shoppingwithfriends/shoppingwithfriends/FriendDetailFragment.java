package com.shoppingwithfriends.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A fragment representing a single Friend detail screen.
 */
@SuppressWarnings("JavaDoc")
public class FriendDetailFragment extends Fragment {

    public static User user;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FriendDetailFragment() {
    }

    /**
     * Called when the activity is starting
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //gets id of user from the bundle
        int id = Integer.parseInt(getArguments().getString("id"));
        DatabaseHandler db = new DatabaseHandler(getActivity());
        //creates user from the id given
        user = db.getUser(id);
        db.close();

    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return rootView
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friend_detail, container, false);

        //sets fields to the user's data
        ((TextView) rootView.findViewById(R.id.textView7)).setText(user.getName());
        ((TextView) rootView.findViewById(R.id.textView8)).setText(user.getEmail());
        ((TextView) rootView.findViewById(R.id.textView9)).setText("" + user.getRating());
        ((TextView) rootView.findViewById(R.id.textView10)).setText("" + user.getNumReports());

        return rootView;
    }
}
