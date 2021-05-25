package a2.m.a.b;

import com.otaliastudios.cameraview.engine.Camera1Engine;
import java.util.Comparator;
public class a implements Comparator<int[]> {
    public a(Camera1Engine camera1Engine) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return (iArr4[1] - iArr4[0]) - (iArr3[1] - iArr3[0]);
    }
}
