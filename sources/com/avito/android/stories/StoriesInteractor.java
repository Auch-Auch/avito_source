package com.avito.android.stories;

import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Story;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\fH&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/stories/StoriesInteractor;", "", "Lcom/avito/android/remote/model/Location;", "location", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/stories/StoriesItem;", "loadStories", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/Story;", "stories", "", "updateStoriesViewedStatus", "(Ljava/util/List;)V", "", "id", "markStoryViewed", "(I)V", "", "isStoryViewed", "(I)Z", "resetLastUpdatedTimestamp", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface StoriesInteractor {
    boolean isStoryViewed(int i);

    @NotNull
    Observable<LoadingState<StoriesItem>> loadStories(@NotNull Location location);

    void markStoryViewed(int i);

    void resetLastUpdatedTimestamp();

    void updateStoriesViewedStatus(@NotNull List<Story> list);
}
