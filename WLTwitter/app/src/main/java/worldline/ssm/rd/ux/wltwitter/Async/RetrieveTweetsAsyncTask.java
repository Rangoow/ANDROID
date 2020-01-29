package worldline.ssm.rd.ux.wltwitter.async;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;


import worldline.ssm.rd.ux.wltwitter.Interfacelibre.TweetChangeListener;
import worldline.ssm.rd.ux.wltwitter.WLTwitterApplication;
import worldline.ssm.rd.ux.wltwitter.helpers.TwitterHelper;
import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;

public class RetrieveTweetsAsyncTask extends AsyncTask<String, Void, List<Tweet>> {

    private TweetChangeListener mListener;

    public RetrieveTweetsAsyncTask(TweetChangeListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<Tweet> doInBackground(String... strings) {
        if(null!= strings && strings.length>0)
        {
            return TwitterHelper.getTweetsOfUser(strings[0]);

        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Tweet> tweets) {
        super.onPostExecute(tweets);
        mListener.onTweetRetrieved(tweets);
    }
}


