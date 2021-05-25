package a2.a.a.a2.b;

import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.Player;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class a implements ControlDispatcher {
    @NotNull
    public final ControlDispatcher a;

    public a(@NotNull ControlDispatcher controlDispatcher) {
        Intrinsics.checkNotNullParameter(controlDispatcher, "dispatcher");
        this.a = controlDispatcher;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchFastForward(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchFastForward(player);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchNext(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchNext(player);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchPrepare(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchPrepare(player);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchPrevious(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchPrevious(player);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchRewind(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchRewind(player);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(@NotNull Player player, int i, long j) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchSeekTo(player, i, j);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(@NotNull Player player, boolean z) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchSetPlayWhenReady(player, z);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(@NotNull Player player, int i) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchSetRepeatMode(player, i);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(@NotNull Player player, boolean z) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchSetShuffleModeEnabled(player, z);
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchStop(@NotNull Player player, boolean z) {
        Intrinsics.checkNotNullParameter(player, "p0");
        return this.a.dispatchStop(player, z);
    }

    @NotNull
    public final ControlDispatcher getDispatcher() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isFastForwardEnabled() {
        return this.a.isFastForwardEnabled();
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean isRewindEnabled() {
        return this.a.isRewindEnabled();
    }

    public final boolean shouldShowPauseButton(@Nullable Player player) {
        return (player == null || player.getPlaybackState() == 4 || player.getPlaybackState() == 1 || !player.getPlayWhenReady()) ? false : true;
    }
}
