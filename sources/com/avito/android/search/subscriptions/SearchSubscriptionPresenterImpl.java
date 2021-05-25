package com.avito.android.search.subscriptions;

import android.os.Bundle;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SearchSubscriptionsItemClickEvent;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenter;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionDataSource;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItem;
import com.avito.android.tracker.SearchSubscriptionsTracker;
import com.avito.android.util.CloseablesKt;
import com.avito.android.util.Formatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.android.util.UnauthorizedException;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020B0A\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010Z\u001a\u00020W¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b!\u0010\u001fR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010=R\u0016\u0010@\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u00100R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020B0A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010=R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006^"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenterImpl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "", AuthSource.SEND_ABUSE, "()V", "d", "c", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/subscriptions/SearchSubscriptionView;", "view", "attachView", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionView;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;)V", "onResume", "onViewPaused", "detachView", "detachRouter", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "onRefresh", "", "success", "onLoginResult", "(Z)V", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "searchSubscription", "onSubscriptionClicked", "(Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;)V", "onRemoveSubscriptionClicked", "onMoreActionClicked", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "l", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "searchSubscriptionObservable", "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", "f", "Z", "isAuthOpened", "Lcom/avito/android/search/subscriptions/SearchSubscriptionView;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "o", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/remote/model/SearchSubscription;", a2.g.r.g.a, "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "requestSubscriptions", "e", "refreshInProgress", "Lcom/avito/android/util/Formatter;", "", "i", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractor;", "k", "Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractor;", "serviceInteractor", "subscriptions", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/tracker/SearchSubscriptionsTracker;", "p", "Lcom/avito/android/tracker/SearchSubscriptionsTracker;", "tracker", "Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;", "j", "Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;", "interactor", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", VKApiConst.Q, "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchesPresenter", "savedState", "<init>", "(Landroid/os/Bundle;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Formatter;Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractor;Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/tracker/SearchSubscriptionsTracker;Lcom/avito/android/saved_searches/SavedSearchesPresenter;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionPresenterImpl implements SearchSubscriptionPresenter {
    public CompositeDisposable a = new CompositeDisposable();
    public CompositeDisposable b = new CompositeDisposable();
    public SearchSubscriptionView c;
    public SearchSubscriptionPresenter.Router d;
    public boolean e;
    public boolean f;
    public DataSource<SearchSubscription> g;
    public final Analytics h;
    public final Formatter<Throwable> i;
    public final SearchSubscriptionInteractor j;
    public final SearchSubscriptionServiceInteractor k;
    public final SearchSubscriptionObservable l;
    public final AccountStorageInteractor m;
    public final SchedulersFactory3 n;
    public final AdapterPresenter o;
    public final SearchSubscriptionsTracker p;
    public final SavedSearchesPresenter q;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<SearchSubscriptionSynchronizedEvent, Unit> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            super(1);
            this.a = searchSubscriptionPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SearchSubscriptionSynchronizedEvent searchSubscriptionSynchronizedEvent) {
            this.a.d();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<SearchSubscriptionUpdatedEvent, Unit> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            super(1);
            this.a = searchSubscriptionPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SearchSubscriptionUpdatedEvent searchSubscriptionUpdatedEvent) {
            SearchSubscriptionPresenterImpl.access$onSearchSubscriptionsRefreshed(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink>> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public d(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink> pair) {
            this.a.c();
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public e(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            SearchSubscriptionPresenter.Router router = this.a.d;
            if (router != null) {
                router.showNotificationSettingsScreen();
            }
        }
    }

    public static final class f<T> implements Consumer<List<? extends SearchSubscription>> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public f(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends SearchSubscription> list) {
            List<? extends SearchSubscription> list2 = list;
            this.a.p.trackSubscriptionsLoaded();
            this.a.p.startSubscriptionsDraw();
            SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "searchSubscriptions");
            SearchSubscriptionPresenterImpl.access$onSearchSubscriptionsLoaded(searchSubscriptionPresenterImpl, new ListDataSource(list2));
            this.a.p.trackSubscriptionsDraw();
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public g(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.p.trackSubscriptionsLoadError();
            this.a.p.startSubscriptionsDraw();
            SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "throwable");
            SearchSubscriptionPresenterImpl.access$onLoadErrorReceived(searchSubscriptionPresenterImpl, th2);
            this.a.p.trackSubscriptionsErrorDraw();
        }
    }

    public static final class h<T> implements Consumer<SubscriptionResult> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public h(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SubscriptionResult subscriptionResult) {
            this.a.c();
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public i(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "throwable");
            SearchSubscriptionPresenterImpl.access$onDeleteErrorReceived(searchSubscriptionPresenterImpl, th2);
        }
    }

    public static final class j<T> implements Consumer<Boolean> {
        public final /* synthetic */ SearchSubscriptionPresenterImpl a;

        public j(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
            this.a = searchSubscriptionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (bool2.booleanValue()) {
                SearchSubscriptionPresenterImpl.access$initialSubscriptionsRequest(this.a);
            } else {
                this.a.a();
            }
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public static final k a = new k();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    @Inject
    public SearchSubscriptionPresenterImpl(@Nullable Bundle bundle, @NotNull Analytics analytics, @NotNull Formatter<Throwable> formatter, @NotNull SearchSubscriptionInteractor searchSubscriptionInteractor, @NotNull SearchSubscriptionServiceInteractor searchSubscriptionServiceInteractor, @NotNull SearchSubscriptionObservable searchSubscriptionObservable, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdapterPresenter adapterPresenter, @NotNull SearchSubscriptionsTracker searchSubscriptionsTracker, @NotNull SavedSearchesPresenter savedSearchesPresenter) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(searchSubscriptionInteractor, "interactor");
        Intrinsics.checkNotNullParameter(searchSubscriptionServiceInteractor, "serviceInteractor");
        Intrinsics.checkNotNullParameter(searchSubscriptionObservable, "searchSubscriptionObservable");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(searchSubscriptionsTracker, "tracker");
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "savedSearchesPresenter");
        this.h = analytics;
        this.i = formatter;
        this.j = searchSubscriptionInteractor;
        this.k = searchSubscriptionServiceInteractor;
        this.l = searchSubscriptionObservable;
        this.m = accountStorageInteractor;
        this.n = schedulersFactory3;
        this.o = adapterPresenter;
        this.p = searchSubscriptionsTracker;
        this.q = savedSearchesPresenter;
        this.f = bundle != null ? bundle.getBoolean("auth_opened") : false;
    }

    public static final void access$initialSubscriptionsRequest(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
        SearchSubscriptionView searchSubscriptionView = searchSubscriptionPresenterImpl.c;
        if (searchSubscriptionView != null) {
            searchSubscriptionView.showProgress();
        }
        searchSubscriptionPresenterImpl.d();
    }

    public static final void access$onDeleteErrorReceived(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl, Throwable th) {
        searchSubscriptionPresenterImpl.b();
        if (th instanceof UnauthorizedException) {
            searchSubscriptionPresenterImpl.a();
            return;
        }
        SearchSubscriptionView searchSubscriptionView = searchSubscriptionPresenterImpl.c;
        if (searchSubscriptionView != null) {
            searchSubscriptionView.showError(searchSubscriptionPresenterImpl.i.format(th));
        }
    }

    public static final void access$onLoadErrorReceived(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl, Throwable th) {
        searchSubscriptionPresenterImpl.b();
        if (Throwables.isAuthProblem(th)) {
            searchSubscriptionPresenterImpl.a();
        } else if (Throwables.isNetworkProblem(th)) {
            SearchSubscriptionView searchSubscriptionView = searchSubscriptionPresenterImpl.c;
            if (searchSubscriptionView != null) {
                searchSubscriptionView.onDataSourceUnavailable();
            }
        } else {
            SearchSubscriptionView searchSubscriptionView2 = searchSubscriptionPresenterImpl.c;
            if (searchSubscriptionView2 != null) {
                searchSubscriptionView2.onDataSourceUnavailable();
            }
            SearchSubscriptionView searchSubscriptionView3 = searchSubscriptionPresenterImpl.c;
            if (searchSubscriptionView3 != null) {
                searchSubscriptionView3.showError(searchSubscriptionPresenterImpl.i.format(th));
            }
        }
    }

    public static final void access$onSearchSubscriptionsLoaded(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl, DataSource dataSource) {
        DataSource<SearchSubscription> dataSource2 = searchSubscriptionPresenterImpl.g;
        if (!(dataSource2 instanceof CloseableDataSource)) {
            dataSource2 = null;
        }
        CloseableDataSource closeableDataSource = (CloseableDataSource) dataSource2;
        if (closeableDataSource != null) {
            CloseablesKt.closeQuiet(closeableDataSource);
        }
        searchSubscriptionPresenterImpl.g = dataSource;
        searchSubscriptionPresenterImpl.o.onDataSourceChanged(new SearchSubscriptionDataSource(dataSource));
        if (!dataSource.isEmpty() || !searchSubscriptionPresenterImpl.e) {
            SearchSubscriptionView searchSubscriptionView = searchSubscriptionPresenterImpl.c;
            if (searchSubscriptionView != null) {
                searchSubscriptionView.onDataChanged();
            }
            searchSubscriptionPresenterImpl.b();
            if (dataSource.isEmpty()) {
                SearchSubscriptionView searchSubscriptionView2 = searchSubscriptionPresenterImpl.c;
                if (searchSubscriptionView2 != null) {
                    searchSubscriptionView2.showEmpty();
                    return;
                }
                return;
            }
            SearchSubscriptionView searchSubscriptionView3 = searchSubscriptionPresenterImpl.c;
            if (searchSubscriptionView3 != null) {
                searchSubscriptionView3.hideEmpty();
            }
        }
    }

    public static final void access$onSearchSubscriptionsRefreshed(SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl) {
        searchSubscriptionPresenterImpl.e = false;
        searchSubscriptionPresenterImpl.c();
    }

    public final void a() {
        SearchSubscriptionView searchSubscriptionView = this.c;
        if (searchSubscriptionView != null) {
            searchSubscriptionView.showEmpty();
        }
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void attachRouter(@Nullable SearchSubscriptionPresenter.Router router) {
        this.d = router;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void attachView(@Nullable SearchSubscriptionView searchSubscriptionView) {
        this.c = searchSubscriptionView;
        DisposableKt.plusAssign(this.b, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.n, this.l.observeSynchronizedEvent(), "searchSubscriptionObserv…(schedulers.mainThread())"), new b(this)));
        DisposableKt.plusAssign(this.b, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.n, this.l.observeUpdatedEvent(), "searchSubscriptionObserv…(schedulers.mainThread())"), new c(this)));
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = this.q.subscribeAction().observeOn(this.n.mainThread()).subscribe(new d(this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "savedSearchesPresenter\n …or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        Disposable subscribe2 = this.q.showSettingsAction().observeOn(this.n.mainThread()).subscribe(new e(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "savedSearchesPresenter\n ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public final void b() {
        SearchSubscriptionView searchSubscriptionView = this.c;
        if (searchSubscriptionView != null) {
            searchSubscriptionView.hideRefreshing();
        }
        SearchSubscriptionView searchSubscriptionView2 = this.c;
        if (searchSubscriptionView2 != null) {
            searchSubscriptionView2.hideProgress();
        }
    }

    public final void c() {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.j.loadRemoteSearchSubscriptions().subscribeOn(this.n.io()).observeOn(this.n.mainThread()).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadRemoteSea…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void d() {
        this.p.startSubscriptionsLoading();
        this.e = true;
        SearchSubscriptionView searchSubscriptionView = this.c;
        if (searchSubscriptionView != null) {
            searchSubscriptionView.showRefreshing();
        }
        this.k.refreshSearchSubscriptionService();
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void detachView() {
        this.b.clear();
        this.a.clear();
        DataSource<SearchSubscription> dataSource = this.g;
        if (!(dataSource instanceof CloseableDataSource)) {
            dataSource = null;
        }
        CloseableDataSource closeableDataSource = (CloseableDataSource) dataSource;
        if (closeableDataSource != null) {
            CloseablesKt.closeQuiet(closeableDataSource);
        }
        this.c = null;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void onLoginResult(boolean z) {
        if (z) {
            SearchSubscriptionView searchSubscriptionView = this.c;
            if (searchSubscriptionView != null) {
                searchSubscriptionView.showProgress();
            }
            onRefresh();
            return;
        }
        SearchSubscriptionPresenter.Router router = this.d;
        if (router != null) {
            router.closeScreen();
        }
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter.Listener
    public void onMoreActionClicked(@NotNull SearchSubscriptionItem searchSubscriptionItem) {
        SearchPushSubscription subscription;
        Intrinsics.checkNotNullParameter(searchSubscriptionItem, "searchSubscription");
        SaveSearchLink editAction = searchSubscriptionItem.getEditAction();
        if (editAction != null && (subscription = editAction.getSubscription()) != null) {
            SavedSearchesPresenter.DefaultImpls.openSubscriptionDialog$default(this.q, subscription, "favourites", null, 4, null);
        }
    }

    @Override // com.avito.android.progress_overlay.OnRefreshListener
    public void onRefresh() {
        d();
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter.Listener
    public void onRemoveSubscriptionClicked(@NotNull SearchSubscriptionItem searchSubscriptionItem) {
        Intrinsics.checkNotNullParameter(searchSubscriptionItem, "searchSubscription");
        SearchSubscriptionView searchSubscriptionView = this.c;
        if (searchSubscriptionView != null) {
            searchSubscriptionView.showProgress();
        }
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = this.j.removeSearchSubscription(searchSubscriptionItem.getStringId()).subscribeOn(this.n.io()).observeOn(this.n.mainThread()).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.removeSearchS…hrowable) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void onResume() {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.m.authorized().observeOn(this.n.mainThread()).distinctUntilChanged().subscribe(new j(this), k.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStorageInteractor….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("auth_opened", this.f);
        return bundle;
    }

    @Override // com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter.Listener
    public void onSubscriptionClicked(@NotNull SearchSubscriptionItem searchSubscriptionItem) {
        Intrinsics.checkNotNullParameter(searchSubscriptionItem, "searchSubscription");
        this.h.track(new SearchSubscriptionsItemClickEvent(searchSubscriptionItem.getSsid()));
        if (searchSubscriptionItem.getDeeplink() != null) {
            SearchSubscriptionPresenter.Router router = this.d;
            if (router != null) {
                router.openSearchSubscription(searchSubscriptionItem.getDeeplink());
                return;
            }
            return;
        }
        SearchSubscriptionPresenter.Router router2 = this.d;
        if (router2 != null) {
            router2.openSearchSubscription(searchSubscriptionItem.getStringId(), searchSubscriptionItem.getTitle());
        }
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter
    public void onViewPaused() {
        this.a.clear();
    }
}
