package t6.w.f.a;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KCallableImpl;
public final class b extends Lambda implements Function0<Type> {
    public final /* synthetic */ KCallableImpl.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(KCallableImpl.c cVar) {
        super(0);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Type invoke() {
        Type access$extractContinuationArgument = KCallableImpl.access$extractContinuationArgument(this.a.a);
        return access$extractContinuationArgument != null ? access$extractContinuationArgument : this.a.a.getCaller().getReturnType();
    }
}
