package androidx.constraintlayout.solver.widgets.analyzer;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import l6.g.b.b.a.b;
public class HorizontalWidgetRun extends WidgetRun {
    public static int[] e = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.b = DependencyNode.a.LEFT;
        this.end.b = DependencyNode.a.RIGHT;
        this.orientation = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void a() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.a;
        if (constraintWidget.measured) {
            this.c.resolve(constraintWidget.getWidth());
        }
        if (!this.c.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.a.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (((parent2 = this.a.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.a.mLeft.getMargin()) - this.a.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.a.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.a.mRight.getMargin());
                    this.c.resolve(width);
                    return;
                } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.c.resolve(this.a.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (((parent = this.a.getParent()) != null && parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                addTarget(this.start, parent.horizontalRun.start, this.a.mLeft.getMargin());
                addTarget(this.end, parent.horizontalRun.end, -this.a.mRight.getMargin());
                return;
            }
        }
        b bVar = this.c;
        if (bVar.resolved) {
            ConstraintWidget constraintWidget2 = this.a;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                    if (constraintAnchorArr[0].mTarget != null) {
                        DependencyNode target = getTarget(constraintAnchorArr[0]);
                        if (target != null) {
                            addTarget(this.start, target, this.a.mListAnchors[0].getMargin());
                            addTarget(this.end, this.start, this.c.value);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr[1].mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchorArr[1]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.a.mListAnchors[1].getMargin());
                            addTarget(this.start, this.end, -this.c.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.a.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        addTarget(this.start, this.a.getParent().horizontalRun.start, this.a.getX());
                        addTarget(this.end, this.start, this.c.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.isInHorizontalChain()) {
                    this.start.c = this.a.mListAnchors[0].getMargin();
                    this.end.c = -this.a.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode target3 = getTarget(this.a.mListAnchors[0]);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.a.mListAnchors[0].getMargin());
                    }
                    DependencyNode target4 = getTarget(this.a.mListAnchors[1]);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.a.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.a;
            int i = constraintWidget3.mMatchConstraintDefaultWidth;
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
            } else if (i == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    bVar.updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        this.c.g.add(this.a.verticalRun.c);
                        this.a.verticalRun.c.f.add(this.c);
                        VerticalWidgetRun verticalWidgetRun2 = this.a.verticalRun;
                        verticalWidgetRun2.c.updateDelegate = this;
                        this.c.g.add(verticalWidgetRun2.start);
                        this.c.g.add(this.a.verticalRun.end);
                        this.a.verticalRun.start.f.add(this.c);
                        this.a.verticalRun.end.f.add(this.c);
                    } else if (this.a.isInHorizontalChain()) {
                        this.a.verticalRun.c.g.add(this.c);
                        this.c.f.add(this.a.verticalRun.c);
                    } else {
                        this.a.verticalRun.c.g.add(this.c);
                    }
                } else {
                    b bVar4 = constraintWidget3.verticalRun.c;
                    bVar.g.add(bVar4);
                    bVar4.f.add(this.c);
                    this.a.verticalRun.start.f.add(this.c);
                    this.a.verticalRun.end.f.add(this.c);
                    b bVar5 = this.c;
                    bVar5.delegateToWidgetRun = true;
                    bVar5.f.add(this.start);
                    this.c.f.add(this.end);
                    this.start.g.add(this.c);
                    this.end.g.add(this.c);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.a;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        if (constraintAnchorArr2[0].mTarget == null || constraintAnchorArr2[1].mTarget == null) {
            if (constraintAnchorArr2[0].mTarget != null) {
                DependencyNode target5 = getTarget(constraintAnchorArr2[0]);
                if (target5 != null) {
                    addTarget(this.start, target5, this.a.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, 1, this.c);
                }
            } else if (constraintAnchorArr2[1].mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchorArr2[1]);
                if (target6 != null) {
                    addTarget(this.end, target6, -this.a.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -1, this.c);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
                addTarget(this.start, this.a.getParent().horizontalRun.start, this.a.getX());
                addTarget(this.end, this.start, 1, this.c);
            }
        } else if (constraintWidget4.isInHorizontalChain()) {
            this.start.c = this.a.mListAnchors[0].getMargin();
            this.end.c = -this.a.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.a.mListAnchors[0]);
            DependencyNode target8 = getTarget(this.a.mListAnchors[1]);
            target7.addDependency(this);
            target8.addDependency(this);
            this.mRunType = WidgetRun.a.CENTER;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.a.setX(dependencyNode.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void b() {
        this.b = null;
        this.start.clear();
        this.end.clear();
        this.c.clear();
        this.d = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean c() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.a.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public final void d(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    public void e() {
        this.d = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.c.resolved = false;
    }

    public String toString() {
        StringBuilder L = a.L("HorizontalRun ");
        L.append(this.a.getDebugName());
        return L.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02ba, code lost:
        if (r14 != 1) goto L_0x0322;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r17) {
        /*
        // Method dump skipped, instructions count: 1093
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }
}
