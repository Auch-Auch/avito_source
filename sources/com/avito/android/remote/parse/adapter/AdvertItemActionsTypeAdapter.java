package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.AdvertItemActions;
import com.avito.android.remote.model.HideAction;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertItemActionsTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/AdvertItemActions;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/AdvertItemActions;", "Lcom/google/gson/stream/JsonWriter;", "writer", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/AdvertItemActions;)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemActionsTypeAdapter extends TypeAdapter<AdvertItemActions> {
    @Override // com.google.gson.TypeAdapter
    @NotNull
    public AdvertItemActions read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                String str = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        int hashCode = nextName.hashCode();
                        if (hashCode != -1161803523) {
                            if (hashCode == 110371416 && nextName.equals("title")) {
                                str = jsonReader.nextString();
                            }
                        } else if (nextName.equals("actions")) {
                            JsonToken peek2 = jsonReader.peek();
                            JsonToken jsonToken2 = JsonToken.BEGIN_ARRAY;
                            if (peek2 == jsonToken2) {
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    if (jsonReader.peek() != JsonToken.NULL) {
                                        JsonToken peek3 = jsonReader.peek();
                                        JsonToken jsonToken3 = JsonToken.BEGIN_OBJECT;
                                        if (peek3 == jsonToken3) {
                                            jsonReader.beginObject();
                                            HideAction hideAction = null;
                                            while (jsonReader.hasNext()) {
                                                String nextName2 = jsonReader.nextName();
                                                if (nextName2 != null && nextName2.hashCode() == 3202370 && nextName2.equals("hide")) {
                                                    boolean z = true;
                                                    if (jsonReader.peek() != JsonToken.NULL) {
                                                        JsonToken peek4 = jsonReader.peek();
                                                        JsonToken jsonToken4 = JsonToken.BEGIN_OBJECT;
                                                        if (peek4 == jsonToken4) {
                                                            jsonReader.beginObject();
                                                            String str2 = null;
                                                            String str3 = null;
                                                            while (jsonReader.hasNext()) {
                                                                String nextName3 = jsonReader.nextName();
                                                                if (nextName3 != null) {
                                                                    int hashCode2 = nextName3.hashCode();
                                                                    if (hashCode2 != -283407311) {
                                                                        if (hashCode2 != 102727412) {
                                                                            if (hashCode2 == 110371416 && nextName3.equals("title")) {
                                                                                str3 = jsonReader.nextString();
                                                                            }
                                                                        } else if (nextName3.equals("label")) {
                                                                            str2 = jsonReader.nextString();
                                                                        }
                                                                    } else if (nextName3.equals("use_icon")) {
                                                                        z = jsonReader.nextBoolean();
                                                                    }
                                                                }
                                                                jsonReader.skipValue();
                                                            }
                                                            jsonReader.endObject();
                                                            if (!(str2 == null || str3 == null)) {
                                                                Intrinsics.checkNotNull(str2);
                                                                Intrinsics.checkNotNull(str3);
                                                                hideAction = new HideAction(str2, str3, z);
                                                            }
                                                        } else {
                                                            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken4, " but was "), " at ", jsonReader));
                                                        }
                                                    } else {
                                                        throw new JsonNullParsingException();
                                                    }
                                                } else {
                                                    jsonReader.skipValue();
                                                }
                                            }
                                            jsonReader.endObject();
                                            if (hideAction != null) {
                                                arrayList.add(hideAction);
                                            }
                                        } else {
                                            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken3, " but was "), " at ", jsonReader));
                                        }
                                    } else {
                                        throw new JsonNullParsingException();
                                    }
                                }
                                jsonReader.endArray();
                            } else {
                                throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken2, " but was "), " at ", jsonReader));
                            }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return new AdvertItemActions(arrayList, str);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    public void write(@NotNull JsonWriter jsonWriter, @Nullable AdvertItemActions advertItemActions) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        throw new UnsupportedOperationException();
    }
}
