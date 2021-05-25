package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/WizardConfigTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class WizardConfigTypeAdapter implements JsonDeserializer<CategoryPublishStep.Wizard.Config> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public CategoryPublishStep.Wizard.Config deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("leaves")) {
            return null;
        }
        JsonElement jsonElement2 = asJsonObject.get("leaves");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "configJsonObject[\"leaves\"]");
        JsonArray asJsonArray = jsonElement2.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(asJsonArray, "leavesArray");
        if (asJsonArray.size() == 0) {
            return null;
        }
        JsonElement jsonElement3 = asJsonArray.get(0);
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "leavesArray[0]");
        if (jsonElement3.isJsonPrimitive()) {
            Type type2 = new TypeToken<List<? extends String>>() { // from class: com.avito.android.remote.parse.adapter.WizardConfigTypeAdapter$deserialize$$inlined$gsonTypeToken$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
            return new CategoryPublishStep.Wizard.Config((List) jsonDeserializationContext.deserialize(asJsonArray, type2), null);
        }
        Type type3 = new TypeToken<List<? extends Navigation>>() { // from class: com.avito.android.remote.parse.adapter.WizardConfigTypeAdapter$deserialize$$inlined$gsonTypeToken$2
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type3, "object : TypeToken<T>() {}.type");
        return new CategoryPublishStep.Wizard.Config(null, (List) jsonDeserializationContext.deserialize(asJsonArray, type3));
    }
}
