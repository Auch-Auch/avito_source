package ru.avito.messenger.internal.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.log.Logger;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BE\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b!\u0010\"J'\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\rR*\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00198$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lru/avito/messenger/internal/util/RuntimeTypeAdapter;", "T", "Lcom/google/gson/JsonDeserializer;", "Lcom/google/gson/JsonObject;", "json", "Ljava/lang/reflect/Type;", "type", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonObject;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "Lcom/google/gson/JsonElement;", "typeOfT", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lru/avito/messenger/internal/gson/TypeId;", "c", "Lkotlin/jvm/functions/Function2;", "fallback", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "subtypeKey", AuthSource.SEND_ABUSE, "typeKey", "", "getMapping", "()Ljava/util/Map;", "mapping", "Lru/avito/messenger/internal/log/Logger;", "d", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class RuntimeTypeAdapter<T> implements JsonDeserializer<T> {
    public final String a;
    public final String b;
    public final Function2<TypeId, JsonObject, T> c;
    public final Logger d;

    public RuntimeTypeAdapter() {
        this(null, null, null, null, 15, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super ru.avito.messenger.internal.gson.TypeId, ? super com.google.gson.JsonObject, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeTypeAdapter(@NotNull String str, @NotNull String str2, @Nullable Function2<? super TypeId, ? super JsonObject, ? extends T> function2, @Nullable Logger logger) {
        Intrinsics.checkNotNullParameter(str, "typeKey");
        Intrinsics.checkNotNullParameter(str2, "subtypeKey");
        this.a = str;
        this.b = str2;
        this.c = function2;
        this.d = logger;
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public final T deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get(this.a);
        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString == null) {
            asString = "";
        }
        JsonElement jsonElement3 = I1.get(this.b);
        TypeId typeId = new TypeId(asString, jsonElement3 != null ? jsonElement3.getAsString() : null);
        Type type2 = getMapping().get(typeId);
        if (type2 != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(I1, "js");
                return deserialize(I1, type2, jsonDeserializationContext);
            } catch (Exception e) {
                Logger logger = this.d;
                if (logger != null) {
                    logger.d("RuntimeTypeAdapter", "Failed to parse json", e);
                }
                Function2<TypeId, JsonObject, T> function2 = this.c;
                if (function2 != null) {
                    Intrinsics.checkNotNullExpressionValue(I1, "js");
                    return function2.invoke(typeId, I1);
                }
                throw e;
            }
        } else {
            Type type3 = getMapping().get(new TypeId(asString, null, 2, null));
            if (type3 != null) {
                Intrinsics.checkNotNullExpressionValue(I1, "js");
                return deserialize(I1, type3, jsonDeserializationContext);
            }
            Function2<TypeId, JsonObject, T> function22 = this.c;
            if (function22 == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(I1, "js");
            return function22.invoke(typeId, I1);
        }
    }

    public abstract T deserialize(@NotNull JsonObject jsonObject, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext);

    @NotNull
    public abstract Map<TypeId, Type> getMapping();

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RuntimeTypeAdapter(String str, String str2, Function2 function2, Logger logger, int i, j jVar) {
        this((i & 1) != 0 ? "type" : str, (i & 2) != 0 ? "subtype" : str2, (i & 4) != 0 ? null : function2, (i & 8) != 0 ? null : logger);
    }
}
