package com.avito.android.autoteka_details.di;

import android.content.res.Resources;
import com.avito.android.autoteka_details.AutotekaDetailsFragment;
import com.avito.android.autoteka_details.core.di.AutotekaInteractorState;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent;", "", "Lcom/avito/android/autoteka_details/AutotekaDetailsFragment;", "autotekaDetailsFragment", "", "inject", "(Lcom/avito/android/autoteka_details/AutotekaDetailsFragment;)V", "Builder", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AutotekaDetailsDependencies.class}, modules = {AutotekaDetailsModule.class})
@PerFragment
public interface AutotekaDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00002\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "", "Lcom/avito/android/autoteka_details/di/AutotekaDetailsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/autoteka_details/di/AutotekaDetailsDependencies;)Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "utmQuery", "withUtmQuery", "", "isRestored", "withIsRestored", "(Z)Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "interactorState", "withInteractorState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "autotekaDetails", "withAutotekaDetails", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent$Builder;", "Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent;", "build", "()Lcom/avito/android/autoteka_details/di/AutotekaDetailsComponent;", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AutotekaDetailsComponent build();

        @NotNull
        Builder dependentOn(@NotNull AutotekaDetailsDependencies autotekaDetailsDependencies);

        @BindsInstance
        @NotNull
        Builder withAdvertId(@AdvertId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withAutotekaDetails(@Nullable AutotekaDetailsResponse autotekaDetailsResponse);

        @BindsInstance
        @NotNull
        Builder withInteractorState(@AutotekaInteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withIsRestored(@IsRestored boolean z);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withUtmQuery(@UtmQuery @Nullable String str);
    }

    void inject(@NotNull AutotekaDetailsFragment autotekaDetailsFragment);
}
