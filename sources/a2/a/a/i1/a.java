package a2.a.a.i1;

import com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl;
import com.avito.android.item_visibility_tracker.TrackKey;
import kotlin.jvm.internal.Ref;
public final class a implements Runnable {
    public final /* synthetic */ ItemVisibilityTrackerImpl a;
    public final /* synthetic */ TrackKey b;
    public final /* synthetic */ Ref.ObjectRef c;

    public a(ItemVisibilityTrackerImpl itemVisibilityTrackerImpl, TrackKey trackKey, Ref.ObjectRef objectRef) {
        this.a = itemVisibilityTrackerImpl;
        this.b = trackKey;
        this.c = objectRef;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ItemVisibilityTrackerImpl.access$trackIfNeeded(this.a, this.b, this.c.element);
    }
}
