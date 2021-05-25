package org.junit.runners.parameterized;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Checks;
import org.junit.runners.model.TestClass;
public class TestWithParameters {
    public final String a;
    public final TestClass b;
    public final List<Object> c;

    public TestWithParameters(String str, TestClass testClass, List<Object> list) {
        Checks.notNull(str, "The name is missing.");
        Checks.notNull(testClass, "The test class is missing.");
        Checks.notNull(list, "The parameters are missing.");
        this.a = str;
        this.b = testClass;
        this.c = Collections.unmodifiableList(new ArrayList(list));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestWithParameters testWithParameters = (TestWithParameters) obj;
        if (!this.a.equals(testWithParameters.a) || !this.c.equals(testWithParameters.c) || !this.b.equals(testWithParameters.b)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.a;
    }

    public List<Object> getParameters() {
        return this.c;
    }

    public TestClass getTestClass() {
        return this.b;
    }

    public int hashCode() {
        int B0 = a.B0(this.a, 14747, 14747);
        return this.c.hashCode() + ((this.b.hashCode() + B0) * 14747);
    }

    public String toString() {
        return this.b.getName() + " '" + this.a + "' with parameters " + this.c;
    }
}
