package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import junit.extensions.TestDecorator;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.InvalidOrderingException;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Orderable;
import org.junit.runner.manipulation.Orderer;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
public class JUnit38ClassRunner extends Runner implements Filterable, Orderable {
    public volatile Test a;

    public static final class b implements TestListener {
        public final RunNotifier a;

        public b(RunNotifier runNotifier, a aVar) {
            this.a = runNotifier;
        }

        public final Description a(Test test) {
            String str;
            if (test instanceof Describable) {
                return ((Describable) test).getDescription();
            }
            Class<?> cls = test.getClass();
            if (test instanceof TestCase) {
                str = ((TestCase) test).getName();
            } else {
                str = test.toString();
            }
            return Description.createTestDescription(cls, str);
        }

        @Override // junit.framework.TestListener
        public void addError(Test test, Throwable th) {
            this.a.fireTestFailure(new Failure(a(test), th));
        }

        @Override // junit.framework.TestListener
        public void addFailure(Test test, AssertionFailedError assertionFailedError) {
            this.a.fireTestFailure(new Failure(a(test), assertionFailedError));
        }

        @Override // junit.framework.TestListener
        public void endTest(Test test) {
            this.a.fireTestFinished(a(test));
        }

        @Override // junit.framework.TestListener
        public void startTest(Test test) {
            this.a.fireTestStarted(a(test));
        }
    }

    public JUnit38ClassRunner(Class<?> cls) {
        this(new TestSuite(cls.asSubclass(TestCase.class)));
    }

    public static Description a(Test test) {
        String str;
        String str2;
        Annotation[] annotationArr;
        if (test instanceof TestCase) {
            TestCase testCase = (TestCase) test;
            Class<?> cls = testCase.getClass();
            String name = testCase.getName();
            try {
                annotationArr = testCase.getClass().getMethod(testCase.getName(), new Class[0]).getDeclaredAnnotations();
            } catch (NoSuchMethodException | SecurityException unused) {
                annotationArr = new Annotation[0];
            }
            return Description.createTestDescription(cls, name, annotationArr);
        } else if (test instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) test;
            if (testSuite.getName() == null) {
                int countTestCases = testSuite.countTestCases();
                if (countTestCases == 0) {
                    str2 = "";
                } else {
                    str2 = String.format(" [example: %s]", testSuite.testAt(0));
                }
                str = String.format("TestSuite with %s tests%s", Integer.valueOf(countTestCases), str2);
            } else {
                str = testSuite.getName();
            }
            Description createSuiteDescription = Description.createSuiteDescription(str, new Annotation[0]);
            int testCount = testSuite.testCount();
            for (int i = 0; i < testCount; i++) {
                createSuiteDescription.addChild(a(testSuite.testAt(i)));
            }
            return createSuiteDescription;
        } else if (test instanceof Describable) {
            return ((Describable) test).getDescription();
        } else {
            if (test instanceof TestDecorator) {
                return a(((TestDecorator) test).getTest());
            }
            return Description.createSuiteDescription(test.getClass());
        }
    }

    public TestListener createAdaptingListener(RunNotifier runNotifier) {
        return new b(runNotifier, null);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        if (this.a instanceof Filterable) {
            ((Filterable) this.a).filter(filter);
        } else if (this.a instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) this.a;
            TestSuite testSuite2 = new TestSuite(testSuite.getName());
            int testCount = testSuite.testCount();
            for (int i = 0; i < testCount; i++) {
                Test testAt = testSuite.testAt(i);
                if (filter.shouldRun(a(testAt))) {
                    testSuite2.addTest(testAt);
                }
            }
            this.a = testSuite2;
            if (testSuite2.testCount() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return a(this.a);
    }

    @Override // org.junit.runner.manipulation.Orderable
    public void order(Orderer orderer) throws InvalidOrderingException {
        if (this.a instanceof Orderable) {
            ((Orderable) this.a).order(orderer);
        }
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        TestResult testResult = new TestResult();
        testResult.addListener(createAdaptingListener(runNotifier));
        this.a.run(testResult);
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        if (this.a instanceof Sortable) {
            ((Sortable) this.a).sort(sorter);
        }
    }

    public JUnit38ClassRunner(Test test) {
        this.a = test;
    }
}
