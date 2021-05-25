package com.avito.android.messenger.channels.mvi.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "", "T", "Ljava/lang/Class;", "clazz", "obj", "", "serialize", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;", "jsonBody", "deserialize", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelPropertySerializer {
    <T> T deserialize(@NotNull Class<T> cls, @NotNull String str);

    @NotNull
    <T> String serialize(@NotNull Class<T> cls, T t);
}
