package com.avito.android.publish.publish_advert_request.data;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PostAdvertResult;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011JO\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertCloudDataSource;", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", "", "", "params", "sessionId", "navigation", "draftId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PostAdvertResult;", "postAdvert", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/PublishApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/PublishApi;", "publishApi", "<init>", "(Lcom/avito/android/remote/PublishApi;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertCloudDataSource implements PublishAdvertDataSource {
    public final PublishApi a;

    @Inject
    public PublishAdvertCloudDataSource(@NotNull PublishApi publishApi) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        this.a = publishApi;
    }

    @Override // com.avito.android.publish.publish_advert_request.data.PublishAdvertDataSource
    @NotNull
    public Observable<PostAdvertResult> postAdvert(@NotNull Map<String, String> map, @NotNull String str, @NotNull Map<String, String> map2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(map2, "navigation");
        return InteropKt.toV2(this.a.postAdvertV15(map2, map, str, str2));
    }
}
