package a2.j.b.b.b1;

import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import java.util.Objects;
public final /* synthetic */ class d implements TrackSelectionUtil.AdaptiveTrackSelectionFactory {
    public final /* synthetic */ FixedTrackSelection.Factory a;

    public /* synthetic */ d(FixedTrackSelection.Factory factory) {
        this.a = factory;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
    public final TrackSelection createAdaptiveTrackSelection(TrackSelection.Definition definition) {
        FixedTrackSelection.Factory factory = this.a;
        Objects.requireNonNull(factory);
        return new FixedTrackSelection(definition.group, definition.tracks[0], factory.a, factory.b);
    }
}
