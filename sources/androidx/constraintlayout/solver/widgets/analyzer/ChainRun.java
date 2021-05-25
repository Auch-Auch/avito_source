package androidx.constraintlayout.solver.widgets.analyzer;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;
public class ChainRun extends WidgetRun {
    public ArrayList<WidgetRun> e = new ArrayList<>();
    public int f;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.orientation = i;
        ConstraintWidget constraintWidget2 = this.a;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(i);
        while (true) {
            constraintWidget2 = previousChainMember;
            if (constraintWidget2 == null) {
                break;
            }
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.a = constraintWidget2;
        this.e.add(constraintWidget2.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.e.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.e.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i2 = this.orientation;
            if (i2 == 0) {
                next.a.horizontalChainRun = this;
            } else if (i2 == 1) {
                next.a.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.a.getParent()).isRtl()) && this.e.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.e;
            this.a = arrayList.get(arrayList.size() - 1).a;
        }
        this.f = this.orientation == 0 ? this.a.getHorizontalChainStyle() : this.a.getVerticalChainStyle();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void a() {
        Iterator<WidgetRun> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        int size = this.e.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.e.get(0).a;
            ConstraintWidget constraintWidget2 = this.e.get(size - 1).a;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget d = d();
                if (d != null) {
                    margin = d.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget e2 = e();
                if (e2 != null) {
                    margin2 = e2.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget d2 = d();
                if (d2 != null) {
                    margin3 = d2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget e3 = e();
                if (e3 != null) {
                    margin4 = e3.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void b() {
        this.b = null;
        Iterator<WidgetRun> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean c() {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            if (!this.e.get(i).c()) {
                return false;
            }
        }
        return true;
    }

    public final ConstraintWidget d() {
        for (int i = 0; i < this.e.size(); i++) {
            WidgetRun widgetRun = this.e.get(i);
            if (widgetRun.a.getVisibility() != 8) {
                return widgetRun.a;
            }
        }
        return null;
    }

    public final ConstraintWidget e() {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.e.get(size);
            if (widgetRun.a.getVisibility() != 8) {
                return widgetRun.a;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.e.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.e.get(i);
            j = ((long) widgetRun.end.c) + widgetRun.getWrapDimension() + j + ((long) widgetRun.start.c);
        }
        return j;
    }

    public String toString() {
        StringBuilder L = a.L("ChainRun ");
        L.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String sb = L.toString();
        Iterator<WidgetRun> it = this.e.iterator();
        while (it.hasNext()) {
            String c3 = a.c3(sb, "<");
            sb = a.c3(c3 + it.next(), "> ");
        }
        return sb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a6, code lost:
        if (r1 != r7) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01cc, code lost:
        if (r1 != r7) goto L_0x01ce;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00eb  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r26) {
        /*
        // Method dump skipped, instructions count: 1090
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.ChainRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }
}
