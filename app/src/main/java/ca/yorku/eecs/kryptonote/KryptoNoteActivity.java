package ca.yorku.eecs.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }

    public void onEncrypt(View v) {
        try {
            Cipher k = new Cipher(((EditText) findViewById(R.id.key)).getText().toString());
            String data = k.encrypt((((EditText) findViewById(R.id.data)).getText().toString()));
            ((TextView) findViewById(R.id.data)).setText(data);

        }

        catch (Exception e) {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

    public void onDecrypt(View v) {
        try {
            Cipher k = new Cipher(((EditText) findViewById(R.id.key)).getText().toString());
            String data = k.decrypt((((EditText) findViewById(R.id.data)).getText().toString()));
            ((TextView) findViewById(R.id.data)).setText(data);

        }

        catch (Exception e) {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

    public void onLoad(View v) {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast label = Toast.makeText(this, "Note Loaded.", Toast.LENGTH_LONG);
            label.show();
        }

        catch (Exception e) {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

    public void onSave(View v) {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast label = Toast.makeText(this, "Note Saved.", Toast.LENGTH_LONG);
            label.show();
        }

        catch (Exception e) {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }
}