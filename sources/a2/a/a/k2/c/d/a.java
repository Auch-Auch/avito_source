package a2.a.a.k2.c.d;

import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<Throwable> {
    public final /* synthetic */ SearchSubscriptionSyncInteractorImpl a;

    public a(SearchSubscriptionSyncInteractorImpl searchSubscriptionSyncInteractorImpl) {
        this.a = searchSubscriptionSyncInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        SearchSubscriptionSyncInteractorImpl searchSubscriptionSyncInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        SearchSubscriptionSyncInteractorImpl.access$notifyFailed(searchSubscriptionSyncInteractorImpl, th2);
    }
}
