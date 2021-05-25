package a2.g.v;

import a2.b.a.a.a;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Utility;
import com.facebook.share.ShareApi;
import java.util.Iterator;
public class j implements CollectionMapper.Collection<String> {
    public final /* synthetic */ Bundle a;

    public j(ShareApi shareApi, Bundle bundle) {
        this.a = bundle;
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
        if (!Utility.putJSONValueInBundle(this.a, str, obj)) {
            StringBuilder L = a.L("Unexpected value: ");
            L.append(obj.toString());
            onErrorListener.onError(new FacebookException(L.toString()));
        }
    }
}
