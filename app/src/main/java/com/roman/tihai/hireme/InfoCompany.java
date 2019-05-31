package com.roman.tihai.hireme;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoCompany extends AppCompatActivity {
    private EditText editName;
    private EditText editEmail;
    private EditText editDate;
    private EditText editLink;
    private EditText editInfo;
    private RadioGroup rbtnGrp;
    private RadioButton rbtn;

    private int position;
    private ArrayList<Company> companyArrayList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_company);
        Intent intent = getIntent();

        String editName = intent.getStringExtra("CompanyName");
        String editEmail = intent.getStringExtra("Email");
        String editDate = intent.getStringExtra("Date");
        String editLink = intent.getStringExtra("Link");
        String editInfo = intent.getStringExtra("info");

        this.position = intent.getIntExtra("Position", 0);

        this.companyArrayList = intent.getParcelableArrayListExtra("Companies");

        this.editName = findViewById(R.id.company_name_text);
        this.editEmail = findViewById(R.id.email_text);
        this.editDate = findViewById(R.id.date_send_text);
        this.editLink = findViewById(R.id.link_text);
        this.editInfo = findViewById(R.id.addition_information_text);
        this.rbtnGrp = findViewById(R.id.radioGroup);

        this.editName.setText(editName);
        this.editEmail.setText(editEmail);
        this.editDate.setText(editDate);
        this.editLink.setText(editLink);
        this.editInfo.setText(editInfo);

    }

    private String getStatus(){
        int selectedBtnId = rbtnGrp.getCheckedRadioButtonId();
        rbtn = findViewById(selectedBtnId);
        return rbtn.getText().toString();
    }

    public void onHideClicked(View view) {

        final String CompanyName = editName.getText().toString().trim();
        final String Email = editEmail.getText().toString().trim();
        final String Date = editDate.getText().toString().trim();
        final String Link = editLink.getText().toString().trim();
        final String Info = editInfo.getText().toString();
        String Status = this.getStatus();

        if(!CompanyName.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("CompanyName", CompanyName);
            intent.putExtra("Email", Email);
            intent.putExtra("Date", Date);
            intent.putExtra("Link", Link);
            intent.putExtra("Info", Info);
            intent.putExtra("Status", Status);
            setResult(RESULT_FIRST_USER, intent);
            intent.putExtra("Positions", this.position);
            finish();

        } else {

        }
        finish();
    }


    public void onEditClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Positions", this.position);
        setResult(RESULT_OK, intent);
        finish();
    }
}
