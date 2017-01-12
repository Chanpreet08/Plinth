package com.lnmiit.plinth.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lnmiit.plinth.Activity.SharedPreferences;
import com.lnmiit.plinth.Model.Contact;
import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.R;
import com.lnmiit.plinth.Tool.Tools;
import com.lnmiit.plinth.response.ContactUsResponse;
import com.lnmiit.plinth.rest.ApiClient;
import com.lnmiit.plinth.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

    private EditText name;
    private EditText email;
    private EditText query;
    private Button phone;
    private Button email_bt;
    private Button submit;
    ProgressDialog pd;
    User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);
        name = (EditText) v.findViewById(R.id.contactus_name);
        email = (EditText) v.findViewById(R.id.contactus_email);
        query = (EditText) v.findViewById(R.id.contactus_query);
        phone = (Button) v.findViewById(R.id.contactus_phone);
        email_bt = (Button) v.findViewById(R.id.contactus_email_bt);
        submit = (Button) v.findViewById(R.id.contactus_submit);
        pd = Tools.getProgressDialog(getContext());
        user=SharedPreferences.getSharedInfo(getContext());
        name.setText(user.getUsername());
        email.setText(user.getEmailId());
        email_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
                mailIntent.setData(Uri.parse("mailto:"));
                mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{ " plinth@lnmiit.ac.in"});
                startActivity(Intent.createChooser(mailIntent, "Send Mail via"));
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + "+91-9468590302"));
                startActivity(phoneIntent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact();
                contact.setContactName(name.getText().toString());
                contact.setContactEmail(email.getText().toString());
                contact.setContactQuery(query.getText().toString());
                pd.show();
                ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                Call<ContactUsResponse> call = apiService.sendContactUs(contact);
                call.enqueue(new Callback<ContactUsResponse>() {
                    @Override
                    public void onResponse(Call<ContactUsResponse> call, Response<ContactUsResponse> response) {
                        if (response.isSuccessful())
                        {
                            pd.dismiss();
                            Toast.makeText(getContext(),"We will get in touch soon!!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ContactUsResponse> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(getContext(),"Connection failed!!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return v;
    }

}
