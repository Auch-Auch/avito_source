package kotlin.jvm.internal;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.q;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0013\u0012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0018¢\u0006\u0004\bN\u0010OJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0016\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011R \u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001e\u0010*\u001a\u0004\u0018\u00010&8V@\u0017X\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0013\u001a\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000fR \u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0-8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\"\u00105\u001a\b\u0012\u0004\u0012\u0002020\u001e8V@\u0017X\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0013\u001a\u0004\b3\u0010!R\u001c\u00106\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0013\u001a\u0004\b6\u0010\u0011R\u001c\u00108\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0013\u001a\u0004\b8\u0010\u0011R\u001c\u0010:\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0013\u001a\u0004\b:\u0010\u0011R\"\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020<0-8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b=\u00100R*\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001e8V@\u0017X\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0013\u001a\u0004\b?\u0010!R\u001c\u0010B\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0013\u001a\u0004\bB\u0010\u0011R\"\u0010G\u001a\b\u0012\u0004\u0012\u00020D0\u001e8V@\u0017X\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0013\u001a\u0004\bE\u0010!R\u0018\u0010I\u001a\u0004\u0018\u00010\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u000fR\u001c\u0010J\u001a\u00020\u00058V@\u0017X\u0004¢\u0006\f\u0012\u0004\bK\u0010\u0013\u001a\u0004\bJ\u0010\u0011R \u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010-8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bL\u00100¨\u0006Q"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "value", "", "isInstance", "(Ljava/lang/Object;)Z", "other", "equals", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isFun", "isFun$annotations", "isSealed", "isSealed$annotations", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "jClass", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getQualifiedName", "qualifiedName", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "getTypeParameters$annotations", "typeParameters", "isOpen", "isOpen$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "Lkotlin/reflect/KFunction;", "getConstructors", "constructors", "getSealedSubclasses", "getSealedSubclasses$annotations", "sealedSubclasses", DecodeProducer.EXTRA_IS_FINAL, "isFinal$annotations", "Lkotlin/reflect/KType;", "getSupertypes", "getSupertypes$annotations", "supertypes", "getSimpleName", "simpleName", "isCompanion", "isCompanion$annotations", "getNestedClasses", "nestedClasses", "<init>", "(Ljava/lang/Class;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final Map<Class<? extends Function<?>>, Integer> b;
    public static final HashMap<String, String> c;
    public static final HashMap<String, String> d;
    public static final HashMap<String, String> e;
    public static final Map<String, String> f;
    @NotNull
    public final Class<?> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\u0002\u0012\u0004\u0012\u00020\u000e0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R2\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R2\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R2\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "Ljava/lang/Class;", "jClass", "", "getClassSimpleName", "(Ljava/lang/Class;)Ljava/lang/String;", "getClassQualifiedName", "value", "", "isInstance", "(Ljava/lang/Object;Ljava/lang/Class;)Z", "", "Lkotlin/Function;", "", "FUNCTION_CLASSES", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "classFqNames", "Ljava/util/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @Nullable
        public final String getClassQualifiedName(@NotNull Class<?> cls) {
            String str;
            Intrinsics.checkNotNullParameter(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) ClassReference.e.get(componentType.getName())) != null) {
                    str2 = a.c3(str, "Array");
                }
                if (str2 != null) {
                    return str2;
                }
                return "kotlin.Array";
            }
            String str3 = (String) ClassReference.e.get(cls.getName());
            return str3 != null ? str3 : cls.getCanonicalName();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
            if (r1 != null) goto L_0x0066;
         */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getClassSimpleName(@org.jetbrains.annotations.NotNull java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L_0x0011
            L_0x000e:
                r1 = r2
                goto L_0x00b6
            L_0x0011:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L_0x0073
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L_0x0043
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L_0x0043
                goto L_0x0066
            L_0x0043:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L_0x0065
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r8, r2, r4, r2)
                r1 = r8
                goto L_0x0066
            L_0x0065:
                r1 = r2
            L_0x0066:
                if (r1 == 0) goto L_0x0069
                goto L_0x00b6
            L_0x0069:
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                r8 = 36
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r8, r2, r4, r2)
                goto L_0x00b6
            L_0x0073:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L_0x00a0
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto L_0x009c
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.access$getSimpleNames$cp()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L_0x009c
                java.lang.String r2 = a2.b.a.a.a.c3(r8, r1)
            L_0x009c:
                if (r2 == 0) goto L_0x00b6
                goto L_0x000e
            L_0x00a0:
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.access$getSimpleNames$cp()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x00b2
                goto L_0x00b6
            L_0x00b2:
                java.lang.String r1 = r8.getSimpleName()
            L_0x00b6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.ClassReference.Companion.getClassSimpleName(java.lang.Class):java.lang.String");
        }

        public final boolean isInstance(@Nullable Object obj, @NotNull Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "jClass");
            Map map = ClassReference.b;
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return TypeIntrinsics.isFunctionOfArity(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(cls));
            }
            return cls.isInstance(obj);
        }

        public Companion(j jVar) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: java.util.HashMap<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(listOf, 10));
        for (Object obj : listOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = r.toMap(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Types.BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put(Types.INT, "kotlin.Int");
        hashMap.put(Types.FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "primitiveFqNames.values");
        for (T t : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.checkNotNullExpressionValue(t, "kotlinName");
            sb.append(StringsKt__StringsKt.substringAfterLast$default(t, (char) FormatterType.defaultDecimalSeparator, (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Pair pair = TuplesKt.to(sb2, ((String) t) + ".Companion");
            hashMap3.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : b.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        e = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.substringAfterLast$default((String) entry2.getValue(), (char) FormatterType.defaultDecimalSeparator, (String) null, 2, (Object) null));
        }
        f = linkedHashMap;
    }

    public ClassReference(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.a = cls;
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSupertypes$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getVisibility$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isAbstract$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isCompanion$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isData$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isFinal$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void isFun$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isInner$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isOpen$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isSealed$annotations() {
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public Object getObjectInstance() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    public boolean isInstance(@Nullable Object obj) {
        return Companion.isInstance(obj, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        throw new KotlinReflectionNotSupportedError();
    }

    @NotNull
    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
