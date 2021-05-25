package com.avito.android.remote.parse.adapter;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.gson.stream.JsonToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/parse/adapter/DeepLinkParseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/google/gson/stream/JsonToken;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "<init>", "(Lcom/google/gson/stream/JsonToken;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkParseException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepLinkParseException(@NotNull JsonToken jsonToken) {
        super("Wrong DeepLink format. Expected " + JsonToken.STRING + " or " + JsonToken.NULL + ", but was " + jsonToken + FormatterType.defaultDecimalSeparator);
        Intrinsics.checkNotNullParameter(jsonToken, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
    }
}
