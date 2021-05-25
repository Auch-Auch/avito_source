package l6.g.b.b.a;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
public class d extends WidgetRun {
    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void a() {
        ConstraintWidget constraintWidget = this.a;
        if (constraintWidget instanceof Barrier) {
            this.start.delegateToWidgetRun = true;
            Barrier barrier = (Barrier) constraintWidget;
            int barrierType = barrier.getBarrierType();
            boolean allowsGoneWidget = barrier.allowsGoneWidget();
            int i = 0;
            if (barrierType == 0) {
                this.start.b = DependencyNode.a.LEFT;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.horizontalRun.start;
                        dependencyNode.f.add(this.start);
                        this.start.g.add(dependencyNode);
                    }
                    i++;
                }
                d(this.a.horizontalRun.start);
                d(this.a.horizontalRun.end);
            } else if (barrierType == 1) {
                this.start.b = DependencyNode.a.RIGHT;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.horizontalRun.end;
                        dependencyNode2.f.add(this.start);
                        this.start.g.add(dependencyNode2);
                    }
                    i++;
                }
                d(this.a.horizontalRun.start);
                d(this.a.horizontalRun.end);
            } else if (barrierType == 2) {
                this.start.b = DependencyNode.a.TOP;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.verticalRun.start;
                        dependencyNode3.f.add(this.start);
                        this.start.g.add(dependencyNode3);
                    }
                    i++;
                }
                d(this.a.verticalRun.start);
                d(this.a.verticalRun.end);
            } else if (barrierType == 3) {
                this.start.b = DependencyNode.a.BOTTOM;
                while (i < barrier.mWidgetsCount) {
                    ConstraintWidget constraintWidget5 = barrier.mWidgets[i];
                    if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.verticalRun.end;
                        dependencyNode4.f.add(this.start);
                        this.start.g.add(dependencyNode4);
                    }
                    i++;
                }
                d(this.a.verticalRun.start);
                d(this.a.verticalRun.end);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        ConstraintWidget constraintWidget = this.a;
        if (constraintWidget instanceof Barrier) {
            int barrierType = ((Barrier) constraintWidget).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.a.setX(this.start.value);
            } else {
                this.a.setY(this.start.value);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void b() {
        this.b = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean c() {
        return false;
    }

    public final void d(DependencyNode dependencyNode) {
        this.start.f.add(dependencyNode);
        dependencyNode.g.add(this.start);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Barrier barrier = (Barrier) this.a;
        int barrierType = barrier.getBarrierType();
        int i = 0;
        int i2 = -1;
        for (DependencyNode dependencyNode : this.start.g) {
            int i3 = dependencyNode.value;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            this.start.resolve(barrier.getMargin() + i2);
        } else {
            this.start.resolve(barrier.getMargin() + i);
        }
    }
}
