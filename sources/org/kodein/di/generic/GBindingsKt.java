package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.GeoContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.TypeReference;
import org.kodein.di.TypeToken;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.BindingKodein;
import org.kodein.di.bindings.EagerSingleton;
import org.kodein.di.bindings.Factory;
import org.kodein.di.bindings.InstanceBinding;
import org.kodein.di.bindings.Multiton;
import org.kodein.di.bindings.NoArgBindingKodein;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import org.kodein.di.bindings.Provider;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.SimpleBindingKodein;
import org.kodein.di.bindings.Singleton;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\b¢\u0006\u0004\b\b\u0010\t\u001am\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0011\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\n\u0018\u0001\"\n\b\u0002\u0010\f\u0018\u0001*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00072%\b\b\u0010\u0010\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b\u0012\u0010\u0013\u001aY\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\f\u0018\u0001*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00072\u001f\b\b\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b\u0017\u0010\u0018\u001ao\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\f\u0018\u0001*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u001f\b\b\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010#\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\n\u0018\u0001\"\n\b\u0002\u0010\f\u0018\u0001*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2%\b\b\u0010\u0010\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b#\u0010$\u001aI\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u000b*\u00020\u00012!\b\b\u0010\u0010\u001a\u001b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001d\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0002\b\u000fH\b¢\u0006\u0004\b&\u0010'\u001a.\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u000b*\u00020\u00012\u0006\u0010(\u001a\u00028\u0000H\b¢\u0006\u0004\b(\u0010*¨\u0006+"}, d2 = {"C", "Lorg/kodein/di/Kodein$Builder;", "Lorg/kodein/di/bindings/Scope;", "scope", "Lorg/kodein/di/Kodein$BindBuilder$WithScope;", "scoped", "(Lorg/kodein/di/Kodein$Builder;Lorg/kodein/di/bindings/Scope;)Lorg/kodein/di/Kodein$BindBuilder$WithScope;", "Lorg/kodein/di/Kodein$BindBuilder$WithContext;", "contexted", "(Lorg/kodein/di/Kodein$Builder;)Lorg/kodein/di/Kodein$BindBuilder$WithContext;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lkotlin/Function2;", "Lorg/kodein/di/bindings/BindingKodein;", "Lkotlin/ExtensionFunctionType;", "creator", "Lorg/kodein/di/bindings/Factory;", "factory", "(Lorg/kodein/di/Kodein$BindBuilder$WithContext;Lkotlin/jvm/functions/Function2;)Lorg/kodein/di/bindings/Factory;", "Lkotlin/Function1;", "Lorg/kodein/di/bindings/NoArgBindingKodein;", "Lorg/kodein/di/bindings/Provider;", GeoContract.PROVIDER, "(Lorg/kodein/di/Kodein$BindBuilder$WithContext;Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/bindings/Provider;", "Lorg/kodein/di/bindings/RefMaker;", "ref", "", "sync", "Lorg/kodein/di/bindings/NoArgSimpleBindingKodein;", "Lorg/kodein/di/bindings/Singleton;", "singleton", "(Lorg/kodein/di/Kodein$BindBuilder$WithScope;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function1;)Lorg/kodein/di/bindings/Singleton;", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "Lorg/kodein/di/bindings/Multiton;", "multiton", "(Lorg/kodein/di/Kodein$BindBuilder$WithScope;Lorg/kodein/di/bindings/RefMaker;ZLkotlin/jvm/functions/Function2;)Lorg/kodein/di/bindings/Multiton;", "Lorg/kodein/di/bindings/EagerSingleton;", "eagerSingleton", "(Lorg/kodein/di/Kodein$Builder;Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/bindings/EagerSingleton;", "instance", "Lorg/kodein/di/bindings/InstanceBinding;", "(Lorg/kodein/di/Kodein$Builder;Ljava/lang/Object;)Lorg/kodein/di/bindings/InstanceBinding;", "kodein-di-generic-jvm"}, k = 2, mv = {1, 4, 0})
public final class GBindingsKt {
    @NotNull
    public static final /* synthetic */ <C> Kodein.BindBuilder.WithContext<C> contexted(@NotNull Kodein.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$contexted");
        Intrinsics.needClassReification();
        return new Kodein.BindBuilder.WithContext.Impl(TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GBindingsKt$contexted$$inlined$generic$1
        }));
    }

    @NotNull
    public static final /* synthetic */ <T> EagerSingleton<T> eagerSingleton(@NotNull Kodein.Builder builder, @NotNull Function1<? super NoArgSimpleBindingKodein<? extends Object>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$eagerSingleton");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        KodeinContainer.Builder containerBuilder = builder.getContainerBuilder();
        Intrinsics.needClassReification();
        return new EagerSingleton<>(containerBuilder, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$eagerSingleton$$inlined$generic$1
        }), function1);
    }

    @NotNull
    public static final /* synthetic */ <C, A, T> Factory<C, A, T> factory(@NotNull Kodein.BindBuilder.WithContext<C> withContext, @NotNull Function2<? super BindingKodein<? extends C>, ? super A, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(withContext, "$this$factory");
        Intrinsics.checkParameterIsNotNull(function2, "creator");
        TypeToken<C> contextType = withContext.getContextType();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GBindingsKt$factory$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new Factory<>(contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$factory$$inlined$generic$2
        }), function2);
    }

    @NotNull
    public static final /* synthetic */ <T> InstanceBinding<T> instance(@NotNull Kodein.Builder builder, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$instance");
        Intrinsics.checkParameterIsNotNull(t, "instance");
        Intrinsics.needClassReification();
        return new InstanceBinding<>(TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$instance$$inlined$generic$1
        }), t);
    }

    @NotNull
    public static final /* synthetic */ <C, A, T> Multiton<C, A, T> multiton(@NotNull Kodein.BindBuilder.WithScope<C> withScope, @Nullable RefMaker refMaker, boolean z, @NotNull Function2<? super SimpleBindingKodein<? extends C>, ? super A, ? extends T> function2) {
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function2, "creator");
        Scope<C> scope = withScope.getScope();
        TypeToken<C> contextType = withScope.getContextType();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GBindingsKt$multiton$$inlined$generic$1
        });
        Intrinsics.needClassReification();
        return new Multiton<>(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$multiton$$inlined$generic$2
        }), refMaker, z, function2);
    }

    public static /* synthetic */ Multiton multiton$default(Kodein.BindBuilder.WithScope withScope, RefMaker refMaker, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            refMaker = null;
        }
        boolean z2 = (i & 2) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(withScope, "$this$multiton");
        Intrinsics.checkParameterIsNotNull(function2, "creator");
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        Intrinsics.needClassReification();
        TypeToken TT = TypesKt.TT(new TypeReference<A>() { // from class: org.kodein.di.generic.GBindingsKt$multiton$$inlined$generic$3
        });
        Intrinsics.needClassReification();
        return new Multiton(scope, contextType, TT, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$multiton$$inlined$generic$4
        }), refMaker, z2, function2);
    }

    @NotNull
    public static final /* synthetic */ <C, T> Provider<C, T> provider(@NotNull Kodein.BindBuilder.WithContext<C> withContext, @NotNull Function1<? super NoArgBindingKodein<? extends C>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(withContext, "$this$provider");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        TypeToken<C> contextType = withContext.getContextType();
        Intrinsics.needClassReification();
        return new Provider<>(contextType, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$provider$$inlined$generic$1
        }), function1);
    }

    @NotNull
    public static final /* synthetic */ <C> Kodein.BindBuilder.WithScope<C> scoped(@NotNull Kodein.Builder builder, @NotNull Scope<? super C> scope) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$scoped");
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        Intrinsics.needClassReification();
        return new Kodein.BindBuilder.WithScope.Impl(TypesKt.TT(new TypeReference<C>() { // from class: org.kodein.di.generic.GBindingsKt$scoped$$inlined$generic$1
        }), scope);
    }

    @NotNull
    public static final /* synthetic */ <C, T> Singleton<C, T> singleton(@NotNull Kodein.BindBuilder.WithScope<C> withScope, @Nullable RefMaker refMaker, boolean z, @NotNull Function1<? super NoArgSimpleBindingKodein<? extends C>, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(withScope, "$this$singleton");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        Scope<C> scope = withScope.getScope();
        TypeToken<C> contextType = withScope.getContextType();
        Intrinsics.needClassReification();
        return new Singleton<>(scope, contextType, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$singleton$$inlined$generic$1
        }), refMaker, z, function1);
    }

    public static /* synthetic */ Singleton singleton$default(Kodein.BindBuilder.WithScope withScope, RefMaker refMaker, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            refMaker = null;
        }
        boolean z2 = (i & 2) != 0 ? true : z;
        Intrinsics.checkParameterIsNotNull(withScope, "$this$singleton");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        Intrinsics.needClassReification();
        return new Singleton(scope, contextType, TypesKt.TT(new TypeReference<T>() { // from class: org.kodein.di.generic.GBindingsKt$singleton$$inlined$generic$2
        }), refMaker, z2, function1);
    }
}
