package ru.avito.messenger.internal.gson.adapter;

import com.avito.android.util.preferences.SessionContract;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.entity.messenger.SystemMessage;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.util.InlineRuntimeTypeAdapter;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR0\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/internal/gson/adapter/SystemMessageTypeAdapter;", "Lru/avito/messenger/internal/util/InlineRuntimeTypeAdapter;", "Lru/avito/messenger/internal/entity/messenger/SystemMessage;", "", "Lru/avito/messenger/internal/gson/TypeId;", "Ljava/lang/Class;", "", "e", "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SystemMessageTypeAdapter extends InlineRuntimeTypeAdapter<SystemMessage> {
    @NotNull
    public final Map<TypeId, Class<? extends Object>> e = r.mapOf(a2.b.a.a.a.r0(SessionContract.SESSION, null, 2, null, SystemMessage.Session.class), a2.b.a.a.a.r0("Message", null, 2, null, SystemMessage.Message.class), a2.b.a.a.a.r0("MessageUpdate", null, 2, null, SystemMessage.MessageUpdate.class), a2.b.a.a.a.r0("ChatRead", null, 2, null, SystemMessage.ChatReadEvent.class), a2.b.a.a.a.r0("ChatClear", null, 2, null, SystemMessage.ChatClear.class), a2.b.a.a.a.r0("MessagesRead", null, 2, null, SystemMessage.MessageReadEvent.class), a2.b.a.a.a.r0("Blacklist", null, 2, null, SystemMessage.Blacklist.class), a2.b.a.a.a.r0("BlacklistRemove", null, 2, null, SystemMessage.BlacklistRemove.class), a2.b.a.a.a.r0("ChatTyping", null, 2, null, SystemMessage.ChatTyping.class), a2.b.a.a.a.r0("ChannelsUpdate", null, 2, null, SystemMessage.ChannelsUpdated.class), a2.b.a.a.a.r0("OptionsUpdate", null, 2, null, SystemMessage.OptionsUpdated.class), a2.b.a.a.a.r0("Batch", null, 2, null, SystemMessage.Batch.class));

    public static final class a extends Lambda implements Function2<TypeId, JsonObject, SystemMessage> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SystemMessage invoke(TypeId typeId, JsonObject jsonObject) {
            TypeId typeId2 = typeId;
            Intrinsics.checkNotNullParameter(typeId2, "typeId");
            Intrinsics.checkNotNullParameter(jsonObject, "<anonymous parameter 1>");
            return new SystemMessage.Unknown(typeId2.getType(), typeId2.getSubtype());
        }
    }

    public SystemMessageTypeAdapter() {
        super(null, a.a, null, 5, null);
    }

    @Override // ru.avito.messenger.internal.util.RuntimeTypeAdapter
    @NotNull
    public Map<TypeId, Class<? extends Object>> getMapping() {
        return this.e;
    }
}
