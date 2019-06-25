package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayOccupiedRooms extends AppCompatActivity {

    ListView listViewRooms;
    DatabaseReference databaseRooms;
    String roomIDSelected;
    List<Room> roomList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_occupied_rooms);
        databaseRooms = FirebaseDatabase.getInstance().getReference("rooms");
        Intent intent = getIntent();
        roomList = new ArrayList<>();
        listViewRooms = (ListView) findViewById(R.id.listViewRooms);

        //Setting onLongClickListener for the updateDialog to prompt
        listViewRooms.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //getting the selected room item form the ArrayList.
                Room room = roomList.get(position);
                roomIDSelected = String.valueOf(room.getRoomID());
                showUpdateDialog(roomIDSelected);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseRooms.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                roomList.clear();
                for(DataSnapshot roomSnapshot : dataSnapshot.getChildren()){
                    Room room = roomSnapshot.getValue(Room.class);

                    Log.i("CURRENT_ROOM", String.valueOf(room.getRoomID()));
                    Log.i("CURRENT_ROOM_PRICE", String.valueOf(room.getPrice_per_night()));

                    roomList.add(room);
                }
                RoomList adapter = new RoomList(DisplayOccupiedRooms.this, roomList);
                listViewRooms.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void showUpdateDialog(final String roomID){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);

        dialogBuilder.setView(dialogView);

        final EditText editText_room_size = (EditText) dialogView.findViewById(R.id.editText_room_size);
        final EditText editText_room_floor = (EditText) dialogView.findViewById(R.id.editText_room_floor);
        final Spinner editText_room_status = (Spinner) dialogView.findViewById(R.id.roomStatus);
        final EditText editText_room_price = (EditText) dialogView.findViewById(R.id.editText_room_price);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.update);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle("Update details of Room ID :  " + roomID);

        //creating the alert dialog using the builder
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String size = editText_room_size.getText().toString();
                    int floor = Integer.parseInt(editText_room_floor.getText().toString());
                    String status = editText_room_status.getSelectedItem().toString();
                    int price = Integer.parseInt(editText_room_price.getText().toString());


                    if (editText_room_size.getText().toString().isEmpty() == true) {
                        editText_room_size.setError("Room size required !");
                    } else if (editText_room_floor.getText().toString().isEmpty() == true) {
                        editText_room_floor.setError("Room floor required !");
                    } else if (editText_room_status.getSelectedItem().toString().isEmpty() == true) {
                        editText_room_price.setError("Price per night of the room required !");
                    } else if (editText_room_price.getText().toString().isEmpty() == true) {
                        Toast.makeText(DisplayOccupiedRooms.this, "Status of the room should be included !", Toast.LENGTH_SHORT).show();
                    } else {
                        updateRommDetails(Integer.parseInt(roomIDSelected), floor, size, status, price);

                        alertDialog.dismiss();
                    }
                } catch (NumberFormatException ex) {
                    Toast.makeText(DisplayOccupiedRooms.this, "Please fill all the required Fields !", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRoom(roomID);
            }
        });

    }

    private void deleteRoom(String roomID) {
        DatabaseReference DBrefRoom = FirebaseDatabase.getInstance().getReference("rooms").child(roomID);

        //This will remove the tree reference from the database.
        DBrefRoom.removeValue();

        Toast.makeText(this, "Room details deleted successfully !", Toast.LENGTH_SHORT).show();
    }

    private boolean updateRommDetails(int roomID, int roomFloor, String roomSize, String roomStatus, int price_per_night){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("rooms").child(String.valueOf(roomID));

        Room room = new Room(roomID, roomFloor, roomSize, roomStatus, price_per_night);

        databaseReference.setValue(room);

        Toast.makeText(this, "Room details updated successfully!", Toast.LENGTH_LONG).show();

        return true;
    }
}
