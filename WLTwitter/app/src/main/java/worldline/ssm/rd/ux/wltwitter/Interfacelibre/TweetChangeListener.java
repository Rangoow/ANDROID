package worldline.ssm.rd.ux.wltwitter.Interfacelibre;

import java.util.List;

import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;

public interface TweetChangeListener {

    public void onTweetRetrieved(List<Tweet> tweets);

}
