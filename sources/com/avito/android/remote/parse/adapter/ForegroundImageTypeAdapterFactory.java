package com.avito.android.remote.parse.adapter;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ForegroundImageTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "T", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ForegroundImageTypeAdapterFactory implements TypeAdapterFactory {
    public final Features a;

    public ForegroundImageTypeAdapterFactory(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.google.gson.TypeAdapterFactory
    @Nullable
    public <T> TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        if (!Intrinsics.areEqual(typeToken.getRawType(), ForegroundImage.class)) {
            return null;
        }
        TypeAdapter<T> adapter = gson.getAdapter(AttributedText.class);
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<com.avito.android.remote.model.text.AttributedText>");
        TypeAdapter<T> adapter2 = gson.getAdapter(UniversalColor.class);
        Objects.requireNonNull(adapter2, "null cannot be cast to non-null type com.google.gson.TypeAdapter<com.avito.android.remote.model.UniversalColor>");
        TypeAdapter<T> adapter3 = gson.getAdapter(Image.class);
        Objects.requireNonNull(adapter3, "null cannot be cast to non-null type com.google.gson.TypeAdapter<com.avito.android.remote.model.Image>");
        return new ForegroundImageTypeAdapter(adapter, adapter2, adapter3, this.a);
    }
}
