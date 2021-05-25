package com.avito.android.remote.parse.adapter.stream_gson;

import a2.b.a.a.a;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/DfpSerpBannerTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/DfpBannerItem;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/DfpBannerItem;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/DfpBannerItem;", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DfpSerpBannerTypeAdapter extends TypeAdapter<DfpBannerItem> {
    public DfpSerpBannerTypeAdapter(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public DfpBannerItem read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                String str = null;
                String str2 = null;
                String str3 = null;
                LinkedHashMap linkedHashMap = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        int hashCode = nextName.hashCode();
                        if (hashCode != -1343989199) {
                            if (hashCode != -1032180935) {
                                if (hashCode != 3355) {
                                    if (hashCode == 2996870 && nextName.equals("alid")) {
                                        str2 = jsonReader.nextString();
                                    }
                                } else if (nextName.equals("id")) {
                                    str = jsonReader.nextString();
                                }
                            } else if (nextName.equals("bannerCode")) {
                                str3 = jsonReader.nextString();
                            }
                        } else if (nextName.equals("networkExtras")) {
                            linkedHashMap = new LinkedHashMap();
                            if (jsonReader.peek() != JsonToken.NULL) {
                                JsonToken peek2 = jsonReader.peek();
                                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                                if (peek2 == jsonToken2) {
                                    jsonReader.beginObject();
                                    while (jsonReader.hasNext()) {
                                        String nextName2 = jsonReader.nextName();
                                        JsonToken peek3 = jsonReader.peek();
                                        if (peek3 == JsonToken.NULL) {
                                            jsonReader.skipValue();
                                        } else {
                                            JsonToken jsonToken3 = JsonToken.BEGIN_ARRAY;
                                            if (peek3 == jsonToken3) {
                                                ArrayList arrayList = new ArrayList();
                                                if (jsonReader.peek() == jsonToken3) {
                                                    jsonReader.beginArray();
                                                    while (jsonReader.hasNext()) {
                                                        String nextString = jsonReader.nextString();
                                                        Intrinsics.checkNotNullExpressionValue(nextString, "nextString()");
                                                        arrayList.add(nextString);
                                                    }
                                                    jsonReader.endArray();
                                                    Intrinsics.checkNotNullExpressionValue(nextName2, "key");
                                                    linkedHashMap.put(nextName2, arrayList);
                                                } else {
                                                    throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken3, " but was "), " at ", jsonReader));
                                                }
                                            } else {
                                                Intrinsics.checkNotNullExpressionValue(nextName2, "key");
                                                String nextString2 = jsonReader.nextString();
                                                Intrinsics.checkNotNullExpressionValue(nextString2, "nextString()");
                                                linkedHashMap.put(nextName2, nextString2);
                                            }
                                        }
                                    }
                                    jsonReader.endObject();
                                } else {
                                    throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken2, " but was "), " at ", jsonReader));
                                }
                            } else {
                                throw new JsonNullParsingException();
                            }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (str == null) {
                    return null;
                }
                return new DfpBannerItem(str, str2, str3, linkedHashMap);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable DfpBannerItem dfpBannerItem) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        throw new UnsupportedOperationException();
    }
}
