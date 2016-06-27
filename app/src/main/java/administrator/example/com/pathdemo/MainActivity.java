package administrator.example.com.pathdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout srl_refreshe;
    private ListView refres_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        srl_refreshe = (SwipeRefreshLayout) findViewById(R.id.srl_refreshe);
//        refres_listView = (ListView) findViewById(R.id.refresh_listview);
    }
}
