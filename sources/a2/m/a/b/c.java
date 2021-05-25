package a2.m.a.b;

import android.util.Range;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import java.util.Comparator;
public class c implements Comparator<Range<Integer>> {
    public final /* synthetic */ boolean a;

    public c(Camera2Engine camera2Engine, boolean z) {
        this.a = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public int compare(Range<Integer> range, Range<Integer> range2) {
        Range<Integer> range3 = range;
        Range<Integer> range4 = range2;
        if (this.a) {
            return (range3.getUpper().intValue() - range3.getLower().intValue()) - (range4.getUpper().intValue() - range4.getLower().intValue());
        }
        return (range4.getUpper().intValue() - range4.getLower().intValue()) - (range3.getUpper().intValue() - range3.getLower().intValue());
    }
}
