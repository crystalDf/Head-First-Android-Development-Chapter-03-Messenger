package com.star.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    private Button mSendButton;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        mSendButton = (Button) findViewById(R.id.send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = mMessageEditText.getText().toString();

//                Intent intent = new Intent(CreateMessageActivity.this,
//                        ReceiveMessageActivity.class);

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message);

//                intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, message);

//                startActivity(intent);

                Intent chosenIntent = Intent.createChooser(intent, getString(R.string.chooser));

                startActivity(chosenIntent);
            }
        });

        mMessageEditText = (EditText) findViewById(R.id.message);
    }

}
