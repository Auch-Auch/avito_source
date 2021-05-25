package x6.c.e;

import java.util.Comparator;
import org.junit.runner.manipulation.Sorter;
import org.junit.runners.ParentRunner;
public class b implements Comparator<T> {
    public final /* synthetic */ Sorter a;
    public final /* synthetic */ ParentRunner b;

    public b(ParentRunner parentRunner, Sorter sorter) {
        this.b = parentRunner;
        this.a = sorter;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.a.compare(this.b.describeChild(t), this.b.describeChild(t2));
    }
}
