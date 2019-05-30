package com.roman.tihai.hireme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Company> mCompanyList;

    CompanyAdapter(Context context, ArrayList<Company> mCompanyList){
        this.mCompanyList = mCompanyList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }



    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.list_companys_item, viewGroup, false);
        return new CompanyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder companyViewHolder, final int i) {
        companyViewHolder.bind(mCompanyList.get(i));

    }

    @Override
    public int getItemCount() {

        return (mCompanyList == null) ? 0 : mCompanyList.size();
    }

    public class CompanyViewHolder extends RecyclerView.ViewHolder {
        private TextView mCompanyNameTV;
        private TextView mEmailTV;
        private TextView mStatusTV;
        private Button mBtn;



        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCompanyNameTV = itemView.findViewById(R.id.company_name_text);
            mEmailTV = itemView.findViewById(R.id.email_text);
            mStatusTV = itemView.findViewById(R.id.status_radio_textview);
            mBtn = itemView.findViewById(R.id.expand_company_info);
        }

        public void bind(Company company){
            mCompanyNameTV.setText(company.getCompanyName());
            mEmailTV.setText(company.getEmail());
            mStatusTV.setText(company.getStatus());
        }



    }
}
