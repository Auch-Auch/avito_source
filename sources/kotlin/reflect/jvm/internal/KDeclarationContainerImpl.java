package kotlin.reflect.jvm.internal;

import a2.g.r.g;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0007¢\u0006\u0004\bH\u0010IJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u0015¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u0015¢\u0006\u0004\b&\u0010%JG\u0010,\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030'2\u0006\u0010\u0003\u001a\u00020\u00152\u0010\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0(2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010+\u001a\u00020\u001fH\u0002¢\u0006\u0004\b,\u0010-J?\u0010.\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030'2\u0006\u0010\u0003\u001a\u00020\u00152\u0010\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0(2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030'H\u0002¢\u0006\u0004\b.\u0010/J/\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u0006\u0012\u0002\b\u00030'2\u0010\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'00H\u0002¢\u0006\u0004\b1\u00102J1\u00107\u001a\u0002062\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'032\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b7\u00108J!\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'002\u0006\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b9\u0010:J+\u0010=\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b?\u0010@R\u001a\u0010C\u001a\u0006\u0012\u0002\b\u00030'8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020D0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006M"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", FirebaseAnalytics.Param.INDEX, "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;)Ljava/util/Collection;", "", SessionContract.SIGNATURE, "findPropertyDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findFunctionDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "desc", "Ljava/lang/reflect/Method;", "findMethodBySignature", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;", "", "isMember", "findDefaultMethod", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Constructor;", "findConstructorBySignature", "(Ljava/lang/String;)Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "Ljava/lang/Class;", "", "parameterTypes", "returnType", "isStaticDefault", "d", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", g.a, "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "f", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "", "result", "isConstructor", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;Ljava/lang/String;Z)V", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Ljava/util/List;", "begin", "end", "e", "(Ljava/lang/String;II)Ljava/lang/Class;", "c", "(Ljava/lang/String;)Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "<init>", "()V", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final Class<?> a = Class.forName("t6.r.a.j");
    @NotNull
    public static final Regex b = new Regex("<v#(\\d+)>");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\t\u001a\u0012\u0012\u0002\b\u0003 \b*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "Lkotlin/text/Regex;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.b;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", AuthSource.SEND_ABUSE, "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public abstract class Data {
        public static final /* synthetic */ KProperty[] c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        @NotNull
        public final ReflectProperties.LazySoftVal a = ReflectProperties.lazySoft(new a(this));

        public static final class a extends Lambda implements Function0<RuntimeModuleData> {
            public final /* synthetic */ Data a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Data data) {
                super(0);
                this.a = data;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public RuntimeModuleData invoke() {
                return ModuleByClassLoaderKt.getOrCreateModule(KDeclarationContainerImpl.this.getJClass());
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public Data() {
        }

        @NotNull
        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.a.getValue(this, c[0]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "member", "", "accept", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Z", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics.checkNotNullParameter(callableMemberDescriptor, "member");
            CallableMemberDescriptor.Kind kind = callableMemberDescriptor.getKind();
            Intrinsics.checkNotNullExpressionValue(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    public static final class a extends Lambda implements Function1<FunctionDescriptor, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(FunctionDescriptor functionDescriptor) {
            FunctionDescriptor functionDescriptor2 = functionDescriptor;
            Intrinsics.checkNotNullParameter(functionDescriptor2, "descriptor");
            return DescriptorRenderer.DEBUG_TEXT.render(functionDescriptor2) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(functionDescriptor2).asString();
        }
    }

    public static final class b extends Lambda implements Function1<PropertyDescriptor, CharSequence> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(PropertyDescriptor propertyDescriptor) {
            PropertyDescriptor propertyDescriptor2 = propertyDescriptor;
            Intrinsics.checkNotNullParameter(propertyDescriptor2, "descriptor");
            return DescriptorRenderer.DEBUG_TEXT.render(propertyDescriptor2) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(propertyDescriptor2).asString();
        }
    }

    public static final class c<T> implements Comparator<DescriptorVisibility> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
            Integer compare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
            if (compare != null) {
                return compare.intValue();
            }
            return 0;
        }
    }

    public final void a(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> b2 = b(str);
        list.addAll(b2);
        int size = ((((ArrayList) b2).size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? a : Object.class;
        Intrinsics.checkNotNullExpressionValue(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    public final List<Class<?>> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char charAt = str.charAt(i2);
            if (!StringsKt__StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                if (charAt == 'L') {
                    i2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ';', i, false, 4, (Object) null);
                } else {
                    throw new KotlinReflectionInternalError(a2.b.a.a.a.c3("Unknown type prefix in the method signature: ", str));
                }
            }
            int i3 = i2 + 1;
            arrayList.add(e(str, i, i3));
            i = i3;
        }
        return arrayList;
    }

    public final Class<?> c(String str) {
        return e(str, StringsKt__StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    public final Method d(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method d;
        if (z) {
            clsArr[0] = cls;
        }
        Method g = g(cls, str, clsArr, cls2);
        if (g != null) {
            return g;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!(superclass == null || (d = d(superclass, str, clsArr, cls2, z)) == null)) {
            return d;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> cls3 : interfaces) {
            Intrinsics.checkNotNullExpressionValue(cls3, "superInterface");
            Method d2 = d(cls3, str, clsArr, cls2, z);
            if (d2 != null) {
                return d2;
            }
            if (z) {
                Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (tryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method g2 = g(tryLoadClass, str, clsArr, cls2);
                    if (g2 != null) {
                        return g2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final Class<?> e(String str, int i, int i2) {
        char charAt = str.charAt(i);
        if (charAt == 'F') {
            return Float.TYPE;
        }
        if (charAt == 'L') {
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            String substring = str.substring(i + 1, i2 - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> loadClass = safeClassLoader.loadClass(m.replace$default(substring, '/', (char) FormatterType.defaultDecimalSeparator, false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return loadClass;
        } else if (charAt == 'S') {
            return Short.TYPE;
        } else {
            if (charAt == 'V') {
                Class<?> cls = Void.TYPE;
                Intrinsics.checkNotNullExpressionValue(cls, "Void.TYPE");
                return cls;
            } else if (charAt == 'I') {
                return Integer.TYPE;
            } else {
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (charAt == '[') {
                    return ReflectClassUtilKt.createArrayType(e(str, i + 1, i2));
                }
                switch (charAt) {
                    case 'B':
                        return Byte.TYPE;
                    case 'C':
                        return Character.TYPE;
                    case 'D':
                        return Double.TYPE;
                    default:
                        throw new KotlinReflectionInternalError(a2.b.a.a.a.c3("Unknown type prefix in the method signature: ", str));
                }
            }
        }
    }

    public final Constructor<?> f(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Nullable
    public final Constructor<?> findConstructorBySignature(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        return f(getJClass(), b(str));
    }

    @Nullable
    public final Constructor<?> findDefaultConstructor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        a(arrayList, str, true);
        return f(jClass, arrayList);
    }

    @Nullable
    public final Method findDefaultMethod(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        if (Intrinsics.areEqual(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        a(arrayList, str2, false);
        Class<?> methodOwner = getMethodOwner();
        String c3 = a2.b.a.a.a.c3(str, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return d(methodOwner, c3, (Class[]) array, c(str2), z);
    }

    @NotNull
    public final FunctionDescriptor findFunctionDescriptor(@NotNull String str, @NotNull String str2) {
        Collection<FunctionDescriptor> collection;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, SessionContract.SIGNATURE);
        if (Intrinsics.areEqual(str, "<init>")) {
            collection = CollectionsKt___CollectionsKt.toList(getConstructorDescriptors());
        } else {
            Name identifier = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier, "Name.identifier(name)");
            collection = getFunctions(identifier);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature(t).asString(), str2)) {
                arrayList.add(t);
            }
        }
        boolean z = true;
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) arrayList);
        }
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(collection, "\n", null, null, 0, null, a.a, 30, null);
        StringBuilder W = a2.b.a.a.a.W("Function '", str, "' (JVM signature: ", str2, ") not resolved in ");
        W.append(this);
        W.append(':');
        if (joinToString$default.length() != 0) {
            z = false;
        }
        W.append(z ? " no members found" : '\n' + joinToString$default);
        throw new KotlinReflectionInternalError(W.toString());
    }

    @Nullable
    public final Method findMethodBySignature(@NotNull String str, @NotNull String str2) {
        Method d;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        if (Intrinsics.areEqual(str, "<init>")) {
            return null;
        }
        Object[] array = b(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> c2 = c(str2);
        Method d2 = d(getMethodOwner(), str, clsArr, c2, false);
        if (d2 != null) {
            return d2;
        }
        if (!getMethodOwner().isInterface() || (d = d(Object.class, str, clsArr, c2, false)) == null) {
            return null;
        }
        return d;
    }

    @NotNull
    public final PropertyDescriptor findPropertyDescriptor(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, SessionContract.SIGNATURE);
        MatchResult matchEntire = b.matchEntire(str2);
        boolean z = true;
        if (matchEntire != null) {
            String str3 = matchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str3));
            if (localProperty != null) {
                return localProperty;
            }
            StringBuilder R = a2.b.a.a.a.R("Local property #", str3, " not found in ");
            R.append(getJClass());
            throw new KotlinReflectionInternalError(R.toString());
        }
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "Name.identifier(name)");
        Collection<PropertyDescriptor> properties = getProperties(identifier);
        ArrayList arrayList = new ArrayList();
        for (T t : properties) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature(t).asString(), str2)) {
                arrayList.add(t);
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder W = a2.b.a.a.a.W("Property '", str, "' (JVM signature: ", str2, ") not resolved in ");
            W.append(this);
            throw new KotlinReflectionInternalError(W.toString());
        } else if (arrayList.size() == 1) {
            return (PropertyDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) arrayList);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : arrayList) {
                DescriptorVisibility visibility = ((PropertyDescriptor) obj).getVisibility();
                Object obj2 = linkedHashMap.get(visibility);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(visibility, obj2);
                }
                ((List) obj2).add(obj);
            }
            Collection values = q.toSortedMap(linkedHashMap, c.a).values();
            Intrinsics.checkNotNullExpressionValue(values, "properties\n             …                }).values");
            List list = (List) CollectionsKt___CollectionsKt.last(values);
            if (list.size() == 1) {
                Intrinsics.checkNotNullExpressionValue(list, "mostVisibleProperties");
                return (PropertyDescriptor) CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            }
            Name identifier2 = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier2, "Name.identifier(name)");
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getProperties(identifier2), "\n", null, null, 0, null, b.a, 30, null);
            StringBuilder W2 = a2.b.a.a.a.W("Property '", str, "' (JVM signature: ", str2, ") not resolved in ");
            W2.append(this);
            W2.append(':');
            if (joinToString$default.length() != 0) {
                z = false;
            }
            W2.append(z ? " no members found" : '\n' + joinToString$default);
            throw new KotlinReflectionInternalError(W2.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a A[LOOP:0: B:6:0x0029->B:17:0x005a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Method g(java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Class<?> r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r9.length     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r9, r1)     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.String r2 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.Class r2 = r1.getReturnType()     // Catch:{ NoSuchMethodException -> 0x005d }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r10)     // Catch:{ NoSuchMethodException -> 0x005d }
            if (r2 == 0) goto L_0x001d
            r0 = r1
            goto L_0x005d
        L_0x001d:
            java.lang.reflect.Method[] r7 = r7.getDeclaredMethods()     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.String r1 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch:{ NoSuchMethodException -> 0x005d }
            int r1 = r7.length     // Catch:{ NoSuchMethodException -> 0x005d }
            r2 = 0
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x005d
            r4 = r7[r3]     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.String r5 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ NoSuchMethodException -> 0x005d }
            java.lang.String r5 = r4.getName()     // Catch:{ NoSuchMethodException -> 0x005d }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)     // Catch:{ NoSuchMethodException -> 0x005d }
            if (r5 == 0) goto L_0x0055
            java.lang.Class r5 = r4.getReturnType()     // Catch:{ NoSuchMethodException -> 0x005d }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r10)     // Catch:{ NoSuchMethodException -> 0x005d }
            if (r5 == 0) goto L_0x0055
            java.lang.Class[] r5 = r4.getParameterTypes()     // Catch:{ NoSuchMethodException -> 0x005d }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ NoSuchMethodException -> 0x005d }
            boolean r5 = java.util.Arrays.equals(r5, r9)     // Catch:{ NoSuchMethodException -> 0x005d }
            if (r5 == 0) goto L_0x0055
            r5 = 1
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            if (r5 == 0) goto L_0x005a
            r0 = r4
            goto L_0x005d
        L_0x005a:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.g(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class):java.lang.reflect.Method");
    }

    @NotNull
    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    @NotNull
    public abstract Collection<FunctionDescriptor> getFunctions(@NotNull Name name);

    @Nullable
    public abstract PropertyDescriptor getLocalProperty(int i);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x001e A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7, r7)
            r1 = 0
            r2 = 3
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r1, r1, r2, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x001e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0055
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L_0x004e
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x004e
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L_0x004e
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = r3.accept(r0, r4)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L_0x004f
        L_0x004e:
            r3 = r1
        L_0x004f:
            if (r3 == 0) goto L_0x001e
            r2.add(r3)
            goto L_0x001e
        L_0x0055:
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @NotNull
    public Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    @NotNull
    public abstract Collection<PropertyDescriptor> getProperties(@NotNull Name name);
}
