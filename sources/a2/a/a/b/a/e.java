package a2.a.a.b.a;

import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResponse;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.ConstantsKt;
public final class e<T> implements SingleOnSubscribe<Task<CredentialRequestResponse>> {
    public final /* synthetic */ SmartLockLoaderImpl a;

    public static final class a<TResult> implements OnCompleteListener<CredentialRequestResponse> {
        public final /* synthetic */ SingleEmitter a;

        public a(SingleEmitter singleEmitter) {
            this.a = singleEmitter;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NotNull Task<CredentialRequestResponse> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.a.onSuccess(task);
        }
    }

    public e(SmartLockLoaderImpl smartLockLoaderImpl) {
        this.a = smartLockLoaderImpl;
    }

    @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Task<CredentialRequestResponse>> singleEmitter) {
        Credentials.getClient(this.a.e).request(new CredentialRequest.Builder().setPasswordLoginSupported(true).setAccountTypes(ConstantsKt.DEFAULT_ORIGIN).build()).addOnCompleteListener(new a(singleEmitter));
    }
}
