package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;
import u6.a.j0.t0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a*\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "Lkotlin/time/Duration;", "stopTimeout", "replayExpiration", "Lkotlinx/coroutines/flow/SharingStarted;", "WhileSubscribed-9tZugJw", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;DD)Lkotlinx/coroutines/flow/SharingStarted;", "WhileSubscribed", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class SharingStartedKt {
    @ExperimentalTime
    @NotNull
    /* renamed from: WhileSubscribed-9tZugJw  reason: not valid java name */
    public static final SharingStarted m517WhileSubscribed9tZugJw(@NotNull SharingStarted.Companion companion, double d, double d2) {
        return new t0(Duration.m480toLongMillisecondsimpl(d), Duration.m480toLongMillisecondsimpl(d2));
    }

    /* renamed from: WhileSubscribed-9tZugJw$default  reason: not valid java name */
    public static /* synthetic */ SharingStarted m518WhileSubscribed9tZugJw$default(SharingStarted.Companion companion, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = Duration.Companion.m489getZEROUwyO8pc();
        }
        if ((i & 2) != 0) {
            d2 = Duration.Companion.m488getINFINITEUwyO8pc();
        }
        return m517WhileSubscribed9tZugJw(companion, d, d2);
    }
}
