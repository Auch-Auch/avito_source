package t6.w.f.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
public final class j extends Lambda implements Function1<Class<?>, CharSequence> {
    public static final j a = new j();

    public j() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(Class<?> cls) {
        Class<?> cls2 = cls;
        Intrinsics.checkNotNullExpressionValue(cls2, "it");
        return ReflectClassUtilKt.getDesc(cls2);
    }
}
