package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    public final ArrayList<ConstraintWidget> a = new ArrayList<>();
    public Measure b = new Measure();
    public ConstraintWidgetContainer c;

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.c = constraintWidgetContainer;
    }

    public final boolean a(Measurer measurer, ConstraintWidget constraintWidget, int i) {
        this.b.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.b.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.b.horizontalDimension = constraintWidget.getWidth();
        this.b.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.b;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.b.measuredWidth);
        constraintWidget.setHeight(this.b.measuredHeight);
        constraintWidget.setHasBaseline(this.b.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.b.measuredBaseline);
        Measure measure2 = this.b;
        measure2.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    public final void b(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i);
        constraintWidgetContainer.setHeight(i2);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.c.layout();
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x01d5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long solverMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31) {
        /*
        // Method dump skipped, instructions count: 1003
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.solverMeasure(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, int, int, int, int, int, int, int, int, int):long");
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.a.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.a.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
