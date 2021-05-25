package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import l6.g.b.b.a.b;
import l6.g.b.b.a.e;
public abstract class WidgetRun implements Dependency {
    public ConstraintWidget a;
    public e b;
    public b c = new b(this);
    public boolean d = false;
    public ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end = new DependencyNode(this);
    public a mRunType = a.NONE;
    public int matchConstraintsType;
    public int orientation = 0;
    public DependencyNode start = new DependencyNode(this);

    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.a = constraintWidget;
    }

    public abstract void a();

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.g.add(dependencyNode2);
        dependencyNode.c = i;
        dependencyNode2.f.add(dependencyNode);
    }

    public abstract void applyToWidget();

    public abstract void b();

    public abstract boolean c();

    public final int getLimitedDimension(int i, int i2) {
        int i3;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.a;
            int i4 = constraintWidget.mMatchConstraintMaxWidth;
            i3 = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i4 > 0) {
                i3 = Math.min(i4, i);
            }
            if (i3 == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.a;
            int i5 = constraintWidget2.mMatchConstraintMaxHeight;
            i3 = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i5 > 0) {
                i3 = Math.min(i5, i);
            }
            if (i3 == i) {
                return i;
            }
        }
        return i3;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int ordinal = constraintAnchor2.mType.ordinal();
        if (ordinal == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (ordinal == 2) {
            return constraintWidget.verticalRun.start;
        }
        if (ordinal == 3) {
            return constraintWidget.horizontalRun.end;
        }
        if (ordinal == 4) {
            return constraintWidget.verticalRun.end;
        }
        if (ordinal != 5) {
            return null;
        }
        return constraintWidget.verticalRun.baseline;
    }

    public long getWrapDimension() {
        b bVar = this.c;
        if (bVar.resolved) {
            return (long) bVar.value;
        }
        return 0;
    }

    public boolean isCenterConnection() {
        int size = this.start.g.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.start.g.get(i2).a != this) {
                i++;
            }
        }
        int size2 = this.end.g.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.end.g.get(i3).a != this) {
                i++;
            }
        }
        if (i >= 2) {
            return true;
        }
        return false;
    }

    public boolean isDimensionResolved() {
        return this.c.resolved;
    }

    public boolean isResolved() {
        return this.d;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r8.matchConstraintsType == 3) goto L_0x00c5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateRunCenter(androidx.constraintlayout.solver.widgets.analyzer.Dependency r11, androidx.constraintlayout.solver.widgets.ConstraintAnchor r12, androidx.constraintlayout.solver.widgets.ConstraintAnchor r13, int r14) {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.updateRunCenter(androidx.constraintlayout.solver.widgets.analyzer.Dependency, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int):void");
    }

    public void updateRunEnd(Dependency dependency) {
    }

    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i) {
        int i2;
        b bVar = this.c;
        if (!bVar.resolved) {
            return 0;
        }
        long j = (long) bVar.value;
        if (isCenterConnection()) {
            i2 = this.start.c - this.end.c;
        } else if (i != 0) {
            return j - ((long) this.end.c);
        } else {
            i2 = this.start.c;
        }
        return j + ((long) i2);
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, b bVar) {
        dependencyNode.g.add(dependencyNode2);
        dependencyNode.g.add(this.c);
        dependencyNode.d = i;
        dependencyNode.e = bVar;
        dependencyNode2.f.add(dependencyNode);
        bVar.f.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int ordinal = constraintAnchor2.mType.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return widgetRun.start;
        }
        if (ordinal == 3 || ordinal == 4) {
            return widgetRun.end;
        }
        return null;
    }
}
