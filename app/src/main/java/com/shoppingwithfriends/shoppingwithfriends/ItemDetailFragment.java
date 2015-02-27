package com.shoppingwithfriends.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static ItemRequest item;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = Integer.parseInt(getArguments().getString("id"));
        DatabaseHandler db = new DatabaseHandler(getActivity());
        //create an item
        item = db.getItemRequest(id);
        db.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        //sets fields to the user's data
        ((TextView) rootView.findViewById(R.id.textView14)).setText(item.getName());
        ((TextView) rootView.findViewById(R.id.textView15)).setText("" + item.getMaxPrice());
        ((TextView) rootView.findViewById(R.id.textView16)).setText(item.getLocation());
        return rootView;
    }
}
