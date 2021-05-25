package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.BenefitColoredIcon;
import com.avito.android.remote.model.BenefitIconName;
import com.avito.android.remote.model.UniversalColor;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/BenefitColoredIconAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/BenefitColoredIcon;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/BenefitColoredIcon;", "<init>", "()V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitColoredIconAdapter implements JsonDeserializer<BenefitColoredIcon> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public BenefitColoredIcon deserialize(@NotNull JsonElement jsonElement, @Nullable Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String x2 = a.x2(asJsonObject, "iconName", "jsonBlock[\"iconName\"]");
        UniversalColor universalColor = (UniversalColor) jsonDeserializationContext.deserialize(asJsonObject.get("color"), UniversalColor.class);
        BenefitIconName.Companion companion = BenefitIconName.Companion;
        Intrinsics.checkNotNullExpressionValue(x2, "iconAsString");
        BenefitIconName byNetworkName = companion.getByNetworkName(x2);
        Intrinsics.checkNotNullExpressionValue(universalColor, "color");
        return new BenefitColoredIcon(byNetworkName, universalColor);
    }
}
