package com.romeotutorial.ex1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private String[] names={"Elementul 1","Elementul 2","Elementul 3","Elementul 4","Elementul 5","Elementul 6"
            ,"Elementul 7","Elementul 8","Elementul 9","Elementul 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                new ArrayList<String>()));
        new MyYask().execute();
    }




    class MyYask extends AsyncTask<Void,String,String>{
        ArrayAdapter<String> adapter;

         protected  void onPreExecute(){
             adapter = (ArrayAdapter<String>)listView.getAdapter();
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(String Name : names)
            {
                publishProgress(Name);
                try {
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "All elements was added";
        }

        @Override
        protected void onProgressUpdate(String... values) {
           adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

        }
    }
}
