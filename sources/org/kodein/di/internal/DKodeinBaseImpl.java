package org.kodein.di.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.CurryKt$toProvider$1;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\u001d\b\u0004\u0012\u0006\u0010(\u001a\u00020#\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010\u0004\u001a\u00020\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005JS\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\b*\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\b*\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J[\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\b*\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J9\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J]\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\b*\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J1\u0010\u0017\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JO\u0010\u0017\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\b*\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0019J3\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0018JQ\u0010\u001a\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\b*\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010(\u001a\u00020#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lorg/kodein/di/internal/DKodeinBaseImpl;", "Lorg/kodein/di/DKodein;", "Lorg/kodein/di/KodeinContext;", "context", "On", "(Lorg/kodein/di/KodeinContext;)Lorg/kodein/di/DKodein;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lorg/kodein/di/TypeToken;", "argType", "type", "tag", "Lkotlin/Function1;", "Factory", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "FactoryOrNull", "Lkotlin/Function0;", "Provider", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "arg", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "ProviderOrNull", "Instance", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Ljava/lang/Object;", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "InstanceOrNull", "Lorg/kodein/di/Kodein;", "getLazy", "()Lorg/kodein/di/Kodein;", "lazy", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/KodeinContext;", "getContext", "()Lorg/kodein/di/KodeinContext;", "Lorg/kodein/di/KodeinContainer;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "getDkodein", "()Lorg/kodein/di/DKodein;", "dkodein", "<init>", "(Lorg/kodein/di/KodeinContainer;Lorg/kodein/di/KodeinContext;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public abstract class DKodeinBaseImpl implements DKodein {
    @NotNull
    public final KodeinContainer a;
    @NotNull
    public final KodeinContext<?> b;

    public DKodeinBaseImpl(@NotNull KodeinContainer kodeinContainer, @NotNull KodeinContext<?> kodeinContext) {
        Intrinsics.checkParameterIsNotNull(kodeinContainer, "container");
        Intrinsics.checkParameterIsNotNull(kodeinContext, "context");
        this.a = kodeinContainer;
        this.b = kodeinContext;
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> Function1<A, T> Factory(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return KodeinContainer.DefaultImpls.factory$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), typeToken, typeToken2, obj), this.b.getValue(), 0, 4, null);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> Function1<A, T> FactoryOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return KodeinContainer.DefaultImpls.factoryOrNull$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), typeToken, typeToken2, obj), this.b.getValue(), 0, 4, null);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <T> T Instance(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return (T) KodeinContainer.DefaultImpls.provider$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), TypeTokenKt.getUnitToken(), typeToken, obj), this.b.getValue(), 0, 4, null).invoke();
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <T> T InstanceOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        Function0 providerOrNull$default = KodeinContainer.DefaultImpls.providerOrNull$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), TypeTokenKt.getUnitToken(), typeToken, obj), this.b.getValue(), 0, 4, null);
        if (providerOrNull$default != null) {
            return (T) providerOrNull$default.invoke();
        }
        return null;
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public DKodein On(@NotNull KodeinContext<?> kodeinContext) {
        Intrinsics.checkParameterIsNotNull(kodeinContext, "context");
        return new DKodeinImpl(getContainer(), kodeinContext);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <T> Function0<T> Provider(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return KodeinContainer.DefaultImpls.provider$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), TypeTokenKt.getUnitToken(), typeToken, obj), this.b.getValue(), 0, 4, null);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <T> Function0<T> ProviderOrNull(@NotNull TypeToken<T> typeToken, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return KodeinContainer.DefaultImpls.providerOrNull$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), TypeTokenKt.getUnitToken(), typeToken, obj), this.b.getValue(), 0, 4, null);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public KodeinContainer getContainer() {
        return this.a;
    }

    @NotNull
    public final KodeinContext<?> getContext() {
        return this.b;
    }

    @Override // org.kodein.di.DKodeinAware
    @NotNull
    public DKodein getDkodein() {
        return this;
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public Kodein getKodein() {
        return DKodein.DefaultImpls.getKodein(this);
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public Kodein getLazy() {
        KodeinContainer container = getContainer();
        if (container != null) {
            return KodeinAwareKt.On$default(new KodeinImpl((KodeinContainerImpl) container), this.b, null, 2, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.internal.KodeinContainerImpl");
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> T Instance(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        return (T) KodeinContainer.DefaultImpls.factory$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), typeToken, typeToken2, obj), this.b.getValue(), 0, 4, null).invoke(a3);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> T InstanceOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Function1 factoryOrNull$default = KodeinContainer.DefaultImpls.factoryOrNull$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), typeToken, typeToken2, obj), this.b.getValue(), 0, 4, null);
        if (factoryOrNull$default != null) {
            return (T) factoryOrNull$default.invoke(a3);
        }
        return null;
    }

    @Override // org.kodein.di.DKodeinBase
    @NotNull
    public <A, T> Function0<T> Provider(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new CurryKt$toProvider$1(KodeinContainer.DefaultImpls.factory$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), typeToken, typeToken2, obj), this.b.getValue(), 0, 4, null), function0);
    }

    @Override // org.kodein.di.DKodeinBase
    @Nullable
    public <A, T> Function0<T> ProviderOrNull(@NotNull TypeToken<? super A> typeToken, @NotNull TypeToken<T> typeToken2, @Nullable Object obj, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "argType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "type");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        Function1 factoryOrNull$default = KodeinContainer.DefaultImpls.factoryOrNull$default(getContainer(), new Kodein.Key(DKodeinImplKt.access$getAnyType$p(this.b), typeToken, typeToken2, obj), this.b.getValue(), 0, 4, null);
        if (factoryOrNull$default != null) {
            return new CurryKt$toProvider$1(factoryOrNull$default, function0);
        }
        return null;
    }
}
