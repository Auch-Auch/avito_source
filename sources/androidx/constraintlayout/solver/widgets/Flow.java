package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    public int A0 = 0;
    public int c0 = -1;
    public int d0 = -1;
    public int e0 = -1;
    public int f0 = -1;
    public int g0 = -1;
    public int h0 = -1;
    public float i0 = 0.5f;
    public float j0 = 0.5f;
    public float k0 = 0.5f;
    public float l0 = 0.5f;
    public float m0 = 0.5f;
    public float n0 = 0.5f;
    public int o0 = 0;
    public int p0 = 0;
    public int q0 = 2;
    public int r0 = 2;
    public int s0 = 0;
    public int t0 = -1;
    public int u0 = 0;
    public ArrayList<a> v0 = new ArrayList<>();
    public ConstraintWidget[] w0 = null;
    public ConstraintWidget[] x0 = null;
    public int[] y0 = null;
    public ConstraintWidget[] z0;

    public class a {
        public int a = 0;
        public ConstraintWidget b = null;
        public int c = 0;
        public ConstraintAnchor d;
        public ConstraintAnchor e;
        public ConstraintAnchor f;
        public ConstraintAnchor g;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
        public int p = 0;
        public int q = 0;

        public a(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.a = i2;
            this.d = constraintAnchor;
            this.e = constraintAnchor2;
            this.f = constraintAnchor3;
            this.g = constraintAnchor4;
            this.h = Flow.this.getPaddingLeft();
            this.i = Flow.this.getPaddingTop();
            this.j = Flow.this.getPaddingRight();
            this.k = Flow.this.getPaddingBottom();
            this.q = i3;
        }

        public void a(ConstraintWidget constraintWidget) {
            int i2 = 0;
            if (this.a == 0) {
                int f2 = Flow.this.f(constraintWidget, this.q);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.p++;
                    f2 = 0;
                }
                int i3 = Flow.this.o0;
                if (constraintWidget.getVisibility() != 8) {
                    i2 = i3;
                }
                this.l = f2 + i2 + this.l;
                int e2 = Flow.this.e(constraintWidget, this.q);
                if (this.b == null || this.c < e2) {
                    this.b = constraintWidget;
                    this.c = e2;
                    this.m = e2;
                }
            } else {
                int f3 = Flow.this.f(constraintWidget, this.q);
                int e3 = Flow.this.e(constraintWidget, this.q);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.p++;
                    e3 = 0;
                }
                int i4 = Flow.this.p0;
                if (constraintWidget.getVisibility() != 8) {
                    i2 = i4;
                }
                this.m = e3 + i2 + this.m;
                if (this.b == null || this.c < f3) {
                    this.b = constraintWidget;
                    this.c = f3;
                    this.l = f3;
                }
            }
            this.o++;
        }

        public void b(boolean z, int i2, boolean z2) {
            int i3;
            float f2;
            ConstraintWidget constraintWidget;
            int i4;
            float f3;
            int i5 = this.o;
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = this.n + i6;
                Flow flow = Flow.this;
                if (i7 >= flow.A0) {
                    break;
                }
                ConstraintWidget constraintWidget2 = flow.z0[i7];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (!(i5 == 0 || this.b == null)) {
                boolean z3 = z2 && i2 == 0;
                int i8 = -1;
                int i9 = -1;
                for (int i10 = 0; i10 < i5; i10++) {
                    int i11 = this.n + (z ? (i5 - 1) - i10 : i10);
                    Flow flow2 = Flow.this;
                    if (i11 >= flow2.A0) {
                        break;
                    }
                    if (flow2.z0[i11].getVisibility() == 0) {
                        if (i8 == -1) {
                            i8 = i10;
                        }
                        i9 = i10;
                    }
                }
                ConstraintWidget constraintWidget3 = null;
                if (this.a == 0) {
                    ConstraintWidget constraintWidget4 = this.b;
                    constraintWidget4.setVerticalChainStyle(Flow.this.d0);
                    int i12 = this.i;
                    if (i2 > 0) {
                        i12 += Flow.this.p0;
                    }
                    constraintWidget4.mTop.connect(this.e, i12);
                    if (z2) {
                        constraintWidget4.mBottom.connect(this.g, this.k);
                    }
                    if (i2 > 0) {
                        this.e.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                    }
                    if (Flow.this.r0 == 3 && !constraintWidget4.hasBaseline()) {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= i5) {
                                break;
                            }
                            int i14 = this.n + (z ? (i5 - 1) - i13 : i13);
                            Flow flow3 = Flow.this;
                            if (i14 >= flow3.A0) {
                                break;
                            }
                            constraintWidget = flow3.z0[i14];
                            if (constraintWidget.hasBaseline()) {
                                break;
                            }
                            i13++;
                        }
                    }
                    constraintWidget = constraintWidget4;
                    int i15 = 0;
                    while (i15 < i5) {
                        int i16 = z ? (i5 - 1) - i15 : i15;
                        int i17 = this.n + i16;
                        Flow flow4 = Flow.this;
                        if (i17 < flow4.A0) {
                            ConstraintWidget constraintWidget5 = flow4.z0[i17];
                            if (i15 == 0) {
                                constraintWidget5.connect(constraintWidget5.mLeft, this.d, this.h);
                            }
                            if (i16 == 0) {
                                Flow flow5 = Flow.this;
                                int i18 = flow5.c0;
                                float f4 = flow5.i0;
                                if (this.n != 0 || (i4 = flow5.e0) == -1) {
                                    if (z2 && (i4 = flow5.g0) != -1) {
                                        f3 = flow5.m0;
                                    }
                                    constraintWidget5.setHorizontalChainStyle(i18);
                                    constraintWidget5.setHorizontalBiasPercent(f4);
                                } else {
                                    f3 = flow5.k0;
                                }
                                f4 = f3;
                                i18 = i4;
                                constraintWidget5.setHorizontalChainStyle(i18);
                                constraintWidget5.setHorizontalBiasPercent(f4);
                            }
                            if (i15 == i5 - 1) {
                                constraintWidget5.connect(constraintWidget5.mRight, this.f, this.j);
                            }
                            if (constraintWidget3 != null) {
                                constraintWidget5.mLeft.connect(constraintWidget3.mRight, Flow.this.o0);
                                if (i15 == i8) {
                                    constraintWidget5.mLeft.setGoneMargin(this.h);
                                }
                                constraintWidget3.mRight.connect(constraintWidget5.mLeft, 0);
                                if (i15 == i9 + 1) {
                                    constraintWidget3.mRight.setGoneMargin(this.j);
                                }
                            }
                            if (constraintWidget5 != constraintWidget4) {
                                if (Flow.this.r0 != 3 || !constraintWidget.hasBaseline() || constraintWidget5 == constraintWidget || !constraintWidget5.hasBaseline()) {
                                    int i19 = Flow.this.r0;
                                    if (i19 == 0) {
                                        constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                    } else if (i19 == 1) {
                                        constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                    } else if (z3) {
                                        constraintWidget5.mTop.connect(this.e, this.i);
                                        constraintWidget5.mBottom.connect(this.g, this.k);
                                    } else {
                                        constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                        constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                    }
                                } else {
                                    constraintWidget5.mBaseline.connect(constraintWidget.mBaseline, 0);
                                }
                            }
                            i15++;
                            constraintWidget3 = constraintWidget5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                ConstraintWidget constraintWidget6 = this.b;
                constraintWidget6.setHorizontalChainStyle(Flow.this.c0);
                int i20 = this.h;
                if (i2 > 0) {
                    i20 += Flow.this.o0;
                }
                if (z) {
                    constraintWidget6.mRight.connect(this.f, i20);
                    if (z2) {
                        constraintWidget6.mLeft.connect(this.d, this.j);
                    }
                    if (i2 > 0) {
                        this.f.mOwner.mLeft.connect(constraintWidget6.mRight, 0);
                    }
                } else {
                    constraintWidget6.mLeft.connect(this.d, i20);
                    if (z2) {
                        constraintWidget6.mRight.connect(this.f, this.j);
                    }
                    if (i2 > 0) {
                        this.d.mOwner.mRight.connect(constraintWidget6.mLeft, 0);
                    }
                }
                int i21 = 0;
                while (i21 < i5) {
                    int i22 = this.n + i21;
                    Flow flow6 = Flow.this;
                    if (i22 < flow6.A0) {
                        ConstraintWidget constraintWidget7 = flow6.z0[i22];
                        if (i21 == 0) {
                            constraintWidget7.connect(constraintWidget7.mTop, this.e, this.i);
                            Flow flow7 = Flow.this;
                            int i23 = flow7.d0;
                            float f5 = flow7.j0;
                            if (this.n != 0 || (i3 = flow7.f0) == -1) {
                                if (z2 && (i3 = flow7.h0) != -1) {
                                    f2 = flow7.n0;
                                }
                                constraintWidget7.setVerticalChainStyle(i23);
                                constraintWidget7.setVerticalBiasPercent(f5);
                            } else {
                                f2 = flow7.l0;
                            }
                            f5 = f2;
                            i23 = i3;
                            constraintWidget7.setVerticalChainStyle(i23);
                            constraintWidget7.setVerticalBiasPercent(f5);
                        }
                        if (i21 == i5 - 1) {
                            constraintWidget7.connect(constraintWidget7.mBottom, this.g, this.k);
                        }
                        if (constraintWidget3 != null) {
                            constraintWidget7.mTop.connect(constraintWidget3.mBottom, Flow.this.p0);
                            if (i21 == i8) {
                                constraintWidget7.mTop.setGoneMargin(this.i);
                            }
                            constraintWidget3.mBottom.connect(constraintWidget7.mTop, 0);
                            if (i21 == i9 + 1) {
                                constraintWidget3.mBottom.setGoneMargin(this.k);
                            }
                        }
                        if (constraintWidget7 != constraintWidget6) {
                            if (z) {
                                int i24 = Flow.this.q0;
                                if (i24 == 0) {
                                    constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                } else if (i24 == 1) {
                                    constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                } else if (i24 == 2) {
                                    constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                    constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                }
                            } else {
                                int i25 = Flow.this.q0;
                                if (i25 == 0) {
                                    constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                } else if (i25 == 1) {
                                    constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                } else if (i25 == 2) {
                                    if (z3) {
                                        constraintWidget7.mLeft.connect(this.d, this.h);
                                        constraintWidget7.mRight.connect(this.f, this.j);
                                    } else {
                                        constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                        constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                    }
                                }
                                i21++;
                                constraintWidget3 = constraintWidget7;
                            }
                        }
                        i21++;
                        constraintWidget3 = constraintWidget7;
                    } else {
                        return;
                    }
                }
            }
        }

        public int c() {
            if (this.a == 1) {
                return this.m - Flow.this.p0;
            }
            return this.m;
        }

        public int d() {
            if (this.a == 0) {
                return this.l - Flow.this.o0;
            }
            return this.l;
        }

        public void e(int i2) {
            int i3 = this.p;
            if (i3 != 0) {
                int i4 = this.o;
                int i5 = i2 / i3;
                for (int i6 = 0; i6 < i4; i6++) {
                    int i7 = this.n;
                    int i8 = i7 + i6;
                    Flow flow = Flow.this;
                    if (i8 >= flow.A0) {
                        break;
                    }
                    ConstraintWidget constraintWidget = flow.z0[i7 + i6];
                    if (this.a == 0) {
                        if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                        }
                    } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                    }
                }
                this.l = 0;
                this.m = 0;
                this.b = null;
                this.c = 0;
                int i9 = this.o;
                for (int i10 = 0; i10 < i9; i10++) {
                    int i11 = this.n + i10;
                    Flow flow2 = Flow.this;
                    if (i11 < flow2.A0) {
                        ConstraintWidget constraintWidget2 = flow2.z0[i11];
                        if (this.a == 0) {
                            int width = constraintWidget2.getWidth();
                            int i12 = Flow.this.o0;
                            if (constraintWidget2.getVisibility() == 8) {
                                i12 = 0;
                            }
                            this.l = width + i12 + this.l;
                            int e2 = Flow.this.e(constraintWidget2, this.q);
                            if (this.b == null || this.c < e2) {
                                this.b = constraintWidget2;
                                this.c = e2;
                                this.m = e2;
                            }
                        } else {
                            int f2 = flow2.f(constraintWidget2, this.q);
                            int e3 = Flow.this.e(constraintWidget2, this.q);
                            int i13 = Flow.this.p0;
                            if (constraintWidget2.getVisibility() == 8) {
                                i13 = 0;
                            }
                            this.m = e3 + i13 + this.m;
                            if (this.b == null || this.c < f2) {
                                this.b = constraintWidget2;
                                this.c = f2;
                                this.l = f2;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void f(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.a = i2;
            this.d = constraintAnchor;
            this.e = constraintAnchor2;
            this.f = constraintAnchor3;
            this.g = constraintAnchor4;
            this.h = i3;
            this.i = i4;
            this.j = i5;
            this.k = i6;
            this.q = i7;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        ConstraintWidget constraintWidget;
        super.addToSolver(linearSystem, z);
        boolean isRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i = this.s0;
        if (i != 0) {
            if (i == 1) {
                int size = this.v0.size();
                int i2 = 0;
                while (i2 < size) {
                    this.v0.get(i2).b(isRtl, i2, i2 == size + -1);
                    i2++;
                }
            } else if (!(i != 2 || this.y0 == null || this.x0 == null || this.w0 == null)) {
                for (int i3 = 0; i3 < this.A0; i3++) {
                    this.z0[i3].resetAnchors();
                }
                int[] iArr = this.y0;
                int i4 = iArr[0];
                int i5 = iArr[1];
                ConstraintWidget constraintWidget2 = null;
                for (int i6 = 0; i6 < i4; i6++) {
                    ConstraintWidget constraintWidget3 = this.x0[isRtl ? (i4 - i6) - 1 : i6];
                    if (!(constraintWidget3 == null || constraintWidget3.getVisibility() == 8)) {
                        if (i6 == 0) {
                            constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                            constraintWidget3.setHorizontalChainStyle(this.c0);
                            constraintWidget3.setHorizontalBiasPercent(this.i0);
                        }
                        if (i6 == i4 - 1) {
                            constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                        }
                        if (i6 > 0) {
                            constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.o0);
                            constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                        }
                        constraintWidget2 = constraintWidget3;
                    }
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    ConstraintWidget constraintWidget4 = this.w0[i7];
                    if (!(constraintWidget4 == null || constraintWidget4.getVisibility() == 8)) {
                        if (i7 == 0) {
                            constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                            constraintWidget4.setVerticalChainStyle(this.d0);
                            constraintWidget4.setVerticalBiasPercent(this.j0);
                        }
                        if (i7 == i5 - 1) {
                            constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                        }
                        if (i7 > 0) {
                            constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.p0);
                            constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                        }
                        constraintWidget2 = constraintWidget4;
                    }
                }
                for (int i8 = 0; i8 < i4; i8++) {
                    for (int i9 = 0; i9 < i5; i9++) {
                        int i10 = (i9 * i4) + i8;
                        if (this.u0 == 1) {
                            i10 = (i8 * i5) + i9;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.z0;
                        if (!(i10 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i10]) == null || constraintWidget.getVisibility() == 8)) {
                            ConstraintWidget constraintWidget5 = this.x0[i8];
                            ConstraintWidget constraintWidget6 = this.w0[i9];
                            if (constraintWidget != constraintWidget5) {
                                constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                                constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                            }
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                                constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                            }
                        }
                    }
                }
            }
        } else if (this.v0.size() > 0) {
            this.v0.get(0).b(isRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.c0 = flow.c0;
        this.d0 = flow.d0;
        this.e0 = flow.e0;
        this.f0 = flow.f0;
        this.g0 = flow.g0;
        this.h0 = flow.h0;
        this.i0 = flow.i0;
        this.j0 = flow.j0;
        this.k0 = flow.k0;
        this.l0 = flow.l0;
        this.m0 = flow.m0;
        this.n0 = flow.n0;
        this.o0 = flow.o0;
        this.p0 = flow.p0;
        this.q0 = flow.q0;
        this.r0 = flow.r0;
        this.s0 = flow.s0;
        this.t0 = flow.t0;
        this.u0 = flow.u0;
    }

    public final int e(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * ((float) i));
                if (i3 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    public final int f(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * ((float) i));
                if (i3 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0116  */
    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    public void measure(int r35, int r36, int r37, int r38) {
        /*
        // Method dump skipped, instructions count: 1348
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measure(int, int, int, int):void");
    }

    public void setFirstHorizontalBias(float f) {
        this.k0 = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.e0 = i;
    }

    public void setFirstVerticalBias(float f) {
        this.l0 = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.f0 = i;
    }

    public void setHorizontalAlign(int i) {
        this.q0 = i;
    }

    public void setHorizontalBias(float f) {
        this.i0 = f;
    }

    public void setHorizontalGap(int i) {
        this.o0 = i;
    }

    public void setHorizontalStyle(int i) {
        this.c0 = i;
    }

    public void setLastHorizontalBias(float f) {
        this.m0 = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.g0 = i;
    }

    public void setLastVerticalBias(float f) {
        this.n0 = f;
    }

    public void setLastVerticalStyle(int i) {
        this.h0 = i;
    }

    public void setMaxElementsWrap(int i) {
        this.t0 = i;
    }

    public void setOrientation(int i) {
        this.u0 = i;
    }

    public void setVerticalAlign(int i) {
        this.r0 = i;
    }

    public void setVerticalBias(float f) {
        this.j0 = f;
    }

    public void setVerticalGap(int i) {
        this.p0 = i;
    }

    public void setVerticalStyle(int i) {
        this.d0 = i;
    }

    public void setWrapMode(int i) {
        this.s0 = i;
    }
}
