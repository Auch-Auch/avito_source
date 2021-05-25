package l6.z;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
@RequiresApi(29)
public class u extends t {
    @Override // l6.z.q, l6.z.v
    public float b(@NonNull View view) {
        return view.getTransitionAlpha();
    }

    @Override // l6.z.r, l6.z.v
    public void d(@NonNull View view, @Nullable Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // l6.z.s, l6.z.v
    public void e(@NonNull View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // l6.z.q, l6.z.v
    public void f(@NonNull View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // l6.z.t, l6.z.v
    public void g(@NonNull View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // l6.z.r, l6.z.v
    public void h(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // l6.z.r, l6.z.v
    public void i(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
