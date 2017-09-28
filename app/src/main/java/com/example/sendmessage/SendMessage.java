package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 *  app SendMessage
 *  @author Elena G (Beelzenef)
 */

public class SendMessage extends AppCompatActivity {

    // Instancias a utilizar
    private EditText edtT_Message;
    private EditText edtT_User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        // Obteniendo edtText para mensaje
        edtT_Message = (EditText) findViewById(R.id.edtT_Message);
        edtT_User = (EditText) findViewById(R.id.edtT_User);
    }

    public void manageOnClick(View v)
    {
        // ¿Qué botón hemos pulsado?
        switch (v.getId()) {
            case R.id.btn_SendMsg:
                enviarMsg();
                break;        }
    }

    void enviarMsg()
    {
        // Recoger usuario y mensaje
        // Crear Bundle y añadir mensaje + usuario
        Bundle bndl = new Bundle();
        bndl.putString("msg", edtT_Message.getText().toString());
        bndl.putString("user", edtT_User.getText().toString());

        // Crear y cargar Intent con Bundle
        Intent intnt = new Intent(SendMessage.this, ViewMsg.class);
        intnt.putExtras(bndl);

        // Iniciar la Activity ViewMessage
        startActivity(intnt);

    }

}
