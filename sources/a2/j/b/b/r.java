package a2.j.b.b;

import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Player;
import java.util.concurrent.TimeoutException;
public final /* synthetic */ class r implements BasePlayer.ListenerInvocation {
    public static final /* synthetic */ r a = new r();

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(Player.EventListener eventListener) {
        eventListener.onPlayerError(ExoPlaybackException.createForTimeout(new TimeoutException("Setting foreground mode timed out."), 2));
    }
}
