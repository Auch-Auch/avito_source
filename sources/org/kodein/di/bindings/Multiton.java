package org.kodein.di.bindings;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeToken;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.KodeinBinding;
import t6.r.a.j;
import x6.d.a.n.d;
import x6.d.a.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\b\b\u0002\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B\u0001\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000$\u0012\u000e\u0010,\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0015\u0012\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u0015\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012#\u00102\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020-¢\u0006\u0002\b/¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJC\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010,\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R3\u00102\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000.\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020-¢\u0006\u0002\b/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R.\u0010;\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010=¨\u0006B"}, d2 = {"Lorg/kodein/di/bindings/Multiton;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/bindings/KodeinBinding;", "", "factoryName", "()Ljava/lang/String;", "factoryFullName", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "", "params", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", "f", "Lorg/kodein/di/TypeToken;", "getArgType", "()Lorg/kodein/di/TypeToken;", "argType", g.a, "getCreatedType", "createdType", "", "h", "Z", "getSync", "()Z", "sync", "Lorg/kodein/di/bindings/Scope;", "d", "Lorg/kodein/di/bindings/Scope;", "getScope", "()Lorg/kodein/di/bindings/Scope;", "scope", "e", "getContextType", "contextType", "Lkotlin/Function2;", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lkotlin/ExtensionFunctionType;", "i", "Lkotlin/jvm/functions/Function2;", "creator", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "_scopeId", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "c", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "getCopier", "()Lorg/kodein/di/bindings/KodeinBinding$Copier;", "copier", "Lorg/kodein/di/bindings/RefMaker;", "Lorg/kodein/di/bindings/RefMaker;", "_refMaker", "refMaker", "<init>", "(Lorg/kodein/di/bindings/Scope;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function2;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Multiton<C, A, T> implements KodeinBinding<C, A, T> {
    public final RefMaker a;
    public final Object b;
    @NotNull
    public final KodeinBinding.Copier<C, A, T> c;
    @NotNull
    public final Scope<C> d;
    @NotNull
    public final TypeToken<? super C> e;
    @NotNull
    public final TypeToken<? super A> f;
    @NotNull
    public final TypeToken<? extends T> g;
    public final boolean h;
    public final Function2<SimpleBindingKodein<? extends C>, A, T> i;

    public static final class a extends Lambda implements Function1<KodeinContainer.Builder, Multiton<C, A, T>> {
        public final /* synthetic */ Multiton a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Multiton multiton) {
            super(1);
            this.a = multiton;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(KodeinContainer.Builder builder) {
            Intrinsics.checkParameterIsNotNull(builder, "it");
            return new Multiton(this.a.getScope(), this.a.getContextType(), this.a.getArgType(), this.a.getCreatedType(), this.a.a, this.a.getSync(), this.a.i);
        }
    }

    public static final class b extends Lambda implements Function1<A, T> {
        public final /* synthetic */ Multiton a;
        public final /* synthetic */ ScopeRegistry b;
        public final /* synthetic */ BindingKodein c;

        public static final class a extends Lambda implements Function0<Reference<? extends T>> {
            public final /* synthetic */ b a;
            public final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, Object obj) {
                super(0);
                this.a = bVar;
                this.b = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.a.a.a.make(new d(this));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Multiton multiton, ScopeRegistry scopeRegistry, BindingKodein bindingKodein) {
            super(1);
            this.a = multiton;
            this.b = scopeRegistry;
            this.c = bindingKodein;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final T invoke(A a3) {
            T t = (T) this.b.getOrCreate(new e(this.a.b, a3), this.a.getSync(), new a(this, a3));
            if (t != null) {
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.bindings.Scope<? super C> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function2<? super org.kodein.di.bindings.SimpleBindingKodein<? extends C>, ? super A, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Multiton(@NotNull Scope<? super C> scope, @NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super A> typeToken2, @NotNull TypeToken<? extends T> typeToken3, @Nullable RefMaker refMaker, boolean z, @NotNull Function2<? super SimpleBindingKodein<? extends C>, ? super A, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken3, "createdType");
        Intrinsics.checkParameterIsNotNull(function2, "creator");
        this.d = scope;
        this.e = typeToken;
        this.f = typeToken2;
        this.g = typeToken3;
        this.h = z;
        this.i = function2;
        this.a = refMaker == null ? SingletonReference.INSTANCE : refMaker;
        this.b = new Object();
        this.c = KodeinBinding.Copier.Companion.invoke(new a(this));
    }

    public final String a(List<String> list) {
        StringBuilder L = a2.b.a.a.a.L("multiton");
        if (!list.isEmpty()) {
            L.append(CollectionsKt___CollectionsKt.joinToString$default(list, ", ", "(", ")", 0, null, null, 56, null));
        }
        String sb = L.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        ArrayList arrayList = new ArrayList(2);
        if (!Intrinsics.areEqual(this.a, SingletonReference.INSTANCE)) {
            StringBuilder L = a2.b.a.a.a.L("ref = ");
            L.append(TypesKt.TTOf(this.a).fullDispString());
            arrayList.add(L.toString());
        }
        return a(arrayList);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        ArrayList arrayList = new ArrayList(2);
        if (!Intrinsics.areEqual(this.a, SingletonReference.INSTANCE)) {
            StringBuilder L = a2.b.a.a.a.L("ref = ");
            L.append(TypesKt.TTOf(this.a).simpleDispString());
            arrayList.add(L.toString());
        }
        return a(arrayList);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super A> getArgType() {
        return this.f;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.e;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public KodeinBinding.Copier<C, A, T> getCopier() {
        return this.c;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.g;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return KodeinBinding.DefaultImpls.getDescription(this);
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<A, T> getFactory(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Kodein.Key<? super C, ? super A, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new b(this, getScope().getRegistry((C) bindingKodein.getContext()), bindingKodein);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return KodeinBinding.DefaultImpls.getFullDescription(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public Scope<C> getScope() {
        return this.d;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return KodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }

    public final boolean getSync() {
        return this.h;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Multiton(Scope scope, TypeToken typeToken, TypeToken typeToken2, TypeToken typeToken3, RefMaker refMaker, boolean z, Function2 function2, int i2, j jVar) {
        this(scope, typeToken, typeToken2, typeToken3, (i2 & 16) != 0 ? null : refMaker, (i2 & 32) != 0 ? true : z, function2);
    }
}
