package space.scherbakov.moviequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        //Статус бар - Начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Статус бар - Конец

        //Кнопка "Назад" - Начало
        //Button btn_back = (Button) findViewById(R.id.btn_back);
        //btn_back.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
               //try {
                    //Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    //startActivity(intent);
                    //finish();

                //} catch (Exception e) {
               //}
            //}
        //});
        //Кнопка "Назад" - Конец
        //Разметка Кнопки Назад - Начало
        //<Button
        //android:id="@+id/btn_back"
        //android:layout_width="wrap_content"
        //android:layout_height="wrap_content"
        //android:layout_marginRight="10dp"
        //android:background="@drawable/style_btn_stroke_white"
        //android:paddingLeft="5dp"
        //android:paddingRight="5dp"
        //android:text="&#60;"
        //android:textAllCaps="false"
        //android:textColor="@color/white"
        //android:textSize="24sp" />/>
        //Разметка Кнопки Назад - Конец


        //Кнопка 1-го уровня - Начало
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        //Кнопка 1-го уровня - Конец

        //Кнопка 2-го уровня - Начало
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        //Кнопка 2-го уровня - Конец

        //Кнопка 3-го уровня - Начало
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        //Кнопка 3-го уровня - Конец
    }
                //Системная кнопка назад - Начало
               // @Override
              //  public void onBackPressed () {
                   // try {
                       // Intent intent = new Intent(GameLevels.this, MainActivity.class);
                       // startActivity(intent);
                       // finish();

                    //} catch (Exception e) {
                    //}
                //}
                //Системная кнопка назад - Конец
        //Системная кнопка назад (Основной вариант) - Начало
                    @Override
                    public void onBackPressed() {


                        if(backPressedTime + 2000 > System.currentTimeMillis()){
                            backToast.cancel();
                            super.onBackPressed();
                            return;
                        }else{
                            backToast = Toast.makeText(getBaseContext(),"Нажмите ещё раз, чтобы выйти",Toast.LENGTH_LONG);
                            backToast.show();
                        }

                        backPressedTime = System.currentTimeMillis();
                    }

            //Системная кнопка назад (Основной вариант) - Конец
        }