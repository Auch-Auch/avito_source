package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.GeoContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.NoArgKodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004BF\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0010\u0012\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0010\u0012\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0002\b\u001a¢\u0006\u0004\b \u0010!J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0018\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R0\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0002\b\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lorg/kodein/di/bindings/Provider;", "C", "", "T", "Lorg/kodein/di/bindings/NoArgKodeinBinding;", "", "factoryName", "()Ljava/lang/String;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "Lorg/kodein/di/TypeToken;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "getCreatedType", "()Lorg/kodein/di/TypeToken;", "createdType", AuthSource.SEND_ABUSE, "getContextType", "contextType", "Lorg/kodein/di/bindings/NoArgBindingKodein;", "Lkotlin/ExtensionFunctionType;", "c", "Lkotlin/jvm/functions/Function1;", "getCreator", "()Lkotlin/jvm/functions/Function1;", "creator", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Provider<C, T> implements NoArgKodeinBinding<C, T> {
    @NotNull
    public final TypeToken<? super C> a;
    @NotNull
    public final TypeToken<? extends T> b;
    @NotNull
    public final Function1<NoArgBindingKodein<? extends C>, T> c;

    public static final class a extends Lambda implements Function1<Unit, T> {
        public final /* synthetic */ Provider a;
        public final /* synthetic */ BindingKodein b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Provider provider, BindingKodein bindingKodein) {
            super(1);
            this.a = provider;
            this.b = bindingKodein;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Unit unit) {
            Intrinsics.checkParameterIsNotNull(unit, "it");
            return this.a.getCreator().invoke(new NoArgBindingKodeinWrap(this.b));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super org.kodein.di.bindings.NoArgBindingKodein<? extends C>, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Provider(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? extends T> typeToken2, @NotNull Function1<? super NoArgBindingKodein<? extends C>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "createdType");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        this.a = typeToken;
        this.b = typeToken2;
        this.c = function1;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return NoArgKodeinBinding.DefaultImpls.factoryFullName(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        return GeoContract.PROVIDER;
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
        return this.a;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public KodeinBinding.Copier<C, Unit, T> getCopier() {
        return NoArgKodeinBinding.DefaultImpls.getCopier(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.b;
    }

    @NotNull
    public final Function1<NoArgBindingKodein<? extends C>, T> getCreator() {
        return this.c;
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
        return new a(this, bindingKodein);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return NoArgKodeinBinding.DefaultImpls.getFullDescription(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public Scope<C> getScope() {
        return NoArgKodeinBinding.DefaultImpls.getScope(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return NoArgKodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }
}
