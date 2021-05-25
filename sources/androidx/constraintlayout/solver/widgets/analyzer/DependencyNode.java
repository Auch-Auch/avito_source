package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.List;
import l6.g.b.b.a.b;
public class DependencyNode implements Dependency {
    public WidgetRun a;
    public a b = a.UNKNOWN;
    public int c;
    public int d = 1;
    public boolean delegateToWidgetRun = false;
    public b e = null;
    public List<Dependency> f = new ArrayList();
    public List<DependencyNode> g = new ArrayList();
    public boolean readyToSolve = false;
    public boolean resolved = false;
    public Dependency updateDelegate = null;
    public int value;

    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.a = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.f.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.g.clear();
        this.f.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String str;
        String debugName = this.a.a.getDebugName();
        a aVar = this.b;
        if (aVar == a.LEFT || aVar == a.RIGHT) {
            str = a2.b.a.a.a.c3(debugName, "_HORIZONTAL");
        } else {
            str = a2.b.a.a.a.c3(debugName, "_VERTICAL");
        }
        StringBuilder Q = a2.b.a.a.a.Q(str, ":");
        Q.append(this.b.name());
        return Q.toString();
    }

    public void resolve(int i) {
        if (!this.resolved) {
            this.resolved = true;
            this.value = i;
            for (Dependency dependency : this.f) {
                dependency.update(dependency);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.a.getDebugName());
        sb.append(":");
        sb.append(this.b);
        sb.append("(");
        sb.append(this.resolved ? Integer.valueOf(this.value) : "unresolved");
        sb.append(") <t=");
        sb.append(this.g.size());
        sb.append(":d=");
        sb.append(this.f.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        for (DependencyNode dependencyNode : this.g) {
            if (!dependencyNode.resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.a.update(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i = 0;
        for (DependencyNode dependencyNode3 : this.g) {
            if (!(dependencyNode3 instanceof b)) {
                i++;
                dependencyNode2 = dependencyNode3;
            }
        }
        if (dependencyNode2 != null && i == 1 && dependencyNode2.resolved) {
            b bVar = this.e;
            if (bVar != null) {
                if (bVar.resolved) {
                    this.c = this.d * bVar.value;
                } else {
                    return;
                }
            }
            resolve(dependencyNode2.value + this.c);
        }
        Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
