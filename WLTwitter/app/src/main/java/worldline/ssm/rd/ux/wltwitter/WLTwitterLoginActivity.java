package worldline.ssm.rd.ux.wltwitter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import worldline.ssm.rd.ux.wltwitter.utils.Constants;
import worldline.ssm.rd.ux.wltwitter.utils.PreferenceUtils;

public class WLTwitterLoginActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText mLoginEdit;
    private EditText mPasswordEdit;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        mLoginEdit = (EditText) findViewById(R.id.loginEditText);
        mPasswordEdit =  findViewById(R.id.passwordEditText);

        findViewById(R.id.LoginButton).setOnClickListener(this);

        final String login = PreferenceUtils.getLogin();
        if(!TextUtils.isEmpty(login))
        startActivity(getHomeIntent(login));
    }


    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(mLoginEdit.getText()))
        {
            Toast.makeText(this,"EmptyLogin",Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        String login = mLoginEdit.getText().toString();
        if(TextUtils.isEmpty(mPasswordEdit.getText()))
        {
            Toast.makeText(this,"EmptyPassword",Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        PreferenceUtils.setLogin(login);
        startActivity(getHomeIntent(login));
    }
    private Intent getHomeIntent(String userName){
        final Intent homeIntent = new Intent(this, WLTwitterActivity.class);
        final Bundle extras = new Bundle();
        extras.putString(Constants.Login.EXTRA_LOGIN, userName);
        homeIntent.putExtras(extras);
        return homeIntent;
    }
}
