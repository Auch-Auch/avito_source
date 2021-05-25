package x6.d.a;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinContainer;
import org.kodein.di.KodeinContext;
import org.kodein.di.KodeinTrigger;
public final class g implements Kodein {
    public final Kodein a;
    @NotNull
    public final KodeinContext<?> b;
    @Nullable
    public final KodeinTrigger c;

    public g(@NotNull KodeinAware kodeinAware, @NotNull KodeinContext<?> kodeinContext, @Nullable KodeinTrigger kodeinTrigger) {
        Intrinsics.checkParameterIsNotNull(kodeinAware, "base");
        Intrinsics.checkParameterIsNotNull(kodeinContext, "kodeinContext");
        Kodein kodein = kodeinAware.getKodein();
        Intrinsics.checkParameterIsNotNull(kodein, "_base");
        Intrinsics.checkParameterIsNotNull(kodeinContext, "kodeinContext");
        this.a = kodein;
        this.b = kodeinContext;
        this.c = kodeinTrigger;
    }

    @Override // org.kodein.di.Kodein
    @NotNull
    public KodeinContainer getContainer() {
        return this.a.getContainer();
    }

    @Override // org.kodein.di.Kodein, org.kodein.di.KodeinAware
    @NotNull
    public Kodein getKodein() {
        return this;
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public KodeinContext<?> getKodeinContext() {
        return this.b;
    }

    @Override // org.kodein.di.KodeinAware
    @Nullable
    public KodeinTrigger getKodeinTrigger() {
        return this.c;
    }
}
