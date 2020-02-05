package worldline.ssm.rd.ux.wltwitter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import worldline.ssm.rd.ux.wltwitter.R;
import worldline.ssm.rd.ux.wltwitter.WLTwitterApplication;
import worldline.ssm.rd.ux.wltwitter.async.DownloadImageAsyncTask;
import worldline.ssm.rd.ux.wltwitter.pojo.Tweet;

public class Tweetsadapter  extends BaseAdapter implements View.OnClickListener {

    private List<Tweet> mTweets;
    private final LayoutInflater mInflater;


    public Tweetsadapter(List<Tweet> mTweets) {
        this.mTweets = mTweets;
        mInflater = LayoutInflater.from(WLTwitterApplication.getContext());
    }

    @Override
    public int getCount() {
        return (null != mTweets)
                ? mTweets.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return null != mTweets
                ? mTweets.get(i) : null;

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView1(int position, View convertView, ViewGroup parent) {
        final View view =
                mInflater.inflate(R.layout.tweet_list_item,
                        null);
        final Tweet tweet = (Tweet) getItem(position);

        final TextView userName =
                (TextView) view.findViewById(R.id.username);
        userName.setText(tweet.user.name);
        final TextView userAlias =
                (TextView) view.findViewById((R.id.Alias));
        userAlias.setText("@" + tweet.user.screenName);
        final TextView text =
                (TextView) view.findViewById(R.id.Content_of_tweet);
        text.setText(tweet.text);
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    private class ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView alias;
        public TextView text;
        public Button button;

        public ViewHolder(View view) {
            image = (ImageView) view.findViewById(R.id.imageView);
            name = (TextView) view.findViewById(R.id.username);
            alias = (TextView) view.findViewById(R.id.Alias);
            text = (TextView) view.findViewById(R.id.Content_of_tweet);
            button = (Button) view.findViewById(R.id.Retweet_Button);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // If we don't have any convertView to reuse, inflate one
        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.tweet_list_item, null);

            // Instantiate the ViewHolder
            holder = new ViewHolder(convertView);
            // Set as tag to the convertView to retrieve it easily
            convertView.setTag(holder);
        } else {
            // Just retrieve the ViewHolder instance in the tag of the view
            holder = (ViewHolder) convertView.getTag();
        }
            // Get the current item
            final Tweet tweet = (Tweet) getItem(position);

            // Set the user name
            holder.name.setText(tweet.user.name);

            // Set the alias
           holder.alias.setText(tweet.user.screenName);

            // Set the text
           holder.text.setText(tweet.text);

            // Register a listener to handle the click on the button
            // And keep track of the position in the tag of the button
            holder.button.setTag(position);
            holder.button.setOnClickListener(this);

            // Display the images
            new DownloadImageAsyncTask(holder.image).execute(tweet.user.profileImageUrl);

            return convertView;
        }
}