package com.avito.android.item_map;

import android.content.Context;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ItemMapIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.GeoReference;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J\u0001\u0010\u0018\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/item_map/ItemMapIntentFactoryImpl;", "Lcom/avito/android/ItemMapIntentFactory;", "Lcom/avito/android/remote/model/Coordinates;", "itemCoordinates", "", "hasFindMeButton", "myCoordinates", "hasBottomSheet", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReference", "itemId", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "amenityButtons", "showMeOnMap", "hasCreateRouteButton", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "shouldTrackMapMovements", "fromPage", "Landroid/content/Intent;", "itemMapIntent", "(Lcom/avito/android/remote/model/Coordinates;ZLcom/avito/android/remote/model/Coordinates;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZZLcom/avito/android/bottom_navigation/NavigationTab;ZLjava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Landroid/content/Context;Lcom/avito/android/Features;Lcom/avito/android/CoreActivityIntentFactory;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapIntentFactoryImpl implements ItemMapIntentFactory {
    @NotNull
    public final Context a;
    public final Features b;
    public final CoreActivityIntentFactory c;

    @Inject
    public ItemMapIntentFactoryImpl(@NotNull Context context, @NotNull Features features, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = context;
        this.b = features;
        this.c = coreActivityIntentFactory;
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    @Override // com.avito.android.ItemMapIntentFactory
    @NotNull
    public Intent itemMapIntent(@Nullable Coordinates coordinates, boolean z, @Nullable Coordinates coordinates2, boolean z2, @Nullable String str, @Nullable String str2, @Nullable List<GeoReference> list, @Nullable String str3, @Nullable List<AmenityButton> list2, boolean z3, boolean z4, @Nullable NavigationTab navigationTab, boolean z5, @Nullable String str4) {
        ItemMapArguments itemMapArguments = new ItemMapArguments(coordinates, z, coordinates2, z2, str, str2, list, str3, list2, z3, z4, z5, str4);
        if (!this.b.getItemMapWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return ItemMapActivity.Companion.newInstance(this.a, itemMapArguments);
        }
        return this.c.mainScreenWithTab(new ItemMapFragmentData(itemMapArguments, navigationTab));
    }
}
