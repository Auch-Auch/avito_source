package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public abstract class AbstractTypeConstructor implements TypeConstructor {
    @NotNull
    public final NotNullLazyValue<b> a;

    public final class a implements TypeConstructor {
        @NotNull
        public final KotlinTypeRefiner a;
        @NotNull
        public final Lazy b;
        public final /* synthetic */ AbstractTypeConstructor c;

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$a$a  reason: collision with other inner class name */
        public static final class C0514a extends Lambda implements Function0<List<? extends KotlinType>> {
            public final /* synthetic */ a a;
            public final /* synthetic */ AbstractTypeConstructor b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0514a(a aVar, AbstractTypeConstructor abstractTypeConstructor) {
                super(0);
                this.a = aVar;
                this.b = abstractTypeConstructor;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends KotlinType> invoke() {
                return KotlinTypeRefinerKt.refineTypes(this.a.a, this.b.getSupertypes());
            }
        }

        public a(@NotNull AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(abstractTypeConstructor, "this$0");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.c = abstractTypeConstructor;
            this.a = kotlinTypeRefiner;
            this.b = t6.c.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new C0514a(this, abstractTypeConstructor));
        }

        public boolean equals(@Nullable Object obj) {
            return this.c.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.c.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo425getDeclarationDescriptor() {
            return this.c.mo425getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.c.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public Collection getSupertypes() {
            return (List) this.b.getValue();
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.c.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.c.refine(kotlinTypeRefiner);
        }

        @NotNull
        public String toString() {
            return this.c.toString();
        }
    }

    public static final class b {
        @NotNull
        public final Collection<KotlinType> a;
        @NotNull
        public List<? extends KotlinType> b = t6.n.d.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Collection<? extends KotlinType> collection) {
            Intrinsics.checkNotNullParameter(collection, "allSupertypes");
            this.a = collection;
        }
    }

    public static final class c extends Lambda implements Function0<b> {
        public final /* synthetic */ AbstractTypeConstructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AbstractTypeConstructor abstractTypeConstructor) {
            super(0);
            this.a = abstractTypeConstructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public b invoke() {
            return new b(this.a.computeSupertypes());
        }
    }

    public static final class d extends Lambda implements Function1<Boolean, b> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public b invoke(Boolean bool) {
            bool.booleanValue();
            return new b(t6.n.d.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES));
        }
    }

    public static final class e extends Lambda implements Function1<b, Unit> {
        public final /* synthetic */ AbstractTypeConstructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(AbstractTypeConstructor abstractTypeConstructor) {
            super(1);
            this.a = abstractTypeConstructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(b bVar) {
            b bVar2 = bVar;
            Intrinsics.checkNotNullParameter(bVar2, "supertypes");
            SupertypeLoopChecker supertypeLoopChecker = this.a.getSupertypeLoopChecker();
            AbstractTypeConstructor abstractTypeConstructor = this.a;
            Collection<KotlinType> findLoopsInSupertypesAndDisconnect = supertypeLoopChecker.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, bVar2.a, new t6.w.f.a.m.j.c(abstractTypeConstructor), new t6.w.f.a.m.j.d(this.a));
            List<KotlinType> list = null;
            if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
                KotlinType defaultSupertypeIfEmpty = this.a.defaultSupertypeIfEmpty();
                findLoopsInSupertypesAndDisconnect = defaultSupertypeIfEmpty == null ? null : t6.n.d.listOf(defaultSupertypeIfEmpty);
                if (findLoopsInSupertypesAndDisconnect == null) {
                    findLoopsInSupertypesAndDisconnect = CollectionsKt__CollectionsKt.emptyList();
                }
            }
            if (this.a.getShouldReportCyclicScopeWithCompanionWarning()) {
                SupertypeLoopChecker supertypeLoopChecker2 = this.a.getSupertypeLoopChecker();
                AbstractTypeConstructor abstractTypeConstructor2 = this.a;
                supertypeLoopChecker2.findLoopsInSupertypesAndDisconnect(abstractTypeConstructor2, findLoopsInSupertypesAndDisconnect, new t6.w.f.a.m.j.a(abstractTypeConstructor2), new t6.w.f.a.m.j.b(this.a));
            }
            AbstractTypeConstructor abstractTypeConstructor3 = this.a;
            if (findLoopsInSupertypesAndDisconnect instanceof List) {
                list = (List) findLoopsInSupertypesAndDisconnect;
            }
            if (list == null) {
                list = CollectionsKt___CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
            }
            List<KotlinType> processSupertypesWithoutCycles = abstractTypeConstructor3.processSupertypesWithoutCycles(list);
            Intrinsics.checkNotNullParameter(processSupertypesWithoutCycles, "<set-?>");
            bVar2.b = processSupertypesWithoutCycles;
            return Unit.INSTANCE;
        }
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.a = storageManager.createLazyValueWithPostCompute(new c(this), d.a, new e(this));
    }

    public static final Collection access$computeNeighbours(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor typeConstructor, boolean z) {
        Objects.requireNonNull(abstractTypeConstructor);
        List list = null;
        AbstractTypeConstructor abstractTypeConstructor2 = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        if (abstractTypeConstructor2 != null) {
            list = CollectionsKt___CollectionsKt.plus((Collection) ((b) abstractTypeConstructor2.a.invoke()).a, (Iterable) abstractTypeConstructor2.getAdditionalNeighboursInSupertypeGraph(z));
        }
        if (list != null) {
            return list;
        }
        Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    @NotNull
    public abstract Collection<KotlinType> computeSupertypes();

    @Nullable
    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    @NotNull
    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo425getDeclarationDescriptor();

    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return false;
    }

    @NotNull
    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    @NotNull
    public List<KotlinType> processSupertypesWithoutCycles(@NotNull List<KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "supertypes");
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    public void reportScopesLoopError(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    public void reportSupertypeLoopError(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType>, java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public List<KotlinType> getSupertypes() {
        return ((b) this.a.invoke()).b;
    }
}
