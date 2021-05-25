package com.avito.android.remote.parse.adapter.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.parse.adapter.RuntimeTypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f8\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/parse/adapter/messenger/ContextActionHandlerTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ContextActionHandlerTypeAdapter extends RuntimeTypeAdapter<ContextActionHandler> implements JsonSerializer<ContextActionHandler> {
    @NotNull
    public final Map<String, Type> a = r.mapOf(TuplesKt.to(ContextActionHandler.MethodCall.TYPE, ContextActionHandler.MethodCall.class), TuplesKt.to("link", ContextActionHandler.Link.class));

    public ContextActionHandlerTypeAdapter() {
        super(null, null, ContextActionHandler.Unknown.class, 3, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Type> getMapping() {
        return this.a;
    }

    @NotNull
    public JsonElement serialize(@NotNull ContextActionHandler contextActionHandler, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(contextActionHandler, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (contextActionHandler instanceof ContextActionHandler.Link) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("type", jsonSerializationContext.serialize("link"));
            JsonObject jsonObject2 = new JsonObject();
            ContextActionHandler.Link link = (ContextActionHandler.Link) contextActionHandler;
            jsonObject2.add("url", jsonSerializationContext.serialize(link.getLink()));
            jsonObject2.add("deepLink", jsonSerializationContext.serialize(link.getDeepLink()));
            jsonObject.add("value", jsonObject2);
            return jsonObject;
        } else if (contextActionHandler instanceof ContextActionHandler.MethodCall) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.add("type", jsonSerializationContext.serialize(ContextActionHandler.MethodCall.TYPE));
            JsonObject jsonObject4 = new JsonObject();
            ContextActionHandler.MethodCall methodCall = (ContextActionHandler.MethodCall) contextActionHandler;
            jsonObject4.add("method", jsonSerializationContext.serialize(methodCall.getMethod()));
            RawJson params = methodCall.getParams();
            if (params != null) {
                jsonObject4.add("params", jsonSerializationContext.serialize(params));
            }
            ContextActionHandler.MethodCall.Reaction reaction = methodCall.getReaction();
            if (reaction != null) {
                jsonObject4.add(ContextActionHandler.MethodCall.REACTION, jsonSerializationContext.serialize(reaction));
            }
            jsonObject3.add("value", jsonObject4);
            return jsonObject3;
        } else if (contextActionHandler instanceof ContextActionHandler.Unknown) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
