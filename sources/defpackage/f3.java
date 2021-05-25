package defpackage;

import com.avito.android.favorites.FavoriteAdvertsServiceInteractorImpl;
import com.avito.android.favorites.FavoriteAdvertsSyncEvent;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: f3  reason: default package */
public final class f3<T> implements Consumer<Integer> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public f3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Integer num) {
        int i = this.a;
        if (i != 0) {
            if (i != 1) {
                throw null;
            } else if (num.intValue() > 0) {
                FavoriteAdvertsServiceInteractorImpl.access$reportEvent(((FavoriteAdvertsServiceInteractorImpl.e) this.b).a, new FavoriteAdvertsSyncEvent.Completed(null, 1, null));
            }
        } else if (num.intValue() > 0) {
            FavoriteAdvertsServiceInteractorImpl.access$reportEvent(((FavoriteAdvertsServiceInteractorImpl.e) this.b).a, new FavoriteAdvertsSyncEvent.Completed(null, 1, null));
        }
    }
}
