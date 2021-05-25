package a2.a.a.b.a;

import com.avito.android.authorization.event.SmartLockSaveEvent;
import com.avito.android.authorization.smart_lock.NeedResolveResultException;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.authorization.smart_lock.SmartLockException;
import com.avito.android.authorization.smart_lock.SmartLockSaverImpl;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f<T> implements MaybeOnSubscribe<Unit> {
    public final /* synthetic */ SmartLockSaverImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public static final class a<TResult> implements OnCompleteListener<Void> {
        public final /* synthetic */ f a;
        public final /* synthetic */ MaybeEmitter b;

        public a(f fVar, MaybeEmitter maybeEmitter) {
            this.a = fVar;
            this.b = maybeEmitter;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v11, resolved type: io.reactivex.rxjava3.core.MaybeEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NotNull Task<Void> task) {
            String str;
            Intrinsics.checkNotNullParameter(task, "task");
            if (task.isSuccessful()) {
                this.a.a.d.track(new SmartLockSaveEvent());
                this.b.onSuccess(Unit.INSTANCE);
                return;
            }
            Exception exception = task.getException();
            if (!(exception instanceof ResolvableApiException)) {
                exception = null;
            }
            ResolvableApiException resolvableApiException = (ResolvableApiException) exception;
            if (resolvableApiException == null || resolvableApiException.getStatusCode() != 6) {
                MaybeEmitter maybeEmitter = this.b;
                Exception exception2 = task.getException();
                if (exception2 == null || (str = exception2.getMessage()) == null) {
                    str = "SmartLock account saving failed";
                }
                maybeEmitter.onError(new SmartLockException(str));
                return;
            }
            Exception exception3 = task.getException();
            Objects.requireNonNull(exception3, "null cannot be cast to non-null type com.google.android.gms.common.api.ResolvableApiException");
            this.b.onError(new NeedResolveResultException(new ResolvableResult((ResolvableApiException) exception3, null, 2, null)));
        }
    }

    public f(SmartLockSaverImpl smartLockSaverImpl, String str, String str2) {
        this.a = smartLockSaverImpl;
        this.b = str;
        this.c = str2;
    }

    @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
    public final void subscribe(MaybeEmitter<Unit> maybeEmitter) {
        Credentials.getClient(this.a.c).save(new Credential.Builder(this.b).setPassword(this.c).build()).addOnCompleteListener(new a(this, maybeEmitter));
    }
}
