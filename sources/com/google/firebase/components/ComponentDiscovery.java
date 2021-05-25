package com.google.firebase.components;

import android.app.Service;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
public final class ComponentDiscovery<T> {
    public final T a;
    public final c<T> b;

    public static class b implements c<Context> {
        public final Class<? extends Service> a;

        public b(Class cls, a aVar) {
            this.a = cls;
        }
    }

    @VisibleForTesting
    public interface c<T> {
    }

    @VisibleForTesting
    public ComponentDiscovery(T t, c<T> cVar) {
        this.a = t;
        this.b = cVar;
    }

    public static ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new b(cls, null));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0077 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.firebase.components.ComponentRegistrar> discover() {
        /*
            r10 = this;
            com.google.firebase.components.ComponentDiscovery$c<T> r0 = r10.b
            T r1 = r10.a
            com.google.firebase.components.ComponentDiscovery$b r0 = (com.google.firebase.components.ComponentDiscovery.b) r0
            java.util.Objects.requireNonNull(r0)
            android.content.Context r1 = (android.content.Context) r1
            r2 = 0
            android.content.pm.PackageManager r3 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0038 }
            if (r3 != 0) goto L_0x0013
            goto L_0x0039
        L_0x0013:
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0038 }
            java.lang.Class<? extends android.app.Service> r5 = r0.a     // Catch:{ NameNotFoundException -> 0x0038 }
            r4.<init>(r1, r5)     // Catch:{ NameNotFoundException -> 0x0038 }
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.ServiceInfo r1 = r3.getServiceInfo(r4, r1)     // Catch:{ NameNotFoundException -> 0x0038 }
            if (r1 != 0) goto L_0x0035
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0038 }
            r1.<init>()     // Catch:{ NameNotFoundException -> 0x0038 }
            java.lang.Class<? extends android.app.Service> r0 = r0.a     // Catch:{ NameNotFoundException -> 0x0038 }
            r1.append(r0)     // Catch:{ NameNotFoundException -> 0x0038 }
            java.lang.String r0 = " has no service info."
            r1.append(r0)     // Catch:{ NameNotFoundException -> 0x0038 }
            r1.toString()     // Catch:{ NameNotFoundException -> 0x0038 }
            goto L_0x0039
        L_0x0035:
            android.os.Bundle r2 = r1.metaData     // Catch:{ NameNotFoundException -> 0x0038 }
            goto L_0x0039
        L_0x0038:
        L_0x0039:
            java.lang.String r0 = "com.google.firebase.components.ComponentRegistrar"
            if (r2 != 0) goto L_0x0042
            java.util.List r1 = java.util.Collections.emptyList()
            goto L_0x0077
        L_0x0042:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r3 = r2.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x004f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0077
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.get(r4)
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x004f
            java.lang.String r5 = "com.google.firebase.components:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x004f
            r5 = 31
            java.lang.String r4 = r4.substring(r5)
            r1.add(r4)
            goto L_0x004f
        L_0x0077:
            java.lang.String r2 = "Could not instantiate %s"
            java.lang.String r3 = "Could not instantiate %s."
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0084:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00e7
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            r6 = 1
            r7 = 0
            java.lang.Class r8 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            java.lang.Class<com.google.firebase.components.ComponentRegistrar> r9 = com.google.firebase.components.ComponentRegistrar.class
            boolean r9 = r9.isAssignableFrom(r8)     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            if (r9 != 0) goto L_0x00ab
            java.lang.String r8 = "Class %s is not an instance of %s"
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            r9[r7] = r5     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            r9[r6] = r0     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            java.lang.String.format(r8, r9)     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            goto L_0x0084
        L_0x00ab:
            java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            java.lang.reflect.Constructor r8 = r8.getDeclaredConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            java.lang.Object r8 = r8.newInstance(r9)     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            com.google.firebase.components.ComponentRegistrar r8 = (com.google.firebase.components.ComponentRegistrar) r8     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            r4.add(r8)     // Catch:{ ClassNotFoundException -> 0x00dd, IllegalAccessException -> 0x00d5, InstantiationException -> 0x00cd, NoSuchMethodException -> 0x00c5, InvocationTargetException -> 0x00bd }
            goto L_0x0084
        L_0x00bd:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r7] = r5
            java.lang.String.format(r2, r6)
            goto L_0x0084
        L_0x00c5:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r7] = r5
            java.lang.String.format(r2, r6)
            goto L_0x0084
        L_0x00cd:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r7] = r5
            java.lang.String.format(r3, r6)
            goto L_0x0084
        L_0x00d5:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r7] = r5
            java.lang.String.format(r3, r6)
            goto L_0x0084
        L_0x00dd:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r7] = r5
            java.lang.String r5 = "Class %s is not an found."
            java.lang.String.format(r5, r6)
            goto L_0x0084
        L_0x00e7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentDiscovery.discover():java.util.List");
    }
}
