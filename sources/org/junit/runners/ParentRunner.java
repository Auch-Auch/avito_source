package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.Checks;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.InvalidTestClassError;
import org.junit.runners.model.MemberValueConsumer;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.TestClassValidator;
import x6.c.e.c;
public abstract class ParentRunner<T> extends Runner implements Filterable, Orderable {
    public static final List<TestClassValidator> e = Collections.singletonList(new AnnotationsValidator());
    public final Lock a = new ReentrantLock();
    public final TestClass b;
    public volatile List<T> c = null;
    public volatile RunnerScheduler d = new a(this);

    public class a implements RunnerScheduler {
        public a(ParentRunner parentRunner) {
        }

        @Override // org.junit.runners.model.RunnerScheduler
        public void finished() {
        }

        @Override // org.junit.runners.model.RunnerScheduler
        public void schedule(Runnable runnable) {
            ((x6.c.e.a) runnable).run();
        }
    }

    public class b extends Statement {
        public final /* synthetic */ RunNotifier a;

        public b(RunNotifier runNotifier) {
            this.a = runNotifier;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() {
            ParentRunner parentRunner = ParentRunner.this;
            RunNotifier runNotifier = this.a;
            RunnerScheduler runnerScheduler = parentRunner.d;
            try {
                for (T t : parentRunner.a()) {
                    runnerScheduler.schedule(new x6.c.e.a(parentRunner, t, runNotifier));
                }
            } finally {
                runnerScheduler.finished();
            }
        }
    }

    public class c extends Statement {
        public final /* synthetic */ Statement a;

        public c(ParentRunner parentRunner, Statement statement) {
            this.a = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            try {
                this.a.evaluate();
            } finally {
                Thread.interrupted();
            }
        }
    }

    public static class d implements MemberValueConsumer<TestRule> {
        public final List<c.b> a = new ArrayList();

        public d(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [org.junit.runners.model.FrameworkMember, java.lang.Object] */
        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember frameworkMember, TestRule testRule) {
            TestRule testRule2 = testRule;
            ClassRule classRule = (ClassRule) frameworkMember.getAnnotation(ClassRule.class);
            this.a.add(new c.b(testRule2, 1, classRule != null ? Integer.valueOf(classRule.order()) : null));
        }
    }

    public ParentRunner(Class<?> cls) throws InitializationError {
        this.b = createTestClass(cls);
        validate();
    }

    public final List<T> a() {
        if (this.c == null) {
            this.a.lock();
            try {
                if (this.c == null) {
                    this.c = Collections.unmodifiableList(new ArrayList(getChildren()));
                }
            } finally {
                this.a.unlock();
            }
        }
        return this.c;
    }

    public Statement childrenInvoker(RunNotifier runNotifier) {
        return new b(runNotifier);
    }

    public Statement classBlock(RunNotifier runNotifier) {
        boolean z;
        Statement childrenInvoker = childrenInvoker(runNotifier);
        Iterator<T> it = a().iterator();
        while (true) {
            if (it.hasNext()) {
                if (!isIgnored(it.next())) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            return childrenInvoker;
        }
        Statement withAfterClasses = withAfterClasses(withBeforeClasses(childrenInvoker));
        List<TestRule> classRules = classRules();
        if (!classRules.isEmpty()) {
            withAfterClasses = new RunRules(withAfterClasses, classRules, getDescription());
        }
        return withInterruptIsolation(withAfterClasses);
    }

    public List<TestRule> classRules() {
        d dVar = new d(null);
        this.b.collectAnnotatedMethodValues(null, ClassRule.class, TestRule.class, dVar);
        this.b.collectAnnotatedFieldValues(null, ClassRule.class, TestRule.class, dVar);
        Collections.sort(dVar.a, x6.c.e.c.d);
        ArrayList arrayList = new ArrayList(dVar.a.size());
        for (c.b bVar : dVar.a) {
            arrayList.add((TestRule) bVar.a);
        }
        return arrayList;
    }

    public void collectInitializationErrors(List<Throwable> list) {
        validatePublicVoidNoArgMethods(BeforeClass.class, true, list);
        validatePublicVoidNoArgMethods(AfterClass.class, true, list);
        RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), list);
        RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
        if (getTestClass().getJavaClass() != null) {
            for (TestClassValidator testClassValidator : e) {
                list.addAll(testClassValidator.validateTestClass(getTestClass()));
            }
        }
    }

    @Deprecated
    public TestClass createTestClass(Class<?> cls) {
        return new TestClass(cls);
    }

