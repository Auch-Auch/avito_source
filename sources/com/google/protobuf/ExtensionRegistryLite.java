package com.google.protobuf;

import a2.j.i.d;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class ExtensionRegistryLite {
    public static volatile boolean b = false;
    public static final Class<?> c;
    public static final ExtensionRegistryLite d = new ExtensionRegistryLite(true);
    public final Map<a, GeneratedMessageLite.GeneratedExtension<?, ?>> a;

    public static final class a {
        public final Object a;
        public final int b;

        public a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        c = cls;
    }

    public ExtensionRegistryLite() {
        this.a = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (d.a != null) {
            try {
                return d.a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return d;
    }

    public static boolean isEagerlyParseMessageSets() {
        return b;
    }

    public static ExtensionRegistryLite newInstance() {
        if (d.a != null) {
            try {
                return d.a("newInstance");
            } catch (Exception unused) {
            }
        }
        return new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean z) {
        b = z;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.a.put(new a(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.a.get(new a(containingtype, i));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == d) {
            this.a = Collections.emptyMap();
        } else {
            this.a = Collections.unmodifiableMap(extensionRegistryLite.a);
        }
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        Class<?> cls = d.a;
        if (cls != null && cls.isAssignableFrom(getClass())) {
            try {
                getClass().getMethod(ProductAction.ACTION_ADD, c).invoke(this, extensionLite);
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", extensionLite), e);
            }
        }
    }

    public ExtensionRegistryLite(boolean z) {
        this.a = Collections.emptyMap();
    }
}
