package com.avito.android.publish.publish_advert_request.data;

import com.avito.android.remote.model.PostAdvertResult;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JO\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertDataSource;", "", "", "", "params", "sessionId", "navigation", "draftId", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PostAdvertResult;", "postAdvert", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/Observable;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishAdvertDataSource {
    @NotNull
    Observable<PostAdvertResult> postAdvert(@NotNull Map<String, String> map, @NotNull String str, @NotNull Map<String, String> map2, @Nullable String str2);
}
