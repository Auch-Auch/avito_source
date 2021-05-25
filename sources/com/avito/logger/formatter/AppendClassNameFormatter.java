package com.avito.logger.formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.logger.LoggingFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/logger/formatter/AppendClassNameFormatter;", "Lcom/avito/logger/LoggingFormatter;", "", "message", "format", "(Ljava/lang/String;)Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "className", "<init>", "(Ljava/lang/String;)V", "logger"}, k = 1, mv = {1, 4, 2})
public final class AppendClassNameFormatter implements LoggingFormatter {
    public final String a;

    public AppendClassNameFormatter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        this.a = str;
    }

    @Override // com.avito.logger.LoggingFormatter
    @NotNull
    public String format(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        return a.u(sb, this.a, "] ", str);
    }
}
