package com.example.navdemo.ui.student;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.navdemo.R;
import com.example.navdemo.databinding.FragmentABinding;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AFragment extends Fragment {

    FragmentABinding binding;
    NavController navController;

    public AFragment() {
        // Required empty public constructor
    }


    public static AFragment newInstance(String param1, String param2) {
        AFragment fragment = new AFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentABinding.inflate(inflater, container, false);
        binding.btnToB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_AFragment_to_BFragment);
            }
        });
        binding.btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DatePickerDialog
                Calendar calendar = Calendar.getInstance(); //取得 Java內建的 日曆物件
                int y = calendar.YEAR;
                int m = calendar.MONTH;
                int d = calendar.DATE;
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            binding.txtYear.setText( String.valueOf(year) );
                            binding.txtMonth.setText(String.valueOf(month) );
                            binding.txtDay.setText(String.valueOf(dayOfMonth) );
                    }
                } , y, m, d);
                dialog.show();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

    }
}