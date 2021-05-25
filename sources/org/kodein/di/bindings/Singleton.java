package org.kodein.di.bindings;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeToken;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.NoArgKodeinBinding;
import t6.r.a.j;
import x6.d.a.n.e;
import x6.d.a.n.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004Bj\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000/\u0012\u000e\u0010(\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0015\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010.\u001a\u00020)\u0012\u001d\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0002\b\u001c¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007JC\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R0\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0002\b\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010(\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010\u0019R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R.\u0010:\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0001058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010?\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b\u0013\u0010<\u0012\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lorg/kodein/di/bindings/Singleton;", "C", "", "T", "Lorg/kodein/di/bindings/NoArgKodeinBinding;", "", "factoryName", "()Ljava/lang/String;", "factoryFullName", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "", "params", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", "f", "Lorg/kodein/di/TypeToken;", "getCreatedType", "()Lorg/kodein/di/TypeToken;", "createdType", "Lorg/kodein/di/bindings/NoArgSimpleBindingKodein;", "Lkotlin/ExtensionFunctionType;", "h", "Lkotlin/jvm/functions/Function1;", "getCreator", "()Lkotlin/jvm/functions/Function1;", "creator", "Lx6/d/a/n/e;", AuthSource.BOOKING_ORDER, "Lx6/d/a/n/e;", "_scopeKey", "e", "getContextType", "contextType", "", g.a, "Z", "getSync", "()Z", "sync", "Lorg/kodein/di/bindings/Scope;", "d", "Lorg/kodein/di/bindings/Scope;", "getScope", "()Lorg/kodein/di/bindings/Scope;", "scope", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "c", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "getCopier", "()Lorg/kodein/di/bindings/KodeinBinding$Copier;", "copier", "Lorg/kodein/di/bindings/RefMaker;", "Lorg/kodein/di/bindings/RefMaker;", "_refMaker$annotations", "()V", "_refMaker", "refMaker", "<init>", "(Lorg/kodein/di/bindings/Scope;Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Singleton<C, T> implements NoArgKodeinBinding<C, T> {
    public final RefMaker a;
    public final e<Unit> b;
    @NotNull
    public final KodeinBinding.Copier<C, Unit, T> c;
    @NotNull
    public final Scope<C> d;
    @NotNull
    public final TypeToken<? super C> e;
    @NotNull
    public final TypeToken<? extends T> f;
    public final boolean g;
    @NotNull
    public final Function1<NoArgSimpleBindingKodein<? extends C>, T> h;

    public static final class a extends Lambda implements Function1<KodeinContainer.Builder, Singleton<C, T>> {
        public final /* synthetic */ Singleton a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Singleton singleton) {
            super(1);
            this.a = singleton;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(KodeinContainer.Builder builder) {
            Intrinsics.checkParameterIsNotNull(builder, "it");
            return new Singleton(this.a.getScope(), this.a.getContextType(), this.a.getCreatedType(), this.a.a, this.a.getSync(), this.a.getCreator());
        }
    }

    public static final class b extends Lambda implements Function1<Unit, T> {
        public final /* synthetic */ Singleton a;
        public final /* synthetic */ ScopeRegistry b;
        public final /* synthetic */ BindingKodein c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Singleton singleton, ScopeRegistry scopeRegistry, BindingKodein bindingKodein) {
            super(1);
            this.a = singleton;
            this.b = scopeRegistry;
            this.c = bindingKodein;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Unit unit) {
            Intrinsics.checkParameterIsNotNull(unit, "it");
            Object orCreate = this.b.getOrCreate(this.a.b, this.a.getSync(), new i(this));
            if (orCreate != null) {
                return orCreate;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.bindings.Scope<? super C> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super org.kodein.di.bindings.NoArgSimpleBindingKodein<? extends C>, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Singleton(@NotNull Scope<? super C> scope, @NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? extends T> typeToken2, @Nullable RefMaker refMaker, boolean z, @NotNull Function1<? super NoArgSimpleBindingKodein<? extends C>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "createdType");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        this.d = scope;
        this.e = typeToken;
        this.f = typeToken2;
        this.g = z;
        this.h = function1;
        this.a = refMaker == null ? SingletonReference.INSTANCE : refMaker;
        this.b = new e<>(new Object(), Unit.INSTANCE);
        this.c = KodeinBinding.Copier.Companion.invoke(new a(this));
    }

    public final String a(List<String> list) {
        StringBuilder L = a2.b.a.a.a.L("singleton");
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

    /* Return type fixed from 'org.kodein.di.TypeToken<kotlin.Unit>' to match base method */
    @Override // org.kodein.di.bindings.NoArgKodeinBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super Unit> getArgType() {
        return NoArgKodeinBinding.DefaultImpls.getArgType(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.e;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public KodeinBinding.Copier<C, Unit, T> getCopier() {
        return this.c;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.f;
    }

    @NotNull
    public final Function1<NoArgSimpleBindingKodein<? extends C>, T> getCreator() {
        return this.h;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return NoArgKodeinBinding.DefaultImpls.getDescription(this);
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<Unit, T> getFactory(@NotNull BindingKodein<? extends C> bindingKodein, @NotNull Kodein.Key<? super C, ? super Unit, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new b(this, getScope().getRegistry((C) bindingKodein.getContext()), bindingKodein);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return NoArgKodeinBinding.DefaultImpls.getFullDescription(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public Scope<C> getScope() {
        return this.d;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return NoArgKodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }

    public final boolean getSync() {
        return this.g;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Singleton(Scope scope, TypeToken typeToken, TypeToken typeToken2, RefMaker refMaker, boolean z, Function1 function1, int i, j jVar) {
        this(scope, typeToken, typeToken2, (i & 8) != 0 ? null : refMaker, (i & 16) != 0 ? true : z, function1);
    }
}
