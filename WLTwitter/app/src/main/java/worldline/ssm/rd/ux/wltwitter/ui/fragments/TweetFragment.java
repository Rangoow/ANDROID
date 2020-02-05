package worldline.ssm.rd.ux.wltwitter.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import worldline.ssm.rd.ux.wltwitter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetFragment extends Fragment {


    public TweetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tweet, container, false);
    }

}
