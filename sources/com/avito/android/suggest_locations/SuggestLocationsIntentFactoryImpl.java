package com.avito.android.suggest_locations;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010#Jw\u0010\u0014\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsIntentFactoryImpl;", "Lcom/avito/android/SuggestLocationsIntentFactory;", "", "locationId", "categoryId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "query", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "", "showHistoricalSuggest", "geoSessionId", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "autoOpenKeyboard", "useLegacyApi", "Landroid/content/Intent;", "suggestLocationsIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;Lcom/avito/android/bottom_navigation/NavigationTab;ZLjava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZ)Landroid/content/Intent;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;Lcom/avito/android/Features;Lcom/avito/android/CoreActivityIntentFactory;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsIntentFactoryImpl implements SuggestLocationsIntentFactory {
    public final Application a;
    public final Features b;
    public final CoreActivityIntentFactory c;

    @Inject
    public SuggestLocationsIntentFactoryImpl(@NotNull Application application, @NotNull Features features, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = features;
        this.c = coreActivityIntentFactory;
    }

    @Override // com.avito.android.SuggestLocationsIntentFactory
    @NotNull
    public Intent suggestLocationsIntent(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, @Nullable NavigationTab navigationTab, boolean z, @Nullable String str4, @Nullable AddressParameter.ValidationRules validationRules, boolean z2, boolean z3) {
        if (!this.b.getLocationSelectWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return SuggestLocationsActivity.Companion.createLocationSelectIntent(this.a, str, str2, num, str3, locationPickerChooseButtonLocation, z, str4, validationRules, z2, z3);
        }
        return this.c.mainScreenWithTab(new SuggestLocationsFragmentData(new SuggestLocationsArguments(str, str2, num, str3, locationPickerChooseButtonLocation, z, str4, validationRules, z2, z3), navigationTab));
    }
}
