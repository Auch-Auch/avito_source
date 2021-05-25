package com.avito.android.async_phone;

import a2.a.a.l.f;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.AsyncPhoneItemView;
import ru.avito.component.serp.PhoneLoadingState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010@\u001a\u00020$\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010;\u001a\u000208\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020B0A\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\bJ\u0010KJE\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018JI\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u001dJC\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0019H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010\u0018R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010=R\u0016\u0010@\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010&R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020B0A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhonePresenterImpl;", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "Lru/avito/component/serp/AsyncPhoneItemView;", "itemView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "Lkotlin/Function1;", "", "onComplete", "loadPhoneLink", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Lru/avito/component/serp/AsyncPhoneItemView;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;Lkotlin/jvm/functions/Function1;)V", "bindItem", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Lru/avito/component/serp/AsyncPhoneItemView;)V", "unbindItem", "(Lcom/avito/android/async_phone/AsyncPhoneItem;)V", "Lcom/avito/android/async_phone/AsyncPhoneView;", "view", "attachView", "(Lcom/avito/android/async_phone/AsyncPhoneView;)V", "detachView", "()V", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "deepLink", "Lcom/avito/android/remote/error/TypedError;", "onError", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lru/avito/component/serp/AsyncPhoneItemView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "c", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "k", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/async_phone/AsyncPhoneView;", "Lcom/avito/android/async_phone/AsyncPhoneTracker;", "f", "Lcom/avito/android/async_phone/AsyncPhoneTracker;", "asyncPhoneTracker", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadingSubscription", "Lcom/avito/android/async_phone/AsyncPhoneInteractor;", "d", "Lcom/avito/android/async_phone/AsyncPhoneInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "i", "Lcom/avito/android/Features;", "features", "La2/a/a/l/g;", "La2/a/a/l/g;", "dataPair", "e", "throwableConverter", "Ldagger/Lazy;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "j", "Ldagger/Lazy;", "router", "Lcom/avito/android/account/AccountStateProvider;", "h", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "<init>", "(Lcom/avito/android/async_phone/AsyncPhoneInteractor;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/async_phone/AsyncPhoneTracker;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/Features;Ldagger/Lazy;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AsyncPhonePresenterImpl implements AsyncPhonePresenter {
    public AsyncPhoneView a;
    public Disposable b;
    public a2.a.a.l.g c;
    public final AsyncPhoneInteractor d;
    public final TypedErrorThrowableConverter e;
    public final AsyncPhoneTracker f;
    public final SchedulersFactory3 g;
    public final AccountStateProvider h;
    public final Features i;
    public final Lazy<AsyncPhoneAuthRouter> j;
    public final TypedErrorThrowableConverter k;

    /* compiled from: java-style lambda group */
    public static final class a implements Action {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            int i = this.a;
            if (i == 0) {
                AsyncPhonePresenterImpl.access$updateState((AsyncPhonePresenterImpl) this.b, PhoneLoadingState.IDLE);
                ((AsyncPhonePresenterImpl) this.b).c = null;
            } else if (i == 1) {
                AsyncPhonePresenterImpl.access$updateState((AsyncPhonePresenterImpl) this.b, PhoneLoadingState.IDLE);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<Observable<Throwable>, ObservableSource<?>> {
        public final /* synthetic */ AsyncPhonePresenterImpl a;

        public b(AsyncPhonePresenterImpl asyncPhonePresenterImpl) {
            this.a = asyncPhonePresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<?> apply(Observable<Throwable> observable) {
            return observable.observeOn(this.a.g.mainThread()).flatMap(new f(this));
        }
    }

    public static final class c<T> implements Consumer<Disposable> {
        public final /* synthetic */ AsyncPhonePresenterImpl a;

        public c(AsyncPhonePresenterImpl asyncPhonePresenterImpl) {
            this.a = asyncPhonePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            AsyncPhonePresenterImpl.access$updateState(this.a, PhoneLoadingState.BLOCKED);
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super DeepLink>> {
        public final /* synthetic */ AsyncPhonePresenterImpl a;
        public final /* synthetic */ Function1 b;

        public d(AsyncPhonePresenterImpl asyncPhonePresenterImpl, Function1 function1) {
            this.a = asyncPhonePresenterImpl;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DeepLink> loadingState) {
            PhoneLoadingState phoneLoadingState;
            LoadingState<? super DeepLink> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                phoneLoadingState = PhoneLoadingState.LOADING;
            } else {
                phoneLoadingState = PhoneLoadingState.IDLE;
            }
            AsyncPhonePresenterImpl.access$updateState(this.a, phoneLoadingState);
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.b.invoke(((LoadingState.Loaded) loadingState2).getData());
                this.a.c = null;
            } else if (loadingState2 instanceof LoadingState.Error) {
                Logs.error$default("AsyncPhonePresenterImpl load phone error", ((LoadingState.Error) loadingState2).getError().toString(), null, 4, null);
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ AsyncPhonePresenterImpl a;
        public final /* synthetic */ Function1 b;

        public e(AsyncPhonePresenterImpl asyncPhonePresenterImpl, Function1 function1) {
            this.a = asyncPhonePresenterImpl;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Function1 function1 = this.b;
            if (function1 != null) {
                TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.k;
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                Unit unit = (Unit) function1.invoke(typedErrorThrowableConverter.convert(th2));
            }
            Logs.error("AsyncPhonePresenterImpl load phone error", th2);
        }
    }

    @Inject
    public AsyncPhonePresenterImpl(@NotNull AsyncPhoneInteractor asyncPhoneInteractor, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull AsyncPhoneTracker asyncPhoneTracker, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStateProvider accountStateProvider, @NotNull Features features, @NotNull Lazy<AsyncPhoneAuthRouter> lazy, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter2) {
        Intrinsics.checkNotNullParameter(asyncPhoneInteractor, "interactor");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(asyncPhoneTracker, "asyncPhoneTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(lazy, "router");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter2, "errorConverter");
        this.d = asyncPhoneInteractor;
        this.e = typedErrorThrowableConverter;
        this.f = asyncPhoneTracker;
        this.g = schedulersFactory3;
        this.h = accountStateProvider;
        this.i = features;
        this.j = lazy;
        this.k = typedErrorThrowableConverter2;
    }

    public static final void access$updateState(AsyncPhonePresenterImpl asyncPhonePresenterImpl, PhoneLoadingState phoneLoadingState) {
        a2.a.a.l.g gVar = asyncPhonePresenterImpl.c;
        if (gVar != null) {
            AsyncPhoneItem asyncPhoneItem = gVar.a;
            if (asyncPhoneItem != null) {
                asyncPhoneItem.setPhoneLoadingState(phoneLoadingState);
            }
            AsyncPhoneItemView asyncPhoneItemView = gVar.b;
            if (asyncPhoneItemView != null) {
                asyncPhoneItemView.setPhoneLoadingState(phoneLoadingState);
            }
        }
    }

    public final void a() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = null;
        AsyncPhoneView asyncPhoneView = this.a;
        if (asyncPhoneView != null) {
            asyncPhoneView.dismissPhoneLoadError();
        }
        PhoneLoadingState phoneLoadingState = PhoneLoadingState.IDLE;
        a2.a.a.l.g gVar = this.c;
        if (gVar != null) {
            AsyncPhoneItem asyncPhoneItem = gVar.a;
            if (asyncPhoneItem != null) {
                asyncPhoneItem.setPhoneLoadingState(phoneLoadingState);
            }
            AsyncPhoneItemView asyncPhoneItemView = gVar.b;
            if (asyncPhoneItemView != null) {
                asyncPhoneItemView.setPhoneLoadingState(phoneLoadingState);
            }
        }
        this.c = null;
    }

    @Override // com.avito.android.async_phone.AsyncPhonePresenter
    public void attachView(@NotNull AsyncPhoneView asyncPhoneView) {
        Intrinsics.checkNotNullParameter(asyncPhoneView, "view");
        this.a = asyncPhoneView;
    }

    public final void b(PhoneRequestLink phoneRequestLink, Function1<? super DeepLink, Unit> function1, Function1<? super TypedError, Unit> function12) {
        Observable<LoadingState<DeepLink>> onErrorResumeNext = this.d.loadPhone(phoneRequestLink.getItemId(), phoneRequestLink.getContext()).doOnSubscribe(new a2.a.a.l.a(this)).doOnNext(new a2.a.a.l.b(this)).onErrorResumeNext(new a2.a.a.l.d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "interactor.loadPhone(dee…          }\n            }");
        Observable<LoadingState<DeepLink>> share = onErrorResumeNext.share();
        this.b = Observable.merge(Observable.just(LoadingState.Loading.INSTANCE).delay(250, TimeUnit.MILLISECONDS, this.g.computation()).takeUntil(share), share).retryWhen(new b(this)).observeOn(this.g.mainThread()).doOnSubscribe(new c(this)).doOnDispose(new a(0, this)).subscribe(new d(this, function1), new e(this, function12), new a(1, this));
    }

    @Override // com.avito.android.async_phone.AsyncPhonePresenter
    public void bindItem(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull AsyncPhoneItemView asyncPhoneItemView) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(asyncPhoneItemView, "itemView");
        asyncPhoneItemView.setPhoneLoadingState(asyncPhoneItem.getPhoneLoadingState());
        a2.a.a.l.g gVar = this.c;
        if (gVar != null && Intrinsics.areEqual(gVar.a, asyncPhoneItem)) {
            this.c = new a2.a.a.l.g(gVar.a, asyncPhoneItemView);
        }
    }

    public final boolean c(PhoneRequestLink phoneRequestLink) {
        return this.i.getAdvertPhoneContactUnderAuth().invoke().booleanValue() && phoneRequestLink.getNeedAuth() && !this.h.isAuthorized();
    }

    @Override // com.avito.android.async_phone.AsyncPhonePresenter
    public void detachView() {
        a();
        this.a = null;
    }

    @Override // com.avito.android.async_phone.AsyncPhonePresenter
    public void loadPhoneLink(@NotNull AsyncPhoneItem asyncPhoneItem, @Nullable AsyncPhoneItemView asyncPhoneItemView, @NotNull DeepLink deepLink, @NotNull ContactSource contactSource, @NotNull Function1<? super DeepLink, Unit> function1) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        a();
        if (!(deepLink instanceof PhoneRequestLink)) {
            function1.invoke(deepLink);
            return;
        }
        PhoneRequestLink phoneRequestLink = (PhoneRequestLink) deepLink;
        if (c(phoneRequestLink)) {
            this.j.get().showAuth(asyncPhoneItem, AuthSource.PHONE_REQUEST, contactSource);
            return;
        }
        this.c = new a2.a.a.l.g(asyncPhoneItem, asyncPhoneItemView);
        b(phoneRequestLink, function1, null);
    }

    @Override // com.avito.android.async_phone.AsyncPhonePresenter
    public void unbindItem(@NotNull AsyncPhoneItem asyncPhoneItem) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        a2.a.a.l.g gVar = this.c;
        if (gVar != null && Intrinsics.areEqual(gVar.a, asyncPhoneItem)) {
            a();
        }
    }

    @Override // com.avito.android.async_phone.AsyncPhonePresenter
    public void loadPhoneLink(@NotNull PhoneRequestLink phoneRequestLink, @Nullable AsyncPhoneItemView asyncPhoneItemView, @NotNull Function1<? super DeepLink, Unit> function1, @NotNull Function1<? super TypedError, Unit> function12) {
        Intrinsics.checkNotNullParameter(phoneRequestLink, "deepLink");
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        Intrinsics.checkNotNullParameter(function12, "onError");
        a();
        if (c(phoneRequestLink)) {
            this.j.get().showAuth(AuthSource.PHONE_REQUEST);
            return;
        }
        this.c = new a2.a.a.l.g(null, asyncPhoneItemView);
        b(phoneRequestLink, function1, function12);
    }
}
