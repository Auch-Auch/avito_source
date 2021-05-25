package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.PretendErrorValue;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/FieldsMessagesTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/PretendErrorValue$FieldsMessages;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/PretendErrorValue$FieldsMessages;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class FieldsMessagesTypeAdapter implements JsonDeserializer<PretendErrorValue.FieldsMessages> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public PretendErrorValue.FieldsMessages deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        return new PretendErrorValue.FieldsMessages((Map) jsonDeserializationContext.deserialize(a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context"), FieldsErrorTypeAdapterKt.access$getMAP_TYPE_TOKEN$p().getType()));
    }
}
