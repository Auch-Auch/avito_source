package org.junit.runners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.Fail;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.MemberValueConsumer;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;
import x6.c.e.c;
public class BlockJUnit4ClassRunner extends ParentRunner<FrameworkMethod> {
    public static TestClassValidator g = new PublicClassValidator();
    public static final ThreadLocal<x6.c.e.c> h = new ThreadLocal<>();
    public final ConcurrentMap<FrameworkMethod, Description> f = new ConcurrentHashMap();

    public class a extends Statement {
        public final /* synthetic */ FrameworkMethod a;

        public a(FrameworkMethod frameworkMethod) {
            this.a = frameworkMethod;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            BlockJUnit4ClassRunner.this.methodBlock(this.a).evaluate();
        }
    }

    public class b extends ReflectiveCallable {
        public final /* synthetic */ FrameworkMethod a;

        public b(FrameworkMethod frameworkMethod) {
            this.a = frameworkMethod;
        }

        @Override // org.junit.internal.runners.model.ReflectiveCallable
        public Object runReflectiveCall() throws Throwable {
            return BlockJUnit4ClassRunner.this.createTest(this.a);
        }
    }

    public static class c<T> implements MemberValueConsumer<T> {
        public final List<T> a = new ArrayList();

        public c(a aVar) {
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember<?> frameworkMember, T t) {
            x6.c.e.c cVar;
            Rule rule = (Rule) frameworkMember.getAnnotation(Rule.class);
            if (!(rule == null || (cVar = BlockJUnit4ClassRunner.h.get()) == null)) {
                cVar.a.put(t, Integer.valueOf(rule.order()));
            }
            this.a.add(t);
        }
    }

    public BlockJUnit4ClassRunner(Class<?> cls) throws InitializationError {
        super(cls);
    }

    public final boolean b() {
        return getTestClass().getJavaClass().getConstructors().length == 1;
    }

