package com.avito.android.code_confirmation;

import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.registration.ConfirmCodeResult;
import com.avito.android.remote.model.registration.RequestCodeResult;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationInteractorImpl;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "", "login", "code", "src", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "d", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorThrowableConverter", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "f", "Ljava/lang/String;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "c", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "resourceProvider", "", "e", "Z", "retry", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;ZLjava/lang/String;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeConfirmationInteractorImpl implements CodeConfirmationInteractor {
    public final ProfileApi a;
    public final SchedulersFactory b;
    public final CodeConfirmationResourceProvider c;
    public final TypedErrorThrowableConverter d;
    public final boolean e;
    public final String f;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends TypedResult<RequestCodeResult>>> {
        public final /* synthetic */ CodeConfirmationInteractorImpl a;

        public a(CodeConfirmationInteractorImpl codeConfirmationInteractorImpl) {
            this.a = codeConfirmationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<RequestCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Observables.toObservable(new TypedResultException(this.a.d.convert(th2)));
        }
    }

    public static final class b<T, R> implements Function<RequestCodeResult, ObservableSource<? extends CodeInfo>> {
        public final /* synthetic */ CodeConfirmationInteractorImpl a;
        public final /* synthetic */ String b;

        public b(CodeConfirmationInteractorImpl codeConfirmationInteractorImpl, String str) {
            this.a = codeConfirmationInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends CodeInfo> apply(RequestCodeResult requestCodeResult) {
            RequestCodeResult requestCodeResult2 = requestCodeResult;
            Intrinsics.checkNotNullParameter(requestCodeResult2, "result");
            if (requestCodeResult2 instanceof RequestCodeResult.Ok) {
                RequestCodeResult.Ok ok = (RequestCodeResult.Ok) requestCodeResult2;
                Observable just = Observable.just(new CodeInfo(this.a.c.codeSent(this.b), ok.getNextTryTime() - ok.getLastTryTime(), 5));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (requestCodeResult2 instanceof RequestCodeResult.Failure) {
                return CodeConfirmationInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((RequestCodeResult.Failure) requestCodeResult2).getMessage()));
            } else {
                if (requestCodeResult2 instanceof RequestCodeResult.IncorrectData) {
                    return CodeConfirmationInteractorImpl.access$toErrorObservable(this.a, new TypedError.ErrorMap(((RequestCodeResult.IncorrectData) requestCodeResult2).getMessages()));
                }
                if (requestCodeResult2 instanceof RequestCodeResult.Confirmed) {
                    RequestCodeResult.Confirmed confirmed = (RequestCodeResult.Confirmed) requestCodeResult2;
                    return Observables.toObservable(new CodeAlreadyConfirmedException(new ConfirmedCodeInfo(this.b, confirmed.getHash(), confirmed.isPhoneUsed())));
                } else if (requestCodeResult2 instanceof RequestCodeResult.VerifyByCall) {
                    return Observable.empty();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    public static final class c<T, R> implements Function<Throwable, ObservableSource<? extends TypedResult<ConfirmCodeResult>>> {
        public final /* synthetic */ CodeConfirmationInteractorImpl a;

        public c(CodeConfirmationInteractorImpl codeConfirmationInteractorImpl) {
            this.a = codeConfirmationInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<ConfirmCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Observables.toObservable(new TypedResultException(this.a.d.convert(th2)));
        }
    }

    public static final class d<T, R> implements Function<ConfirmCodeResult, ObservableSource<? extends ConfirmedCodeInfo>> {
        public final /* synthetic */ CodeConfirmationInteractorImpl a;
        public final /* synthetic */ String b;

        public d(CodeConfirmationInteractorImpl codeConfirmationInteractorImpl, String str) {
            this.a = codeConfirmationInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConfirmedCodeInfo> apply(ConfirmCodeResult confirmCodeResult) {
            ConfirmCodeResult confirmCodeResult2 = confirmCodeResult;
            Intrinsics.checkNotNullParameter(confirmCodeResult2, "result");
            if (confirmCodeResult2 instanceof ConfirmCodeResult.Ok) {
                ConfirmCodeResult.Ok ok = (ConfirmCodeResult.Ok) confirmCodeResult2;
                Observable just = Observable.just(new ConfirmedCodeInfo(this.b, ok.getHash(), ok.isPhoneUsed()));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (confirmCodeResult2 instanceof ConfirmCodeResult.Failure) {
                return CodeConfirmationInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((ConfirmCodeResult.Failure) confirmCodeResult2).getMessage()));
            } else {
                if (confirmCodeResult2 instanceof ConfirmCodeResult.IncorrectData) {
                    return CodeConfirmationInteractorImpl.access$toErrorObservable(this.a, new TypedError.ErrorMap(((ConfirmCodeResult.IncorrectData) confirmCodeResult2).getMessages()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public CodeConfirmationInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorThrowableConverter");
        Intrinsics.checkNotNullParameter(str, "src");
        this.a = profileApi;
        this.b = schedulersFactory;
        this.c = codeConfirmationResourceProvider;
        this.d = typedErrorThrowableConverter;
        this.e = z;
        this.f = str;
    }

    public static final Observable access$toErrorObservable(CodeConfirmationInteractorImpl codeConfirmationInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(codeConfirmationInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        ProfileApi profileApi = this.a;
        boolean z = this.e;
        if (str2 == null) {
            str2 = this.f;
        }
        Observable onErrorResumeNext = InteropKt.toV2(profileApi.requestCode(str, z, str2)).subscribeOn(this.b.io()).onErrorResumeNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.requestCode(login, r…bservable()\n            }");
        Observable<CodeInfo> flatMap = TypedObservablesKt.toTyped(onErrorResumeNext).flatMap(new b(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.requestCode(login, r…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        ProfileApi profileApi = this.a;
        if (str3 == null) {
            str3 = this.f;
        }
        Observable onErrorResumeNext = InteropKt.toV2(profileApi.confirmCode(str, str2, str3)).subscribeOn(this.b.io()).onErrorResumeNext(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.confirmCode(login, c…bservable()\n            }");
        Observable<ConfirmedCodeInfo> flatMap = TypedObservablesKt.toTyped(onErrorResumeNext).flatMap(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.confirmCode(login, c…          }\n            }");
        return flatMap;
    }
}
