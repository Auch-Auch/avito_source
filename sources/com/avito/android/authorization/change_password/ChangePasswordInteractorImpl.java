package com.avito.android.authorization.change_password;

import com.avito.android.authorization.change_password.di.Hash;
import com.avito.android.authorization.change_password.di.Login;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.recover_by_phone.ResetPasswordResult;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B-\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordInteractorImpl;", "Lcom/avito/android/authorization/change_password/ChangePasswordInteractor;", "", Preference.PASSWORD, "Lio/reactivex/Observable;", "", "changePassword", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", "c", "Lcom/avito/android/remote/ProfileApi;", "api", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "type", AuthSource.BOOKING_ORDER, "hash", "login", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ChangePasswordInteractorImpl implements ChangePasswordInteractor {
    public final String a;
    public final String b;
    public final ProfileApi c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<ResetPasswordResult, ObservableSource<? extends Unit>> {
        public final /* synthetic */ ChangePasswordInteractorImpl a;

        public a(ChangePasswordInteractorImpl changePasswordInteractorImpl) {
            this.a = changePasswordInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(ResetPasswordResult resetPasswordResult) {
            ResetPasswordResult resetPasswordResult2 = resetPasswordResult;
            Intrinsics.checkNotNullParameter(resetPasswordResult2, "result");
            if (resetPasswordResult2 instanceof ResetPasswordResult.Ok) {
                Observable just = Observable.just(Unit.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (resetPasswordResult2 instanceof ResetPasswordResult.Failure) {
                return ChangePasswordInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((ResetPasswordResult.Failure) resetPasswordResult2).getMessage()));
            } else {
                if (resetPasswordResult2 instanceof ResetPasswordResult.IncorrectData) {
                    return ChangePasswordInteractorImpl.access$toErrorObservable(this.a, new TypedError.ErrorMap(((ResetPasswordResult.IncorrectData) resetPasswordResult2).getMessages()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Inject
    public ChangePasswordInteractorImpl(@Login @NotNull String str, @Hash @NotNull String str2, @NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = str2;
        this.c = profileApi;
        this.d = schedulersFactory;
        this.a = Strings.isEmail(str) ? "email" : "phone";
    }

    public static final Observable access$toErrorObservable(ChangePasswordInteractorImpl changePasswordInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(changePasswordInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordInteractor
    @NotNull
    public Observable<Unit> changePassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Preference.PASSWORD);
        Observable subscribeOn = InteropKt.toV2(this.c.resetPassword(str, this.b, this.a)).subscribeOn(this.d.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.resetPassword(passwo…scribeOn(schedulers.io())");
        Observable<Unit> flatMap = TypedObservablesKt.toTyped(subscribeOn).flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.resetPassword(passwo…          }\n            }");
        return flatMap;
    }
}
