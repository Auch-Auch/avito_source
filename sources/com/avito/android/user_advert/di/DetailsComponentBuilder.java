package com.avito.android.user_advert.di;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u000f\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000e\u001a\u00020\u0011H'¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010 \u001a\u00020\u001cH'¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\"\u001a\u00020\u001cH'¢\u0006\u0004\b#\u0010\u001fJ\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010$\u001a\u00020\u001cH'¢\u0006\u0004\b%\u0010\u001fJ\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010&\u001a\u00020\u001cH'¢\u0006\u0004\b'\u0010\u001fJ!\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0001\u0010)\u001a\u0004\u0018\u00010(H'¢\u0006\u0004\b*\u0010+J!\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0001\u0010,\u001a\u0004\u0018\u00010(H'¢\u0006\u0004\b-\u0010+J\u001f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010/\u001a\u0004\u0018\u00010.H'¢\u0006\u0004\b0\u00101J\u001f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u00103\u001a\u0004\u0018\u000102H'¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "", "T", "build", "()Ljava/lang/Object;", "Lcom/avito/android/user_advert/di/MyAdvertDetailsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/user_advert/di/MyAdvertDetailsDependencies;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Landroidx/fragment/app/FragmentActivity;", "withFragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "withLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Lcom/avito/android/user_advert/advert/DetailsId;", "id", "withDetailsId", "(Lcom/avito/android/user_advert/advert/DetailsId;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "", "shouldOpenActivateDialog", "withShouldOpenActivateDialog", "(Z)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "isNewAdvert", "withIsNewAdvert", "shouldOpenUserAdverts", "withShouldOpenUserAdverts", "shouldFinishAfterActivation", "withShouldFinishAfterActivation", "restoreAdvert", "withRestoreAdvert", "", "errorMessage", "withErrorMessage", "(Ljava/lang/String;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "statusMessage", "withStatusMessage", "Landroid/os/Bundle;", "interactorState", "withInteractorState", "(Landroid/os/Bundle;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "Lcom/avito/android/util/Kundle;", "presenterState", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/user_advert/di/DetailsComponentBuilder;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface DetailsComponentBuilder<T> {
    @NotNull
    /* renamed from: build */
    T mo95build();

    @NotNull
    DetailsComponentBuilder<T> dependentOn(@NotNull MyAdvertDetailsDependencies myAdvertDetailsDependencies);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withActivity(@NotNull Activity activity);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withDetailsId(@NotNull DetailsId detailsId);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withErrorMessage(@ErrorMessage @Nullable String str);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withFragmentActivity(@NotNull FragmentActivity fragmentActivity);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withInteractorState(@Nullable Bundle bundle);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withIsNewAdvert(@IsNewAdvert boolean z);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withPresenterState(@Nullable Kundle kundle);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withResources(@NotNull Resources resources);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withRestoreAdvert(@RestoreAdvert boolean z);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withShouldFinishAfterActivation(@ShouldFinishAfterActivation boolean z);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withShouldOpenActivateDialog(@ShouldOpenActivateDialog boolean z);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withShouldOpenUserAdverts(@ShouldOpenUserAdverts boolean z);

    @BindsInstance
    @NotNull
    DetailsComponentBuilder<T> withStatusMessage(@StatusMessage @Nullable String str);
}
