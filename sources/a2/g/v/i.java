package a2.g.v;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.ShareApi;
import org.json.JSONArray;
public class i implements CollectionMapper.OnMapperCompleteListener {
    public final /* synthetic */ CollectionMapper.OnMapValueCompleteListener a;
    public final /* synthetic */ JSONArray b;

    public i(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener, JSONArray jSONArray) {
        this.a = onMapValueCompleteListener;
        this.b = jSONArray;
    }

    @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
    public void onComplete() {
        this.a.onComplete(this.b);
    }

    @Override // com.facebook.internal.CollectionMapper.OnErrorListener
    public void onError(FacebookException facebookException) {
        this.a.onError(facebookException);
    }
}
