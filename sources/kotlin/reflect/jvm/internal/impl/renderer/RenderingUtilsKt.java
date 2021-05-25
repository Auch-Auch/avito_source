package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
public final class RenderingUtilsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0 != false) goto L_0x0041;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String render(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7.isSpecial()
            java.lang.String r1 = "asString()"
            r2 = 0
            if (r0 == 0) goto L_0x000f
            goto L_0x0042
        L_0x000f:
            java.lang.String r0 = r7.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Set<java.lang.String> r3 = kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated.KEYWORDS
            boolean r3 = r3.contains(r0)
            r4 = 1
            if (r3 != 0) goto L_0x0041
            r3 = 0
        L_0x0020:
            int r5 = r0.length()
            if (r3 >= r5) goto L_0x003e
            char r5 = r0.charAt(r3)
            boolean r6 = java.lang.Character.isLetterOrDigit(r5)
            if (r6 != 0) goto L_0x0036
            r6 = 95
            if (r5 == r6) goto L_0x0036
            r5 = 1
            goto L_0x0037
        L_0x0036:
            r5 = 0
        L_0x0037:
            if (r5 == 0) goto L_0x003b
            r0 = 1
            goto L_0x003f
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x003e:
            r0 = 0
        L_0x003f:
            if (r0 == 0) goto L_0x0042
        L_0x0041:
            r2 = 1
        L_0x0042:
            if (r2 == 0) goto L_0x0067
            r0 = 96
            java.lang.String r7 = r7.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r0 = "`"
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r0)
            goto L_0x006e
        L_0x0067:
            java.lang.String r7 = r7.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
        L_0x006e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.render(kotlin.reflect.jvm.internal.impl.name.Name):java.lang.String");
    }

    @NotNull
    public static final String renderFqName(@NotNull List<Name> list) {
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public static final String render(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments()");
        return renderFqName(pathSegments);
    }
}
