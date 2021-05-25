package org.kodein.di;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/KodeinAware;", "", "Lorg/kodein/di/KodeinContext;", "getKodeinContext", "()Lorg/kodein/di/KodeinContext;", "kodeinContext", "Lorg/kodein/di/KodeinTrigger;", "getKodeinTrigger", "()Lorg/kodein/di/KodeinTrigger;", "kodeinTrigger", "Lorg/kodein/di/Kodein;", "getKodein", "()Lorg/kodein/di/Kodein;", "kodein", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface KodeinAware {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static KodeinContext<?> getKodeinContext(KodeinAware kodeinAware) {
            return KodeinAwareKt.getAnyKodeinContext();
        }

        @Nullable
        public static KodeinTrigger getKodeinTrigger(KodeinAware kodeinAware) {
            return null;
        }
    }

    @NotNull
    Kodein getKodein();

    @NotNull
    KodeinContext<?> getKodeinContext();

    @Nullable
    KodeinTrigger getKodeinTrigger();
}
