package a2.j.d.c;

import java.lang.reflect.Field;
public final class l3<T> {
    public final Field a;

    public l3(Field field, k3 k3Var) {
        this.a = field;
        field.setAccessible(true);
    }

    public void a(T t, Object obj) {
        try {
            this.a.set(t, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
