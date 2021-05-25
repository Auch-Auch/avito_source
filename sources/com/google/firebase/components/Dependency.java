package com.google.firebase.components;

import a2.b.a.a.a;
public final class Dependency {
    public final Class<?> a;
    public final int b;
    public final int c;

    public Dependency(Class<?> cls, int i, int i2) {
        this.a = (Class) Preconditions.checkNotNull(cls, "Null dependency anInterface.");
        this.b = i;
        this.c = i2;
    }

    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (this.a == dependency.a && this.b == dependency.b && this.c == dependency.c) {
            return true;
        }
        return false;
    }

    public Class<?> getInterface() {
        return this.a;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public boolean isDirectInjection() {
        return this.c == 0;
    }

    public boolean isRequired() {
        return this.b == 1;
    }

    public boolean isSet() {
        return this.b == 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i = this.b;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.c != 0) {
            z = false;
        }
        return a.B(sb, z, "}");
    }
}
