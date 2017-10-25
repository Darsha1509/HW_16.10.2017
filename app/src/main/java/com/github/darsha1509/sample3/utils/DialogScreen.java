package com.github.darsha1509.sample3.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.github.darsha1509.sample3.R;

public class DialogScreen {

    public static AlertDialog getDialog(Activity activity, boolean result){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.dialog_title);

        if(result){
            builder.setMessage(R.string.dialog_message);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        } else {
            builder.setMessage(R.string.dialog_message_choice);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        }


          return  builder.create();
    }

}
