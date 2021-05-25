package kotlin.random;

import com.avito.android.remote.auth.AuthSource;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "impl", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", AuthSource.BOOKING_ORDER, "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "implStorage", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 b = new FallbackThreadLocalRandom$implStorage$1();

    @Override // kotlin.random.AbstractPlatformRandom
    @NotNull
    public Random getImpl() {
        Object obj = this.b.get();
        Intrinsics.checkNotNullExpressionValue(obj, "implStorage.get()");
        return (Random) obj;
    }
}
