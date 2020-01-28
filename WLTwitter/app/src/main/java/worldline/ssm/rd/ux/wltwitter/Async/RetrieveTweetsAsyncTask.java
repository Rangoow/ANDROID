package worldline.ssm.rd.ux.wltwitter.Async;

import android.os.AsyncTask;

import java.util.List;

import worldline.ssm.rd.ux.wltwitter.WLTwitterActivity;
import worldline.ssm.rd.ux.wltwitter.WLTwitterApplication;
import worldline.ssm.rd.ux.wltwitter.helpers.TwitterHelper;
import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;

public class RetrieveTweetsAsyncTask extends AsyncTask<String, Void, List<Tweet>> {


    @Override
    protected List<Tweet> doInBackground(String... strings) {
        if(null != strings && strings.length>0){
            return TwitterHelper.getTweetsOfUser(strings[0]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Tweet> tweets) {
        super.onPostExecute(tweets);
        if (null != tweets) {
            for (Tweet t:tweets)
                System.out.println(WLTwitterApplication.class.getName() + t.text);
        }
    }
}
