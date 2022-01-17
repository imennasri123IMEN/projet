package isetb.TP6.hellostudent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView l;
    private DatabaseHelper db;
    private userAdaptater adapter;
    private ArrayList<isetb.tp6.hellostudent.user> listStudent;
    private FloatingActionButton btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        l=findViewById(R.id.list_view);
        int nbuser=db.getuserCount();
        if(nbuser==0)
        {
            Toast.makeText(this, "Empty Database", Toast.LENGTH_SHORT).show();
        }else
        {
            listuser=db.getAlluser();
            adapter=new userAdaptater(this,listuser);
            l.setAdapter(adapter);
        }
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                View subView=inflater.inflate(R.layout.add_user,null,true);
                EditText n=subView.findViewById(R.id.edit_name);
                EditText p=subView.findViewById(R.id.edit_phone);
                AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);

                a.setView(subView);
                a.create();
                a.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=n.getText().toString();
                        String phone=p.getText().toString();
                        isetb.tp6.hellostudent.user s=new isetb.tp6.hellostudent.user(name,phone);
                        db.adduser(s);
                        finish();
                        startActivity(getIntent());
                    }
                });

                a.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });



                a.show();
            }
        });



    }
}





