package com.redleefstudios.sushidictionary;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Fred on 4/13/2016.
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {

    private ArrayList<FoodObject> itemData;

    private Fragment mFragment;

    private OnCustomListAdapterInteraction mListener;

    public ListRecyclerAdapter(ArrayList<FoodObject> itemData, Fragment mFragment)
    {
        this.itemData = itemData;
        this.mFragment = mFragment;

        if (mFragment instanceof OnCustomListAdapterInteraction) {
            mListener = (OnCustomListAdapterInteraction) mFragment;
        } else {
            throw new RuntimeException(mFragment.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public ListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_item, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    public interface OnCustomListAdapterInteraction {
        void onItemClicked(int position);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position)
    {
        viewHolder.mLargeText.setText(itemData.get(position).getName());
        viewHolder.mMediumText.setText(itemData.get(position).getEthnicName());
        viewHolder.mSmallText.setText(itemData.get(position).getDescription());
        //Set color Categories

        viewHolder.mImage.setBackgroundResource(itemData.get(position).getImage());

        viewHolder.itemLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClicked(position);
            }
        });


    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mLargeText;
        public TextView mMediumText;
        public TextView mSmallText;
        public ImageView mImage;
        public View itemLayoutView;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);
            this.itemLayoutView = itemLayoutView;
            mLargeText = (TextView)itemLayoutView.findViewById(R.id.foodTitle);
            mMediumText = (TextView)itemLayoutView.findViewById(R.id.foodEthnicName);
            mSmallText = (TextView)itemLayoutView.findViewById(R.id.foodSmallDescription);
            mImage = (ImageView)itemLayoutView.findViewById(R.id.foodSmallImage);
        }
    }


    @Override
    public int getItemCount()
    {
        return itemData.size();
    }
}