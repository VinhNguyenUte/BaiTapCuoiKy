package com.example.btck;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.btck.Fragment.ChatFragment;
import com.example.btck.Fragment.FavoriteFragment;
import com.example.btck.Fragment.HomeFragment;
import com.example.btck.Fragment.NoticeFragment;
import com.example.btck.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo Fragment mặc định (HomeFragment)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        // Tham chiếu đến BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Xử lý sự kiện khi chọn item trong BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            // Sử dụng if-else thay vì switch-case
            if (item.getItemId() == R.id.home_icon) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.chat_icon) {
                selectedFragment = new ChatFragment();
            } else if (item.getItemId() == R.id.cart_icon) {
                selectedFragment = new FavoriteFragment();
            } else if (item.getItemId() == R.id.notification_icon) {
                selectedFragment = new NoticeFragment();
            } else if (item.getItemId() == R.id.profile_icon) {
                selectedFragment = new ProfileFragment();
            }

            // Thay thế Fragment hiện tại bằng Fragment được chọn
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });

    }
}