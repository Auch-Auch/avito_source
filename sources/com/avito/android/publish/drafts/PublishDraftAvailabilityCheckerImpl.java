package com.avito.android.publish.drafts;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PublishDraftResponse;
import dagger.Lazy;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftAvailabilityCheckerImpl;", "Lcom/avito/android/publish/drafts/PublishDraftAvailabilityChecker;", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "getOrDeleteIfNeeded", "()Lio/reactivex/Single;", "Ldagger/Lazy;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "publishDraftRepositoryLazy", "<init>", "(Ldagger/Lazy;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftAvailabilityCheckerImpl implements PublishDraftAvailabilityChecker {
    public final Lazy<PublishDraftRepository> a;

    public PublishDraftAvailabilityCheckerImpl(@NotNull Lazy<PublishDraftRepository> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "publishDraftRepositoryLazy");
        this.a = lazy;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftAvailabilityChecker
    @NotNull
    public Single<PublishDraftResponse> getOrDeleteIfNeeded() {
        return this.a.get().getLatestDraftData();
    }
}
