package com.avito.android.in_app_calls;

import com.avito.android.calls.Call;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nRV\u0010\u0011\u001aB\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004 \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000e0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/in_app_calls/CallRegistryImpl;", "Lcom/avito/android/in_app_calls/CallRegistry;", "", "callUuid", "Lcom/avito/android/calls/Call;", "call", "", "addCall", "(Ljava/lang/String;Lcom/avito/android/calls/Call;)V", "getCall", "(Ljava/lang/String;)Lcom/avito/android/calls/Call;", "removeCall", "", "kotlin.jvm.PlatformType", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", Names.IN_APP_CALLS, "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallRegistryImpl implements CallRegistry {
    public final Map<String, Call> a = Collections.synchronizedMap(new LinkedHashMap());

    @Override // com.avito.android.in_app_calls.CallRegistry
    public void addCall(@NotNull String str, @NotNull Call call) {
        Intrinsics.checkNotNullParameter(str, "callUuid");
        Intrinsics.checkNotNullParameter(call, "call");
        Map<String, Call> map = this.a;
        Intrinsics.checkNotNullExpressionValue(map, Names.IN_APP_CALLS);
        map.put(str, call);
    }

    @Override // com.avito.android.in_app_calls.CallRegistry
    @Nullable
    public Call getCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "callUuid");
        return this.a.get(str);
    }

    @Override // com.avito.android.in_app_calls.CallRegistry
    @Nullable
    public Call removeCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "callUuid");
        return this.a.remove(str);
    }
}
