package com.avito.android.code_confirmation;

import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.recover_by_phone.ConfirmPasswordRecoveryByPhoneResult;
import com.avito.android.remote.model.recover_by_phone.RecoverByPhoneResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/code_confirmation/LegacyCodeConfirmationInteractor;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "", "login", "code", "src", "Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "id", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "resourceProvider", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;Lcom/avito/android/util/SchedulersFactory;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyCodeConfirmationInteractor implements CodeConfirmationInteractor {
    public final ProfileApi a;
    public final CodeConfirmationResourceProvider b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<RecoverByPhoneResult, ObservableSource<? extends CodeInfo>> {
        public final /* synthetic */ LegacyCodeConfirmationInteractor a;
        public final /* synthetic */ String b;

        public a(LegacyCodeConfirmationInteractor legacyCodeConfirmationInteractor, String str) {
            this.a = legacyCodeConfirmationInteractor;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends CodeInfo> apply(RecoverByPhoneResult recoverByPhoneResult) {
            RecoverByPhoneResult recoverByPhoneResult2 = recoverByPhoneResult;
            Intrinsics.checkNotNullParameter(recoverByPhoneResult2, "result");
            if (recoverByPhoneResult2 instanceof RecoverByPhoneResult.Ok) {
                RecoverByPhoneResult.Ok ok = (RecoverByPhoneResult.Ok) recoverByPhoneResult2;
                Observable just = Observable.just(new CodeInfo(this.a.b.codeSent(this.b), ok.getNextTryTime() - ok.getLastTryTime(), 5));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (recoverByPhoneResult2 instanceof RecoverByPhoneResult.Failure) {
                return Observables.toObservable(new TypedResultException(new ErrorWithMessage.SimpleMessageError(((RecoverByPhoneResult.Failure) recoverByPhoneResult2).getMessage())));
            } else {
                if (recoverByPhoneResult2 instanceof RecoverByPhoneResult.Unsafe) {
                    return Observables.toObservable(new TypedResultException(new ErrorWithMessage.SimpleMessageError(((RecoverByPhoneResult.Unsafe) recoverByPhoneResult2).getMessage())));
                }
                if (recoverByPhoneResult2 instanceof RecoverByPhoneResult.IncorrectData) {
                    return Observables.toObservable(new TypedResultException(new TypedError.ErrorMap(((RecoverByPhoneResult.IncorrectData) recoverByPhoneResult2).getMessages())));
                }
                if (recoverByPhoneResult2 instanceof RecoverByPhoneResult.Confirmed) {
                    RecoverByPhoneResult.Confirmed confirmed = (RecoverByPhoneResult.Confirmed) recoverByPhoneResult2;
                    return Observables.toObservable(new CodeAlreadyConfirmedException(new ConfirmedCodeInfo(this.b, confirmed.getHash(), confirmed.isPhoneUsed())));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<ConfirmPasswordRecoveryByPhoneResult, ObservableSource<? extends ConfirmedCodeInfo>> {
        public final /* synthetic */ LegacyCodeConfirmationInteractor a;
        public final /* synthetic */ String b;

        public b(LegacyCodeConfirmationInteractor legacyCodeConfirmationInteractor, String str) {
            this.a = legacyCodeConfirmationInteractor;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConfirmedCodeInfo> apply(ConfirmPasswordRecoveryByPhoneResult confirmPasswordRecoveryByPhoneResult) {
            ConfirmPasswordRecoveryByPhoneResult confirmPasswordRecoveryByPhoneResult2 = confirmPasswordRecoveryByPhoneResult;
            Intrinsics.checkNotNullParameter(confirmPasswordRecoveryByPhoneResult2, "result");
            if (confirmPasswordRecoveryByPhoneResult2 instanceof ConfirmPasswordRecoveryByPhoneResult.Ok) {
                Observable just = Observable.just(new ConfirmedCodeInfo(this.b, ((ConfirmPasswordRecoveryByPhoneResult.Ok) confirmPasswordRecoveryByPhoneResult2).getHash(), true));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (confirmPasswordRecoveryByPhoneResult2 instanceof ConfirmPasswordRecoveryByPhoneResult.Failure) {
                return LegacyCodeConfirmationInteractor.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((ConfirmPasswordRecoveryByPhoneResult.Failure) confirmPasswordRecoveryByPhoneResult2).getMessage()));
            } else {
                if (confirmPasswordRecoveryByPhoneResult2 instanceof ConfirmPasswordRecoveryByPhoneResult.IncorrectData) {
                    return LegacyCodeConfirmationInteractor.access$toErrorObservable(this.a, new TypedError.ErrorMap(((ConfirmPasswordRecoveryByPhoneResult.IncorrectData) confirmPasswordRecoveryByPhoneResult2).getMessages()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public LegacyCodeConfirmationInteractor(@NotNull ProfileApi profileApi, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = profileApi;
        this.b = codeConfirmationResourceProvider;
        this.c = schedulersFactory;
    }

    public static final Observable access$toErrorObservable(LegacyCodeConfirmationInteractor legacyCodeConfirmationInteractor, TypedError typedError) {
        Objects.requireNonNull(legacyCodeConfirmationInteractor);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable subscribeOn = InteropKt.toV2(this.a.recoverPasswordByPhone(str)).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.recoverPasswordByPho…scribeOn(schedulers.io())");
        Observable<CodeInfo> flatMap = TypedObservablesKt.toTyped(subscribeOn).flatMap(new a(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.recoverPasswordByPho…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        Observable subscribeOn = InteropKt.toV2(this.a.confirmRecoverPasswordByPhone(str, str2)).subscribeOn(this.c.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.confirmRecoverPasswo…scribeOn(schedulers.io())");
        Observable<ConfirmedCodeInfo> flatMap = TypedObservablesKt.toTyped(subscribeOn).flatMap(new b(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.confirmRecoverPasswo…          }\n            }");
        return flatMap;
    }
}
