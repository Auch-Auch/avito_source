package com.avito.android.messenger.service;

import a2.a.a.o1.g.c;
import a2.a.a.o1.g.d;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.UnreadMessagesCounterConsumer;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "logTag", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "client", "Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;", "unreadMessagesCounterConsumer", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/preferences/MessengerStorage;", "messengerStorage", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "updateUnreadMessageModel", "(Ljava/lang/String;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/UnreadMessagesCounterConsumer;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/preferences/MessengerStorage;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class UpdateUnreadMessagesCountWorkerKt {
    public static final void updateUnreadMessageModel(@NotNull String str, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull UnreadMessagesCounterConsumer unreadMessagesCounterConsumer, @NotNull AccountStateProvider accountStateProvider, @NotNull MessengerStorage messengerStorage, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(unreadMessagesCounterConsumer, "unreadMessagesCounterConsumer");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerStorage, "messengerStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Single doOnSuccess = InteropKt.toV2(accountStateProvider.currentAuthorized()).flatMap(new c(messengerClient, str)).doOnSuccess(new d(messengerStorage));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "accountStateProvider.cur…counters.channelsCount) }");
        UnreadMessagesCounter unreadMessagesCounter = (UnreadMessagesCounter) doOnSuccess.subscribeOn(schedulersFactory.computation()).timeout(10, TimeUnit.SECONDS, schedulersFactory.computation()).blockingGet();
        Intrinsics.checkNotNullExpressionValue(unreadMessagesCounter, "counter");
        unreadMessagesCounterConsumer.accept(unreadMessagesCounter);
    }
}
