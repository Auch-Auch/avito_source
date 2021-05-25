package com.avito.android.publish.drafts;

import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftWiper;", "", "Lio/reactivex/Completable;", "deleteDraftWithPhotos", "()Lio/reactivex/Completable;", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDraftWiper {
    @NotNull
    Completable deleteDraftWithPhotos();
}
