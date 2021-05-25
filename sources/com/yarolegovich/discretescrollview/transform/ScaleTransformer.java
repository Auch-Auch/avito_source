package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import androidx.annotation.FloatRange;
import com.yarolegovich.discretescrollview.transform.Pivot;
public class ScaleTransformer implements DiscreteScrollItemTransformer {
    public Pivot a = Pivot.X.CENTER.create();
    public Pivot b = Pivot.Y.CENTER.create();
    public float c = 0.8f;
    public float d = 0.2f;

    public static class Builder {
        public ScaleTransformer a = new ScaleTransformer();
        public float b = 1.0f;

        public ScaleTransformer build() {
            ScaleTransformer scaleTransformer = this.a;
            scaleTransformer.d = this.b - scaleTransformer.c;
            return scaleTransformer;
        }

        public Builder setMaxScale(@FloatRange(from = 0.01d) float f) {
            this.b = f;
            return this;
        }

        public Builder setMinScale(@FloatRange(from = 0.01d) float f) {
            this.a.c = f;
            return this;
        }

        public Builder setPivotX(Pivot.X x) {
            return setPivotX(x.create());
        }

        public Builder setPivotY(Pivot.Y y) {
            return setPivotY(y.create());
        }

        public Builder setPivotX(Pivot pivot) {
            if (pivot.getAxis() == 0) {
                this.a.a = pivot;
                return this;
            }
            throw new IllegalArgumentException("You passed a Pivot for wrong axis.");
        }

        public Builder setPivotY(Pivot pivot) {
            if (pivot.getAxis() == 1) {
                this.a.b = pivot;
                return this;
            }
            throw new IllegalArgumentException("You passed a Pivot for wrong axis.");
        }
    }

    @Override // com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer
    public void transformItem(View view, float f) {
        this.a.setOn(view);
        this.b.setOn(view);
        float abs = 1.0f - Math.abs(f);
        float f2 = (this.d * abs) + this.c;
        view.setScaleX(f2);
        view.setScaleY(f2);
    }
}
