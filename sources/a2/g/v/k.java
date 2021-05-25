package a2.g.v;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareOpenGraphObject;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
public class k implements CollectionMapper.Collection<String> {
    public final /* synthetic */ ShareOpenGraphObject a;
    public final /* synthetic */ JSONObject b;

    public k(ShareApi shareApi, ShareOpenGraphObject shareOpenGraphObject, JSONObject jSONObject) {
        this.a = shareOpenGraphObject;
        this.b = jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.internal.CollectionMapper.Collection
    public Object get(String str) {
        return this.a.get(str);
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<String> keyIterator() {
        return this.a.keySet().iterator();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, com.facebook.internal.CollectionMapper$OnErrorListener] */
    @Override // com.facebook.internal.CollectionMapper.Collection
    public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        try {
            this.b.put(str, obj);
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging object.";
            }
            onErrorListener.onError(new FacebookException(localizedMessage));
        }
    }
}
