package com.example.whiteawayshotelandresort;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter class
 */
public class RoomList extends ArrayAdapter<Room> {

    private Activity context;
    private List<Room> roomList;

    public RoomList(Activity context, List<Room> roomList){
        super(context, R.layout.list_layout1, roomList);
        this.context = context;
        this.roomList = roomList;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout1, null, true);

        TextView textViewRoomID = (TextView) listViewItem.findViewById(R.id.textViewID);
        TextView textViewFloor = (TextView) listViewItem.findViewById(R.id.textViewFloor);
        TextView textViewRoomSize = (TextView) listViewItem.findViewById(R.id.textViewSize);
        TextView textViewRoomStatus = (TextView) listViewItem.findViewById(R.id.textViewStatus);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);

        Room room = roomList.get(position);

        textViewRoomID.setText("Room ID :  " + String.valueOf(room.getRoomID()));
        textViewFloor.setText("\t\tRoom Floor :  " + String.valueOf(room.getRoom_floor()));
        textViewRoomSize.setText("\t\tRoom Size :  " + room.getRoom_size());
        textViewRoomStatus.setText("\t\tRoom Status :  " + room.getRoom_status());
        textViewPrice.setText("\t\tPrice per Night :  " + String.valueOf(room.getPrice_per_night()) + "\n");

        return listViewItem;
    }
}
