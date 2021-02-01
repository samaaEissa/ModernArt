package com.example.modernart;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView left_1;
    TextView left_2;
    TextView right_1;
    TextView right_2;
    TextView right_3;
    SeekBar  color_seek;
    TextView [] boxs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_1=(TextView)findViewById(R.id.left_1);
        left_2=(TextView)findViewById(R.id.left_2);
        right_1=(TextView)findViewById(R.id.right_1);
        right_2=(TextView)findViewById(R.id.right_2);
        right_3=(TextView)findViewById(R.id.right_3);
        boxs= new TextView[]{ left_2, right_1, right_2, right_3};
        color_seek=(SeekBar)findViewById(R.id.seekBar);
        color_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int last_progress=0;
            
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                last_progress=progress;
                for (int i=0;i< boxs.length;i++){
                    ColorDrawable viewColor = (ColorDrawable) boxs[i].getBackground();
                    int colorId = viewColor.getColor();
                    colorId=colorId+20*last_progress;
                    boxs[i].setBackgroundColor(colorId);
                }



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.info_menue,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();
        if (item_id==R.id.item_1){
            Info_Dialog moreInfoFragment = new Info_Dialog();
            moreInfoFragment.show(getSupportFragmentManager(),"MOMA view");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}