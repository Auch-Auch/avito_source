package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.u.a;
import t6.u.b;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/random/Random;", "Ljava/util/Random;", "asJavaRandom", "(Lkotlin/random/Random;)Ljava/util/Random;", "asKotlinRandom", "(Ljava/util/Random;)Lkotlin/random/Random;", "", "hi26", "low27", "", "doubleFromParts", "(II)D", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class PlatformRandomKt {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random asJavaRandom(@NotNull Random random) {
        Random impl;
        Intrinsics.checkNotNullParameter(random, "$this$asJavaRandom");
        AbstractPlatformRandom abstractPlatformRandom = (AbstractPlatformRandom) (!(random instanceof AbstractPlatformRandom) ? null : random);
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new a(random) : impl;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random asKotlinRandom(@NotNull Random random) {
        Random random2;
        Intrinsics.checkNotNullParameter(random, "$this$asKotlinRandom");
        a aVar = (a) (!(random instanceof a) ? null : random);
        return (aVar == null || (random2 = aVar.b) == null) ? new b(random) : random2;
    }

    public static final double doubleFromParts(int i, int i2) {
        return ((double) ((((long) i) << 27) + ((long) i2))) / ((double) 9007199254740992L);
    }
}
