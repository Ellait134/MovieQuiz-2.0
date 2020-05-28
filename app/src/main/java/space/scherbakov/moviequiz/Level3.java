package space.scherbakov.moviequiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    public int num1;
    public int num2;
    public int num3;
    public int num4;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvs3);

        //Круглые углы - Начало
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setClipToOutline(true);

        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setClipToOutline(true);

        final ImageView img3 = (ImageView) findViewById(R.id.img3);
        img3.setClipToOutline(true);

        final ImageView img4 = (ImageView) findViewById(R.id.img4);
        img4.setClipToOutline(true);
        //Круглые углы - Конец

        final TextView text1 = findViewById(R.id.textlvl1);

        //Статус бар - Начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Статус бар - Конец


        //Диалоговое окно начало ур.3 - Начало
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();

        ImageView previewimg =(ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewimgthree);

        TextView textdescription =(TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.leveltwo);

        Button buttoncontinue = (Button) dialog.findViewById(R.id.buttoncontinue);
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //Диалоговое окно начало ур3. - конец

        //Диалоговое окно конец ур3. - Начало
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);

        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescription);
        textdescriptionEnd.setText(R.string.lvlthree);



        Button buttoncontinueend = (Button) dialogEnd.findViewById(R.id.buttoncontinue);
        buttoncontinueend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, Level3.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialogEnd.dismiss();
            }
        });
        //Диалоговое окно конец ур3. - Конец

        //Кнопка  Назад - Начало
        Button btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level3.this,GameLevels.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e ){

                }
            }
        });
        //Кнопка  Назад - Конец

        //Массив прогресс бара - Начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
        };
        //Массив прогресс бара - Конец

        //Анимация - Начало
        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);
        //Анимация - Конец

        //Картинки и текст - Начало
        num1 = random.nextInt(10);
        img1.setImageResource(array.images3[num1]);

        num2 = random.nextInt(10);
        img2.setImageResource(array.images3[num2]);

        num3 = random.nextInt(10);
        img3.setImageResource(array.images3[num3]);

        num4 = random.nextInt(10);
        img4.setImageResource(array.images3[num4]);

        //final int[]anums = {
        //num1,num2,num3,num4
        //};
        //final int nums = random.nextInt(anums.length);

        text1.setText(array.texts3[num1]);
        //Картинки и текст - Конец

        //Анимация Первой картинки - Начало
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img2.setEnabled(false);
                    img3.setEnabled(false);
                    img4.setEnabled(false);
                    if (num1 == num1) {
                        img1.setImageResource(R.drawable.img_true);
                    } else {
                        img1.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (num1 == num1) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = -2;
                            }
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    if (count == 10) {
                        dialogEnd.show();
                    } else {
                        num1 = random.nextInt(10);
                        img1.setImageResource(array.images3[num1]);
                        img1.startAnimation(a);

                        num2 = random.nextInt(10);
                        img2.setImageResource(array.images3[num2]);
                        img2.startAnimation(a);

                        num3 = random.nextInt(10);
                        img3.setImageResource(array.images3[num3]);
                        img3.startAnimation(a);

                        num4 = random.nextInt(10);
                        img4.setImageResource(array.images3[num4]);
                        img4.startAnimation(a);


                        //final int nums = random.nextInt(num1 | num2 | num3 | num4);

                        text1.setText(array.texts3[num1]);

                        img2.setEnabled(true);
                        img3.setEnabled(true);
                        img4.setEnabled(true);
                    }

                }
                return true;
            }
        });
        //Анимация Первой картинки - Конец


        //Анимация Второй картинки - Начало
        img2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img1.setEnabled(false);
                    img3.setEnabled(false);
                    img4.setEnabled(false);
                    if (num2 == num1) {
                        img2.setImageResource(R.drawable.img_true);
                    } else {
                        img2.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (num2 == num1) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = -2;
                            }
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    if (count == 10) {
                        dialogEnd.show();
                    } else {
                        num1 = random.nextInt(10);
                        img1.setImageResource(array.images3[num1]);
                        img1.startAnimation(a);

                        num2 = random.nextInt(10);
                        img2.setImageResource(array.images3[num2]);
                        img2.startAnimation(a);

                        num3 = random.nextInt(10);
                        img3.setImageResource(array.images3[num3]);
                        img3.startAnimation(a);

                        num4 = random.nextInt(10);
                        img4.setImageResource(array.images3[num4]);
                        img4.startAnimation(a);


                        //final int nums = random.nextInt(num1 | num2 | num3 | num4);

                        text1.setText(array.texts3[num1]);

                        img1.setEnabled(true);
                        img3.setEnabled(true);
                        img4.setEnabled(true);
                    }

                }
                return true;
            }
        });
        //Анимация Второй картинки - Конец

        //Анимация Третьей картинки - Начало
        img3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img2.setEnabled(false);
                    img1.setEnabled(false);
                    img4.setEnabled(false);
                    if (num3 == num1) {
                        img3.setImageResource(R.drawable.img_true);
                    } else {
                        img3.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (num3 == num1) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = -2;
                            }
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    if (count == 10) {
                        dialogEnd.show();
                    } else {
                        num1 = random.nextInt(10);
                        img1.setImageResource(array.images3[num1]);
                        img1.startAnimation(a);

                        num2 = random.nextInt(10);
                        img2.setImageResource(array.images3[num2]);
                        img2.startAnimation(a);

                        num3 = random.nextInt(10);
                        img3.setImageResource(array.images3[num3]);
                        img3.startAnimation(a);

                        num4 = random.nextInt(10);
                        img4.setImageResource(array.images3[num4]);
                        img4.startAnimation(a);


                        //final int nums = random.nextInt(num1 | num2 | num3 | num4);

                        text1.setText(array.texts3[num1]);

                        img2.setEnabled(true);
                        img1.setEnabled(true);
                        img4.setEnabled(true);
                    }

                }
                return true;
            }
        });
        //Анимация Третьей картинки - Конец

        //Анимация Четвёртой картинки - Начало
        img4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img1.setEnabled(false);
                    img2.setEnabled(false);
                    img3.setEnabled(false);
                    if (num4 == num1) {
                        img4.setImageResource(R.drawable.img_true);
                    } else {
                        img4.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (num4 == num1) {
                        if (count < 10) {
                            count = count + 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                            } else {
                                count = -2;
                            }
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }
                    if (count == 10) {
                        dialogEnd.show();
                    } else {
                        num1 = random.nextInt(10);
                        img1.setImageResource(array.images3[num1]);
                        img1.startAnimation(a);

                        num2 = random.nextInt(10);
                        img2.setImageResource(array.images3[num2]);
                        img2.startAnimation(a);

                        num3 = random.nextInt(10);
                        img3.setImageResource(array.images3[num3]);
                        img3.startAnimation(a);

                        num4 = random.nextInt(10);
                        img4.setImageResource(array.images3[num4]);
                        img4.startAnimation(a);


                        //final int nums = random.nextInt(num1 | num2 | num3 | num4);

                        text1.setText(array.texts3[num1]);

                        img1.setEnabled(true);
                        img2.setEnabled(true);
                        img3.setEnabled(true);
                    }

                }
                return true;
            }
        });
        //Анимация Четвёртой картинки - Конец


    }

    //Системная кнопка назад - Начало
    @Override
    public void onBackPressed () {
        try {
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {
        }
    }
    //Системная кнопка назад - Конец
}
