package a2.j.b.b.c1;

import android.view.View;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.Assertions;
public final /* synthetic */ class l implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView.j a;
    public final /* synthetic */ StyledPlayerControlView.i b;

    public /* synthetic */ l(StyledPlayerControlView.j jVar, StyledPlayerControlView.i iVar) {
        this.a = jVar;
        this.b = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DefaultTrackSelector defaultTrackSelector;
        StyledPlayerControlView.j jVar = this.a;
        StyledPlayerControlView.i iVar = this.b;
        if (!(jVar.e == null || (defaultTrackSelector = StyledPlayerControlView.this.y0) == null)) {
            DefaultTrackSelector.ParametersBuilder buildUpon = defaultTrackSelector.getParameters().buildUpon();
            for (int i = 0; i < jVar.c.size(); i++) {
                int intValue = jVar.c.get(i).intValue();
                if (intValue == iVar.a) {
                    buildUpon = buildUpon.setSelectionOverride(intValue, ((MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(jVar.e)).getTrackGroups(intValue), new DefaultTrackSelector.SelectionOverride(iVar.b, iVar.c)).setRendererDisabled(intValue, false);
                } else {
                    buildUpon = buildUpon.clearSelectionOverrides(intValue).setRendererDisabled(intValue, true);
                }
            }
            ((DefaultTrackSelector) Assertions.checkNotNull(StyledPlayerControlView.this.y0)).setParameters(buildUpon);
            jVar.d(iVar.d);
            StyledPlayerControlView.this.r0.dismiss();
        }
    }
}
