package a2.m.a.c;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
public class a implements Comparable<a> {
    public final RectF a;
    public final int b;

    public a(@NonNull RectF rectF, int i) {
        this.a = rectF;
        this.b = i;
    }

    public final void a(@NonNull RectF rectF, @NonNull PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull a aVar) {
        return -Integer.valueOf(this.b).compareTo(Integer.valueOf(aVar.b));
    }
}
