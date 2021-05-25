package ru.avito.messenger.internal.di;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.gson.GsonDeserializer;
import ru.avito.messenger.internal.gson.GsonFactory;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.gson.TypeInfo;
import ru.avito.messenger.internal.log.Logger;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001By\u0012\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b\u0012\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b\u0012\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000f¨\u0006\u001d"}, d2 = {"Lru/avito/messenger/internal/di/GsonModule;", "", "Lru/avito/messenger/internal/log/Logger;", "logger", "Lcom/google/gson/Gson;", "provideGson", "(Lru/avito/messenger/internal/log/Logger;)Lcom/google/gson/Gson;", "gson", "Lru/avito/messenger/internal/gson/GsonDeserializer;", "provideGsonDeserializer", "(Lcom/google/gson/Gson;)Lru/avito/messenger/internal/gson/GsonDeserializer;", "", "Lru/avito/messenger/internal/gson/TypeId;", "Lru/avito/messenger/internal/gson/TypeInfo;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "contextTypes", "", "e", "Ljava/util/Set;", "customTypes", AuthSource.SEND_ABUSE, "bodyTypes", "d", "notificationBodyTypes", "c", "bodyItemTypes", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class GsonModule {
    public final Map<TypeId, TypeInfo<?>> a;
    public final Map<TypeId, TypeInfo<?>> b;
    public final Map<TypeId, TypeInfo<?>> c;
    public final Map<TypeId, TypeInfo<?>> d;
    public final Set<TypeInfo<?>> e;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<ru.avito.messenger.internal.gson.TypeId, ? extends ru.avito.messenger.internal.gson.TypeInfo<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<ru.avito.messenger.internal.gson.TypeId, ? extends ru.avito.messenger.internal.gson.TypeInfo<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<ru.avito.messenger.internal.gson.TypeId, ? extends ru.avito.messenger.internal.gson.TypeInfo<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<ru.avito.messenger.internal.gson.TypeId, ? extends ru.avito.messenger.internal.gson.TypeInfo<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Set<? extends ru.avito.messenger.internal.gson.TypeInfo<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public GsonModule(@NotNull Map<TypeId, ? extends TypeInfo<?>> map, @NotNull Map<TypeId, ? extends TypeInfo<?>> map2, @NotNull Map<TypeId, ? extends TypeInfo<?>> map3, @NotNull Map<TypeId, ? extends TypeInfo<?>> map4, @NotNull Set<? extends TypeInfo<?>> set) {
        Intrinsics.checkNotNullParameter(map, "bodyTypes");
        Intrinsics.checkNotNullParameter(map2, "contextTypes");
        Intrinsics.checkNotNullParameter(map3, "bodyItemTypes");
        Intrinsics.checkNotNullParameter(map4, "notificationBodyTypes");
        Intrinsics.checkNotNullParameter(set, "customTypes");
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.d = map4;
        this.e = set;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final Gson provideGson(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        return new GsonFactory(logger).create(this.a, this.b, this.c, this.d, this.e);
    }

    @Provides
    @PerMessenger
    @NotNull
    public final GsonDeserializer provideGsonDeserializer(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new GsonDeserializer(gson);
    }
}
