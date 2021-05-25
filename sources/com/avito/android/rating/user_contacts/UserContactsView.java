package com.avito.android.rating.user_contacts;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "dataSource", "", "setItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "show", "showEmptyState", "(Z)V", "", "message", "showMessage", "(Ljava/lang/String;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserContactsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UserContactsView userContactsView) {
            ItemView.DefaultImpls.onUnbind(userContactsView);
        }
    }

    void setItems(@NotNull DataSource<RatingDetailsItem> dataSource);

    void showEmptyState(boolean z);

    void showMessage(@NotNull String str);
}
