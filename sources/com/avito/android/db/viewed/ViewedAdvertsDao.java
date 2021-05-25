package com.avito.android.db.viewed;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH&¢\u0006\u0004\b\f\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "", "", "id", "", "save", "(Ljava/lang/String;)V", "", "count", "removeLessPopularViewedAdverts", "(I)V", "", "isViewed", "(Ljava/lang/String;)Z", "", "ids", "", "(Ljava/util/List;)Ljava/util/Set;", "getCount", "()I", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedAdvertsDao {
    int getCount();

    @NotNull
    Set<String> isViewed(@NotNull List<String> list);

    boolean isViewed(@NotNull String str);

    void removeLessPopularViewedAdverts(int i);

    void save(@NotNull String str);
}