    public abstract Description describeChild(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.junit.runners.ParentRunner<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        this.a.lock();
        try {
            ArrayList arrayList = new ArrayList(a());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (filter.shouldRun(describeChild(next))) {
                    try {
                        filter.apply(next);
                    } catch (NoTestsRemainException unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.c = Collections.unmodifiableList(arrayList);
            if (this.c.isEmpty()) {
                throw new NoTestsRemainException();
            }
        } finally {
            this.a.unlock();
        }
    }

    public abstract List<T> getChildren();

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description description;
        Class<?> javaClass = getTestClass().getJavaClass();
        if (javaClass == null || !javaClass.getName().equals(getName())) {
            description = Description.createSuiteDescription(getName(), getRunnerAnnotations());
        } else {
            description = Description.createSuiteDescription(javaClass, getRunnerAnnotations());
        }
        for (T t : a()) {
            description.addChild(describeChild(t));
        }
        return description;
    }

    public String getName() {
        return this.b.getName();
    }

    public Annotation[] getRunnerAnnotations() {
        return this.b.getAnnotations();
    }

    public final TestClass getTestClass() {
        return this.b;
    }

    public boolean isIgnored(T t) {
        return false;
    }

    @Override // org.junit.runner.manipulation.Orderable
    public void order(Orderer orderer) throws InvalidOrderingException {
        if (!(getDescription().getAnnotation(FixMethodOrder.class) != null)) {
            this.a.lock();
            try {
                List<T> a3 = a();
                LinkedHashMap linkedHashMap = new LinkedHashMap(a3.size());
                for (T t : a3) {
                    Description describeChild = describeChild(t);
                    List list = (List) linkedHashMap.get(describeChild);
                    if (list == null) {
                        list = new ArrayList(1);
                        linkedHashMap.put(describeChild, list);
                    }
                    list.add(t);
                    orderer.apply(t);
                }
                List<Description> order = orderer.order(linkedHashMap.keySet());
                ArrayList arrayList = new ArrayList(a3.size());
                for (Description description : order) {
                    arrayList.addAll((Collection) linkedHashMap.get(description));
                }
                this.c = Collections.unmodifiableList(arrayList);
            } finally {
                this.a.unlock();
            }
        }
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, getDescription());
        eachTestNotifier.fireTestSuiteStarted();
        try {
            classBlock(runNotifier).evaluate();
        } catch (AssumptionViolatedException e2) {
            eachTestNotifier.addFailedAssumption(e2);
        } catch (StoppedByUserException e3) {
            throw e3;
        } catch (Throwable th) {
            eachTestNotifier.fireTestSuiteFinished();
            throw th;
        }
        eachTestNotifier.fireTestSuiteFinished();
    }

    public abstract void runChild(T t, RunNotifier runNotifier);

    public final void runLeaf(Statement statement, Description description, RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, description);
        eachTestNotifier.fireTestStarted();
        try {
            statement.evaluate();
        } catch (AssumptionViolatedException e2) {
            eachTestNotifier.addFailedAssumption(e2);
        } catch (Throwable th) {
            eachTestNotifier.fireTestFinished();
            throw th;
        }
        eachTestNotifier.fireTestFinished();
    }

    public void setScheduler(RunnerScheduler runnerScheduler) {
        this.d = runnerScheduler;
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (!(getDescription().getAnnotation(FixMethodOrder.class) != null)) {
            this.a.lock();
            try {
                for (T t : a()) {
                    sorter.apply(t);
                }
                ArrayList arrayList = new ArrayList(a());
                Collections.sort(arrayList, new x6.c.e.b(this, sorter));
                this.c = Collections.unmodifiableList(arrayList);
            } finally {
                this.a.unlock();
            }
        }
    }

    public final void validate() throws InitializationError {
        ArrayList arrayList = new ArrayList();
        collectInitializationErrors(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InvalidTestClassError(this.b.getJavaClass(), arrayList);
        }
    }

    public void validatePublicVoidNoArgMethods(Class<? extends Annotation> cls, boolean z, List<Throwable> list) {
        for (FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods(cls)) {
            frameworkMethod.validatePublicVoidNoArg(z, list);
        }
    }

    public Statement withAfterClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.b.getAnnotatedMethods(AfterClass.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(statement, annotatedMethods, null);
    }

    public Statement withBeforeClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.b.getAnnotatedMethods(BeforeClass.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(statement, annotatedMethods, null);
    }

    public final Statement withInterruptIsolation(Statement statement) {
        return new c(this, statement);
    }

    public ParentRunner(TestClass testClass) throws InitializationError {
        this.b = (TestClass) Checks.notNull(testClass);
        validate();
    }
}
