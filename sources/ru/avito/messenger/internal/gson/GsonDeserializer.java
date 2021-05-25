package ru.avito.messenger.internal.gson;

import com.avito.android.jsonrpc.client.Deserializer;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/internal/gson/GsonDeserializer;", "Lcom/avito/android/jsonrpc/client/Deserializer;", "Lcom/google/gson/JsonElement;", "Ljava/lang/reflect/Type;", "type", "data", "", "deserialize", "(Ljava/lang/reflect/Type;Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GsonDeserializer implements Deserializer<JsonElement> {
    public final Gson a;

    public GsonDeserializer(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Nullable
    public Object deserialize(@NotNull Type type, @NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jsonElement, "data");
        return this.a.fromJson(jsonElement, type);
    }
}
