package x6.d.a.n;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.BindingKodein;
public final class g<C> implements BindingKodein<C> {
    public final BindingKodein<C> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.bindings.BindingKodein<? extends C> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull BindingKodein<? extends C> bindingKodein) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "_base");
        this.a = bindingKodein;
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<Function1<A, T>> AllFactories(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.a.AllFactories(typeToken, typeToken2, obj);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <T> List<T> AllInstances(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.a.AllInstances(typeToken, obj);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<T> AllInstances(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.a.AllInstances(typeToken, typeToken2, obj, a3);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <T> List<Function0<T>> AllProviders(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.a.AllProviders(typeToken, obj);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<Function0<T>> AllProviders(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return this.a.AllProviders(typeToken, typeToken2, obj, function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> Function1<A, T> Factory(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.a.Factory(typeToken, typeToken2, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> Function1<A, T> FactoryOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.a.FactoryOrNull(typeToken, typeToken2, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <T> T Instance(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return (T) this.a.Instance(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> T Instance(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return (T) this.a.Instance(typeToken, typeToken2, obj, a3);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <T> T InstanceOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return (T) this.a.InstanceOrNull(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> T InstanceOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return (T) this.a.InstanceOrNull(typeToken, typeToken2, obj, a3);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public DKodein On(@NotNull KodeinContext<?> kodeinContext) {
        Intrinsics.checkParameterIsNotNull(kodeinContext, "context");
        return this.a.On(kodeinContext);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <T> Function0<T> Provider(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.a.Provider(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> Function0<T> Provider(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return this.a.Provider(typeToken, typeToken2, obj, function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <T> Function0<T> ProviderOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.a.ProviderOrNull(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> Function0<T> ProviderOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return this.a.ProviderOrNull(typeToken, typeToken2, obj, function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public KodeinContainer getContainer() {
        return this.a.getContainer();
    }

    @Override // org.kodein.di.bindings.WithContext
    public C getContext() {
        return this.a.getContext();
    }

    @Override // org.kodein.di.DKodeinAware
    @NotNull
    public DKodein getDkodein() {
        return this.a.getDkodein();
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public Kodein getKodein() {
        return this.a.getKodein();
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public Kodein getLazy() {
        return this.a.getLazy();
    }

    @Override // org.kodein.di.bindings.SimpleBindingKodein
    public Function1 overriddenFactory() {
        throw new IllegalStateException("Cannot access overrides in a Set binding");
    }

    @Override // org.kodein.di.bindings.SimpleBindingKodein
    public Function1 overriddenFactoryOrNull() {
        throw new IllegalStateException("Cannot access overrides in a Set binding");
    }
}
