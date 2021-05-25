package org.junit.experimental.max;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestSuite;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import x6.c.a.c.a;
public class MaxCore {
    public final MaxHistory a;

    public MaxCore(File file) {
        this.a = MaxHistory.forFolder(file);
    }

    @Deprecated
    public static MaxCore forFolder(String str) {
        return storedLocally(new File(str));
    }

    public static MaxCore storedLocally(File file) {
        return new MaxCore(file);
    }

    public final void a(Description description, Description description2, List<Description> list) {
        if (!description2.getChildren().isEmpty()) {
            Iterator<Description> it = description2.getChildren().iterator();
            while (it.hasNext()) {
                a(description2, it.next(), list);
            }
        } else if (description2.toString().equals("warning(junit.framework.TestSuite$1)")) {
            list.add(Description.createSuiteDescription("malformed JUnit 3 test class: " + description, new Annotation[0]));
        } else {
            list.add(description2);
        }
    }

    public Result run(Class<?> cls) {
        return run(Request.aClass(cls));
    }

    public Request sortRequest(Request request) {
        Runner runner;
        Class<?> cls;
        if (request instanceof SortingRequest) {
            return request;
        }
        ArrayList arrayList = new ArrayList();
        a(null, request.getRunner().getDescription(), arrayList);
        Collections.sort(arrayList, this.a.testComparator());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Description description = (Description) it.next();
            if (description.toString().equals("TestSuite with 0 tests")) {
                runner = Suite.emptySuite();
            } else if (description.toString().startsWith("malformed JUnit 3 test class: ")) {
                try {
                    cls = Class.forName(description.toString().replace("malformed JUnit 3 test class: ", ""));
                } catch (ClassNotFoundException unused) {
                    cls = null;
                }
                runner = new JUnit38ClassRunner(new TestSuite(cls));
            } else {
                Class<?> testClass = description.getTestClass();
                if (testClass != null) {
                    String methodName = description.getMethodName();
                    if (methodName == null) {
                        runner = Request.aClass(testClass).getRunner();
                    } else {
                        runner = Request.method(testClass, methodName).getRunner();
                    }
                } else {
                    throw new RuntimeException("Can't build a runner from description [" + description + "]");
                }
            }
            arrayList2.add(runner);
        }
        return new a(this, arrayList2);
    }

    public List<Description> sortedLeavesForTest(Request request) {
        Request sortRequest = sortRequest(request);
        ArrayList arrayList = new ArrayList();
        a(null, sortRequest.getRunner().getDescription(), arrayList);
        return arrayList;
    }

    public Result run(Request request) {
        return run(request, new JUnitCore());
    }

    public Result run(Request request, JUnitCore jUnitCore) {
        jUnitCore.addListener(this.a.listener());
        return jUnitCore.run(sortRequest(request).getRunner());
    }
}
