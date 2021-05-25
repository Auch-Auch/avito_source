package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
public class GuidelineReference implements Reference {
    public final State a;
    public int b;
    public Guideline c;
    public int d = -1;
    public int e = -1;
    public float f = 0.0f;
    public Object g;

    public GuidelineReference(State state) {
        this.a = state;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        this.c.setOrientation(this.b);
        int i = this.d;
        if (i != -1) {
            this.c.setGuideBegin(i);
            return;
        }
        int i2 = this.e;
        if (i2 != -1) {
            this.c.setGuideEnd(i2);
        } else {
            this.c.setGuidePercent(this.f);
        }
    }

    public void end(Object obj) {
        this.d = -1;
        this.e = this.a.convertDimension(obj);
        this.f = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.c == null) {
            this.c = new Guideline();
        }
        return this.c;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.g;
    }

    public int getOrientation() {
        return this.b;
    }

    public void percent(float f2) {
        this.d = -1;
        this.e = -1;
        this.f = f2;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof Guideline) {
            this.c = (Guideline) constraintWidget;
        } else {
            this.c = null;
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object obj) {
        this.g = obj;
    }

    public void setOrientation(int i) {
        this.b = i;
    }

    public void start(Object obj) {
        this.d = this.a.convertDimension(obj);
        this.e = -1;
        this.f = 0.0f;
    }
}
