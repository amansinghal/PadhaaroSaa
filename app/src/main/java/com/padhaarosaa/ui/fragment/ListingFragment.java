package com.padhaarosaa.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.ValueEventListener;
import com.padhaarosaa.Model.Merriages;
import com.padhaarosaa.R;
import com.padhaarosaa.core.fragment.BaseFragment;
import com.padhaarosaa.core.rest.Firbase;
import com.padhaarosaa.views.MerrigesItemView;

import java.util.List;

import butterknife.Bind;
import io.nlopez.smartadapters.SmartAdapter;
/**
 * Created by gspl on 12/9/2015.
 */
public class ListingFragment extends BaseFragment
{

    @Bind(R.id.frag_listing_rv)
    RecyclerView recyclerView;

    @Override
    public void onFragmentReady()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fillData();
    }

    private void fillData()
    {
        showProgress();
        Firbase.getData(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println(dataSnapshot);
                GenericTypeIndicator<List<Merriages>> t = new GenericTypeIndicator<List<Merriages>>() {};
                List<Merriages> merriages = dataSnapshot.getValue(t);
                SmartAdapter.items(merriages).map(Merriages.class, MerrigesItemView.class).into(recyclerView);
                hideProgress();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {
                System.out.println(firebaseError.getDetails());
                hideProgress();
            }
        });
    }

    @Override
    public int getFragmentLayout()
    {
        return R.layout.frag_listing;
    }
}
