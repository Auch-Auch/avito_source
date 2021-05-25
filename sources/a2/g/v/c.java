package a2.g.v;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.ShareApi;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;
public class c implements GraphRequest.Callback {
    public final /* synthetic */ CollectionMapper.OnMapValueCompleteListener a;
    public final /* synthetic */ SharePhoto b;

    public c(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener, SharePhoto sharePhoto) {
        this.a = onMapValueCompleteListener;
        this.b = sharePhoto;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        String str = "Error staging photo.";
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
            this.a.onError(new FacebookException(str));
            return;
        }
        String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
        if (optString == null) {
            this.a.onError(new FacebookException(str));
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", optString);
            jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, this.b.getUserGenerated());
            this.a.onComplete(jSONObject2);
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage != null) {
                str = localizedMessage;
            }
            this.a.onError(new FacebookException(str));
        }
    }
}
