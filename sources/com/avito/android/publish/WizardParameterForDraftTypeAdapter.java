package com.avito.android.publish;

import a2.b.a.a.a;
import com.avito.android.remote.InvalidSchemaException;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/WizardParameterForDraftTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/WizardParameter;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/WizardParameter;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/WizardParameter;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardParameterForDraftTypeAdapter implements JsonSerializer<WizardParameter>, JsonDeserializer<WizardParameter> {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0075 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0075 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public WizardParameter deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        List list;
        Navigation navigation;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonObject asJsonObject = I1.getAsJsonObject("navigation");
        if (asJsonObject != null) {
            Object deserialize = jsonDeserializationContext.deserialize(asJsonObject, Navigation.class);
            Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
            Navigation navigation2 = (Navigation) deserialize;
            if (navigation2 != null) {
                JsonElement jsonElement2 = I1.get("title");
                String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                if (asString == null) {
                    asString = "";
                }
                JsonElement jsonElement3 = I1.get("description");
                String asString2 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                JsonArray asJsonArray = I1.getAsJsonArray("children");
                if (asJsonArray != null) {
                    list = new ArrayList(asJsonArray.size());
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        list.add(jsonDeserializationContext.deserialize(it.next(), WizardParameter.class));
                    }
                } else {
                    list = 0;
                }
                if (list == 0) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                JsonObject asJsonObject2 = I1.getAsJsonObject("rootNavigation");
                if (asJsonObject2 != null) {
                    Object deserialize2 = jsonDeserializationContext.deserialize(asJsonObject2, Navigation.class);
                    Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
                    navigation = (Navigation) deserialize2;
                } else {
                    navigation = null;
                }
                JsonElement jsonElement4 = I1.get("isCrossVertical");
                return new WizardParameter(navigation2, asString, asString2, list, navigation, jsonElement4 != null ? Boolean.valueOf(jsonElement4.getAsBoolean()) : null);
            }
        }
        throw new InvalidSchemaException("WizardParameters' Navigation must not be null");
    }

    @NotNull
    public JsonElement serialize(@NotNull WizardParameter wizardParameter, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(wizardParameter, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("navigation", jsonSerializationContext.serialize(wizardParameter.getNavigation()));
        jsonObject.addProperty("title", wizardParameter.getTitle());
        String description = wizardParameter.getDescription();
        if (description != null) {
            jsonObject.addProperty("description", description);
        }
        jsonObject.add("children", jsonSerializationContext.serialize(wizardParameter.getChildren()));
        jsonObject.addProperty("isCrossVertical", Boolean.valueOf(wizardParameter.isVerticalChange()));
        Navigation rootNavigation = wizardParameter.getRootNavigation();
        if (rootNavigation != null) {
            jsonObject.add("rootNavigation", jsonSerializationContext.serialize(rootNavigation));
        }
        return jsonObject;
    }
}
