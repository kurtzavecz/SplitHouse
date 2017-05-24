package com.zavecz.splithouse;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BillsFragment extends Fragment{

    //define variables
    public Button addBillBt;
    public EditText billNameEt;
    public TextView bill1;
    public TextView bill2;
    public TextView bill3;
    public TextView bill4;
    public TextView bill5;
    public EditText billPay1;
    public EditText billPay2;
    public EditText billPay3;
    public EditText billPay4;
    public EditText billPay5;
    public TextView textView3;
    public Button button2;



    public BillsFragment() {
        // Required empty public constructor
    }
    public static BillsFragment newInstance() {
        BillsFragment billsFragment = new BillsFragment();
        return billsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bills, container, false);

        //get refferences
        addBillBt = (Button) view.findViewById(R.id.addBillBt);
        billNameEt = (EditText) view.findViewById(R.id.billNameEt);
        bill1 = (TextView) view.findViewById(R.id.bill1);
        bill2 = (TextView) view.findViewById(R.id.bill2);
        bill3 = (TextView) view.findViewById(R.id.bill3);
        bill4 = (TextView) view.findViewById(R.id.bill4);
        bill5 = (TextView) view.findViewById(R.id.bill5);
        billPay1 = (EditText) view.findViewById(R.id.billPay1);
        billPay2 = (EditText) view.findViewById(R.id.billPay2);
        billPay3 = (EditText) view.findViewById(R.id.billPay3);
        billPay4 = (EditText) view.findViewById(R.id.billPay4);
        billPay5 = (EditText) view.findViewById(R.id.billPay5);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        button2 = (Button) view.findViewById(R.id.button2);

        //set listeners
        addBillBt.setOnClickListener(addBillClick());
        button2.setOnClickListener(totalClick());


        return view;
    }

    //when the total button is clicked it shows the total ammount added up
    private View.OnClickListener totalClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tots = Double.parseDouble(getTotal());
                textView3.setText(Double.toString(tots));

            }
        };
    }

    //constructor to get the total bills, if the widget is not visible
    //it is set to 0 thus not added into the total.
    public String getTotal(){
        double total = Double.parseDouble(billPay1.getText().toString())
                + Double.parseDouble(billPay2.getText().toString())
                + Double.parseDouble(billPay3.getText().toString())
                + Double.parseDouble(billPay4.getText().toString())
                + Double.parseDouble(billPay5.getText().toString());

        return String.valueOf(total);
    }

    //Constructor to add a bills name and then make the widget visible
    //after each click the edittext is cleared to enter a new name
    private View.OnClickListener addBillClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bill1.getText().equals("none")){
                    bill1.setText(billNameEt.getText().toString());
                    bill1.setVisibility(View.VISIBLE);
                    billPay1.setVisibility(View.VISIBLE);
                    billNameEt.setText("");
                }else if(bill2.getText().equals("none")){
                    bill2.setText(billNameEt.getText().toString());
                    bill2.setVisibility(View.VISIBLE);
                    billPay2.setVisibility(View.VISIBLE);
                    billNameEt.setText("");
                }else if(bill3.getText().equals("none")){
                    bill3.setText(billNameEt.getText().toString());
                    bill3.setVisibility(View.VISIBLE);
                    billPay3.setVisibility(View.VISIBLE);
                    billNameEt.setText("");
                }else if(bill4.getText().equals("none")){
                    bill4.setText(billNameEt.getText().toString());
                    bill4.setVisibility(View.VISIBLE);
                    billPay4.setVisibility(View.VISIBLE);
                    billNameEt.setText("");
                }else if(bill5.getText().equals("none")){
                    bill5.setText(billNameEt.getText().toString());
                    bill5.setVisibility(View.VISIBLE);
                    billPay5.setVisibility(View.VISIBLE);
                    billNameEt.setText("");
                }

            }
        };
    }
}
