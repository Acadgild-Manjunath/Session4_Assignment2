package com.acadgild.com.session4_assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listContact;
    String[] names = new String[]{"Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name7"};
    String[] numbers = new String[]{"PhoneNumber1", "PhoneNumber2", "PhoneNumber3", "PhoneNumber4",
            "PhoneNumber5", "PhoneNumber6", "PhoneNumber7"};

    ArrayList<CustomHandler> arrList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = (ListView)findViewById(R.id.listContact);

        for(int i=0;i<names.length;i++)
        {
            CustomHandler handler = new CustomHandler();
            handler.setPersonName(names[i]);
            handler.setPhoneNumber(numbers[i]);
            arrList.add(handler);
        }

        CustomAdapter custAdp = new CustomAdapter(this, arrList);
        listContact.setAdapter(custAdp);
        listContact.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Toast.makeText(this,"Selected name is "+names[pos] + "\n" + "Selected number is "+numbers[pos], Toast.LENGTH_SHORT).show();

    }
}
