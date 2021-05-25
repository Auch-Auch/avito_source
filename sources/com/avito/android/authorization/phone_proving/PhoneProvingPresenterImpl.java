package com.avito.android.authorization.phone_proving;

import a2.a.a.b.g.c;
import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.event.AntihackEventSource;
import com.avito.android.authorization.event.AntihackReturnOnPhoneListEvent;
import com.avito.android.authorization.phone_proving.PhoneProvingPresenter;
import com.avito.android.authorization.phone_proving.di.ChallengeId;
import com.avito.android.authorization.phone_proving.di.InputHint;
import com.avito.android.authorization.phone_proving.di.IsOpenedFromPhoneList;
import com.avito.android.authorization.phone_proving.di.PhonePart;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0001\u0010A\u001a\u00020\u0014\u0012\b\b\u0001\u0010$\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u00101\u001a\u00020.\u0012\b\u0010B\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\fR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00104R$\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0016¨\u0006E"}, d2 = {"Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenterImpl;", "Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter;", "Lcom/avito/android/authorization/phone_proving/PhoneProvingView;", "view", "", "attachView", "(Lcom/avito/android/authorization/phone_proving/PhoneProvingView;)V", "Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "trackOnScreenClosed", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "", "e", "Ljava/lang/String;", "phoneEnding", "Lcom/avito/android/authorization/phone_proving/PhoneProvingPresenter$Router;", g.a, "challengeId", "", "j", "Z", "isOpenedFromPhoneList", "Lcom/avito/android/error_helper/ErrorHelper;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "i", "inputHint", "Lcom/avito/android/authorization/phone_proving/PhoneProvingInteractor;", "k", "Lcom/avito/android/authorization/phone_proving/PhoneProvingInteractor;", "interactor", "Lcom/avito/android/authorization/phone_proving/PhoneProvingView;", "Lcom/avito/android/dialog/DialogPresenter;", "l", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "c", "disposables", "", "f", "Ljava/util/Map;", "errors", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "h", "phonePart", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/authorization/phone_proving/PhoneProvingInteractor;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneProvingPresenterImpl implements PhoneProvingPresenter {
    public PhoneProvingView a;
    public PhoneProvingPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public Map<String, String> f;
    public final String g;
    public final String h;
    public final String i;
    public final boolean j;
    public final PhoneProvingInteractor k;
    public final DialogPresenter l;
    public final ErrorHelper m;
    public final SchedulersFactory n;
    public final Analytics o;

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
            int i = this.a;
            if (i == 0) {
                PhoneProvingPresenterImpl.access$closeScreen((PhoneProvingPresenterImpl) this.b);
            } else if (i == 1) {
                PhoneProvingPresenterImpl.access$onProvePhone((PhoneProvingPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ PhoneProvingPresenterImpl a;

        public b(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
            this.a = phoneProvingPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            PhoneProvingPresenterImpl phoneProvingPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            phoneProvingPresenterImpl.e = str2;
            this.a.b();
        }
    }

    @Inject
    public PhoneProvingPresenterImpl(@ChallengeId @NotNull String str, @PhonePart @NotNull String str2, @InputHint @NotNull String str3, @IsOpenedFromPhoneList boolean z, @NotNull PhoneProvingInteractor phoneProvingInteractor, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @Nullable Kundle kundle) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(str, "challengeId");
        Intrinsics.checkNotNullParameter(str2, "phonePart");
        Intrinsics.checkNotNullParameter(str3, "inputHint");
        Intrinsics.checkNotNullParameter(phoneProvingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = z;
        this.k = phoneProvingInteractor;
        this.l = dialogPresenter;
        this.m = errorHelper;
        this.n = schedulersFactory;
        this.o = analytics;
        String string = kundle != null ? kundle.getString("phone_ending") : null;
        this.e = string == null ? "" : string;
        this.f = (kundle == null || (emptyMap = kundle.getStringMap("errors")) == null) ? r.emptyMap() : emptyMap;
    }

    public static final void access$closeScreen(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
        phoneProvingPresenterImpl.trackOnScreenClosed();
        PhoneProvingPresenter.Router router = phoneProvingPresenterImpl.b;
        if (router != null) {
            router.leaveScreen(false);
        }
    }

    public static final void access$handleError(PhoneProvingPresenterImpl phoneProvingPresenterImpl, Throwable th) {
        TypedError handle = phoneProvingPresenterImpl.m.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            CompositeDisposable compositeDisposable = phoneProvingPresenterImpl.d;
            Disposable subscribe = phoneProvingPresenterImpl.l.showDialog(((ErrorResult.ErrorDialog) handle).getUserDialog()).subscribe(new a2.a.a.b.g.a(phoneProvingPresenterImpl, handle));
            Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…  }\n                    }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } else if (handle instanceof ErrorResult.IncorrectData) {
            phoneProvingPresenterImpl.f = ((ErrorResult.IncorrectData) handle).getMessages();
            phoneProvingPresenterImpl.a();
        } else {
            PhoneProvingView phoneProvingView = phoneProvingPresenterImpl.a;
            if (phoneProvingView != null) {
                phoneProvingView.showError(phoneProvingPresenterImpl.m.recycle(handle));
            }
        }
    }

    public static final void access$handlePhoneProvingCompleted(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
        PhoneProvingPresenter.Router router = phoneProvingPresenterImpl.b;
        if (router != null) {
            router.leaveScreen(true);
        }
    }

    public static final void access$handleResetPasswordStarted(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
        Objects.requireNonNull(phoneProvingPresenterImpl);
        phoneProvingPresenterImpl.f = r.emptyMap();
        phoneProvingPresenterImpl.a();
        PhoneProvingView phoneProvingView = phoneProvingPresenterImpl.a;
        if (phoneProvingView != null) {
            phoneProvingView.hideKeyboard();
            phoneProvingView.showProgress();
        }
    }

    public static final void access$onProvePhone(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
        String str = phoneProvingPresenterImpl.h + phoneProvingPresenterImpl.e;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (true ^ t6.y.a.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        CompositeDisposable compositeDisposable = phoneProvingPresenterImpl.c;
        Disposable subscribe = phoneProvingPresenterImpl.k.provePhone(phoneProvingPresenterImpl.g, sb2).observeOn(phoneProvingPresenterImpl.n.mainThread()).doOnSubscribe(new a2.a.a.b.g.b(phoneProvingPresenterImpl)).doAfterTerminate(new r0(0, phoneProvingPresenterImpl)).subscribe(new r0(1, phoneProvingPresenterImpl), new c(phoneProvingPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.provePhone(ch…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void a() {
        PhoneProvingView phoneProvingView;
        PhoneProvingView phoneProvingView2 = this.a;
        if (phoneProvingView2 != null) {
            phoneProvingView2.hidePhoneError();
        }
        for (Map.Entry<String, String> entry : this.f.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.hashCode() == 1085338122 && key.equals("passphrase") && (phoneProvingView = this.a) != null) {
                phoneProvingView.showPhoneError(value);
            }
        }
        PhoneProvingView phoneProvingView3 = this.a;
        if (phoneProvingView3 != null) {
            phoneProvingView3.requestFieldFocus();
        }
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter
    public void attachRouter(@NotNull PhoneProvingPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter
    public void attachView(@NotNull PhoneProvingView phoneProvingView) {
        Intrinsics.checkNotNullParameter(phoneProvingView, "view");
        this.a = phoneProvingView;
        if (phoneProvingView != null) {
            phoneProvingView.setPhoneStarting(this.h);
        }
        PhoneProvingView phoneProvingView2 = this.a;
        if (phoneProvingView2 != null) {
            phoneProvingView2.setInputHint(this.i);
        }
        a();
        b();
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = phoneProvingView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…bscribe { closeScreen() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = phoneProvingView.proveClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.proveClicks().subscribe { onProvePhone() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = phoneProvingView.phoneEndingChanged().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.phoneEndingChanged(…veButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    public final void b() {
        PhoneProvingView phoneProvingView = this.a;
        if (phoneProvingView != null) {
            phoneProvingView.setProveButtonEnabled(this.e.length() == this.i.length());
        }
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("phone_ending", this.e).putStringMap("errors", this.f);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingPresenter
    public void trackOnScreenClosed() {
        if (this.j) {
            this.o.track(new AntihackReturnOnPhoneListEvent(AntihackEventSource.ANTIHACK));
        }
    }
}
