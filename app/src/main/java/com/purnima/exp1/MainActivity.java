package com.purnima.exp1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LayoutFragments into containers
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        //FragA
        FragmentA mFragmentA = new FragmentA();
        mFragmentTransaction.replace(R.id.containerA,mFragmentA);

        //FragB
        FragmentB mFragmentB = new FragmentB();
        mFragmentTransaction.replace(R.id.containerB,mFragmentB);

        mFragmentTransaction.commit();

    }
}
