package a2.g.v;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.ShareApi;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareOpenGraphAction;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public class e implements CollectionMapper.OnMapperCompleteListener {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ ShareOpenGraphAction b;
    public final /* synthetic */ GraphRequest.Callback c;
    public final /* synthetic */ FacebookCallback d;
    public final /* synthetic */ ShareApi e;

    public e(ShareApi shareApi, Bundle bundle, ShareOpenGraphAction shareOpenGraphAction, GraphRequest.Callback callback, FacebookCallback facebookCallback) {
        this.e = shareApi;
        this.a = bundle;
        this.b = shareOpenGraphAction;
        this.c = callback;
        this.d = facebookCallback;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        try {
            ShareApi.a(this.a);
            new GraphRequest(AccessToken.getCurrentAccessToken(), this.e.c(URLEncoder.encode(this.b.getActionType(), "UTF-8")), this.a, HttpMethod.POST, this.c).executeAsync();
        } catch (UnsupportedEncodingException e2) {
            ShareInternalUtility.invokeCallbackWithException(this.d, e2);
        }
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        ShareInternalUtility.invokeCallbackWithException(this.d, facebookException);
    }
}
