package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.Condition;
import com.avito.android.remote.model.category_parameters.Constraint;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ConstraintTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/category_parameters/Constraint;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "mapping", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ConstraintTypeAdapter implements JsonDeserializer<Constraint> {
    public final Map<String, Type> a = r.mapOf(TuplesKt.to("limit", Constraint.Limit.class), TuplesKt.to("length", Constraint.Length.class), TuplesKt.to("regexp", Constraint.Regex.class), TuplesKt.to("equalTo", Constraint.EqualTo.class), TuplesKt.to("distinctFrom", Constraint.DistinctFrom.class));

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Constraint deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement2;
        JsonObject asJsonObject;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement3 = I1.get("type");
        String str = null;
        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
        if (asString == null) {
            asString = "";
        }
        Type type2 = this.a.get(asString);
        if (type2 == null || (jsonElement2 = I1.get("value")) == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) {
            return null;
        }
        JsonElement jsonElement4 = I1.get("conditions");
        JsonArray asJsonArray = jsonElement4 != null ? jsonElement4.getAsJsonArray() : null;
        JsonElement jsonElement5 = I1.get("conditionFlow");
        if (jsonElement5 != null) {
            str = jsonElement5.getAsString();
        }
        Constraint constraint = (Constraint) jsonDeserializationContext.deserialize(asJsonObject, type2);
        if (asJsonArray != null) {
            ArrayList arrayList = new ArrayList(asJsonArray.size());
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(jsonDeserializationContext.deserialize(it.next(), Condition.class));
            }
            constraint.setConditions(arrayList);
        }
        if (str != null) {
            constraint.setConditionFlow(str);
        }
        return constraint;
    }
}
