package com.avito.android.location_picker.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.di.PerActivity;
import com.avito.android.location_picker.LocationPickerActivity;
import com.avito.android.location_picker.entities.ActivityResult;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.view.LocationPickerChooseButtonLocation;
import dagger.BindsInstance;
import dagger.Component;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/location_picker/di/LocationPickerComponent;", "", "Lcom/avito/android/location_picker/LocationPickerActivity;", "activity", "", "inject", "(Lcom/avito/android/location_picker/LocationPickerActivity;)V", "Builder", "location-picker_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {LocationPickerDependencies.class}, modules = {LocationPickerModule.class})
@PerActivity
public interface LocationPickerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H&¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location_picker/entities/ActivityResult;", "relay", "withActivityResultRelay", "(Lio/reactivex/rxjava3/core/Observable;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "state", "withInitialState", "(Lcom/avito/android/location_picker/entities/LocationPickerState;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "", "showSearchRadius", "withSearchRadius", "(Z)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "validate", "withAddressKindsValidation", "Lcom/avito/android/avito_map/AvitoMapTarget;", "mapTarget", "withSavedMapTarget", "(Lcom/avito/android/avito_map/AvitoMapTarget;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "withFragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;", "location", "withChooseButtonLocation", "(Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;", "sendLocationToJobAssistant", "withSendLocationToJobAssistant", "(Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Lcom/avito/android/location_picker/di/LocationPickerDependencies;", "dependencies", "(Lcom/avito/android/location_picker/di/LocationPickerDependencies;)Lcom/avito/android/location_picker/di/LocationPickerComponent$Builder;", "Lcom/avito/android/location_picker/di/LocationPickerComponent;", "build", "()Lcom/avito/android/location_picker/di/LocationPickerComponent;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        LocationPickerComponent build();

        @NotNull
        Builder dependencies(@NotNull LocationPickerDependencies locationPickerDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withActivityResultRelay(@NotNull Observable<ActivityResult> observable);

        @BindsInstance
        @NotNull
        Builder withAddressKindsValidation(@AddressKindsValidation boolean z);

        @BindsInstance
        @NotNull
        Builder withChooseButtonLocation(@NotNull LocationPickerChooseButtonLocation locationPickerChooseButtonLocation);

        @BindsInstance
        @NotNull
        Builder withFragmentActivity(@NotNull FragmentActivity fragmentActivity);

        @BindsInstance
        @NotNull
        Builder withInitialState(@NotNull LocationPickerState locationPickerState);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSavedMapTarget(@Nullable AvitoMapTarget avitoMapTarget);

        @BindsInstance
        @NotNull
        Builder withSearchRadius(@ShowSearchRadius boolean z);

        @BindsInstance
        @NotNull
        Builder withSendLocationToJobAssistant(@NotNull SendLocationToJobAssistant sendLocationToJobAssistant);
    }

    void inject(@NotNull LocationPickerActivity locationPickerActivity);
}
