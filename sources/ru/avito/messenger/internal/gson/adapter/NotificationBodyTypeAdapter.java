package ru.avito.messenger.internal.gson.adapter;

import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.body.notification.NotificationBody;
import ru.avito.messenger.api.entity.body.notification.Unknown;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.util.InlineRuntimeTypeAdapter;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/gson/adapter/NotificationBodyTypeAdapter;", "Lru/avito/messenger/internal/util/InlineRuntimeTypeAdapter;", "Lru/avito/messenger/api/entity/body/notification/NotificationBody;", "", "Lru/avito/messenger/internal/gson/TypeId;", "Ljava/lang/reflect/Type;", "e", "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "customTypes", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Ljava/util/Map;Lru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationBodyTypeAdapter extends InlineRuntimeTypeAdapter<NotificationBody> {
    @NotNull
    public final Map<TypeId, Type> e;

    public static final class a extends Lambda implements Function2<TypeId, JsonObject, NotificationBody> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public NotificationBody invoke(TypeId typeId, JsonObject jsonObject) {
            TypeId typeId2 = typeId;
            Intrinsics.checkNotNullParameter(typeId2, "typeId");
            Intrinsics.checkNotNullParameter(jsonObject, "<anonymous parameter 1>");
            return new Unknown(typeId2.getType());
        }
    }

    public NotificationBodyTypeAdapter() {
        this(null, null, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationBodyTypeAdapter(Map map, Logger logger, int i, j jVar) {
        this((i & 1) != 0 ? r.emptyMap() : map, (i & 2) != 0 ? null : logger);
    }

    @Override // ru.avito.messenger.internal.util.RuntimeTypeAdapter
    @NotNull
    public Map<TypeId, Type> getMapping() {
        return this.e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<ru.avito.messenger.internal.gson.TypeId, ? extends java.lang.reflect.Type> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationBodyTypeAdapter(@NotNull Map<TypeId, ? extends Type> map, @Nullable Logger logger) {
        super(null, a.a, logger, 1, null);
        Intrinsics.checkNotNullParameter(map, "customTypes");
        this.e = map;
    }
}
