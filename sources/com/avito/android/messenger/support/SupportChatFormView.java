package com.avito.android.messenger.support;

import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.support.SupportChatFormPresenter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "Lio/reactivex/rxjava3/core/Observable;", "", "getSendStream", "()Lio/reactivex/rxjava3/core/Observable;", "sendStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SupportChatFormView extends Renderer<SupportChatFormPresenter.State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull SupportChatFormView supportChatFormView, @NotNull SupportChatFormPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(supportChatFormView, state);
        }
    }

    @NotNull
    Observable<CharSequence> getSendStream();
}
