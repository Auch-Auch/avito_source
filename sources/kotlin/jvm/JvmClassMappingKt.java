package kotlin.jvm;

import com.avito.android.util.preferences.db_preferences.Types;
import java.lang.annotation.Annotation;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"(\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\")\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\n*\u00028\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000b8G@\u0006¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0007\u0010\u000f\"=\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b8Ç\u0002@\u0007X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000f\"-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068G@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"/\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000f\"-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001c"}, d2 = {"", "T", "", "", "isArrayOf", "([Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getJavaClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "", "Lkotlin/reflect/KClass;", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "annotationClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "java", "getRuntimeClassOfKClassInstance", "getRuntimeClassOfKClassInstance$annotations", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "kotlin", "getJavaPrimitiveType", "javaPrimitiveType", "getJavaObjectType", "javaObjectType", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt {
    @NotNull
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "$this$annotationClass");
        Class<? extends Annotation> annotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "(this as java.lang.annot…otation).annotationType()");
        KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return kotlinClass;
    }

    @JvmName(name = "getJavaClass")
    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$java");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }

    public static /* synthetic */ void getJavaClass$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Class<T> getJavaObjectType(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals("double") ? Double.class : cls;
            case 104431:
                if (name.equals(Types.INT)) {
                    return Integer.class;
                }
                return cls;
            case 3039496:
                if (name.equals("byte")) {
                    return Byte.class;
                }
                return cls;
            case 3052374:
                if (name.equals("char")) {
                    return Character.class;
                }
                return cls;
            case 3327612:
                if (name.equals("long")) {
                    return Long.class;
                }
                return cls;
            case 3625364:
                if (name.equals("void")) {
                    return Void.class;
                }
                return cls;
            case 64711720:
                if (name.equals(Types.BOOLEAN)) {
                    return Boolean.class;
                }
                return cls;
            case 97526364:
                if (name.equals(Types.FLOAT)) {
                    return Float.class;
                }
                return cls;
            case 109413500:
                if (name.equals("short")) {
                    return Short.class;
                }
                return cls;
            default:
                return cls;
        }
    }

    @Nullable
    public static final <T> Class<T> getJavaPrimitiveType(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                break;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                break;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                break;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                break;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                break;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                break;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                break;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                break;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                break;
        }
        return null;
    }

    @JvmName(name = "getKotlinClass")
    @NotNull
    public static final <T> KClass<T> getKotlinClass(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "$this$kotlin");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    @NotNull
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "$this$javaClass");
        Class<KClass<T>> cls = (Class<KClass<T>>) kClass.getClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
        return cls;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    public static final /* synthetic */ <T> boolean isArrayOf(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "$this$isArrayOf");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "$this$javaClass");
        Class<T> cls = (Class<T>) t.getClass();
        Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<T>");
        return cls;
    }
}
