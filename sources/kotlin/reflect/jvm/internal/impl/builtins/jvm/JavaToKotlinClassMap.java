package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.l;
public final class JavaToKotlinClassMap {
    @NotNull
    public static final JavaToKotlinClassMap INSTANCE;
    @NotNull
    public static final String a;
    @NotNull
    public static final String b;
    @NotNull
    public static final String c;
    @NotNull
    public static final String d;
    @NotNull
    public static final ClassId e;
    @NotNull
    public static final FqName f;
    @NotNull
    public static final ClassId g;
    @NotNull
    public static final HashMap<FqNameUnsafe, ClassId> h = new HashMap<>();
    @NotNull
    public static final HashMap<FqNameUnsafe, ClassId> i = new HashMap<>();
    @NotNull
    public static final HashMap<FqNameUnsafe, FqName> j = new HashMap<>();
    @NotNull
    public static final HashMap<FqNameUnsafe, FqName> k = new HashMap<>();
    @NotNull
    public static final List<PlatformMutabilityMapping> l;

    public static final class PlatformMutabilityMapping {
        @NotNull
        public final ClassId a;
        @NotNull
        public final ClassId b;
        @NotNull
        public final ClassId c;

        public PlatformMutabilityMapping(@NotNull ClassId classId, @NotNull ClassId classId2, @NotNull ClassId classId3) {
            Intrinsics.checkNotNullParameter(classId, "javaClass");
            Intrinsics.checkNotNullParameter(classId2, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(classId3, "kotlinMutable");
            this.a = classId;
            this.b = classId2;
            this.c = classId3;
        }

        @NotNull
        public final ClassId component1() {
            return this.a;
        }

        @NotNull
        public final ClassId component2() {
            return this.b;
        }

        @NotNull
        public final ClassId component3() {
            return this.c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlatformMutabilityMapping)) {
                return false;
            }
            PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
            return Intrinsics.areEqual(this.a, platformMutabilityMapping.a) && Intrinsics.areEqual(this.b, platformMutabilityMapping.b) && Intrinsics.areEqual(this.c, platformMutabilityMapping.c);
        }

        @NotNull
        public final ClassId getJavaClass() {
            return this.a;
        }

