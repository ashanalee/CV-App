package com.example.cvapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class cv2 extends AppCompatActivity {
    EditText cname,gender,eemail,contact,degree,skill,expe,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv2);
        cname = findViewById(R.id.cname);
        gender = findViewById(R.id.cgender);
        eemail = findViewById(R.id.cemail);
        contact = findViewById(R.id.ccontact);
        degree = findViewById(R.id.cdegree);
        skill = findViewById(R.id.cskill);
        expe = findViewById(R.id.cexpe);
        desc = findViewById(R.id.cdes);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        cname.setText(""+name);

        Intent j = getIntent();
        String gen = j.getStringExtra("gender");
        gender.setText(""+gen);

        Intent k = getIntent();
        String email = k.getStringExtra("email");
        eemail.setText(""+email);

        Intent l = getIntent();
        String contact1 = l.getStringExtra("contact");
        contact.setText(""+contact1);

        Intent n = getIntent();
        String degree1 = n.getStringExtra("degree");
        degree.setText(""+degree1);

        Intent in = getIntent();
        String skills = in.getStringExtra("skill");
        skill.setText(""+skills);

        Intent inexp = getIntent();
        String exp = inexp.getStringExtra("Experience");
        expe.setText(""+exp);

        Intent p = getIntent();
        String desc1 = p.getStringExtra("Description");
        desc.setText(""+desc1);
    }
}