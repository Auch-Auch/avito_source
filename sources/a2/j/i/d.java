package a2.j.i;

import com.google.protobuf.ExtensionRegistryLite;
public final class d {
    public static final Class<?> a;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        a = cls;
    }

    public static final ExtensionRegistryLite a(String str) throws Exception {
        return (ExtensionRegistryLite) a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
