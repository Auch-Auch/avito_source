package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class Pivot {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public int a;
    public int b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public enum X {
        LEFT {
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public Pivot create() {
                return new Pivot(0, 0);
            }
        },
        CENTER {
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public Pivot create() {
                return new Pivot(0, -1);
            }
        },
        RIGHT {
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public Pivot create() {
                return new Pivot(0, -2);
            }
        };

        /* access modifiers changed from: public */
        X(a aVar) {
        }

        public abstract Pivot create();
    }

    public enum Y {
        TOP {
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public Pivot create() {
                return new Pivot(1, 0);
            }
        },
        CENTER {
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public Pivot create() {
                return new Pivot(1, -1);
            }
        },
        BOTTOM {
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public Pivot create() {
                return new Pivot(1, -2);
            }
        };

        /* access modifiers changed from: public */
        Y(a aVar) {
        }

        public abstract Pivot create();
    }

    public Pivot(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int getAxis() {
        return this.a;
    }

    public void setOn(View view) {
        int i = this.a;
        if (i == 0) {
            int i2 = this.b;
            if (i2 == -2) {
                view.setPivotX((float) view.getWidth());
            } else if (i2 != -1) {
                view.setPivotX((float) i2);
            } else {
                view.setPivotX(((float) view.getWidth()) * 0.5f);
            }
        } else if (i == 1) {
            int i3 = this.b;
            if (i3 == -2) {
                view.setPivotY((float) view.getHeight());
            } else if (i3 != -1) {
                view.setPivotY((float) i3);
            } else {
                view.setPivotY(((float) view.getHeight()) * 0.5f);
            }
        }
    }
}
