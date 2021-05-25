package com.avito.android.messenger.conversation.mvi.message_menu;

import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuPresenter$State;", "Lio/reactivex/Observable;", "", "getActionConfirmedStream", "()Lio/reactivex/Observable;", "actionConfirmedStream", "", "getActionClickStream", "actionClickStream", "getDismissStream", "dismissStream", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageMenuView extends Renderer<MessageMenuPresenter.State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull MessageMenuView messageMenuView, @NotNull MessageMenuPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(messageMenuView, state);
        }
    }

    @NotNull
    Observable<String> getActionClickStream();

    @NotNull
    Observable<Unit> getActionConfirmedStream();

    @NotNull
    Observable<Unit> getDismissStream();
}
