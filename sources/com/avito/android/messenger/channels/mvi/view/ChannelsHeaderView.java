package com.avito.android.messenger.channels.mvi.view;

import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsHeaderView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsHeaderView extends Renderer<ChannelsHeaderPresenter.State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull ChannelsHeaderView channelsHeaderView, @NotNull ChannelsHeaderPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(channelsHeaderView, state);
        }
    }
}
