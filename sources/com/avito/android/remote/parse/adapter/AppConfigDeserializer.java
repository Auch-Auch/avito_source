package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.config.AppConfig;
import com.avito.android.util.JsonObjectExtensionsKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AppConfigDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/config/AppConfig;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/config/AppConfig;", "<init>", "()V", "config_release"}, k = 1, mv = {1, 4, 2})
public final class AppConfigDeserializer implements JsonDeserializer<AppConfig> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AppConfig deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        AppConfig appConfig = new AppConfig(0, 0, 0, 0, false, 31, null);
        Intrinsics.checkNotNullExpressionValue(I1, "js");
        JsonElement jsonElement2 = I1.get("versionMin");
        boolean z = false;
        appConfig.setVersionMin(jsonElement2 != null ? jsonElement2.getAsInt() : 0);
        JsonElement jsonElement3 = I1.get("versionMax");
        appConfig.setVersionMax(jsonElement3 != null ? jsonElement3.getAsInt() : 0);
        JsonElement jsonElement4 = I1.get("platformVersion");
        appConfig.setPlatformVersion(jsonElement4 != null ? jsonElement4.getAsInt() : 0);
        Long nullableLong = JsonObjectExtensionsKt.getNullableLong(I1, "geoReportTimeout");
        appConfig.setGeoReportTimeout(nullableLong != null ? nullableLong.longValue() : 0);
        JsonElement jsonElement5 = I1.get("yandexReportsEnabled");
        if (jsonElement5 != null && jsonElement5.getAsInt() == 1) {
            z = true;
        }
        appConfig.setYandexReportsEnabled(z);
        return appConfig;
    }
}
