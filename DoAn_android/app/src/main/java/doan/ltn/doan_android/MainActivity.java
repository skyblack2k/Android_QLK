package doan.ltn.doan_android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import doan.ltn.doan_android.Fragment.Home.HomeFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.button_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.subactivity, new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.home_nav:
                        fragment = new HomeFragment();
                        break;
                    case R.id.storage_nav:
                        fragment = new HomeFragment();

                        break;
                    case R.id.customer_nav:
                        fragment = new HomeFragment();
                        break;

                    case R.id.setting_nav:
                        fragment = new HomeFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.subactivity, fragment).commit();


                return true;
            }
        });
    }

}