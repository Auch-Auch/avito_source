package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ChannelContextTypeAdapter;", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapter;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "", "", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getMapping", "()Ljava/util/Map;", "mapping", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelContextTypeAdapter extends RuntimeTypeAdapter<ChannelContext> {
    @NotNull
    public final Map<String, Type> a = r.mapOf(TuplesKt.to("item", ChannelContext.Item.class), TuplesKt.to("user", ChannelContext.UserToUser.class), TuplesKt.to(ChannelContext.System.TYPE, ChannelContext.System.class));

    public ChannelContextTypeAdapter() {
        super(null, null, ChannelContext.Unknown.class, 3, null);
    }

    @Override // com.avito.android.remote.parse.adapter.RuntimeTypeAdapter
    @NotNull
    public Map<String, Type> getMapping() {
        return this.a;
    }
}
