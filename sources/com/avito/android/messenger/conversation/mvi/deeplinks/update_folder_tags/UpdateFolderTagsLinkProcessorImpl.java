package com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.UpdateFolderTagsLink;
import com.avito.android.messenger.analytics.MessengerMoveToFolderEvent;
import com.avito.android.util.Formatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B5\b\u0007\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/update_folder_tags/UpdateFolderTagsLinkProcessor;", "Lcom/avito/android/deep_linking/links/UpdateFolderTagsLink;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/UpdateFolderTagsLink;)Z", "", "onCleared", "()V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorMessageStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorMessageStream", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lio/reactivex/Scheduler;", g.a, "Lkotlin/Lazy;", "getScheduler", "()Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/analytics/Analytics;", "k", "Lcom/avito/android/analytics/Analytics;", "analytics", "d", "getTagsUpdatedStream", "tagsUpdatedStream", "Lcom/avito/android/util/Formatter;", "", "j", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "h", "Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Formatter;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateFolderTagsLinkProcessorImpl extends UpdateFolderTagsLinkProcessor {
    @NotNull
    public final SingleLiveEvent<Unit> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> e = new SingleLiveEvent<>();
    public final CompositeDisposable f = new CompositeDisposable();
    public final Lazy g = t6.c.lazy(new e(this));
    public final MessengerClient<AvitoMessengerApi> h;
    public final SchedulersFactory i;
    public final Formatter<Throwable> j;
    public final Analytics k;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Unit>> {
        public final /* synthetic */ UpdateFolderTagsLink a;

        public a(UpdateFolderTagsLink updateFolderTagsLink) {
            this.a = updateFolderTagsLink;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return avitoMessengerApi2.updateFolderTags(t6.n.d.listOf(this.a.getChannelId()), this.a.getAddTags(), this.a.getRemoveTags());
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ UpdateFolderTagsLinkProcessorImpl a;
        public final /* synthetic */ UpdateFolderTagsLink b;

        public b(UpdateFolderTagsLinkProcessorImpl updateFolderTagsLinkProcessorImpl, UpdateFolderTagsLink updateFolderTagsLink) {
            this.a = updateFolderTagsLinkProcessorImpl;
            this.b = updateFolderTagsLink;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.k.track(new MessengerMoveToFolderEvent(this.b.getChannelId(), this.b.getFolderId(), CollectionsKt___CollectionsKt.joinToString$default(this.b.getAddTags(), ",", null, null, 0, null, null, 62, null), MessengerMoveToFolderEvent.MovedFrom.CHAT));
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ UpdateFolderTagsLinkProcessorImpl a;

        public c(UpdateFolderTagsLinkProcessorImpl updateFolderTagsLinkProcessorImpl) {
            this.a = updateFolderTagsLinkProcessorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getTagsUpdatedStream().postValue(Unit.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ UpdateFolderTagsLinkProcessorImpl a;

        public d(UpdateFolderTagsLinkProcessorImpl updateFolderTagsLinkProcessorImpl) {
            this.a = updateFolderTagsLinkProcessorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error("UpdateFolderTagsLinkProcessor", "api.updateFolderTags() error", th2);
            this.a.getErrorMessageStream().postValue(this.a.j.format(th2));
        }
    }

    public static final class e extends Lambda implements Function0<Scheduler> {
        public final /* synthetic */ UpdateFolderTagsLinkProcessorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(UpdateFolderTagsLinkProcessorImpl updateFolderTagsLinkProcessorImpl) {
            super(0);
            this.a = updateFolderTagsLinkProcessorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Scheduler invoke() {
            Scheduler io2 = this.a.i.io();
            CompositeDisposable compositeDisposable = this.a.f;
            SharedScheduler sharedScheduler = new SharedScheduler(io2);
            compositeDisposable.add(Disposables.fromAction(new UpdateFolderTagsLinkProcessorImpl$scheduler$2$inlined$sam$i$io_reactivex_functions_Action$0(new UpdateFolderTagsLinkProcessorImpl$scheduler$2$$special$$inlined$toShared$1(sharedScheduler))));
            return sharedScheduler;
        }
    }

    @Inject
    public UpdateFolderTagsLinkProcessorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull SchedulersFactory schedulersFactory, @NotNull Formatter<Throwable> formatter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.h = messengerClient;
        this.i = schedulersFactory;
        this.j = formatter;
        this.k = analytics;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
        super.onCleared();
    }

    public boolean doProcess(@NotNull UpdateFolderTagsLink updateFolderTagsLink) {
        Intrinsics.checkNotNullParameter(updateFolderTagsLink, "deeplink");
        Disposable subscribe = this.h.withMessengerApi().observeOn((Scheduler) this.g.getValue()).flatMap(new a(updateFolderTagsLink)).doOnSuccess(new b(this, updateFolderTagsLink)).subscribeOn((Scheduler) this.g.getValue()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "client.withMessengerApi(…          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessor
    @NotNull
    public SingleLiveEvent<String> getErrorMessageStream() {
        return this.e;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessor
    @NotNull
    public SingleLiveEvent<Unit> getTagsUpdatedStream() {
        return this.d;
    }
}
