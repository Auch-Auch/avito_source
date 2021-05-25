package a2.j.b.b;

import a2.j.b.b.d0;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
public final /* synthetic */ class o implements BasePlayer.ListenerInvocation {
    public final /* synthetic */ d0.b a;

    public /* synthetic */ o(d0.b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(Player.EventListener eventListener) {
        j0 j0Var = this.a.a;
        eventListener.onPlayerStateChanged(j0Var.j, j0Var.d);
    }
}
