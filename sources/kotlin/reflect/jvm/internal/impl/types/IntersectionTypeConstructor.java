package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.o.a;
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    @Nullable
    public KotlinType a;
    @NotNull
    public final LinkedHashSet<KotlinType> b;
    public final int c;

    public static final class a extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
        public final /* synthetic */ IntersectionTypeConstructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(IntersectionTypeConstructor intersectionTypeConstructor) {
            super(1);
            this.a = intersectionTypeConstructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            return this.a.refine(kotlinTypeRefiner2).createType();
        }
    }

    public IntersectionTypeConstructor(@NotNull Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    @NotNull
    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.b);
    }

    @NotNull
    public final SimpleType createType() {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), this, CollectionsKt__CollectionsKt.emptyList(), false, createScopeForKotlinType(), new a(this));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual(this.b, ((IntersectionTypeConstructor) obj).b);
    }

    @Nullable
    public final KotlinType getAlternativeType() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.b.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
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

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        return this.b;
    }

    public int hashCode() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public final IntersectionTypeConstructor setAlternative(@Nullable KotlinType kotlinType) {
        IntersectionTypeConstructor intersectionTypeConstructor = new IntersectionTypeConstructor(this.b);
        intersectionTypeConstructor.a = kotlinType;
        return intersectionTypeConstructor;
    }

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.sortedWith(this.b, new Comparator<T>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(t.toString(), t2.toString());
            }
        }), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public IntersectionTypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<KotlinType> supertypes = getSupertypes();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(it.next().mo988refine(kotlinTypeRefiner));
            z = true;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        KotlinType kotlinType = null;
        if (z) {
            KotlinType alternativeType = getAlternativeType();
            if (alternativeType != null) {
                kotlinType = alternativeType.mo988refine(kotlinTypeRefiner);
            }
            intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).setAlternative(kotlinType);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }
}
