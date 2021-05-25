package t6.w.f.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
public final class f extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ KPropertyImpl.Accessor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(KPropertyImpl.Accessor accessor) {
        super(0);
        this.a = accessor;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r1 = this;
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r1.a
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r0.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r0.getDescriptor()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r0)
            r0 = r0 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.w.f.a.f.invoke():boolean");
    }
}
