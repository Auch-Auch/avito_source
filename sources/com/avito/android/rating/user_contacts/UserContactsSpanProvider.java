package com.avito.android.rating.user_contacts;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "", "", VKApiConst.POSITION, "columnCount", "getSpan", "(II)I", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserContactsSpanProvider {
    int getSpan(int i, int i2);

    void onDataSourceChanged(@NotNull DataSource<RatingDetailsItem> dataSource);
}
