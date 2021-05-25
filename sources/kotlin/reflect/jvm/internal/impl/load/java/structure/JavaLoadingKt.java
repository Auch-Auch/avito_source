package kotlin.reflect.jvm.internal.impl.load.java.structure;
public final class JavaLoadingKt {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r0.equals("hashCode") == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r0.equals("toString") == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        r5 = r5.getValueParameters().isEmpty();
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isObjectMethodInInterface(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r5.getContainingClass()
            boolean r0 = r0.isInterface()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0095
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
            if (r0 == 0) goto L_0x0095
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) r5
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r5.getName()
            java.lang.String r0 = r0.asString()
            int r3 = r0.hashCode()
            r4 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r3 == r4) goto L_0x0080
            r4 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r3 == r4) goto L_0x003c
            r4 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r3 == r4) goto L_0x0033
            goto L_0x0088
        L_0x0033:
            java.lang.String r3 = "hashCode"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x008a
            goto L_0x0088
        L_0x003c:
            java.lang.String r3 = "equals"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0045
            goto L_0x0088
        L_0x0045:
            java.util.List r5 = r5.getValueParameters()
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull(r5)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) r5
            r0 = 0
            if (r5 != 0) goto L_0x0054
            r5 = r0
            goto L_0x0058
        L_0x0054:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r5 = r5.getType()
        L_0x0058:
            boolean r3 = r5 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
            if (r3 == 0) goto L_0x005f
            r0 = r5
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) r0
        L_0x005f:
            if (r0 != 0) goto L_0x0062
            goto L_0x0088
        L_0x0062:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier r5 = r0.getClassifier()
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
            if (r0 == 0) goto L_0x0088
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) r5
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = r5.getFqName()
            if (r5 == 0) goto L_0x0088
            java.lang.String r5 = r5.asString()
            java.lang.String r0 = "java.lang.Object"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r5 == 0) goto L_0x0088
            r5 = 1
            goto L_0x0092
        L_0x0080:
            java.lang.String r3 = "toString"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x008a
        L_0x0088:
            r5 = 0
            goto L_0x0092
        L_0x008a:
            java.util.List r5 = r5.getValueParameters()
            boolean r5 = r5.isEmpty()
        L_0x0092:
            if (r5 == 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r1 = 0
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt.isObjectMethodInInterface(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember):boolean");
    }
}
