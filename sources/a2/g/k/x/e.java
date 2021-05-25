package a2.g.k.x;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import org.json.JSONException;
import org.json.JSONObject;
public class e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ ViewIndexer b;

    public e(ViewIndexer viewIndexer, String str) {
        this.b = viewIndexer;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        GraphRequest buildAppIndexingRequest;
        String md5hash = Utility.md5hash(this.a);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if ((md5hash == null || !md5hash.equals(this.b.d)) && (buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(this.a, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING)) != null) {
            GraphResponse executeAndWait = buildAppIndexingRequest.executeAndWait();
            try {
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(jSONObject.optString("success"))) {
                        Logger.log(LoggingBehavior.APP_EVENTS, "com.facebook.appevents.codeless.ViewIndexer", "Successfully send UI component tree to server");
                        this.b.d = md5hash;
                    }
                    if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                        CodelessManager.f = Boolean.valueOf(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED));
                        return;
                    }
                    return;
                }
                String str = "Error sending UI component tree to Facebook: " + executeAndWait.getError();
            } catch (JSONException unused) {
            }
        }
    }
}
