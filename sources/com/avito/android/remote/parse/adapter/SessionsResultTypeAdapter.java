package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.SessionsElement;
import com.avito.android.remote.model.SessionsResult;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SessionsResultTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/SessionsResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/SessionsResult;", "<init>", "()V", "sessions_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsResultTypeAdapter implements JsonDeserializer<SessionsResult> {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0042 */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public SessionsResult deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ArrayList arrayList;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("list");
        Long l = null;
        JsonArray asJsonArray = jsonElement2 != null ? jsonElement2.getAsJsonArray() : null;
        if (asJsonArray != null) {
            arrayList = new ArrayList(asJsonArray.size());
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(jsonDeserializationContext.deserialize(it.next(), SessionsElement.class));
            }
        } else {
            arrayList = null;
        }
        JsonElement jsonElement3 = I1.get("cursor");
        if (jsonElement3 != null) {
            l = Long.valueOf(jsonElement3.getAsLong());
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return new SessionsResult(arrayList2, l);
    }
}
