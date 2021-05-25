package kotlin.reflect.jvm;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001d\u0010\b\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"/\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\"\b\b\u0000\u0010\n*\u00020\t*\b\u0012\u0004\u0012\u00028\u00000\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001d\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u0014\"\u0017\u0010\u0019\u001a\u00020\u0016*\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"1\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\f8F@\u0006¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\"\u001d\u0010\"\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u001f8F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!\"\u001d\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001d\u0010(\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\f8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Ljava/lang/reflect/Member;", "Lkotlin/reflect/KDeclarationContainer;", AuthSource.SEND_ABUSE, "(Ljava/lang/reflect/Member;)Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KProperty;", "Ljava/lang/reflect/Field;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaField", "", "T", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/KFunction;", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "kotlinFunction", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaGetter", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "Lkotlin/reflect/KType;", "Ljava/lang/reflect/Type;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "javaType", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "javaConstructor", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaSetter", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "kotlinProperty", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaMethod", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "ReflectJvmMapping")
public final class ReflectJvmMapping {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            KotlinClassHeader.Kind.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            KotlinClassHeader.Kind kind = KotlinClassHeader.Kind.FILE_FACADE;
            iArr[2] = 1;
            KotlinClassHeader.Kind kind2 = KotlinClassHeader.Kind.MULTIFILE_CLASS;
            iArr[4] = 2;
            KotlinClassHeader.Kind kind3 = KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
            iArr[5] = 3;
        }
    }

    public static final KDeclarationContainer a(Member member) {
        KotlinClassHeader classHeader;
        ReflectKotlinClass.Factory factory = ReflectKotlinClass.Factory;
        Class<?> declaringClass = member.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "declaringClass");
        ReflectKotlinClass create = factory.create(declaringClass);
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind == null) {
            return null;
        }
        int ordinal = kind.ordinal();
        if (ordinal != 2 && ordinal != 4 && ordinal != 5) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass2, "declaringClass");
        return new KPackageImpl(declaringClass2, null, 2, null);
    }

    @Nullable
    public static final <T> Constructor<T> getJavaConstructor(@NotNull KFunction<? extends T> kFunction) {
        Caller<?> caller;
        Intrinsics.checkNotNullParameter(kFunction, "$this$javaConstructor");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Object obj = null;
        Object member = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.getMember();
        if (member instanceof Constructor) {
            obj = member;
        }
        return (Constructor) obj;
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction kFunction) {
    }

    @Nullable
    public static final Field getJavaField(@NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "$this$javaField");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    @Nullable
    public static final Method getJavaGetter(@NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "$this$javaGetter");
        return getJavaMethod(kProperty.getGetter());
    }

    @Nullable
    public static final Method getJavaMethod(@NotNull KFunction<?> kFunction) {
        Caller<?> caller;
        Intrinsics.checkNotNullParameter(kFunction, "$this$javaMethod");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Object obj = null;
        Object member = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.getMember();
        if (member instanceof Method) {
            obj = member;
        }
        return (Method) obj;
    }

    @Nullable
    public static final Method getJavaSetter(@NotNull KMutableProperty<?> kMutableProperty) {
        Intrinsics.checkNotNullParameter(kMutableProperty, "$this$javaSetter");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType kType) {
        Intrinsics.checkNotNullParameter(kType, "$this$javaType");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        return javaType != null ? javaType : TypesJVMKt.getJavaType(kType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b6 A[EDGE_INSN: B:53:0x00b6->B:35:0x00b6 ?: BREAK  , SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.KFunction<?> getKotlinFunction(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r7) {
        /*
            java.lang.String r0 = "$this$kotlinFunction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r7.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            java.lang.String r1 = "declaringClass"
            r2 = 0
            if (r0 == 0) goto L_0x00bb
            kotlin.reflect.KDeclarationContainer r0 = a(r7)
            if (r0 == 0) goto L_0x0056
            java.util.Collection r0 = r0.getMembers()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0025:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0037
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof kotlin.reflect.KFunction
            if (r4 == 0) goto L_0x0025
            r1.add(r3)
            goto L_0x0025
        L_0x0037:
            java.util.Iterator r0 = r1.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r0.next()
            r3 = r1
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r7)
            if (r3 == 0) goto L_0x003b
            r2 = r1
        L_0x0053:
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            return r2
        L_0x0056:
            java.lang.Class r0 = r7.getDeclaringClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            kotlin.reflect.KClass r0 = kotlin.reflect.full.KClasses.getCompanionObject(r0)
            if (r0 == 0) goto L_0x00bb
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getFunctions(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x006f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00b5
            java.lang.Object r3 = r0.next()
            r4 = r3
            kotlin.reflect.KFunction r4 = (kotlin.reflect.KFunction) r4
            java.lang.reflect.Method r4 = getJavaMethod(r4)
            if (r4 == 0) goto L_0x00b1
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = r7.getName()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x00b1
            java.lang.Class[] r5 = r4.getParameterTypes()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Class[] r6 = r7.getParameterTypes()
            boolean r5 = java.util.Arrays.equals(r5, r6)
            if (r5 == 0) goto L_0x00b1
            java.lang.Class r4 = r4.getReturnType()
            java.lang.Class r5 = r7.getReturnType()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x00b1
            r4 = 1
            goto L_0x00b2
        L_0x00b1:
            r4 = 0
        L_0x00b2:
            if (r4 == 0) goto L_0x006f
            goto L_0x00b6
        L_0x00b5:
            r3 = r2
        L_0x00b6:
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            if (r3 == 0) goto L_0x00bb
            return r3
        L_0x00bb:
            java.lang.Class r0 = r7.getDeclaringClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getFunctions(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x00ce:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e6
            java.lang.Object r1 = r0.next()
            r3 = r1
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r7)
            if (r3 == 0) goto L_0x00ce
            r2 = r1
        L_0x00e6:
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(java.lang.reflect.Method):kotlin.reflect.KFunction");
    }

    @Nullable
    public static final KProperty<?> getKotlinProperty(@NotNull Field field) {
        Intrinsics.checkNotNullParameter(field, "$this$kotlinProperty");
        Object obj = null;
        if (field.isSynthetic()) {
            return null;
        }
        KDeclarationContainer a = a(field);
        if (a != null) {
            Collection<KCallable<?>> members = a.getMembers();
            ArrayList arrayList = new ArrayList();
            for (T t : members) {
                if (t instanceof KProperty) {
                    arrayList.add(t);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(getJavaField((KProperty) next), field)) {
                    obj = next;
                    break;
                }
            }
            return (KProperty) obj;
        }
        Class<?> declaringClass = field.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "declaringClass");
        Iterator it2 = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(declaringClass)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(getJavaField((KProperty1) next2), field)) {
                obj = next2;
                break;
            }
        }
        return (KProperty) obj;
    }

    @Nullable
    public static final <T> KFunction<T> getKotlinFunction(@NotNull Constructor<T> constructor) {
        T t;
        Intrinsics.checkNotNullParameter(constructor, "$this$kotlinFunction");
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "declaringClass");
        Iterator<T> it = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(getJavaConstructor(t), constructor)) {
                break;
            }
        }
        return t;
    }
}
