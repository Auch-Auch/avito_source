package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
public class FrameworkField extends FrameworkMember<FrameworkField> {
    public final Field a;

    public FrameworkField(Field field) {
        Objects.requireNonNull(field, "FrameworkField cannot be created without an underlying field.");
        this.a = field;
        if (isPublic()) {
            try {
                field.setAccessible(true);
            } catch (SecurityException unused) {
            }
        }
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean a() {
        return false;
    }

    public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.a.get(obj);
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.a.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getDeclaringClass() {
        return this.a.getDeclaringClass();
    }

    public Field getField() {
        return this.a;
    }

    @Override // org.junit.runners.model.FrameworkMember
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public String getName() {
        return getField().getName();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getType() {
        return this.a.getType();
    }

    public String toString() {
        return this.a.toString();
    }

    public boolean isShadowedBy(FrameworkField frameworkField) {
        return frameworkField.getName().equals(getName());
    }
}
