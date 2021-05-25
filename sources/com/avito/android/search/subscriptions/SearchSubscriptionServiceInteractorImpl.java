package com.avito.android.search.subscriptions;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractorImpl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractor;", "", "refreshSearchSubscriptionService", "()V", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionSyncRunner", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionServiceInteractorImpl implements SearchSubscriptionServiceInteractor {
    public final Context a;
    public final SearchSubscriptionSyncRunner b;

    @Inject
    public SearchSubscriptionServiceInteractorImpl(@NotNull Context context, @NotNull SearchSubscriptionSyncRunner searchSubscriptionSyncRunner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchSubscriptionSyncRunner, "searchSubscriptionSyncRunner");
        this.a = context;
        this.b = searchSubscriptionSyncRunner;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionServiceInteractor
    public void refreshSearchSubscriptionService() {
        this.b.startUpdate(this.a);
    }
}
