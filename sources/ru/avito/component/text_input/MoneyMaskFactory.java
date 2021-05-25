package ru.avito.component.text_input;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0019"}, d2 = {"Lru/avito/component/text_input/MoneyMaskFactory;", "", "", "digit", "Lru/avito/component/text_input/Mask;", "createMaskForNumber", "(J)Lru/avito/component/text_input/Mask;", "createPostfixFreeMaskForNumber", "", "length", "createMask", "(I)Lru/avito/component/text_input/Mask;", "", AuthSource.SEND_ABUSE, "(I)Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "postfix", "", "C", "maskSpace", "c", InternalConstsKt.PLACEHOLDER, "<init>", "(Ljava/lang/String;C)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MoneyMaskFactory {
    public final char a;
    public final String b;
    public final char c;

    public MoneyMaskFactory(@NotNull String str, char c2) {
        Intrinsics.checkNotNullParameter(str, "postfix");
        this.b = str;
        this.c = c2;
        this.a = MoneyMaskConstantsKt.MONEY_MASK_SPACE;
    }

    public final String a(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                if (i3 > 0 && i3 % 3 == 0) {
                    sb.append(this.a);
                }
                sb.append(this.c);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        StringBuilder reverse = sb.reverse();
        Intrinsics.checkNotNullExpressionValue(reverse, "maskBuffer.reverse()");
        return StringsKt__StringsKt.trimStart(reverse).toString();
    }

    @NotNull
    public final Mask createMask(int i) {
        String str;
        int length = i - this.b.length();
        int i2 = length / 4;
        if (i2 <= 0) {
            i2 = 0;
        }
        if (length <= 0) {
            str = this.b;
        } else {
            str = a(length - i2) + this.b;
        }
        return new Mask(str, this.c);
    }

    @NotNull
    public final Mask createMaskForNumber(long j) {
        return new Mask(a(String.valueOf(j).length()) + this.b, this.c);
    }

    @NotNull
    public final Mask createPostfixFreeMaskForNumber(long j) {
        return new Mask(a(String.valueOf(j).length()), this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MoneyMaskFactory(String str, char c2, int i, j jVar) {
        this(str, (i & 2) != 0 ? '#' : c2);
    }
}
