package com.purnima.exp1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.AddOnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LayoutFragments into containers
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        //FragA
        FragmentA mFragmentA = new FragmentA();
        mFragmentTransaction.replace(R.id.containerA, mFragmentA);

        //FragB
        FragmentB mFragmentB = new FragmentB();
        mFragmentTransaction.replace(R.id.containerB, mFragmentB);

        mFragmentTransaction.commit();

    }

    @Override
    public void onAddClick(String sum) {
        //Object of fragment 2
        FragmentB fragB = (FragmentB) getFragmentManager().findFragmentById(R.id.containerB);
        //call updateSum() from fragment B
        fragB.updateSum(sum);
    }
}
