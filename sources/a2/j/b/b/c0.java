package a2.j.b.b;

import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
public final /* synthetic */ class c0 implements BasePlayer.ListenerInvocation {
    public static final /* synthetic */ c0 a = new c0();

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(Player.EventListener eventListener) {
        eventListener.onSeekProcessed();
    }
}
