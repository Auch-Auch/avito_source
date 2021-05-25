package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
import t6.w.f.a.m.j.j.c;
public final class TypeIntersector {
    @NotNull
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final /* synthetic */ a[] e;

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$a$a  reason: collision with other inner class name */
        public static final class C0515a extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public C0515a(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.a
            @NotNull
            public a a(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return b(unwrappedType);
            }
        }

        public static final class b extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.a
            public a a(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return this;
            }
        }

        public static final class c extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.a
            @NotNull
            public a a(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                return b(unwrappedType);
            }
        }

        public static final class d extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.a
            @NotNull
            public a a(@NotNull UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "nextType");
                a b = b(unwrappedType);
                return b == a.b ? this : b;
            }
        }

        static {
            c cVar = new c("START", 0);
            a = cVar;
            C0515a aVar = new C0515a("ACCEPT_NULL", 1);
            b = aVar;
            d dVar = new d("UNKNOWN", 2);
            c = dVar;
            b bVar = new b("NOT_NULL", 3);
            d = bVar;
            e = new a[]{cVar, aVar, dVar, bVar};
        }

        public a(String str, int i, j jVar) {
        }

        public static a valueOf(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = e;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        @NotNull
        public abstract a a(@NotNull UnwrappedType unwrappedType);

        @NotNull
        public final a b(@NotNull UnwrappedType unwrappedType) {
            Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
            if (unwrappedType.isMarkedNullable()) {
                return b;
            }
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) {
                return d;
            }
            return c;
        }
    }

    public static final boolean access$isStrictSupertype(TypeIntersector typeIntersector, KotlinType kotlinType, KotlinType kotlinType2) {
        Objects.requireNonNull(typeIntersector);
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        return newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> a(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r8, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
        L_0x000e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0058
            java.lang.Object r1 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            boolean r2 = r0.isEmpty()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0023
            goto L_0x0052
        L_0x0023:
            java.util.Iterator r2 = r0.iterator()
        L_0x0027:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0052
            java.lang.Object r5 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r5
            if (r5 == r1) goto L_0x004e
            java.lang.String r6 = "lower"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = "upper"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            java.lang.Object r5 = r9.invoke(r5, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x004e
            r5 = 1
            goto L_0x004f
        L_0x004e:
            r5 = 0
        L_0x004f:
            if (r5 == 0) goto L_0x0027
            r3 = 1
        L_0x0052:
            if (r3 == 0) goto L_0x000e
            r8.remove()
            goto L_0x000e
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.a(java.util.Collection, kotlin.jvm.functions.Function2):java.util.Collection");
    }

    @NotNull
    public final SimpleType intersectTypes$descriptors(@NotNull List<? extends SimpleType> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<UnwrappedType> arrayList = new ArrayList();
        for (SimpleType simpleType : list) {
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> supertypes = simpleType.getConstructor().getSupertypes();
                Intrinsics.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(supertypes, 10));
                for (T t : supertypes) {
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(t);
                    if (simpleType.isMarkedNullable()) {
                        upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(upperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        a aVar = a.a;
        for (UnwrappedType unwrappedType : arrayList) {
            aVar = aVar.a(unwrappedType);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SimpleType simpleType2 = (SimpleType) it.next();
            if (aVar == a.d) {
                if (simpleType2 instanceof NewCapturedType) {
                    simpleType2 = SpecialTypesKt.withNotNullProjection((NewCapturedType) simpleType2);
                }
                simpleType2 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(simpleType2, false, 1, null);
            }
            linkedHashSet.add(simpleType2);
        }
        if (linkedHashSet.size() == 1) {
            return (SimpleType) CollectionsKt___CollectionsKt.single(linkedHashSet);
        }
        new c(linkedHashSet);
        Collection<SimpleType> a3 = a(linkedHashSet, new Function2<KotlinType, KotlinType, Boolean>(this) { // from class: t6.w.f.a.m.j.j.d
            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            @NotNull
            public final String getName() {
                return "isStrictSupertype";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(TypeIntersector.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final String getSignature() {
                return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
                KotlinType kotlinType3 = kotlinType;
                KotlinType kotlinType4 = kotlinType2;
                Intrinsics.checkNotNullParameter(kotlinType3, "p0");
                Intrinsics.checkNotNullParameter(kotlinType4, "p1");
                return Boolean.valueOf(TypeIntersector.access$isStrictSupertype((TypeIntersector) this.receiver, kotlinType3, kotlinType4));
            }
        });
        ((ArrayList) a3).isEmpty();
        SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(a3);
        if (findIntersectionType != null) {
            return findIntersectionType;
        }
        Collection<SimpleType> a4 = a(a3, new Function2<KotlinType, KotlinType, Boolean>(NewKotlinTypeChecker.Companion.getDefault()) { // from class: t6.w.f.a.m.j.j.e
            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            @NotNull
            public final String getName() {
                return "equalTypes";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(NewKotlinTypeCheckerImpl.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final String getSignature() {
                return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
                KotlinType kotlinType3 = kotlinType;
                KotlinType kotlinType4 = kotlinType2;
                Intrinsics.checkNotNullParameter(kotlinType3, "p0");
                Intrinsics.checkNotNullParameter(kotlinType4, "p1");
                return Boolean.valueOf(((NewKotlinTypeCheckerImpl) this.receiver).equalTypes(kotlinType3, kotlinType4));
            }
        });
        ArrayList arrayList3 = (ArrayList) a4;
        arrayList3.isEmpty();
        if (arrayList3.size() < 2) {
            return (SimpleType) CollectionsKt___CollectionsKt.single(a4);
        }
        return new IntersectionTypeConstructor(linkedHashSet).createType();
    }
}
