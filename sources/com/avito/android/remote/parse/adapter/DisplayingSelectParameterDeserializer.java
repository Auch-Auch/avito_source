package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.SortDirection;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/DisplayingSelectParameterDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "", "", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "sortDirectionMap", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DisplayingSelectParameterDeserializer implements JsonDeserializer<SelectParameter.Displaying> {
    public final Map<String, SortDirection> a = r.mapOf(TuplesKt.to("acs", SortDirection.Ascending), TuplesKt.to("desc", SortDirection.Descending));

    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public SelectParameter.Displaying deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String str;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("type");
        if (jsonElement2 == null || (str = jsonElement2.getAsString()) == null) {
            str = "default";
        }
        JsonElement jsonElement3 = I1.get("typoCorrectionEnabled");
        boolean asBoolean = jsonElement3 != null ? jsonElement3.getAsBoolean() : false;
        JsonElement jsonElement4 = I1.get("withImages");
        boolean asBoolean2 = jsonElement4 != null ? jsonElement4.getAsBoolean() : false;
        JsonElement jsonElement5 = I1.get("titlePattern");
        Boolean bool = null;
        String asString = jsonElement5 != null ? jsonElement5.getAsString() : null;
        JsonElement jsonElement6 = I1.get("sortDirection");
        String asString2 = jsonElement6 != null ? jsonElement6.getAsString() : null;
        Intrinsics.checkNotNullExpressionValue(I1, "jsonObject");
        JsonElement jsonElement7 = I1.get("hideTitle.v2");
        if (jsonElement7 != null) {
            bool = Boolean.valueOf(jsonElement7.getAsBoolean());
        } else {
            JsonElement jsonElement8 = I1.get("hideTitle");
            if (jsonElement8 != null) {
                bool = Boolean.valueOf(jsonElement8.getAsBoolean());
            }
        }
        return new SelectParameter.Displaying(str, Boolean.valueOf(asBoolean), bool != null ? bool.booleanValue() : false, Boolean.valueOf(asBoolean2), asString, this.a.get(asString2));
    }
}
