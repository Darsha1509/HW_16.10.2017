package com.github.darsha1509.sample3;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.darsha1509.sample3.utils.DialogScreen;
import com.github.darsha1509.sample3.utils.Utils;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    boolean mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.version_text_view);



        new Thread(new Runnable() {

            @Override
            public void run() {

                Utils utils = new Utils(MainActivity.this);
                final String version = utils.getVersion();
                mResult = utils.compereVersions(version);

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        showResult(mResult);
                        AlertDialog dialog = DialogScreen.getDialog(MainActivity.this, mResult);
                        dialog.show();
                    }
                });
            }
        }).start();
    }




    private void showResult(boolean result){
        if(result){
            mTextView.setText(R.string.new_version);
        } else {
            mTextView.setText(R.string.updated_version);
        }

    }
}
