package com.example.hansel.demo4;;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;

public class ItemAdding extends AppCompatActivity {

    private EditText itemName;
    private EditText itemDesc;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_adding);

        itemName = (EditText) findViewById(R.id.nameInput);
        itemDesc = (EditText) findViewById(R.id.descInput);

        preferences = getSharedPreferences("values",MODE_PRIVATE);
    }

    public void addItem(View view){
        preferences.edit()
                .putString(itemName.getText().toString(), itemDesc.getText().toString())
                .apply();;
        finish();

    }
}