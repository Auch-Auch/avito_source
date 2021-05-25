package junit.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.junit.internal.MethodSorter;
import org.junit.internal.Throwables;
public class TestSuite implements Test {
    public String a;
    public Vector<Test> b;

    public static class a extends TestCase {
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(str);
            this.b = str2;
        }

        @Override // junit.framework.TestCase
        public void runTest() {
            TestCase.fail(this.b);
        }
    }

    public TestSuite() {
        this.b = new Vector<>(10);
    }

    public static Test createTest(Class<?> cls, String str) {
        Object obj;
        try {
            Constructor<?> testConstructor = getTestConstructor(cls);
            try {
                if (testConstructor.getParameterTypes().length == 0) {
                    obj = testConstructor.newInstance(new Object[0]);
                    if (obj instanceof TestCase) {
                        ((TestCase) obj).setName(str);
                    }
                } else {
                    obj = testConstructor.newInstance(str);
                }
                return (Test) obj;
            } catch (InstantiationException e) {
                StringBuilder R = a2.b.a.a.a.R("Cannot instantiate test case: ", str, " (");
                R.append(Throwables.getStacktrace(e));
                R.append(")");
                return warning(R.toString());
            } catch (InvocationTargetException e2) {
                StringBuilder R2 = a2.b.a.a.a.R("Exception in constructor: ", str, " (");
                R2.append(Throwables.getStacktrace(e2.getTargetException()));
                R2.append(")");
                return warning(R2.toString());
            } catch (IllegalAccessException e3) {
                StringBuilder R3 = a2.b.a.a.a.R("Cannot access test case: ", str, " (");
                R3.append(Throwables.getStacktrace(e3));
                R3.append(")");
                return warning(R3.toString());
            }
        } catch (NoSuchMethodException unused) {
            StringBuilder L = a2.b.a.a.a.L("Class ");
            L.append(cls.getName());
            L.append(" has no public constructor TestCase(String name) or TestCase()");
            return warning(L.toString());
        }
    }

    public static Constructor<?> getTestConstructor(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    public static Test warning(String str) {
        return new a("warning", str);
    }

    public final boolean a(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }

    public void addTest(Test test) {
        this.b.add(test);
    }

    public void addTestSuite(Class<? extends TestCase> cls) {
        addTest(new TestSuite(cls));
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        Iterator<Test> it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().countTestCases();
        }
        return i;
    }

    public String getName() {
        return this.a;
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        Iterator<Test> it = this.b.iterator();
        while (it.hasNext()) {
            Test next = it.next();
            if (!testResult.shouldStop()) {
                runTest(next, testResult);
            } else {
                return;
            }
        }
    }

    public void runTest(Test test, TestResult testResult) {
        test.run(testResult);
    }

    public void setName(String str) {
        this.a = str;
    }

    public Test testAt(int i) {
        return this.b.get(i);
    }

    public int testCount() {
        return this.b.size();
    }

    public Enumeration<Test> tests() {
        return this.b.elements();
    }

    public String toString() {
        if (getName() != null) {
            return getName();
        }
        return super.toString();
    }

    public TestSuite(Class<?> cls) {
        this.b = new Vector<>(10);
        this.a = cls.getName();
        try {
            getTestConstructor(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                StringBuilder L = a2.b.a.a.a.L("Class ");
                L.append(cls.getName());
                L.append(" is not public");
                addTest(warning(L.toString()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; Test.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                Method[] declaredMethods = MethodSorter.getDeclaredMethods(cls2);
                for (Method method : declaredMethods) {
                    String name = method.getName();
                    if (!arrayList.contains(name)) {
                        if (a(method) && Modifier.isPublic(method.getModifiers())) {
                            arrayList.add(name);
                            addTest(createTest(cls, name));
                        } else if (a(method)) {
                            StringBuilder L2 = a2.b.a.a.a.L("Test method isn't public: ");
                            L2.append(method.getName());
                            L2.append("(");
                            L2.append(cls.getCanonicalName());
                            L2.append(")");
                            addTest(warning(L2.toString()));
                        }
                    }
                }
            }
            if (this.b.size() == 0) {
                StringBuilder L3 = a2.b.a.a.a.L("No tests found in ");
                L3.append(cls.getName());
                addTest(warning(L3.toString()));
            }
        } catch (NoSuchMethodException unused) {
            StringBuilder L4 = a2.b.a.a.a.L("Class ");
            L4.append(cls.getName());
            L4.append(" has no public constructor TestCase(String name) or TestCase()");
            addTest(warning(L4.toString()));
        }
    }

    public TestSuite(Class<? extends TestCase> cls, String str) {
        this(cls);
        setName(str);
    }

    public TestSuite(String str) {
        this.b = new Vector<>(10);
        setName(str);
    }

    public TestSuite(Class<?>... clsArr) {
        Test test;
        this.b = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            if (TestCase.class.isAssignableFrom(cls)) {
                test = new TestSuite(cls.asSubclass(TestCase.class));
            } else {
                test = warning(cls.getCanonicalName() + " does not extend TestCase");
            }
            addTest(test);
        }
    }

    public TestSuite(Class<? extends TestCase>[] clsArr, String str) {
        this(clsArr);
        setName(str);
    }
}
