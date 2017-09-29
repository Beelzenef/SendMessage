package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sendmessage.pojo.Message;

/**
 *  Esta Clase recibe dos strings desde otra Activity
 *  @author Elena G (Beelzenef)
 *
 *  @see android.content.Intent
 *  @see android.os.Bundle
 *  @see com.example.sendmessage.pojo.Message
 */
public class ViewMsgActivity extends AppCompatActivity {

    // Instancias a usar

    private TextView txtV_ViewMessage;
    private TextView txtV_ViewUser;

    private Message otroMensaje;

    private static final String TAG = "com.example.sendmessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        // Identificando vistas
        txtV_ViewMessage = (TextView)findViewById(R.id.txtV_viewMessage);
        txtV_ViewUser = (TextView) findViewById(R.id.txtV_viewUser);

        // Recoger Intent
        //Intent unIntent = getIntent();
        // Recoger mensaje de Bundle
        //Bundle unBundle = unIntent.getExtras();

        otroMensaje =  (Message) getIntent().getExtras().getSerializable("msg");

        // Mostrar usuario
        String viewUser = String.format(getResources().getString(R.string.txtV_ViewMsg),
                                        otroMensaje.getUsuario());

        txtV_ViewUser.setText(viewUser);

        // Mostrar mensaje
        txtV_ViewMessage.setText(otroMensaje.getTextomsg());

        Log.d(TAG, "ViewMessage onCreate");
    }

    // Metodos del ciclo de vida, para debugging

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "ViewMessage onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d(TAG, "ViewMessage onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "ViewMessage onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "ViewMessage onStop");
    }
}
