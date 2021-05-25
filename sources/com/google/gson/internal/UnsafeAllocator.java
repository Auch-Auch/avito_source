package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public abstract class UnsafeAllocator {

    public class a extends UnsafeAllocator {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Object b;

        public a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.a(cls);
            return (T) this.a.invoke(this.b, cls);
        }
    }

    public class b extends UnsafeAllocator {
        public final /* synthetic */ Method a;
        public final /* synthetic */ int b;

        public b(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.a(cls);
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    public class c extends UnsafeAllocator {
        public final /* synthetic */ Method a;

        public c(Method method) {
            this.a = method;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            UnsafeAllocator.a(cls);
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    public class d extends UnsafeAllocator {
        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException(a2.b.a.a.a.B2(cls, a2.b.a.a.a.L("Interface can't be instantiated! Interface name: ")));
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException(a2.b.a.a.a.B2(cls, a2.b.a.a.a.L("Abstract class can't be instantiated! Class name: ")));
        }
    }

    public static UnsafeAllocator create() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new b(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                } catch (Exception unused3) {
                    return new d();
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
