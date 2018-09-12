package elshab7.engineering.simpledialog;

import android.content.Context;
import android.content.DialogInterface;

public class SimpleDialog {
    private android.support.v7.app.AlertDialog.Builder alertDialogBuilder;
    private AlertDialogCallback mAlertDialogCallback;
    private String mYes=null,mNo=null,mCancel=null;


    private SimpleDialog(Context context, String Msg) {
        alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(Msg);
        setCancelable(false);
        setPositiveButton("Yes");
        setNegativeButton("No");
        //setCancelButton("Cancel");
        mAlertDialogCallback=new AlertDialogCallback() {
            @Override
            public void onYesClicked() {}
            @Override
            public void onNoClicked() {}
            @Override
            public void onCancelClicked() {}
        };
        setAlertCallback(mAlertDialogCallback);
    }

    public static SimpleDialog Initialize(Context context, String Msg) {
        return new SimpleDialog(context,Msg);
    }

    public SimpleDialog setAlertCallback(AlertDialogCallback alertDialogCallback) {
        mAlertDialogCallback = alertDialogCallback;
        setPositiveButton(mYes);
        setNegativeButton(mNo);
        if(mCancel!=null)setCancelButton(mCancel);
        return this;
    }

    public SimpleDialog setCancelable(boolean cancelable) {
        alertDialogBuilder.setCancelable(cancelable);
        return this;
    }

    public SimpleDialog setIcon(int icon) {
        alertDialogBuilder.setIcon(icon);
        return this;
    }
    public SimpleDialog setTitle(String title) {
        alertDialogBuilder.setTitle(title);
        return this;
    }

    public SimpleDialog setPositiveButton(String msgID) {
        mYes=msgID;
        alertDialogBuilder.setPositiveButton(msgID, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialogCallback.onYesClicked();
            }
        });
        return this;
    }
    public SimpleDialog setNegativeButton(String msgID) {
        mNo=msgID;
        alertDialogBuilder.setNegativeButton(msgID, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialogCallback.onNoClicked();
            }
        });
        return this;
    }
    public SimpleDialog setCancelButton(String msgID) {
        mCancel=msgID;
        alertDialogBuilder.setNeutralButton(msgID, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialogCallback.onCancelClicked();
            }
        });
        return this;
    }
    public void Show(){
        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public interface AlertDialogCallback {

        /**
         * "Rate now" event
         */
        void onYesClicked();

        /**
         * "No, thanks" event
         */
        void onNoClicked();

        /**
         * "Later" event
         */
        void onCancelClicked();
    }
}
