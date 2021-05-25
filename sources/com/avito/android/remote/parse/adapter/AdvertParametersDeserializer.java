package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertParametersDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AdvertParameters;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AdvertParameters;", "Lcom/google/gson/JsonArray;", "js", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonArray;Lcom/google/gson/JsonDeserializationContext;)Ljava/util/List;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertParametersDeserializer implements JsonDeserializer<AdvertParameters> {
    public final List<AdvertParameters.Parameter> a(JsonArray jsonArray, JsonDeserializationContext jsonDeserializationContext) {
        List list;
        if (jsonArray == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsonArray.size());
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement jsonElement = (JsonElement) it.next();
            Intrinsics.checkNotNullExpressionValue(jsonElement, "element");
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            String x2 = a.x2(asJsonObject, "title", "js[\"title\"]");
            JsonElement jsonElement2 = asJsonObject.get("subtitles");
            Object obj = null;
            JsonArray<JsonElement> asJsonArray = jsonElement2 != null ? jsonElement2.getAsJsonArray() : null;
            if (asJsonArray == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList arrayList2 = new ArrayList(asJsonArray.size());
                for (JsonElement jsonElement3 : asJsonArray) {
                    Intrinsics.checkNotNullExpressionValue(jsonElement3, "element");
                    arrayList2.add(jsonElement3.getAsString());
                }
                list = arrayList2;
            }
            JsonElement jsonElement4 = asJsonObject.get("description");
            String asString = jsonElement4 != null ? jsonElement4.getAsString() : null;
            JsonElement jsonElement5 = asJsonObject.get(ShareConstants.MEDIA_URI);
            if (jsonElement5 != null) {
                obj = jsonDeserializationContext.deserialize(jsonElement5, DeepLink.class);
            }
            Intrinsics.checkNotNullExpressionValue(x2, "title");
            arrayList.add(new AdvertParameters.Parameter(x2, list, asString, (DeepLink) obj));
        }
        return arrayList;
    }

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AdvertParameters deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        List list;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        List<AdvertParameters.Parameter> a = a(I1.getAsJsonArray("flat"), jsonDeserializationContext);
        JsonArray<JsonElement> asJsonArray = I1.getAsJsonArray("groups");
        if (asJsonArray == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(asJsonArray.size());
            for (JsonElement jsonElement2 : asJsonArray) {
                Intrinsics.checkNotNullExpressionValue(jsonElement2, "element");
                JsonObject asJsonObject = jsonElement2.getAsJsonObject();
                String x2 = a.x2(asJsonObject, "title", "js[\"title\"]");
                List<AdvertParameters.Parameter> a3 = a(asJsonObject.getAsJsonArray(ResidentialComplexModuleKt.VALUES), jsonDeserializationContext);
                Intrinsics.checkNotNullExpressionValue(x2, "title");
                arrayList.add(new AdvertParameters.Group(x2, a3));
            }
            list = arrayList;
        }
        JsonElement jsonElement3 = I1.get("flatTitle");
        return new AdvertParameters(a, list, (AttributedText) (jsonElement3 != null ? jsonDeserializationContext.deserialize(jsonElement3, AttributedText.class) : null));
    }
}
