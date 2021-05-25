package kotlin.coroutines.jvm.internal;

import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "completion", "probeCoroutineCreated", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", TextureMediaEncoder.FRAME_EVENT, "", "probeCoroutineResumed", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineSuspended", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class DebugProbesKt {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return continuation;
    }

    @SinceKotlin(version = "1.3")
    public static final void probeCoroutineResumed(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, TextureMediaEncoder.FRAME_EVENT);
    }

    @SinceKotlin(version = "1.3")
    public static final void probeCoroutineSuspended(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, TextureMediaEncoder.FRAME_EVENT);
    }
}
