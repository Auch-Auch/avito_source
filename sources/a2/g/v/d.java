package a2.g.v;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.ShareApi;
import com.facebook.share.internal.ShareInternalUtility;
import org.json.JSONObject;
public class d implements GraphRequest.Callback {
    public final /* synthetic */ FacebookCallback a;

    public d(ShareApi shareApi, FacebookCallback facebookCallback) {
        this.a = facebookCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        String str;
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.optString("id");
        }
        ShareInternalUtility.invokeCallbackWithResults(this.a, str, graphResponse);
    }
}
