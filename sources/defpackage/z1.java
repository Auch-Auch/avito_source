package defpackage;

import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: z1  reason: default package */
public final class z1<T> implements Consumer<List<? extends SearchSubscription>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public z1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(List<? extends SearchSubscription> list) {
        int i = this.a;
        if (i == 0) {
            List<? extends SearchSubscription> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            SearchSubscriptionSyncInteractorImpl.access$saveLoadSubscriptionsToDao((SearchSubscriptionSyncInteractorImpl) this.b, list2);
        } else if (i == 1) {
            List<? extends SearchSubscription> list3 = list;
            Intrinsics.checkNotNullExpressionValue(list3, "it");
            SearchSubscriptionSyncInteractorImpl.access$notifySuccessAndUnreadCount((SearchSubscriptionSyncInteractorImpl) this.b, list3);
        } else {
            throw null;
        }
    }
}
