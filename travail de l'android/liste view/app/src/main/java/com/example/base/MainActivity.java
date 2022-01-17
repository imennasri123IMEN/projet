package com.example.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
String mtitle[]={"bus","taxi","avion"};
    String mdescription[]={"bus","taxi","avion"};
    int image[]={R.drawable.bus,R.drawable.taxi,R.drawable.avion};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);


        class MyAdapter extends ArrayAdapter<String> {
            Context context;
            String rtitle[];
            String rdescription[];
            int rimg[];

            MyAdapter(Context c, String title[], String description[], int imgs[]) {
                super(c, R.layout.row, R.id.text1, title);
                this.context = c;
                this.rtitle = title;
                this.rdescription = description;
                this.rimg = imgs;

            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
                View row = layoutInflater.inflate(R.layout.row, parent, false);
                ImageView image = row.findViewById(R.id.image);
                TextView myTitle = row.findViewById(R.id.text1);
                TextView myDescription = row.findViewById(R.id.text2);
                image.setImageResource(rimg[position]);
                myTitle.setText(rtitle[position]);
                myDescription.setText(rdescription[position]);
                return row;
            }
        }
    }}
