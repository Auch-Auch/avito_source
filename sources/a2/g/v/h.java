package a2.g.v;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.share.ShareApi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
public class h implements CollectionMapper.Collection<Integer> {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ JSONArray b;

    public class a implements Iterator<Integer> {
        public final /* synthetic */ Mutable a;
        public final /* synthetic */ int b;

        public a(h hVar, Mutable mutable, int i) {
            this.a = mutable;
            this.b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.value.intValue() < this.b;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public Integer next() {
            Mutable mutable = this.a;
            T t = mutable.value;
            mutable.value = (T) Integer.valueOf(t.intValue() + 1);
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    public h(ShareApi shareApi, ArrayList arrayList, JSONArray jSONArray) {
        this.a = arrayList;
        this.b = jSONArray;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.internal.CollectionMapper.Collection
    public Object get(Integer num) {
        return this.a.get(num.intValue());
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<Integer> keyIterator() {
        return new a(this, new Mutable(0), this.a.size());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, com.facebook.internal.CollectionMapper$OnErrorListener] */
    @Override // com.facebook.internal.CollectionMapper.Collection
    public void set(Integer num, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        try {
            this.b.put(num.intValue(), obj);
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging object.";
            }
            onErrorListener.onError(new FacebookException(localizedMessage));
        }
    }
}
