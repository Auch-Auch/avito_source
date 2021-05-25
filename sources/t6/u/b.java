package t6.u;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;
import org.jetbrains.annotations.NotNull;
public final class b extends AbstractPlatformRandom {
    @NotNull
    public final Random b;

    public b(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "impl");
        this.b = random;
    }

    @Override // kotlin.random.AbstractPlatformRandom
    @NotNull
    public Random getImpl() {
        return this.b;
    }
}
