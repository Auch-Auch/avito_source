package a2.a.a.l2;

import com.avito.android.serp.adapter.PersistableSerpItem;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
public final class d<T, R> implements Function<Throwable, List<? extends PersistableSerpItem>> {
    public final /* synthetic */ List a;

    public d(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends PersistableSerpItem> apply(Throwable th) {
        return this.a;
    }
}
