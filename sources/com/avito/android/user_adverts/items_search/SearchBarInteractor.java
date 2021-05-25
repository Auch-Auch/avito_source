package com.avito.android.user_adverts.items_search;

import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_adverts/items_search/SearchBarInteractor;", "", "", "query", "", "loadSuggestions", "(Ljava/lang/String;)V", "search", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface SearchBarInteractor {
    @WorkerThread
    void loadSuggestions(@NotNull String str);

    void search(@NotNull String str);
}
