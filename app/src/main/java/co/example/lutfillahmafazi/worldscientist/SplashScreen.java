package co.example.lutfillahmafazi.worldscientist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private long ms  = 0;
    private long splashTime = 3000;
    private Boolean splashActive = true;
    private Boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        final Thread myThread = new Thread() {
            public void run(){
                try {
                    while (splashActive && ms < splashTime){
                        if (!paused){
                            ms = ms + 100 ;
                            sleep(100);
                            progressBar.setProgress((int) ms);
                        }
                    }
                }catch (Exception e){
                }finally {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        myThread.start();
    }
}
