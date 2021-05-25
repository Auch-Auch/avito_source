package com.avito.android.search.subscriptions.sync;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.search.subscriptions.SearchSubscriptionUpdatedEvent;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.Logs;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractorImpl;", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractor;", "", "updateMode", "", "updateIfNeeded", "(J)V", "Lcom/avito/android/db/SearchSubscriptionDao;", "c", "Lcom/avito/android/db/SearchSubscriptionDao;", "subscriptionDao", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "searchSubscriptionConsumer", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "api", "Lcom/avito/android/account/AccountStorageInteractor;", "d", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/subscriptions/remote/SubscriptionsApi;Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/account/AccountStorageInteractor;)V", "Companion", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionSyncInteractorImpl implements SearchSubscriptionSyncInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static long e;
    public final SubscriptionsApi a;
    public final SearchSubscriptionConsumer b;
    public final SearchSubscriptionDao c;
    public final AccountStorageInteractor d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncInteractorImpl$Companion;", "", "", "lastTryUpdateTimestamp", "J", "getLastTryUpdateTimestamp", "()J", "setLastTryUpdateTimestamp", "(J)V", "<init>", "()V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final long getLastTryUpdateTimestamp() {
            return SearchSubscriptionSyncInteractorImpl.e;
        }

        public final void setLastTryUpdateTimestamp(long j) {
            SearchSubscriptionSyncInteractorImpl.e = j;
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public SearchSubscriptionSyncInteractorImpl(@NotNull SubscriptionsApi subscriptionsApi, @NotNull SearchSubscriptionConsumer searchSubscriptionConsumer, @NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(subscriptionsApi, "api");
        Intrinsics.checkNotNullParameter(searchSubscriptionConsumer, "searchSubscriptionConsumer");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "subscriptionDao");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        this.a = subscriptionsApi;
        this.b = searchSubscriptionConsumer;
        this.c = searchSubscriptionDao;
        this.d = accountStorageInteractor;
    }

    public static final void access$notifyFailed(SearchSubscriptionSyncInteractorImpl searchSubscriptionSyncInteractorImpl, Throwable th) {
        searchSubscriptionSyncInteractorImpl.b.accept(new SearchSubscriptionUpdatedEvent());
        Logs.error("SavedSearchService", "Failed to update search subscriptions", th);
    }

    public static final void access$notifySuccessAndUnreadCount(SearchSubscriptionSyncInteractorImpl searchSubscriptionSyncInteractorImpl, List list) {
        searchSubscriptionSyncInteractorImpl.b.accept(new SearchSubscriptionUpdatedEvent());
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((SearchSubscription) it.next()).getCount() > 0) {
                i++;
            }
        }
        searchSubscriptionSyncInteractorImpl.b.accept(new SavedSearchesCounter(i));
    }

    public static final void access$saveLoadSubscriptionsToDao(SearchSubscriptionSyncInteractorImpl searchSubscriptionSyncInteractorImpl, List list) {
        searchSubscriptionSyncInteractorImpl.c.saveSearchSubscriptions(list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorKt.access$getMAX_SCHEDULED_INTERVAL_MS$p() < (java.lang.System.currentTimeMillis() - com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorImpl.e)) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateIfNeeded(long r8) {
        /*
            r7 = this;
            com.avito.android.account.AccountStorageInteractor r0 = r7.d
            com.avito.android.account.BlockingAccountStorageInteractor r0 = r0.toBlocking()
            boolean r0 = r0.isAuthorized()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000f
            goto L_0x002c
        L_0x000f:
            r3 = 2
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x002e
            r3 = 0
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x001c
            goto L_0x002e
        L_0x001c:
            long r8 = java.lang.System.currentTimeMillis()
            long r3 = com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorKt.access$getMAX_SCHEDULED_INTERVAL_MS$p()
            long r5 = com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorImpl.e
            long r8 = r8 - r5
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r8 = 0
            goto L_0x002f
        L_0x002e:
            r8 = 1
        L_0x002f:
            if (r8 == 0) goto L_0x0053
            long r8 = java.lang.System.currentTimeMillis()
            com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorImpl.e = r8
            com.avito.android.subscriptions.remote.SubscriptionsApi r8 = r7.a
            io.reactivex.rxjava3.core.Observable r8 = r8.getSearchSubscriptions()
            z1 r9 = new z1
            r9.<init>(r2, r7)
            io.reactivex.rxjava3.core.Observable r8 = r8.doOnNext(r9)
            z1 r9 = new z1
            r9.<init>(r1, r7)
            a2.a.a.k2.c.d.a r0 = new a2.a.a.k2.c.d.a
            r0.<init>(r7)
            r8.subscribe(r9, r0)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractorImpl.updateIfNeeded(long):void");
    }
}
