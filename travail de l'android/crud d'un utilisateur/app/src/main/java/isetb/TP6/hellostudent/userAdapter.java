package isetb.TP6.hellostudent;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

class userAdaptater extends ArrayAdapter<isetb.tp6.hellostudent.user> {
    Activity context;
    ArrayList<isetb.tp6.hellostudent.user> listuser;
    DatabaseHelper db;



    public userAdaptater(Activity context, ArrayList<isetb.tp6.hellostudent.user> listuser) {
        super(context, R.layout.user_item,listuser);
        this.context = context;
        this.listuser = listuser;

    }

    @NonNull
    @Override
    //convertir le fichier xml en view
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view= inflater.inflate(R.layout.user_item,null,false);
        TextView t1=view.findViewById(R.id.text_id);
        TextView t2=view.findViewById(R.id.text_nom);
        TextView t3=view.findViewById(R.id.text_phone);
        ImageView img1=view.findViewById(R.id.edit_user);
        ImageView img2=view.findViewById(R.id.delete_user);
        //n3abiw les textes views
        t1.setText(String.valueOf(listuser.get(position).getId()));
        t2.setText(listuser.get(position).getName());
        t3.setText(listuser.get(position).getPhone());
        //la position pour afficher l'etudiant que j'ai séléctionné
        isetb.tp6.hellostudent.user s=listuser.get(position);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater1=LayoutInflater.from(context);
                View subView=inflater1.inflate(R.layout.user_student,null,false);
                EditText n=subView.findViewById(R.id.edit_name);
                EditText p=subView.findViewById(R.id.edit_phone);
                n.setText(s.getName());
                p.setText(s.getPhone());
                AlertDialog.Builder a=new AlertDialog.Builder(context);
                a.setTitle("Edit user");
                a.setView(subView);
                a.create();
                a.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db=new DatabaseHelper(context);
                        String name=n.getText().toString();
                        String phone=p.getText().toString();
                        isetb.tp6.hellostudent.user user=new isetb.tp6.hellostudent.user(name,phone);
                        db.updateuser(user, s.getId());
                        context.finish();
                        context.startActivity(context.getIntent());
                    }
                });
                a.show();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater1= LayoutInflater.from(context);
                View subView=inflater1.inflate(R.layout.add_user,null);
                EditText n=subView.findViewById(R.id.edit_name);
                EditText p=subView.findViewById(R.id.edit_phone);
                n.setText(s.getName());
                p.setText(s.getPhone());
                AlertDialog.Builder a=new AlertDialog.Builder(context);
                a.setView(subView);
                a.create();
                a.setTitle("Edit user");
                a.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db=new DatabaseHelper(context);
                        String name=n.getText().toString();
                        String phone=p.getText().toString();
                        isetb.tp6.hellostudent.user user=new isetb.tp6.hellostudent.user(name, phone);
                        db.updateuser(user,s.getId());
                        context.finish();
                        context.startActivity(context.getIntent());
                    }
                });
                a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                a.show();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DatabaseHelper(context);
                db.removeuser(s.getId());
                context.finish();
                context.startActivity(context.getIntent());
                Toast.makeText(context, "user Deleted", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }

}