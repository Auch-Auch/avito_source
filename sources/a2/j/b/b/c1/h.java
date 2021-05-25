package a2.j.b.b.c1;

import android.view.View;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.R;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
public final /* synthetic */ class h implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView.b a;

    public /* synthetic */ h(StyledPlayerControlView.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StyledPlayerControlView.b bVar = this.a;
        DefaultTrackSelector defaultTrackSelector = StyledPlayerControlView.this.y0;
        if (defaultTrackSelector != null) {
            DefaultTrackSelector.ParametersBuilder buildUpon = defaultTrackSelector.getParameters().buildUpon();
            for (int i = 0; i < bVar.c.size(); i++) {
                buildUpon = buildUpon.clearSelectionOverrides(bVar.c.get(i).intValue());
            }
            ((DefaultTrackSelector) Assertions.checkNotNull(StyledPlayerControlView.this.y0)).setParameters(buildUpon);
        }
        StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
        StyledPlayerControlView.e eVar = styledPlayerControlView.p0;
        eVar.d[1] = styledPlayerControlView.getResources().getString(R.string.exo_track_selection_auto);
        StyledPlayerControlView.this.r0.dismiss();
    }
}
