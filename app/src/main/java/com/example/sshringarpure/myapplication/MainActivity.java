package com.example.sshringarpure.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnItemSelectedListener {
    private Button b1,b2,b3,b4;
    private ImageView iv;
    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;

    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1,tx2,tx3;
    private ListView mainList;
    private Spinner spinner;
    private int gPosition;

    private final String[] listContent = {"Charani Tuzhya Thevi","Varnu Kitee Upkaar","Aataa Tari Krupa Kari",
            "Aganita Tav Upkaar","Akshama Deen","Anandee Anand","Arambh Nahi","Bhakt Vatsala Bhakta Deena",
            "Chinta Karu Nako","Darshana Si Kagaa","Daya Kari Sri","Deena Dayaghan","Deva Guru Raya","Dhanya Re Sadguru Raya",
            "Dharita Guru Paule","Digambar Murti","Datta Atma Ram","Datta Bala Ram -I","Datta Bala Ram -II","Dattache_paye_Amhi",
            "Datta Daya Kari","Datta Guru Mazey Aai","Datta Namacha Gajar -I","Datta Prabhu","Guru Bhajani","Guru Charanacha",
            "Guru Kathamrut","Guru Krupe Vin","Guru Maharaj","Guru Vine Anya Na","Jaisa Bhaav","Janmo Janmi","Karuna Kar Tu",
            "Kai Apradh Mazha","Lago Re Tuzhey","Lago Re Tuzhey -I","Manav Dehi","Mai Baap Tumhi","Maya Jaali Mana","Mudha Daas Mi",
            "Namo Shiv Roopa","Payachiya Seva","Rut Kamal Karnike","Sadguru Charni","Sadguru Jeevan","Saguna Murti","Sai Malang Baba",
            "Sai Swaroop Datta","Shevata Goad Kari","Sri Guru Datta","Tuchi Mata Pita","Tuzhiya Charani","Tukobachi Kanta",
            "Zaali Pooja","Set One","Set Two","Set Three","Set Four","Set Five"} ;
    private final int[] resId = { R.raw.charani_tuzhya_thevi, R.raw.varnu_kitee_upkaar, R.raw.aata_tari_krupa_karee,
            R.raw.aganita_tav_upkaar, R.raw.akshama_deen, R.raw.anandee_anand, R.raw.aramba_nahi, R.raw.bhakta_vatsala_bhakta_dheen,
            R.raw.chinta_karoo_nako, R.raw.darshana_si_kaagaa, R.raw.daya_karee_sri, R.raw.deena_daya, R.raw.deva_guru_raya,R.raw.dhanya_re_sadguru_raya,
            R.raw.dharita_guru_paule,R.raw.digambar_murti,R.raw.datta_atma_ram,R.raw.datta_bala_ram_01,R.raw.datta_bala_ram_02,
            R.raw.dattachey_paye_amhi,R.raw.datta_daya_kari,R.raw.datta_guru_mazey_aai,R.raw.datta_namacha_gajar_01,R.raw.datta_prabhu,
            R.raw.guru_bhajani,R.raw.guru_charanacha,R.raw.guru_kathamrut,R.raw.guru_krupe_vin,R.raw.guru_maharaj,R.raw.guru_vine_anya_na,
            R.raw.jaisa_bhaav,R.raw.janmo_janmee,R.raw.karuna_kar_tu,R.raw.kai_apradha_maza,R.raw.lago_re_tuzhey,R.raw.lago_re_tuzhey_01,
            R.raw.manav_dehi,R.raw.mai_baap_tumhi,R.raw.maya_jaali_mana,R.raw.mudha_daas_mi,R.raw.namo_shiv_roopa,R.raw.payachiya_seva,
            R.raw.rut_kamal_karnike,R.raw.sadguru_charni,R.raw.sadguru_jeevan,R.raw.saguna_murti,R.raw.sai_malang_baba,R.raw.sai_swaroop_datta,
            R.raw.shevata_goad_kari,R.raw.sri_guru_datta_re,R.raw.tuchi_mata_pita,R.raw.tuzhiya_charani,R.raw.tukobachi_kanta,R.raw.zaali_pooja,
            R.raw.set_one,R.raw.set_two,R.raw.set_three,R.raw.set_four,R.raw.set_five} ;
    public static int oneTimeOnly = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gPosition = 0;
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        //iv = (ImageView)findViewById(R.id.imageView);

        tx1 = (TextView)findViewById(R.id.textView2);
        tx2 = (TextView)findViewById(R.id.textView3);
        tx3 = (TextView)findViewById(R.id.textView4);
        // tx3.setText("Song.mp3");

        //spinner = (Spinner)  findViewById(R.id.spinner);
        //spinner.setOnItemSelectedListener(this);
        //List<String> list = new ArrayList<String>();
        //list.add("Select an Arati");
        //list.add("charani_tuzhya_thevi");
        // mediaPlayer = MediaPlayer.create(this, R.raw.charani_tuzhya_thevi);
        //ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        b3.setEnabled(false);
        b2.setEnabled(false);
        b1.setEnabled(false);
        b4.setEnabled(false);
        mediaPlayer = new MediaPlayer();
        mainList = (ListView) findViewById(R.id.listView1);
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listContent);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        //simple_spinner_dropdown_item
        mainList.setAdapter(dataAdapter);
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adatperView, View view,int position, long id) {
                    gPosition = position;
                    playsong(position);
            }
        });


        //spinner.setAdapter(dataAdapter);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setClickable(false);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing Arati",Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                tx2.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime)))
                );

                tx1.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startTime)))
                );

                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing Arati",Toast.LENGTH_SHORT).show();
                        mediaPlayer.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void playsong(final int songindex) {
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), resId[songindex]);
            //mediaPlayer.setLooping(true);
            mediaPlayer.start();
            finalTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();

            if (oneTimeOnly == 0) {
                seekbar.setMax((int) finalTime);
                oneTimeOnly = 1;
            }

            tx2.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    finalTime)))
            );

            tx1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    startTime)))
            );

            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(UpdateSongTime, 100);
            b3.setEnabled(false);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b4.setEnabled(true);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (gPosition < ( resId.length - 1)) {
                    playsong(gPosition + 1);
                    gPosition = gPosition + 1 ;
                } else {
                    playsong(0);
                    gPosition = 0;
                }
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}