package t6.w.f.a;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
public final class i extends Lambda implements Function0<List<? extends Type>> {
    public final /* synthetic */ KTypeImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(KTypeImpl.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public List<? extends Type> invoke() {
        Type javaType = this.a.a.getJavaType();
        Intrinsics.checkNotNull(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }
}
