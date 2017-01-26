import com.eworl.tictactoe.activities.LoginActivity;
import com.eworl.tictactoe.network.callbacks.LoginCallback;
import com.eworl.tictactoe.network.core.HttpRequest;
import com.eworl.tictactoe.network.NetworkConstants;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class LoginRequest extends HttpRequest {
    LoginActivity activity;
    LoginCallback loginCallback;

    public LoginRequest(LoginActivity activity) {
        super(activity);
        this.activity = activity;
        loginCallback = new LoginCallback(activity);
    }

    public void start(String username, String password) {
        RequestBody formBody = new FormBody.Builder()
                .add("email_id", username)
                .add("password", password)
                .build();


        String url = NetworkConstants.ROUTE_LOGIN;
        super.send(url, HttpRequest.POST, formBody, loginCallback);
    }

}
