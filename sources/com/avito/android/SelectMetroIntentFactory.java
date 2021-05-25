package com.avito.android;

import android.content.Intent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JS\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/SelectMetroIntentFactory;", "", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "metroWithLines", "", "requestId", "", "locationId", "categoryId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValues", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Landroid/content/Intent;", "selectMetroIntent", "(Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/List;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SelectMetroIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent selectMetroIntent$default(SelectMetroIntentFactory selectMetroIntentFactory, MetroResponseBody metroResponseBody, String str, int i, Integer num, List list, NavigationTab navigationTab, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 32) != 0) {
                    navigationTab = null;
                }
                return selectMetroIntentFactory.selectMetroIntent(metroResponseBody, str, i, num, list, navigationTab);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectMetroIntent");
        }
    }

    @NotNull
    Intent selectMetroIntent(@Nullable MetroResponseBody metroResponseBody, @NotNull String str, int i, @Nullable Integer num, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable NavigationTab navigationTab);
}