    @Override // org.junit.runners.ParentRunner
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        if (getTestClass().getJavaClass() != null) {
            list.addAll(g.validateTestClass(getTestClass()));
        }
        validateNoNonStaticInnerClass(list);
        validateConstructor(list);
        validateInstanceMethods(list);
        validateFields(list);
        RuleMemberValidator.RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    public List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(Test.class);
    }

    public Object createTest() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(new Object[0]);
    }

    @Override // org.junit.runners.ParentRunner
    public List<FrameworkMethod> getChildren() {
        return computeTestMethods();
    }

    public List<TestRule> getTestRules(Object obj) {
        c cVar = new c(null);
        getTestClass().collectAnnotatedMethodValues(obj, Rule.class, TestRule.class, cVar);
        getTestClass().collectAnnotatedFieldValues(obj, Rule.class, TestRule.class, cVar);
        return cVar.a;
    }

    /* JADX INFO: finally extract failed */
    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        try {
            Object run = new b(frameworkMethod).run();
            Statement withAfters = withAfters(frameworkMethod, run, withBefores(frameworkMethod, run, withPotentialTimeout(frameworkMethod, run, possiblyExpectingExceptions(frameworkMethod, run, methodInvoker(frameworkMethod, run)))));
            x6.c.e.c cVar = new x6.c.e.c();
            h.set(cVar);
            try {
                List<TestRule> testRules = getTestRules(run);
                for (MethodRule methodRule : rules(run)) {
                    if (!(methodRule instanceof TestRule) || !testRules.contains(methodRule)) {
                        cVar.c.add(methodRule);
                    }
                }
                for (TestRule testRule : testRules) {
                    cVar.b.add(testRule);
                }
                h.remove();
                Description describeChild = describeChild(frameworkMethod);
                if (!cVar.c.isEmpty() || !cVar.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(cVar.b.size() + cVar.c.size());
                    for (MethodRule methodRule2 : cVar.c) {
                        arrayList.add(new c.b(methodRule2, 0, cVar.a.get(methodRule2)));
                    }
                    for (TestRule testRule2 : cVar.b) {
                        arrayList.add(new c.b(testRule2, 1, cVar.a.get(testRule2)));
                    }
                    Collections.sort(arrayList, x6.c.e.c.d);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c.b bVar = (c.b) it.next();
                        if (bVar.b == 1) {
                            withAfters = ((TestRule) bVar.a).apply(withAfters, describeChild);
                        } else {
                            withAfters = ((MethodRule) bVar.a).apply(withAfters, frameworkMethod, run);
                        }
                    }
                }
                return withInterruptIsolation(withAfters);
            } catch (Throwable th) {
                h.remove();
                throw th;
            }
        } catch (Throwable th2) {
            return new Fail(th2);
        }
    }

    public Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
        return new InvokeMethod(frameworkMethod, obj);
    }

    public Statement possiblyExpectingExceptions(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        Test test = (Test) frameworkMethod.getAnnotation(Test.class);
        Class<? extends Throwable> expected = (test == null || test.expected() == Test.None.class) ? null : test.expected();
        return expected != null ? new ExpectException(statement, expected) : statement;
    }

    public List<MethodRule> rules(Object obj) {
        c cVar = new c(null);
        getTestClass().collectAnnotatedMethodValues(obj, Rule.class, MethodRule.class, cVar);
        getTestClass().collectAnnotatedFieldValues(obj, Rule.class, MethodRule.class, cVar);
        return cVar.a;
    }

    public String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    public void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
        validateZeroArgConstructor(list);
    }

    public void validateFields(List<Throwable> list) {
        RuleMemberValidator.RULE_VALIDATOR.validate(getTestClass(), list);
    }

    @Deprecated
    public void validateInstanceMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(After.class, false, list);
        validatePublicVoidNoArgMethods(Before.class, false, list);
        validateTestMethods(list);
        if (computeTestMethods().isEmpty()) {
            list.add(new Exception("No runnable methods"));
        }
    }

    public void validateNoNonStaticInnerClass(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass()) {
            StringBuilder L = a2.b.a.a.a.L("The inner class ");
            L.append(getTestClass().getName());
            L.append(" is not static.");
            list.add(new Exception(L.toString()));
        }
    }

    public void validateOnlyOneConstructor(List<Throwable> list) {
        if (!b()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    public void validateTestMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(Test.class, false, list);
    }

    public void validateZeroArgConstructor(List<Throwable> list) {
        if (!getTestClass().isANonStaticInnerClass() && b() && getTestClass().getOnlyConstructor().getParameterTypes().length != 0) {
            list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
        }
    }

    public Statement withAfters(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(After.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(statement, annotatedMethods, obj);
    }

    public Statement withBefores(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Before.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(statement, annotatedMethods, obj);
    }

    @Deprecated
    public Statement withPotentialTimeout(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        long j;
        Test test = (Test) frameworkMethod.getAnnotation(Test.class);
        if (test == null) {
            j = 0;
        } else {
            j = test.timeout();
        }
        if (j <= 0) {
            return statement;
        }
        return FailOnTimeout.builder().withTimeout(j, TimeUnit.MILLISECONDS).build(statement);
    }

    public Object createTest(FrameworkMethod frameworkMethod) throws Exception {
        return createTest();
    }

    public Description describeChild(FrameworkMethod frameworkMethod) {
        Description description = this.f.get(frameworkMethod);
        if (description != null) {
            return description;
        }
        Description createTestDescription = Description.createTestDescription(getTestClass().getJavaClass(), testName(frameworkMethod), frameworkMethod.getAnnotations());
        this.f.putIfAbsent(frameworkMethod, createTestDescription);
        return createTestDescription;
    }

    public boolean isIgnored(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotation(Ignore.class) != null;
    }

    public void runChild(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        Description describeChild = describeChild(frameworkMethod);
        if (isIgnored(frameworkMethod)) {
            runNotifier.fireTestIgnored(describeChild);
        } else {
            runLeaf(new a(frameworkMethod), describeChild, runNotifier);
        }
    }

    public BlockJUnit4ClassRunner(TestClass testClass) throws InitializationError {
        super(testClass);
    }
}
