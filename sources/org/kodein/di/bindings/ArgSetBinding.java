package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.KodeinBinding;
import t6.n.e;
import x6.d.a.n.g;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005BM\u0012\u000e\u0010#\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000e\u0012\u000e\u0010)\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000e\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u000e\u0012\u0014\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u000e¢\u0006\u0004\b*\u0010+JO\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010RP\u0010\u0019\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00130\u0012j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0013`\u00148\u0010@\u0010X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R4\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\"R*\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\"R$\u0010)\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\"¨\u0006,"}, d2 = {"Lorg/kodein/di/bindings/ArgSetBinding;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/BaseMultiBinding;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "Lorg/kodein/di/TypeToken;", "e", "Lorg/kodein/di/TypeToken;", "_elementType", "Ljava/util/LinkedHashSet;", "Lorg/kodein/di/bindings/KodeinBinding;", "Lkotlin/collections/LinkedHashSet;", AuthSource.SEND_ABUSE, "Ljava/util/LinkedHashSet;", "getSet$kodein_di_core", "()Ljava/util/LinkedHashSet;", "set", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "getCopier", "()Lorg/kodein/di/bindings/KodeinBinding$Copier;", "copier", "c", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "f", "getCreatedType", "createdType", "d", "getArgType", "argType", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class ArgSetBinding<C, A, T> extends BaseMultiBinding<C, A, T> {
    @NotNull
    public final LinkedHashSet<KodeinBinding<C, A, T>> a = new LinkedHashSet<>();
    @NotNull
    public final KodeinBinding.Copier<C, A, Set<T>> b = KodeinBinding.Copier.Companion.invoke(new a(this));
    @NotNull
    public final TypeToken<? super C> c;
    @NotNull
    public final TypeToken<? super A> d;
    public final TypeToken<? extends T> e;
    @NotNull
    public final TypeToken<? extends Set<T>> f;

    public static final class a extends Lambda implements Function1<KodeinContainer.Builder, ArgSetBinding<C, A, T>> {
        public final /* synthetic */ ArgSetBinding a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ArgSetBinding argSetBinding) {
            super(1);
            this.a = argSetBinding;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(KodeinContainer.Builder builder) {
            KodeinBinding<C, A, T> copy;
            KodeinContainer.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "builder");
            ArgSetBinding argSetBinding = new ArgSetBinding(this.a.getContextType(), this.a.getArgType(), this.a.e, this.a.getCreatedType());
            LinkedHashSet<KodeinBinding<C, A, T>> set$kodein_di_core = argSetBinding.getSet$kodein_di_core();
            LinkedHashSet<KodeinBinding<C, A, T>> set$kodein_di_core2 = this.a.getSet$kodein_di_core();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set$kodein_di_core2, 10));
            for (T t : set$kodein_di_core2) {
                KodeinBinding.Copier<C, A, T> copier = t.getCopier();
                if (!(copier == null || (copy = copier.copy(builder2)) == null)) {
                    t = copy;
                }
                arrayList.add(t);
            }
            set$kodein_di_core.addAll(arrayList);
            return argSetBinding;
        }
    }

    public static final class b extends Lambda implements Function1<A, Set<? extends T>> {
        public final /* synthetic */ List a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(List list) {
            super(1);
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return SequencesKt___SequencesKt.toSet(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.a), new x6.d.a.n.a(obj)));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: org.kodein.di.TypeToken<? extends java.util.Set<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ArgSetBinding(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @NotNull TypeToken<? extends Set<? extends T>> typeToken4) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken3, "_elementType");
        Intrinsics.checkParameterIsNotNull(typeToken4, "createdType");
        this.c = typeToken;
        this.d = typeToken2;
        this.e = typeToken3;
        this.f = typeToken4;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super A> getArgType() {
        return this.d;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.c;
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public KodeinBinding.Copier<C, A, Set<T>> getCopier() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends Set<T>> getCreatedType() {
        return this.f;
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<A, Set<T>> getFactory(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Kodein.Key<? super C, ? super A, ? extends Set<? extends T>> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        g gVar = new g(bindingKodein);
        Kodein.Key<? super C, ? super A, ? extends T> key2 = new Kodein.Key<>(key.getContextType(), key.getArgType(), this.e, key.getTag());
        LinkedHashSet<KodeinBinding<C, A, T>> set$kodein_di_core = getSet$kodein_di_core();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set$kodein_di_core, 10));
        Iterator<T> it = set$kodein_di_core.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFactory(gVar, key2));
        }
        return new b(arrayList);
    }

    @Override // org.kodein.di.bindings.BaseMultiBinding
    @NotNull
    public LinkedHashSet<KodeinBinding<C, A, T>> getSet$kodein_di_core() {
        return this.a;
    }
}
