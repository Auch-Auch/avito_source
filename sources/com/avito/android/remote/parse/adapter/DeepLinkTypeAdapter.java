package com.avito.android.remote.parse.adapter;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/DeepLinkTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkTypeAdapter extends TypeAdapter<DeepLink> {
    public final DeepLinkFactory a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
            iArr[8] = 2;
        }
    }

    public DeepLinkTypeAdapter(@NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        this.a = deepLinkFactory;
    }

    @Override // com.google.gson.TypeAdapter
    @NotNull
    public DeepLink read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        JsonToken peek = jsonReader.peek();
        if (peek != null) {
            int ordinal = peek.ordinal();
            if (ordinal == 5) {
                DeepLinkFactory deepLinkFactory = this.a;
                String nextString = jsonReader.nextString();
                Intrinsics.checkNotNullExpressionValue(nextString, "reader.nextString()");
                return deepLinkFactory.createFromUri(nextString);
            } else if (ordinal == 8) {
                return new NoMatchLink();
            }
        }
        Intrinsics.checkNotNullExpressionValue(peek, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        throw new DeepLinkParseException(peek);
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        throw new UnsupportedOperationException();
    }
}
