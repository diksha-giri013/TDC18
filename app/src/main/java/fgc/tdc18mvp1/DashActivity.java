package fgc.tdc18mvp1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fgc.tdc18mvp1.adapters.DashRVMainAdapter;
import fgc.tdc18mvp1.classes.DashRVContent;

public class DashActivity extends AppCompatActivity {

    //View Pager Variables
    int currentPage = 0; //Top VP page counter
    Timer timer; //Timer for Top VP
    final long DELAY_MS = 500;//delay in milliseconds before Top VP is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive Top VP view executions.

    //Button Variables
    private FloatingActionButton register_fab;
    private SwitchCompat switch_filter;
    //FAB state change colors
    private int enable_color = Color.parseColor("#00c853");
    private int disable_color = Color.parseColor("#FF616161");

    //Recycler view Variables
    private List<DashRVContent> cardContent = new ArrayList<>();
    public DashRVContent card_content;
    private RecyclerView recyclerView;
    private DashRVMainAdapter mAdapter;
    public String switch_mode ="Explorer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

       //Register FAB on click code
        register_fab = (FloatingActionButton) findViewById(R.id.DashAct_fab_register); //assigning register button the respective XML element
        register_fab.setVisibility(View.GONE);
        register_fab.setOnClickListener(new View.OnClickListener() { //navigate to register screen on fab button click
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashActivity.this, RegisterFABActivity.class);
                startActivity(intent);}});

        //Switch code to filter content on dashboard acc to selected state
        switch_filter = (SwitchCompat) findViewById(R.id.switchCompat);
        switch_filter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cardContent.clear(); //for destroying previously populated objects in the RV
                if (!isChecked){
                    register_fab.setVisibility(View.GONE);
                    switch_mode ="Explorer";
                }
                else {
                    register_fab.setClickable(true);
                    register_fab.setVisibility(View.VISIBLE);
                    switch_mode ="Participant";
                 }
                prepareDashContentData(switch_mode); //populating the recycler view according to the switch
            }
        });

        //View Pager Code
        final ViewPager pager = (ViewPager) findViewById(R.id.DashAct_vp_top);
        pager.setAdapter(new fgc.tdc18mvp1.adapters.DashVPTopAdapter.MyPagerAdapter(getSupportFragmentManager()));
        pager.setOffscreenPageLimit(3);

        //After setting the adapter use the timer
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 3) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        //Recycler view code
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new DashRVMainAdapter(cardContent);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareDashContentData(switch_mode);
        }

        //Function for filtering cards in RV
        public void filter(String switch_mode) {
            int pos;
            String status = this.card_content.getStatus();
            if (switch_mode == "Explorer") {
                if (status == "1") {
                    pos = this.mAdapter.getItemPosition(this.card_content);
                    this.mAdapter.remove_item(pos);

                }
            } else {
                if (status == "2") {
                    pos = this.mAdapter.getItemPosition(this.card_content);
                    this.mAdapter.remove_item(pos);
                }
            }
        }

     private void prepareDashContentData(String switch_mode) {
        /*status code description of content cards as follows:
         are as follows: 0-all, 1-for participant, 2-for explorer */
        card_content = new DashRVContent("WORKSHOP 1", "This Is A Good Workshop", "This is the description of this workshop.", "24/13/2019","Sem Hall", "WORKSHOP","0" );
        cardContent.add(card_content); filter(switch_mode);

        card_content = new DashRVContent("REGISTRATION OPEN!", "This Is A Nice Workshop", "This is the description of this workshop.", "27/13/2019","Some Hall", "UPDATE", "1" );
        cardContent.add(card_content); filter(switch_mode);

        card_content = new DashRVContent("AUDIENCE PASS!", "This Is An Important Update!", "This is the description of this update.", "Touch to act! "," ", "UPDATE", "2" );
        cardContent.add(card_content); filter(switch_mode);

        card_content = new DashRVContent("ARTICLE FOR EXPLORER", "This Is A Good Workshop", "This is the description of this workshop.", "Medium","Author", "ARTICLE", "2" );
        cardContent.add(card_content); filter(switch_mode);

        card_content = new DashRVContent("SOME VIDEO", "This Is A Good Video", "This is the description of this video.", "Youtube","Artist", "VIDEO", "0" );
        cardContent.add(card_content); filter(switch_mode);

        mAdapter.notifyDataSetChanged();
    }

}
