package com.avito.android.messenger.channels.mvi.interactor;

import a2.a.a.o1.b.b.b.k;
import a2.a.a.o1.b.b.b.l;
import a2.a.a.o1.b.b.b.m;
import a2.a.a.o1.b.b.b.n;
import a2.a.a.o1.b.b.b.o;
import a2.a.a.o1.b.b.b.p;
import a2.a.a.o1.b.b.b.q;
import a2.a.a.o1.b.b.b.r;
import a2.a.a.o1.b.b.b.t;
import a2.a.a.o1.b.b.b.u;
import androidx.lifecycle.ViewModel;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.messenger.folders.Folder;
import com.avito.android.messenger.folders.Folders;
import com.avito.android.messenger.folders.FoldersUnreadCounters;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.event.BlacklistInfo;
import ru.avito.messenger.api.entity.event.BlacklistRemoveEvent;
import ru.avito.messenger.api.entity.event.ChannelsUpdatedEvent;
import ru.avito.messenger.api.entity.event.ChatClearEvent;
import ru.avito.messenger.api.entity.event.ReadChatEvent;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B-\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractorImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractor;", "Landroidx/lifecycle/ViewModel;", "", "refreshCounters", "()V", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "allSubscriptions", "Lcom/jakewharton/rxrelay2/Relay;", "c", "Lcom/jakewharton/rxrelay2/Relay;", "refreshCountersTriggers", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "f", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/messenger/folders/FoldersUnreadCounters;", "e", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getFoldersCounterStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "foldersCounterStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lru/avito/messenger/MessengerClient;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FoldersInteractorImpl extends ViewModel implements FoldersInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Relay<Unit> c;
    public final CompositeDisposable d;
    @NotNull
    public final PublishRelay<FoldersUnreadCounters> e;
    public final MessengerClient<AvitoMessengerApi> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/FoldersInteractorImpl$Companion;", "", "", "REFRESH_THROTTLE_TIMEOUT_MS", "J", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public FoldersInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup, @NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "messengerFolderTabsTestGroup");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.f = messengerClient;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.d = compositeDisposable;
        PublishRelay<FoldersUnreadCounters> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.e = create2;
        if (manuallyExposedAbTestGroup.getTestGroup().isTest()) {
            Scheduler io2 = schedulersFactory.io();
            Disposable subscribe = messengerClient.allReconnects().subscribeOn(io2).observeOn(io2).subscribe(new r(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "client.allReconnects()\n …          }\n            }");
            DisposableKt.addTo(subscribe, compositeDisposable);
            Disposable subscribe2 = messengerClient.observeChatEvents(ChatMessage.class).map(k.a).mergeWith(messengerClient.observeChatEvents(ReadChatEvent.class).map(l.a)).mergeWith(messengerClient.observeChatEvents(ChannelsUpdatedEvent.class).map(m.a)).mergeWith(messengerClient.observeChatEvents(BlacklistRemoveEvent.class).map(n.a)).mergeWith(messengerClient.observeChatEvents(BlacklistInfo.class).map(o.a)).mergeWith(messengerClient.observeChatEvents(ChatClearEvent.class).map(p.a)).subscribeOn(io2).subscribe(new q(this));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "client.observeChatEvents…ers += Unit\n            }");
            DisposableKt.addTo(subscribe2, compositeDisposable);
            List<Folder> all = Folders.INSTANCE.getAll();
            LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(t6.n.q.mapCapacity(t6.n.e.collectionSizeOrDefault(all, 10)), 16));
            for (T t : all) {
                linkedHashMap.put(t.getId(), t.getMergedTags().getFirst());
            }
            Disposable subscribe3 = this.c.subscribeOn(io2).observeOn(io2).throttleFirst(500, TimeUnit.MILLISECONDS).switchMapSingle(new t(this, linkedHashMap)).subscribe(new u(this));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "refreshCountersTriggers\n…thCounters)\n            }");
            DisposableKt.addTo(subscribe3, this.d);
            getFoldersCounterStream().accept(FoldersUnreadCounters.Companion.from(Folders.INSTANCE.getAll(), t6.n.r.emptyMap()));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.clear();
        super.onCleared();
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor
    public void refreshCounters() {
        this.c.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.FoldersInteractor
    @NotNull
    public PublishRelay<FoldersUnreadCounters> getFoldersCounterStream() {
        return this.e;
    }
}
