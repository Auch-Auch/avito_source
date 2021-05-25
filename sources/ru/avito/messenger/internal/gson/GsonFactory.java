package ru.avito.messenger.internal.gson;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.BodyImagesResponse;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.ChatMessageUpdate;
import ru.avito.messenger.api.entity.Image;
import ru.avito.messenger.api.entity.ReadOnlyState;
import ru.avito.messenger.api.entity.body.MessageBody;
import ru.avito.messenger.api.entity.body.item.BodyItem;
import ru.avito.messenger.api.entity.body.notification.NotificationBody;
import ru.avito.messenger.api.entity.context.ChannelContext;
import ru.avito.messenger.internal.entity.messenger.SystemMessage;
import ru.avito.messenger.internal.gson.adapter.BodyImagesResponseTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.BodyItemTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.ChannelContextTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.ImageTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.MessageBodyTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.MessageTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.MessageUpdateTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.NotificationBodyTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.ReadOnlyStateTypeAdapter;
import ru.avito.messenger.internal.gson.adapter.SystemMessageTypeAdapter;
import ru.avito.messenger.internal.log.Logger;
import t6.n.q;
import t6.n.r;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0001\u0010\f\u001a\u00020\u000b2\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00022\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00022\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00022\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00022\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\t¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\u0002*\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0013\u001a\u00020\u0011*\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/avito/messenger/internal/gson/GsonFactory;", "", "", "Lru/avito/messenger/internal/gson/TypeId;", "Lru/avito/messenger/internal/gson/TypeInfo;", "bodyTypes", "contextTypes", "bodyItemTypes", "notificationBodyTypes", "", "customTypes", "Lcom/google/gson/Gson;", "create", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)Lcom/google/gson/Gson;", "Ljava/lang/reflect/Type;", "c", "(Ljava/util/Map;)Ljava/util/Map;", "Lcom/google/gson/GsonBuilder;", "map", AuthSource.BOOKING_ORDER, "(Lcom/google/gson/GsonBuilder;Ljava/util/Map;)Lcom/google/gson/GsonBuilder;", "", "typeInfos", AuthSource.SEND_ABUSE, "(Lcom/google/gson/GsonBuilder;Ljava/util/Collection;)Lcom/google/gson/GsonBuilder;", "Lru/avito/messenger/internal/log/Logger;", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Lru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GsonFactory {
    public final Logger a;

    public GsonFactory() {
        this(null, 1, null);
    }

    public GsonFactory(@Nullable Logger logger) {
        this.a = logger;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.avito.messenger.internal.gson.GsonFactory */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Gson create$default(GsonFactory gsonFactory, Map map, Map map2, Map map3, Map map4, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            map = r.emptyMap();
        }
        if ((i & 2) != 0) {
            map2 = r.emptyMap();
        }
        if ((i & 4) != 0) {
            map3 = r.emptyMap();
        }
        if ((i & 8) != 0) {
            map4 = r.emptyMap();
        }
        if ((i & 16) != 0) {
            set = y.emptySet();
        }
        return gsonFactory.create(map, map2, map3, map4, set);
    }

    public final GsonBuilder a(GsonBuilder gsonBuilder, Collection<? extends TypeInfo<?>> collection) {
        for (T t : collection) {
            if (t.getAdapter() != null) {
                gsonBuilder.registerTypeAdapter(t.getType(), t.getAdapter());
            }
        }
        return gsonBuilder;
    }

    public final GsonBuilder b(GsonBuilder gsonBuilder, Map<TypeId, ? extends TypeInfo<?>> map) {
        a(gsonBuilder, map.values());
        return gsonBuilder;
    }

    public final Map<TypeId, Type> c(Map<TypeId, ? extends TypeInfo<?>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(map.size()));
        for (T t : map.entrySet()) {
            linkedHashMap.put(t.getKey(), ((TypeInfo) t.getValue()).getType());
        }
        return linkedHashMap;
    }

    @NotNull
    public final Gson create(@NotNull Map<TypeId, ? extends TypeInfo<?>> map, @NotNull Map<TypeId, ? extends TypeInfo<?>> map2, @NotNull Map<TypeId, ? extends TypeInfo<?>> map3, @NotNull Map<TypeId, ? extends TypeInfo<?>> map4, @NotNull Set<? extends TypeInfo<?>> set) {
        Intrinsics.checkNotNullParameter(map, "bodyTypes");
        Intrinsics.checkNotNullParameter(map2, "contextTypes");
        Intrinsics.checkNotNullParameter(map3, "bodyItemTypes");
        Intrinsics.checkNotNullParameter(map4, "notificationBodyTypes");
        Intrinsics.checkNotNullParameter(set, "customTypes");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ChatMessage.class, new MessageTypeAdapter());
        gsonBuilder.registerTypeAdapter(ChatMessageUpdate.class, new MessageUpdateTypeAdapter());
        gsonBuilder.registerTypeAdapter(MessageBody.class, new MessageBodyTypeAdapter(c(map), this.a));
        gsonBuilder.registerTypeAdapter(ChannelContext.class, new ChannelContextTypeAdapter(c(map2), this.a));
        gsonBuilder.registerTypeAdapter(ReadOnlyState.class, new ReadOnlyStateTypeAdapter());
        gsonBuilder.registerTypeAdapter(BodyItem.class, new BodyItemTypeAdapter(c(map3), this.a));
        gsonBuilder.registerTypeAdapter(Image.class, new ImageTypeAdapter());
        gsonBuilder.registerTypeAdapter(NotificationBody.class, new NotificationBodyTypeAdapter(c(map4), this.a));
        gsonBuilder.registerTypeAdapter(SystemMessage.class, new SystemMessageTypeAdapter());
        gsonBuilder.registerTypeAdapter(BodyImagesResponse.class, new BodyImagesResponseTypeAdapter());
        b(gsonBuilder, map);
        b(gsonBuilder, map2);
        b(gsonBuilder, map3);
        a(gsonBuilder, set);
        b(gsonBuilder, map4);
        Gson create = gsonBuilder.create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n          …es)\n            .create()");
        return create;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GsonFactory(Logger logger, int i, j jVar) {
        this((i & 1) != 0 ? null : logger);
    }
}
