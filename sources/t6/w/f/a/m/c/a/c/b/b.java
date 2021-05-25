package t6.w.f.a.m.c.a.c.b;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
public final class b extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ TypeParameterDescriptor a;
    public final /* synthetic */ JavaTypeAttributes b;
    public final /* synthetic */ TypeConstructor c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        super(0);
        this.a = typeParameterDescriptor;
        this.b = javaTypeAttributes;
        this.c = typeConstructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public KotlinType invoke() {
        TypeParameterDescriptor typeParameterDescriptor = this.a;
        Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
        return JavaTypeResolverKt.getErasedUpperBound(typeParameterDescriptor, this.b.getUpperBoundOfTypeParameter(), new a(this.c));
    }
}
