package com.avito.android.util.text;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/text/TextStyleAttributeFormatter;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/text/FontParameter$TextStyleParameter;", "parameter", "", "getStyleId", "(Landroid/content/Context;Lcom/avito/android/remote/model/text/FontParameter$TextStyleParameter;)Ljava/lang/Integer;", "", "value", "defStyle", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "<init>", "()V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class TextStyleAttributeFormatter {
    @NotNull
    public static final TextStyleAttributeFormatter INSTANCE = new TextStyleAttributeFormatter();

    public final Integer a(Context context, String str, String str2) {
        if (str != null) {
            Integer valueOf = Integer.valueOf(context.getResources().getIdentifier(str, str2, context.getPackageName()));
            if (valueOf.intValue() > 0) {
                return valueOf;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        if ((r0.intValue() > 0) != false) goto L_0x002f;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer getStyleId(@org.jetbrains.annotations.Nullable android.content.Context r6, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.text.FontParameter.TextStyleParameter r7) {
        /*
            r5 = this;
            java.lang.String r0 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r7.getAttribute()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r6 == 0) goto L_0x002e
            java.lang.String r4 = "attr"
            java.lang.Integer r0 = r5.a(r6, r0, r4)
            if (r0 == 0) goto L_0x002e
            int r0 = r0.intValue()
            int r0 = com.avito.android.util.Contexts.getResourceIdByAttr(r6, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r4 = r0.intValue()
            if (r4 <= 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = r3
        L_0x002f:
            if (r0 == 0) goto L_0x0032
            goto L_0x004c
        L_0x0032:
            java.lang.String r7 = r7.getStyle()
            if (r6 == 0) goto L_0x004b
            java.lang.String r0 = "style"
            java.lang.Integer r6 = r5.a(r6, r7, r0)
            if (r6 == 0) goto L_0x004b
            int r7 = r6.intValue()
            if (r7 <= 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            if (r1 == 0) goto L_0x004b
            r3 = r6
        L_0x004b:
            r0 = r3
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.text.TextStyleAttributeFormatter.getStyleId(android.content.Context, com.avito.android.remote.model.text.FontParameter$TextStyleParameter):java.lang.Integer");
    }
}
