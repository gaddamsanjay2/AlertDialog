package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    UserPojo userPojo;
    UserAdapter userAdapter;
    List<UserPojo> userPojoList = new ArrayList<>();
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.customgrid);
        userAdapter = new UserAdapter(this, userPojoList);
        gridView.setAdapter(userAdapter);

        loadUserData1();

        // SIMPLE ALERT DIALOG

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                // Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                // intent.putExtra("imageKey",userPojoList.get(i).getEmpImage());
                //intent.putExtra("idKey",userPojoList.get(i).getName());
                //  intent.putExtra("nameKey",userPojoList.get(i).getMail());
                // intent.putExtra("salKey",userPojoList.get(i).getMobile());
                //   intent.putExtra("designationKey",userPojoList.get(i).getAddress());
                // startActivity(intent);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("hello android");
                builder.setMessage("Welcome to Alert Dialog");
                builder.setIcon(R.drawable.ic_baseline_battery_alert_24);
                builder.setCancelable(false);

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });
                builder.setNeutralButton("help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "help", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.create();
                builder.show();
            }
        });

        //CUSTOM ALERT DIALOG

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View root = getLayoutInflater().inflate(R.layout.dialog, null);
                builder.setView(root);
                builder.setCancelable(false);

                Button cancel = root.findViewById(R.id.btn1);
                Button ok = root.findViewById(R.id.btn2);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();


                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });

    }

    private void loadUserData1() {

        userPojo=new UserPojo(R.drawable.img,"sanjay","sanjay@gmail.com","1234567890","12345");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.img_1,"Raju","Raju@gmail.com","50,000","12341234");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.img_2,"sai","Sai@gmail.com","50,000","1234");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.img_3,"ram","ram@gmail.com","50,000","123456");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.img_4,"abhi","abhi@gmail.com","80,000","12345");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.img_5,"hari","hari@gmail.com","50,000","12345");
        userPojoList.add(userPojo);

        userAdapter.notifyDataSetChanged();

    }
}
