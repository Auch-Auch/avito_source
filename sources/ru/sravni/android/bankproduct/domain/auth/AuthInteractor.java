package ru.sravni.android.bankproduct.domain.auth;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.auth.entity.RegisterInfo;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/domain/auth/AuthInteractor;", "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", "", "extractedPhone", "formattedPhone", "", "setPhoneNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "getPhoneNumber", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/auth/entity/RegisterInfo;", "sendPhone", "()Lio/reactivex/Observable;", "smsCode", "sendSmsCode", "(Ljava/lang/String;)Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/auth/IAuthRepository;", "c", "Lru/sravni/android/bankproduct/domain/auth/IAuthRepository;", "authRepository", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "<init>", "(Lru/sravni/android/bankproduct/domain/auth/IAuthRepository;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AuthInteractor implements IAuthInteractor {
    public String a = "";
    public String b = "";
    public final IAuthRepository c;
    public final IThrowableWrapper d;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends RegisterInfo>> {
        public final /* synthetic */ AuthInteractor a;

        public a(AuthInteractor authInteractor) {
            this.a = authInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends RegisterInfo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return UtilFunctionsKt.typeObservable(this.a.d.wrap(th2));
        }
    }

    public static final class b<T, R> implements Function<Throwable, ObservableSource<? extends Unit>> {
        public final /* synthetic */ AuthInteractor a;

        public b(AuthInteractor authInteractor) {
            this.a = authInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Unit> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return UtilFunctionsKt.typeObservable(this.a.d.wrap(th2));
        }
    }

    public AuthInteractor(@NotNull IAuthRepository iAuthRepository, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iAuthRepository, "authRepository");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.c = iAuthRepository;
        this.d = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.domain.auth.IAuthInteractor
    @NotNull
    public String getPhoneNumber() {
        return this.b;
    }

    @Override // ru.sravni.android.bankproduct.domain.auth.IAuthInteractor
    @NotNull
    public Observable<RegisterInfo> sendPhone() {
        IAuthRepository iAuthRepository = this.c;
        StringBuilder I = a2.b.a.a.a.I('7');
        I.append(this.a);
        Observable<RegisterInfo> onErrorResumeNext = iAuthRepository.registerUser(I.toString()).onErrorResumeNext(new a(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "authRepository.registerU…error).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.auth.IAuthInteractor
    @NotNull
    public Observable<Unit> sendSmsCode(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "smsCode");
        IAuthRepository iAuthRepository = this.c;
        StringBuilder I = a2.b.a.a.a.I('7');
        I.append(this.a);
        Observable<Unit> onErrorResumeNext = iAuthRepository.sendSmsCode(I.toString(), str).onErrorResumeNext(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "authRepository.sendSmsCo…error).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.auth.IAuthInteractor
    public void setPhoneNumber(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "extractedPhone");
        Intrinsics.checkParameterIsNotNull(str2, "formattedPhone");
        this.a = str;
        this.b = str2;
    }
}
