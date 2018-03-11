package wordfinder.wordfinder;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainWindow extends AppCompatActivity {

    public static Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        resources = getResources();
    }

    public void startSearch(View view) {
        EditText letters = (EditText) findViewById(R.id.letters);
        EditText counter = (EditText) findViewById(R.id.count);
        ListView listView = (ListView) findViewById(R.id.resultList);
        List<String> list;
        try {
            list = PermutateDictionary.go(letters.getText().toString(), counter.getText().toString());
        } catch (WordFinderException e) {
            list = new ArrayList<>();
            list.add(e.getMessage());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }
}