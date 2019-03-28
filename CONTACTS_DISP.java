package com.example.shreyaghose.umeed;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class CONTACTS_DISP extends AppCompatActivity {
    private Button loadContacts;
    private   TextView listContacts;

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts__disp);

        listContacts = (TextView) findViewById(R.id.ListContacts);
        loadContacts = (Button) findViewById(R.id.LoadContacts);

        loadContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadContacts();
            }
        });
        //btn.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent I211 = new Intent(Intent.ACTION_CALL);
               // I211.setData(Uri.parse("tel:9404358588"));
            //}
        //});

    }

    private void loadContacts() {
        StringBuilder builder = new StringBuilder();
        //StringBuilder builder2 = new StringBuilder();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));

                if (hasPhoneNumber > 0) {
                    Cursor cursor2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", new String[]{id}, null);

                    while (cursor2.moveToNext()) {
                        String phoneNumber = cursor2.getString(cursor2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        builder.append("\n\n").append("Contact: ").append(name).append("\n").append(" Phone Number : ").append(phoneNumber).append("\n\n");

                    }
                    cursor2.close();


                }
            }
        }
        cursor.close();
        listContacts.setText(builder.toString());





    }

}

