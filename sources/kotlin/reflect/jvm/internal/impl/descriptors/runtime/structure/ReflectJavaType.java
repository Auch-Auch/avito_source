package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public abstract class ReflectJavaType implements JavaType {
    @NotNull
    public static final Factory Factory = new Factory(null);

    public static final class Factory {
        public Factory() {
        }

        @NotNull
        public final ReflectJavaType create(@NotNull Type type) {
            ReflectJavaType reflectJavaType;
            Intrinsics.checkNotNullParameter(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                reflectJavaType = new ReflectJavaArrayType(type);
            } else if (type instanceof WildcardType) {
                reflectJavaType = new ReflectJavaWildcardType((WildcardType) type);
            } else {
                reflectJavaType = new ReflectJavaClassifierType(type);
            }
            return reflectJavaType;
        }

        public Factory(j jVar) {
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaType) && Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) obj).getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName) {
        return JavaType.DefaultImpls.findAnnotation(this, fqName);
    }

    @NotNull
    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
