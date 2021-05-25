package org.kodein.di.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeToken;
import org.kodein.di.bindings.BindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\n\b\u0002\u0010\u0004 \u0001*\u00020\u00032\u00020\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B;\b\u0000\u0012\u0006\u0010>\u001a\u00020\u0005\u0012\u0018\u0010B\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?\u0012\u0006\u0010!\u001a\u00028\u0000\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\bC\u0010DJ\u001d\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\\\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00070\u000f\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u000f\"\b\b\u0003\u0010\u0004*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0012\u0010\u0013JX\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00040\u000f\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0001¢\u0006\u0004\b\u0012\u0010\u0015J@\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00160\u000f\"\b\b\u0003\u0010\u0004*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0017\u0010\u0013Jd\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u00160\u000f\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00030\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0007\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJV\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0018\u00010\u0007\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ2\u0010\u001c\u001a\u00028\u0003\"\b\b\u0003\u0010\u0004*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJP\u0010\u001c\u001a\u00028\u0004\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001eJ4\u0010\u001f\u001a\u0004\u0018\u00018\u0003\"\b\b\u0003\u0010\u0004*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u001f\u0010\u001dJR\u0010\u001f\u001a\u0004\u0018\u00018\u0004\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ\u001c\u0010\"\u001a\u00020\u00052\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 H\u0001¢\u0006\u0004\b\"\u0010#J8\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00030\u0016\"\b\b\u0003\u0010\u0004*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b$\u0010%J\\\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00040\u0016\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00030\u0016H\u0001¢\u0006\u0004\b$\u0010&J:\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0016\"\b\b\u0003\u0010\u0004*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b'\u0010%J^\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0004\u0018\u00010\u0016\"\u0004\b\u0003\u0010\u0002\"\b\b\u0004\u0010\u0004*\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00030\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00030\u0016H\u0001¢\u0006\u0004\b'\u0010&R\u0016\u0010+\u001a\u00020(8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u0010!\u001a\u00028\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020,8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b8\u0010.R\u001c\u0010>\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R(\u0010B\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?8\b@\bX\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lorg/kodein/di/internal/BindingKodeinImpl;", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/DKodein;", "Lorg/kodein/di/bindings/BindingKodein;", "Lkotlin/Function1;", "overriddenFactory", "()Lkotlin/jvm/functions/Function1;", "overriddenFactoryOrNull", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "", "AllFactories", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "AllInstances", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/util/List;", "arg", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "Lkotlin/Function0;", "AllProviders", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "Factory", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "FactoryOrNull", "Instance", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "InstanceOrNull", "Lorg/kodein/di/KodeinContext;", "context", "On", "(Lorg/kodein/di/KodeinContext;)Lorg/kodein/di/DKodein;", "Provider", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "ProviderOrNull", "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "Lorg/kodein/di/Kodein;", "getKodein", "()Lorg/kodein/di/Kodein;", "kodein", "c", "Ljava/lang/Object;", "getContext", "()Ljava/lang/Object;", "", "d", "I", "_overrideLevel", "getLazy", "lazy", AuthSource.SEND_ABUSE, "Lorg/kodein/di/DKodein;", "getDkodein", "()Lorg/kodein/di/DKodein;", "dkodein", "Lorg/kodein/di/Kodein$Key;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/Kodein$Key;", "_key", "<init>", "(Lorg/kodein/di/DKodein;Lorg/kodein/di/Kodein$Key;Ljava/lang/Object;I)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public class BindingKodeinImpl<C, A, T> implements DKodein, BindingKodein<C> {
    @NotNull
    public final DKodein a;
    public final Kodein.Key<C, A, T> b;
    public final C c;
    public final int d;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.kodein.di.Kodein$Key<? super C, ? super A, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public BindingKodeinImpl(@NotNull DKodein dKodein, @NotNull Kodein.Key<? super C, ? super A, ? extends T> key, C c2, int i) {
        Intrinsics.checkParameterIsNotNull(dKodein, "dkodein");
        Intrinsics.checkParameterIsNotNull(key, "_key");
        this.a = dKodein;
        this.b = key;
        this.c = c2;
        this.d = i;
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
        return this.c;
    }

    @Override // org.kodein.di.DKodeinAware
    @NotNull
    public DKodein getDkodein() {
        return this.a;
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
    @NotNull
    public Function1<Object, Object> overriddenFactory() {
        Function1<A, T> factory = getContainer().factory(this.b, getContext(), this.d + 1);
        if (factory != null) {
            return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 1);
        }
        throw new TypeCastException("null cannot be cast to non-null type (kotlin.Any?) -> kotlin.Any");
    }

    @Override // org.kodein.di.bindings.SimpleBindingKodein
    @Nullable
    public Function1<Object, Object> overriddenFactoryOrNull() {
        return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(getContainer().factoryOrNull(this.b, getContext(), this.d + 1), 1);
    }
}
