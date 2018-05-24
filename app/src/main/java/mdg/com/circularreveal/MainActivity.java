package mdg.com.circularreveal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<ModelClass> textList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        textList = new ArrayList<>();

        textList.add(new ModelClass("Card 1"));
        textList.add(new ModelClass("Card 2"));
        textList.add(new ModelClass("Card 3"));
        textList.add(new ModelClass("Card 4"));
        textList.add(new ModelClass("Card 5"));

        adapter = new CardAdapter(this, textList);
        recyclerView.setAdapter(adapter);
    }
}
