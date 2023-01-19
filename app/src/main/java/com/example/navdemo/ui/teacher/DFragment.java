package com.example.navdemo.ui.teacher;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navdemo.R;
import com.example.navdemo.databinding.FragmentDBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DFragment extends Fragment {
    FragmentDBinding binding;
    NavController navController;

    public DFragment() {
        // Required empty public constructor
    }

    public static DFragment newInstance(String param1, String param2) {
        DFragment fragment = new DFragment();
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
        // Inflate the layout for this fragment
        binding = FragmentDBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


}