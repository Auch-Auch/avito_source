package junit.framework;

import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.Sorter;
public class JUnit4TestAdapter implements Test, Filterable, Orderable, Describable {
    public final Class<?> a;
    public final Runner b;
    public final JUnit4TestAdapterCache c;

    public JUnit4TestAdapter(Class<?> cls) {
        this(cls, JUnit4TestAdapterCache.getDefault());
    }

    public final Description a(Description description) {
        if (description.getAnnotation(Ignore.class) != null) {
            return Description.EMPTY;
        }
        Description childlessCopy = description.childlessCopy();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            Description a3 = a(it.next());
            if (!a3.isEmpty()) {
                childlessCopy.addChild(a3);
            }
        }
        return childlessCopy;
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return this.b.testCount();
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        filter.apply(this.b);
    }

    @Override // org.junit.runner.Describable
    public Description getDescription() {
        return a(this.b.getDescription());
    }

    public Class<?> getTestClass() {
        return this.a;
    }

    public List<Test> getTests() {
        return this.c.asTestList(getDescription());
    }

    @Override // org.junit.runner.manipulation.Orderable
    public void order(Orderer orderer) throws InvalidOrderingException {
        orderer.apply(this.b);
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        this.b.run(this.c.getNotifier(testResult, this));
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        sorter.apply(this.b);
    }

    public String toString() {
        return this.a.getName();
    }

    public JUnit4TestAdapter(Class<?> cls, JUnit4TestAdapterCache jUnit4TestAdapterCache) {
        this.c = jUnit4TestAdapterCache;
        this.a = cls;
        this.b = Request.classWithoutSuiteMethod(cls).getRunner();
    }
}
