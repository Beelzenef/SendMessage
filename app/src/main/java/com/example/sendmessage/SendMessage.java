package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendMessage extends AppCompatActivity {

    // Instancias a utilizar
    private EditText edtT_Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        // Obteniendo edtText para mensaje
        edtT_Message = (EditText) findViewById(R.id.edtT_Message);
    }

    public void manageOnClick(View v)
    {
        // ¿Qué botón hemos pulsado?
        switch (v.getId()) {
            case R.id.btn_SendMsg:
                enviarMsg();
                break;
        }
    }

    void enviarMsg()
    {
        // Recoger usuario y mensaje
        // Crear Bundle y añadir el mensaje
        Bundle bndl = new Bundle();
        bndl.putString("msg", edtT_Message.getText().toString());

        // Crear y cargar Intent con Bundle
        Intent intnt = new Intent(SendMessage.this, ViewMsg.class);
        intnt.putExtras(bndl);

        // Iniciar la Activity ViewMessage
        startActivity(intnt);

    }

}
