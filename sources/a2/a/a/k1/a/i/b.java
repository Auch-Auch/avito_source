package a2.a.a.k1.a.i;

import com.avito.android.lib.design.segmented_control.SegmentedControl;
public final class b implements Runnable {
    public final /* synthetic */ SegmentedControl a;

    public b(SegmentedControl segmentedControl) {
        this.a = segmentedControl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e();
        this.a.d();
        SegmentedControl.access$invalidateSegments(this.a);
        SegmentedControl segmentedControl = this.a;
        segmentedControl.setItemsSelectedState(segmentedControl.getCurrentSelected());
    }
}
