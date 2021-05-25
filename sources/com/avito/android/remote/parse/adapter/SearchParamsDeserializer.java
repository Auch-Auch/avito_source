package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SearchParamsDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/SearchParams;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/SearchParams;", "Lcom/google/gson/JsonArray;", "jsonArray", "", "", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonArray;)Ljava/util/List;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchParamsDeserializer implements JsonDeserializer<SearchParams> {
    public final List<String> a(JsonArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement jsonElement = (JsonElement) it.next();
            Intrinsics.checkNotNullExpressionValue(jsonElement, "it");
            arrayList.add(jsonElement.getAsString());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:153:0x0321 A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x032a A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0336 A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x033f A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x034b A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0354 A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x035f A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0368 A[Catch:{ ClassCastException -> 0x0391 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x01ff A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x011b A[SYNTHETIC] */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.SearchParams deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r31, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r32, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r33) {
        /*
        // Method dump skipped, instructions count: 943
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.SearchParamsDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.SearchParams");
    }
}
