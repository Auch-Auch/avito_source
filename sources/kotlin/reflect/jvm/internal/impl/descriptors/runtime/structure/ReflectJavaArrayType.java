package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import a2.b.a.a.a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import org.jetbrains.annotations.NotNull;
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    @NotNull
    public final Type a;
    @NotNull
    public final ReflectJavaType b;
    @NotNull
    public final Collection<JavaAnnotation> c;

    public ReflectJavaArrayType(@NotNull Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.a = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof GenericArrayType) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Type genericComponentType = ((GenericArrayType) reflectType).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
            reflectJavaType = factory.create(genericComponentType);
        } else {
            if (reflectType instanceof Class) {
                Class cls = (Class) reflectType;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType()");
                    reflectJavaType = factory2.create(componentType);
                }
            }
            StringBuilder L = a.L("Not an array type (");
            L.append(getReflectType().getClass());
            L.append("): ");
            L.append(getReflectType());
            throw new IllegalArgumentException(L.toString());
        }
        this.b = reflectJavaType;
        this.c = CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    @NotNull
    public Type getReflectType() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    @NotNull
    public ReflectJavaType getComponentType() {
        return this.b;
    }
}
