package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR#\u0010\u0012\u001a\u00020\u00018F@\u0006X\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lorg/kodein/di/LazyKodein;", "Lorg/kodein/di/Kodein;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lorg/kodein/di/LazyKodein;", "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getBaseKodein", "()Lorg/kodein/di/Kodein;", "baseKodein$annotations", "()V", "baseKodein", "Lkotlin/Function0;", "f", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class LazyKodein implements Kodein {
    public static final /* synthetic */ KProperty[] b = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyKodein.class), "baseKodein", "getBaseKodein()Lorg/kodein/di/Kodein;"))};
    @NotNull
    public final Lazy a;

    public LazyKodein(@NotNull Function0<? extends Kodein> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "f");
        this.a = c.lazy(function0);
    }

    public static /* synthetic */ void baseKodein$annotations() {
    }

    @NotNull
    public final Kodein getBaseKodein() {
        Lazy lazy = this.a;
        KProperty kProperty = b[0];
        return (Kodein) lazy.getValue();
    }

    @Override // org.kodein.di.Kodein
    @NotNull
    public KodeinContainer getContainer() {
        return getBaseKodein().getContainer();
    }

    @Override // org.kodein.di.Kodein, org.kodein.di.KodeinAware
    @NotNull
    public Kodein getKodein() {
        return Kodein.DefaultImpls.getKodein(this);
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public KodeinContext<?> getKodeinContext() {
        return Kodein.DefaultImpls.getKodeinContext(this);
    }

    @Override // org.kodein.di.KodeinAware
    @Nullable
    public KodeinTrigger getKodeinTrigger() {
        return Kodein.DefaultImpls.getKodeinTrigger(this);
    }

    @NotNull
    public final LazyKodein getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        return this;
    }
}
