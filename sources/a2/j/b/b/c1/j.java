package a2.j.b.b.c1;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView.f a;

    public /* synthetic */ j(StyledPlayerControlView.f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StyledPlayerControlView.f fVar = this.a;
        StyledPlayerControlView.a(StyledPlayerControlView.this, fVar.getAdapterPosition());
    }
}
