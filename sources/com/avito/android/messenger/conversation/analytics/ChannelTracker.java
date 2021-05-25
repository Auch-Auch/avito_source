package com.avito.android.messenger.conversation.analytics;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010\bJ\u000f\u0010\"\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\bR\u0016\u0010&\u001a\u00020%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/analytics/ChannelTracker;", "", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "", "curItemCount", "startReloadSession", "(I)V", "startLoadMoreSession", "stopAllSessions", "startContextLoading", "startMessagesLoading", "trackContextLoad", "trackMessagesLoad", "trackContextLoadError", "trackMessagesLoadError", "startContextPreparing", "startMessagesPreparing", "trackContextPreparing", "trackMessagesPreparing", "trackContextPreparingError", "trackMessagesPreparingError", "startContextDraw", "startMessagesDraw", "trackContextDraw", "trackMessagesDraw", "trackContextDrawError", "trackMessagesDrawError", "destroy", "detach", "attach", "", "isTrackingLoadMore", "()Z", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelTracker {
    void attach();

    void destroy();

    void detach();

    boolean isTrackingLoadMore();

    void startContextDraw();

    void startContextLoading();

    void startContextPreparing();

    void startInit();

    void startLoadMoreSession(int i);

    void startMessagesDraw();

    void startMessagesLoading();

    void startMessagesPreparing();

    void startReloadSession(int i);

    void stopAllSessions();

    void trackContextDraw();

    void trackContextDrawError();

    void trackContextLoad();

    void trackContextLoadError();

    void trackContextPreparing();

    void trackContextPreparingError();

    void trackDiInject(long j);

    void trackInit();

    void trackMessagesDraw();

    void trackMessagesDrawError();

    void trackMessagesLoad();

    void trackMessagesLoadError();

    void trackMessagesPreparing();

    void trackMessagesPreparingError();
}
