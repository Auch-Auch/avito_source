package a2.j.b.d.v.l;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
public final class m implements ShapeAppearanceModel.CornerSizeUnaryOperator {
    public final /* synthetic */ RectF a;

    public m(RectF rectF) {
        this.a = rectF;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    @NonNull
    public CornerSize apply(@NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(this.a) / this.a.height());
    }
}
