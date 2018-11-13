package com.farid.solid_software_adnroid_test_app;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FrameLayout cLayout;
    private TextView textView;
    private RandomColor colorRGBc;
    private Button dButton;
    private boolean aBoolean;
    private MediaPlayer mp;
    private boolean dodo;
    private ColorChangeAsyTask asyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aBoolean = true;
        this.colorRGBc = new RandomColor();

        this.cLayout = (FrameLayout) findViewById(R.id.mainLayout);
        this.cLayout.setClickable(true);
        this.cLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });

        this.textView = (TextView) findViewById(R.id.clicableText);
        this.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });

        this.dButton = (Button) findViewById(R.id.button);
        this.mp = MediaPlayer.create(this, R.raw.disco);
        this.asyTask = new ColorChangeAsyTask();
    }
    //кнопка вкл/выкл диско :)
    public  void  doit(View view){

        if (aBoolean) {
            dodo = true;
            asyTask.execute();
            mp.start();
            aBoolean = !aBoolean;
        }
        else {
            Toast.makeText(MainActivity.this, "Disco ends ^_^", Toast.LENGTH_SHORT).show();
            dodo = false;
            mp.pause();
            aBoolean = !aBoolean;

        }
    }
    //обновляет цвет заднего фона Layout и цвет текста
    public void change(){

        cLayout.setBackgroundColor(colorRGBc.getRgb());
        textView.setTextColor(colorRGBc.getRgb());
    }

    //класс асингтаск, поток на заднем фоне для диско
    class ColorChangeAsyTask extends AsyncTask<Void, Integer, Void>{

        private int a = 0, b = 0, c = 0;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Disco starts  =)", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setTextColor(values[0]);
            cLayout.setBackgroundColor(values[1]);
            dButton.setBackgroundColor(values[2]);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            while (dodo){
                a = colorRGBc.getRgb();
                b = colorRGBc.getRgb();
                c = colorRGBc.getRgb();
                publishProgress(a, b, c);
                SystemClock.sleep(200);

            }

            return null;
        }
    }

}
