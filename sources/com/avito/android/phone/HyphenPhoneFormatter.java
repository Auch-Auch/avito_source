package com.avito.android.phone;

import com.avito.android.common.InputData;
import com.avito.android.common.InputFormatter;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/phone/HyphenPhoneFormatter;", "Lcom/avito/android/common/InputFormatter;", "Lcom/avito/android/common/InputData;", "data", "format", "(Lcom/avito/android/common/InputData;)Lcom/avito/android/common/InputData;", "", "raw", "(Lcom/avito/android/common/InputData;)Ljava/lang/CharSequence;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "maxLength", AuthSource.SEND_ABUSE, "I", "getInputType", "()I", "inputType", "<init>", "(Ljava/lang/Integer;)V", "formatters-provider_release"}, k = 1, mv = {1, 4, 2})
public final class HyphenPhoneFormatter implements InputFormatter {
    public final int a = 3;
    public final Integer b;

    public HyphenPhoneFormatter(@Nullable Integer num) {
        this.b = num;
    }

    @Override // com.avito.android.common.InputFormatter
    @NotNull
    public InputData format(@NotNull InputData inputData) {
        Intrinsics.checkNotNullParameter(inputData, "data");
        if (inputData.getValue().length() == 0) {
            return inputData;
        }
        if (inputData.getValue().length() == 0) {
            return inputData;
        }
        CharSequence value = inputData.getValue();
        int selectionStart = inputData.getSelectionStart();
        int selectionEnd = inputData.getSelectionEnd();
        Integer num = this.b;
        int intValue = num != null ? num.intValue() : Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(13);
        int i = 0;
        int i2 = 0;
        while (i < value.length()) {
            if (i2 <= StringsKt__StringsKt.getLastIndex("ddd ddd-dd-dd")) {
                if ("ddd ddd-dd-dd".charAt(i2) == 'd') {
                    if (Character.isDigit(value.charAt(i))) {
                        sb.append(value.charAt(i));
                    } else {
                        i++;
                        if (i2 < selectionStart) {
                            selectionStart--;
                        }
                        if (i2 < selectionEnd) {
                            selectionEnd--;
                        }
                    }
                } else if (value.charAt(i) == "ddd ddd-dd-dd".charAt(i2)) {
                    sb.append(value.charAt(i));
                } else {
                    sb.append("ddd ddd-dd-dd".charAt(i2));
                    i2++;
                    if (i2 <= selectionStart) {
                        selectionStart++;
                    }
                    if (i2 <= selectionEnd) {
                        selectionEnd++;
                    }
                }
                i2++;
            } else if (i >= intValue) {
                break;
            } else if (Character.isDigit(value.charAt(i))) {
                sb.append(value.charAt(i));
            }
            i++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
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
        CharSequence value = inputData.getValue();
        StringBuilder sb = new StringBuilder();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char charAt = value.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        if (this.b == null) {
            return sb;
        }
        return ((sb.length() == 0) || this.b.intValue() > sb.length()) ? sb : sb.subSequence(0, this.b.intValue());
    }
}
