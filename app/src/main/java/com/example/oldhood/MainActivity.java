package com.example.oldhood;

import static kotlinx.coroutines.android.HandlerDispatcherKt.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.oldhood.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {



    ActivityMainBinding binding;

    private static final int CHAT_ID = R.id.chat;
    private static final int DELIVERY_ID = R.id.delivery;
    private static final int EMERGENCY_ID = R.id.emergency;
    private static final int MEDICATION_ID = R.id.medication;
    private static final int HOME_ID = R.id.home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == CHAT_ID) {
                replaceFragment(new ChatFragment());
            } else if (itemId == HOME_ID) {
                replaceFragment(new HomeFragment());
            } else if (itemId == EMERGENCY_ID) {
                replaceFragment(new EmergencyFragment());
            } else if (itemId == DELIVERY_ID) {
                replaceFragment((new DeliveryFragment()));
            } else if (itemId == MEDICATION_ID) {
                replaceFragment(new MedicationFragment());
            }


            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        // Create fragment manager and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the existing fragment with the new one
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        // Commit the transaction
        fragmentTransaction.commit();
    }
}