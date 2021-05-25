package com.avito.android.profile.edit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.CalledFrom;
import com.avito.android.Features;
import com.avito.android.LocationListIntentFactory;
import com.avito.android.PhoneConfirmationIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.profile.R;
import com.avito.android.profile.di.DaggerEditProfileComponent;
import com.avito.android.profile.di.EditProfileComponent;
import com.avito.android.profile.di.EditProfileDependencies;
import com.avito.android.profile.edit.EditProfilePresenter;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectActivityKt;
import com.avito.android.select.SelectResult;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Activities;
import com.avito.android.util.Bundles;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Intents;
import com.avito.android.util.Kundle;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bv\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\nJ)\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\b\u0010&\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\fJ\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020!H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0000@\u0000X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010l\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bl\u0010K\u001a\u0004\bm\u0010M\"\u0004\bn\u0010OR\"\u0010p\u001a\u00020o8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010u¨\u0006w"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/profile/edit/EditProfilePresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onBackPressed", "setUpCustomToolbar", "()Z", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "getContentLayoutId", "()I", "Lcom/avito/android/remote/model/Location;", "location", "openLocationScreen", "(Lcom/avito/android/remote/model/Location;)V", "", "title", "", "Lcom/avito/android/remote/model/NameIdEntity;", "items", "selectedItem", "openSubLocationScreen", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/NameIdEntity;)V", "openCameraScreen", "phoneNumber", "openPhoneVerificationScreen", "(Ljava/lang/String;)V", "changesSaved", "close", "(Z)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$profile_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$profile_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/CalledFrom;", "k", "Lcom/avito/android/CalledFrom;", "calledFrom", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/profile/edit/CameraDelegate;", "cameraDelegate", "Lcom/avito/android/profile/edit/CameraDelegate;", "getCameraDelegate", "()Lcom/avito/android/profile/edit/CameraDelegate;", "setCameraDelegate", "(Lcom/avito/android/profile/edit/CameraDelegate;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/profile/edit/EditProfileInteractor;", "editProfileInteractor", "Lcom/avito/android/profile/edit/EditProfileInteractor;", "getEditProfileInteractor", "()Lcom/avito/android/profile/edit/EditProfileInteractor;", "setEditProfileInteractor", "(Lcom/avito/android/profile/edit/EditProfileInteractor;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/profile/edit/LocationInteractor;", "locationInteractor", "Lcom/avito/android/profile/edit/LocationInteractor;", "getLocationInteractor", "()Lcom/avito/android/profile/edit/LocationInteractor;", "setLocationInteractor", "(Lcom/avito/android/profile/edit/LocationInteractor;)V", "Lcom/avito/android/profile/edit/EditProfilePresenter;", "editProfilePresenter", "Lcom/avito/android/profile/edit/EditProfilePresenter;", "getEditProfilePresenter", "()Lcom/avito/android/profile/edit/EditProfilePresenter;", "setEditProfilePresenter", "(Lcom/avito/android/profile/edit/EditProfilePresenter;)V", "activityIntentFactory", "getActivityIntentFactory", "setActivityIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory$profile_release", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory$profile_release", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "<init>", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class EditProfileActivity extends BaseActivity implements EditProfilePresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public CameraDelegate cameraDelegate;
    @Inject
    public EditProfileInteractor editProfileInteractor;
    @Inject
    public EditProfilePresenter editProfilePresenter;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    public CalledFrom k;
    @Inject
    public LocationInteractor locationInteractor;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;

    @Override // com.avito.android.profile.edit.EditProfilePresenter.Router
    public void close(boolean z) {
        if (z) {
            CalledFrom calledFrom = this.k;
            if (calledFrom == null || !(calledFrom instanceof CalledFrom.Push)) {
                setResult(-1);
            } else {
                ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
                if (activityIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
                }
                Intent flags = activityIntentFactory2.profilePreviewIntent().setFlags(67108864);
                Intrinsics.checkNotNullExpressionValue(flags, "intentFactory\n          ….FLAG_ACTIVITY_CLEAR_TOP)");
                startActivity(flags);
            }
        }
        finish();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics$profile_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final CameraDelegate getCameraDelegate() {
        CameraDelegate cameraDelegate2 = this.cameraDelegate;
        if (cameraDelegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraDelegate");
        }
        return cameraDelegate2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.edit_profile;
    }

    @NotNull
    public final EditProfileInteractor getEditProfileInteractor() {
        EditProfileInteractor editProfileInteractor2 = this.editProfileInteractor;
        if (editProfileInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfileInteractor");
        }
        return editProfileInteractor2;
    }

    @NotNull
    public final EditProfilePresenter getEditProfilePresenter() {
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        return editProfilePresenter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory$profile_release() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final LocationInteractor getLocationInteractor() {
        LocationInteractor locationInteractor2 = this.locationInteractor;
        if (locationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationInteractor");
        }
        return locationInteractor2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        List<ParcelableEntity<String>> selectedItems;
        ParcelableEntity parcelableEntity;
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
        } else if (i != 1) {
            if (i == 2) {
                SelectResult extractSelectResult = SelectActivityKt.extractSelectResult(intent);
                if (extractSelectResult != null && (selectedItems = extractSelectResult.getSelectedItems()) != null && (parcelableEntity = (ParcelableEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) selectedItems)) != null) {
                    EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
                    if (editProfilePresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
                    }
                    editProfilePresenter2.onSubLocationSelected((NameIdEntity) parcelableEntity);
                }
            } else if (i == 3) {
                Transformation transformation = intent != null ? (Transformation) intent.getParcelableExtra(PhotoPickerActivityKt.EXTRA_PHOTO_TRANSFORMATION) : null;
                CameraDelegate cameraDelegate2 = this.cameraDelegate;
                if (cameraDelegate2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraDelegate");
                }
                Uri handleTakePhotoResult = cameraDelegate2.handleTakePhotoResult(intent);
                if (handleTakePhotoResult != null) {
                    EditProfilePresenter editProfilePresenter3 = this.editProfilePresenter;
                    if (editProfilePresenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
                    }
                    editProfilePresenter3.onAvatarSelected(handleTakePhotoResult, transformation);
                }
            }
        } else if (intent != null) {
            Location location = (Location) intent.getParcelableExtra("location");
            EditProfilePresenter editProfilePresenter4 = this.editProfilePresenter;
            if (editProfilePresenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
            }
            Intrinsics.checkNotNullExpressionValue(location, "location");
            editProfilePresenter4.onLocationSelected(location);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        editProfilePresenter2.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        editProfilePresenter2.attachView(new EditProfileViewImpl(viewGroup, simpleRecyclerAdapter, analytics2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        editProfilePresenter2.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        Bundle putKundle = Bundles.putKundle(bundle, "edit_profile_presenter", editProfilePresenter2.onSaveState());
        LocationInteractor locationInteractor2 = this.locationInteractor;
        if (locationInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationInteractor");
        }
        Bundle putKundle2 = Bundles.putKundle(putKundle, "location_interactor", locationInteractor2.onSaveState());
        EditProfileInteractor editProfileInteractor2 = this.editProfileInteractor;
        if (editProfileInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfileInteractor");
        }
        Bundles.putKundle(putKundle2, "edit_profile_interactor", editProfileInteractor2.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        editProfilePresenter2.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        EditProfilePresenter editProfilePresenter2 = this.editProfilePresenter;
        if (editProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editProfilePresenter");
        }
        editProfilePresenter2.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter.Router
    public void openCameraScreen() {
        CameraDelegate cameraDelegate2 = this.cameraDelegate;
        if (cameraDelegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraDelegate");
        }
        Intent createTakePhotoIntent = cameraDelegate2.createTakePhotoIntent(this);
        if (createTakePhotoIntent != null) {
            Activities.startActivityForResultSafely(this, createTakePhotoIntent, 3);
        }
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter.Router
    public void openLocationScreen(@Nullable Location location) {
        ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(LocationListIntentFactory.DefaultImpls.locationIntent$default(activityIntentFactory2, location, false, false, null, false, 24, null), 1);
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter.Router
    public void openPhoneVerificationScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(PhoneConfirmationIntentFactory.DefaultImpls.phoneVerificationIntent$default(activityIntentFactory2, str, null, false, false, 8, null));
    }

    @Override // com.avito.android.profile.edit.EditProfilePresenter.Router
    public void openSubLocationScreen(@NotNull String str, @NotNull List<NameIdEntity> list, @Nullable NameIdEntity nameIdEntity) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        startActivityForResult(SelectActivityKt.createSelectActivityIntent(this, new Arguments(String.valueOf(2), list, CollectionsKt__CollectionsKt.listOfNotNull(nameIdEntity), str, true, false, false, false, false, false, null, false, false, null, 15872, null)), 2);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics$profile_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCameraDelegate(@NotNull CameraDelegate cameraDelegate2) {
        Intrinsics.checkNotNullParameter(cameraDelegate2, "<set-?>");
        this.cameraDelegate = cameraDelegate2;
    }

    public final void setEditProfileInteractor(@NotNull EditProfileInteractor editProfileInteractor2) {
        Intrinsics.checkNotNullParameter(editProfileInteractor2, "<set-?>");
        this.editProfileInteractor = editProfileInteractor2;
    }

    public final void setEditProfilePresenter(@NotNull EditProfilePresenter editProfilePresenter2) {
        Intrinsics.checkNotNullParameter(editProfilePresenter2, "<set-?>");
        this.editProfilePresenter = editProfilePresenter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory$profile_release(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.intentFactory = activityIntentFactory2;
    }

    public final void setLocationInteractor(@NotNull LocationInteractor locationInteractor2) {
        Intrinsics.checkNotNullParameter(locationInteractor2, "<set-?>");
        this.locationInteractor = locationInteractor2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        Kundle kundle = null;
        this.k = intent != null ? Intents.getCalledFrom(intent) : null;
        Kundle kundle2 = bundle != null ? Bundles.getKundle(bundle, "edit_profile_presenter") : null;
        Kundle kundle3 = bundle != null ? Bundles.getKundle(bundle, "location_interactor") : null;
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "edit_profile_interactor");
        }
        EditProfileComponent.Builder editProfileInteractorState = DaggerEditProfileComponent.builder().dependencies((EditProfileDependencies) ComponentDependenciesKt.getDependencies(EditProfileDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).activity(this).presenterState(kundle2).interactorState(kundle3).editProfileInteractorState(kundle);
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        editProfileInteractorState.withGson(create).build().inject(this);
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}
