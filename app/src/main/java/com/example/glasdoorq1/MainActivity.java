package com.example.glasdoorq1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {


    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @SuppressLint("CutPasteId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new Jobs(), "Jobs");
        viewPagerAdapter.AddFragment(new Company(), "Companies");
        viewPagerAdapter.AddFragment(new salary(), "Salaries");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        ListView listView;
        String mTitle[]={"Senior Software Engineer Data","Staff Software Engineer"};
        int images[]={R.drawable.img1,R.drawable.img2};
        String description[]={"House Canary","One Medical"};
        String description2[]={"San Francisco,CA","San Francisco,CA"};
        String  rates[]={"$147k-$166k(Glassdoor Est.)","$117k-170k(Glassdoor Est.)"};
        listView=findViewById(R.id.listview);
        MyAdapter adapter=new MyAdapter(this, mTitle, description,images,description2,rates);
        listView.setAdapter(adapter);
        Button button;
        button=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreen2();
            }
        });

    }
    public void openScreen2()
    {
        Intent intent=new Intent(this,screen2.class) ;
        startActivity(intent);}

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rtitle[];
        String rdes[];
        int rimg[];
        String rdes1[];
        String rate[];
        MyAdapter(Context c,String title[],String description[],int images[],String description2[],String rates[])
        {
            super(c,R.layout.rowss,R.id.text1,title);
            this.context=c;
            this.rtitle=title;
            this.rdes=description;
            this.rdes1=description2;
            this.rimg=images;
            this.rate=rates;
        }
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.rowss,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView mydes=row.findViewById(R.id.text1);
            TextView mydes1=row.findViewById(R.id.text2);
            TextView mydes2=row.findViewById(R.id.text3);
            TextView myrates=row.findViewById(R.id.text4);
            Button button=row.findViewById(R.id.button1);
            images.setImageResource(rimg[position]);
            mydes.setText(rtitle[position]);
            mydes1.setText(rdes[position]);
            mydes2.setText(rdes1[position]);
            myrates.setText(rate[position]);

            return row;
        }
    }
}