package com.avito.android.code_confirmation;

import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.RequestPhoneAntihackCodeResult;
import com.avito.android.remote.model.SendPhoneAntihackCodeResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/code_confirmation/PhoneAntihackInteractorImpl;", "Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "", "login", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;)Lio/reactivex/Observable;", "code", "challengeId", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorThrowableConverter", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "d", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneAntihackInteractorImpl implements PhoneAntihackInteractor {
    public final ProfileApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;
    public final CodeConfirmationResourceProvider d;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends TypedResult<RequestPhoneAntihackCodeResult>>> {
        public final /* synthetic */ PhoneAntihackInteractorImpl a;

        public a(PhoneAntihackInteractorImpl phoneAntihackInteractorImpl) {
            this.a = phoneAntihackInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<RequestPhoneAntihackCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Observables.toObservable(new TypedResultException(this.a.c.convert(th2)));
        }
    }

    public static final class b<T, R> implements Function<RequestPhoneAntihackCodeResult, ObservableSource<? extends CodeInfo>> {
        public final /* synthetic */ PhoneAntihackInteractorImpl a;
        public final /* synthetic */ String b;

        public b(PhoneAntihackInteractorImpl phoneAntihackInteractorImpl, String str) {
            this.a = phoneAntihackInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends CodeInfo> apply(RequestPhoneAntihackCodeResult requestPhoneAntihackCodeResult) {
            RequestPhoneAntihackCodeResult requestPhoneAntihackCodeResult2 = requestPhoneAntihackCodeResult;
            Intrinsics.checkNotNullParameter(requestPhoneAntihackCodeResult2, "result");
            if (requestPhoneAntihackCodeResult2 instanceof RequestPhoneAntihackCodeResult.Ok) {
                Observable just = Observable.just(new CodeInfo(this.a.d.codeSent(this.b), ((RequestPhoneAntihackCodeResult.Ok) requestPhoneAntihackCodeResult2).getTimeout(), 5));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (requestPhoneAntihackCodeResult2 instanceof RequestPhoneAntihackCodeResult.Failure) {
                return PhoneAntihackInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((RequestPhoneAntihackCodeResult.Failure) requestPhoneAntihackCodeResult2).getMessage()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class c<T, R> implements Function<Throwable, ObservableSource<? extends TypedResult<SendPhoneAntihackCodeResult>>> {
        public final /* synthetic */ PhoneAntihackInteractorImpl a;

        public c(PhoneAntihackInteractorImpl phoneAntihackInteractorImpl) {
            this.a = phoneAntihackInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends TypedResult<SendPhoneAntihackCodeResult>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return Observables.toObservable(new TypedResultException(this.a.c.convert(th2)));
        }
    }

    public static final class d<T, R> implements Function<SendPhoneAntihackCodeResult, ObservableSource<? extends ConfirmedCodeInfo>> {
        public final /* synthetic */ PhoneAntihackInteractorImpl a;
        public final /* synthetic */ String b;

        public d(PhoneAntihackInteractorImpl phoneAntihackInteractorImpl, String str) {
            this.a = phoneAntihackInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConfirmedCodeInfo> apply(SendPhoneAntihackCodeResult sendPhoneAntihackCodeResult) {
            SendPhoneAntihackCodeResult sendPhoneAntihackCodeResult2 = sendPhoneAntihackCodeResult;
            Intrinsics.checkNotNullParameter(sendPhoneAntihackCodeResult2, "result");
            if (sendPhoneAntihackCodeResult2 instanceof SendPhoneAntihackCodeResult.Ok) {
                Observable just = Observable.just(new ConfirmedCodeInfo(this.b, "", false));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (sendPhoneAntihackCodeResult2 instanceof SendPhoneAntihackCodeResult.Failure) {
                return PhoneAntihackInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((SendPhoneAntihackCodeResult.Failure) sendPhoneAntihackCodeResult2).getMessage()));
            } else {
                if (sendPhoneAntihackCodeResult2 instanceof SendPhoneAntihackCodeResult.IncorrectData) {
                    return PhoneAntihackInteractorImpl.access$toErrorObservable(this.a, new TypedError.ErrorMap(((SendPhoneAntihackCodeResult.IncorrectData) sendPhoneAntihackCodeResult2).getMessages()));
                }
                if (sendPhoneAntihackCodeResult2 instanceof SendPhoneAntihackCodeResult.FailedWithDialog) {
                    return PhoneAntihackInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.ErrorDialog(((SendPhoneAntihackCodeResult.FailedWithDialog) sendPhoneAntihackCodeResult2).getUserDialog()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Inject
    public PhoneAntihackInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorThrowableConverter");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        this.a = profileApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
        this.d = codeConfirmationResourceProvider;
    }

    public static final Observable access$toErrorObservable(PhoneAntihackInteractorImpl phoneAntihackInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(phoneAntihackInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.code_confirmation.PhoneAntihackInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        Observable onErrorResumeNext = InteropKt.toV2(this.a.requestPhoneAntihackCode(str)).subscribeOn(this.b.io()).onErrorResumeNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.requestPhoneAntihack…bservable()\n            }");
        Observable<CodeInfo> flatMap = TypedObservablesKt.toTyped(onErrorResumeNext).flatMap(new b(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.requestPhoneAntihack…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.code_confirmation.PhoneAntihackInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "login", str2, "code", str3, "challengeId");
        Observable onErrorResumeNext = InteropKt.toV2(this.a.sendPhoneAntihackCode(str, str2, str3)).subscribeOn(this.b.io()).onErrorResumeNext(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "api.sendPhoneAntihackCod…bservable()\n            }");
        Observable<ConfirmedCodeInfo> flatMap = TypedObservablesKt.toTyped(onErrorResumeNext).flatMap(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.sendPhoneAntihackCod…          }\n            }");
        return flatMap;
    }
}
