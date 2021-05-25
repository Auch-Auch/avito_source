package com.avito.android.epress_cv.remote;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.epress_cv.remote.model.CreateExpressCvResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/epress_cv/remote/CreateExpressCvOkTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$Ok;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$Ok;", "<init>", "()V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class CreateExpressCvOkTypeAdapter implements JsonDeserializer<CreateExpressCvResult> {
    /* Return type fixed from 'com.avito.android.epress_cv.remote.model.CreateExpressCvResult$Ok' to match base method */
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public CreateExpressCvResult deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement, DeepLink.class);
        Intrinsics.checkNotNullExpressionValue(deserialize, "deserialize(json, T::class.java)");
        return new CreateExpressCvResult.Ok((DeepLink) deserialize);
    }
}
