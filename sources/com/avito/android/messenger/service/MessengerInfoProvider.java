package com.avito.android.messenger.service;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/service/MessengerInfoProvider;", "", "", "provideEndpoint", "()Ljava/lang/String;", "provideOrigin", "provideImageUploadEndpoint", "provideFileTransferEndpoint", "", "provideHandshakeHeaders", "()Ljava/util/Map;", "provideConnectionParameters", "api_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerInfoProvider {
    @NotNull
    Map<String, String> provideConnectionParameters();

    @NotNull
    String provideEndpoint();

    @NotNull
    String provideFileTransferEndpoint();

    @NotNull
    Map<String, String> provideHandshakeHeaders();

    @NotNull
    String provideImageUploadEndpoint();

    @NotNull
    String provideOrigin();
}
