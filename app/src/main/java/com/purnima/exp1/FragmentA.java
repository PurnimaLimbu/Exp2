package com.purnima.exp1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by purnimalimbu on 2017-08-24.
 */

public class FragmentA extends Fragment implements View.OnClickListener {
    //Instant Var
    private EditText mNumA;
    private EditText mNumB;
    private Button mAddButton;
    String valueA = "";
    String valueB = "";
    AddOnClickListener mAddOnClickListener;


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        //Link xml
        mNumA = (EditText) view.findViewById(R.id.numA);
        mNumB = (EditText) view.findViewById(R.id.numB);
        mAddButton = (Button) view.findViewById(R.id.add);

        mAddButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        //downcasting
         valueA = mNumA.getText().toString();
         valueB = mNumB.getText().toString();

        //Check if the the fiels are empty if so return Error
        if (valueA.isEmpty()) {
            mNumA.setError("This field is required");
            return;
        }

        if(valueB.isEmpty()){
            mNumB.setError("This field is required");
            return;
        }

        //String to int and sum

        int sum = Integer.parseInt(valueA)+Integer.parseInt(valueB);
        //sum int to string
        String s_sum = Integer.toString(sum);
        mAddOnClickListener.onAddClick(s_sum);
    }


    //Container Activity must implement this interface
    public interface AddOnClickListener {
        public void onAddClick(String sum);
    }

    //onAttach lifecycle method to communicate with Activity

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mAddOnClickListener = (AddOnClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement AddOnClickListener");
        }
    }


}
