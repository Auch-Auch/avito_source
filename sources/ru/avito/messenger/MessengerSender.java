package ru.avito.messenger;

import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.ChatMessage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J=\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\rJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\rJ%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\rJ/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0018\u0010\rJI\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lru/avito/messenger/MessengerSender;", "", "", "channelId", "localId", "text", "", "templates", "Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/ChatMessage;", "sendTextMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "sendReactionMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "itemId", "sendItemMessage", "imageId", "sendImageMessage", "targetUserId", "sendCallMessage", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "url", "sendLinkMessage", MessageBody.File.FILE_ID, "sendFileMessage", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "title", MessageBody.Location.KIND, "sendLocationMessage", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerSender {
    @NotNull
    Single<ChatMessage> sendCallMessage(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<ChatMessage> sendFileMessage(@NotNull String str, @NotNull String str2, @Nullable String str3);

    @NotNull
    Single<ChatMessage> sendImageMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<ChatMessage> sendItemMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<ChatMessage> sendLinkMessage(@NotNull String str, @Nullable String str2, @NotNull String str3);

    @NotNull
    Single<ChatMessage> sendLocationMessage(@NotNull String str, @Nullable String str2, double d, double d2, @NotNull String str3, @Nullable String str4);

    @NotNull
    Single<ChatMessage> sendReactionMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<ChatMessage> sendTextMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<String> list);
}
