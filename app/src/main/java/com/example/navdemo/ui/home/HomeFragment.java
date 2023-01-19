package com.example.navdemo.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navdemo.R;
import com.example.navdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;
    private SharedPreferences userInfo;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // onCreateView 表示系統 "正在建立" UI 畫面 如需任何操作畫面的動作 可能導致失敗 綁定事件則例外
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        userInfo = getActivity().getSharedPreferences("userInfo",MODE_PRIVATE);

        binding.btnToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用 NavController 切換到 AFragement
                // 請使用 Mobile_navigation 中的 Action ID
                String cate = userInfo.getString("cate","error");
                if( cate.equals("student")) {
                    // 如果是學生(訪客 非會員)
                    navController.navigate(R.id.action_nav_home_to_AFragment);
                } else if (cate.equals("teacher")) {
                    // 如果是老師(已登入會員)
                    navController.navigate(R.id.action_nav_home_to_DFragment);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("身分異常")
                            .setMessage("請確認您的身分\r\n 或是與 App管理人員聯絡")
                            .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                }
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