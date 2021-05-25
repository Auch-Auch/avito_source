package com.sumsub.sns.core.data.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/data/deserializer/RemoteRequiredDocImagePreviewResultDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/sumsub/sns/core/data/model/remote/RemoteRequiredDoc$ImageReviewResult;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteRequiredDocImagePreviewResultDeserializer implements JsonDeserializer<RemoteRequiredDoc.ImageReviewResult> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public RemoteRequiredDoc.ImageReviewResult deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Set<Map.Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "jsonObject.entrySet()");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(entrySet, 10));
        for (T t : entrySet) {
            Object key = t.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            int parseInt = Integer.parseInt((String) key);
            Object value = t.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            arrayList.add(TuplesKt.to(Integer.valueOf(parseInt), (RemoteRequiredDoc.ReviewResult) jsonDeserializationContext.deserialize(((JsonElement) value).getAsJsonObject(), RemoteRequiredDoc.ReviewResult.class)));
        }
        return new RemoteRequiredDoc.ImageReviewResult(r.toMap(arrayList));
    }
}
