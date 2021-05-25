package com.avito.android.price;

import com.avito.android.common.InputData;
import com.avito.android.common.InputFormatter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/price/PriceInputFormatterImpl;", "Lcom/avito/android/common/InputFormatter;", "Lcom/avito/android/common/InputData;", "data", "format", "(Lcom/avito/android/common/InputData;)Lcom/avito/android/common/InputData;", "", "raw", "(Lcom/avito/android/common/InputData;)Ljava/lang/CharSequence;", "", "maxLength", AuthSource.SEND_ABUSE, "(Lcom/avito/android/common/InputData;I)Lcom/avito/android/common/InputData;", "I", "getInputType", "()I", "inputType", "<init>", "()V", "formatters-provider_release"}, k = 1, mv = {1, 4, 2})
public final class PriceInputFormatterImpl implements InputFormatter {
    public final int a = 2;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r6 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r7 < r13.getSelectionEnd()) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.common.InputData a(com.avito.android.common.InputData r13, int r14) {
        /*
            r12 = this;
            java.lang.CharSequence r0 = r13.getValue()
            int r1 = r0.length()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r1 == 0) goto L_0x0012
            return r13
        L_0x0012:
            int r1 = r0.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r5 = java.lang.Math.min(r1, r14)
            r4.<init>(r5)
            int r5 = r13.getSelectionStart()
            int r6 = r13.getSelectionEnd()
            r7 = 0
        L_0x0028:
            java.lang.String r8 = "digitsValueBuilder.toString()"
            if (r7 >= r1) goto L_0x0080
            char r9 = r0.charAt(r7)
            r10 = 10
            int r9 = java.lang.Character.digit(r9, r10)
            r10 = 48
            r11 = -1
            if (r9 == r11) goto L_0x0054
            r4.append(r9)
            int r9 = r4.length()
            if (r9 <= r2) goto L_0x0064
            char r9 = r4.charAt(r3)
            if (r9 != r10) goto L_0x0064
            r4.deleteCharAt(r3)
            if (r5 <= 0) goto L_0x0051
            int r5 = r5 + -1
        L_0x0051:
            if (r6 <= 0) goto L_0x0064
            goto L_0x0062
        L_0x0054:
            int r9 = r13.getSelectionStart()
            if (r7 >= r9) goto L_0x005c
            int r5 = r5 + -1
        L_0x005c:
            int r9 = r13.getSelectionEnd()
            if (r7 >= r9) goto L_0x0064
        L_0x0062:
            int r6 = r6 + -1
        L_0x0064:
            int r9 = r4.length()
            if (r9 != r14) goto L_0x007d
            char r9 = r4.charAt(r3)
            if (r9 == r10) goto L_0x007d
            com.avito.android.common.InputData r13 = new com.avito.android.common.InputData
            java.lang.String r14 = r4.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r8)
            r13.<init>(r14, r5, r6)
            return r13
        L_0x007d:
            int r7 = r7 + 1
            goto L_0x0028
        L_0x0080:
            com.avito.android.common.InputData r13 = new com.avito.android.common.InputData
            java.lang.String r14 = r4.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r8)
            r13.<init>(r14, r5, r6)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.price.PriceInputFormatterImpl.a(com.avito.android.common.InputData, int):com.avito.android.common.InputData");
    }

    @Override // com.avito.android.common.InputFormatter
    @NotNull
    public InputData format(@NotNull InputData inputData) {
        Intrinsics.checkNotNullParameter(inputData, "data");
        if (inputData.getValue().length() == 0) {
            return inputData;
        }
        InputData a3 = a(inputData, 12);
        if (a3.getValue().length() <= 3) {
            return a3;
        }
        int length = a3.getValue().length();
        int i = length % 3;
        if (i == 0) {
            i += 3;
        }
        StringBuilder sb = new StringBuilder(((length / 3) + 1) * 4);
        int selectionStart = a3.getSelectionStart();
        int selectionEnd = a3.getSelectionEnd();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == i) {
                i += 3;
                if (i2 < a3.getSelectionStart()) {
                    selectionStart++;
                }
                if (i2 < a3.getSelectionEnd()) {
                    selectionEnd++;
                }
                sb.append(' ');
            }
            sb.append(a3.getValue().charAt(i2));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "resultValueBuilder.toString()");
        return new InputData(sb2, selectionStart, selectionEnd);
    }

    @Override // com.avito.android.common.InputFormatter
    public int getInputType() {
        return this.a;
    }

    @Override // com.avito.android.common.InputFormatter
    @NotNull
    public CharSequence raw(@NotNull InputData inputData) {
        Intrinsics.checkNotNullParameter(inputData, "data");
        return a(inputData, 12).getValue();
    }
}
