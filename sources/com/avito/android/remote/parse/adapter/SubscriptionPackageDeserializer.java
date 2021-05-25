package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.service_subscription.PackageAttribute;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SubscriptionPackageDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/service_subscription/PackageAttribute;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/service_subscription/PackageAttribute;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionPackageDeserializer implements JsonDeserializer<PackageAttribute> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public PackageAttribute deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        if (jsonElement.isJsonObject()) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("type");
            String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (asString == null) {
                Object deserialize = jsonDeserializationContext.deserialize(jsonElement, PackageAttribute.Regular.class);
                Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(json…bute.Regular::class.java)");
                return (PackageAttribute) deserialize;
            }
            int hashCode = asString.hashCode();
            if (hashCode != 1086463900) {
                if (hashCode == 1236617178 && asString.equals("monster")) {
                    JsonElement jsonElement3 = jsonElement.getAsJsonObject().get("value");
                    Intrinsics.checkNotNullExpressionValue(jsonElement3, "json.asJsonObject[VALUE_KEY]");
                    Object deserialize2 = jsonDeserializationContext.deserialize(jsonElement3, PackageAttribute.Monster.class);
                    Intrinsics.checkNotNullExpressionValue(deserialize2, "deserialize(json, T::class.java)");
                    return (PackageAttribute) deserialize2;
                }
            } else if (asString.equals("regular")) {
                JsonElement jsonElement4 = jsonElement.getAsJsonObject().get("value");
                Intrinsics.checkNotNullExpressionValue(jsonElement4, "json.asJsonObject[VALUE_KEY]");
                Object deserialize3 = jsonDeserializationContext.deserialize(jsonElement4, PackageAttribute.Regular.class);
                Intrinsics.checkNotNullExpressionValue(deserialize3, "deserialize(json, T::class.java)");
                return (PackageAttribute) deserialize3;
            }
            throw new IllegalArgumentException(a.c3("Unsupported type: ", asString));
        }
        throw new IllegalArgumentException("Unexpected json: " + jsonElement);
    }
}
