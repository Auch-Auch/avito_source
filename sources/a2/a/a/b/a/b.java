package a2.a.a.b.a;

import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(0);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        SmartLockLoaderImpl.access$push(this.a.a, SmartLockLoader.Command.Wait.INSTANCE);
        return Unit.INSTANCE;
    }
}
