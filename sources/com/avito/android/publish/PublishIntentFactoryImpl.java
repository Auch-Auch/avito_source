package com.avito.android.publish;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.location_picker.LocationPickerActivity;
import com.avito.android.location_picker.view.LocationPickerChooseButtonLocation;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.publish.cpa_tariff.CpaTariffActivityKt;
import com.avito.android.publish.new_advert.AddFragmentData;
import com.avito.android.publish.objects.ObjectsEditActivityKt;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivityKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.publish.start_publish.StartPublishActivity;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010G\u001a\u00020D¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J]\u0010\u001f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J9\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J)\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b4\u0010/J?\u0010<\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u0001052\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000108j\n\u0012\u0004\u0012\u000209\u0018\u0001`:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020!H\u0016¢\u0006\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/avito/android/publish/PublishIntentFactoryImpl;", "Lcom/avito/android/PublishIntentFactory;", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Landroid/content/Intent;", "publishAdvertIntent", "(Lcom/avito/android/remote/model/Navigation;)Landroid/content/Intent;", "", "itemId", "action", "focusId", "editingAdvertIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "draftId", "", "trackDraftResume", "publishAdvertFromDraftIntent", "(Ljava/lang/String;Z)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/SearchRadius;", "searchRadius", "categoryId", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "Lcom/avito/android/remote/model/SearchParams;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/PublishIntentFactory$JobAssistantParams;", "jobAssistantParams", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "locationPickerIntent", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;Ljava/lang/String;Lcom/avito/android/remote/model/SearchRadius;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/PublishIntentFactory$JobAssistantParams;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)Landroid/content/Intent;", "", "maxPhotoCount", "minPhotoCount", "selectedPhotoId", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "createPhotoPickerIntentForPublish", "(Ljava/lang/String;IILjava/lang/String;Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "objectsParameter", "selectedObjectIndex", "createObjectsEditIntent", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)Landroid/content/Intent;", "createLimitsHistoryIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "createLimitsHistoryForDraftIntent", "newAdvert", "()Landroid/content/Intent;", "calledFrom", "createPublishOverlayIntent", "", "lat", "lng", "Ljava/util/ArrayList;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "Lkotlin/collections/ArrayList;", ResidentialComplexModuleKt.VALUES, "createResidentialComplexSuggestActivity", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/ArrayList;)Landroid/content/Intent;", "createCpaTariffActivity", "(I)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "d", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "c", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Landroid/app/Application;Lcom/avito/android/CoreActivityIntentFactory;Lcom/avito/android/ab_tests/AbTestsConfigProvider;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishIntentFactoryImpl implements PublishIntentFactory {
    public final Application a;
    public final CoreActivityIntentFactory b;
    public final AbTestsConfigProvider c;
    public final UserAdvertsTabTestGroup d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PublishIntentFactory.LocationPickerChooseButtonLocation.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @Inject
    public PublishIntentFactoryImpl(@NotNull Application application, @NotNull CoreActivityIntentFactory coreActivityIntentFactory, @NotNull AbTestsConfigProvider abTestsConfigProvider, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        this.a = application;
        this.b = coreActivityIntentFactory;
        this.c = abTestsConfigProvider;
        this.d = userAdvertsTabTestGroup;
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createCpaTariffActivity(int i) {
        return CpaTariffActivityKt.createCpaTariffActivityIntent(this.a, i);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createLimitsHistoryForDraftIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        return PublishLimitsHistoryActivityKt.createLimitsHistoryActivityIntent(this.a, new ItemId.Draft(str));
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createLimitsHistoryIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return PublishLimitsHistoryActivityKt.createLimitsHistoryActivityIntent(this.a, new ItemId.Advert(str));
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createObjectsEditIntent(@NotNull Navigation navigation, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(objectsParameter, "objectsParameter");
        return ObjectsEditActivityKt.createObjectsEditIntent(this.a, navigation, objectsParameter, num);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createPhotoPickerIntentForPublish(@NotNull String str, int i, int i2, @Nullable String str2, @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(photoPickerMode, "mode");
        return PhotoPickerActivityKt.createPhotoPickerActivityIntent$default(this.a, str, PhotoUploadKt.UPLOAD_TYPE_PUBLISH, i2, i, str2, false, false, null, photoPickerMode, 448, null);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createPublishOverlayIntent(@Nullable String str) {
        StartPublishActivity.Type type;
        this.c.draftsOnStartPublishSheet().expose();
        if (this.c.draftsOnStartPublishSheet().getTestGroup().isTest()) {
            type = StartPublishActivity.Type.SHEET;
        } else {
            type = StartPublishActivity.Type.FLOATING_BUTTONS;
        }
        return StartPublishActivity.Companion.createStartPublishOverlayActivity(this.a, str, type);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent createResidentialComplexSuggestActivity(@Nullable Double d2, @Nullable Double d3, @Nullable ArrayList<SelectParameter.Value> arrayList) {
        return ResidentialComplexActivityKt.createResidentialComplexActivityIntent(this.a, d2, d3, arrayList);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent editingAdvertIntent(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return PublishActivityKt.createPublishActivityForEditing(this.a, str, str2);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent locationPickerIntent(@Nullable AddressParameter.Value value, @Nullable String str, @Nullable SearchRadius searchRadius, @Nullable String str2, @NotNull PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, @Nullable SearchParams searchParams, @Nullable PublishIntentFactory.JobAssistantParams jobAssistantParams, @Nullable AddressParameter.ValidationRules validationRules) {
        LocationPickerChooseButtonLocation locationPickerChooseButtonLocation2;
        Intrinsics.checkNotNullParameter(locationPickerChooseButtonLocation, "chooseButtonLocation");
        LocationPickerActivity.Companion companion = LocationPickerActivity.Companion;
        Application application = this.a;
        int ordinal = locationPickerChooseButtonLocation.ordinal();
        if (ordinal == 0) {
            locationPickerChooseButtonLocation2 = LocationPickerChooseButtonLocation.APPBAR;
        } else if (ordinal == 1) {
            locationPickerChooseButtonLocation2 = LocationPickerChooseButtonLocation.FOOTER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return companion.createLocationPickerActivityIntent(application, value, str, searchRadius, str2, locationPickerChooseButtonLocation2, searchParams, jobAssistantParams, validationRules);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent newAdvert() {
        if (this.d.isTest()) {
            return createPublishOverlayIntent(null);
        }
        return this.b.mainScreenWithTab(new AddFragmentData(null));
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent publishAdvertFromDraftIntent(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        return PublishActivityKt.createPublishActivityForDraft(this.a, str, z);
    }

    @Override // com.avito.android.PublishIntentFactory
    @NotNull
    public Intent publishAdvertIntent(@NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return PublishActivityKt.createPublishActivity(this.a, navigation);
    }
}
