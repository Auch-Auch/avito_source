package com.avito.android.publish.drafts;

import com.avito.android.photo_picker.legacy.DraftPhotosWiper;
import com.avito.android.remote.auth.AuthSource;
import dagger.Lazy;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftWiperImpl;", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "Lio/reactivex/Completable;", "deleteDraftWithPhotos", "()Lio/reactivex/Completable;", "Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;", "draftWiper", "Ldagger/Lazy;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "publishDraftRepositoryLazy", "<init>", "(Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;Ldagger/Lazy;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftWiperImpl implements PublishDraftWiper {
    public final DraftPhotosWiper a;
    public final Lazy<PublishDraftRepository> b;

    public static final class a implements Action {
        public final /* synthetic */ PublishDraftWiperImpl a;

        public a(PublishDraftWiperImpl publishDraftWiperImpl) {
            this.a = publishDraftWiperImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.a.wipeAll();
        }
    }

    public PublishDraftWiperImpl(@NotNull DraftPhotosWiper draftPhotosWiper, @NotNull Lazy<PublishDraftRepository> lazy) {
        Intrinsics.checkNotNullParameter(draftPhotosWiper, "draftWiper");
        Intrinsics.checkNotNullParameter(lazy, "publishDraftRepositoryLazy");
        this.a = draftPhotosWiper;
        this.b = lazy;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftWiper
    @NotNull
    public Completable deleteDraftWithPhotos() {
        Completable merge = Completable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Completable[]{Completable.fromAction(new a(this)), this.b.get().deleteDraft()}));
        Intrinsics.checkNotNullExpressionValue(merge, "Completable.merge(\n     …)\n            )\n        )");
        return merge;
    }
}
