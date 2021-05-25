package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.NoArgKodeinBinding;
import t6.n.e;
import x6.d.a.n.f;
import x6.d.a.n.g;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u0006B=\u0012\u000e\u0010)\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000f\u0012\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u000f\u0012\u0014\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u000f¢\u0006\u0004\b*\u0010+JO\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013RV\u0010\u001e\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u00160\u0015j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u0016`\u00178\u0010@\u0010X\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR4\u0010$\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0011R$\u0010)\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013¨\u0006,"}, d2 = {"Lorg/kodein/di/bindings/SetBinding;", "C", "", "T", "Lorg/kodein/di/bindings/NoArgKodeinBinding;", "", "Lorg/kodein/di/bindings/BaseMultiBinding;", "", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "Lorg/kodein/di/TypeToken;", "e", "Lorg/kodein/di/TypeToken;", "getCreatedType", "()Lorg/kodein/di/TypeToken;", "createdType", "Ljava/util/LinkedHashSet;", "Lorg/kodein/di/bindings/KodeinBinding;", "Lkotlin/collections/LinkedHashSet;", AuthSource.SEND_ABUSE, "Ljava/util/LinkedHashSet;", "getSet$kodein_di_core", "()Ljava/util/LinkedHashSet;", "set$annotations", "()V", "set", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "getCopier", "()Lorg/kodein/di/bindings/KodeinBinding$Copier;", "copier", "d", "_elementType", "c", "getContextType", "contextType", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class SetBinding<C, T> extends BaseMultiBinding<C, Unit, T> implements NoArgKodeinBinding<C, Set<? extends T>> {
    @NotNull
    public final LinkedHashSet<KodeinBinding<C, Unit, T>> a = new LinkedHashSet<>();
    @NotNull
    public final KodeinBinding.Copier<C, Unit, Set<T>> b = KodeinBinding.Copier.Companion.invoke(new a(this));
    @NotNull
    public final TypeToken<? super C> c;
    public final TypeToken<? extends T> d;
    @NotNull
    public final TypeToken<? extends Set<T>> e;

    public static final class a extends Lambda implements Function1<KodeinContainer.Builder, SetBinding<C, T>> {
        public final /* synthetic */ SetBinding a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SetBinding setBinding) {
            super(1);
            this.a = setBinding;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [org.kodein.di.bindings.KodeinBinding] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(org.kodein.di.KodeinContainer.Builder r7) {
            /*
                r6 = this;
                org.kodein.di.KodeinContainer$Builder r7 = (org.kodein.di.KodeinContainer.Builder) r7
                java.lang.String r0 = "builder"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
                org.kodein.di.bindings.SetBinding r0 = new org.kodein.di.bindings.SetBinding
                org.kodein.di.bindings.SetBinding r1 = r6.a
                org.kodein.di.TypeToken r1 = r1.getContextType()
                org.kodein.di.bindings.SetBinding r2 = r6.a
                org.kodein.di.TypeToken r2 = org.kodein.di.bindings.SetBinding.access$get_elementType$p(r2)
                org.kodein.di.bindings.SetBinding r3 = r6.a
                org.kodein.di.TypeToken r3 = r3.getCreatedType()
                r0.<init>(r1, r2, r3)
                java.util.LinkedHashSet r1 = r0.getSet$kodein_di_core()
                org.kodein.di.bindings.SetBinding r2 = r6.a
                java.util.LinkedHashSet r2 = r2.getSet$kodein_di_core()
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r4 = t6.n.e.collectionSizeOrDefault(r2, r4)
                r3.<init>(r4)
                java.util.Iterator r2 = r2.iterator()
            L_0x0037:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L_0x0054
                java.lang.Object r4 = r2.next()
                org.kodein.di.bindings.KodeinBinding r4 = (org.kodein.di.bindings.KodeinBinding) r4
                org.kodein.di.bindings.KodeinBinding$Copier r5 = r4.getCopier()
                if (r5 == 0) goto L_0x0050
                org.kodein.di.bindings.KodeinBinding r5 = r5.copy(r7)
                if (r5 == 0) goto L_0x0050
                r4 = r5
            L_0x0050:
                r3.add(r4)
                goto L_0x0037
            L_0x0054:
                r1.addAll(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.kodein.di.bindings.SetBinding.a.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b extends Lambda implements Function1<Unit, Set<? extends T>> {
        public final /* synthetic */ List a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(List list) {
            super(1);
            this.a = list;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Unit unit) {
            Intrinsics.checkParameterIsNotNull(unit, "it");
            return SequencesKt___SequencesKt.toSet(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.a), f.a));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.kodein.di.TypeToken<? extends java.util.Set<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public SetBinding(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? extends T> typeToken2, @NotNull TypeToken<? extends Set<? extends T>> typeToken3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "_elementType");
        Intrinsics.checkParameterIsNotNull(typeToken3, "createdType");
        this.c = typeToken;
        this.d = typeToken2;
        this.e = typeToken3;
    }

    public static /* synthetic */ void set$annotations() {
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return NoArgKodeinBinding.DefaultImpls.factoryFullName(this);
    }

    /* Return type fixed from 'org.kodein.di.TypeToken<kotlin.Unit>' to match base method */
    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super Unit> getArgType() {
        return NoArgKodeinBinding.DefaultImpls.getArgType(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.c;
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public KodeinBinding.Copier<C, Unit, Set<T>> getCopier() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends Set<T>> getCreatedType() {
        return this.e;
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return NoArgKodeinBinding.DefaultImpls.getDescription(this);
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<Unit, Set<T>> getFactory(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Kodein.Key<? super C, ? super Unit, ? extends Set<? extends T>> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        g gVar = new g(bindingKodein);
        Kodein.Key key2 = new Kodein.Key(key.getContextType(), TypeTokenKt.getUnitToken(), this.d, key.getTag());
        LinkedHashSet<KodeinBinding<C, Unit, T>> set$kodein_di_core = getSet$kodein_di_core();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set$kodein_di_core, 10));
        Iterator<T> it = set$kodein_di_core.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFactory(gVar, key2));
        }
        return new b(arrayList);
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return NoArgKodeinBinding.DefaultImpls.getFullDescription(this);
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    @Nullable
    public Scope<C> getScope() {
        return NoArgKodeinBinding.DefaultImpls.getScope(this);
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return NoArgKodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding
    @NotNull
    public LinkedHashSet<KodeinBinding<C, Unit, T>> getSet$kodein_di_core() {
        return this.a;
    }
}
