package ru.avito.component.text_input;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lru/avito/component/text_input/SimpleMaskFormatter;", "Lru/avito/component/text_input/TextChangeAwareFormatter;", "", "text", "", Tracker.Events.CREATIVE_START, "before", "count", "Lru/avito/component/text_input/CursorCharSequence;", "format", "(Ljava/lang/CharSequence;III)Lru/avito/component/text_input/CursorCharSequence;", "Lru/avito/component/text_input/Mask;", AuthSource.SEND_ABUSE, "Lru/avito/component/text_input/Mask;", "mask", "", "", InternalConstsKt.PLACEHOLDER, "<init>", "(Ljava/lang/String;C)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleMaskFormatter implements TextChangeAwareFormatter {
    public final Mask a;

    public SimpleMaskFormatter(@NotNull String str, char c) {
        Intrinsics.checkNotNullParameter(str, "mask");
        this.a = new Mask(str, c);
    }

    @Override // ru.avito.component.text_input.TextChangeAwareFormatter
    @NotNull
    public CursorCharSequence format(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        boolean z = true;
        if (i2 > 0 && i3 == 0) {
            int i5 = i + i2;
            boolean z2 = this.a.previousPlaceholderPosition(i5) == this.a.previousPlaceholderPosition(i);
            boolean z3 = this.a.previousPlaceholderPosition(i) < i;
            if (z2 && z3) {
                int previousPlaceholderPosition = this.a.previousPlaceholderPosition(i);
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
        String obj = Mask.rawText$default(this.a, subSequence, null, 2, null).toString();
        String obj2 = this.a.rawText(sb, new IntRange(i + i2, sb.length())).toString();
        StringBuilder sb2 = new StringBuilder(obj);
        sb2.append(obj2);
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(rawUntouch…pend(rawUntouchedTextEnd)");
        CharSequence trim = StringsKt__StringsKt.trim(subSequence3);
        if (StringsKt__StringsKt.startsWith$default(trim, (CharSequence) "+7", false, 2, (Object) null)) {
            trim = trim.subSequence(2, trim.length()).toString();
        }
        String replace = new Regex("[^\\d]").replace(trim, "");
        if (replace.length() == 11 && StringsKt__StringsKt.startsWith$default((CharSequence) replace, '8', false, 2, (Object) null)) {
            replace = replace.subSequence(1, replace.length()).toString();
        }
        if (!(sb2.length() == this.a.getMaskPlaceholdersCount() && replace.length() == 1)) {
            z = false;
        }
        String c3 = z ? a.c3(obj, obj2) : obj + ((CharSequence) replace) + obj2;
        if (z) {
            i4 = obj.length();
        } else {
            i4 = replace.length() + obj.length();
        }
        return new CursorCharSequence(this.a.filledText(c3), this.a.cursorPosition(i4));
    }
}
