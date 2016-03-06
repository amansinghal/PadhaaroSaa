package com.padhaarosaa.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.ValueEventListener;
import com.padhaarosaa.Model.Contents;
import com.padhaarosaa.Model.Meals;
import com.padhaarosaa.Model.Merriages;
import com.padhaarosaa.R;
import com.padhaarosaa.core.fragment.BaseFragment;
import com.padhaarosaa.core.rest.FirebaseConstants;
import com.padhaarosaa.views.MerrigesItemView;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import io.nlopez.smartadapters.SmartAdapter;
/**
 * Created by gspl on 12/9/2015.
 */
public class ListingFragment extends BaseFragment
{
    int count = 0;

    @Override
    public void onFragmentReady()
    {
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //fillData();
        /*Firebase firebase = new Firebase(FirebaseConstants.FIREBASE_URL);
        firebase = firebase.child("meals");
        Meals[] mealses = new Meals[3];
        mealses[0] = getMeal();
        mealses[1] = getMeal();
        mealses[2] = getMeal();
        firebase.setValue(mealses, new Firebase.CompletionListener()
        {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase)
            {
                System.out.println(firebase);
                System.out.println(firebaseError);
            }
        });*/
    }


    private Meals getMeal()
    {
        Meals meals = new Meals();
        Contents[] conArray = new Contents[3];
        Contents contents = new Contents();
        contents.setName("Salad");
        contents.setImageUrl("");
        conArray[0] = contents;
        contents = new Contents();
        contents.setName("Chapati");
        contents.setImageUrl("");
        conArray[1] = contents;
        contents = new Contents();
        contents.setName("Raita");
        contents.setImageUrl("");
        conArray[2] = contents;
        meals.setContents(conArray);
        meals.setName("Balanced");
        meals.setId(101);
        meals.setRupees(49);
        meals.setMON_OPTION(conArray);
        return meals;
    }

    @OnClick(R.id.frag_home_meals)
    public void openMeals()
    {
        getFragmentManager().beginTransaction().replace(R.id.content_main, new MealsFragment()).commit();
    }

    @Override
    public int getFragmentLayout()
    {
        return R.layout.frag_listing;
    }
}
