package l6.g.b.b.a;

import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;
public class e {
    public static int c;
    public WidgetRun a = null;
    public ArrayList<WidgetRun> b = new ArrayList<>();

    public e(WidgetRun widgetRun, int i) {
        c++;
        this.a = widgetRun;
    }

    public final boolean a(WidgetRun widgetRun, int i) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.a.isTerminalWidget[i]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.f) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).a) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it = ((ChainRun) widgetRun).e.iterator();
                    while (it.hasNext()) {
                        a(it.next(), i);
                    }
                } else if (!(widgetRun instanceof d)) {
                    widgetRun.a.isTerminalWidget[i] = false;
                }
                a(dependencyNode2.a, i);
            }
        }
        for (Dependency dependency2 : widgetRun.end.f) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).a) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).e.iterator();
                    while (it2.hasNext()) {
                        a(it2.next(), i);
                    }
                } else if (!(widgetRun instanceof d)) {
                    widgetRun.a.isTerminalWidget[i] = false;
                }
                a(dependencyNode.a, i);
            }
        }
        return false;
    }

    public final long b(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.a;
        if (widgetRun instanceof d) {
            return j;
        }
        int size = dependencyNode.f.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.f.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.a != widgetRun) {
                    j2 = Math.min(j2, b(dependencyNode2, ((long) dependencyNode2.c) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j2;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return Math.min(Math.min(j2, b(widgetRun.start, wrapDimension)), wrapDimension - ((long) widgetRun.start.c));
    }

    public final long c(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.a;
        if (widgetRun instanceof d) {
            return j;
        }
        int size = dependencyNode.f.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.f.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.a != widgetRun) {
                    j2 = Math.max(j2, c(dependencyNode2, ((long) dependencyNode2.c) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j2;
        }
        long wrapDimension = j + widgetRun.getWrapDimension();
        return Math.max(Math.max(j2, c(widgetRun.end, wrapDimension)), wrapDimension - ((long) widgetRun.end.c));
    }
}
