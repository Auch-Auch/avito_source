package org.junit.internal;

import java.util.ArrayList;
import java.util.List;
public class ArrayComparisonFailure extends AssertionError {
    private static final long serialVersionUID = 1;
    public final List<Integer> a = new ArrayList();
    public final String b;
    public final AssertionError c;

    public ArrayComparisonFailure(String str, AssertionError assertionError, int i) {
        this.b = str;
        this.c = assertionError;
        initCause(assertionError);
        addDimension(i);
    }

    public void addDimension(int i) {
        this.a.add(0, Integer.valueOf(i));
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        return super.getCause() == null ? this.c : super.getCause();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("arrays first differed at element ");
        for (Integer num : this.a) {
            int intValue = num.intValue();
            sb.append("[");
            sb.append(intValue);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return getMessage();
    }
}
