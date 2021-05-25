package t6.w.f.a.m.a.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
public final class b extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ JvmBuiltInsCustomizer a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.a = jvmBuiltInsCustomizer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public KotlinType invoke() {
        SimpleType anyType = this.a.a.getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(anyType, "moduleDescriptor.builtIns.anyType");
        return anyType;
    }
}
