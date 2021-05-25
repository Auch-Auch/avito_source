package t6.w.f.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
public final class e extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ KPropertyImpl.Accessor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(KPropertyImpl.Accessor accessor) {
        super(0);
        this.a = accessor;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function0
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r2.a
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r0.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r0.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r0.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r1 = kotlin.reflect.jvm.internal.UtilKt.getJVM_STATIC()
            boolean r0 = r0.hasAnnotation(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.w.f.a.e.invoke():boolean");
    }
}
