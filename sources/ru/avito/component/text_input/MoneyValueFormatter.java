package ru.avito.component.text_input;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/avito/component/text_input/MoneyValueFormatter;", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "", "text", "", Tracker.Events.CREATIVE_START, "before", "count", "Lru/avito/component/text_input/CursorCharSequence;", "format", "(Ljava/lang/CharSequence;III)Lru/avito/component/text_input/CursorCharSequence;", "", "", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)J", "Lru/avito/component/text_input/MoneyMaskFactory;", "Lru/avito/component/text_input/MoneyMaskFactory;", "maskFactory", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "postfix", "", "d", "Z", "allowEmptyValue", "c", "I", "maxLength", "<init>", "(Ljava/lang/String;IZ)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MoneyValueFormatter implements TextChangeAwareFormatter {
    public final MoneyMaskFactory a;
    public final String b;
    public final int c;
    public final boolean d;

    public MoneyValueFormatter(@NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "postfix");
        this.b = str;
        this.c = i;
        this.d = z;
        this.a = new MoneyMaskFactory(str, 0, 2, null);
    }

    public final long a(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str);
    }

    @Override // ru.avito.component.text_input.TextChangeAwareFormatter
    @NotNull
    public CursorCharSequence format(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Mask createMask = this.a.createMask((charSequence.length() + i2) - i3);
        boolean z = true;
        if (i2 > 0 && i3 == 0) {
            int i5 = i + i2;
            boolean z2 = createMask.previousPlaceholderPosition(i5) == createMask.previousPlaceholderPosition(i);
            boolean z3 = createMask.previousPlaceholderPosition(i) < i;
            if (z2 && z3) {
                int previousPlaceholderPosition = createMask.previousPlaceholderPosition(i);
                charSequence = StringsKt__StringsKt.removeRange(charSequence, previousPlaceholderPosition, i);
                i2 = i5 - previousPlaceholderPosition;
                i = previousPlaceholderPosition;
            }
        }
        CharSequence subSequence = charSequence.subSequence(0, i);
        int i6 = i3 + i;
        CharSequence subSequence2 = charSequence.subSequence(i6, charSequence.length());
        char[] cArr = new char[i2];
        for (int i7 = 0; i7 < i2; i7++) {
            cArr[i7] = ' ';
        }
        String str = new String(cArr);
        CharSequence subSequence3 = charSequence.subSequence(i, i6);
        StringBuilder sb = new StringBuilder(subSequence);
        sb.append(str);
        sb.append(subSequence2);
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder(untouchedT….append(untouchedTextEnd)");
        String obj = Mask.rawText$default(createMask, subSequence, null, 2, null).toString();
        String obj2 = createMask.rawText(sb, new IntRange(i + i2, sb.length())).toString();
        StringBuilder sb2 = new StringBuilder(obj);
        sb2.append(obj2);
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(rawUntouch…pend(rawUntouchedTextEnd)");
        String replace = new Regex("[^\\d]").replace(subSequence3, "");
        String str2 = obj + ((CharSequence) replace) + obj2;
        int length = str2.length();
        int i8 = this.c;
        String obj3 = length > i8 ? str2.subSequence(0, i8).toString() : str2;
        if (this.d) {
            if (obj3.length() == 0) {
                return new CursorCharSequence(this.b, 0);
            }
        }
        long a3 = a(obj3);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "rawUntouchedOldText.toString()");
        boolean z4 = a(sb3) == a3;
        boolean z5 = a3 == 0;
        boolean startsWith$default = m.startsWith$default(obj, "0", false, 2, null);
        if (obj3.length() >= str2.length()) {
            z = false;
        }
        Mask createMaskForNumber = this.a.createMaskForNumber(a3);
        Mask createPostfixFreeMaskForNumber = this.a.createPostfixFreeMaskForNumber(a3);
        CharSequence filledText = createMaskForNumber.filledText(String.valueOf(a3));
        if (z5 || startsWith$default) {
            i4 = createPostfixFreeMaskForNumber.cursorPosition(String.valueOf(a3).length());
        } else if (z) {
            i4 = createPostfixFreeMaskForNumber.cursorPosition(Math.min(replace.length() + obj.length(), obj3.length()));
        } else if (z4) {
            i4 = createPostfixFreeMaskForNumber.cursorPosition(obj.length());
        } else {
            i4 = createPostfixFreeMaskForNumber.cursorPosition(replace.length() + obj.length());
        }
        return new CursorCharSequence(filledText, i4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MoneyValueFormatter(String str, int i, boolean z, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? 9 : i, (i2 & 4) != 0 ? false : z);
    }
}
