package com.padhaarosaa.views;

import android.content.Context;
import android.widget.TextView;

import com.padhaarosaa.Model.Meals;
import com.padhaarosaa.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableLayout;
/**
 * Created by AmaN on 3/6/2016.
 */
public class MealsItemView extends BindableLayout<Meals>
{
    @Bind(R.id.meal_item_view_name)
    TextView name;
    @Bind(R.id.meal_item_view_rupees)
    TextView rupees;

    public MealsItemView(Context context)
    {
        super(context);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.meal_item_view;
    }

    @Override
    public void bind(Meals meals)
    {
        name.setText(meals.getName());
        rupees.setText(meals.getRupees()+"Rs.");
    }
}
