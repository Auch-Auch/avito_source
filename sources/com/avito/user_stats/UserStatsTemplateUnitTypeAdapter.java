package com.avito.user_stats;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.user_stats.model.ColumnsTemplate;
import com.avito.user_stats.model.DescriptionTemplate;
import com.avito.user_stats.model.HeaderTemplate;
import com.avito.user_stats.model.InfographicsTemplate;
import com.avito.user_stats.model.SpaceTemplate;
import com.avito.user_stats.model.TemplateUnit;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR*\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/user_stats/UserStatsTemplateUnitTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/user_stats/model/TemplateUnit;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/user_stats/model/TemplateUnit;", "", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "typeMapping", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTemplateUnitTypeAdapter implements JsonDeserializer<TemplateUnit> {
    public final Map<String, Class<? extends TemplateUnit>> a = r.mapOf(TuplesKt.to(TariffPackageInfoConverterKt.HEADER_STRING_ID, HeaderTemplate.class), TuplesKt.to("block_2_columns", ColumnsTemplate.class), TuplesKt.to("description", DescriptionTemplate.class), TuplesKt.to("infographic", InfographicsTemplate.class), TuplesKt.to("space", SpaceTemplate.class));

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public TemplateUnit deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("type");
        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString == null) {
            asString = "";
        }
        Type type2 = (Class) this.a.get(asString);
        if (type2 != null) {
            return (TemplateUnit) jsonDeserializationContext.deserialize(I1, type2);
        }
        return null;
    }
}
