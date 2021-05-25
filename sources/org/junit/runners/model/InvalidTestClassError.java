package org.junit.runners.model;

import a2.b.a.a.a;
import java.util.List;
public class InvalidTestClassError extends InitializationError {
    private static final long serialVersionUID = 1;
    public final String b;

    public InvalidTestClassError(Class<?> cls, List<Throwable> list) {
        super(list);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        sb.append(String.format("Invalid test class '%s':", cls.getName()));
        for (Throwable th : list) {
            StringBuilder L = a.L("\n  ");
            L.append(i);
            L.append(". ");
            L.append(th.getMessage());
            sb.append(L.toString());
            i++;
        }
        this.b = sb.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }
}
