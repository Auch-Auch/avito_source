package a2.g.s;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;
public class i implements Utility.GraphMeRequestWithCacheCallback {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ LoginClient.Request b;
    public final /* synthetic */ h c;

    public i(h hVar, Bundle bundle, LoginClient.Request request) {
        this.c = hVar;
        this.a = bundle;
        this.b = request;
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onFailure(FacebookException facebookException) {
        LoginClient loginClient = this.c.loginClient;
        loginClient.c(LoginClient.Result.b(loginClient.g, "Caught exception", facebookException.getMessage()));
    }

    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
    public void onSuccess(JSONObject jSONObject) {
        try {
            this.a.putString(NativeProtocol.EXTRA_USER_ID, jSONObject.getString("id"));
            this.c.g(this.b, this.a);
        } catch (JSONException e) {
            LoginClient loginClient = this.c.loginClient;
            loginClient.c(LoginClient.Result.b(loginClient.g, "Caught exception", e.getMessage()));
        }
    }
}
