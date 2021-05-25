package org.junit.validator;

import a2.b.a.a.a;
import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;
public class PublicClassValidator implements TestClassValidator {
    public static final List<Exception> a = Collections.emptyList();

    @Override // org.junit.validator.TestClassValidator
    public List<Exception> validateTestClass(TestClass testClass) {
        if (testClass.isPublic()) {
            return a;
        }
        StringBuilder L = a.L("The class ");
        L.append(testClass.getName());
        L.append(" is not public.");
        return Collections.singletonList(new Exception(L.toString()));
    }
}
