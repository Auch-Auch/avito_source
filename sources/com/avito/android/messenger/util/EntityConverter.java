package com.avito.android.messenger.util;

import android.net.Uri;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.SimpleAction;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.ChatAvatar;
import com.avito.android.remote.model.messenger.PublicProfile;
import com.avito.android.util.Collections;
import com.avito.android.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.Avatar;
import ru.avito.messenger.api.entity.ChannelUser;
import ru.avito.messenger.api.entity.Image;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\r*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u0010H\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/util/EntityConverter;", "", "Lru/avito/messenger/api/entity/ChannelUser;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/remote/model/User;", "toRemoteUser", "(Lru/avito/messenger/api/entity/ChannelUser;Lcom/avito/android/deep_linking/DeepLinkFactory;)Lcom/avito/android/remote/model/User;", "Lru/avito/messenger/api/entity/Image;", "Lcom/avito/android/remote/model/Image;", "toRemoteImage", "(Lru/avito/messenger/api/entity/Image;)Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/SimpleAction;", "Lcom/avito/android/remote/model/Action;", "toAction", "(Lcom/avito/android/remote/model/SimpleAction;Lcom/avito/android/deep_linking/DeepLinkFactory;)Lcom/avito/android/remote/model/Action;", "Lru/avito/messenger/api/entity/Avatar;", "Lcom/avito/android/remote/model/messenger/ChatAvatar;", "toRemoteChatAvatar", "(Lru/avito/messenger/api/entity/Avatar;)Lcom/avito/android/remote/model/messenger/ChatAvatar;", "Lru/avito/messenger/api/entity/PublicProfile;", "Lcom/avito/android/remote/model/messenger/PublicProfile;", "toRemotePublicProfile", "(Lru/avito/messenger/api/entity/PublicProfile;Lcom/avito/android/deep_linking/DeepLinkFactory;)Lcom/avito/android/remote/model/messenger/PublicProfile;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface EntityConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static Action access$toAction(EntityConverter entityConverter, SimpleAction simpleAction, DeepLinkFactory deepLinkFactory) {
            return new Action(simpleAction.getTitle(), deepLinkFactory.createFromUri(simpleAction.getUri()), null, null, simpleAction.getUri().toString(), null, 44, null);
        }

        public static ChatAvatar access$toRemoteChatAvatar(EntityConverter entityConverter, Avatar avatar) {
            String str = avatar.getDefault();
            Image image = avatar.getImage();
            return new ChatAvatar(str, image != null ? entityConverter.toRemoteImage(image) : null);
        }

        @Nullable
        public static com.avito.android.remote.model.Image toRemoteImage(@NotNull EntityConverter entityConverter, @NotNull Image image) {
            Intrinsics.checkNotNullParameter(image, "$this$toRemoteImage");
            Map<String, Uri> variants = image.getVariants();
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(variants.size()));
            for (T t : variants.entrySet()) {
                linkedHashMap.put(StringUtils.parseSize((String) t.getKey()), t.getValue());
            }
            Map filterKeysNotNull = Collections.filterKeysNotNull(linkedHashMap);
            if (!filterKeysNotNull.isEmpty()) {
                return new com.avito.android.remote.model.Image(filterKeysNotNull);
            }
            return null;
        }

        @NotNull
        public static User toRemoteUser(@NotNull EntityConverter entityConverter, @NotNull ChannelUser channelUser, @NotNull DeepLinkFactory deepLinkFactory) {
            PublicProfile publicProfile;
            ChatAvatar chatAvatar;
            Intrinsics.checkNotNullParameter(channelUser, "$this$toRemoteUser");
            Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
            String id = channelUser.getId();
            String name = channelUser.getName();
            Long lastActionTime = channelUser.getLastActionTime();
            ru.avito.messenger.api.entity.PublicProfile publicProfile2 = channelUser.getPublicProfile();
            Action action = null;
            if (publicProfile2 != null) {
                Avatar avatar = publicProfile2.getAvatar();
                if (avatar != null) {
                    String str = avatar.getDefault();
                    Image image = avatar.getImage();
                    chatAvatar = new ChatAvatar(str, image != null ? entityConverter.toRemoteImage(image) : null);
                } else {
                    chatAvatar = null;
                }
                SimpleAction action2 = publicProfile2.getAction();
                if (action2 != null) {
                    action = new Action(action2.getTitle(), deepLinkFactory.createFromUri(action2.getUri()), null, null, action2.getUri().toString(), null, 44, null);
                }
                publicProfile = new PublicProfile(chatAvatar, action);
            } else {
                publicProfile = null;
            }
            return new User(id, name, lastActionTime, null, publicProfile, 8, null);
        }
    }

    @Nullable
    com.avito.android.remote.model.Image toRemoteImage(@NotNull Image image);

    @NotNull
    User toRemoteUser(@NotNull ChannelUser channelUser, @NotNull DeepLinkFactory deepLinkFactory);
}
