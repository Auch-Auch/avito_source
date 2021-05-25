package ru.avito.messenger.internal.gson.adapter;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.body.CallReference;
import ru.avito.messenger.api.entity.body.ImageReference;
import ru.avito.messenger.api.entity.body.ItemReference;
import ru.avito.messenger.api.entity.body.MessageBody;
import ru.avito.messenger.api.entity.body.MsgSystem;
import ru.avito.messenger.api.entity.body.Text;
import ru.avito.messenger.api.entity.body.Unknown;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.util.JsonObjectsKt;
import ru.avito.messenger.internal.util.KeyRuntimeTypeAdapter;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/gson/adapter/MessageBodyTypeAdapter;", "Lru/avito/messenger/internal/util/KeyRuntimeTypeAdapter;", "Lru/avito/messenger/api/entity/body/MessageBody;", "", "Lru/avito/messenger/internal/gson/TypeId;", "Ljava/lang/reflect/Type;", "f", "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "customTypes", "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(Ljava/util/Map;Lru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageBodyTypeAdapter extends KeyRuntimeTypeAdapter<MessageBody> {
    @NotNull
    public final Map<TypeId, Type> f;

    public static final class a extends Lambda implements Function2<TypeId, JsonObject, MessageBody> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public MessageBody invoke(TypeId typeId, JsonObject jsonObject) {
            TypeId typeId2 = typeId;
            JsonObject jsonObject2 = jsonObject;
            Intrinsics.checkNotNullParameter(typeId2, "typeId");
            Intrinsics.checkNotNullParameter(jsonObject2, SDKConstants.PARAM_A2U_BODY);
            return new Unknown(typeId2.getType(), JsonObjectsKt.getNullableString(jsonObject2, com.avito.android.remote.model.messenger.message.MessageBody.RANDOM_ID));
        }
    }

    public MessageBodyTypeAdapter() {
        this(null, null, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageBodyTypeAdapter(Map map, Logger logger, int i, j jVar) {
        this((i & 1) != 0 ? r.emptyMap() : map, (i & 2) != 0 ? null : logger);
    }

    @Override // ru.avito.messenger.internal.util.RuntimeTypeAdapter
    @NotNull
    public Map<TypeId, Type> getMapping() {
        return this.f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageBodyTypeAdapter(@NotNull Map<TypeId, ? extends Type> map, @Nullable Logger logger) {
        super(null, SDKConstants.PARAM_A2U_BODY, a.a, logger, 1, null);
        Intrinsics.checkNotNullParameter(map, "customTypes");
        this.f = r.plus(r.mapOf(a2.b.a.a.a.r0("text", null, 2, null, Text.class), a2.b.a.a.a.r0("item", null, 2, null, ItemReference.class), a2.b.a.a.a.r0(ChannelContext.System.TYPE, null, 2, null, MsgSystem.class), a2.b.a.a.a.r0("image", null, 2, null, ImageReference.class), a2.b.a.a.a.r0("call", null, 2, null, CallReference.class)), map);
    }
}
