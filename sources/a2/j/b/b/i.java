package a2.j.b.b;

import a2.j.b.b.d0;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
public final /* synthetic */ class i implements BasePlayer.ListenerInvocation {
    public final /* synthetic */ d0.b a;

    public /* synthetic */ i(d0.b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(Player.EventListener eventListener) {
        d0.b bVar = this.a;
        eventListener.onPlayWhenReadyChanged(bVar.a.j, bVar.j);
    }
}
