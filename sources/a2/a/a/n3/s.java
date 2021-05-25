package a2.a.a.n3;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class s extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ Function0 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Function0 function0) {
        super(0);
        this.a = function0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        this.a.invoke();
        return Boolean.TRUE;
    }
}
