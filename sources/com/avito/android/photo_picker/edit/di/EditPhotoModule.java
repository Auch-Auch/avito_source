package com.avito.android.photo_picker.edit.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.edit.EditPhotoViewModel;
import com.avito.android.photo_picker.edit.EditPhotoViewModelFactory;
import com.avito.android.photo_picker.edit.ExifProvider;
import com.avito.android.photo_picker.edit.ExifProviderImpl;
import com.avito.android.util.PrivatePhotosStorage;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/photo_picker/edit/di/EditPhotoModule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "Lcom/avito/android/photo_picker/edit/ExifProvider;", "provideExifProvider", "(Landroid/content/Context;Lcom/avito/android/util/PrivatePhotosStorage;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;)Lcom/avito/android/photo_picker/edit/ExifProvider;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;", "<init>", "()V", "Declarations", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class EditPhotoModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/edit/di/EditPhotoModule$Declarations;", "", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/photo_picker/edit/EditPhotoViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;", "serializer", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "provideExifExtraDataSerializer", "(Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;)Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ExifExtraDataSerializer provideExifExtraDataSerializer(@NotNull ExifExtraDataSerializerImpl exifExtraDataSerializerImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull EditPhotoViewModelFactory editPhotoViewModelFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ExifProvider provideExifProvider(@NotNull Context context, @NotNull PrivatePhotosStorage privatePhotosStorage, @NotNull ExifExtraDataSerializer exifExtraDataSerializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        return new ExifProviderImpl(context, privatePhotosStorage, exifExtraDataSerializer);
    }

    @Provides
    @PerFragment
    @NotNull
    public final EditPhotoViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, factory).get(EditPhotoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…otoViewModel::class.java)");
        return (EditPhotoViewModel) viewModel;
    }
}
