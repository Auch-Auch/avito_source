package com.avito.android.remote.parse.adapter.stream_gson;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SimpleLocation;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/LocationTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/Location;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/Location;)V", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/Location;", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LocationTypeAdapter extends TypeAdapter<Location> {
    public final Gson a;

    public LocationTypeAdapter(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public Location read(@NotNull JsonReader jsonReader) {
        SimpleLocation simpleLocation;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                SimpleLocation simpleLocation2 = null;
                String str = null;
                String str2 = null;
                CaseText caseText = null;
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        switch (nextName.hashCode()) {
                            case -995424086:
                                if (!nextName.equals("parent")) {
                                    break;
                                } else {
                                    simpleLocation2 = (SimpleLocation) this.a.getAdapter(SimpleLocation.class).read(jsonReader);
                                    continue;
                                }
                            case -718268117:
                                if (!nextName.equals("hasDistricts")) {
                                    break;
                                } else {
                                    z4 = jsonReader.nextBoolean();
                                    continue;
                                }
                            case 3355:
                                if (!nextName.equals("id")) {
                                    break;
                                } else {
                                    str2 = String.valueOf(jsonReader.nextInt());
                                    continue;
                                }
                            case 104585032:
                                if (!nextName.equals("names")) {
                                    break;
                                } else {
                                    caseText = (CaseText) this.a.getAdapter(CaseText.class).read(jsonReader);
                                    continue;
                                }
                            case 123779743:
                                if (!nextName.equals("hasMetro")) {
                                    break;
                                } else {
                                    z = jsonReader.nextBoolean();
                                    continue;
                                }
                            case 239016633:
                                if (!nextName.equals("hasChildren")) {
                                    break;
                                } else {
                                    z2 = jsonReader.nextBoolean();
                                    continue;
                                }
                            case 913923854:
                                if (!nextName.equals("hasDirections")) {
                                    break;
                                } else {
                                    z3 = jsonReader.nextBoolean();
                                    continue;
                                }
                            case 1175162725:
                                if (!nextName.equals("parentId")) {
                                    break;
                                } else {
                                    str = String.valueOf(jsonReader.nextInt());
                                    continue;
                                }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (simpleLocation2 != null) {
                    simpleLocation = simpleLocation2;
                } else {
                    simpleLocation = str != null ? new SimpleLocation(str, new CaseText()) : null;
                }
                if (str2 == null || caseText == null) {
                    return null;
                }
                return new Location(str2, caseText, z, z2, z3, z4, simpleLocation, false, null, null, 896, null);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    public void write(@Nullable JsonWriter jsonWriter, @Nullable Location location) {
        throw new UnsupportedOperationException();
    }
}
