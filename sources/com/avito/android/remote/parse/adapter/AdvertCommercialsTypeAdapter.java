package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PositionedCommercialCascade;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.advert_details.commercials.AdvertCommercialsResponse;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertCommercialsTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/advert_details/commercials/AdvertCommercialsResponse;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/advert_details/commercials/AdvertCommercialsResponse;", "Lcom/google/gson/stream/JsonWriter;", "writer", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/advert_details/commercials/AdvertCommercialsResponse;)V", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertCommercialsTypeAdapter extends TypeAdapter<AdvertCommercialsResponse> {
    public final Gson a;

    public AdvertCommercialsTypeAdapter(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public AdvertCommercialsResponse read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                boolean z = false;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        int hashCode = nextName.hashCode();
                        if (hashCode != -1111047202) {
                            if (hashCode == 1707117674 && nextName.equals("positions")) {
                                if (jsonReader.peek() != JsonToken.NULL) {
                                    JsonToken peek2 = jsonReader.peek();
                                    JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                                    if (peek2 == jsonToken2) {
                                        jsonReader.beginObject();
                                        while (jsonReader.hasNext()) {
                                            ArrayList arrayList2 = new ArrayList();
                                            String nextName2 = jsonReader.nextName();
                                            JsonToken peek3 = jsonReader.peek();
                                            JsonToken jsonToken3 = JsonToken.BEGIN_ARRAY;
                                            if (peek3 == jsonToken3) {
                                                jsonReader.beginArray();
                                                while (jsonReader.hasNext()) {
                                                    SerpElement serpElement = (SerpElement) this.a.getAdapter(SerpElement.class).read(jsonReader);
                                                    if (serpElement != null) {
                                                        arrayList2.add(serpElement);
                                                    }
                                                }
                                                jsonReader.endArray();
                                                Intrinsics.checkNotNullExpressionValue(nextName2, "name");
                                                arrayList.add(new PositionedCommercialCascade(nextName2, arrayList2));
                                            } else {
                                                throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken3, " but was "), " at ", jsonReader));
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
                        } else if (nextName.equals("enableEventSampling")) {
                            z = jsonReader.nextBoolean();
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new AdvertCommercialsResponse(arrayList, z);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable AdvertCommercialsResponse advertCommercialsResponse) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        throw new UnsupportedOperationException();
    }
}
