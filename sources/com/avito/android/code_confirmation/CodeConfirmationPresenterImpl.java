package com.avito.android.code_confirmation;

import a2.a.a.e0.i;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationPresenter;
import com.avito.android.code_confirmation.RequestCodeInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ResetPasswordLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001hBg\b\u0007\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u00102\u001a\u00020/\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010S\u001a\u00020P\u0012\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00120_\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010-\u001a\u00020*\u0012\b\u0010e\u001a\u0004\u0018\u00010#¢\u0006\u0004\bf\u0010gJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J#\u0010\f\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J/\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010;R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00120_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010;R\u0016\u0010d\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u00104¨\u0006i"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationPresenterImpl;", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter;", "Lcom/avito/android/code_confirmation/CodeConfirmationView;", "", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/code_confirmation/CodeConfirmationView;)V", AuthSource.SEND_ABUSE, "()V", "d", "", "", "messages", "c", "(Ljava/util/Map;)V", "view", "attachView", "login", "text", "", "codeTimeout", "", "codeLength", "initData", "(Ljava/lang/String;Ljava/lang/String;JI)V", "challengeId", "enablePhoneAntihack", "(Ljava/lang/String;)V", "phone", "enableTfaMode", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/code_confirmation/CodeConfirmationPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenterImpl$Mode;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/code_confirmation/CodeConfirmationPresenterImpl$Mode;", "mode", "Lcom/avito/android/code_confirmation/CodeReceiver;", VKApiConst.VERSION, "Lcom/avito/android/code_confirmation/CodeReceiver;", "codeReceiver", "Lcom/avito/android/code_confirmation/CodeConfirmationPresenter$Router;", "Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "o", "Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "phoneAntihackInteractor", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "u", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "rxTimer", "f", "Ljava/lang/String;", "Ldagger/Lazy;", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "p", "Ldagger/Lazy;", "tfaInteractor", "k", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "n", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "Lcom/avito/android/code_confirmation/CodeConfirmationView;", "", "e", "Z", "autoSend", "Lcom/avito/android/util/ErrorFormatter;", "r", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "l", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "s", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "resourceProvider", "i", "Ljava/lang/Long;", "nextRequestTime", "Lcom/avito/android/util/SchedulersFactory;", VKApiConst.Q, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "h", "I", "j", "Ljava/util/Map;", "Lcom/avito/android/util/Formatter;", "t", "Lcom/avito/android/util/Formatter;", "timerFormatter", a2.g.r.g.a, "disposables", "state", "<init>", "(Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/code_confirmation/timer/RxTimer;Lcom/avito/android/code_confirmation/CodeReceiver;Lcom/avito/android/util/Kundle;)V", "Mode", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeConfirmationPresenterImpl implements CodeConfirmationPresenter {
    public CodeConfirmationView a;
    public CodeConfirmationPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public boolean e;
    public String f;
    public String g;
    public int h;
    public Long i;
    public Map<String, String> j;
    public String k;
    public String l;
    public Mode m;
    public final CodeConfirmationInteractor n;
    public final PhoneAntihackInteractor o;
    public final Lazy<TfaInteractor> p;
    public final SchedulersFactory q;
    public final ErrorFormatter r;
    public final CodeConfirmationResourceProvider s;
    public final Formatter<Long> t;
    public final RxTimer u;
    public final CodeReceiver v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationPresenterImpl$Mode;", "", "<init>", "(Ljava/lang/String;I)V", MessengerShareContentUtility.PREVIEW_DEFAULT, "PHONE_ANTIHACK", "TFA", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        DEFAULT,
        PHONE_ANTIHACK,
        TFA
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            Mode.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            Mode.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
            Mode.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[1] = 1;
            iArr3[2] = 2;
        }
    }

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
                ((CodeConfirmationPresenterImpl) this.b).d();
            } else if (i == 1) {
                CodeConfirmationPresenterImpl.access$requestCode((CodeConfirmationPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;

        public b(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
            this.a = codeConfirmationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            CodeConfirmationView codeConfirmationView = this.a.a;
            if (codeConfirmationView != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "code");
                codeConfirmationView.showCode(str2);
            }
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;
        public final /* synthetic */ CodeConfirmationView b;

        public c(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl, CodeConfirmationView codeConfirmationView) {
            this.a = codeConfirmationPresenterImpl;
            this.b = codeConfirmationView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideKeyboard();
            CodeConfirmationPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    public static final class d<T> implements Consumer<String> {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;

        public d(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
            this.a = codeConfirmationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            CodeConfirmationPresenterImpl.access$tryAutoSendCode(this.a);
            this.a.a();
        }
    }

    public static final class e<T> implements Consumer<Disposable> {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;

        public e(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
            this.a = codeConfirmationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            CodeConfirmationView codeConfirmationView = this.a.a;
            if (codeConfirmationView != null) {
                codeConfirmationView.showProgress();
            }
            CodeConfirmationView codeConfirmationView2 = this.a.a;
            if (codeConfirmationView2 != null) {
                codeConfirmationView2.hideKeyboard();
            }
            CodeConfirmationView codeConfirmationView3 = this.a.a;
            if (codeConfirmationView3 != null) {
                codeConfirmationView3.hideCodeError();
            }
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;

        public f(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
            this.a = codeConfirmationPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            CodeConfirmationView codeConfirmationView = this.a.a;
            if (codeConfirmationView != null) {
                codeConfirmationView.hideProgress();
            }
            this.a.e = false;
        }
    }

    public static final class g<T> implements Consumer<ConfirmedCodeInfo> {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;

        public g(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
            this.a = codeConfirmationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ConfirmedCodeInfo confirmedCodeInfo) {
            ConfirmedCodeInfo confirmedCodeInfo2 = confirmedCodeInfo;
            CodeConfirmationPresenter.Router router = this.a.b;
            if (router != null) {
                router.finishConfirmation(confirmedCodeInfo2.getLogin(), confirmedCodeInfo2.getHash(), confirmedCodeInfo2.isPhoneUsed());
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ CodeConfirmationPresenterImpl a;

        public h(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
            this.a = codeConfirmationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            CodeConfirmationPresenterImpl codeConfirmationPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            CodeConfirmationPresenterImpl.access$handleError(codeConfirmationPresenterImpl, th2);
        }
    }

    @Inject
    public CodeConfirmationPresenterImpl(@NotNull CodeConfirmationInteractor codeConfirmationInteractor, @NotNull PhoneAntihackInteractor phoneAntihackInteractor, @NotNull Lazy<TfaInteractor> lazy, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider, @NotNull Formatter<Long> formatter, @NotNull RxTimer rxTimer, @NotNull CodeReceiver codeReceiver, @Nullable Kundle kundle) {
        String str;
        Map<String, String> emptyMap;
        Mode mode;
        String string;
        Integer num;
        String string2;
        Boolean bool;
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        Intrinsics.checkNotNullParameter(phoneAntihackInteractor, "phoneAntihackInteractor");
        Intrinsics.checkNotNullParameter(lazy, "tfaInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(formatter, "timerFormatter");
        Intrinsics.checkNotNullParameter(rxTimer, "rxTimer");
        Intrinsics.checkNotNullParameter(codeReceiver, "codeReceiver");
        this.n = codeConfirmationInteractor;
        this.o = phoneAntihackInteractor;
        this.p = lazy;
        this.q = schedulersFactory;
        this.r = errorFormatter;
        this.s = codeConfirmationResourceProvider;
        this.t = formatter;
        this.u = rxTimer;
        this.v = codeReceiver;
        this.e = (kundle == null || (bool = kundle.getBoolean("autoSend")) == null) ? true : bool.booleanValue();
        String str2 = "";
        this.f = (kundle == null || (str = kundle.getString("login")) == null) ? str2 : str;
        if (!(kundle == null || (string2 = kundle.getString("text")) == null)) {
            str2 = string2;
        }
        this.g = str2;
        this.h = (kundle == null || (num = kundle.getInt("length")) == null) ? 0 : num.intValue();
        String str3 = null;
        this.i = kundle != null ? kundle.getLong("nextRequestDate") : null;
        this.j = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
        this.k = kundle != null ? kundle.getString("challengeId") : null;
        this.l = kundle != null ? kundle.getString("phone") : str3;
        this.m = (kundle == null || (string = kundle.getString("mode")) == null || (mode = Mode.valueOf(string)) == null) ? Mode.DEFAULT : mode;
    }

    public static final void access$handleError(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl, Throwable th) {
        com.avito.android.remote.model.Action action;
        CodeConfirmationView codeConfirmationView;
        Objects.requireNonNull(codeConfirmationPresenterImpl);
        codeConfirmationPresenterImpl.j = r.emptyMap();
        if (th instanceof TypedResultException) {
            TypedResultException typedResultException = (TypedResultException) th;
            TypedError errorResult = typedResultException.getErrorResult();
            if (errorResult instanceof TypedError.ErrorMap) {
                codeConfirmationPresenterImpl.c(((TypedError.ErrorMap) errorResult).getMessages());
            } else if (errorResult instanceof ErrorWithMessage.ErrorDialog) {
                UserDialog data = ((ErrorWithMessage.ErrorDialog) errorResult).getData();
                List<com.avito.android.remote.model.Action> actions = data.getActions();
                if (actions != null && (action = (com.avito.android.remote.model.Action) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) actions)) != null && (codeConfirmationView = codeConfirmationPresenterImpl.a) != null) {
                    codeConfirmationView.showUserDialog(data.getTitle(), data.getMessage(), action.getTitle(), new a2.a.a.e0.e(codeConfirmationPresenterImpl, action), new a2.a.a.e0.f(codeConfirmationPresenterImpl));
                }
            } else {
                CodeConfirmationView codeConfirmationView2 = codeConfirmationPresenterImpl.a;
                if (codeConfirmationView2 != null) {
                    codeConfirmationView2.showError(codeConfirmationPresenterImpl.r.format(typedResultException));
                }
            }
        } else if (th instanceof CodeAlreadyConfirmedException) {
            CodeConfirmationPresenter.Router router = codeConfirmationPresenterImpl.b;
            if (router != null) {
                CodeAlreadyConfirmedException codeAlreadyConfirmedException = (CodeAlreadyConfirmedException) th;
                router.finishConfirmation(codeAlreadyConfirmedException.getInfo().getLogin(), codeAlreadyConfirmedException.getInfo().getHash(), codeAlreadyConfirmedException.getInfo().isPhoneUsed());
            }
        } else {
            CodeConfirmationView codeConfirmationView3 = codeConfirmationPresenterImpl.a;
            if (codeConfirmationView3 != null) {
                codeConfirmationView3.showError(codeConfirmationPresenterImpl.r.format(th));
            }
        }
    }

    public static final DeepLink access$mixResetPasswordSrc(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl, DeepLink deepLink, String str) {
        Objects.requireNonNull(codeConfirmationPresenterImpl);
        return deepLink instanceof ResetPasswordLink ? new ResetPasswordLink(((ResetPasswordLink) deepLink).getLogin(), false, str, 2, null) : deepLink;
    }

    public static final void access$requestCode(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        Observable<CodeInfo> observable;
        int ordinal = codeConfirmationPresenterImpl.m.ordinal();
        if (ordinal == 0) {
            observable = RequestCodeInteractor.DefaultImpls.requestCode$default(codeConfirmationPresenterImpl.n, codeConfirmationPresenterImpl.f, null, 2, null);
        } else if (ordinal == 1) {
            observable = codeConfirmationPresenterImpl.o.requestCode(codeConfirmationPresenterImpl.f);
        } else if (ordinal == 2) {
            String str = codeConfirmationPresenterImpl.l;
            if (str == null || (observable = RequestCodeInteractor.DefaultImpls.requestCode$default(codeConfirmationPresenterImpl.p.get(), str, null, 2, null)) == null) {
                throw new IllegalStateException("Phone must be not null in Tfa mode");
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        CompositeDisposable compositeDisposable = codeConfirmationPresenterImpl.c;
        Disposable subscribe = observable.observeOn(codeConfirmationPresenterImpl.q.mainThread()).doOnSubscribe(new a2.a.a.e0.a(codeConfirmationPresenterImpl)).doAfterTerminate(new a2.a.a.e0.b(codeConfirmationPresenterImpl)).subscribe(new a2.a.a.e0.c(codeConfirmationPresenterImpl), new a2.a.a.e0.d(codeConfirmationPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "requestCode\n            …          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$tryAutoSendCode(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        if (codeConfirmationPresenterImpl.e) {
            codeConfirmationPresenterImpl.d();
        }
    }

    public final void a() {
        String code;
        CodeConfirmationView codeConfirmationView = this.a;
        if (codeConfirmationView != null) {
            boolean z = false;
            if (((codeConfirmationView == null || (code = codeConfirmationView.getCode()) == null) ? 0 : code.length()) >= this.h) {
                z = true;
            }
            codeConfirmationView.setSendButtonEnabled(z);
        }
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void attachRouter(@NotNull CodeConfirmationPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.v.connect().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "codeReceiver.connect().s…-> view?.showCode(code) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.b = router;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void attachView(@NotNull CodeConfirmationView codeConfirmationView) {
        Intrinsics.checkNotNullParameter(codeConfirmationView, "view");
        this.a = codeConfirmationView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = codeConfirmationView.sendClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.sendClicks().subscribe { trySendCode() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = codeConfirmationView.requestClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.requestClicks().subscribe { requestCode() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = codeConfirmationView.navigationClicks().subscribe(new c(this, codeConfirmationView));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.navigationClicks().…?.leaveScreen()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = codeConfirmationView.codeChanged().subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.codeChanged().subsc…ndApplyButton()\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        b(codeConfirmationView);
    }

    public final void b(CodeConfirmationView codeConfirmationView) {
        if (this.e) {
            d();
        }
        a();
        codeConfirmationView.showText(this.g, this.f);
        codeConfirmationView.setCodeLength(this.h);
        Long l2 = this.i;
        if (l2 != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = this.u.start(l2.longValue()).observeOn(this.q.mainThread()).subscribe(new a2.a.a.e0.g(this), new a2.a.a.e0.h(this), new i(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "rxTimer.start(nextReques…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } else {
            CodeConfirmationView codeConfirmationView2 = this.a;
            if (codeConfirmationView2 != null) {
                codeConfirmationView2.showRequestButton();
            }
        }
        c(this.j);
    }

    public final void c(Map<String, String> map) {
        CodeConfirmationView codeConfirmationView;
        this.j = map;
        String str = (String) CollectionsKt___CollectionsKt.firstOrNull(map.values());
        if (str != null && (codeConfirmationView = this.a) != null) {
            codeConfirmationView.showCodeError(str);
        }
    }

    public final void d() {
        String code;
        Observable<ConfirmedCodeInfo> observable;
        CodeConfirmationView codeConfirmationView = this.a;
        if (codeConfirmationView != null && (code = codeConfirmationView.getCode()) != null) {
            if (!(code.length() >= this.h)) {
                code = null;
            }
            if (code != null) {
                int ordinal = this.m.ordinal();
                if (ordinal == 0) {
                    observable = CodeConfirmationInteractor.DefaultImpls.sendCode$default(this.n, this.f, code, null, 4, null);
                } else if (ordinal == 1) {
                    String str = this.k;
                    if (str == null || (observable = this.o.sendCode(this.f, code, str)) == null) {
                        throw new IllegalStateException("challengeId must be not null in PHONE_ANTIHACK mode");
                    }
                } else if (ordinal == 2) {
                    String str2 = this.l;
                    if (str2 == null || (observable = this.p.get().sendCode(str2, code, "")) == null) {
                        throw new IllegalStateException("Phone must be not null in TFA mode");
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                CompositeDisposable compositeDisposable = this.c;
                Disposable subscribe = observable.observeOn(this.q.mainThread()).doOnSubscribe(new e(this)).doAfterTerminate(new f(this)).subscribe(new g(this), new h(this));
                Intrinsics.checkNotNullExpressionValue(subscribe, "sendCode\n            .ob…          }\n            )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void enablePhoneAntihack(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "challengeId");
        this.m = Mode.PHONE_ANTIHACK;
        this.k = str;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void enableTfaMode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.m = Mode.TFA;
        this.l = str;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    public void initData(@NotNull String str, @NotNull String str2, long j2, int i2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.f = str;
        this.g = str2;
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        this.i = Long.valueOf(TimeUnit.SECONDS.toMillis(j2) + instance.getTimeInMillis());
        this.h = i2;
        CodeConfirmationView codeConfirmationView = this.a;
        if (codeConfirmationView != null) {
            b(codeConfirmationView);
        }
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("autoSend", Boolean.valueOf(this.e)).putLong("nextRequestDate", this.i).putString("login", this.f).putString("text", this.g).putInt("length", Integer.valueOf(this.h)).putStringMap("messages", this.j).putString("challengeId", this.k).putString("phone", this.l).putString("mode", this.m.name());
    }
}
