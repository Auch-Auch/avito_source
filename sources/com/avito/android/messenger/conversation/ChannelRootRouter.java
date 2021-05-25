package com.avito.android.messenger.conversation;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0011\u0010\u0010J'\u0010\u0017\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015H&¢\u0006\u0004\b\u0019\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelRootRouter;", "", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnBackPressedListener", "(Lcom/avito/android/ui/fragments/OnBackPressedListener;)V", "openAuthScreen", "()V", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "fromRecommendations", "openAdvertScreen", "(Ljava/lang/String;Z)V", "openMyAdvertScreen", "(Ljava/lang/String;)V", "openAdvertSelectionScreen", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "close", "result", "(I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelRootRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void openGallery$default(ChannelRootRouter channelRootRouter, List list, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                channelRootRouter.openGallery(list, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openGallery");
        }
    }

    void close();

    @Override // com.avito.android.messenger.conversation.create.CreateChannelRouter
    void close(int i);

    void openAdvertScreen(@NotNull String str, boolean z);

    void openAdvertSelectionScreen(@Nullable String str);

    void openAuthScreen();

    void openGallery(@NotNull List<Image> list, int i);

    void openMyAdvertScreen(@NotNull String str);

    void setOnBackPressedListener(@Nullable OnBackPressedListener onBackPressedListener);
}
