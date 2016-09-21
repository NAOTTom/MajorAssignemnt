package com.example.tom.guessthenumber;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SaveActivity extends ActionBarActivity {

    EditText numbersInput;
    TextView numbersText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        numbersInput = (EditText) findViewById(R.id.numbersInput);
        numbersText = (TextView) findViewById(R.id.numbersText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();

    }

    //Add a product to the database
    public void addButtonClicked(View view){
        Products product = new Products(numbersInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputText = numbersInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        numbersText.setText(dbString);
        numbersInput.setText("");
    }

   //restart the game
    public void onClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}