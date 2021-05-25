package com.avito.android.photo_picker;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.di.PerActivity;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerActivity
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "c", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "Lcom/avito/android/util/RandomKeyProvider;", "e", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "d", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "f", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "", g.a, "I", "maxPhotos", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "interactor", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerViewModelFactory implements ViewModelProvider.Factory {
    public final PhotoPickerInteractor a;
    public final SchedulersFactory b;
    public final PhotoPickerEventTracker c;
    public final ComputerVisionInteractor d;
    public final RandomKeyProvider e;
    public final PublishIntentFactory.PhotoPickerMode f;
    public final int g;

    @Inject
    public PhotoPickerViewModelFactory(@NotNull PhotoPickerInteractor photoPickerInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull RandomKeyProvider randomKeyProvider, @Named("mode") @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode, @Named("max_photo_count") int i) {
        Intrinsics.checkNotNullParameter(photoPickerInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(photoPickerMode, "mode");
        this.a = photoPickerInteractor;
        this.b = schedulersFactory;
        this.c = photoPickerEventTracker;
        this.d = computerVisionInteractor;
        this.e = randomKeyProvider;
        this.f = photoPickerMode;
        this.g = i;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PhotoPickerViewModel.class)) {
            return new PhotoPickerViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
