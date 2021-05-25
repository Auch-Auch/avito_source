package com.avito.android.certificate_pinning;

import a2.g.r.g;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenterImpl;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkView;", "view", "", "attachView", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkView;)V", "detachView", "()V", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "", "autoCheck", "checkNetwork", "(Z)V", "Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractor;", "f", "Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.BOOKING_ORDER, "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;", "d", "Z", "firstCheck", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", AuthSource.SEND_ABUSE, "Lcom/avito/android/certificate_pinning/UnsafeNetworkView;", "", "c", "Ljava/lang/String;", "redirectUrl", "state", "<init>", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class UnsafeNetworkPresenterImpl implements UnsafeNetworkPresenter {
    public UnsafeNetworkView a;
    public UnsafeNetworkPresenter.Router b;
    public String c;
    public boolean d;
    public final CompositeDisposable e;
    public final UnsafeNetworkInteractor f;
    public final SchedulersFactory g;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            UnsafeNetworkPresenter.Router router;
            int i = this.a;
            if (i == 0) {
                ((UnsafeNetworkView) this.b).showLoading();
            } else if (i == 1) {
                UnsafeNetworkPresenter.DefaultImpls.checkNetwork$default((UnsafeNetworkPresenterImpl) this.b, false, 1, null);
            } else if (i == 2) {
                String str = ((UnsafeNetworkPresenterImpl) this.b).c;
                if (str != null && (router = ((UnsafeNetworkPresenterImpl) this.b).b) != null) {
                    router.openBrowser(str);
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                return;
            }
            if (i != 1) {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<NetworkState> {
        public final /* synthetic */ UnsafeNetworkPresenterImpl a;
        public final /* synthetic */ boolean b;

        public c(UnsafeNetworkPresenterImpl unsafeNetworkPresenterImpl, boolean z) {
            this.a = unsafeNetworkPresenterImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(NetworkState networkState) {
            UnsafeNetworkView unsafeNetworkView;
            UnsafeNetworkView unsafeNetworkView2;
            NetworkState networkState2 = networkState;
            long state = networkState2.getState();
            if (state == 0) {
                UnsafeNetworkPresenter.Router router = this.a.b;
                if (router != null) {
                    router.closeScreen();
                }
            } else if (state == 1) {
                UnsafeNetworkView unsafeNetworkView3 = this.a.a;
                if (unsafeNetworkView3 != null) {
                    unsafeNetworkView3.showAuthorizationRequired();
                }
                this.a.c = networkState2.getRedirectUrl();
            } else if (state == 2) {
                if (this.b) {
                    UnsafeNetworkView unsafeNetworkView4 = this.a.a;
                    if (unsafeNetworkView4 != null) {
                        unsafeNetworkView4.showUnsafeNetwork();
                    }
                } else if (this.a.d) {
                    UnsafeNetworkView unsafeNetworkView5 = this.a.a;
                    if (unsafeNetworkView5 != null) {
                        unsafeNetworkView5.showUnsafeNetwork();
                    }
                    this.a.d = false;
                } else {
                    UnsafeNetworkView unsafeNetworkView6 = this.a.a;
                    if (unsafeNetworkView6 != null) {
                        unsafeNetworkView6.showStillUnsafeNetworkError();
                    }
                }
            } else if (state == 3) {
                if ((!this.b) && (unsafeNetworkView2 = this.a.a) != null) {
                    unsafeNetworkView2.showNetworkError();
                }
            } else if ((!this.b) && (unsafeNetworkView = this.a.a) != null) {
                unsafeNetworkView.showUnknownSafetyCheckingError();
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ UnsafeNetworkPresenterImpl a;

        public d(UnsafeNetworkPresenterImpl unsafeNetworkPresenterImpl) {
            this.a = unsafeNetworkPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            UnsafeNetworkView unsafeNetworkView = this.a.a;
            if (unsafeNetworkView != null) {
                unsafeNetworkView.showUnknownSafetyCheckingError();
            }
        }
    }

    @Inject
    public UnsafeNetworkPresenterImpl(@NotNull UnsafeNetworkInteractor unsafeNetworkInteractor, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(unsafeNetworkInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.f = unsafeNetworkInteractor;
        this.g = schedulersFactory;
        this.c = kundle != null ? kundle.getString("redirect_url") : null;
        this.d = (kundle == null || (bool = kundle.getBoolean("first_check")) == null) ? true : bool.booleanValue();
        this.e = new CompositeDisposable();
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    public void attachRouter(@NotNull UnsafeNetworkPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    public void attachView(@NotNull UnsafeNetworkView unsafeNetworkView) {
        Intrinsics.checkNotNullParameter(unsafeNetworkView, "view");
        this.a = unsafeNetworkView;
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = unsafeNetworkView.checkAgainButtonClicks().doOnNext(new a(0, unsafeNetworkView)).subscribe(new a(1, this), b.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.checkAgainButtonCli…work()\n            }, {})");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.e;
        Disposable subscribe2 = unsafeNetworkView.authenticateButtonClicks().subscribe(new a(2, this), b.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.authenticateButtonC…     }\n            }, {})");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        unsafeNetworkView.showLoading();
        UnsafeNetworkPresenter.DefaultImpls.checkNetwork$default(this, false, 1, null);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    public void checkNetwork(boolean z) {
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.f.checkNetworkState().observeOn(this.g.mainThread()).subscribe(new c(this, z), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor\n            .…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    public void detachView() {
        this.e.clear();
        this.a = null;
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    public void onBackPressed() {
        UnsafeNetworkView unsafeNetworkView = this.a;
        if (unsafeNetworkView != null) {
            unsafeNetworkView.showLoading();
        }
        UnsafeNetworkPresenter.DefaultImpls.checkNetwork$default(this, false, 1, null);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("redirect_url", this.c);
    }
}
