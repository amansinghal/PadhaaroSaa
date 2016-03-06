package com.padhaarosaa.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.padhaarosaa.Model.Meals;
import com.padhaarosaa.R;
import com.padhaarosaa.core.fragment.BaseFragment;
import com.padhaarosaa.core.rest.FirebaseConstants;
import com.padhaarosaa.views.MealsItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import io.nlopez.smartadapters.SmartAdapter;
import io.nlopez.smartadapters.adapters.RecyclerMultiAdapter;
/**
 * Created by AmaN on 3/6/2016.
 */
public class MealsFragment extends BaseFragment
{
    @Bind(R.id.frag_meals_listing_rv_list)
    RecyclerView rvListing;
RecyclerMultiAdapter recyclerMultiAdapter;
    List<Meals> mealsList = new ArrayList<>();
    @Override
    public void onFragmentReady()
    {
        showProgress();
        rvListing.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerMultiAdapter = SmartAdapter.items(mealsList).map(Meals.class, MealsItemView.class).recyclerAdapter();
        rvListing.setAdapter(recyclerMultiAdapter);
        Firebase firebase = new Firebase(FirebaseConstants.FIREBASE_URL);
        firebase.child("meals").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot snapshot)
            {
                hideProgress();
                for(DataSnapshot postSnapshot : snapshot.getChildren())
                {
                    Meals meals = postSnapshot.getValue(Meals.class);
                    mealsList.add(meals);
                    recyclerMultiAdapter.notifyDataSetChanged();
                    System.out.println(meals.getRupees() + " - " + meals.getName());
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {
                hideProgress();
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    @Override
    public int getFragmentLayout()
    {
        return R.layout.frag_meals_listing;
    }
}
