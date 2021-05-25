package kotlin.reflect.jvm.internal.calls;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "T", "Ljava/lang/Class;", "annotationClass", "", "", ResidentialComplexModuleKt.VALUES, "", "Ljava/lang/reflect/Method;", "methods", "createAnnotationInstance", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
public final class AnnotationConstructorCallerKt {

    public static final class a extends Lambda implements Function1<Object, Boolean> {
        public final /* synthetic */ Class a;
        public final /* synthetic */ List b;
        public final /* synthetic */ Map c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Class cls, List list, Map map) {
            super(1);
            this.a = cls;
            this.b = list;
            this.c = map;
        }

        /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.Nullable java.lang.Object r7) {
            /*
            // Method dump skipped, instructions count: 256
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.a.invoke(java.lang.Object):boolean");
        }
    }

    public static final class b extends Lambda implements Function0<Integer> {
        public final /* synthetic */ Map a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Map map) {
            super(0);
            this.a = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            int i;
            int i2 = 0;
            for (Map.Entry entry : this.a.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    i = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    i = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    i = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    i = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    i = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    i = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    i = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    i = Arrays.hashCode((double[]) value);
                } else if (value instanceof Object[]) {
                    i = Arrays.hashCode((Object[]) value);
                } else {
                    i = value.hashCode();
                }
                i2 += i ^ (str.hashCode() * 127);
            }
            return Integer.valueOf(i2);
        }
    }

    public static final class c implements InvocationHandler {
        public final /* synthetic */ Class a;
        public final /* synthetic */ Lazy b;
        public final /* synthetic */ Lazy c;
        public final /* synthetic */ a d;
        public final /* synthetic */ Map e;

        public c(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, a aVar, Map map) {
            this.a = cls;
            this.b = lazy;
            this.c = lazy2;
            this.d = aVar;
            this.e = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Intrinsics.checkNotNullExpressionValue(method, "method");
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return this.c.getValue();
                    }
                } else if (name.equals("toString")) {
                    return this.b.getValue();
                }
            }
            if (Intrinsics.areEqual(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.d.invoke(ArraysKt___ArraysKt.single(objArr)));
            }
            if (this.e.containsKey(name)) {
                return this.e.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb.append(ArraysKt___ArraysKt.toList(objArr));
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    public static final class d extends Lambda implements Function0<String> {
        public final /* synthetic */ Class a;
        public final /* synthetic */ Map b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Class cls, Map map) {
            super(0);
            this.a = cls;
            this.b = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            StringBuilder I = a2.b.a.a.a.I('@');
            I.append(this.a.getCanonicalName());
            CollectionsKt___CollectionsKt.joinTo$default(this.b.entrySet(), I, ", ", "(", ")", 0, null, t6.w.f.a.l.a.a, 48, null);
            String sb = I.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
            return sb;
        }
    }

    public static final Void access$throwIllegalArgumentType(int i, String str, Class cls) {
        KClass kClass;
        String str2;
        if (Intrinsics.areEqual(cls, Class.class)) {
            kClass = Reflection.getOrCreateKotlinClass(KClass.class);
        } else if (!cls.isArray() || !Intrinsics.areEqual(cls.getComponentType(), Class.class)) {
            kClass = JvmClassMappingKt.getKotlinClass(cls);
        } else {
            kClass = Reflection.getOrCreateKotlinClass(KClass[].class);
        }
        if (Intrinsics.areEqual(kClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(kClass.getQualifiedName());
            sb.append(Typography.less);
            Class<?> componentType = JvmClassMappingKt.getJavaClass(kClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "kotlinClass.java.componentType");
            sb.append(JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName());
            sb.append(Typography.greater);
            str2 = sb.toString();
        } else {
            str2 = kClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + str2);
    }

    public static final Object access$transformKotlinToJvm(Object obj, Class cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = JvmClassMappingKt.getJavaClass((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    @NotNull
    public static final <T> T createAnnotationInstance(@NotNull Class<T> cls, @NotNull Map<String, ? extends Object> map, @NotNull List<Method> list) {
        Intrinsics.checkNotNullParameter(cls, "annotationClass");
        Intrinsics.checkNotNullParameter(map, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(list, "methods");
        a aVar = new a(cls, list, map);
        Lazy lazy = t6.c.lazy(new b(map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(cls, t6.c.lazy(new d(cls, map)), null, lazy, null, aVar, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(keySet, 10));
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }
}
