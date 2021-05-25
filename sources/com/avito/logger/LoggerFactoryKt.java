package com.avito.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lcom/avito/logger/LoggerFactory;", "Lcom/avito/logger/Logger;", "create", "(Lcom/avito/logger/LoggerFactory;)Lcom/avito/logger/Logger;", "logger"}, k = 2, mv = {1, 4, 2})
public final class LoggerFactoryKt {
    public static final /* synthetic */ <T> Logger create(LoggerFactory loggerFactory) {
        Intrinsics.checkNotNullParameter(loggerFactory, "$this$create");
        Intrinsics.reifiedOperationMarker(4, "T");
        String simpleName = Object.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "T::class.java.simpleName");
        return loggerFactory.create(simpleName);
    }
}
