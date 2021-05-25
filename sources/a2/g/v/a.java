package a2.g.v;

import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.ShareApi;
import org.json.JSONObject;
public class a implements GraphRequest.Callback {
    public final /* synthetic */ CollectionMapper.OnMapValueCompleteListener a;

    public a(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        this.a = onMapValueCompleteListener;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        String str = "Error staging Open Graph object.";
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (errorMessage != null) {
                str = errorMessage;
            }
            this.a.onError(new FacebookGraphResponseException(graphResponse, str));
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            this.a.onError(new FacebookGraphResponseException(graphResponse, str));
            return;
        }
        String optString = jSONObject.optString("id");
        if (optString == null) {
            this.a.onError(new FacebookGraphResponseException(graphResponse, str));
        } else {
            this.a.onComplete(optString);
        }
    }
}
