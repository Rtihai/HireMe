package com.roman.tihai.hireme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateCompanyActivity extends AppCompatActivity {


    private EditText editName;
    private EditText editEmail;
    private EditText editDate;
    private EditText editLink;
    private EditText editInfo;
    private RadioButton rbtn;

    private RadioGroup rbtnGrp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_company);

        this.editName = findViewById(R.id.edit_name);
        this.editEmail = findViewById(R.id.edit_email);
        this.editDate = findViewById(R.id.edit_date);
        this.editLink = findViewById(R.id.edit_link);
        this.editInfo = findViewById(R.id.edit_info);
        this.rbtnGrp = findViewById(R.id.radioGroup);

        Intent intent = getIntent();
        addListenerOnButton();
    }

    private void addListenerOnButton() {
    }

    private String getStatus(){
        int selectedBtnId = rbtnGrp.getCheckedRadioButtonId();
        rbtn = findViewById(selectedBtnId);
        return rbtn.getText().toString();
    }

    public void clickOnCancel(View view) {
        finish();
    }

    public void clickOnSave(View view) {
        final String CompanyName = editName.getText().toString().trim();
        final String Email = editEmail.getText().toString().trim();
        final String Date = editDate.getText().toString().trim();
        final String Link = editLink.getText().toString().trim();
        final String Info = editInfo.getText().toString();
        String Status = this.getStatus();

        if(!CompanyName.isEmpty()) {
            Intent intent = new Intent();
            intent.putExtra("CompanyName", CompanyName);
            intent.putExtra("Email", Email);
            intent.putExtra("Date", Date);
            intent.putExtra("Link", Link);
            intent.putExtra("Info", Info);
            intent.putExtra("Status", Status);
            setResult(RESULT_OK, intent);
            finish();

        } else {

        }

    }
}