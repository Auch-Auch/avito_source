package a2.j.b.d.o;

import androidx.annotation.NonNull;
import com.google.android.material.shape.AdjustedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
public class a implements ShapeAppearanceModel.CornerSizeUnaryOperator {
    public final /* synthetic */ float a;

    public a(MaterialShapeDrawable materialShapeDrawable, float f) {
        this.a = f;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    @NonNull
    public CornerSize apply(@NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(this.a, cornerSize);
    }
}
