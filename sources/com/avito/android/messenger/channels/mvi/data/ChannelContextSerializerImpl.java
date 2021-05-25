package com.avito.android.messenger.channels.mvi.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR*\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R*\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializerImpl;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "context", "", "serialize", "(Lcom/avito/android/remote/model/messenger/context/ChannelContext;)Ljava/lang/String;", "serializeType", "type", "jsonBody", "deserialize", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "classMap", AuthSource.BOOKING_ORDER, "typeMap", "<init>", "(Lcom/google/gson/Gson;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelContextSerializerImpl implements ChannelContextSerializer {
    public final Map<String, Class<? extends ChannelContext>> a = new LinkedHashMap();
    public final Map<Class<? extends ChannelContext>, String> b = new LinkedHashMap();
    public final Gson c;

    public ChannelContextSerializerImpl(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.c = gson;
        if (this.a.containsKey("item") || this.b.containsKey(ChannelContext.Item.class)) {
            throw new IllegalStateException(a.B2(ChannelContext.Item.class, a.R("Type is already registered: type = ", "item", ", clazz = ")));
        }
        this.a.put("item", ChannelContext.Item.class);
        this.b.put(ChannelContext.Item.class, "item");
        if (this.a.containsKey("user") || this.b.containsKey(ChannelContext.UserToUser.class)) {
            throw new IllegalStateException(a.B2(ChannelContext.UserToUser.class, a.R("Type is already registered: type = ", "user", ", clazz = ")));
        }
        this.a.put("user", ChannelContext.UserToUser.class);
        this.b.put(ChannelContext.UserToUser.class, "user");
        if (this.a.containsKey(ChannelContext.System.TYPE) || this.b.containsKey(ChannelContext.System.class)) {
            throw new IllegalStateException(a.B2(ChannelContext.System.class, a.R("Type is already registered: type = ", ChannelContext.System.TYPE, ", clazz = ")));
        }
        this.a.put(ChannelContext.System.TYPE, ChannelContext.System.class);
        this.b.put(ChannelContext.System.class, ChannelContext.System.TYPE);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer
    @NotNull
    public ChannelContext deserialize(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "jsonBody");
        Class<? extends ChannelContext> cls = this.a.get(str);
        if (cls != null) {
            ChannelContext channelContext = null;
            try {
                channelContext = (ChannelContext) this.c.fromJson(str2, (Class<Object>) cls);
            } catch (Exception unused) {
                StringBuilder L = a.L("Couldn't parse context ");
                L.append(cls.getSimpleName());
                L.append(" from json: ");
                L.append(str2);
                Logs.debug$default("ChannelContextSerializer", L.toString(), null, 4, null);
            }
            if (channelContext != null) {
                return channelContext;
            }
        }
        return new ChannelContext.Unknown(str);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer
    @NotNull
    public String serialize(@NotNull ChannelContext channelContext) {
        Intrinsics.checkNotNullParameter(channelContext, "context");
        String json = this.c.toJson(channelContext);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(context)");
        return json;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer
    @NotNull
    public String serializeType(@NotNull ChannelContext channelContext) {
        Intrinsics.checkNotNullParameter(channelContext, "context");
        String str = this.b.get(channelContext.getClass());
        if (str == null) {
            ChannelContext.Unknown unknown = (ChannelContext.Unknown) (!(channelContext instanceof ChannelContext.Unknown) ? null : channelContext);
            str = unknown != null ? unknown.getType() : null;
        }
        if (str != null) {
            return str;
        }
        StringBuilder L = a.L("Unregistered context type, class = ");
        L.append(channelContext.getClass());
        L.append(", ");
        L.append(channelContext);
        throw new IllegalArgumentException(L.toString());
    }
}
