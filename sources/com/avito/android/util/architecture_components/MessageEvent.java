package com.avito.android.util.architecture_components;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/util/architecture_components/MessageEvent;", "Lcom/avito/android/util/architecture_components/Event;", "", "message", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class MessageEvent extends Event<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageEvent(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
