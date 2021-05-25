package com.avito.android.code_confirmation.tfa;

import com.avito.android.account.AccountInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.TfaCodeResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/code_confirmation/tfa/TfaInteractorImpl;", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "", "id", "src", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "login", "code", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountInteractor;", "e", "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "c", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorThrowableConverter", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/account/AccountInteractor;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class TfaInteractorImpl implements TfaInteractor {
    public final ProfileApi a;
    public final SchedulersFactory3 b;
    public final CodeConfirmationResourceProvider c;
    public final TypedErrorThrowableConverter d;
    public final AccountInteractor e;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends TypedResult<TfaCodeResult>>> {
        public final /* synthetic */ TfaInteractorImpl a;

        public a(TfaInteractorImpl tfaInteractorImpl) {
            this.a = tfaInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<TfaCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Observables.toObservable(new TypedResultException(this.a.d.convert(th2)));
        }
    }

    public static final class b<T, R> implements Function<TfaCodeResult, CodeInfo> {
        public final /* synthetic */ TfaInteractorImpl a;
        public final /* synthetic */ String b;

        public b(TfaInteractorImpl tfaInteractorImpl, String str) {
            this.a = tfaInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CodeInfo apply(TfaCodeResult tfaCodeResult) {
            TfaCodeResult tfaCodeResult2 = tfaCodeResult;
            Intrinsics.checkNotNullParameter(tfaCodeResult2, "it");
            return new CodeInfo(this.a.c.codeSent(TfaInteractorImpl.access$formatPhoneNumber(this.a, this.b)), tfaCodeResult2.getTimer(), 5);
        }
    }

    public static final class c<T, R> implements Function<Throwable, ObservableSource<? extends LoadingState<? super LoginResult>>> {
        public final /* synthetic */ TfaInteractorImpl a;

        public c(TfaInteractorImpl tfaInteractorImpl) {
            this.a = tfaInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends LoadingState<? super LoginResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Observables.toObservable(new TypedResultException(this.a.d.convert(th2)));
        }
    }

    public static final class d<T, R> implements Function<LoginResult, ObservableSource<? extends ConfirmedCodeInfo>> {
        public final /* synthetic */ TfaInteractorImpl a;
        public final /* synthetic */ String b;

        public d(TfaInteractorImpl tfaInteractorImpl, String str) {
            this.a = tfaInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConfirmedCodeInfo> apply(LoginResult loginResult) {
            LoginResult loginResult2 = loginResult;
            Intrinsics.checkNotNullParameter(loginResult2, "it");
            if (loginResult2 instanceof LoginResult.Ok) {
                Observable just = Observable.just(new ConfirmedCodeInfo(TfaInteractorImpl.access$formatPhoneNumber(this.a, this.b), "", false));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (loginResult2 instanceof LoginResult.FailedWithDialog) {
                return TfaInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.ErrorDialog(((LoginResult.FailedWithDialog) loginResult2).getUserDialog()));
            } else {
                return TfaInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(""));
            }
        }
    }

    @Inject
    public TfaInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull AccountInteractor accountInteractor) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorThrowableConverter");
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        this.a = profileApi;
        this.b = schedulersFactory3;
        this.c = codeConfirmationResourceProvider;
        this.d = typedErrorThrowableConverter;
        this.e = accountInteractor;
    }

    public static final String access$formatPhoneNumber(TfaInteractorImpl tfaInteractorImpl, String str) {
        Objects.requireNonNull(tfaInteractorImpl);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb2.append(charAt);
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "filterTo(StringBuilder(), predicate).toString()");
        int i2 = 0;
        for (int i3 = 0; i3 < "+# ### ###-##-##".length(); i3++) {
            char charAt2 = "+# ### ###-##-##".charAt(i3);
            if (charAt2 != '#') {
                sb.append(charAt2);
                Intrinsics.checkNotNullExpressionValue(sb, "result.append(maskSymbol)");
            } else if (i2 < sb3.length()) {
                sb.append(sb3.charAt(i2));
                i2++;
            }
        }
        String sb4 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "result.toString()");
        return sb4;
    }

    public static final Observable access$toErrorObservable(TfaInteractorImpl tfaInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(tfaInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        io.reactivex.rxjava3.core.Observable<TypedResult<TfaCodeResult>> subscribeOn = this.a.requestTfaCode(str).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.requestTfaCode(id)\n …scribeOn(schedulers.io())");
        Observable onErrorResumeNext = InteropKt.toV2(subscribeOn).onErrorResumeNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.requestTfaCode(id)\n …bservable()\n            }");
        Observable<CodeInfo> map = TypedObservablesKt.toTyped(onErrorResumeNext).map(new b(this, str));
        Intrinsics.checkNotNullExpressionValue(map, "api.requestTfaCode(id)\n …          )\n            }");
        return map;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        Observable onErrorResumeNext = InteropKt.toV2(this.e.login(str2, str)).onErrorResumeNext(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "accountInteractor.login(…bservable()\n            }");
        Observable observable = onErrorResumeNext.flatMap(TfaInteractorImpl$sendCode$$inlined$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "flatMap { state ->\n     …tOrError().toObservable()");
        Observable<ConfirmedCodeInfo> flatMap = observable.flatMap(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "accountInteractor.login(…          }\n            }");
        return flatMap;
    }
}
