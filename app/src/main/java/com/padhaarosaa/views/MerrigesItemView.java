package com.padhaarosaa.views;

import android.content.Context;
import android.widget.TextView;

import com.padhaarosaa.Model.Merriages;
import com.padhaarosaa.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableLayout;
/**
 * Created by gspl on 12/9/2015.
 */
public class MerrigesItemView extends BindableLayout<Merriages>
{

    @Bind(R.id.list_item_tv_couple_name)
    TextView tvCoupleName;

    public MerrigesItemView(Context context)
    {
        super(context);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.list_item_view;
    }

    @Override
    public void bind(Merriages merriages)
    {
        tvCoupleName.setText(merriages.getCoupleName().getBrideName()+" weds "+merriages.getCoupleName().getGroomName());
    }
}
