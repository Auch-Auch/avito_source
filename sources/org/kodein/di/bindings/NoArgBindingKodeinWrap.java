package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0015\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,¢\u0006\u0004\b>\u0010?J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\\\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00140\u0013\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J:\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013\"\b\b\u0001\u0010\u000e*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u0017\u0010\u0018JX\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0013\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00028\u0001H\u0001¢\u0006\u0004\b\u0017\u0010\u001aJ@\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0013\"\b\b\u0001\u0010\u000e*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001b\u0010\u0018Jd\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00050\u0013\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJT\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0014\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJV\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0014\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ2\u0010 \u001a\u00028\u0001\"\b\b\u0001\u0010\u000e*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b \u0010!JP\u0010 \u001a\u00028\u0002\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00028\u0001H\u0001¢\u0006\u0004\b \u0010\"J4\u0010#\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u000e*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b#\u0010!JR\u0010#\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00028\u0001H\u0001¢\u0006\u0004\b#\u0010\"J\u001c\u0010&\u001a\u00020\u00032\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0001¢\u0006\u0004\b&\u0010'J8\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0001\u0010\u000e*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b(\u0010)J\\\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0001¢\u0006\u0004\b(\u0010*J:\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\"\b\b\u0001\u0010\u000e*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b+\u0010)J^\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0005\"\u0004\b\u0001\u0010\r\"\b\b\u0002\u0010\u000e*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0001¢\u0006\u0004\b+\u0010*R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0002048V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010%\u001a\u00028\u00008\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b;\u0010\u000bR\u0016\u0010=\u001a\u0002048\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b<\u00106¨\u0006@"}, d2 = {"Lorg/kodein/di/bindings/NoArgBindingKodeinWrap;", "C", "Lorg/kodein/di/bindings/NoArgBindingKodein;", "Lorg/kodein/di/DKodein;", "Lorg/kodein/di/bindings/WithContext;", "Lkotlin/Function0;", "", "overriddenProvider", "()Lkotlin/jvm/functions/Function0;", "overriddenProviderOrNull", "overriddenInstance", "()Ljava/lang/Object;", "overriddenInstanceOrNull", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "T", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "", "Lkotlin/Function1;", "AllFactories", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "AllInstances", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "arg", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "AllProviders", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "Factory", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "FactoryOrNull", "Instance", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "InstanceOrNull", "Lorg/kodein/di/KodeinContext;", "context", "On", "(Lorg/kodein/di/KodeinContext;)Lorg/kodein/di/DKodein;", "Provider", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "ProviderOrNull", "Lorg/kodein/di/bindings/BindingKodein;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/bindings/BindingKodein;", "_kodein", "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "Lorg/kodein/di/Kodein;", "getKodein", "()Lorg/kodein/di/Kodein;", "kodein", "getDkodein", "()Lorg/kodein/di/DKodein;", "dkodein", "getContext", "getLazy", "lazy", "<init>", "(Lorg/kodein/di/bindings/BindingKodein;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class NoArgBindingKodeinWrap<C> implements NoArgBindingKodein<C>, DKodein, WithContext<C> {
    public final BindingKodein<C> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.bindings.BindingKodein<? extends C> */
    /* JADX WARN: Multi-variable type inference failed */
    public NoArgBindingKodeinWrap(@NotNull BindingKodein<? extends C> bindingKodein) {
        Intrinsics.checkParameterIsNotNull(bindingKodein, "_kodein");
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

    @Override // org.kodein.di.bindings.NoArgSimpleBindingKodein
    @NotNull
    public Object overriddenInstance() {
        return overriddenProvider().invoke();
    }

    @Override // org.kodein.di.bindings.NoArgSimpleBindingKodein
    @Nullable
    public Object overriddenInstanceOrNull() {
        Function0<Object> overriddenProviderOrNull = overriddenProviderOrNull();
        if (overriddenProviderOrNull != null) {
            return overriddenProviderOrNull.invoke();
        }
        return null;
    }

    @Override // org.kodein.di.bindings.NoArgSimpleBindingKodein
    @NotNull
    public Function0<Object> overriddenProvider() {
        return new Function0<Object>(this.a.overriddenFactory()) { // from class: org.kodein.di.bindings.NoArgBindingKodeinWrap$overriddenProvider$$inlined$toProvider$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Object invoke() {
                return this.a.invoke(Unit.INSTANCE);
            }
        };
    }

    @Override // org.kodein.di.bindings.NoArgSimpleBindingKodein
    @Nullable
    public Function0<Object> overriddenProviderOrNull() {
        Function1<Object, Object> overriddenFactoryOrNull = this.a.overriddenFactoryOrNull();
        if (overriddenFactoryOrNull != null) {
            return new Function0<Object>(overriddenFactoryOrNull) { // from class: org.kodein.di.bindings.NoArgBindingKodeinWrap$overriddenProviderOrNull$$inlined$toProvider$1
                public final /* synthetic */ Function1 a;

                {
                    this.a = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Object invoke() {
                    return this.a.invoke(Unit.INSTANCE);
                }
            };
        }
        return null;
    }
}
