package a2.j.b.d.o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapePath;
import java.util.List;
public class b extends ShapePath.c {
    public final /* synthetic */ List b;
    public final /* synthetic */ Matrix c;

    public b(ShapePath shapePath, List list, Matrix matrix) {
        this.b = list;
        this.c = matrix;
    }

    @Override // com.google.android.material.shape.ShapePath.c
    public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
        for (ShapePath.c cVar : this.b) {
            cVar.a(this.c, shadowRenderer, i, canvas);
        }
    }
}
