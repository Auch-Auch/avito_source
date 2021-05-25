package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
public final class NewCapturedTypeConstructor implements CapturedTypeConstructor {
    @NotNull
    public final TypeProjection a;
    @Nullable
    public Function0<? extends List<? extends UnwrappedType>> b;
    @Nullable
    public final NewCapturedTypeConstructor c;
    @Nullable
    public final TypeParameterDescriptor d;
    @NotNull
    public final Lazy e;

    public static final class a extends Lambda implements Function0<List<? extends UnwrappedType>> {
        public final /* synthetic */ List<UnwrappedType> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(List<? extends UnwrappedType> list) {
            super(0);
            this.a = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends UnwrappedType> invoke() {
            return this.a;
        }
    }

    public static final class b extends Lambda implements Function0<List<? extends UnwrappedType>> {
        public final /* synthetic */ NewCapturedTypeConstructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NewCapturedTypeConstructor newCapturedTypeConstructor) {
            super(0);
            this.a = newCapturedTypeConstructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends UnwrappedType> invoke() {
            Function0 function0 = this.a.b;
            if (function0 == null) {
                return null;
            }
            return (List) function0.invoke();
        }
    }

    public static final class c extends Lambda implements Function0<List<? extends UnwrappedType>> {
        public final /* synthetic */ List<UnwrappedType> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(List<? extends UnwrappedType> list) {
            super(0);
            this.a = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends UnwrappedType> invoke() {
            return this.a;
        }
    }

    public static final class d extends Lambda implements Function0<List<? extends UnwrappedType>> {
        public final /* synthetic */ NewCapturedTypeConstructor a;
        public final /* synthetic */ KotlinTypeRefiner b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            super(0);
            this.a = newCapturedTypeConstructor;
            this.b = kotlinTypeRefiner;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends UnwrappedType> invoke() {
            List<UnwrappedType> supertypes = this.a.getSupertypes();
            KotlinTypeRefiner kotlinTypeRefiner = this.b;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(supertypes, 10));
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().mo988refine(kotlinTypeRefiner));
            }
            return arrayList;
        }
    }

    public NewCapturedTypeConstructor(@NotNull TypeProjection typeProjection, @Nullable Function0<? extends List<? extends UnwrappedType>> function0, @Nullable NewCapturedTypeConstructor newCapturedTypeConstructor, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeProjection, "projection");
        this.a = typeProjection;
        this.b = function0;
        this.c = newCapturedTypeConstructor;
        this.d = typeParameterDescriptor;
        this.e = t6.c.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new b(this));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(NewCapturedTypeConstructor.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedTypeConstructor newCapturedTypeConstructor = (NewCapturedTypeConstructor) obj;
        NewCapturedTypeConstructor newCapturedTypeConstructor2 = this.c;
        if (newCapturedTypeConstructor2 == null) {
            newCapturedTypeConstructor2 = this;
        }
        NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor.c;
        if (newCapturedTypeConstructor3 != null) {
            newCapturedTypeConstructor = newCapturedTypeConstructor3;
        }
        if (newCapturedTypeConstructor2 == newCapturedTypeConstructor) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinType type = getProjection().getType();
        Intrinsics.checkNotNullExpressionValue(type, "projection.type");
        return TypeUtilsKt.getBuiltIns(type);
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

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    @NotNull
    public TypeProjection getProjection() {
        return this.a;
    }

    public int hashCode() {
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.c;
        return newCapturedTypeConstructor == null ? super.hashCode() : newCapturedTypeConstructor.hashCode();
    }

    public final void initializeSupertypes(@NotNull List<? extends UnwrappedType> list) {
        Intrinsics.checkNotNullParameter(list, "supertypes");
        Function0<? extends List<? extends UnwrappedType>> function0 = this.b;
        this.b = new c(list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CapturedType(");
        L.append(getProjection());
        L.append(')');
        return L.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<UnwrappedType> getSupertypes() {
        List<UnwrappedType> list = (List) this.e.getValue();
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public NewCapturedTypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        d dVar;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "projection.refine(kotlinTypeRefiner)");
        if (this.b == null) {
            dVar = null;
        } else {
            dVar = new d(this, kotlinTypeRefiner);
        }
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.c;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        return new NewCapturedTypeConstructor(refine, dVar, newCapturedTypeConstructor, this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, Function0 function0, NewCapturedTypeConstructor newCapturedTypeConstructor, TypeParameterDescriptor typeParameterDescriptor, int i, j jVar) {
        this(typeProjection, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : newCapturedTypeConstructor, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, List list, NewCapturedTypeConstructor newCapturedTypeConstructor, int i, j jVar) {
        this(typeProjection, list, (i & 4) != 0 ? null : newCapturedTypeConstructor);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor(@NotNull TypeProjection typeProjection, @NotNull List<? extends UnwrappedType> list, @Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this(typeProjection, new a(list), newCapturedTypeConstructor, null, 8, null);
        Intrinsics.checkNotNullParameter(typeProjection, "projection");
        Intrinsics.checkNotNullParameter(list, "supertypes");
    }
}
