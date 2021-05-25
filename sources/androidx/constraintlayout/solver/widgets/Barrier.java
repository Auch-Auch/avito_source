package androidx.constraintlayout.solver.widgets;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public int S = 0;
    public boolean T = true;
    public int U = 0;
    public boolean V = false;

    public Barrier() {
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        Object[] objArr;
        boolean z2;
        int i;
        int i2;
        int i3;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        constraintAnchorArr[0] = this.mLeft;
        constraintAnchorArr[2] = this.mTop;
        constraintAnchorArr[1] = this.mRight;
        constraintAnchorArr[3] = this.mBottom;
        int i4 = 0;
        while (true) {
            objArr = this.mListAnchors;
            if (i4 >= objArr.length) {
                break;
            }
            objArr[i4].e = linearSystem.createObjectVariable(objArr[i4]);
            i4++;
        }
        int i5 = this.S;
        if (i5 >= 0 && i5 < 4) {
            ConstraintAnchor constraintAnchor = objArr[i5];
            if (!this.V) {
                allSolved();
            }
            if (this.V) {
                this.V = false;
                int i6 = this.S;
                if (i6 == 0 || i6 == 1) {
                    linearSystem.addEquality(this.mLeft.e, this.mX);
                    linearSystem.addEquality(this.mRight.e, this.mX);
                } else if (i6 == 2 || i6 == 3) {
                    linearSystem.addEquality(this.mTop.e, this.mY);
                    linearSystem.addEquality(this.mBottom.e, this.mY);
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.mWidgetsCount) {
                        z2 = false;
                        break;
                    }
                    ConstraintWidget constraintWidget = this.mWidgets[i7];
                    if ((this.T || constraintWidget.allowedInBarrier()) && ((((i2 = this.S) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i3 = this.S) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                        break;
                    }
                    i7++;
                }
                z2 = true;
                boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
                boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
                boolean z5 = !z2 && (((i = this.S) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))));
                int i8 = 5;
                if (!z5) {
                    i8 = 4;
                }
                for (int i9 = 0; i9 < this.mWidgetsCount; i9++) {
                    ConstraintWidget constraintWidget2 = this.mWidgets[i9];
                    if (this.T || constraintWidget2.allowedInBarrier()) {
                        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.S]);
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                        int i10 = this.S;
                        constraintAnchorArr2[i10].e = createObjectVariable;
                        int i11 = (constraintAnchorArr2[i10].mTarget == null || constraintAnchorArr2[i10].mTarget.mOwner != this) ? 0 : constraintAnchorArr2[i10].mMargin + 0;
                        if (i10 == 0 || i10 == 2) {
                            linearSystem.addLowerBarrier(constraintAnchor.e, createObjectVariable, this.U - i11, z2);
                        } else {
                            linearSystem.addGreaterBarrier(constraintAnchor.e, createObjectVariable, this.U + i11, z2);
                        }
                        linearSystem.addEquality(constraintAnchor.e, createObjectVariable, this.U + i11, i8);
                    }
                }
                int i12 = this.S;
                if (i12 == 0) {
                    linearSystem.addEquality(this.mRight.e, this.mLeft.e, 0, 8);
                    linearSystem.addEquality(this.mLeft.e, this.mParent.mRight.e, 0, 4);
                    linearSystem.addEquality(this.mLeft.e, this.mParent.mLeft.e, 0, 0);
                } else if (i12 == 1) {
                    linearSystem.addEquality(this.mLeft.e, this.mRight.e, 0, 8);
                    linearSystem.addEquality(this.mLeft.e, this.mParent.mLeft.e, 0, 4);
                    linearSystem.addEquality(this.mLeft.e, this.mParent.mRight.e, 0, 0);
                } else if (i12 == 2) {
                    linearSystem.addEquality(this.mBottom.e, this.mTop.e, 0, 8);
                    linearSystem.addEquality(this.mTop.e, this.mParent.mBottom.e, 0, 4);
                    linearSystem.addEquality(this.mTop.e, this.mParent.mTop.e, 0, 0);
                } else if (i12 == 3) {
                    linearSystem.addEquality(this.mTop.e, this.mBottom.e, 0, 8);
                    linearSystem.addEquality(this.mTop.e, this.mParent.mTop.e, 0, 4);
                    linearSystem.addEquality(this.mTop.e, this.mParent.mBottom.e, 0, 0);
                }
            }
        }
    }

    public boolean allSolved() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.mWidgetsCount;
            if (i4 >= i) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i4];
            if ((this.T || constraintWidget.allowedInBarrier()) && ((((i2 = this.S) == 0 || i2 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i3 = this.S) == 2 || i3 == 3) && !constraintWidget.isResolvedVertically()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i6];
            if (this.T || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i7 = this.S;
                    if (i7 == 0) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i7 == 1) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i7 == 2) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i7 == 3) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z2 = true;
                }
                int i8 = this.S;
                if (i8 == 0) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i9 = i5 + this.U;
        int i10 = this.S;
        if (i10 == 0 || i10 == 1) {
            setFinalHorizontal(i9, i9);
        } else {
            setFinalVertical(i9, i9);
        }
        this.V = true;
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.T;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.S = barrier.S;
        this.T = barrier.T;
        this.U = barrier.U;
    }

    public int getBarrierType() {
        return this.S;
    }

    public int getMargin() {
        return this.U;
    }

    public int getOrientation() {
        int i = this.S;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.V;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.V;
    }

    public void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            int i2 = this.S;
            if (i2 == 0 || i2 == 1) {
                constraintWidget.setInBarrier(0, true);
            } else if (i2 == 2 || i2 == 3) {
                constraintWidget.setInBarrier(1, true);
            }
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.T = z;
    }

    public void setBarrierType(int i) {
        this.S = i;
    }

    public void setMargin(int i) {
        this.U = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        StringBuilder L = a.L("[Barrier] ");
        L.append(getDebugName());
        L.append(" {");
        String sb = L.toString();
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                sb = a.c3(sb, ", ");
            }
            StringBuilder L2 = a.L(sb);
            L2.append(constraintWidget.getDebugName());
            sb = L2.toString();
        }
        return a.c3(sb, "}");
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}
