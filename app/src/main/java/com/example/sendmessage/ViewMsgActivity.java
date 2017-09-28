package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *  Esta Clase recibe dos strings desde otra Activity
 *  @author Elena G (Beelzenef)
 *
 *  @see android.content.Intent
 *  @see android.os.Bundle
 */
public class ViewMsgActivity extends AppCompatActivity {

    // Instancias a usar
    private TextView txtV_ViewMessage;
    private TextView txtV_ViewUser;

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

        // Mostrar usuario
        String viewUser = String.format(getResources().getString(R.string.txtV_ViewMsg),
                                        getIntent().getExtras().getString("user"));

        txtV_ViewUser.setText(viewUser);

        // Mostrar mensaje
        txtV_ViewMessage.setText(getIntent().getExtras().getString("msg"));
    }
}
