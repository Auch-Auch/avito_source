package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, Types.BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(PrimitiveType.INT, Types.INT, "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, Types.FLOAT, "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    
    public static final Set<FqName> e = new HashSet();
    public static final Map<String, JvmPrimitiveType> f = new HashMap();
    public static final Map<PrimitiveType, JvmPrimitiveType> g = new EnumMap(PrimitiveType.class);
    public static final Map<String, JvmPrimitiveType> h = new HashMap();
    public final PrimitiveType a;
    public final String b;
    public final String c;
    public final FqName d;

    /* access modifiers changed from: public */
    static {
        JvmPrimitiveType[] values = values();
        for (int i2 = 0; i2 < 8; i2++) {
            JvmPrimitiveType jvmPrimitiveType = values[i2];
            e.add(jvmPrimitiveType.getWrapperFqName());
            f.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            g.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            h.put(jvmPrimitiveType.getDesc(), jvmPrimitiveType);
        }
    }

    /* access modifiers changed from: public */
    JvmPrimitiveType(@NotNull PrimitiveType primitiveType, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        if (primitiveType != null) {
            this.a = primitiveType;
            this.b = str;
            this.c = str2;
            this.d = new FqName(str3);
            return;
        }
        a(6);
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r7) {
        /*
            r0 = 4
            r1 = 2
            if (r7 == r1) goto L_0x000c
            if (r7 == r0) goto L_0x000c
            switch(r7) {
                case 10: goto L_0x000c;
                case 11: goto L_0x000c;
                case 12: goto L_0x000c;
                case 13: goto L_0x000c;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x000e
        L_0x000c:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        L_0x000e:
            if (r7 == r1) goto L_0x0017
            if (r7 == r0) goto L_0x0017
            switch(r7) {
                case 10: goto L_0x0017;
                case 11: goto L_0x0017;
                case 12: goto L_0x0017;
                case 13: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            r3 = 3
            goto L_0x0018
        L_0x0017:
            r3 = 2
        L_0x0018:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType"
            r5 = 0
            switch(r7) {
                case 1: goto L_0x003c;
                case 2: goto L_0x0039;
                case 3: goto L_0x0034;
                case 4: goto L_0x0039;
                case 5: goto L_0x002f;
                case 6: goto L_0x002a;
                case 7: goto L_0x003c;
                case 8: goto L_0x002f;
                case 9: goto L_0x0025;
                case 10: goto L_0x0039;
                case 11: goto L_0x0039;
                case 12: goto L_0x0039;
                case 13: goto L_0x0039;
                default: goto L_0x0020;
            }
        L_0x0020:
            java.lang.String r6 = "className"
            r3[r5] = r6
            goto L_0x0040
        L_0x0025:
            java.lang.String r6 = "wrapperClassName"
            r3[r5] = r6
            goto L_0x0040
        L_0x002a:
            java.lang.String r6 = "primitiveType"
            r3[r5] = r6
            goto L_0x0040
        L_0x002f:
            java.lang.String r6 = "desc"
            r3[r5] = r6
            goto L_0x0040
        L_0x0034:
            java.lang.String r6 = "type"
            r3[r5] = r6
            goto L_0x0040
        L_0x0039:
            r3[r5] = r4
            goto L_0x0040
        L_0x003c:
            java.lang.String r6 = "name"
            r3[r5] = r6
        L_0x0040:
            java.lang.String r5 = "get"
            r6 = 1
            if (r7 == r1) goto L_0x0061
            if (r7 == r0) goto L_0x0061
            switch(r7) {
                case 10: goto L_0x005c;
                case 11: goto L_0x0057;
                case 12: goto L_0x0052;
                case 13: goto L_0x004d;
                default: goto L_0x004a;
            }
        L_0x004a:
            r3[r6] = r4
            goto L_0x0063
        L_0x004d:
            java.lang.String r4 = "getWrapperFqName"
            r3[r6] = r4
            goto L_0x0063
        L_0x0052:
            java.lang.String r4 = "getDesc"
            r3[r6] = r4
            goto L_0x0063
        L_0x0057:
            java.lang.String r4 = "getJavaKeywordName"
            r3[r6] = r4
            goto L_0x0063
        L_0x005c:
            java.lang.String r4 = "getPrimitiveType"
            r3[r6] = r4
            goto L_0x0063
        L_0x0061:
            r3[r6] = r5
        L_0x0063:
            switch(r7) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0077;
                case 3: goto L_0x0075;
                case 4: goto L_0x0077;
                case 5: goto L_0x0070;
                case 6: goto L_0x006b;
                case 7: goto L_0x006b;
                case 8: goto L_0x006b;
                case 9: goto L_0x006b;
                case 10: goto L_0x0077;
                case 11: goto L_0x0077;
                case 12: goto L_0x0077;
                case 13: goto L_0x0077;
                default: goto L_0x0066;
            }
        L_0x0066:
            java.lang.String r4 = "isWrapperClassName"
            r3[r1] = r4
            goto L_0x0077
        L_0x006b:
            java.lang.String r4 = "<init>"
            r3[r1] = r4
            goto L_0x0077
        L_0x0070:
            java.lang.String r4 = "getByDesc"
            r3[r1] = r4
            goto L_0x0077
        L_0x0075:
            r3[r1] = r5
        L_0x0077:
            java.lang.String r2 = java.lang.String.format(r2, r3)
            if (r7 == r1) goto L_0x0088
            if (r7 == r0) goto L_0x0088
            switch(r7) {
                case 10: goto L_0x0088;
                case 11: goto L_0x0088;
                case 12: goto L_0x0088;
                case 13: goto L_0x0088;
                default: goto L_0x0082;
            }
        L_0x0082:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>(r2)
            goto L_0x008d
        L_0x0088:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r2)
        L_0x008d:
            throw r7
            switch-data {10->0x000c, 11->0x000c, 12->0x000c, 13->0x000c, }
            switch-data {10->0x0017, 11->0x0017, 12->0x0017, 13->0x0017, }
            switch-data {1->0x003c, 2->0x0039, 3->0x0034, 4->0x0039, 5->0x002f, 6->0x002a, 7->0x003c, 8->0x002f, 9->0x0025, 10->0x0039, 11->0x0039, 12->0x0039, 13->0x0039, }
            switch-data {10->0x005c, 11->0x0057, 12->0x0052, 13->0x004d, }
            switch-data {1->0x0075, 2->0x0077, 3->0x0075, 4->0x0077, 5->0x0070, 6->0x006b, 7->0x006b, 8->0x006b, 9->0x006b, 10->0x0077, 11->0x0077, 12->0x0077, 13->0x0077, }
            switch-data {10->0x0088, 11->0x0088, 12->0x0088, 13->0x0088, }
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.a(int):void");
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull String str) {
        if (str != null) {
            JvmPrimitiveType jvmPrimitiveType = f.get(str);
            if (jvmPrimitiveType != null) {
                return jvmPrimitiveType;
            }
            throw new AssertionError(a.c3("Non-primitive type name passed: ", str));
        }
        a(1);
        throw null;
    }

    @NotNull
    public String getDesc() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        a(12);
        throw null;
    }

    @NotNull
    public String getJavaKeywordName() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        a(11);
        throw null;
    }

    @NotNull
    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.a;
        if (primitiveType != null) {
            return primitiveType;
        }
        a(10);
        throw null;
    }

    @NotNull
    public FqName getWrapperFqName() {
        FqName fqName = this.d;
        if (fqName != null) {
            return fqName;
        }
        a(13);
        throw null;
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull PrimitiveType primitiveType) {
        if (primitiveType != null) {
            JvmPrimitiveType jvmPrimitiveType = g.get(primitiveType);
            if (jvmPrimitiveType != null) {
                return jvmPrimitiveType;
            }
            a(4);
            throw null;
        }
        a(3);
        throw null;
    }
}
