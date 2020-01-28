package worldline.ssm.rd.ux.wltwitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import worldline.ssm.rd.ux.wltwitter.utils.Constants;
import worldline.ssm.rd.ux.wltwitter.utils.PreferenceUtils;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(this);

        final String login = PreferenceUtils.getLogin();
        if(!TextUtils.isEmpty(login))
            startActivity(getHomeIntent(login));
    }

    @Override
    public void onClick(View v) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        if (TextUtils.isEmpty(usernameEditText.getText())) {
            Toast.makeText(getApplicationContext(), getText(R.string.username_empty_error), Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(passwordEditText.getText())) {
            Toast.makeText(getApplicationContext(), getText(R.string.password_empty_error), Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(getHomeIntent(usernameEditText.getText().toString()));
    }

        private Intent getHomeIntent(String username){
            final Intent homeIntent = new Intent(this,WLTwitterActivity.class);
            final Bundle extras = new Bundle();
            extras.putString(Constants.Login.EXTRA_LOGIN,username);
            homeIntent.putExtras(extras);
            return homeIntent;
        }
    }
