package com.example.navdemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navdemo.R;
import com.example.navdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // onCreateView 表示系統 "正在建立" UI 畫面 如需任何操作畫面的動作 可能導致失敗 綁定事件則例外
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用 NavController 切換到 AFragement
                // 請使用 Mobile_navigation 中的 Action ID
                navController.navigate(R.id.action_nav_home_to_AFragment);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // onViewCreated 方法 顧名思義 表示整個UI畫面已經  ready 此時操作任何UI物件最安全
        navController = Navigation.findNavController(view);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}