package a2.j.b.b.c1;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
public final /* synthetic */ class i implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView.d a;

    public /* synthetic */ i(StyledPlayerControlView.d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StyledPlayerControlView.d dVar = this.a;
        StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
        int adapterPosition = dVar.getAdapterPosition();
        if (adapterPosition == 0) {
            StyledPlayerControlView.g gVar = styledPlayerControlView.q0;
            gVar.c = styledPlayerControlView.s0;
            gVar.d = styledPlayerControlView.v0;
            styledPlayerControlView.n0 = 0;
            styledPlayerControlView.d(gVar);
        } else if (adapterPosition == 1) {
            styledPlayerControlView.n0 = 1;
            styledPlayerControlView.d(styledPlayerControlView.A0);
        } else {
            styledPlayerControlView.r0.dismiss();
        }
    }
}
