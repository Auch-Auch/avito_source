package com.avito.android.location_picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location_picker.LocationPickerBinder;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor;
import com.avito.android.location_picker.analytics.ScreenCloseFromBlock;
import com.avito.android.location_picker.di.DaggerLocationPickerComponent;
import com.avito.android.location_picker.di.LocationPickerComponent;
import com.avito.android.location_picker.di.LocationPickerDependencies;
import com.avito.android.location_picker.entities.ActivityResult;
import com.avito.android.location_picker.entities.AddressValidationState;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.LocationPickerStateKt;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.view.LocationPickerChooseButtonLocation;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.ui.activity.BaseActivity;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.maps.MapsInitializer;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b<\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/location_picker/LocationPickerActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/location_picker/LocationPickerBinder$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStart", "()V", "onBackPressed", "onStop", "outState", "onSaveInstanceState", "onResume", "onPause", "", "accessGoogleServices", "()Z", "Lio/reactivex/rxjava3/core/Single;", "Landroid/location/Location;", "findLocation", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/location_picker/entities/ActivityResult;", "k", "Lcom/jakewharton/rxrelay3/Relay;", "activityResultRelay", "Lcom/avito/android/location_picker/LocationPickerBinder;", "binder", "Lcom/avito/android/location_picker/LocationPickerBinder;", "getBinder", "()Lcom/avito/android/location_picker/LocationPickerBinder;", "setBinder", "(Lcom/avito/android/location_picker/LocationPickerBinder;)V", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;)V", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "defaultLocationInteractor", "Lcom/avito/android/location/find/DefaultLocationInteractor;", "getDefaultLocationInteractor", "()Lcom/avito/android/location/find/DefaultLocationInteractor;", "setDefaultLocationInteractor", "(Lcom/avito/android/location/find/DefaultLocationInteractor;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", "l", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "<init>", "Companion", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerActivity extends BaseActivity implements LocationPickerBinder.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public LocationPickerAnalyticsInteractor analyticsInteractor;
    @Inject
    public LocationPickerBinder binder;
    @Inject
    public DefaultLocationInteractor defaultLocationInteractor;
    public final Relay<ActivityResult> k;
    public Disposable l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"Js\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b \u0010\u0017¨\u0006#"}, d2 = {"Lcom/avito/android/location_picker/LocationPickerActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "itemId", "Lcom/avito/android/remote/model/SearchRadius;", "searchRadius", "categoryId", "Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;", "chooseButtonLocation", "Lcom/avito/android/remote/model/SearchParams;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/PublishIntentFactory$JobAssistantParams;", "jobAssistantParams", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "Landroid/content/Intent;", "createLocationPickerActivityIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;Ljava/lang/String;Lcom/avito/android/remote/model/SearchRadius;Ljava/lang/String;Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/PublishIntentFactory$JobAssistantParams;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)Landroid/content/Intent;", "EXTRA_CATEGORY_ID", "Ljava/lang/String;", "EXTRA_CHOOSE_BUTTON_LOCATION", "EXTRA_INITIAL_ADDRESS", "EXTRA_ITEM_ID", "EXTRA_JOB_ASSISTANT_PARAMS", "EXTRA_SEARCH_PARAMS", "EXTRA_SEARCH_RADIUS", "EXTRA_VALIDATION_RULES", "KEY_MAP_STATE", "KEY_STATE", "<init>", "()V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Intent createLocationPickerActivityIntent$default(Companion companion, Context context, AddressParameter.Value value, String str, SearchRadius searchRadius, String str2, LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, SearchParams searchParams, PublishIntentFactory.JobAssistantParams jobAssistantParams, AddressParameter.ValidationRules validationRules, int i, Object obj) {
            AddressParameter.ValidationRules validationRules2 = null;
            AddressParameter.Value value2 = (i & 2) != 0 ? null : value;
            String str3 = (i & 4) != 0 ? null : str;
            SearchRadius searchRadius2 = (i & 8) != 0 ? null : searchRadius;
            String str4 = (i & 16) != 0 ? null : str2;
            LocationPickerChooseButtonLocation locationPickerChooseButtonLocation2 = (i & 32) != 0 ? LocationPickerChooseButtonLocation.APPBAR : locationPickerChooseButtonLocation;
            SearchParams searchParams2 = (i & 64) != 0 ? null : searchParams;
            PublishIntentFactory.JobAssistantParams jobAssistantParams2 = (i & 128) != 0 ? null : jobAssistantParams;
            if ((i & 256) == 0) {
                validationRules2 = validationRules;
            }
            return companion.createLocationPickerActivityIntent(context, value2, str3, searchRadius2, str4, locationPickerChooseButtonLocation2, searchParams2, jobAssistantParams2, validationRules2);
        }

        @NotNull
        public final Intent createLocationPickerActivityIntent(@NotNull Context context, @Nullable AddressParameter.Value value, @Nullable String str, @Nullable SearchRadius searchRadius, @Nullable String str2, @NotNull LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, @Nullable SearchParams searchParams, @Nullable PublishIntentFactory.JobAssistantParams jobAssistantParams, @Nullable AddressParameter.ValidationRules validationRules) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(locationPickerChooseButtonLocation, "chooseButtonLocation");
            Intent putExtra = new Intent(context, LocationPickerActivity.class).putExtra("EX_INITIAL_ADDRESS", value).putExtra("EXTRA_ITEM_ID", str).putExtra("EXTRA_SEARCH_RADIUS", searchRadius).putExtra("EXTRA_CATEGORY_ID", str2).putExtra("EXTRA_CHOOSE_BUTTON_LOCATION", locationPickerChooseButtonLocation).putExtra("EXTRA_SEARCH_PARAMS", searchParams).putExtra("EXTRA_SHOULD_SEND_LOCATION_TO_JOB_ASSISTANT", jobAssistantParams).putExtra("EXTRA_VALIDATION_RULES", validationRules);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…N_RULES, validationRules)");
            return putExtra;
        }

        public Companion(j jVar) {
        }
    }

    public LocationPickerActivity() {
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.k = create;
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder.Router
    public boolean accessGoogleServices() {
        return MapsInitializer.initialize(getApplicationContext()) == 0;
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder.Router
    @NotNull
    public Single<Location> findLocation() {
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        defaultLocationInteractor2.setActivity(this);
        DefaultLocationInteractor defaultLocationInteractor3 = this.defaultLocationInteractor;
        if (defaultLocationInteractor3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        return defaultLocationInteractor3.findLocation();
    }

    @NotNull
    public final LocationPickerAnalyticsInteractor getAnalyticsInteractor() {
        LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor = this.analyticsInteractor;
        if (locationPickerAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return locationPickerAnalyticsInteractor;
    }

    @NotNull
    public final LocationPickerBinder getBinder() {
        LocationPickerBinder locationPickerBinder = this.binder;
        if (locationPickerBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        return locationPickerBinder;
    }

    @NotNull
    public final DefaultLocationInteractor getDefaultLocationInteractor() {
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        return defaultLocationInteractor2;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.k.accept(new ActivityResult(i, i2 == -1, null));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LocationPickerBinder locationPickerBinder = this.binder;
        if (locationPickerBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        LocationPickerState currentState = locationPickerBinder.getCurrentState();
        if (currentState != null && currentState.getRadiusState().getNeedToShowWidget()) {
            LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor = this.analyticsInteractor;
            if (locationPickerAnalyticsInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            locationPickerAnalyticsInteractor.trackScreenClosed(currentState, ScreenCloseFromBlock.CANCEL);
        }
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        LocationPickerState locationPickerState;
        String str;
        SendLocationToJobAssistant sendLocationToJobAssistant;
        String str2;
        String str3;
        String str4;
        super.onCreate(bundle);
        setContentView(R.layout.location_picker_activity);
        AddressParameter.Value value = (AddressParameter.Value) getIntent().getParcelableExtra("EX_INITIAL_ADDRESS");
        String stringExtra = getIntent().getStringExtra("EXTRA_ITEM_ID");
        String stringExtra2 = getIntent().getStringExtra("EXTRA_CATEGORY_ID");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        SearchParams searchParams = (SearchParams) getIntent().getParcelableExtra("EXTRA_SEARCH_PARAMS");
        SearchRadius searchRadius = (SearchRadius) getIntent().getParcelableExtra("EXTRA_SEARCH_RADIUS");
        AddressValidationState addressValidationState = new AddressValidationState((AddressParameter.ValidationRules) getIntent().getParcelableExtra("EXTRA_VALIDATION_RULES"), false, false, null, 14, null);
        if (searchParams != null) {
            getWindow().setSoftInputMode(48);
        }
        if (bundle != null && (locationPickerState = (LocationPickerState) bundle.getParcelable("KEY_STATE")) != null) {
            str = "EXTRA_VALIDATION_RULES";
        } else if (value == null) {
            str = "EXTRA_VALIDATION_RULES";
            if (searchParams == null || searchRadius == null) {
                locationPickerState = new LocationPickerState(stringExtra, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, stringExtra2, false, null, false, null, null, 4128766, null);
            } else {
                AvitoMapPoint avitoMapPoint = new AvitoMapPoint(searchRadius.getCoordinates().getLatitude(), searchRadius.getCoordinates().getLongitude());
                String id = searchRadius.getId();
                if (id != null) {
                    str2 = id;
                } else {
                    str2 = "";
                }
                Long distanceInMeters = searchRadius.getDistanceInMeters();
                long longValue = distanceInMeters != null ? distanceInMeters.longValue() : 0;
                Long distanceInMeters2 = searchRadius.getDistanceInMeters();
                locationPickerState = new LocationPickerState(stringExtra, avitoMapPoint, false, 17.0f, "", false, null, false, false, false, null, null, null, false, false, false, stringExtra2, false, new SearchRadiusViewState(str2, null, true, false, null, longValue, null, distanceInMeters2 == null || distanceInMeters2.longValue() != 0, false, 0, searchParams, true, searchRadius, 858, null), false, null, null, 3866564, null);
            }
        } else if (Intrinsics.areEqual(stringExtra2, LocationPickerStateKt.CATEGORY_REAL_ESTATE)) {
            AvitoMapPoint avitoMapPoint2 = new AvitoMapPoint(value.getLat(), value.getLng());
            String text = value.getText();
            if (text != null) {
                str4 = text;
            } else {
                str4 = "";
            }
            String text2 = value.getText();
            boolean z = !(text2 == null || text2.length() == 0);
            String text3 = value.getText();
            boolean z2 = text3 == null || text3.length() == 0;
            SearchRadiusViewState searchRadiusViewState = new SearchRadiusViewState(null, null, false, false, null, 0, null, false, false, 0, null, false, null, 8191, null);
            String jsonWebToken = value.getJsonWebToken();
            str = "EXTRA_VALIDATION_RULES";
            locationPickerState = new LocationPickerState(stringExtra, avitoMapPoint2, z2, 11.0f, str4, z, null, false, false, false, null, null, null, false, false, false, stringExtra2, false, searchRadiusViewState, false, jsonWebToken, addressValidationState, 720832, null);
        } else {
            AvitoMapPoint avitoMapPoint3 = new AvitoMapPoint(value.getLat(), value.getLng());
            String text4 = value.getText();
            if (text4 != null) {
                str3 = text4;
            } else {
                str3 = "";
            }
            String text5 = value.getText();
            boolean z3 = !(text5 == null || text5.length() == 0);
            SearchRadiusViewState searchRadiusViewState2 = new SearchRadiusViewState(null, null, false, false, null, 0, null, false, false, 0, null, false, null, 8191, null);
            String text6 = value.getText();
            boolean z4 = text6 == null || text6.length() == 0;
            String jsonWebToken2 = value.getJsonWebToken();
            str = "EXTRA_VALIDATION_RULES";
            locationPickerState = new LocationPickerState(stringExtra, avitoMapPoint3, z4, 17.0f, str3, z3, null, false, false, false, null, null, null, false, false, false, stringExtra2, false, searchRadiusViewState2, false, jsonWebToken2, addressValidationState, 720832, null);
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("EXTRA_CHOOSE_BUTTON_LOCATION");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.location_picker.view.LocationPickerChooseButtonLocation");
        LocationPickerChooseButtonLocation locationPickerChooseButtonLocation = (LocationPickerChooseButtonLocation) serializableExtra;
        PublishIntentFactory.JobAssistantParams jobAssistantParams = (PublishIntentFactory.JobAssistantParams) getIntent().getParcelableExtra("EXTRA_SHOULD_SEND_LOCATION_TO_JOB_ASSISTANT");
        AddressParameter.ValidationRules validationRules = (AddressParameter.ValidationRules) getIntent().getParcelableExtra(str);
        if (jobAssistantParams != null) {
            sendLocationToJobAssistant = new SendLocationToJobAssistant.ShouldSend(jobAssistantParams.getChannelId());
        } else {
            sendLocationToJobAssistant = SendLocationToJobAssistant.Default.INSTANCE;
        }
        AvitoMapTarget avitoMapTarget = bundle != null ? (AvitoMapTarget) bundle.getParcelable("KEY_MAP_STATE") : null;
        if (avitoMapTarget == null && locationPickerState.getRadiusState().getShouldLoadRadiusList()) {
            avitoMapTarget = new AvitoMapTarget(locationPickerState.getLatLng(), locationPickerState.getZoom());
        }
        LocationPickerComponent.Builder withActivity = DaggerLocationPickerComponent.builder().dependencies((LocationPickerDependencies) ComponentDependenciesKt.getDependencies(LocationPickerDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivityResultRelay(this.k).withInitialState(locationPickerState).withFragmentActivity(this).withSavedMapTarget(avitoMapTarget).withSearchRadius(locationPickerState.getRadiusState().getNeedToShowWidget()).withAddressKindsValidation(validationRules != null).withActivity(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withActivity.withResources(resources).withChooseButtonLocation(locationPickerChooseButtonLocation).withSendLocationToJobAssistant(sendLocationToJobAssistant).build().inject(this);
        if (bundle == null && locationPickerState.getRadiusState().getNeedToShowWidget()) {
            LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor = this.analyticsInteractor;
            if (locationPickerAnalyticsInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            locationPickerAnalyticsInteractor.trackScreenOpened(locationPickerState);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        LocationPickerBinder locationPickerBinder = this.binder;
        if (locationPickerBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        locationPickerBinder.sendScreenExitAfterCoordinatesResolve();
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        defaultLocationInteractor2.unregisterLocationReceiver(this);
        super.onPause();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DefaultLocationInteractor defaultLocationInteractor2 = this.defaultLocationInteractor;
        if (defaultLocationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultLocationInteractor");
        }
        defaultLocationInteractor2.registerLocationReceiver(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        LocationPickerBinder locationPickerBinder = this.binder;
        if (locationPickerBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        LocationPickerState currentState = locationPickerBinder.getCurrentState();
        bundle.putParcelable("KEY_STATE", currentState);
        bundle.putParcelable("KEY_MAP_STATE", currentState != null ? currentState.getMapTarget() : null);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LocationPickerBinder locationPickerBinder = this.binder;
        if (locationPickerBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        locationPickerBinder.attachRouter(this);
        LocationPickerBinder locationPickerBinder2 = this.binder;
        if (locationPickerBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        this.l = locationPickerBinder2.bind();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        LocationPickerBinder locationPickerBinder = this.binder;
        if (locationPickerBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        locationPickerBinder.detachRouter();
        super.onStop();
        Disposable disposable = this.l;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void setAnalyticsInteractor(@NotNull LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(locationPickerAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = locationPickerAnalyticsInteractor;
    }

    public final void setBinder(@NotNull LocationPickerBinder locationPickerBinder) {
        Intrinsics.checkNotNullParameter(locationPickerBinder, "<set-?>");
        this.binder = locationPickerBinder;
    }

    public final void setDefaultLocationInteractor(@NotNull DefaultLocationInteractor defaultLocationInteractor2) {
        Intrinsics.checkNotNullParameter(defaultLocationInteractor2, "<set-?>");
        this.defaultLocationInteractor = defaultLocationInteractor2;
    }
}
