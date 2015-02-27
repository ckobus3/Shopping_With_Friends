package com.shoppingwithfriends.shoppingwithfriends;

import android.app.Activity;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import static com.shoppingwithfriends.shoppingwithfriends.ItemRequest.currentItem;


public class AddItem extends ListFragment {
    private static final String STATE_ACTIVATED_POSITION = "activated_position";
    private List itemList = new ArrayList();
    private List<ItemRequest> List;
    private ArrayAdapter mAdapter;

    private OnFragmentInteractionListener mListener;
    private Callback mCallbacks;

    private int mActivatedPosition = ListView.INVALID_POSITION;

    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(String task, int id);
    }


    public AddItem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHandler db = new DatabaseHandler(getActivity());

        List<ItemRequest> itemList;
        itemList = new ItemRequest(db.getRequestsByUser(User user));
        db.close();
        for (ItemRequest item : itemList ) {
            if (!item.equals(currentItem) && !itemList.contains(item)) {
                itemList.add(item);
            } else
                itemList.remove(item); //removes the irrelevant user
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item2, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
