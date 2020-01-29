package worldline.ssm.rd.ux.wltwitter.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import worldline.ssm.rd.ux.wltwitter.Interfacelibre.TweetChangeListener;
import worldline.ssm.rd.ux.wltwitter.R;
import worldline.ssm.rd.ux.wltwitter.WLTwitterApplication;
import worldline.ssm.rd.ux.wltwitter.async.RetrieveTweetsAsyncTask;
import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;
import worldline.ssm.rd.ux.wltwitter.utils.PreferenceUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetsFragment extends Fragment implements TweetChangeListener {
    private RetrieveTweetsAsyncTask mTweetsAsyncTask;
    private ListView mListView;

    public TweetsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        final String login= PreferenceUtils.getLogin();
        if(!TextUtils.isEmpty(login)) {
            mTweetsAsyncTask = new RetrieveTweetsAsyncTask(this);
            mTweetsAsyncTask.execute(login);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tweets, container, false);
        mListView = (ListView) rootView.findViewById(R.id.tweetsListView);
        mListView.setAdapter(new ArrayAdapter<Tweet>(getActivity(), android.R.layout.simple_list_item_1,
                new ArrayList<Tweet>()));
        return rootView;
        }


    @Override
    public void onTweetRetrieved(List<Tweet> tweets) {
        mListView.setAdapter(new ArrayAdapter<Tweet>(getActivity(), android.R.layout.simple_list_item_1,tweets));
        if(null !=tweets){
            for(Tweet t:tweets)
                Log.d(WLTwitterApplication.class.getName(), t.text);
        }
    }
}
