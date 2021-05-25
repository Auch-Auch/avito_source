package a2.a.a.b.a;

import com.avito.android.authorization.smart_lock.NeedResolveResultException;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.authorization.smart_lock.SmartLockException;
import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Task<CredentialRequestResponse>, MaybeSource<? extends Credential>> {
    public final /* synthetic */ SmartLockLoaderImpl a;

    public c(SmartLockLoaderImpl smartLockLoaderImpl) {
        this.a = smartLockLoaderImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends Credential> apply(Task<CredentialRequestResponse> task) {
        Task<CredentialRequestResponse> task2 = task;
        Intrinsics.checkNotNullExpressionValue(task2, "task");
        if (task2.isSuccessful()) {
            CredentialRequestResponse result = task2.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "task.result");
            return Maybe.just(result.getCredential());
        }
        Exception exception = task2.getException();
        if (!(exception instanceof ResolvableApiException)) {
            exception = null;
        }
        ResolvableApiException resolvableApiException = (ResolvableApiException) exception;
        if (resolvableApiException == null || resolvableApiException.getStatusCode() != 6) {
            return Maybe.error(new SmartLockException("SmartLock accounts loading failed"));
        }
        Exception exception2 = task2.getException();
        Objects.requireNonNull(exception2, "null cannot be cast to non-null type com.google.android.gms.common.api.ResolvableApiException");
        return Maybe.error(new NeedResolveResultException(new ResolvableResult((ResolvableApiException) exception2, new b(this))));
    }
}
