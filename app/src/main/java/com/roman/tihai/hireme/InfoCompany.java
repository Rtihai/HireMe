package com.roman.tihai.hireme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class InfoCompany extends AppCompatActivity {
    private TextView CompanyName;
    private TextView Email;
    private TextView Date;
    private TextView Link;
    private TextView Info;
    private TextView Status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_company);
        Intent intent = getIntent();

        String CompanyName = intent.getStringExtra("CompanyName");
        String Email = intent.getStringExtra("Email");
        String Date = intent.getStringExtra("Date");
        String Link = intent.getStringExtra("Link");
        String Info = intent.getStringExtra("info");
        String Status = intent.getStringExtra("Status");

        this.CompanyName = findViewById(R.id.company_name_text);
        this.Email = findViewById(R.id.email_text);
        this.Date = findViewById(R.id.date_send_text);
        this.Link = findViewById(R.id.link_text);
        this.Info = findViewById(R.id.addition_information_text);

        this.CompanyName.setText(CompanyName);
        this.CompanyName.setText(Email);
        this.CompanyName.setText(Date);
        this.CompanyName.setText(Link);
        this.CompanyName.setText(Info);

//        I think We don't need radio button on this view
//        we can put TextView as a status instead of the buttons. How do you think?

//        this.Status = findViewById(R.id.)
    }

}
