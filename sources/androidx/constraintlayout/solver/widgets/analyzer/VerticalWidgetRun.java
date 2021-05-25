package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import l6.g.b.b.a.a;
import l6.g.b.b.a.b;
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    public b e = null;

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.start.b = DependencyNode.a.TOP;
        this.end.b = DependencyNode.a.BOTTOM;
        dependencyNode.b = DependencyNode.a.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void a() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.a;
        if (constraintWidget.measured) {
            this.c.resolve(constraintWidget.getHeight());
        }
        if (!this.c.resolved) {
            this.dimensionBehavior = this.a.getVerticalDimensionBehaviour();
            if (this.a.hasBaseline()) {
                this.e = new a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.a.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.a.mTop.getMargin()) - this.a.mBottom.getMargin();
                    addTarget(this.start, parent2.verticalRun.start, this.a.mTop.getMargin());
                    addTarget(this.end, parent2.verticalRun.end, -this.a.mBottom.getMargin());
                    this.c.resolve(height);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.c.resolve(this.a.getHeight());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.a.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.verticalRun.start, this.a.mTop.getMargin());
            addTarget(this.end, parent.verticalRun.end, -this.a.mBottom.getMargin());
            return;
        }
        b bVar = this.c;
        boolean z = bVar.resolved;
        if (z) {
            ConstraintWidget constraintWidget2 = this.a;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                if (constraintAnchorArr[2].mTarget != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.c = this.a.mListAnchors[2].getMargin();
                        this.end.c = -this.a.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = getTarget(this.a.mListAnchors[2]);
                        if (target != null) {
                            addTarget(this.start, target, this.a.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = getTarget(this.a.mListAnchors[3]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.a.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (this.a.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.a.getBaselineDistance());
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[2].mTarget != null) {
                    DependencyNode target3 = getTarget(constraintAnchorArr[2]);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.a.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, this.c.value);
                        if (this.a.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.a.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[3].mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchorArr[3]);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.a.mListAnchors[3].getMargin());
                        addTarget(this.start, this.end, -this.c.value);
                    }
                    if (this.a.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.a.getBaselineDistance());
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[4].mTarget != null) {
                    DependencyNode target5 = getTarget(constraintAnchorArr[4]);
                    if (target5 != null) {
                        addTarget(this.baseline, target5, 0);
                        addTarget(this.start, this.baseline, -this.a.getBaselineDistance());
                        addTarget(this.end, this.start, this.c.value);
                        return;
                    }
                    return;
                } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.a.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    addTarget(this.start, this.a.getParent().verticalRun.start, this.a.getY());
                    addTarget(this.end, this.start, this.c.value);
                    if (this.a.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.a.getBaselineDistance());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        if (z || this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            bVar.addDependency(this);
        } else {
            ConstraintWidget constraintWidget3 = this.a;
            int i = constraintWidget3.mMatchConstraintDefaultHeight;
            if (i == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    b bVar2 = parent3.verticalRun.c;
                    this.c.g.add(bVar2);
                    bVar2.f.add(this.c);
                    b bVar3 = this.c;
                    bVar3.delegateToWidgetRun = true;
                    bVar3.f.add(this.start);
                    this.c.f.add(this.end);
                }
            } else if (i == 3 && !constraintWidget3.isInVerticalChain()) {
                ConstraintWidget constraintWidget4 = this.a;
                if (constraintWidget4.mMatchConstraintDefaultWidth != 3) {
                    b bVar4 = constraintWidget4.horizontalRun.c;
                    this.c.g.add(bVar4);
                    bVar4.f.add(this.c);
                    b bVar5 = this.c;
                    bVar5.delegateToWidgetRun = true;
                    bVar5.f.add(this.start);
                    this.c.f.add(this.end);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.a;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
        if (constraintAnchorArr2[2].mTarget != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget5.isInVerticalChain()) {
                this.start.c = this.a.mListAnchors[2].getMargin();
                this.end.c = -this.a.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = getTarget(this.a.mListAnchors[2]);
                DependencyNode target7 = getTarget(this.a.mListAnchors[3]);
                target6.addDependency(this);
                target7.addDependency(this);
                this.mRunType = WidgetRun.a.CENTER;
            }
            if (this.a.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.e);
            }
        } else if (constraintAnchorArr2[2].mTarget != null) {
            DependencyNode target8 = getTarget(constraintAnchorArr2[2]);
            if (target8 != null) {
                addTarget(this.start, target8, this.a.mListAnchors[2].getMargin());
                addTarget(this.end, this.start, 1, this.c);
                if (this.a.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.e);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.a.getDimensionRatio() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.a.horizontalRun;
                    if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour3) {
                        horizontalWidgetRun.c.f.add(this.c);
                        this.c.g.add(this.a.horizontalRun.c);
                        this.c.updateDelegate = this;
                    }
                }
            }
        } else if (constraintAnchorArr2[3].mTarget != null) {
            DependencyNode target9 = getTarget(constraintAnchorArr2[3]);
            if (target9 != null) {
                addTarget(this.end, target9, -this.a.mListAnchors[3].getMargin());
                addTarget(this.start, this.end, -1, this.c);
                if (this.a.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.e);
                }
            }
        } else if (constraintAnchorArr2[4].mTarget != null) {
            DependencyNode target10 = getTarget(constraintAnchorArr2[4]);
            if (target10 != null) {
                addTarget(this.baseline, target10, 0);
                addTarget(this.start, this.baseline, -1, this.e);
                addTarget(this.end, this.start, 1, this.c);
            }
        } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.getParent() != null) {
            addTarget(this.start, this.a.getParent().verticalRun.start, this.a.getY());
            addTarget(this.end, this.start, 1, this.c);
            if (this.a.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.e);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour4 == dimensionBehaviour5 && this.a.getDimensionRatio() > 0.0f) {
                HorizontalWidgetRun horizontalWidgetRun2 = this.a.horizontalRun;
                if (horizontalWidgetRun2.dimensionBehavior == dimensionBehaviour5) {
                    horizontalWidgetRun2.c.f.add(this.c);
                    this.c.g.add(this.a.horizontalRun.c);
                    this.c.updateDelegate = this;
                }
            }
        }
        if (this.c.g.size() == 0) {
            this.c.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.a.setY(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void b() {
        this.b = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.c.clear();
        this.d = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean c() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.a.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    public void d() {
        this.d = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.c.resolved = false;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("VerticalRun ");
        L.append(this.a.getDebugName());
        return L.toString();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        float f;
        float f2;
        int ordinal = this.mRunType.ordinal();
        if (ordinal == 1) {
            updateRunStart(dependency);
        } else if (ordinal == 2) {
            updateRunEnd(dependency);
        } else if (ordinal == 3) {
            ConstraintWidget constraintWidget = this.a;
            updateRunCenter(dependency, constraintWidget.mTop, constraintWidget.mBottom, 1);
            return;
        }
        b bVar = this.c;
        if (bVar.readyToSolve && !bVar.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.a;
            int i2 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i2 == 2) {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    b bVar2 = parent.verticalRun.c;
                    if (bVar2.resolved) {
                        float f3 = this.a.mMatchConstraintPercentHeight;
                        this.c.resolve((int) ((((float) bVar2.value) * f3) + 0.5f));
                    }
                }
            } else if (i2 == 3 && constraintWidget2.horizontalRun.c.resolved) {
                int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                if (dimensionRatioSide != -1) {
                    if (dimensionRatioSide == 0) {
                        ConstraintWidget constraintWidget3 = this.a;
                        i = (int) ((constraintWidget3.getDimensionRatio() * ((float) constraintWidget3.horizontalRun.c.value)) + 0.5f);
                    } else if (dimensionRatioSide != 1) {
                        i = 0;
                    } else {
                        ConstraintWidget constraintWidget4 = this.a;
                        f2 = (float) constraintWidget4.horizontalRun.c.value;
                        f = constraintWidget4.getDimensionRatio();
                    }
                    this.c.resolve(i);
                } else {
                    ConstraintWidget constraintWidget5 = this.a;
                    f2 = (float) constraintWidget5.horizontalRun.c.value;
                    f = constraintWidget5.getDimensionRatio();
                }
                i = (int) ((f2 / f) + 0.5f);
                this.c.resolve(i);
            }
        }
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.readyToSolve) {
                if (!dependencyNode.resolved || !dependencyNode2.resolved || !this.c.resolved) {
                    if (!this.c.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.a;
                        if (constraintWidget6.mMatchConstraintDefaultWidth == 0 && !constraintWidget6.isInVerticalChain()) {
                            int i3 = this.start.g.get(0).value;
                            DependencyNode dependencyNode3 = this.start;
                            int i4 = i3 + dependencyNode3.c;
                            int i5 = this.end.g.get(0).value + this.end.c;
                            dependencyNode3.resolve(i4);
                            this.end.resolve(i5);
                            this.c.resolve(i5 - i4);
                            return;
                        }
                    }
                    if (!this.c.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.g.size() > 0 && this.end.g.size() > 0) {
                        int i6 = (this.end.g.get(0).value + this.end.c) - (this.start.g.get(0).value + this.start.c);
                        b bVar3 = this.c;
                        int i7 = bVar3.h;
                        if (i6 < i7) {
                            bVar3.resolve(i6);
                        } else {
                            bVar3.resolve(i7);
                        }
                    }
                    if (this.c.resolved && this.start.g.size() > 0 && this.end.g.size() > 0) {
                        DependencyNode dependencyNode4 = this.start.g.get(0);
                        DependencyNode dependencyNode5 = this.end.g.get(0);
                        int i8 = dependencyNode4.value + this.start.c;
                        int i9 = dependencyNode5.value + this.end.c;
                        float verticalBiasPercent = this.a.getVerticalBiasPercent();
                        if (dependencyNode4 == dependencyNode5) {
                            i8 = dependencyNode4.value;
                            i9 = dependencyNode5.value;
                            verticalBiasPercent = 0.5f;
                        }
                        this.start.resolve((int) ((((float) ((i9 - i8) - this.c.value)) * verticalBiasPercent) + ((float) i8) + 0.5f));
                        this.end.resolve(this.start.value + this.c.value);
                    }
                }
            }
        }
    }
}
