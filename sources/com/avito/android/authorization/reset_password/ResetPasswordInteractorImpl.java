package com.avito.android.authorization.reset_password;

import a2.a.a.b.h.b;
import a2.a.a.b.h.c;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.RequestCodeInteractor;
import com.avito.android.code_confirmation.di.LoginCodeConfirmation;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.ResetPasswordResult;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
import com.avito.android.util.rx3.InteropKt;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordInteractorImpl;", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "", "login", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/ResetPasswordResult;", "resetPassword", "(Ljava/lang/String;)Lio/reactivex/Observable;", "loginResetPasswordForPhone", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "e", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "api", "Ldagger/Lazy;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "c", "Ldagger/Lazy;", "loginCodeConfirmationInteractor", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "d", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "resourceProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;Ldagger/Lazy;Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ResetPasswordInteractorImpl implements ResetPasswordInteractor {
    public final ProfileApi a;
    public final CodeConfirmationInteractor b;
    public final Lazy<CodeConfirmationInteractor> c;
    public final ResetPasswordResourceProvider d;
    public final TypedErrorThrowableConverter e;
    public final SchedulersFactory f;

    public static final class a<T, R> implements Function<CodeInfo, ResetPasswordResult> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ResetPasswordResult apply(CodeInfo codeInfo) {
            CodeInfo codeInfo2 = codeInfo;
            Intrinsics.checkNotNullParameter(codeInfo2, "it");
            return new ResetPasswordResult.ViaCode(codeInfo2.getText(), codeInfo2.getTimeout(), codeInfo2.getLength());
        }
    }

    @Inject
    public ResetPasswordInteractorImpl(@NotNull ProfileApi profileApi, @NotNull CodeConfirmationInteractor codeConfirmationInteractor, @LoginCodeConfirmation @NotNull Lazy<CodeConfirmationInteractor> lazy, @NotNull ResetPasswordResourceProvider resetPasswordResourceProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        Intrinsics.checkNotNullParameter(lazy, "loginCodeConfirmationInteractor");
        Intrinsics.checkNotNullParameter(resetPasswordResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = profileApi;
        this.b = codeConfirmationInteractor;
        this.c = lazy;
        this.d = resetPasswordResourceProvider;
        this.e = typedErrorThrowableConverter;
        this.f = schedulersFactory;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordInteractor
    @NotNull
    public Observable<ResetPasswordResult> loginResetPasswordForPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        Observable<ResetPasswordResult> map = RequestCodeInteractor.DefaultImpls.requestCode$default(this.c.get(), str, null, 2, null).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "loginCodeConfirmationInt… it.timeout, it.length) }");
        return map;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordInteractor
    @NotNull
    public Observable<ResetPasswordResult> resetPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        if (Strings.isEmail(str)) {
            Observable<ResetPasswordResult> map = InteropKt.toV2(this.a.recoverPasswordByEmail(str)).subscribeOn(this.f.io()).onErrorResumeNext(new a2.a.a.b.h.a(this)).map(new b(this, str));
            Intrinsics.checkNotNullExpressionValue(map, "api\n            .recover…wordViaLinkText(email)) }");
            return map;
        }
        Observable<ResetPasswordResult> map2 = RequestCodeInteractor.DefaultImpls.requestCode$default(this.b, str, null, 2, null).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map2, "codeConfirmationInteract… it.timeout, it.length) }");
        return map2;
    }
}
