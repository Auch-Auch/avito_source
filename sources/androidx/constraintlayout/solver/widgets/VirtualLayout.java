package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
public class VirtualLayout extends HelperWidget {
    public int S = 0;
    public int T = 0;
    public int U = 0;
    public int V = 0;
    public int W = 0;
    public int X = 0;
    public boolean Y = false;
    public int Z = 0;
    public int a0 = 0;
    public BasicMeasure.Measurer b0 = null;
    public BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();

    public void applyRtl(boolean z) {
        int i = this.U;
        if (i <= 0 && this.V <= 0) {
            return;
        }
        if (z) {
            this.W = this.V;
            this.X = i;
            return;
        }
        this.W = i;
        this.X = this.V;
    }

    public void captureWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public int getMeasuredHeight() {
        return this.a0;
    }

    public int getMeasuredWidth() {
        return this.Z;
    }

    public int getPaddingBottom() {
        return this.T;
    }

    public int getPaddingLeft() {
        return this.W;
    }

    public int getPaddingRight() {
        return this.X;
    }

    public int getPaddingTop() {
        return this.S;
    }

    public void measure(int i, int i2, int i3, int i4) {
    }

    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.b0 == null && getParent() != null) {
            this.b0 = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.b0.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    public boolean measureChildren() {
        ConstraintWidget constraintWidget = this.mParent;
        BasicMeasure.Measurer measurer = constraintWidget != null ? ((ConstraintWidgetContainer) constraintWidget).getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.mWidgets[i];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                    z = false;
                }
                if (!z) {
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.mMeasure;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget2.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget2.getHeight();
                    measurer.measure(constraintWidget2, this.mMeasure);
                    constraintWidget2.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget2.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget2.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
            i++;
        }
    }

    public boolean needSolverPass() {
        return this.Y;
    }

    public void needsCallbackFromSolver(boolean z) {
        this.Y = z;
    }

    public void setMeasure(int i, int i2) {
        this.Z = i;
        this.a0 = i2;
    }

    public void setPadding(int i) {
        this.S = i;
        this.T = i;
        this.U = i;
        this.V = i;
    }

    public void setPaddingBottom(int i) {
        this.T = i;
    }

    public void setPaddingEnd(int i) {
        this.V = i;
    }

    public void setPaddingLeft(int i) {
        this.W = i;
    }

    public void setPaddingRight(int i) {
        this.X = i;
    }

    public void setPaddingStart(int i) {
        this.U = i;
        this.W = i;
        this.X = i;
    }

    public void setPaddingTop(int i) {
        this.S = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }
}
