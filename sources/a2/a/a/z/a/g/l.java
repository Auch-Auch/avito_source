package a2.a.a.z.a.g;

import com.avito.android.calls.CredentialsStorage;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class l<V> implements Callable<Object> {
    public final /* synthetic */ m a;
    public final /* synthetic */ String b;

    public l(m mVar, String str) {
        this.a = mVar;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        CredentialsStorage credentialsStorage = this.a.a.a.a;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(str, "name");
        credentialsStorage.setUsername(str);
        return Unit.INSTANCE;
    }
}
