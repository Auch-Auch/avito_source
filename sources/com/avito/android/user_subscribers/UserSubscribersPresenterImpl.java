package com.avito.android.user_subscribers;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_subscribers.UserSubscribersPresenter;
import com.avito.android.user_subscribers.action.SubscriberAction;
import com.avito.android.user_subscribers.adapter.UserSubscriberItem;
import com.avito.android.user_subscribers.adapter.error.ErrorItem;
import com.avito.android.user_subscribers.adapter.loading.LoadingItem;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010+\u001a\u00020(\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<\u0012\u0006\u00104\u001a\u000201\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J#\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersPresenterImpl;", "Lcom/avito/android/user_subscribers/UserSubscribersPresenter;", "", AuthSource.BOOKING_ORDER, "()V", "d", "", "error", "Landroid/net/Uri;", "failedUri", AuthSource.SEND_ABUSE, "(Ljava/lang/Throwable;Landroid/net/Uri;)V", "nextPage", "Lcom/avito/android/user_subscribers/adapter/loading/LoadingItem;", "c", "(Landroid/net/Uri;)Lcom/avito/android/user_subscribers/adapter/loading/LoadingItem;", "", "Lcom/avito/android/user_subscribers/adapter/UserSubscriberItem;", "e", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/user_subscribers/UserSubscribersView;", "view", "attachView", "(Lcom/avito/android/user_subscribers/UserSubscribersView;)V", "detachView", "Lcom/avito/android/user_subscribers/UserSubscribersPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/user_subscribers/UserSubscribersPresenter$Router;)V", "detachRouter", "Lcom/avito/android/user_subscribers/UserSubscribersView;", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "actionDisposable", "f", "Landroid/net/Uri;", "currentLoadingNextPage", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/user_subscribers/UserSubscribersPresenter$Router;", "Lcom/avito/android/user_subscribers/UserSubscribersInteractor;", "h", "Lcom/avito/android/user_subscribers/UserSubscribersInteractor;", "interactor", "Lcom/avito/android/error_helper/ErrorHelper;", "k", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Ljava/util/List;", "items", "loadDisposable", "Lio/reactivex/Observable;", "Lcom/avito/android/user_subscribers/action/SubscriberAction;", "j", "Lio/reactivex/Observable;", "itemActions", "state", "<init>", "(Lcom/avito/android/user_subscribers/UserSubscribersInteractor;Lcom/avito/android/util/SchedulersFactory;Lio/reactivex/Observable;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/Kundle;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersPresenterImpl implements UserSubscribersPresenter {
    public List<? extends UserSubscriberItem> a;
    public UserSubscribersView b;
    public UserSubscribersPresenter.Router c;
    public Disposable d;
    public Disposable e;
    public Uri f;
    public final CompositeDisposable g;
    public final UserSubscribersInteractor h;
    public final SchedulersFactory i;
    public final Observable<SubscriberAction> j;
    public final ErrorHelper k;

    public static final class a<T> implements Consumer<SubscriberAction> {
        public final /* synthetic */ UserSubscribersPresenterImpl a;

        public a(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
            this.a = userSubscribersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SubscriberAction subscriberAction) {
            SubscriberAction subscriberAction2 = subscriberAction;
            if (subscriberAction2 instanceof SubscriberAction.OpenDeepLink) {
                UserSubscribersPresenter.Router router = this.a.c;
                if (router != null) {
                    router.followDeepLink(((SubscriberAction.OpenDeepLink) subscriberAction2).getDeepLink());
                }
            } else if (subscriberAction2 instanceof SubscriberAction.LoadPage) {
                UserSubscribersPresenterImpl.access$loadPage(this.a, ((SubscriberAction.LoadPage) subscriberAction2).getUri());
            } else if (subscriberAction2 instanceof SubscriberAction.Retry) {
                UserSubscribersPresenterImpl.access$retryLoadingPage(this.a, ((SubscriberAction.Retry) subscriberAction2).getFailedUri());
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ UserSubscribersPresenterImpl a;

        public b(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
            this.a = userSubscribersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.b();
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ UserSubscribersPresenterImpl a;

        public c(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
            this.a = userSubscribersPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            UserSubscribersView userSubscribersView = this.a.b;
            if (userSubscribersView != null) {
                userSubscribersView.hideRefreshProgress();
            }
        }
    }

    public static final class d<T> implements Consumer<SubscriberList> {
        public final /* synthetic */ UserSubscribersPresenterImpl a;

        public d(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
            this.a = userSubscribersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SubscriberList subscriberList) {
            SubscriberList subscriberList2 = subscriberList;
            UserSubscribersPresenterImpl userSubscribersPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(subscriberList2, "it");
            UserSubscribersPresenterImpl.access$handleLoadSuccess(userSubscribersPresenterImpl, subscriberList2, CollectionsKt__CollectionsKt.emptyList());
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserSubscribersPresenterImpl a;

        public e(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
            this.a = userSubscribersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            UserSubscribersPresenterImpl userSubscribersPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            userSubscribersPresenterImpl.a(th2, null);
        }
    }

    @Inject
    public UserSubscribersPresenterImpl(@NotNull UserSubscribersInteractor userSubscribersInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull Observable<SubscriberAction> observable, @NotNull ErrorHelper errorHelper, @Nullable Kundle kundle) {
        List<? extends UserSubscriberItem> listOf;
        Intrinsics.checkNotNullParameter(userSubscribersInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(observable, "itemActions");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        this.h = userSubscribersInteractor;
        this.i = schedulersFactory;
        this.j = observable;
        this.k = errorHelper;
        this.a = (kundle == null || (listOf = kundle.getParcelableList("items")) == null) ? t6.n.d.listOf(c(null)) : listOf;
        this.g = new CompositeDisposable();
    }

    public static final void access$handleLoadSuccess(UserSubscribersPresenterImpl userSubscribersPresenterImpl, SubscriberList subscriberList, List list) {
        Objects.requireNonNull(userSubscribersPresenterImpl);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(subscriberList.getItems());
        Uri nextPage = subscriberList.getNextPage();
        if (nextPage != null) {
            arrayList.add(userSubscribersPresenterImpl.c(nextPage));
        }
        userSubscribersPresenterImpl.a = arrayList;
        userSubscribersPresenterImpl.d();
    }

    public static final void access$loadPage(UserSubscribersPresenterImpl userSubscribersPresenterImpl, Uri uri) {
        if (uri == null) {
            userSubscribersPresenterImpl.b();
        } else if (!Intrinsics.areEqual(userSubscribersPresenterImpl.f, uri)) {
            userSubscribersPresenterImpl.f = uri;
            Disposable disposable = userSubscribersPresenterImpl.d;
            if (disposable != null) {
                disposable.dispose();
            }
            userSubscribersPresenterImpl.d = userSubscribersPresenterImpl.h.getSubscriberList(uri).observeOn(userSubscribersPresenterImpl.i.mainThread()).doFinally(new a2.a.a.m3.a(userSubscribersPresenterImpl)).subscribe(new a2.a.a.m3.b(userSubscribersPresenterImpl), new a2.a.a.m3.c(userSubscribersPresenterImpl, uri));
        }
    }

    public static final void access$retryLoadingPage(UserSubscribersPresenterImpl userSubscribersPresenterImpl, Uri uri) {
        userSubscribersPresenterImpl.a = CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) userSubscribersPresenterImpl.e(userSubscribersPresenterImpl.a), userSubscribersPresenterImpl.c(uri));
        userSubscribersPresenterImpl.d();
    }

    public final void a(Throwable th, Uri uri) {
        this.a = CollectionsKt___CollectionsKt.plus((Collection<? extends ErrorItem>) e(this.a), new ErrorItem("error_item", this.k.recycle(th), uri));
        d();
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersPresenter
    public void attachRouter(@NotNull UserSubscribersPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersPresenter
    public void attachView(@NotNull UserSubscribersView userSubscribersView) {
        Intrinsics.checkNotNullParameter(userSubscribersView, "view");
        this.b = userSubscribersView;
        this.e = this.j.subscribe(new a(this));
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = userSubscribersView.refreshClicks().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.refreshClicks().sub…loadFirstPage()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        d();
    }

    public final void b() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = this.h.getSubscriberList().observeOn(this.i.mainThread()).doFinally(new c(this)).subscribe(new d(this), new e(this));
    }

    public final LoadingItem c(Uri uri) {
        return new LoadingItem(PageLoadingItem.ID, uri);
    }

    public final void d() {
        UserSubscribersView userSubscribersView = this.b;
        if (userSubscribersView != null) {
            userSubscribersView.showEmptyState(this.a.isEmpty());
        }
        UserSubscribersView userSubscribersView2 = this.b;
        if (userSubscribersView2 != null) {
            userSubscribersView2.setItems(new ListDataSource(this.a));
        }
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersPresenter
    public void detachView() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.e;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.g.clear();
    }

    public final List<UserSubscriberItem> e(List<? extends UserSubscriberItem> list) {
        boolean z;
        if (!list.isEmpty()) {
            ListIterator<? extends UserSubscriberItem> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                UserSubscriberItem userSubscriberItem = (UserSubscriberItem) listIterator.previous();
                if ((userSubscriberItem instanceof LoadingItem) || (userSubscriberItem instanceof ErrorItem)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    return CollectionsKt___CollectionsKt.take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("items", this.a);
    }
}
