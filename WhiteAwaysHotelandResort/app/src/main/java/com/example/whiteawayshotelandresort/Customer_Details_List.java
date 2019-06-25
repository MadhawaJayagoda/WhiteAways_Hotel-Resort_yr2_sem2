package com.example.whiteawayshotelandresort;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Customer_Details_List extends ArrayAdapter<Customer_Details> {
    private Activity context;
    private List<Customer_Details> customerDetailsList;

    public Customer_Details_List(Activity context, List<Customer_Details> customerDetailsList){
        super(context, R.layout.list_layout, customerDetailsList);
        this.context = context;
        this.customerDetailsList = customerDetailsList;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){

        LayoutInflater  inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewCustomerName = (TextView) listViewItem.findViewById(R.id.textViewCustomerName);
        TextView textViewRoomId = (TextView) listViewItem.findViewById(R.id.textViewRoomId);
        TextView textViewDayIn = (TextView) listViewItem.findViewById(R.id.textViewDayIn);
        TextView textViewDayOut = (TextView) listViewItem.findViewById(R.id.textViewDayOut);
        TextView textViewDayCount = (TextView) listViewItem.findViewById(R.id.textViewDayCount);

        Customer_Details customerDetails = customerDetailsList.get(position);

        textViewCustomerName.setText(customerDetails.getReservation_made_by());
        textViewRoomId.setText("\t\tRoom ID :  " + String.valueOf(customerDetails.getRoomID()));
        textViewDayIn.setText("\t\tCheck in Date :  " + customerDetails.getDate_in());
        textViewDayOut.setText("\t\tCheck out Date :  " + customerDetails.getDate_out());
        textViewDayCount.setText("\t\tNumber of Days stayed :  " + Long.toString(customerDetails.getDay_count())+ "\n");

        return listViewItem;

    }
}


