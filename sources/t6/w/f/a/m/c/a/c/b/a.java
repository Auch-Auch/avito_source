package t6.w.f.a.m.c.a.c.b;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
public final class a extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ TypeConstructor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(TypeConstructor typeConstructor) {
        super(0);
        this.a = typeConstructor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public KotlinType invoke() {
        ClassifierDescriptor declarationDescriptor = this.a.mo425getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor);
        SimpleType defaultType = declarationDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
    }
}
