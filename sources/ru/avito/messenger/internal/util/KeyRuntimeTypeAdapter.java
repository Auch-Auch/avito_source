package ru.avito.messenger.internal.util;

import a2.b.a.a.a;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.log.Logger;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BE\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/avito/messenger/internal/util/KeyRuntimeTypeAdapter;", "T", "Lru/avito/messenger/internal/util/RuntimeTypeAdapter;", "Lcom/google/gson/JsonObject;", "json", "Ljava/lang/reflect/Type;", "type", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonObject;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "", "e", "Ljava/lang/String;", "valueKey", "typeKey", "Lkotlin/Function2;", "Lru/avito/messenger/internal/gson/TypeId;", "fallback", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class KeyRuntimeTypeAdapter<T> extends RuntimeTypeAdapter<T> {
    public final String e;

    public KeyRuntimeTypeAdapter() {
        this(null, null, null, null, 15, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyRuntimeTypeAdapter(String str, String str2, Function2 function2, Logger logger, int i, j jVar) {
        this((i & 1) != 0 ? "type" : str, (i & 2) != 0 ? "value" : str2, (i & 4) != 0 ? null : function2, (i & 8) != 0 ? null : logger);
    }

    @Override // ru.avito.messenger.internal.util.RuntimeTypeAdapter
    public final T deserialize(@NotNull JsonObject jsonObject, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Intrinsics.checkNotNullParameter(jsonObject, "json");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        JsonElement jsonElement = jsonObject.get(this.e);
        Intrinsics.checkNotNullExpressionValue(jsonElement, "value");
        if (jsonElement.isJsonObject()) {
            return (T) jsonDeserializationContext.deserialize(jsonElement.getAsJsonObject(), type);
        }
        StringBuilder L = a.L("Unexpected value at json['");
        L.append(this.e);
        L.append("'], where json=");
        L.append(jsonObject);
        throw new IllegalArgumentException(L.toString());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KeyRuntimeTypeAdapter(@NotNull String str, @NotNull String str2, @Nullable Function2<? super TypeId, ? super JsonObject, ? extends T> function2, @Nullable Logger logger) {
        super(str, null, function2, logger, 2, null);
        Intrinsics.checkNotNullParameter(str, "typeKey");
        Intrinsics.checkNotNullParameter(str2, "valueKey");
        this.e = str2;
    }
}
