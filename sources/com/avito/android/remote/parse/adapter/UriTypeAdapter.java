package com.avito.android.remote.parse.adapter;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/UriTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/net/Uri;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Landroid/net/Uri;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, ShareConstants.MEDIA_URI, "", "write", "(Lcom/google/gson/stream/JsonWriter;Landroid/net/Uri;)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UriTypeAdapter extends TypeAdapter<Uri> {
    @Override // com.google.gson.TypeAdapter
    @NotNull
    public Uri read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Uri parse = Uri.parse(jsonReader.nextString());
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(reader.nextString())");
        return parse;
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        jsonWriter.value(String.valueOf(uri));
    }
}
