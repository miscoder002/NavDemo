package com.example.navdemo.ui.student;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navdemo.R;
import com.example.navdemo.databinding.FragmentBBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BFragment extends Fragment implements View.OnClickListener{

    FragmentBBinding binding;
    NavController navController;
    public BFragment() {
        // Required empty public constructor
    }


    public static BFragment newInstance(String param1, String param2) {
        BFragment fragment = new BFragment();
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
        binding = FragmentBBinding.inflate(inflater, container, false);
        binding.btnToC.setOnClickListener(this);
        binding.btnBackA.setOnClickListener(this);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // onViewCreated 方法 顧名思義 表示整個UI畫面已經  ready 此時操作任何UI物件最安全
        navController = Navigation.findNavController(view);

    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.btnToC:
                navController.navigate(R.id.action_BFragment_to_CFragment);
                break;
            case R.id.btnBackA:
                // 透過 Activity 觸發 onBack 動作 , fragment 本身無此功能
                getActivity().onBackPressed();
                break;

        }
    }
}