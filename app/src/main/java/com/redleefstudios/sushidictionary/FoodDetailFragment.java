package com.redleefstudios.sushidictionary;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

public class FoodDetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    CollapsingToolbarLayout collapsingToolbarLayout;


    public FoodDetailFragment() {
        // Required empty public constructor
    }

    public static FoodDetailFragment newInstance(String param1, String param2) {
        FoodDetailFragment fragment = new FoodDetailFragment();
        /*
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        */
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        */

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail_fragment, container, false);

        /*A
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        getActivity().setActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Masago");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
*/
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
