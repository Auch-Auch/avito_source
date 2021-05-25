package l6.g.b.b.a;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
public class c extends WidgetRun {
    public c(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.horizontalRun.b();
        constraintWidget.verticalRun.b();
        this.orientation = ((Guideline) constraintWidget).getOrientation();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void a() {
        Guideline guideline = (Guideline) this.a;
        int relativeBegin = guideline.getRelativeBegin();
        int relativeEnd = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (relativeBegin != -1) {
                this.start.g.add(this.a.mParent.horizontalRun.start);
                this.a.mParent.horizontalRun.start.f.add(this.start);
                this.start.c = relativeBegin;
            } else if (relativeEnd != -1) {
                this.start.g.add(this.a.mParent.horizontalRun.end);
                this.a.mParent.horizontalRun.end.f.add(this.start);
                this.start.c = -relativeEnd;
            } else {
                DependencyNode dependencyNode = this.start;
                dependencyNode.delegateToWidgetRun = true;
                dependencyNode.g.add(this.a.mParent.horizontalRun.end);
                this.a.mParent.horizontalRun.end.f.add(this.start);
            }
            d(this.a.horizontalRun.start);
            d(this.a.horizontalRun.end);
            return;
        }
        if (relativeBegin != -1) {
            this.start.g.add(this.a.mParent.verticalRun.start);
            this.a.mParent.verticalRun.start.f.add(this.start);
            this.start.c = relativeBegin;
        } else if (relativeEnd != -1) {
            this.start.g.add(this.a.mParent.verticalRun.end);
            this.a.mParent.verticalRun.end.f.add(this.start);
            this.start.c = -relativeEnd;
        } else {
            DependencyNode dependencyNode2 = this.start;
            dependencyNode2.delegateToWidgetRun = true;
            dependencyNode2.g.add(this.a.mParent.verticalRun.end);
            this.a.mParent.verticalRun.end.f.add(this.start);
        }
        d(this.a.verticalRun.start);
        d(this.a.verticalRun.end);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.a).getOrientation() == 1) {
            this.a.setX(this.start.value);
        } else {
            this.a.setY(this.start.value);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void b() {
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
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve && !dependencyNode.resolved) {
            this.start.resolve((int) ((((Guideline) this.a).getRelativePercent() * ((float) dependencyNode.g.get(0).value)) + 0.5f));
        }
    }
}
