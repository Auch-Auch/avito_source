package com.avito.android.publish.start_publish;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.start_publish.StartPublishInteractor;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PublishDraftResponse;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
import ru.avito.component.floating_add_advert.AdvertShortcut;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishInteractorImpl;", "Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/publish/start_publish/StartPublishInteractor$ScreenData;", "loadStartupSheetData", "()Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "getCategoryShortcuts", "Lio/reactivex/rxjava3/core/Completable;", "deleteDraftWithPhotos", "()Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "c", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "d", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "addAdvertInteractor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Ldagger/Lazy;", "Lcom/avito/android/publish/drafts/PublishDraftAvailabilityChecker;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "publishDraftAvailabilityChecker", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Ldagger/Lazy;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lru/avito/component/floating_add_advert/AddAdvertInteractor;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StartPublishInteractorImpl implements StartPublishInteractor {
    public final SchedulersFactory3 a;
    public final Lazy<PublishDraftAvailabilityChecker> b;
    public final PublishDraftWiper c;
    public final AddAdvertInteractor d;

    public static final class a<T> implements Consumer<Throwable> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("PublishDrafts", "Failed to delete draft", th);
        }
    }

    public static final class b<T, R> implements Function<List<? extends AdvertShortcut>, List<? extends StartPublishSheet.SheetData.CategoryShortcutItem>> {
        public final /* synthetic */ StartPublishInteractorImpl a;

        public b(StartPublishInteractorImpl startPublishInteractorImpl) {
            this.a = startPublishInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends StartPublishSheet.SheetData.CategoryShortcutItem> apply(List<? extends AdvertShortcut> list) {
            List<? extends AdvertShortcut> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "advertShortcuts");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(StartPublishInteractorImpl.access$toCategoryShortcutItem(this.a, it.next()));
            }
            return arrayList;
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<List<? extends StartPublishSheet.SheetData.CategoryShortcutItem>, PublishDraftResponse, StartPublishInteractor.ScreenData> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public StartPublishInteractor.ScreenData apply(List<? extends StartPublishSheet.SheetData.CategoryShortcutItem> list, PublishDraftResponse publishDraftResponse) {
            List<? extends StartPublishSheet.SheetData.CategoryShortcutItem> list2 = list;
            PublishDraftResponse publishDraftResponse2 = publishDraftResponse;
            Intrinsics.checkNotNullParameter(list2, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
            Intrinsics.checkNotNullParameter(publishDraftResponse2, "latestDraftData");
            return new StartPublishInteractor.ScreenData(list2, publishDraftResponse2);
        }
    }

    @Inject
    public StartPublishInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull Lazy<PublishDraftAvailabilityChecker> lazy, @NotNull PublishDraftWiper publishDraftWiper, @NotNull AddAdvertInteractor addAdvertInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(lazy, "publishDraftAvailabilityChecker");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(addAdvertInteractor, "addAdvertInteractor");
        this.a = schedulersFactory3;
        this.b = lazy;
        this.c = publishDraftWiper;
        this.d = addAdvertInteractor;
    }

    public static final StartPublishSheet.SheetData.CategoryShortcutItem access$toCategoryShortcutItem(StartPublishInteractorImpl startPublishInteractorImpl, AdvertShortcut advertShortcut) {
        Objects.requireNonNull(startPublishInteractorImpl);
        return new StartPublishSheet.SheetData.CategoryShortcutItem(advertShortcut.getTitle(), advertShortcut.getNavigation(), new AdvertPublicationLink(advertShortcut.getNavigation()));
    }

    @Override // com.avito.android.publish.start_publish.StartPublishInteractor
    @NotNull
    public Completable deleteDraftWithPhotos() {
        Completable observeOn = InteropKt.toV3(this.c.deleteDraftWithPhotos()).doOnError(a.a).subscribeOn(this.a.io()).observeOn(this.a.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "publishDraftWiper\n      …lersFactory.mainThread())");
        return observeOn;
    }

    @Override // com.avito.android.publish.start_publish.StartPublishInteractor
    @NotNull
    public Single<List<StartPublishSheet.SheetData.CategoryShortcutItem>> getCategoryShortcuts() {
        Single<R> observeOn = this.d.getAdvertShortcuts().map(new b(this)).subscribeOn(this.a.io()).observeOn(this.a.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "addAdvertInteractor\n    …lersFactory.mainThread())");
        return observeOn;
    }

    @Override // com.avito.android.publish.start_publish.StartPublishInteractor
    @NotNull
    public Single<StartPublishInteractor.ScreenData> loadStartupSheetData() {
        Single<StartPublishInteractor.ScreenData> observeOn = Single.zip(getCategoryShortcuts(), a2.b.a.a.a.e2(this.a, InteropKt.toV3(this.b.get().getOrDeleteIfNeeded()).onErrorReturn(a2.a.a.e2.e0.e.a), "publishDraftAvailability…n(schedulersFactory.io())"), c.a).subscribeOn(this.a.io()).observeOn(this.a.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "Single.zip(\n            …lersFactory.mainThread())");
        return observeOn;
    }
}
