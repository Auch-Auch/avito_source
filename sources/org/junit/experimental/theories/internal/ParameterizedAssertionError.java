package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
public class ParameterizedAssertionError extends AssertionError {
    private static final long serialVersionUID = 1;

    public ParameterizedAssertionError(Throwable th, String str, Object... objArr) {
        super(String.format("%s(%s)", str, join(", ", objArr)));
        initCause(th);
    }

    public static String join(String str, Object... objArr) {
        return join(str, Arrays.asList(objArr));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedAssertionError) && toString().equals(obj.toString());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    public static String join(String str, Collection<Object> collection) {
        String str2;
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = collection.iterator();
        while (it.hasNext()) {
            try {
                str2 = String.valueOf(it.next());
            } catch (Throwable unused) {
                str2 = "[toString failed]";
            }
            sb.append(str2);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
