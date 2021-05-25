package org.junit.runners.model;

import java.lang.reflect.Modifier;
import org.junit.runners.model.FrameworkMember;
public abstract class FrameworkMember<T extends FrameworkMember<T>> implements Annotatable {
    public abstract boolean a();

    public abstract Class<?> getDeclaringClass();

    public abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getType();

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public abstract boolean isShadowedBy(T t);

    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }
}
