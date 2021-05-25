package org.kodein.di.bindings;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.bindings.KodeinBinding;
import org.kodein.di.bindings.NoArgKodeinBinding;
import org.kodein.di.internal.BindingKodeinImpl;
import x6.d.a.n.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003B@\u0012\u0006\u0010+\u001a\u00020*\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\u0012\u001f\u0010)\u001a\u001b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010#\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b$¢\u0006\u0004\b,\u0010-JG\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\t2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u001a\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R0\u0010\u001a\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0018\u0010 \u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR2\u0010)\u001a\u001b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010#\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lorg/kodein/di/bindings/EagerSingleton;", "", "T", "Lorg/kodein/di/bindings/NoArgKodeinBinding;", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "", "factoryName", "()Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", "e", "Lorg/kodein/di/TypeToken;", "getCreatedType", "()Lorg/kodein/di/TypeToken;", "createdType", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "d", "Lorg/kodein/di/bindings/KodeinBinding$Copier;", "getCopier", "()Lorg/kodein/di/bindings/KodeinBinding$Copier;", "copier", AuthSource.SEND_ABUSE, "getContextType", "contextType", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "_instance", "c", "_lock", "Lorg/kodein/di/bindings/NoArgSimpleBindingKodein;", "Lkotlin/ExtensionFunctionType;", "f", "Lkotlin/jvm/functions/Function1;", "getCreator", "()Lkotlin/jvm/functions/Function1;", "creator", "Lorg/kodein/di/KodeinContainer$Builder;", "builder", "<init>", "(Lorg/kodein/di/KodeinContainer$Builder;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class EagerSingleton<T> implements NoArgKodeinBinding<Object, T> {
    @NotNull
    public final TypeToken<Object> a = TypeTokenKt.getAnyToken();
    public volatile T b;
    public final Object c = new Object();
    @NotNull
    public final KodeinBinding.Copier<Object, Unit, T> d;
    @NotNull
    public final TypeToken<? extends T> e;
    @NotNull
    public final Function1<NoArgSimpleBindingKodein<? extends Object>, T> f;

    public static final class a extends Lambda implements Function1<DKodein, Unit> {
        public final /* synthetic */ EagerSingleton a;
        public final /* synthetic */ Kodein.Key b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EagerSingleton eagerSingleton, Kodein.Key key) {
            super(1);
            this.a = eagerSingleton;
            this.b = key;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DKodein dKodein) {
            DKodein dKodein2 = dKodein;
            Intrinsics.checkParameterIsNotNull(dKodein2, "$receiver");
            Function1 access$getFactory = EagerSingleton.access$getFactory(this.a, new BindingKodeinImpl(dKodein2, this.b, null, 0));
            Unit unit = Unit.INSTANCE;
            access$getFactory.invoke(unit);
            return unit;
        }
    }

    public static final class b extends Lambda implements Function1<KodeinContainer.Builder, EagerSingleton<T>> {
        public final /* synthetic */ EagerSingleton a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EagerSingleton eagerSingleton) {
            super(1);
            this.a = eagerSingleton;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(KodeinContainer.Builder builder) {
            KodeinContainer.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "builder");
            return new EagerSingleton(builder2, this.a.getCreatedType(), this.a.getCreator());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super org.kodein.di.bindings.NoArgSimpleBindingKodein<? extends java.lang.Object>, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public EagerSingleton(@NotNull KodeinContainer.Builder builder, @NotNull TypeToken<? extends T> typeToken, @NotNull Function1<? super NoArgSimpleBindingKodein<? extends Object>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(typeToken, "createdType");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        this.e = typeToken;
        this.f = function1;
        builder.onReady(new a(this, new Kodein.Key(TypeTokenKt.getAnyToken(), TypeTokenKt.getUnitToken(), getCreatedType(), null)));
        this.d = KodeinBinding.Copier.Companion.invoke(new b(this));
    }

    public static final Function1 access$getFactory(EagerSingleton eagerSingleton, BindingKodein bindingKodein) {
        Objects.requireNonNull(eagerSingleton);
        return new c(eagerSingleton, bindingKodein);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryFullName() {
        return NoArgKodeinBinding.DefaultImpls.factoryFullName(this);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String factoryName() {
        return "eagerSingleton";
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
    @NotNull
    public KodeinBinding.Copier<Object, Unit, T> getCopier() {
        return this.d;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public TypeToken<? extends T> getCreatedType() {
        return this.e;
    }

    @NotNull
    public final Function1<NoArgSimpleBindingKodein<? extends Object>, T> getCreator() {
        return this.f;
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getDescription() {
        return NoArgKodeinBinding.DefaultImpls.getDescription(this);
    }

    @Override // org.kodein.di.bindings.Binding
    @NotNull
    public Function1<Unit, T> getFactory(@NotNull BindingKodein<? extends Object> bindingKodein, @NotNull Kodein.Key<Object, ? super Unit, ? extends T> key) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "kodein");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new c(this, bindingKodein);
    }

    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    public String getFullDescription() {
        return NoArgKodeinBinding.DefaultImpls.getFullDescription(this);
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
