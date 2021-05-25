package com.avito.android.search.subscriptions;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.db.SavedSearchDao;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.search.subscriptions.di.DaggerSearchSubscriptionSyncServiceComponent;
import com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.Contexts;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bH\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u001aR\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionSyncService;", "Landroid/app/IntentService;", "", "onCreate", "()V", "onDestroy", "Landroid/content/Intent;", "intent", "onHandleIntent", "(Landroid/content/Intent;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "searchSubscriptionConsumer", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "getSearchSubscriptionConsumer", "()Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "setSearchSubscriptionConsumer", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;)V", "Lcom/avito/android/TopLocationInteractor;", "topLocationInteractor", "Lcom/avito/android/TopLocationInteractor;", "getTopLocationInteractor", "()Lcom/avito/android/TopLocationInteractor;", "setTopLocationInteractor", "(Lcom/avito/android/TopLocationInteractor;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "locationsDisposable", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "getSearchParamsConverter", "()Lcom/avito/android/remote/model/SearchParamsConverter;", "setSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulersFactory", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulersFactory", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/remote/LocationApi;", "locationApi", "Lcom/avito/android/remote/LocationApi;", "getLocationApi", "()Lcom/avito/android/remote/LocationApi;", "setLocationApi", "(Lcom/avito/android/remote/LocationApi;)V", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "subscriptionsApi", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "getSubscriptionsApi", "()Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "setSubscriptionsApi", "(Lcom/avito/android/subscriptions/remote/SubscriptionsApi;)V", AuthSource.BOOKING_ORDER, "subscriptionsDisposable", "Lcom/avito/android/db/SavedSearchDao;", "savedSearchDao", "Lcom/avito/android/db/SavedSearchDao;", "getSavedSearchDao", "()Lcom/avito/android/db/SavedSearchDao;", "setSavedSearchDao", "(Lcom/avito/android/db/SavedSearchDao;)V", "<init>", "Companion", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionSyncService extends IntentService {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static boolean c;
    public final CompositeDisposable a = new CompositeDisposable();
    public final CompositeDisposable b = new CompositeDisposable();
    @Inject
    public Features features;
    @Inject
    public LocationApi locationApi;
    @Inject
    public SavedSearchDao savedSearchDao;
    @Inject
    public SchedulersFactory3 schedulersFactory;
    @Inject
    public SearchParamsConverter searchParamsConverter;
    @Inject
    public SearchSubscriptionConsumer searchSubscriptionConsumer;
    @Inject
    public SubscriptionsApi subscriptionsApi;
    @Inject
    public TopLocationInteractor topLocationInteractor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR*\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionSyncService$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/db/SavedSearchDao;", "savedSearchDao", "", "startServiceIfSynchronizationNeeded", "(Landroid/content/Context;Lcom/avito/android/db/SavedSearchDao;)Z", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "<set-?>", "isRunning", "Z", "()Z", "setRunning", "(Z)V", "<init>", "()V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context) {
            return a2.b.a.a.a.X0(context, "context", context, SearchSubscriptionSyncService.class);
        }

        public final boolean isRunning() {
            return SearchSubscriptionSyncService.c;
        }

        public final boolean startServiceIfSynchronizationNeeded(@NotNull Context context, @NotNull SavedSearchDao savedSearchDao) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(savedSearchDao, "savedSearchDao");
            if (isRunning() || savedSearchDao.getCount() <= 0) {
                return false;
            }
            context.startService(createIntent(context));
            return true;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<Location> {
        public final /* synthetic */ SearchSubscriptionSyncService a;

        public a(SearchSubscriptionSyncService searchSubscriptionSyncService) {
            this.a = searchSubscriptionSyncService;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            Location location2 = location;
            SearchSubscriptionSyncService searchSubscriptionSyncService = this.a;
            Intrinsics.checkNotNullExpressionValue(location2, "location");
            SearchSubscriptionSyncService.access$synchronizeWithTopLocation(searchSubscriptionSyncService, location2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SavedSearchSyncService", "Failed to load top location", th);
        }
    }

    public SearchSubscriptionSyncService() {
        super("SavedSearchSyncService");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a6, code lost:
        throw r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$synchronizeWithTopLocation(com.avito.android.search.subscriptions.SearchSubscriptionSyncService r12, com.avito.android.remote.model.Location r13) {
        /*
            com.avito.android.db.SavedSearchDao r0 = r12.savedSearchDao
            java.lang.String r1 = "savedSearchDao"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            android.database.Cursor r0 = r0.readSearches()
            java.lang.String r2 = "savedSearchDao.readSearches()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
        L_0x0012:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x00a0 }
            r3 = 0
            if (r2 == 0) goto L_0x009c
            com.avito.android.db.SavedSearchDao r2 = r12.savedSearchDao     // Catch:{ all -> 0x00a0 }
            if (r2 != 0) goto L_0x0020
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x00a0 }
        L_0x0020:
            com.avito.android.db.entity.SavedSearch r2 = r2.readFromCursor(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "savedSearchDao.readFromCursor(cursor)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = r2.searchParams     // Catch:{ all -> 0x00a0 }
            com.avito.android.remote.model.SearchParams r6 = com.avito.android.remote.model.SearchParamsFactory.fromString(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "SearchParamsFactory.from…savedSearch.searchParams)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = r6.getLocationId()     // Catch:{ all -> 0x00a0 }
            if (r4 != 0) goto L_0x0041
            java.lang.String r4 = r13.getId()     // Catch:{ all -> 0x00a0 }
            r6.setLocationId(r4)     // Catch:{ all -> 0x00a0 }
        L_0x0041:
            com.avito.android.remote.model.SearchParamsConverter r5 = r12.searchParamsConverter     // Catch:{ all -> 0x00a0 }
            if (r5 != 0) goto L_0x004a
            java.lang.String r4 = "searchParamsConverter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch:{ all -> 0x00a0 }
        L_0x004a:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            java.util.Map r4 = com.avito.android.remote.model.SearchParamsConverter.DefaultImpls.convertToMap$default(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a0 }
            io.reactivex.rxjava3.disposables.CompositeDisposable r5 = r12.b     // Catch:{ all -> 0x00a0 }
            com.avito.android.subscriptions.remote.SubscriptionsApi r6 = r12.subscriptionsApi     // Catch:{ all -> 0x00a0 }
            if (r6 != 0) goto L_0x005f
            java.lang.String r7 = "subscriptionsApi"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ all -> 0x00a0 }
        L_0x005f:
            r7 = 2
            io.reactivex.rxjava3.core.Observable r3 = com.avito.android.subscriptions.remote.SubscriptionsApi.DefaultImpls.addSearchSubscription$default(r6, r4, r3, r7, r3)     // Catch:{ all -> 0x00a0 }
            com.avito.android.util.SchedulersFactory3 r4 = r12.schedulersFactory     // Catch:{ all -> 0x00a0 }
            java.lang.String r6 = "schedulersFactory"
            if (r4 != 0) goto L_0x006d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x006d:
            io.reactivex.rxjava3.core.Scheduler r4 = r4.trampoline()
            io.reactivex.rxjava3.core.Observable r3 = r3.observeOn(r4)
            com.avito.android.util.SchedulersFactory3 r4 = r12.schedulersFactory
            if (r4 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x007c:
            io.reactivex.rxjava3.core.Scheduler r4 = r4.trampoline()
            io.reactivex.rxjava3.core.Observable r3 = r3.subscribeOn(r4)
            a2.a.a.k2.c.a r4 = new a2.a.a.k2.c.a
            r4.<init>(r2, r12, r13)
            a2.a.a.k2.c.b r6 = new a2.a.a.k2.c.b
            r6.<init>(r2, r12, r13)
            io.reactivex.rxjava3.disposables.Disposable r2 = r3.subscribe(r4, r6)
            java.lang.String r3 = "subscriptionsApi.addSear… }\n                    })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r5, r2)
            goto L_0x0012
        L_0x009c:
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return
        L_0x00a0:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.subscriptions.SearchSubscriptionSyncService.access$synchronizeWithTopLocation(com.avito.android.search.subscriptions.SearchSubscriptionSyncService, com.avito.android.remote.model.Location):void");
    }

    public final void a() {
        Observable<Location> observable;
        if (Contexts.isConnectionAvailable(this)) {
            CompositeDisposable compositeDisposable = this.a;
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            if (features2.getTopLocationSingleRequest().invoke().booleanValue()) {
                TopLocationInteractor topLocationInteractor2 = this.topLocationInteractor;
                if (topLocationInteractor2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLocationInteractor");
                }
                observable = topLocationInteractor2.getTopLocation();
            } else {
                LocationApi locationApi2 = this.locationApi;
                if (locationApi2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationApi");
                }
                observable = locationApi2.getTopLocation();
            }
            SchedulersFactory3 schedulersFactory3 = this.schedulersFactory;
            if (schedulersFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
            }
            Observable<Location> subscribeOn = observable.subscribeOn(schedulersFactory3.trampoline());
            SchedulersFactory3 schedulersFactory32 = this.schedulersFactory;
            if (schedulersFactory32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
            }
            Disposable subscribe = subscribeOn.observeOn(schedulersFactory32.trampoline()).subscribe(new a(this), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "getTopLocation()\n       …load top location\", t) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        SearchSubscriptionConsumer searchSubscriptionConsumer2 = this.searchSubscriptionConsumer;
        if (searchSubscriptionConsumer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSubscriptionConsumer");
        }
        searchSubscriptionConsumer2.accept(new SearchSubscriptionSynchronizedEvent());
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final LocationApi getLocationApi() {
        LocationApi locationApi2 = this.locationApi;
        if (locationApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationApi");
        }
        return locationApi2;
    }

    @NotNull
    public final SavedSearchDao getSavedSearchDao() {
        SavedSearchDao savedSearchDao2 = this.savedSearchDao;
        if (savedSearchDao2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchDao");
        }
        return savedSearchDao2;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulersFactory() {
        SchedulersFactory3 schedulersFactory3 = this.schedulersFactory;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
        }
        return schedulersFactory3;
    }

    @NotNull
    public final SearchParamsConverter getSearchParamsConverter() {
        SearchParamsConverter searchParamsConverter2 = this.searchParamsConverter;
        if (searchParamsConverter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchParamsConverter");
        }
        return searchParamsConverter2;
    }

    @NotNull
    public final SearchSubscriptionConsumer getSearchSubscriptionConsumer() {
        SearchSubscriptionConsumer searchSubscriptionConsumer2 = this.searchSubscriptionConsumer;
        if (searchSubscriptionConsumer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSubscriptionConsumer");
        }
        return searchSubscriptionConsumer2;
    }

    @NotNull
    public final SubscriptionsApi getSubscriptionsApi() {
        SubscriptionsApi subscriptionsApi2 = this.subscriptionsApi;
        if (subscriptionsApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsApi");
        }
        return subscriptionsApi2;
    }

    @NotNull
    public final TopLocationInteractor getTopLocationInteractor() {
        TopLocationInteractor topLocationInteractor2 = this.topLocationInteractor;
        if (topLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topLocationInteractor");
        }
        return topLocationInteractor2;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerSearchSubscriptionSyncServiceComponent.builder().dependentOn((SearchSubscriptionDependencies) ComponentDependenciesKt.getDependencies(SearchSubscriptionDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        this.a.clear();
        this.b.clear();
        c = false;
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        c = true;
        boolean z = false;
        try {
            a();
        } finally {
            c = z;
        }
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setLocationApi(@NotNull LocationApi locationApi2) {
        Intrinsics.checkNotNullParameter(locationApi2, "<set-?>");
        this.locationApi = locationApi2;
    }

    public final void setSavedSearchDao(@NotNull SavedSearchDao savedSearchDao2) {
        Intrinsics.checkNotNullParameter(savedSearchDao2, "<set-?>");
        this.savedSearchDao = savedSearchDao2;
    }

    public final void setSchedulersFactory(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulersFactory = schedulersFactory3;
    }

    public final void setSearchParamsConverter(@NotNull SearchParamsConverter searchParamsConverter2) {
        Intrinsics.checkNotNullParameter(searchParamsConverter2, "<set-?>");
        this.searchParamsConverter = searchParamsConverter2;
    }

    public final void setSearchSubscriptionConsumer(@NotNull SearchSubscriptionConsumer searchSubscriptionConsumer2) {
        Intrinsics.checkNotNullParameter(searchSubscriptionConsumer2, "<set-?>");
        this.searchSubscriptionConsumer = searchSubscriptionConsumer2;
    }

    public final void setSubscriptionsApi(@NotNull SubscriptionsApi subscriptionsApi2) {
        Intrinsics.checkNotNullParameter(subscriptionsApi2, "<set-?>");
        this.subscriptionsApi = subscriptionsApi2;
    }

    public final void setTopLocationInteractor(@NotNull TopLocationInteractor topLocationInteractor2) {
        Intrinsics.checkNotNullParameter(topLocationInteractor2, "<set-?>");
        this.topLocationInteractor = topLocationInteractor2;
    }
}
