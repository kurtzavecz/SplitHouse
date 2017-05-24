package com.zavecz.splithouse;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.defaultValue;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoommatesFragment extends Fragment {

    //define the variables
    private Button addMate;
    private EditText mateName;
    private TextView mate1;
    private TextView mate2;
    private TextView mate3;
    private TextView mate4;
    private TextView payTv1;
    private TextView payTv2;
    private TextView payTv3;
    private TextView payTv4;
    private TextView payAmmount1;
    private TextView payAmmount2;
    private TextView payAmmount3;
    private TextView payAmmount4;
    private Button hide1Bt;
    private Button hide2Bt;
    private Button hide3Bt;
    private Button hide4Bt;
    private Button clearBt;
    private Button applyBt;
    private TextView noteF;

    private String msg;

    public RoommatesFragment() {
        // Required empty public constructor
    }
    public static RoommatesFragment newInstance() {
        RoommatesFragment roommatesFragment = new RoommatesFragment();
        return roommatesFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_roommates, container, false);
        super.onCreate(savedInstanceState);

        //get refference to widgets
        mate1 = (TextView) view.findViewById(R.id.mate1);
        mate2 = (TextView) view.findViewById(R.id.mate2);
        mate3 = (TextView) view.findViewById(R.id.mate3);
        mate4 = (TextView) view.findViewById(R.id.mate4);
        payTv1 = (TextView) view.findViewById(R.id.payTv1);
        payTv2 = (TextView) view.findViewById(R.id.payTv2);
        payTv3 = (TextView) view.findViewById(R.id.payTv3);
        payTv4 = (TextView) view.findViewById(R.id.payTv4);
        payAmmount1 = (TextView) view.findViewById(R.id.payAmmount1);
        payAmmount2 = (TextView) view.findViewById(R.id.payAmmount2);
        payAmmount3 = (TextView) view.findViewById(R.id.payAmmount3);
        payAmmount4 = (TextView) view.findViewById(R.id.payAmmount4);
        hide1Bt = (Button) view.findViewById(R.id.hide1Bt);
        hide2Bt = (Button) view.findViewById(R.id.hide2Bt);
        hide3Bt = (Button) view.findViewById(R.id.hide3Bt);
        hide4Bt = (Button) view.findViewById(R.id.hide4Bt);
        mateName = (EditText) view.findViewById(R.id.mateName);
        addMate = (Button) view.findViewById(R.id.mateBt);
        clearBt = (Button) view.findViewById(R.id.clearBt);
        applyBt = (Button) view.findViewById(R.id.applyBt);
        noteF = (TextView) view.findViewById(R.id.noteF);

        //set the listeners
        addMate.setOnClickListener(onClick());
        hide1Bt.setOnClickListener(hide1Click());
        hide2Bt.setOnClickListener(hide2Click());
        hide3Bt.setOnClickListener(hide3Click());
        hide4Bt.setOnClickListener(hide4Click());
        clearBt.setOnClickListener(clearAll());
        applyBt.setOnClickListener(calcAndApply());

        return view;
    }

    //Constructor to clear all the roomates to start over
    //it hides all the widgets and clears the names.
    private View.OnClickListener clearAll() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mate1.setText("none");
                mate1.setVisibility(View.GONE);
                payTv1.setVisibility(View.GONE);
                payAmmount1.setVisibility(View.GONE);
                hide1Bt.setVisibility(View.GONE);

                mate2.setText("none");
                mate2.setVisibility(View.GONE);
                payTv2.setVisibility(View.GONE);
                payAmmount2.setVisibility(View.GONE);
                hide2Bt.setVisibility(View.GONE);

                mate3.setText("none");
                mate3.setVisibility(View.GONE);
                payTv3.setVisibility(View.GONE);
                payAmmount3.setVisibility(View.GONE);
                hide3Bt.setVisibility(View.GONE);

                mate4.setText("none");
                mate4.setVisibility(View.GONE);
                payTv4.setVisibility(View.GONE);
                payAmmount4.setVisibility(View.GONE);
                hide4Bt.setVisibility(View.GONE);
            }
        };
    }

    //constructor to check how many roomates there are and then use sthat count
    //to divide the total bills ammount and sets the widgets to display the ammount
    private View.OnClickListener calcAndApply() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(mate1.getVisibility() == View.VISIBLE){
                    count++;
                }if(mate2.getVisibility() == View.VISIBLE){
                    count++;
                }if(mate3.getVisibility() == View.VISIBLE){
                    count++;
                }if(mate4.getVisibility() == View.VISIBLE){
                    count++;
                }

                //getting the total from the BillsFragment
                String str = ((TextView)getActivity().findViewById(R.id.textView3)).getText().toString();

                double tots = Double.valueOf(str) / count;
                String dd = Double.toString(tots);

                payAmmount1.setText("$"+String.valueOf(dd));
                payAmmount2.setText("$"+String.valueOf(dd));
                payAmmount3.setText("$"+String.valueOf(dd));
                payAmmount4.setText("$"+String.valueOf(dd));
            }
        };
    }


    //removes the roommate
    private View.OnClickListener hide1Click() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mate1.setText("none");
                mate1.setVisibility(View.GONE);
                payTv1.setVisibility(View.GONE);
                payAmmount1.setVisibility(View.GONE);
                hide1Bt.setVisibility(View.GONE);
            }
        };
    }
    //removes the roommate
    private View.OnClickListener hide2Click() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mate2.setText("none");
                mate2.setVisibility(View.GONE);
                payTv2.setVisibility(View.GONE);
                payAmmount2.setVisibility(View.GONE);
                hide2Bt.setVisibility(View.GONE);
            }
        };
    }
    //removes the roommate
    private View.OnClickListener hide3Click() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mate3.setText("none");
                mate3.setVisibility(View.GONE);
                payTv3.setVisibility(View.GONE);
                payAmmount3.setVisibility(View.GONE);
                hide3Bt.setVisibility(View.GONE);
            }
        };
    }
    //removes the roommate
    private View.OnClickListener hide4Click() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mate4.setText("none");
                mate4.setVisibility(View.GONE);
                payTv4.setVisibility(View.GONE);
                payAmmount4.setVisibility(View.GONE);
                hide4Bt.setVisibility(View.GONE);
            }
        };
    }


    //Constructor to add the roommate and make the respected widgets
    //visible to the screen
    private View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mate1.getText().equals("none")){
                    mate1.setText(mateName.getText().toString());
                    mate1.setVisibility(View.VISIBLE);
                    payTv1.setVisibility(View.VISIBLE);
                    payAmmount1.setVisibility(View.VISIBLE);
                    hide1Bt.setVisibility(View.VISIBLE);
                    mateName.setText("");
                }else if(mate2.getText().equals("none")){
                    mate2.setText(mateName.getText().toString());
                    mate2.setVisibility(View.VISIBLE);
                    payTv2.setVisibility(View.VISIBLE);
                    payAmmount2.setVisibility(View.VISIBLE);
                    hide2Bt.setVisibility(View.VISIBLE);
                    mateName.setText("");
                }else if(mate3.getText().equals("none")){
                    mate3.setText(mateName.getText().toString());
                    mate3.setVisibility(View.VISIBLE);
                    payTv3.setVisibility(View.VISIBLE);
                    payAmmount3.setVisibility(View.VISIBLE);
                    hide3Bt.setVisibility(View.VISIBLE);
                    mateName.setText("");
                }else if(mate4.getText().equals("none")){
                    mate4.setText(mateName.getText().toString());
                    mate4.setVisibility(View.VISIBLE);
                    payTv4.setVisibility(View.VISIBLE);
                    payAmmount4.setVisibility(View.VISIBLE);
                    hide4Bt.setVisibility(View.VISIBLE);
                    mateName.setText("");
                }

            }
        };
    }
}