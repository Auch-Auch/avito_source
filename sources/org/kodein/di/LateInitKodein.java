package org.kodein.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/LateInitKodein;", "Lorg/kodein/di/Kodein;", "Lorg/kodein/di/KodeinContainer;", "getContainer", "()Lorg/kodein/di/KodeinContainer;", "container", "baseKodein", "Lorg/kodein/di/Kodein;", "getBaseKodein", "()Lorg/kodein/di/Kodein;", "setBaseKodein", "(Lorg/kodein/di/Kodein;)V", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class LateInitKodein implements Kodein {
    @NotNull
    public Kodein baseKodein;

    @NotNull
    public final Kodein getBaseKodein() {
        Kodein kodein = this.baseKodein;
        if (kodein == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseKodein");
        }
        return kodein;
    }

    @Override // org.kodein.di.Kodein
    @NotNull
    public KodeinContainer getContainer() {
        Kodein kodein = this.baseKodein;
        if (kodein == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseKodein");
        }
        return kodein.getContainer();
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

    public final void setBaseKodein(@NotNull Kodein kodein) {
        Intrinsics.checkParameterIsNotNull(kodein, "<set-?>");
        this.baseKodein = kodein;
    }
}
