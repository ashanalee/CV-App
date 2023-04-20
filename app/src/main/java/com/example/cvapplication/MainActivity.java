package com.example.cvapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name,email,desc,contact;
    Spinner exspinner;

    CheckBox male,fmale;

    String result,degree1,web1,graphic1,exp;
    Button submit;
    Button image;
    ImageView ve;
    RadioButton web,graphic;
    Switch degree;
    int select_image  =1;
    String[] expe = {"Select","1 Years","2 Years","3 Years","4 Years","5 Years"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        desc = findViewById(R.id.description);
        male = findViewById(R.id.male);
        fmale = findViewById(R.id.fmale);
        exspinner = findViewById(R.id.exspinner);
        submit = findViewById(R.id.submit);
        contact = findViewById(R.id.contact);
        web = findViewById(R.id.web);
        graphic = findViewById(R.id.graphic);
        degree = findViewById(R.id.switch1);
        ve= findViewById(R.id.imageView);
        image  = findViewById(R.id.select);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"title"),select_image);
            }
        });


       degree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(degree.isChecked())
               {
                   degree1 = "Done";
               }
               else
               {
                   degree1 = "Doing";
               }
           }
       });

       ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, expe);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exspinner.setAdapter(adapter3);
        exspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                exp  = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked())
                {
                    result = "Male";
                }
            }
        });

        fmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fmale.isChecked())
                {
                    result = "Female";
                }
            }
        });

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(web.isChecked())
            {
                web1 = "Web Development";
            }

            if(graphic.isChecked())
            {
                graphic1 = "Graphic Designing";
            }

            switch (view.getId())
            {
                case R.id.submit:
                    Intent i = new Intent(getApplicationContext(),cv2.class);
                    i.putExtra("name",name.getText().toString());
                    i.putExtra("email",email.getText().toString());
                    i.putExtra("contact",contact.getText().toString());
                    i.putExtra("description",desc.getText().toString());
                    i.putExtra("gender",result);
                    i.putExtra("degree",degree1);
                    i.putExtra("skill",graphic1);
                    i.putExtra("Experience",exp);
                    i.putExtra("Description",desc.getText().toString());
                    startActivity(i);
            }
        }
    });
    }
    protected void  OnActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1)
        {
            Uri Uri  = data.getData();
            ve.setImageURI(Uri);
        }
    }
}


