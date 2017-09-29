package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sendmessage.pojo.Message;

/**
 *  Esta Clase envia un usuario y un mensaje a otra Activity
 *
 *  Conceptos aprendidos
 *
 *  <ul>
 *      <li>Concepto Context</li>
 *      <li>Paso de mensajes entre Activities a mediante la Clase Intent</li>
 *      <li>Paso de parametros para formateo de cadneas mediante la Clase Bundle</li>
 *  </ul>
 *
 *  @author Elena G (Beelzenef)
 *
 *  @see android.content.Intent
 *  @see android.os.Bundle
 *  @see com.example.sendmessage.pojo.Message
 */

public class SendMessageActivity extends AppCompatActivity {

    // Instancias a utilizar

    private EditText edtT_Message;
    private EditText edtT_User;
    private Button btn_SendMsg;

    private Message unMensaje;

    private static final String TAG = "com.example.sendmessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        // Obteniendo edtText para mensaje
        edtT_Message = (EditText) findViewById(R.id.edtT_Message);
        edtT_User = (EditText) findViewById(R.id.edtT_User);

        // Obteniendo boton
        btn_SendMsg = (Button) findViewById(R.id.btn_SendMsg);

        // Registrar Listener OnClickListener
        btn_SendMsg.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    enviarMsg();
                }
            }
        );

        Log.d(TAG, "SendMessage onCreate");

    }

    /*
    public void manageOnClick(View v)
    {
        // ¿Qué botón hemos pulsado?
        switch (v.getId()) {
            case R.id.btn_SendMsg:
                enviarMsg();
                break;        }
    }

    */

    // Metodos del ciclo de vida, para debugging

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "SendMessage onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Log.d(TAG, "SendMessage onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "SendMessage onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "SendMessage onStop");
    }

    // Enviando mensaje a traves de Bundle

    void enviarMsg()
    {
        unMensaje = new Message(edtT_Message.getText().toString(), edtT_User.getText().toString());

        // Recoger usuario y mensaje
        // Crear Bundle y añadir mensaje + usuario
        Bundle unBundle = new Bundle();
        unBundle.putSerializable("msg", unMensaje);

        //unBundle.putString("msg", edtT_Message.getText().toString());
        //unBundle.putString("user", edtT_User.getText().toString());

        // Crear y cargar Intent con Bundle
        Intent unIntent = new Intent(SendMessageActivity.this, ViewMsgActivity.class);
        unIntent.putExtras(unBundle);

        // Iniciar la Activity ViewMessage
        startActivity(unIntent);

    }

}
