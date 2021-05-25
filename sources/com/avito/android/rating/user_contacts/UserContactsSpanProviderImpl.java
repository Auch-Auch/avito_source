package com.avito.android.rating.user_contacts;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsSpanProviderImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsSpanProvider;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", VKApiConst.POSITION, "columnCount", "getSpan", "(II)I", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactsSpanProviderImpl implements UserContactsSpanProvider {
    public DataSource<RatingDetailsItem> a;

    @Override // com.avito.android.rating.user_contacts.UserContactsSpanProvider
    public int getSpan(int i, int i2) {
        DataSource<RatingDetailsItem> dataSource = this.a;
        RatingDetailsItem ratingDetailsItem = null;
        if (dataSource != null && i >= 0 && i < dataSource.getCount()) {
            ratingDetailsItem = dataSource.getItem(i);
        }
        if (ratingDetailsItem instanceof ContactItem) {
            return 1;
        }
        return i2;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsSpanProvider
    public void onDataSourceChanged(@NotNull DataSource<RatingDetailsItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }
}
