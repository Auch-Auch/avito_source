package com.avito.android.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0004\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\tJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/util/RussianPhoneNumberFormatter;", "Lcom/avito/android/util/PositionFormatter;", "", "value", "format", "(Ljava/lang/String;)Ljava/lang/String;", "", "cursorPosition", "Lcom/avito/android/util/CursorString;", "(Ljava/lang/String;I)Lcom/avito/android/util/CursorString;", Types.STRING, AuthSource.SEND_ABUSE, "(Lcom/avito/android/util/CursorString;)Lcom/avito/android/util/CursorString;", "", AuthSource.BOOKING_ORDER, "Z", "trimNationalPrefix", "addCountryCode", "<init>", "(ZZ)V", "formatters_release"}, k = 1, mv = {1, 4, 2})
public final class RussianPhoneNumberFormatter implements PositionFormatter {
    public final boolean a;
    public final boolean b;

    public RussianPhoneNumberFormatter() {
        this(false, false, 3, null);
    }

    public RussianPhoneNumberFormatter(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final CursorString a(CursorString cursorString) {
        int i;
        String value = cursorString.getValue();
        int cursorPosition = cursorString.getCursorPosition();
        if (this.a && m.startsWith$default(value, "+7 ", false, 2, null)) {
            Objects.requireNonNull(value, "null cannot be cast to non-null type java.lang.String");
            value = value.substring(3);
            Intrinsics.checkNotNullExpressionValue(value, "(this as java.lang.String).substring(startIndex)");
            cursorPosition = Math.max(0, cursorPosition - 3);
        }
        int length = value.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i = -1;
                break;
            }
            char charAt = value.charAt(i2);
            if (Character.isDigit(charAt) || charAt == '+') {
                i = i2;
                break;
            }
            i2++;
        }
        if (i != -1 && m.startsWith$default(value, "+7", i, false, 4, null)) {
            value = value.substring(i + 2);
            Intrinsics.checkNotNullExpressionValue(value, "(this as java.lang.String).substring(startIndex)");
            cursorPosition = Math.max(0, (cursorPosition - 2) - i);
        }
        return new CursorString(value, cursorPosition);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RussianPhoneNumberFormatter(boolean z, boolean z2, int i, j jVar) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    @Override // com.avito.android.util.PositionFormatter
    @NotNull
    public String format(@Nullable String str) {
        return str != null ? format(str, 0).getValue() : "";
    }

    @Override // com.avito.android.util.PositionFormatter
    @NotNull
    public CursorString format(@Nullable String str, int i) {
        CursorString cursorString;
        if (str == null) {
            return new CursorString("", 0);
        }
        CursorString cursorString2 = new CursorString(str, i);
        if (this.b) {
            cursorString = a(cursorString2);
            String value = cursorString.getValue();
            int i2 = 0;
            for (int i3 = 0; i3 < value.length(); i3++) {
                if (Character.isDigit(value.charAt(i3))) {
                    i2++;
                }
            }
            if (i2 == 11 && (cursorString.getValue().charAt(0) == '7' || cursorString.getValue().charAt(0) == '8')) {
                cursorString = new CursorString(StringsKt___StringsKt.drop(cursorString.getValue(), 1), cursorString.getCursorPosition() - 1);
            }
        } else {
            cursorString = a(cursorString2);
        }
        if (!(cursorString.getValue().length() == 0)) {
            String value2 = cursorString.getValue();
            int cursorPosition = cursorString.getCursorPosition();
            StringBuilder sb = new StringBuilder(13);
            int i4 = 0;
            int i5 = 0;
            while (i4 < value2.length()) {
                if (i5 <= StringsKt__StringsKt.getLastIndex("ddd ddd-dd-dd")) {
                    if ("ddd ddd-dd-dd".charAt(i5) == 'd') {
                        if (Character.isDigit(value2.charAt(i4))) {
                            sb.append(value2.charAt(i4));
                        } else {
                            i4++;
                            if (i5 < cursorPosition) {
                                cursorPosition--;
                            }
                        }
                    } else if (value2.charAt(i4) == "ddd ddd-dd-dd".charAt(i5)) {
                        sb.append(value2.charAt(i4));
                    } else {
                        sb.append("ddd ddd-dd-dd".charAt(i5));
                        i5++;
                        if (i5 <= cursorPosition) {
                            cursorPosition++;
                        }
                    }
                    i5++;
                } else if (Character.isDigit(value2.charAt(i4))) {
                    sb.append(value2.charAt(i4));
                }
                i4++;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            cursorString = new CursorString(sb2, cursorPosition);
        }
        if (!this.a) {
            return cursorString;
        }
        StringBuilder L = a.L("+7 ");
        L.append(cursorString.getValue());
        return new CursorString(L.toString(), cursorString.getCursorPosition() + 3);
    }
}
