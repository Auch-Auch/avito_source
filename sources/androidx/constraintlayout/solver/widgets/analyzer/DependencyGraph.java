package androidx.constraintlayout.solver.widgets.analyzer;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import l6.g.b.b.a.b;
import l6.g.b.b.a.c;
import l6.g.b.b.a.d;
import l6.g.b.b.a.e;
public class DependencyGraph {
    public ConstraintWidgetContainer a;
    public boolean b = true;
    public boolean c = true;
    public ConstraintWidgetContainer d;
    public ArrayList<WidgetRun> e = new ArrayList<>();
    public BasicMeasure.Measurer f;
    public BasicMeasure.Measure g;
    public ArrayList<e> h;

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        new ArrayList();
        this.f = null;
        this.g = new BasicMeasure.Measure();
        this.h = new ArrayList<>();
        this.a = constraintWidgetContainer;
        this.d = constraintWidgetContainer;
    }

    public final void a(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<e> arrayList, e eVar) {
        WidgetRun widgetRun = dependencyNode.a;
        if (widgetRun.b == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.a;
            if (!(widgetRun == constraintWidgetContainer.horizontalRun || widgetRun == constraintWidgetContainer.verticalRun)) {
                if (eVar == null) {
                    eVar = new e(widgetRun, i2);
                    arrayList.add(eVar);
                }
                widgetRun.b = eVar;
                eVar.b.add(widgetRun);
                for (Dependency dependency : widgetRun.start.f) {
                    if (dependency instanceof DependencyNode) {
                        a((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, eVar);
                    }
                }
                for (Dependency dependency2 : widgetRun.end.f) {
                    if (dependency2 instanceof DependencyNode) {
                        a((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, eVar);
                    }
                }
                if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.f) {
                        if (dependency3 instanceof DependencyNode) {
                            a((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, eVar);
                        }
                    }
                }
                for (DependencyNode dependencyNode3 : widgetRun.start.g) {
                    a(dependencyNode3, i, 0, dependencyNode2, arrayList, eVar);
                }
                for (DependencyNode dependencyNode4 : widgetRun.end.g) {
                    a(dependencyNode4, i, 1, dependencyNode2, arrayList, eVar);
                }
                if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (DependencyNode dependencyNode5 : ((VerticalWidgetRun) widgetRun).baseline.g) {
                        a(dependencyNode5, i, 2, dependencyNode2, arrayList, eVar);
                    }
                }
            }
        }
    }

    public final boolean b(ConstraintWidgetContainer constraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        int i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        int i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour5 == dimensionBehaviour7 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour7 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour7 && dimensionBehaviour6 == dimensionBehaviour7) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour5 == dimensionBehaviour8 && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                if (dimensionBehaviour6 == dimensionBehaviour8 && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour5;
                int i3 = next.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i3;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour6;
                int i4 = next.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i4;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour5 == dimensionBehaviour9 || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour6 == dimensionBehaviour9 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int width = next.getWidth();
                    if (dimensionBehaviour5 == dimensionBehaviour9) {
                        i = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i = width;
                        dimensionBehaviour3 = dimensionBehaviour5;
                    }
                    int height = next.getHeight();
                    if (dimensionBehaviour6 == dimensionBehaviour9) {
                        i2 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i2 = height;
                        dimensionBehaviour4 = dimensionBehaviour6;
                    }
                    e(next, dimensionBehaviour3, i, dimensionBehaviour4, i2);
                    next.horizontalRun.c.resolve(next.getWidth());
                    next.verticalRun.c.resolve(next.getHeight());
                    next.measured = true;
                } else {
                    if (dimensionBehaviour5 == dimensionBehaviour8 && (dimensionBehaviour6 == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i3 == 3) {
                            if (dimensionBehaviour6 == dimensionBehaviour2) {
                                e(next, dimensionBehaviour2, 0, dimensionBehaviour2, 0);
                            }
                            int height2 = next.getHeight();
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.FIXED;
                            e(next, dimensionBehaviour10, (int) ((((float) height2) * next.mDimensionRatio) + 0.5f), dimensionBehaviour10, height2);
                            next.horizontalRun.c.resolve(next.getWidth());
                            next.verticalRun.c.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i3 == 1) {
                            e(next, dimensionBehaviour2, 0, dimensionBehaviour6, 0);
                            next.horizontalRun.c.h = next.getWidth();
                        } else if (i3 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviourArr2[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour11 == dimensionBehaviour12 || dimensionBehaviourArr2[0] == dimensionBehaviour9) {
                                e(next, dimensionBehaviour12, (int) ((next.mMatchConstraintPercentWidth * ((float) constraintWidgetContainer.getWidth())) + 0.5f), dimensionBehaviour6, next.getHeight());
                                next.horizontalRun.c.resolve(next.getWidth());
                                next.verticalRun.c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                e(next, dimensionBehaviour2, 0, dimensionBehaviour6, 0);
                                next.horizontalRun.c.resolve(next.getWidth());
                                next.verticalRun.c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour6 == dimensionBehaviour8 && (dimensionBehaviour5 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i4 == 3) {
                            if (dimensionBehaviour5 == dimensionBehaviour) {
                                e(next, dimensionBehaviour, 0, dimensionBehaviour, 0);
                            }
                            int width2 = next.getWidth();
                            float f2 = next.mDimensionRatio;
                            if (next.getDimensionRatioSide() == -1) {
                                f2 = 1.0f / f2;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.FIXED;
                            e(next, dimensionBehaviour13, width2, dimensionBehaviour13, (int) ((((float) width2) * f2) + 0.5f));
                            next.horizontalRun.c.resolve(next.getWidth());
                            next.verticalRun.c.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i4 == 1) {
                            e(next, dimensionBehaviour5, 0, dimensionBehaviour, 0);
                            next.verticalRun.c.h = next.getHeight();
                        } else if (i4 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = dimensionBehaviourArr3[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour14 == dimensionBehaviour15 || dimensionBehaviourArr3[1] == dimensionBehaviour9) {
                                e(next, dimensionBehaviour5, next.getWidth(), dimensionBehaviour15, (int) ((next.mMatchConstraintPercentHeight * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                                next.horizontalRun.c.resolve(next.getWidth());
                                next.verticalRun.c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                e(next, dimensionBehaviour, 0, dimensionBehaviour6, 0);
                                next.horizontalRun.c.resolve(next.getWidth());
                                next.verticalRun.c.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour5 == dimensionBehaviour8 && dimensionBehaviour6 == dimensionBehaviour8) {
                        if (i3 == 1 || i4 == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            e(next, dimensionBehaviour16, 0, dimensionBehaviour16, 0);
                            next.horizontalRun.c.h = next.getWidth();
                            next.verticalRun.c.h = next.getHeight();
                        } else if (i4 == 2 && i3 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = dimensionBehaviourArr4[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour17 == dimensionBehaviour18 || dimensionBehaviourArr4[0] == dimensionBehaviour18) {
                                if (dimensionBehaviourArr4[1] == dimensionBehaviour18 || dimensionBehaviourArr4[1] == dimensionBehaviour18) {
                                    e(next, dimensionBehaviour18, (int) ((next.mMatchConstraintPercentWidth * ((float) constraintWidgetContainer.getWidth())) + 0.5f), dimensionBehaviour18, (int) ((next.mMatchConstraintPercentHeight * ((float) constraintWidgetContainer.getHeight())) + 0.5f));
                                    next.horizontalRun.c.resolve(next.getWidth());
                                    next.verticalRun.c.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void buildGraph() {
        buildGraph(this.e);
        this.h.clear();
        e.c = 0;
        d(this.a.horizontalRun, 0, this.h);
        d(this.a.verticalRun, 1, this.h);
        this.b = false;
    }

    public final int c(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        DependencyGraph dependencyGraph = this;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int size = dependencyGraph.h.size();
        long j = 0;
        long j2 = 0;
        int i2 = 0;
        while (i2 < size) {
            e eVar = dependencyGraph.h.get(i2);
            WidgetRun widgetRun = eVar.a;
            if (widgetRun instanceof ChainRun) {
                if (((ChainRun) widgetRun).orientation != i) {
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
            } else if (i == 0) {
                if (!(widgetRun instanceof HorizontalWidgetRun)) {
                    j = Math.max(j, j2);
                    i2++;
                    j2 = 0;
                    dependencyGraph = this;
                    constraintWidgetContainer2 = constraintWidgetContainer;
                }
            } else if (!(widgetRun instanceof VerticalWidgetRun)) {
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            }
            DependencyNode dependencyNode = (i == 0 ? constraintWidgetContainer2.horizontalRun : constraintWidgetContainer2.verticalRun).start;
            DependencyNode dependencyNode2 = (i == 0 ? constraintWidgetContainer2.horizontalRun : constraintWidgetContainer2.verticalRun).end;
            boolean contains = widgetRun.start.g.contains(dependencyNode);
            boolean contains2 = eVar.a.end.g.contains(dependencyNode2);
            long wrapDimension = eVar.a.getWrapDimension();
            if (!contains || !contains2) {
                if (contains) {
                    DependencyNode dependencyNode3 = eVar.a.start;
                    j2 = Math.max(eVar.c(dependencyNode3, (long) dependencyNode3.c), ((long) eVar.a.start.c) + wrapDimension);
                } else if (contains2) {
                    DependencyNode dependencyNode4 = eVar.a.end;
                    j2 = Math.max(-eVar.b(dependencyNode4, (long) dependencyNode4.c), ((long) (-eVar.a.end.c)) + wrapDimension);
                } else {
                    WidgetRun widgetRun2 = eVar.a;
                    j2 = (widgetRun2.getWrapDimension() + ((long) widgetRun2.start.c)) - ((long) eVar.a.end.c);
                }
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            } else {
                long c2 = eVar.c(eVar.a.start, j2);
                long b2 = eVar.b(eVar.a.end, j2);
                long j3 = c2 - wrapDimension;
                WidgetRun widgetRun3 = eVar.a;
                int i3 = widgetRun3.end.c;
                if (j3 >= ((long) (-i3))) {
                    j3 += (long) i3;
                }
                long j4 = (long) widgetRun3.start.c;
                long j5 = ((-b2) - wrapDimension) - j4;
                if (j5 >= j4) {
                    j5 -= j4;
                }
                float biasPercent = widgetRun3.a.getBiasPercent(i);
                float f2 = (float) (biasPercent > 0.0f ? (long) ((((float) j3) / (1.0f - biasPercent)) + (((float) j5) / biasPercent)) : 0);
                long b3 = ((long) ((f2 * biasPercent) + 0.5f)) + wrapDimension + ((long) a.b(1.0f, biasPercent, f2, 0.5f));
                WidgetRun widgetRun4 = eVar.a;
                j2 = (((long) widgetRun4.start.c) + b3) - ((long) widgetRun4.end.c);
                j = Math.max(j, j2);
                i2++;
                j2 = 0;
                dependencyGraph = this;
                constraintWidgetContainer2 = constraintWidgetContainer;
            }
        }
        return (int) j;
    }

    public final void d(WidgetRun widgetRun, int i, ArrayList<e> arrayList) {
        for (Dependency dependency : widgetRun.start.f) {
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                a(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.f) {
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                a(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.f) {
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.b) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.a.mChildren.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z = true;
                }
            }
            if (!z) {
                Iterator<e> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    e next2 = it2.next();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    boolean z2 = dimensionBehaviour == dimensionBehaviour3;
                    boolean z3 = dimensionBehaviour2 == dimensionBehaviour3;
                    Objects.requireNonNull(next2);
                    if (z2) {
                        WidgetRun widgetRun = next2.a;
                        if (widgetRun instanceof HorizontalWidgetRun) {
                            next2.a(widgetRun, 0);
                        }
                    }
                    if (z3) {
                        WidgetRun widgetRun2 = next2.a;
                        if (widgetRun2 instanceof VerticalWidgetRun) {
                            next2.a(widgetRun2, 1);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x018a, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean directMeasure(boolean r10) {
        /*
        // Method dump skipped, instructions count: 433
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph.directMeasure(boolean):boolean");
    }

    public boolean directMeasureSetup(boolean z) {
        if (this.b) {
            Iterator<ConstraintWidget> it = this.a.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.c.resolved = false;
                horizontalWidgetRun.d = false;
                horizontalWidgetRun.e();
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.c.resolved = false;
                verticalWidgetRun.d = false;
                verticalWidgetRun.d();
            }
            this.a.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.a;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.c.resolved = false;
            horizontalWidgetRun2.d = false;
            horizontalWidgetRun2.e();
            VerticalWidgetRun verticalWidgetRun2 = this.a.verticalRun;
            verticalWidgetRun2.c.resolved = false;
            verticalWidgetRun2.d = false;
            verticalWidgetRun2.d();
            buildGraph();
        }
        b(this.d);
        this.a.setX(0);
        this.a.setY(0);
        this.a.horizontalRun.start.resolve(0);
        this.a.verticalRun.start.resolve(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0143 A[EDGE_INSN: B:78:0x0143->B:62:0x0143 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean directMeasureWithOrientation(boolean r10, int r11) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph.directMeasureWithOrientation(boolean, int):boolean");
    }

    public final void e(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        BasicMeasure.Measure measure = this.g;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.f.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.g.measuredWidth);
        constraintWidget.setHeight(this.g.measuredHeight);
        constraintWidget.setHasBaseline(this.g.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.g.measuredBaseline);
    }

    public void invalidateGraph() {
        this.b = true;
    }

    public void invalidateMeasures() {
        this.c = true;
    }

    public void measureWidgets() {
        b bVar;
        Iterator<ConstraintWidget> it = this.a.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i = next.mMatchConstraintDefaultWidth;
                int i2 = next.mMatchConstraintDefaultHeight;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                b bVar2 = next.horizontalRun.c;
                boolean z3 = bVar2.resolved;
                b bVar3 = next.verticalRun.c;
                boolean z4 = bVar3.resolved;
                if (z3 && z4) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    e(next, dimensionBehaviour4, bVar2.value, dimensionBehaviour4, bVar3.value);
                    next.measured = true;
                } else if (z3 && z) {
                    e(next, ConstraintWidget.DimensionBehaviour.FIXED, bVar2.value, dimensionBehaviour3, bVar3.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.verticalRun.c.h = next.getHeight();
                    } else {
                        next.verticalRun.c.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z4 && z2) {
                    e(next, dimensionBehaviour3, bVar2.value, ConstraintWidget.DimensionBehaviour.FIXED, bVar3.value);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.horizontalRun.c.h = next.getWidth();
                    } else {
                        next.horizontalRun.c.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (bVar = next.verticalRun.e) != null) {
                    bVar.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.f = measurer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.d.horizontalRun.b();
        this.d.verticalRun.b();
        arrayList.add(this.d.horizontalRun);
        arrayList.add(this.d.verticalRun);
        Iterator<ConstraintWidget> it = this.d.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new c(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new d(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.a != this.d) {
                next2.a();
            }
        }
    }
}
