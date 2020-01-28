package worldline.ssm.rd.ux.wltwitter;

import androidx.appcompat.app.AppCompatActivity;

import worldline.ssm.rd.ux.wltwitter.Async.RetrieveTweetsAsyncTask;
import worldline.ssm.rd.ux.wltwitter.utils.Constants;
import worldline.ssm.rd.ux.wltwitter.utils.PreferenceUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WLTwitterActivity extends AppCompatActivity {

    private RetrieveTweetsAsyncTask mTweetsAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent fromIntent =  getIntent();
        String username = "";
        if (fromIntent!=null){
            if (fromIntent.getExtras()!=null) {
                username = fromIntent.getExtras().getString(Constants.Login.EXTRA_LOGIN);
                mTweetsAsyncTask = new RetrieveTweetsAsyncTask(username);

            }
            getSupportActionBar().setTitle(username);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //action de logout
        if (id == R.id.actionLogout) {
            PreferenceUtils.setLogin(null);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
