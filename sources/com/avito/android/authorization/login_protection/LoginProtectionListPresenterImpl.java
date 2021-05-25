package com.avito.android.authorization.login_protection;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter;
import com.avito.android.authorization.login_protection.action.PhoneListAction;
import com.avito.android.authorization.login_protection.di.ChallengeId;
import com.avito.android.authorization.login_protection.di.IsPhoneListForAntihackMode;
import com.avito.android.authorization.login_protection.di.LoginForTfa;
import com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001JB{\b\u0007\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0010%\u001a\u00020\"\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100B\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0010\u0012\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010A\u001a\u00020>\u0012\b\b\u0001\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001cR\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006K"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionListPresenterImpl;", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;", "view", "", "attachView", "(Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;)V", "onPhoneProved", "()V", "onTfaSuccess", "detachView", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;)V", "detachRouter", "", "searchText", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "Lcom/avito/android/authorization/login_protection/LoginProtectionListPresenterImpl$Mode;", "d", "Lcom/avito/android/authorization/login_protection/LoginProtectionListPresenterImpl$Mode;", "mode", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;", "h", "Ljava/lang/String;", "challengeId", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/authorization/login_protection/action/PhoneListAction;", "k", "Lio/reactivex/rxjava3/core/Observable;", "itemActions", "Ldagger/Lazy;", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "e", "Ldagger/Lazy;", "tfaInteractor", "i", "login", "Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;", "l", "Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;", "formatter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/analytics/Analytics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/ErrorFormatter;", "n", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "", g.a, "Ljava/util/List;", "phones", "", "isAntihackMode", "<init>", "(Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory3;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/authorization/login_protection/formatter/LoginProtectionPhoneFormatter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/ErrorFormatter;Z)V", "Mode", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginProtectionListPresenterImpl implements LoginProtectionPhoneListPresenter {
    public LoginProtectionPhoneListView a;
    public LoginProtectionPhoneListPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final Mode d;
    public final Lazy<TfaInteractor> e;
    public final SchedulersFactory3 f;
    public final List<String> g;
    public final String h;
    public final String i;
    public final AdapterPresenter j;
    public final Observable<PhoneListAction> k;
    public final LoginProtectionPhoneFormatter l;
    public final Analytics m;
    public final ErrorFormatter n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionListPresenterImpl$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "ANTIHACK", "TFA", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        ANTIHACK,
        TFA
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            Mode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            Mode.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            Mode.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[1] = 2;
        }
    }

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ LoginProtectionListPresenterImpl a;

        public a(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl) {
            this.a = loginProtectionListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            LoginProtectionListPresenterImpl loginProtectionListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "searchText");
            loginProtectionListPresenterImpl.a(str2);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ LoginProtectionListPresenterImpl a;

        public b(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl) {
            this.a = loginProtectionListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            LoginProtectionPhoneListPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen(false, this.a.d == Mode.ANTIHACK);
            }
        }
    }

    public static final class c<T> implements Consumer<PhoneListAction> {
        public final /* synthetic */ LoginProtectionListPresenterImpl a;

        public c(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl) {
            this.a = loginProtectionListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(PhoneListAction phoneListAction) {
            PhoneListAction phoneListAction2 = phoneListAction;
            LoginProtectionListPresenterImpl loginProtectionListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(phoneListAction2, "action");
            LoginProtectionListPresenterImpl.access$handleItemAction(loginProtectionListPresenterImpl, phoneListAction2);
        }
    }

    @Inject
    public LoginProtectionListPresenterImpl(@NotNull Lazy<TfaInteractor> lazy, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull List<String> list, @ChallengeId @NotNull String str, @LoginForTfa @Nullable String str2, @NotNull AdapterPresenter adapterPresenter, @NotNull Observable<PhoneListAction> observable, @NotNull LoginProtectionPhoneFormatter loginProtectionPhoneFormatter, @NotNull Analytics analytics, @NotNull ErrorFormatter errorFormatter, @IsPhoneListForAntihackMode boolean z) {
        Mode mode;
        Intrinsics.checkNotNullParameter(lazy, "tfaInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(list, "phones");
        Intrinsics.checkNotNullParameter(str, "challengeId");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(observable, "itemActions");
        Intrinsics.checkNotNullParameter(loginProtectionPhoneFormatter, "formatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.e = lazy;
        this.f = schedulersFactory3;
        this.g = list;
        this.h = str;
        this.i = str2;
        this.j = adapterPresenter;
        this.k = observable;
        this.l = loginProtectionPhoneFormatter;
        this.m = analytics;
        this.n = errorFormatter;
        if (z) {
            mode = Mode.ANTIHACK;
        } else {
            mode = Mode.TFA;
        }
        this.d = mode;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$handleItemAction(com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl r5, com.avito.android.authorization.login_protection.action.PhoneListAction r6) {
        /*
            com.avito.android.authorization.login_protection.LoginProtectionPhoneListView r0 = r5.a
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getSearchText()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x001c
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            boolean r4 = r6 instanceof com.avito.android.authorization.login_protection.action.PhoneListAction.PhoneClickAction
            if (r4 == 0) goto L_0x0099
            com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl$Mode r4 = r5.d
            int r4 = r4.ordinal()
            if (r4 == 0) goto L_0x0079
            if (r4 == r2) goto L_0x002d
            goto L_0x00b0
        L_0x002d:
            com.avito.android.authorization.login_protection.action.PhoneListAction$PhoneClickAction r6 = (com.avito.android.authorization.login_protection.action.PhoneListAction.PhoneClickAction) r6
            java.lang.String r6 = r6.getPhone()
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r5.c
            dagger.Lazy<com.avito.android.code_confirmation.tfa.TfaInteractor> r2 = r5.e
            java.lang.Object r2 = r2.get()
            com.avito.android.code_confirmation.RequestCodeInteractor r2 = (com.avito.android.code_confirmation.RequestCodeInteractor) r2
            r3 = 2
            io.reactivex.Observable r1 = com.avito.android.code_confirmation.RequestCodeInteractor.DefaultImpls.requestCode$default(r2, r6, r1, r3, r1)
            io.reactivex.rxjava3.core.Observable r1 = com.avito.android.util.rx3.InteropKt.toV3(r1)
            com.avito.android.util.SchedulersFactory3 r2 = r5.f
            io.reactivex.rxjava3.core.Scheduler r2 = r2.mainThread()
            io.reactivex.rxjava3.core.Observable r1 = r1.observeOn(r2)
            a2.a.a.b.e.a r2 = new a2.a.a.b.e.a
            r2.<init>(r5)
            io.reactivex.rxjava3.core.Observable r1 = r1.doOnSubscribe(r2)
            a2.a.a.b.e.b r2 = new a2.a.a.b.e.b
            r2.<init>(r5)
            io.reactivex.rxjava3.core.Observable r1 = r1.doAfterTerminate(r2)
            a2.a.a.b.e.c r2 = new a2.a.a.b.e.c
            r2.<init>(r5, r6)
            a2.a.a.b.e.d r6 = new a2.a.a.b.e.d
            r6.<init>(r5)
            io.reactivex.rxjava3.disposables.Disposable r5 = r1.subscribe(r2, r6)
            java.lang.String r6 = "tfaInteractor.get().requ…rmat(it)) }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.avito.android.util.rx3.Disposables.plusAssign(r0, r5)
            goto L_0x00b0
        L_0x0079:
            com.avito.android.analytics.Analytics r1 = r5.m
            com.avito.android.authorization.event.AntihackPhoneSelectedEvent r2 = new com.avito.android.authorization.event.AntihackPhoneSelectedEvent
            r2.<init>(r0, r3)
            r1.track(r2)
            com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter$Router r0 = r5.b
            if (r0 == 0) goto L_0x00b0
            java.lang.String r1 = r5.h
            com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter r5 = r5.l
            com.avito.android.authorization.login_protection.action.PhoneListAction$PhoneClickAction r6 = (com.avito.android.authorization.login_protection.action.PhoneListAction.PhoneClickAction) r6
            java.lang.String r6 = r6.getPhone()
            java.lang.String r5 = r5.trimPhone(r6)
            r0.openPhoneProving(r1, r5)
            goto L_0x00b0
        L_0x0099:
            boolean r6 = r6 instanceof com.avito.android.authorization.login_protection.action.PhoneListAction.AnotherPhoneClickAction
            if (r6 == 0) goto L_0x00b0
            com.avito.android.analytics.Analytics r6 = r5.m
            com.avito.android.authorization.event.AntihackPhoneSelectedEvent r1 = new com.avito.android.authorization.event.AntihackPhoneSelectedEvent
            r1.<init>(r0, r2)
            r6.track(r1)
            com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter$Router r5 = r5.b
            if (r5 == 0) goto L_0x00b0
            java.lang.String r6 = "request/122"
            r5.openHelpCenter(r6)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl.access$handleItemAction(com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl, com.avito.android.authorization.login_protection.action.PhoneListAction):void");
    }

    public static final void access$handleTfaCodeRequested(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl, String str, CodeInfo codeInfo) {
        Unit unit;
        String str2 = loginProtectionListPresenterImpl.i;
        if (str2 != null) {
            LoginProtectionPhoneListPresenter.Router router = loginProtectionListPresenterImpl.b;
            if (router != null) {
                router.openTfaCodeConfirmation(str2, str, codeInfo.getText(), codeInfo.getTimeout(), codeInfo.getLength());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        throw new IllegalStateException("Login must be not null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == 0) goto L_0x0031
            java.util.List<java.lang.String> r0 = r8.g
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0033
            java.lang.Object r4 = r0.next()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            r6 = 2
            r7 = 0
            boolean r5 = kotlin.text.StringsKt__StringsKt.contains$default(r5, r9, r2, r6, r7)
            if (r5 == 0) goto L_0x0018
            r3.add(r4)
            goto L_0x0018
        L_0x0031:
            java.util.List<java.lang.String> r3 = r8.g
        L_0x0033:
            java.util.ArrayList r0 = new java.util.ArrayList
            r2 = 10
            int r2 = t6.n.e.collectionSizeOrDefault(r3, r2)
            r0.<init>(r2)
            java.util.Iterator r2 = r3.iterator()
        L_0x0042:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.avito.android.authorization.login_protection.formatter.LoginProtectionPhoneFormatter r4 = r8.l
            com.avito.android.authorization.login_protection.adapter.phone.PhoneItem r3 = r4.formatPhoneNumber(r3, r9)
            r0.add(r3)
            goto L_0x0042
        L_0x0058:
            com.avito.konveyor.adapter.AdapterPresenter r9 = r8.j
            com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl$Mode r2 = r8.d
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x007a
            if (r2 != r1) goto L_0x0074
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0083
            com.avito.android.authorization.login_protection.adapter.not_found.PhoneNotFoundItem r0 = new com.avito.android.authorization.login_protection.adapter.not_found.PhoneNotFoundItem
            r0.<init>()
            java.util.List r0 = t6.n.d.listOf(r0)
            goto L_0x0083
        L_0x0074:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x007a:
            com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItem r1 = new com.avito.android.authorization.login_protection.adapter.another.AnotherPhoneItem
            r1.<init>()
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r0, r1)
        L_0x0083:
            com.avito.konveyor.util.AdapterPresentersKt.updateItems(r9, r0)
            com.avito.android.authorization.login_protection.LoginProtectionPhoneListView r9 = r8.a
            if (r9 == 0) goto L_0x008d
            r9.onDataChanged()
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl.a(java.lang.String):void");
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter
    public void attachRouter(@NotNull LoginProtectionPhoneListPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter
    public void attachView(@NotNull LoginProtectionPhoneListView loginProtectionPhoneListView) {
        LoginProtectionPhoneListView loginProtectionPhoneListView2;
        Intrinsics.checkNotNullParameter(loginProtectionPhoneListView, "view");
        this.a = loginProtectionPhoneListView;
        int ordinal = this.d.ordinal();
        if (ordinal == 0) {
            LoginProtectionPhoneListView loginProtectionPhoneListView3 = this.a;
            if (loginProtectionPhoneListView3 != null) {
                loginProtectionPhoneListView3.showDescriptionForAntihack();
            }
        } else if (ordinal == 1 && (loginProtectionPhoneListView2 = this.a) != null) {
            loginProtectionPhoneListView2.showDescriptionForTfa();
        }
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = loginProtectionPhoneListView.getNavigationClicks().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks\n  …e.ANTIHACK)\n            }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        if (this.g.size() > 10) {
            loginProtectionPhoneListView.showSearchInput();
            Observable<String> searchTextChanges = loginProtectionPhoneListView.getSearchTextChanges();
            if (searchTextChanges != null) {
                CompositeDisposable compositeDisposable2 = this.c;
                Disposable subscribe2 = searchTextChanges.distinctUntilChanged().subscribe(new a(this));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "it.distinctUntilChanged(…searchPhone(searchText) }");
                Disposables.plusAssign(compositeDisposable2, subscribe2);
            }
        }
        this.k.subscribe(new c(this));
        String searchText = loginProtectionPhoneListView.getSearchText();
        if (searchText == null) {
            searchText = "";
        }
        a(searchText);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter
    public void detachView() {
        this.a = null;
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter
    public void onPhoneProved() {
        LoginProtectionPhoneListPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen(true, true);
        }
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter
    public void onTfaSuccess() {
        LoginProtectionPhoneListPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen(true, false);
        }
    }
}
