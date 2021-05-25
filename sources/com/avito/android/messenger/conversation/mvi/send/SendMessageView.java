package com.avito.android.messenger.conversation.mvi.send;

import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000e¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/SendMessageView;", "", "", "clearText", "()V", "Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;", "prevState", "curState", "", "userChangedText", "render", "(Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;Lcom/avito/android/messenger/conversation/mvi/send/SendMessagePresenter$State;Z)V", "Lio/reactivex/Observable;", "getAttachImageClicks", "()Lio/reactivex/Observable;", "attachImageClicks", "getAttachmentDialogDismissedStream", "attachmentDialogDismissedStream", "getSendLocationClicks", "sendLocationClicks", "getAttachFileClicks", "attachFileClicks", "", "getSubmitButtonClicks", "submitButtonClicks", "getTouches", "touches", "getAttachItemClicks", "attachItemClicks", "getMessageTextChangesByUser", "messageTextChangesByUser", "getAttachButtonClicks", "attachButtonClicks", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SendMessageView {
    void clearText();

    @NotNull
    Observable<Unit> getAttachButtonClicks();

    @NotNull
    Observable<Unit> getAttachFileClicks();

    @NotNull
    Observable<Unit> getAttachImageClicks();

    @NotNull
    Observable<Unit> getAttachItemClicks();

    @NotNull
    Observable<Unit> getAttachmentDialogDismissedStream();

    @NotNull
    Observable<String> getMessageTextChangesByUser();

    @NotNull
    Observable<Unit> getSendLocationClicks();

    @NotNull
    Observable<String> getSubmitButtonClicks();

    @NotNull
    Observable<Unit> getTouches();

    void render(@Nullable SendMessagePresenter.State state, @NotNull SendMessagePresenter.State state2, boolean z);
}
