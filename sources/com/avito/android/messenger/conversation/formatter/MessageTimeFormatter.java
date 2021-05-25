package com.avito.android.messenger.conversation.formatter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/formatter/MessageTimeFormatter;", "Lcom/avito/android/util/Formatter;", "", "value", "", "format", "(Ljava/lang/Long;)Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", AuthSource.SEND_ABUSE, "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageTimeFormatter implements Formatter<Long> {
    public final SimpleDateFormat a;

    public MessageTimeFormatter(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.a = new SimpleDateFormat("HH:mm", locale);
    }

    @NotNull
    public String format(@Nullable Long l) {
        String format = l != null ? this.a.format(Long.valueOf(l.longValue())) : null;
        return format != null ? format : "";
    }
}
