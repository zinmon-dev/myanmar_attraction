package xyz.aungpyaephyo.padc.myanmarattractions.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import xyz.aungpyaephyo.padc.myanmarattractions.R;

/**
 * Created by Asus on 7/15/2016.
 */
public class RegisterFragment extends Fragment {
    private EditText etDateOfBirth;

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_register, container, false);
        etDateOfBirth = (EditText)view.findViewById(R.id.et_date_of_birth);
        etDateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    //showThirdPartyDatePicker();
                    showDatePicker();
                }
            }
        });
        etDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showThirdPartyDatePicker();
                showDatePicker();
            }
        });

        final EditText etRegUsername = (EditText) view.findViewById(R.id.etRegusername);
        final EditText etRegEmail = (EditText) view.findViewById(R.id.etRegEmail);
        final EditText etRegPassword = (EditText) view.findViewById(R.id.etRegPassword);
        final EditText etRegBD = (EditText) view.findViewById(R.id.et_date_of_birth);
        final Spinner etRegCountry = (Spinner) view.findViewById(R.id.spiner_country);

        Button btnRegister = (Button) view.findViewById(R.id.btn_registration);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etRegUsername.getText().toString();
                String email = etRegEmail.getText().toString();
                String password = etRegPassword.getText().toString();
                String dateofbirth = etRegBD.getText().toString();
                String country = etRegCountry.getSelectedItem().toString();
                if(userName.isEmpty() && email.isEmpty() && password.isEmpty() && dateofbirth.isEmpty())
                {
                    Toast.makeText(getContext(),"Fill all content",Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });

        return view;
    }

    public void showDatePicker(){

        DialogFragment newFragment = new MyDatePickerDialog();
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

    }
    private void showThirdPartyDatePicker(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog thirdPartyDatePicker = DatePickerDialog.newInstance(
                (DatePickerDialog.OnDateSetListener) this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        thirdPartyDatePicker.show(getActivity().getFragmentManager(), "ThirdPartyDatePicker");

    }

    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(getContext(), "Year : " + year + " Month : " + monthOfYear + " Day : " + dayOfMonth, Toast.LENGTH_SHORT).show();
    }
}
