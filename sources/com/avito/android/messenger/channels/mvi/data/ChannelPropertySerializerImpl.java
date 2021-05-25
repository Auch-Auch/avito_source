package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializerImpl;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "T", "Ljava/lang/Class;", "clazz", "obj", "", "serialize", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;", "jsonBody", "deserialize", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelPropertySerializerImpl implements ChannelPropertySerializer {
    public final Gson a;

    public ChannelPropertySerializerImpl(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer
    public <T> T deserialize(@NotNull Class<T> cls, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, "jsonBody");
        return (T) this.a.fromJson(str, (Class<Object>) cls);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer
    @NotNull
    public <T> String serialize(@NotNull Class<T> cls, T t) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        String json = this.a.toJson(t, cls);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(obj, clazz)");
        return json;
    }
}
