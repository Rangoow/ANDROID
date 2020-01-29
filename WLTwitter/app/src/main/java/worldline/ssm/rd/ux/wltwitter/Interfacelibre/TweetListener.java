package worldline.ssm.rd.ux.wltwitter.Interfacelibre;

import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;

public interface TweetListener {
    public void  onRetweet(Tweet tweet);
    public void onView(Tweet tweet);

}

