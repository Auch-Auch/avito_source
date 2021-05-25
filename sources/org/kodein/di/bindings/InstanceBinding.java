package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.NoArgKodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003B\u001f\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JG\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\f2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R$\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\u001e\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006¨\u0006#"}, d2 = {"Lorg/kodein/di/bindings/InstanceBinding;", "", "T", "Lorg/kodein/di/bindings/NoArgKodeinBinding;", "", "factoryName", "()Ljava/lang/String;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "Lorg/kodein/di/TypeToken;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "getCreatedType", "()Lorg/kodein/di/TypeToken;", "createdType", "getFullDescription", "fullDescription", AuthSource.SEND_ABUSE, "getContextType", "contextType", "c", "Ljava/lang/Object;", "getInstance", "()Ljava/lang/Object;", "instance", "getDescription", "description", "<init>", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class InstanceBinding<T> implements NoArgKodeinBinding<Object, T> {
    @NotNull
    public final TypeToken<Object> a = TypeTokenKt.getAnyToken();
    @NotNull
    public final TypeToken<? extends T> b;
    @NotNull
    public final T c;

    public static final class a extends Lambda implements Function1<Unit, T> {
        public final /* synthetic */ InstanceBinding a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InstanceBinding instanceBinding) {
            super(1);
            this.a = instanceBinding;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Unit unit) {
            Intrinsics.checkParameterIsNotNull(unit, "it");
            return this.a.getInstance();
        }
    }

    public InstanceBinding(@NotNull TypeToken<? extends T> typeToken, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(typeToken, "createdType");
        Intrinsics.checkParameterIsNotNull(t, "instance");
        this.b = typeToken;
        this.c = t;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return NoArgKodeinBinding.DefaultImpls.factoryFullName(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        return "instance";
    }

    /* Return type fixed from 'org.kodein.di.TypeToken<kotlin.Unit>' to match base method */
    @Override // org.kodein.di.bindings.NoArgKodeinBinding, org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? super Unit> getArgType() {
        return NoArgKodeinBinding.DefaultImpls.getArgType(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<Object> getContextType() {
        return this.a;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public KodeinBinding.Copier<Object, Unit, T> getCopier() {
        return NoArgKodeinBinding.DefaultImpls.getCopier(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return factoryName() + " ( " + getCreatedType().simpleDispString() + " ) ";
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<Unit, T> getFactory(@NotNull BindingKodein<? extends Object> bindingKodein, @NotNull Kodein.Key<Object, ? super Unit, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new a(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return factoryFullName() + " ( " + getCreatedType().fullDispString() + " ) ";
    }

    @NotNull
    public final T getInstance() {
        return this.c;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @Nullable
    public Scope<Object> getScope() {
        return NoArgKodeinBinding.DefaultImpls.getScope(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    public boolean getSupportSubTypes() {
        return NoArgKodeinBinding.DefaultImpls.getSupportSubTypes(this);
    }
}
