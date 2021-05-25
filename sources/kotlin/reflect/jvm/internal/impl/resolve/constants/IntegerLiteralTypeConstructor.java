package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.d;
import t6.r.a.j;
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final ModuleDescriptor b;
    @NotNull
    public final Set<KotlinType> c;
    @NotNull
    public final SimpleType d = KotlinTypeFactory.integerLiteralType(Annotations.Companion.getEMPTY(), this, false);
    @NotNull
    public final Lazy e = c.lazy(new a(this));

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2};

            static {
                a.values();
            }
        }

        public enum a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        public Companion() {
        }

        @Nullable
        public final SimpleType findIntersectionType(@NotNull Collection<? extends SimpleType> collection) {
            Intrinsics.checkNotNullParameter(collection, "types");
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                SimpleType next = it.next();
                while (it.hasNext()) {
                    T next2 = it.next();
                    next = next;
                    if (!(next == null || next2 == null)) {
                        TypeConstructor constructor = next.getConstructor();
                        TypeConstructor constructor2 = next2.getConstructor();
                        boolean z = constructor instanceof IntegerLiteralTypeConstructor;
                        if (z && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                            IntegerLiteralTypeConstructor integerLiteralTypeConstructor = (IntegerLiteralTypeConstructor) constructor;
                            IntegerLiteralTypeConstructor integerLiteralTypeConstructor2 = new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.a, integerLiteralTypeConstructor.b, CollectionsKt___CollectionsKt.union(integerLiteralTypeConstructor.getPossibleTypes(), ((IntegerLiteralTypeConstructor) constructor2).getPossibleTypes()), null);
                            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                            next = KotlinTypeFactory.integerLiteralType(Annotations.Companion.getEMPTY(), integerLiteralTypeConstructor2, false);
                        } else if (z) {
                            if (((IntegerLiteralTypeConstructor) constructor).getPossibleTypes().contains(next2)) {
                                next = next2;
                            }
                        } else if ((constructor2 instanceof IntegerLiteralTypeConstructor) && ((IntegerLiteralTypeConstructor) constructor2).getPossibleTypes().contains(next)) {
                        }
                    }
                    next = null;
                }
                return next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<List<SimpleType>> {
        public final /* synthetic */ IntegerLiteralTypeConstructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
            super(0);
            this.a = integerLiteralTypeConstructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<SimpleType> invoke() {
            SimpleType defaultType = this.a.getBuiltIns().getComparable().getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
            List<SimpleType> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(TypeSubstitutionKt.replace$default(defaultType, d.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, this.a.d)), null, 2, null));
            if (!IntegerLiteralTypeConstructor.access$isContainsOnlyUnsignedTypes(this.a)) {
                mutableListOf.add(this.a.getBuiltIns().getNumberType());
            }
            return mutableListOf;
        }
    }

    public IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set set, j jVar) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        this.a = j;
        this.b = moduleDescriptor;
        this.c = set;
    }

    public static final boolean access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        Collection<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(integerLiteralTypeConstructor.b);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!integerLiteralTypeConstructor.getPossibleTypes().contains(it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkConstructor(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Set<KotlinType> set = this.c;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getConstructor(), typeConstructor)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.b.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @Nullable
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo425getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public final Set<KotlinType> getPossibleTypes() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return (List) this.e.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public String toString() {
        StringBuilder I = a2.b.a.a.a.I('[');
        I.append(CollectionsKt___CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, t6.w.f.a.m.g.f.a.a, 30, null));
        I.append(']');
        return Intrinsics.stringPlus("IntegerLiteralType", I.toString());
    }
}
