package com.avito.android;

import android.content.Intent;
import com.avito.android.PublishIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0001\u0010\u0014\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/SuggestLocationsIntentFactory;", "", "", "locationId", "categoryId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "query", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "", "showHistoricalSuggest", "geoSessionId", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "autoOpenKeyboard", "useLegacyApi", "Landroid/content/Intent;", "suggestLocationsIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;Lcom/avito/android/bottom_navigation/NavigationTab;ZLjava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZ)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent suggestLocationsIntent$default(SuggestLocationsIntentFactory suggestLocationsIntentFactory, String str, String str2, Integer num, String str3, PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, NavigationTab navigationTab, boolean z, String str4, AddressParameter.ValidationRules validationRules, boolean z2, boolean z3, int i, Object obj) {
            if (obj == null) {
                return suggestLocationsIntentFactory.suggestLocationsIntent(str, str2, num, str3, locationPickerChooseButtonLocation, navigationTab, (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : validationRules, (i & 512) != 0 ? false : z2, (i & 1024) != 0 ? false : z3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: suggestLocationsIntent");
        }
    }

    @NotNull
    Intent suggestLocationsIntent(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, @Nullable NavigationTab navigationTab, boolean z, @Nullable String str4, @Nullable AddressParameter.ValidationRules validationRules, boolean z2, boolean z3);
}
