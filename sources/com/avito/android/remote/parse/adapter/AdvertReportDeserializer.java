package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.AdvertReport;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AdvertReportDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/AdvertReport;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/AdvertReport;", "<init>", "()V", "item-report_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertReportDeserializer implements JsonDeserializer<AdvertReport> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AdvertReport deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        String asString;
        JsonElement jsonElement2;
        String asString2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement5 = I1.get("reportInfo");
        ArrayList arrayList = null;
        JsonObject asJsonObject = jsonElement5 != null ? jsonElement5.getAsJsonObject() : null;
        JsonElement jsonElement6 = I1.get("title");
        String asString3 = jsonElement6 != null ? jsonElement6.getAsString() : null;
        JsonElement jsonElement7 = I1.get(TariffPackageInfoConverterKt.HEADER_STRING_ID);
        String asString4 = jsonElement7 != null ? jsonElement7.getAsString() : null;
        String asString5 = (asJsonObject == null || (jsonElement4 = asJsonObject.get("requisite")) == null) ? null : jsonElement4.getAsString();
        String asString6 = (asJsonObject == null || (jsonElement3 = asJsonObject.get("status")) == null) ? null : jsonElement3.getAsString();
        JsonElement jsonElement8 = I1.get(Sort.DATE);
        String asString7 = jsonElement8 != null ? jsonElement8.getAsString() : null;
        JsonElement jsonElement9 = I1.get("legalInfo");
        AttributedText attributedText = (AttributedText) (jsonElement9 != null ? jsonDeserializationContext.deserialize(jsonElement9, AttributedText.class) : null);
        JsonElement jsonElement10 = I1.get(Navigation.ATTRIBUTES);
        JsonArray asJsonArray = jsonElement10 != null ? jsonElement10.getAsJsonArray() : null;
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement11 = asJsonArray.get(i);
                Intrinsics.checkNotNullExpressionValue(jsonElement11, "jsonArray[a]");
                JsonObject asJsonObject2 = jsonElement11.getAsJsonObject();
                JsonElement jsonElement12 = asJsonObject2.get("icon");
                if (!(jsonElement12 == null || (asString = jsonElement12.getAsString()) == null || (jsonElement2 = asJsonObject2.get("title")) == null || (asString2 = jsonElement2.getAsString()) == null)) {
                    int hashCode = asString.hashCode();
                    if (hashCode != 2524) {
                        if (hashCode == 2656902 && asString.equals("WARN")) {
                            arrayList.add(new AdvertReport.WarnResult(asString2));
                        }
                    } else if (asString.equals("OK")) {
                        arrayList.add(new AdvertReport.OkResult(asString2));
                    }
                }
            }
        }
        return new AdvertReport(asString3, asString4, asString5, asString6, asString7, attributedText, arrayList);
    }
}
