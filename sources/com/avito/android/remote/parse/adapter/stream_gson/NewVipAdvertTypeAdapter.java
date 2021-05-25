package com.avito.android.remote.parse.adapter.stream_gson;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.section.VipAdvert;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/NewVipAdvertTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/section/VipAdvert;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/section/VipAdvert;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/section/VipAdvert;)V", "Lcom/avito/android/remote/model/SerpAdvert;", AuthSource.SEND_ABUSE, "Lcom/google/gson/TypeAdapter;", "serpAdapter", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class NewVipAdvertTypeAdapter extends TypeAdapter<VipAdvert> {
    public final TypeAdapter<SerpAdvert> a;

    public NewVipAdvertTypeAdapter(@NotNull TypeAdapter<SerpAdvert> typeAdapter) {
        Intrinsics.checkNotNullParameter(typeAdapter, "serpAdapter");
        this.a = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public VipAdvert read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        SerpAdvert read = this.a.read(jsonReader);
        Intrinsics.checkNotNullExpressionValue(read, "serpAdvert");
        return new VipAdvert(read);
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable VipAdvert vipAdvert) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        throw new UnsupportedOperationException();
    }
}
