package com.example.application.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.application.R;

public class SupportFragment extends Fragment implements View.OnClickListener {
    MainActivity main = new MainActivity();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_support, container, false);
        onInitializeElements(v);
        return v;
    }

    public void onInitializeElements(View v){
        final TextView text_support_name=v.findViewById(R.id.support_name);
        final TextView text_support_question= v.findViewById(R.id.support_question);
        final TextView text_support_text=v.findViewById(R.id.support_text);
        final TextView text_donation_amount=v.findViewById(R.id.donation_ammount);
        final TextView text_donation_msg=v.findViewById(R.id.donation_message);

        main.HideKeyboardEditText(text_support_name);
        main.HideKeyboardEditText(text_support_question);
        main.HideKeyboardEditText(text_support_text);
        main.HideKeyboardEditText(text_donation_amount);
        main.HideKeyboardEditText(text_donation_msg);
    }

    @Override
    public void onClick(View v) {

    }
}
