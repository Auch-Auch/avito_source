package com.avito.android.html_formatter;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/html_formatter/FormatChange;", "", "Lcom/avito/android/html_formatter/FormatChange$Type;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_formatter/FormatChange$Type;", "getType", "()Lcom/avito/android/html_formatter/FormatChange$Type;", "type", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", "Type", "Lcom/avito/android/html_formatter/ParagraphFormatChange;", "Lcom/avito/android/html_formatter/InlineFormatChange;", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public abstract class FormatChange {
    public final int a;
    @NotNull
    public final Type b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/html_formatter/FormatChange$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        ADD,
        REMOVE
    }

    public FormatChange(int i, Type type, j jVar) {
        this.a = i;
        this.b = type;
    }

    @NotNull
    public final Type getType() {
        return this.b;
    }

    public final int getValue() {
        return this.a;
    }
}
