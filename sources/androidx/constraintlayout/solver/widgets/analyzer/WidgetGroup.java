package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
public class WidgetGroup {
    public static int g;
    public ArrayList<ConstraintWidget> a = new ArrayList<>();
    public int b = -1;
    public boolean c = false;
    public int d = 0;
    public ArrayList<a> e = null;
    public int f = -1;

    public class a {
        public WeakReference<ConstraintWidget> a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public a(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
            this.a = new WeakReference<>(constraintWidget);
            this.b = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.c = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.d = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.e = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.f = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.g = i;
        }
    }

    public WidgetGroup(int i) {
        int i2 = g;
        g = i2 + 1;
        this.b = i2;
        this.d = i;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.a.contains(constraintWidget)) {
            return false;
        }
        this.a.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.e != null && this.c) {
            for (int i = 0; i < this.e.size(); i++) {
                a aVar = this.e.get(i);
                ConstraintWidget constraintWidget = aVar.a.get();
                if (constraintWidget != null) {
                    constraintWidget.setFinalFrame(aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g);
                }
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.a.size();
        if (this.f != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.f == widgetGroup.b) {
                    moveTo(this.d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.a.clear();
    }

    public int getId() {
        return this.b;
    }

    public int getOrientation() {
        return this.d;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        for (int i = 0; i < this.a.size(); i++) {
            if (widgetGroup.a.contains(this.a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.c;
    }

    public int measureWrap(LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        if (this.a.size() == 0) {
            return 0;
        }
        ArrayList<ConstraintWidget> arrayList = this.a;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.get(i4).addToSolver(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.e = new ArrayList<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.e.add(new a(this, arrayList.get(i5), linearSystem, i));
        }
        if (i == 0) {
            i2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            i3 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            i2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            i3 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return i3 - i2;
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i == 0) {
                next.horizontalGroup = widgetGroup.getId();
            } else {
                next.verticalGroup = widgetGroup.getId();
            }
        }
        this.f = widgetGroup.b;
    }

    public void setAuthoritative(boolean z) {
        this.c = z;
    }

    public void setOrientation(int i) {
        this.d = i;
    }

    public int size() {
        return this.a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.d;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        sb.append(" [");
        String j = a2.b.a.a.a.j(sb, this.b, "] <");
        Iterator<ConstraintWidget> it = this.a.iterator();
        while (it.hasNext()) {
            StringBuilder Q = a2.b.a.a.a.Q(j, " ");
            Q.append(it.next().getDebugName());
            j = Q.toString();
        }
        return a2.b.a.a.a.c3(j, " >");
    }
}