        public int hashCode() {
            int hashCode = this.b.hashCode();
            return this.c.hashCode() + ((hashCode + (this.a.hashCode() * 31)) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PlatformMutabilityMapping(javaClass=");
            L.append(this.a);
            L.append(", kotlinReadOnly=");
            L.append(this.b);
            L.append(", kotlinMutable=");
            L.append(this.c);
            L.append(')');
            return L.toString();
        }
    }

    static {
        JavaToKotlinClassMap javaToKotlinClassMap = new JavaToKotlinClassMap();
        INSTANCE = javaToKotlinClassMap;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.Function;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append(FormatterType.defaultDecimalSeparator);
        sb.append(functionClassKind.getClassNamePrefix());
        a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.KFunction;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append(FormatterType.defaultDecimalSeparator);
        sb2.append(functionClassKind2.getClassNamePrefix());
        b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.SuspendFunction;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append(FormatterType.defaultDecimalSeparator);
        sb3.append(functionClassKind3.getClassNamePrefix());
        c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.KSuspendFunction;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append(FormatterType.defaultDecimalSeparator);
        sb4.append(functionClassKind4.getClassNamePrefix());
        d = sb4.toString();
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        e = classId;
        FqName asSingleFqName = classId.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f = asSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        g = classId2;
        Intrinsics.checkNotNullExpressionValue(ClassId.topLevel(new FqName("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        javaToKotlinClassMap.e(Class.class);
        ClassId classId3 = ClassId.topLevel(StandardNames.FqNames.iterable);
        Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(FqNames.iterable)");
        FqName fqName = StandardNames.FqNames.mutableIterable;
        FqName packageFqName = classId3.getPackageFqName();
        FqName packageFqName2 = classId3.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName tail = FqNamesUtilKt.tail(fqName, packageFqName2);
        int i2 = 0;
        ClassId classId4 = new ClassId(packageFqName, tail, false);
        ClassId classId5 = ClassId.topLevel(StandardNames.FqNames.iterator);
        Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(FqNames.iterator)");
        FqName fqName2 = StandardNames.FqNames.mutableIterator;
        FqName packageFqName3 = classId5.getPackageFqName();
        FqName packageFqName4 = classId5.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId6 = new ClassId(packageFqName3, FqNamesUtilKt.tail(fqName2, packageFqName4), false);
        ClassId classId7 = ClassId.topLevel(StandardNames.FqNames.collection);
        Intrinsics.checkNotNullExpressionValue(classId7, "topLevel(FqNames.collection)");
        FqName fqName3 = StandardNames.FqNames.mutableCollection;
        FqName packageFqName5 = classId7.getPackageFqName();
        FqName packageFqName6 = classId7.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId8 = new ClassId(packageFqName5, FqNamesUtilKt.tail(fqName3, packageFqName6), false);
        ClassId classId9 = ClassId.topLevel(StandardNames.FqNames.list);
        Intrinsics.checkNotNullExpressionValue(classId9, "topLevel(FqNames.list)");
        FqName fqName4 = StandardNames.FqNames.mutableList;
        FqName packageFqName7 = classId9.getPackageFqName();
        FqName packageFqName8 = classId9.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId10 = new ClassId(packageFqName7, FqNamesUtilKt.tail(fqName4, packageFqName8), false);
        ClassId classId11 = ClassId.topLevel(StandardNames.FqNames.set);
        Intrinsics.checkNotNullExpressionValue(classId11, "topLevel(FqNames.set)");
        FqName fqName5 = StandardNames.FqNames.mutableSet;
        FqName packageFqName9 = classId11.getPackageFqName();
        FqName packageFqName10 = classId11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId12 = new ClassId(packageFqName9, FqNamesUtilKt.tail(fqName5, packageFqName10), false);
        ClassId classId13 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        Intrinsics.checkNotNullExpressionValue(classId13, "topLevel(FqNames.listIterator)");
        FqName fqName6 = StandardNames.FqNames.mutableListIterator;
        FqName packageFqName11 = classId13.getPackageFqName();
        FqName packageFqName12 = classId13.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId14 = new ClassId(packageFqName11, FqNamesUtilKt.tail(fqName6, packageFqName12), false);
        FqName fqName7 = StandardNames.FqNames.map;
        ClassId classId15 = ClassId.topLevel(fqName7);
        Intrinsics.checkNotNullExpressionValue(classId15, "topLevel(FqNames.map)");
        FqName fqName8 = StandardNames.FqNames.mutableMap;
        FqName packageFqName13 = classId15.getPackageFqName();
        FqName packageFqName14 = classId15.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId16 = new ClassId(packageFqName13, FqNamesUtilKt.tail(fqName8, packageFqName14), false);
        ClassId createNestedClassId = ClassId.topLevel(fqName7).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        FqName fqName9 = StandardNames.FqNames.mutableMapEntry;
        FqName packageFqName15 = createNestedClassId.getPackageFqName();
        FqName packageFqName16 = createNestedClassId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        List<PlatformMutabilityMapping> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(javaToKotlinClassMap.e(Iterable.class), classId3, classId4), new PlatformMutabilityMapping(javaToKotlinClassMap.e(Iterator.class), classId5, classId6), new PlatformMutabilityMapping(javaToKotlinClassMap.e(Collection.class), classId7, classId8), new PlatformMutabilityMapping(javaToKotlinClassMap.e(List.class), classId9, classId10), new PlatformMutabilityMapping(javaToKotlinClassMap.e(Set.class), classId11, classId12), new PlatformMutabilityMapping(javaToKotlinClassMap.e(ListIterator.class), classId13, classId14), new PlatformMutabilityMapping(javaToKotlinClassMap.e(Map.class), classId15, classId16), new PlatformMutabilityMapping(javaToKotlinClassMap.e(Map.Entry.class), createNestedClassId, new ClassId(packageFqName15, FqNamesUtilKt.tail(fqName9, packageFqName16), false))});
        l = listOf;
        javaToKotlinClassMap.d(Object.class, StandardNames.FqNames.any);
        javaToKotlinClassMap.d(String.class, StandardNames.FqNames.string);
        javaToKotlinClassMap.d(CharSequence.class, StandardNames.FqNames.charSequence);
        javaToKotlinClassMap.c(Throwable.class, StandardNames.FqNames.throwable);
        javaToKotlinClassMap.d(Cloneable.class, StandardNames.FqNames.cloneable);
        javaToKotlinClassMap.d(Number.class, StandardNames.FqNames.number);
        javaToKotlinClassMap.c(Comparable.class, StandardNames.FqNames.comparable);
        javaToKotlinClassMap.d(Enum.class, StandardNames.FqNames._enum);
        javaToKotlinClassMap.c(Annotation.class, StandardNames.FqNames.annotation);
        for (PlatformMutabilityMapping platformMutabilityMapping : listOf) {
            JavaToKotlinClassMap javaToKotlinClassMap2 = INSTANCE;
            Objects.requireNonNull(javaToKotlinClassMap2);
            ClassId component1 = platformMutabilityMapping.component1();
            ClassId component2 = platformMutabilityMapping.component2();
            ClassId component3 = platformMutabilityMapping.component3();
            javaToKotlinClassMap2.a(component1, component2);
            FqName asSingleFqName2 = component3.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName2, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> hashMap = i;
            FqNameUnsafe unsafe = asSingleFqName2.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
            hashMap.put(unsafe, component1);
            FqName asSingleFqName3 = component2.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName3, "readOnlyClassId.asSingleFqName()");
            FqName asSingleFqName4 = component3.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName4, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, FqName> hashMap2 = j;
            FqNameUnsafe unsafe2 = component3.asSingleFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe2, "mutableClassId.asSingleFqName().toUnsafe()");
            hashMap2.put(unsafe2, asSingleFqName3);
            HashMap<FqNameUnsafe, FqName> hashMap3 = k;
            FqNameUnsafe unsafe3 = asSingleFqName3.toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe3, "readOnlyFqName.toUnsafe()");
            hashMap3.put(unsafe3, asSingleFqName4);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int i3 = 0;
        while (i3 < 8) {
            JvmPrimitiveType jvmPrimitiveType = values[i3];
            i3++;
            JavaToKotlinClassMap javaToKotlinClassMap3 = INSTANCE;
            ClassId classId17 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics.checkNotNullExpressionValue(classId17, "topLevel(jvmType.wrapperFqName)");
            StandardNames standardNames = StandardNames.INSTANCE;
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            ClassId classId18 = ClassId.topLevel(StandardNames.getPrimitiveFqName(primitiveType));
            Intrinsics.checkNotNullExpressionValue(classId18, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            javaToKotlinClassMap3.a(classId17, classId18);
        }
        for (ClassId classId19 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            JavaToKotlinClassMap javaToKotlinClassMap4 = INSTANCE;
            StringBuilder L = a.L("kotlin.jvm.internal.");
            L.append(classId19.getShortClassName().asString());
            L.append("CompanionObject");
            ClassId classId20 = ClassId.topLevel(new FqName(L.toString()));
            Intrinsics.checkNotNullExpressionValue(classId20, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            ClassId createNestedClassId2 = classId19.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            javaToKotlinClassMap4.a(classId20, createNestedClassId2);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            JavaToKotlinClassMap javaToKotlinClassMap5 = INSTANCE;
            ClassId classId21 = ClassId.topLevel(new FqName(Intrinsics.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            Intrinsics.checkNotNullExpressionValue(classId21, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            StandardNames standardNames2 = StandardNames.INSTANCE;
            javaToKotlinClassMap5.a(classId21, StandardNames.getFunctionClassId(i4));
            javaToKotlinClassMap5.b(new FqName(Intrinsics.stringPlus(b, Integer.valueOf(i4))), g);
            if (i5 >= 23) {
                break;
            }
            i4 = i5;
        }
        while (true) {
            int i6 = i2 + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.KSuspendFunction;
            JavaToKotlinClassMap javaToKotlinClassMap6 = INSTANCE;
            javaToKotlinClassMap6.b(new FqName(Intrinsics.stringPlus(functionClassKind5.getPackageFqName().toString() + FormatterType.defaultDecimalSeparator + functionClassKind5.getClassNamePrefix(), Integer.valueOf(i2))), g);
            if (i6 >= 22) {
                FqName safe = StandardNames.FqNames.nothing.toSafe();
                Intrinsics.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                javaToKotlinClassMap6.b(safe, javaToKotlinClassMap6.e(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    public final void a(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> hashMap = h;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(unsafe, classId2);
        FqName asSingleFqName = classId2.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "kotlinClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, ClassId> hashMap2 = i;
        FqNameUnsafe unsafe2 = asSingleFqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap2.put(unsafe2, classId);
    }

    public final void b(FqName fqName, ClassId classId) {
        HashMap<FqNameUnsafe, ClassId> hashMap = i;
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(unsafe, classId);
    }

    public final void c(Class<?> cls, FqName fqName) {
        ClassId e2 = e(cls);
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(kotlinFqName)");
        a(e2, classId);
    }

    public final void d(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        c(cls, safe);
    }

    public final ClassId e(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(clazz.canonicalName))");
            return classId;
        }
        ClassId createNestedClassId = e(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return createNestedClassId;
    }

    public final boolean f(FqNameUnsafe fqNameUnsafe, String str) {
        Integer intOrNull;
        String asString = fqNameUnsafe.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "kotlinFqName.asString()");
        String substringAfter = StringsKt__StringsKt.substringAfter(asString, str, "");
        if (!(substringAfter.length() > 0) || StringsKt__StringsKt.startsWith$default((CharSequence) substringAfter, '0', false, 2, (Object) null) || (intOrNull = l.toIntOrNull(substringAfter)) == null || intOrNull.intValue() < 23) {
            return false;
        }
        return true;
    }

    @NotNull
    public final FqName getFUNCTION_N_FQ_NAME() {
        return f;
    }

    @NotNull
    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return l;
    }

    public final boolean isMutable(@Nullable FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> hashMap = j;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(@Nullable FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> hashMap = k;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(fqNameUnsafe);
    }

    @Nullable
    public final ClassId mapJavaToKotlin(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return h.get(fqName.toUnsafe());
    }

    @Nullable
    public final ClassId mapKotlinToJava(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "kotlinFqName");
        if (f(fqNameUnsafe, a)) {
            return e;
        }
        if (f(fqNameUnsafe, c)) {
            return e;
        }
        if (f(fqNameUnsafe, b)) {
            return g;
        }
        if (f(fqNameUnsafe, d)) {
            return g;
        }
        return i.get(fqNameUnsafe);
    }

    @Nullable
    public final FqName mutableToReadOnly(@Nullable FqNameUnsafe fqNameUnsafe) {
        return j.get(fqNameUnsafe);
    }

    @Nullable
    public final FqName readOnlyToMutable(@Nullable FqNameUnsafe fqNameUnsafe) {
        return k.get(fqNameUnsafe);
    }
}
