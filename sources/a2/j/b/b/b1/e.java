package a2.j.b.b.b1;

import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import java.util.Objects;
public final /* synthetic */ class e implements TrackSelectionUtil.AdaptiveTrackSelectionFactory {
    public final /* synthetic */ RandomTrackSelection.Factory a;

    public /* synthetic */ e(RandomTrackSelection.Factory factory) {
        this.a = factory;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
    public final TrackSelection createAdaptiveTrackSelection(TrackSelection.Definition definition) {
        RandomTrackSelection.Factory factory = this.a;
        Objects.requireNonNull(factory);
        return new RandomTrackSelection(definition.group, definition.tracks, factory.a);
    }
}
