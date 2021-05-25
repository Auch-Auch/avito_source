package a2.g.v;

import a2.b.a.a.a;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.ShareApi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;
public class b implements CollectionMapper.OnMapperCompleteListener {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;
    public final /* synthetic */ GraphRequest.Callback c;
    public final /* synthetic */ CollectionMapper.OnMapValueCompleteListener d;
    public final /* synthetic */ ShareApi e;

    public b(ShareApi shareApi, JSONObject jSONObject, String str, GraphRequest.Callback callback, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        this.e = shareApi;
        this.a = jSONObject;
        this.b = str;
        this.c = callback;
        this.d = onMapValueCompleteListener;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        Bundle y1 = a.y1("object", this.a.toString());
        try {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            ShareApi shareApi = this.e;
            new GraphRequest(currentAccessToken, shareApi.c("objects/" + URLEncoder.encode(this.b, "UTF-8")), y1, HttpMethod.POST, this.c).executeAsync();
        } catch (UnsupportedEncodingException e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging Open Graph object.";
            }
            this.d.onError(new FacebookException(localizedMessage));
        }
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.d.onError(facebookException);
    }
}
