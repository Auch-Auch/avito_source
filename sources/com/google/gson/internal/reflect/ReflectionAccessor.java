package com.google.gson.internal.reflect;

import a2.j.f.a.n.a;
import a2.j.f.a.n.b;
import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;
public abstract class ReflectionAccessor {
    public static final ReflectionAccessor a = (JavaVersion.getMajorJavaVersion() < 9 ? new a() : new b());

    public static ReflectionAccessor getInstance() {
        return a;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
