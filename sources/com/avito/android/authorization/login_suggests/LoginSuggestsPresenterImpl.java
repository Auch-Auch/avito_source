package com.avito.android.authorization.login_suggests;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenter;
import com.avito.android.authorization.login_suggests.Suggest;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.authorization.login_suggests.adapter.common_login.CommonLoginItem;
import com.avito.android.authorization.login_suggests.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.authorization.login_suggests.adapter.progress.ProgressItem;
import com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItem;
import com.avito.android.authorization.login_suggests.events.CommonLoginClickedEvent;
import com.avito.android.authorization.login_suggests.events.SuggestClickedEvent;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140:\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00106\u001a\u000203\u0012\b\b\u0001\u0010 \u001a\u00020\u001d\u0012\b\u0010>\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u001d\u0010\u0016\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001bR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u00109R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenterImpl;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;", "view", "", "attachView", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;)V", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;)V", "detachRouter", "()V", "detachView", "onBackPressed", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "", "Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", "items", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)V", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/performance/ContentTracker;", "l", "Lcom/avito/android/performance/ContentTracker;", "suggestsTracker", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractor;", "f", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "disposables", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/performance/ScreenTracker;", "k", "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "e", "Ljava/util/List;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "h", "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemClicks", "state", "<init>", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/performance/ScreenTracker;Lcom/avito/android/performance/ContentTracker;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestsPresenterImpl implements LoginSuggestsPresenter {
    public LoginSuggestsView a;
    public LoginSuggestsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends LoginSuggestsItem> e;
    public final LoginSuggestsInteractor f;
    public final AdapterPresenter g;
    public final PublishRelay<LoginSuggestsItem> h;
    public final SchedulersFactory i;
    public final Analytics j;
    public final ScreenTracker k;
    public final ContentTracker l;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Disposable disposable) {
            int i = this.a;
            if (i == 0) {
                ContentTracker.DefaultImpls.loading$default(((LoginSuggestsPresenterImpl) this.b).l, null, 1, null);
            } else if (i == 1) {
                LoginSuggestsPresenterImpl loginSuggestsPresenterImpl = (LoginSuggestsPresenterImpl) this.b;
                List list = loginSuggestsPresenterImpl.e;
                ArrayList arrayList = new ArrayList();
                for (T t : list) {
                    if (!(t instanceof ErrorSnippetItem)) {
                        arrayList.add(t);
                    }
                }
                loginSuggestsPresenterImpl.e = arrayList;
                LoginSuggestsPresenterImpl loginSuggestsPresenterImpl2 = (LoginSuggestsPresenterImpl) this.b;
                loginSuggestsPresenterImpl2.b(CollectionsKt___CollectionsKt.plus((Collection<? extends ProgressItem>) loginSuggestsPresenterImpl2.e, new ProgressItem()));
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<LoginSuggestsItem> {
        public final /* synthetic */ LoginSuggestsPresenterImpl a;

        public b(LoginSuggestsPresenterImpl loginSuggestsPresenterImpl) {
            this.a = loginSuggestsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoginSuggestsItem loginSuggestsItem) {
            LoginSuggestsItem loginSuggestsItem2 = loginSuggestsItem;
            if (loginSuggestsItem2 instanceof SuggestItem) {
                SuggestItem suggestItem = (SuggestItem) loginSuggestsItem2;
                Suggest suggest = suggestItem.getSuggest();
                if (suggest instanceof Suggest.Login) {
                    this.a.j.track(new SuggestClickedEvent(((Suggest.Login) suggestItem.getSuggest()).getLogin(), null, 2, null));
                    LoginSuggestsPresenter.Router router = this.a.b;
                    if (router != null) {
                        router.closeWithLogin(((Suggest.Login) suggestItem.getSuggest()).getLogin());
                    }
                } else if (suggest instanceof Suggest.Social) {
                    this.a.j.track(new SuggestClickedEvent(null, ((Suggest.Social) suggestItem.getSuggest()).getSocial(), 1, null));
                    LoginSuggestsPresenter.Router router2 = this.a.b;
                    if (router2 != null) {
                        router2.closeWithSocial(((Suggest.Social) suggestItem.getSuggest()).getSocial(), ((Suggest.Social) suggestItem.getSuggest()).getSocialId());
                    }
                }
            } else if (loginSuggestsItem2 instanceof CommonLoginItem) {
                this.a.j.track(new CommonLoginClickedEvent());
                LoginSuggestsPresenter.Router router3 = this.a.b;
                if (router3 != null) {
                    router3.closeWithCommon();
                }
            } else if (loginSuggestsItem2 instanceof ErrorSnippetItem) {
                this.a.a();
            }
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ LoginSuggestsPresenterImpl a;

        public c(LoginSuggestsPresenterImpl loginSuggestsPresenterImpl) {
            this.a = loginSuggestsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            LoginSuggestsPresenter.Router router = this.a.b;
            if (router != null) {
                router.close();
            }
        }
    }

    public static final class d<T, R> implements Function<List<? extends Suggest>, List<? extends SuggestItem>> {
        public final /* synthetic */ LoginSuggestsPresenterImpl a;

        public d(LoginSuggestsPresenterImpl loginSuggestsPresenterImpl) {
            this.a = loginSuggestsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends SuggestItem> apply(List<? extends Suggest> list) {
            List<? extends Suggest> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            ContentTracker.DefaultImpls.loaded$default(this.a.l, null, 1, null);
            this.a.l.preparing();
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
            int i = 0;
            for (T t : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new SuggestItem((long) i, t));
                i = i2;
            }
            ContentTracker.DefaultImpls.prepared$default(this.a.l, null, 1, null);
            return arrayList;
        }
    }

    public static final class e<T> implements Consumer<List<? extends SuggestItem>> {
        public final /* synthetic */ LoginSuggestsPresenterImpl a;

        public e(LoginSuggestsPresenterImpl loginSuggestsPresenterImpl) {
            this.a = loginSuggestsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends SuggestItem> list) {
            LoginSuggestsView loginSuggestsView;
            List<? extends SuggestItem> list2 = list;
            this.a.l.drawing();
            if (list2.size() > 2 && (loginSuggestsView = this.a.a) != null) {
                loginSuggestsView.open();
            }
            if (list2.isEmpty()) {
                LoginSuggestsPresenter.Router router = this.a.b;
                if (router != null) {
                    router.closeWithCommon();
                }
            } else {
                LoginSuggestsPresenterImpl loginSuggestsPresenterImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(list2, "items");
                LoginSuggestsPresenterImpl.access$updateItems(loginSuggestsPresenterImpl, CollectionsKt___CollectionsKt.plus((Collection<? extends CommonLoginItem>) list2, new CommonLoginItem()));
            }
            ContentTracker.DefaultImpls.drawn$default(this.a.l, null, 1, null);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ LoginSuggestsPresenterImpl a;

        public f(LoginSuggestsPresenterImpl loginSuggestsPresenterImpl) {
            this.a = loginSuggestsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.l.loaded(ContentTracker.State.Failure);
            LoginSuggestsPresenter.Router router = this.a.b;
            if (router != null) {
                router.closeWithCommon();
            }
        }
    }

    @Inject
    public LoginSuggestsPresenterImpl(@NotNull LoginSuggestsInteractor loginSuggestsInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull PublishRelay<LoginSuggestsItem> publishRelay, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull ScreenTracker screenTracker, @Named("suggests") @NotNull ContentTracker contentTracker, @Nullable Kundle kundle) {
        List<? extends LoginSuggestsItem> emptyList;
        Intrinsics.checkNotNullParameter(loginSuggestsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClicks");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(screenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(contentTracker, "suggestsTracker");
        this.f = loginSuggestsInteractor;
        this.g = adapterPresenter;
        this.h = publishRelay;
        this.i = schedulersFactory;
        this.j = analytics;
        this.k = screenTracker;
        this.l = contentTracker;
        this.e = (kundle == null || (emptyList = kundle.getParcelableList("items")) == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList;
    }

    public static final void access$updateItems(LoginSuggestsPresenterImpl loginSuggestsPresenterImpl, List list) {
        loginSuggestsPresenterImpl.e = list;
        loginSuggestsPresenterImpl.b(list);
    }

    public final void a() {
        this.k.resetSession();
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.f.getSuggests().observeOn(this.i.mainThread()).doOnSubscribe(new a(0, this)).doOnSubscribe(new a(1, this)).map(new d(this)).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSuggests()…thCommon()\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter
    public void attachRouter(@NotNull LoginSuggestsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter
    public void attachView(@NotNull LoginSuggestsView loginSuggestsView) {
        Intrinsics.checkNotNullParameter(loginSuggestsView, "view");
        this.a = loginSuggestsView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.h.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks.subscribe { i…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = loginSuggestsView.navigationClicks().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…router?.close()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        if (this.e.isEmpty()) {
            a();
        } else {
            b(this.e);
        }
    }

    public final void b(List<? extends LoginSuggestsItem> list) {
        AdapterPresentersKt.updateItems(this.g, list);
        LoginSuggestsView loginSuggestsView = this.a;
        if (loginSuggestsView != null) {
            loginSuggestsView.notifyItemsChanged();
        }
        LoginSuggestsView loginSuggestsView2 = this.a;
        if (loginSuggestsView2 != null) {
            ArrayList<LoginSuggestsItem> arrayList = new ArrayList();
            for (T t : list) {
                if (t instanceof SuggestItem) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
            for (LoginSuggestsItem loginSuggestsItem : arrayList) {
                arrayList2.add(Integer.valueOf(list.indexOf(loginSuggestsItem)));
            }
            loginSuggestsView2.setDividers(arrayList2);
        }
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter
    public void onBackPressed() {
        LoginSuggestsView loginSuggestsView = this.a;
        if (loginSuggestsView != null) {
            loginSuggestsView.close();
        }
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("items", this.e);
    }
}
