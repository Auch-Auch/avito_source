package t6.w.f.a;

import a2.b.a.a.a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
public final class h extends Lambda implements Function0<Type> {
    public final /* synthetic */ int a;
    public final /* synthetic */ KTypeImpl.a b;
    public final /* synthetic */ Lazy c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(int i, KTypeImpl.a aVar, Lazy lazy, KProperty kProperty) {
        super(0);
        this.a = i;
        this.b = aVar;
        this.c = lazy;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Type invoke() {
        Type javaType = this.b.a.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return componentType;
        } else if (javaType instanceof GenericArrayType) {
            if (this.a == 0) {
                Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                Intrinsics.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                return genericComponentType;
            }
            StringBuilder L = a.L("Array type has been queried for a non-0th argument: ");
            L.append(this.b.a);
            throw new KotlinReflectionInternalError(L.toString());
        } else if (javaType instanceof ParameterizedType) {
            Type type = (Type) ((List) this.c.getValue()).get(this.a);
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Intrinsics.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                Type type2 = (Type) ArraysKt___ArraysKt.firstOrNull(lowerBounds);
                if (type2 != null) {
                    type = type2;
                } else {
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                    type = (Type) ArraysKt___ArraysKt.first(upperBounds);
                }
            }
            Intrinsics.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
            return type;
        } else {
            StringBuilder L2 = a.L("Non-generic type has been queried for arguments: ");
            L2.append(this.b.a);
            throw new KotlinReflectionInternalError(L2.toString());
        }
    }
}
