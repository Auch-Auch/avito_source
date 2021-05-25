package com.avito.android.authorization.select_social;

import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.SocialCredentials;
import com.avito.android.authorization.event.SocialButtonClickedEvent;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.authorization.select_social.SelectSocialPresenter;
import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010@\u001a\u00020=\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020504\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ7\u0010\u0013\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\fR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010ER\u0016\u0010G\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010 ¨\u0006K"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialPresenterImpl;", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "Lcom/avito/android/authorization/select_social/SelectSocialView;", "view", "", "attachView", "(Lcom/avito/android/authorization/select_social/SelectSocialView;)V", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;)V", "detachRouter", "()V", "detachView", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "user", "onSocialLoginSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginFailure", "onSocialLoginCanceled", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", "suggestKey", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/authorization/select_social/SelectSocialInteractor;", "f", "Lcom/avito/android/authorization/select_social/SelectSocialInteractor;", "interactor", "Lcom/avito/konveyor/adapter/AdapterPresenter;", a2.g.r.g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/authorization/select_social/adapter/SelectSocialField;", "j", "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemClicks", "Lcom/avito/android/authorization/SocialCredentials;", "e", "Lcom/avito/android/authorization/SocialCredentials;", "credentials", "Lcom/avito/android/util/ErrorFormatter;", "i", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "k", "Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "resourceProvider", "Lcom/avito/android/authorization/select_social/SelectSocialView;", "d", "viewDisposables", "state", "<init>", "(Lcom/avito/android/authorization/select_social/SelectSocialInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectSocialPresenterImpl implements SelectSocialPresenter {
    public SelectSocialView a;
    public SelectSocialPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public SocialCredentials e;
    public final SelectSocialInteractor f;
    public final AdapterPresenter g;
    public final SchedulersFactory h;
    public final ErrorFormatter i;
    public final PublishRelay<SelectSocialField> j;
    public final SelectSocialResourceProvider k;
    public final Analytics l;
    public final String m;

    public static final class a<T> implements Consumer<SelectSocialField> {
        public final /* synthetic */ SelectSocialPresenterImpl a;
        public final /* synthetic */ SelectSocialView b;

        public a(SelectSocialPresenterImpl selectSocialPresenterImpl, SelectSocialView selectSocialView) {
            this.a = selectSocialPresenterImpl;
            this.b = selectSocialView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SelectSocialField selectSocialField) {
            SelectSocialField selectSocialField2 = selectSocialField;
            if (selectSocialField2 instanceof SelectSocialField.Social) {
                this.b.showProgress();
                String type = ((SelectSocialField.Social) selectSocialField2).getSocial().getType();
                this.a.l.track(new SocialButtonClickedEvent(SocialButtonClickedEventKt.AUTH, type));
                SelectSocialPresenter.Router router = this.a.b;
                if (router != null) {
                    router.openSocialLogin(type);
                }
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ SelectSocialPresenterImpl a;

        public b(SelectSocialPresenterImpl selectSocialPresenterImpl) {
            this.a = selectSocialPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            SelectSocialPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    public static final class c<T> implements Consumer<List<? extends SelectSocialField>> {
        public final /* synthetic */ SelectSocialPresenterImpl a;
        public final /* synthetic */ SelectSocialView b;

        public c(SelectSocialPresenterImpl selectSocialPresenterImpl, SelectSocialView selectSocialView) {
            this.a = selectSocialPresenterImpl;
            this.b = selectSocialView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends SelectSocialField> list) {
            List<? extends SelectSocialField> list2 = list;
            AdapterPresenter adapterPresenter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(list2, "items");
            AdapterPresentersKt.updateItems(adapterPresenter, list2);
            this.b.notifyItemsChanged();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ SelectSocialPresenterImpl a;
        public final /* synthetic */ SelectSocialView b;

        public d(SelectSocialPresenterImpl selectSocialPresenterImpl, SelectSocialView selectSocialView) {
            this.a = selectSocialPresenterImpl;
            this.b = selectSocialView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.b.showError(this.a.i.format(th));
        }
    }

    public static final class e<T> implements Consumer<Disposable> {
        public final /* synthetic */ SelectSocialPresenterImpl a;

        public e(SelectSocialPresenterImpl selectSocialPresenterImpl) {
            this.a = selectSocialPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            SelectSocialView selectSocialView = this.a.a;
            if (selectSocialView != null) {
                selectSocialView.showProgress();
            }
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ SelectSocialPresenterImpl a;

        public f(SelectSocialPresenterImpl selectSocialPresenterImpl) {
            this.a = selectSocialPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.e = null;
            SelectSocialView selectSocialView = this.a.a;
            if (selectSocialView != null) {
                selectSocialView.hideProgress();
            }
        }
    }

    public static final class g<T> implements Consumer<SocialAuthResult> {
        public final /* synthetic */ SelectSocialPresenterImpl a;

        public g(SelectSocialPresenterImpl selectSocialPresenterImpl) {
            this.a = selectSocialPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SocialAuthResult socialAuthResult) {
            SelectSocialView selectSocialView;
            SocialAuthResult socialAuthResult2 = socialAuthResult;
            if (socialAuthResult2 instanceof SocialAuthResult.Ok) {
                String message = ((SocialAuthResult.Ok) socialAuthResult2).getAuthResult().getMessage();
                if (!(message == null || (selectSocialView = this.a.a) == null)) {
                    selectSocialView.showToast(message);
                }
                SelectSocialPresenter.Router router = this.a.b;
                if (router != null) {
                    router.completeAuthorization();
                    return;
                }
                return;
            }
            SelectSocialView selectSocialView2 = this.a.a;
            if (selectSocialView2 != null) {
                selectSocialView2.showError(this.a.k.getSocialAuthenticationError());
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ SelectSocialPresenterImpl a;

        public h(SelectSocialPresenterImpl selectSocialPresenterImpl) {
            this.a = selectSocialPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof TypedResultException) {
                TypedResultException typedResultException = (TypedResultException) th2;
                if (typedResultException.getErrorResult() instanceof ErrorWithMessage.ErrorDialog) {
                    TypedError errorResult = typedResultException.getErrorResult();
                    Objects.requireNonNull(errorResult, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage.ErrorDialog");
                    ErrorWithMessage.ErrorDialog errorDialog = (ErrorWithMessage.ErrorDialog) errorResult;
                    SelectSocialView selectSocialView = this.a.a;
                    if (selectSocialView != null) {
                        selectSocialView.showErrorDialog(errorDialog.getData().getTitle(), errorDialog.getData().getMessage());
                        return;
                    }
                    return;
                }
            }
            SelectSocialView selectSocialView2 = this.a.a;
            if (selectSocialView2 != null) {
                selectSocialView2.showError(this.a.i.format(th2, new a2.a.a.b.j.a(this)));
            }
        }
    }

    @Inject
    public SelectSocialPresenterImpl(@NotNull SelectSocialInteractor selectSocialInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter, @NotNull PublishRelay<SelectSocialField> publishRelay, @NotNull SelectSocialResourceProvider selectSocialResourceProvider, @NotNull Analytics analytics, @Nullable String str, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(selectSocialInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClicks");
        Intrinsics.checkNotNullParameter(selectSocialResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = selectSocialInteractor;
        this.g = adapterPresenter;
        this.h = schedulersFactory;
        this.i = errorFormatter;
        this.j = publishRelay;
        this.k = selectSocialResourceProvider;
        this.l = analytics;
        this.m = str;
        this.e = kundle != null ? (SocialCredentials) kundle.getParcelable("credentials") : null;
    }

    public final void a() {
        Observable<SocialAuthResult> observable;
        SocialCredentials socialCredentials = this.e;
        if (socialCredentials != null) {
            CompositeDisposable compositeDisposable = this.c;
            String socialType = socialCredentials.getSocialType();
            if (socialType.hashCode() == 93029210 && socialType.equals("apple")) {
                observable = this.f.loginWithApple(socialCredentials.getToken(), socialCredentials.getUser(), this.m);
            } else {
                observable = this.f.login(socialCredentials.getSocialType(), socialCredentials.getToken(), socialCredentials.getEmail(), this.m);
            }
            Disposable subscribe = observable.observeOn(this.h.mainThread()).doOnSubscribe(new e(this)).doOnTerminate(new f(this)).subscribe(new g(this), new h(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "when (credentials.social…     }\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void attachRouter(@NotNull SelectSocialPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        a();
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void attachView(@NotNull SelectSocialView selectSocialView) {
        Intrinsics.checkNotNullParameter(selectSocialView, "view");
        this.a = selectSocialView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.j.subscribe(new a(this, selectSocialView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemClicks.subscribe { i…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = selectSocialView.navigationClicks().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…{ router?.leaveScreen() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = this.f.loadItems().subscribe(new c(this, selectSocialView), new d(this, selectSocialView));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "interactor.loadItems().s…)\n            }\n        )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("credentials", this.e);
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void onSocialLoginCanceled() {
        SelectSocialView selectSocialView = this.a;
        if (selectSocialView != null) {
            selectSocialView.hideProgress();
        }
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void onSocialLoginFailure() {
        SelectSocialView selectSocialView = this.a;
        if (selectSocialView != null) {
            selectSocialView.hideProgress();
        }
        SelectSocialView selectSocialView2 = this.a;
        if (selectSocialView2 != null) {
            selectSocialView2.showError(this.k.getSocialAuthenticationError());
        }
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialPresenter
    public void onSocialLoginSuccess(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (str == null || str2 == null) {
            onSocialLoginFailure();
            return;
        }
        this.e = new SocialCredentials(str, str2, str3, str4);
        a();
    }
}
