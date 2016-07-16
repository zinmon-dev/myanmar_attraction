package xyz.aungpyaephyo.padc.myanmarattractions.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import xyz.aungpyaephyo.padc.myanmarattractions.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserActivityFragment extends Fragment {

    public UserActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_user, container, false);
        final EditText etEmail = (EditText) view.findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) view.findViewById(R.id.etPassword);
        Button btnLogin = (Button) view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= etEmail.getText().toString();
                String password= etPassword.getText().toString();

                if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(getContext(),"Please fill username and password",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btnLinkToRegister = (Button) view.findViewById(R.id.btnLinkToRegisterScreen);

        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Go to register",Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager2 = getFragmentManager();
                RegisterFragment pulseFragment=RegisterFragment.newInstance();
                fragmentManager2.beginTransaction()
                        .replace(R.id.fl_container, pulseFragment)
                       .commit();
            }
        });

        return view;
    }
}
