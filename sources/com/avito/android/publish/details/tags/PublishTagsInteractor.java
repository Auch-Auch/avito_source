package com.avito.android.publish.details.tags;

import com.avito.android.remote.model.publish.BubbleSuggest;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "", "", "query", "", "categoryId", "Lio/reactivex/Single;", "", "Lcom/avito/android/remote/model/publish/BubbleSuggest;", "loadSuggests", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishTagsInteractor {
    @NotNull
    Single<List<BubbleSuggest>> loadSuggests(@NotNull String str, @Nullable Integer num);
}
