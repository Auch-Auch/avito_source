package a2.j.b.b.c1;

import android.view.View;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
public final /* synthetic */ class k implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView.h a;

    public /* synthetic */ k(StyledPlayerControlView.h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StyledPlayerControlView.h hVar = this.a;
        DefaultTrackSelector defaultTrackSelector = StyledPlayerControlView.this.y0;
        if (defaultTrackSelector != null) {
            DefaultTrackSelector.ParametersBuilder buildUpon = defaultTrackSelector.getParameters().buildUpon();
            for (int i = 0; i < hVar.c.size(); i++) {
                int intValue = hVar.c.get(i).intValue();
                buildUpon = buildUpon.clearSelectionOverrides(intValue).setRendererDisabled(intValue, true);
            }
            ((DefaultTrackSelector) Assertions.checkNotNull(StyledPlayerControlView.this.y0)).setParameters(buildUpon);
            StyledPlayerControlView.this.r0.dismiss();
        }
    }
}
