package com.redleefstudios.sushidictionary;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FoodListFragment extends Fragment implements ListRecyclerAdapter.OnCustomListAdapterInteraction{

    ListRecyclerAdapter mAdapter;
    ArrayList<FoodObject> mData;

    private OnFragmentInteractionListener mListener;

    public FoodListFragment() {
        // Required empty public constructor
    }

    public static FoodListFragment newInstance(String param1, String param2) {
        FoodListFragment fragment = new FoodListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mData = new ArrayList<FoodObject>();

        for(int x = 0; x < 30; x++)
        {
            FoodObject toAdd = new FoodObject(getResources().getString(R.string.test_title), getResources().getString(R.string.test_description), R.drawable.masago);
            toAdd.setEthnicName(getResources().getString(R.string.test_ethnic));
            toAdd.addIngredient(Ingredient.FISH_ROE);

            mData.add(toAdd);
        }

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        // 3. create an adapter
        mAdapter = new ListRecyclerAdapter(mData, this);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Main Activity Implements this, needs to have the method public void onSelection(int position)
     */
    public interface OnFragmentInteractionListener {
        void onSelection(int position);
    }

    /**
     * Called within fragment when item is selected, calls local variable mListener which is OnFragmentInteractionListener
     * @param position
     */
    public void onItemClicked(int position)
    {
        if (mListener != null) {
            mListener.onSelection(position);
        }
    }
}
