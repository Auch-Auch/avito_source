package com.avito.android.di.component;

import android.content.ContentResolver;
import com.avito.android.di.PerContentProvider;
import com.avito.android.di.module.PhotoContentProviderModule;
import com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies;
import com.avito.android.photo_picker.legacy.provider.PhotoContentProvider;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/PhotoContentProviderComponent;", "", "Lcom/avito/android/photo_picker/legacy/provider/PhotoContentProvider;", "contentProvider", "", "inject", "(Lcom/avito/android/photo_picker/legacy/provider/PhotoContentProvider;)V", "Builder", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhotoContentProviderDependencies.class}, modules = {PhotoContentProviderModule.class})
@PerContentProvider
public interface PhotoContentProviderComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/component/PhotoContentProviderComponent$Builder;", "", "Lcom/avito/android/photo_picker/legacy/di/PhotoContentProviderDependencies;", "photoContentProviderDependencies", "(Lcom/avito/android/photo_picker/legacy/di/PhotoContentProviderDependencies;)Lcom/avito/android/di/component/PhotoContentProviderComponent$Builder;", "Landroid/content/ContentResolver;", "contentResolver", "(Landroid/content/ContentResolver;)Lcom/avito/android/di/component/PhotoContentProviderComponent$Builder;", "Lcom/avito/android/di/component/PhotoContentProviderComponent;", "build", "()Lcom/avito/android/di/component/PhotoContentProviderComponent;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhotoContentProviderComponent build();

        @BindsInstance
        @NotNull
        Builder contentResolver(@NotNull ContentResolver contentResolver);

        @NotNull
        Builder photoContentProviderDependencies(@NotNull PhotoContentProviderDependencies photoContentProviderDependencies);
    }

    void inject(@NotNull PhotoContentProvider photoContentProvider);
}
