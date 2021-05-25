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
public final class b<C> implements BindingKodein<C> {
    @NotNull
    public final BindingKodein<?> a;
    public final C b;
    public final /* synthetic */ BindingKodein c;

    public b(@NotNull BindingKodein<?> bindingKodein, C c2) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "base");
        this.c = bindingKodein;
        this.a = bindingKodein;
        this.b = c2;
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<Function1<A, T>> AllFactories(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.c.AllFactories(typeToken, typeToken2, obj);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <T> List<T> AllInstances(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.c.AllInstances(typeToken, obj);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<T> AllInstances(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.c.AllInstances(typeToken, typeToken2, obj, a3);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <T> List<Function0<T>> AllProviders(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.c.AllProviders(typeToken, obj);
    }

    @Override // org.kodein.di.DKodein
    @NotNull
    public <A, T> List<Function0<T>> AllProviders(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return this.c.AllProviders(typeToken, typeToken2, obj, function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> Function1<A, T> Factory(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.c.Factory(typeToken, typeToken2, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> Function1<A, T> FactoryOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return this.c.FactoryOrNull(typeToken, typeToken2, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <T> T Instance(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return (T) this.c.Instance(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> T Instance(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return (T) this.c.Instance(typeToken, typeToken2, obj, a3);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <T> T InstanceOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return (T) this.c.InstanceOrNull(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> T InstanceOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return (T) this.c.InstanceOrNull(typeToken, typeToken2, obj, a3);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public DKodein On(@NotNull KodeinContext<?> kodeinContext) {
        Intrinsics.checkParameterIsNotNull(kodeinContext, "context");
        return this.c.On(kodeinContext);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <T> Function0<T> Provider(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.c.Provider(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> Function0<T> Provider(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return this.c.Provider(typeToken, typeToken2, obj, function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <T> Function0<T> ProviderOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return this.c.ProviderOrNull(typeToken, obj);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> Function0<T> ProviderOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return this.c.ProviderOrNull(typeToken, typeToken2, obj, function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public KodeinContainer getContainer() {
        return this.c.getContainer();
    }

    @Override // org.kodein.di.bindings.WithContext
    public C getContext() {
        return this.b;
    }

    @Override // org.kodein.di.DKodeinAware
    @NotNull
    public DKodein getDkodein() {
        return this.c.getDkodein();
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public Kodein getKodein() {
        return this.c.getKodein();
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public Kodein getLazy() {
        return this.c.getLazy();
    }

    @Override // org.kodein.di.bindings.SimpleBindingKodein
    @NotNull
    public Function1<Object, Object> overriddenFactory() {
        return this.c.overriddenFactory();
    }

    @Override // org.kodein.di.bindings.SimpleBindingKodein
    @Nullable
    public Function1<Object, Object> overriddenFactoryOrNull() {
        return this.c.overriddenFactoryOrNull();
    }
}
