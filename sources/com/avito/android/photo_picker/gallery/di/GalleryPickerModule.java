package com.avito.android.photo_picker.gallery.di;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepository;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepositoryImpl;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemBluePrint;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenter;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/gallery/di/GalleryPickerModule;", "", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemBluePrint;", "galleryItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemBluePrint;)Lcom/avito/konveyor/ItemBinder;", "binder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "providePhotoGridPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Declarations", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class GalleryPickerModule {
    @NotNull
    public static final GalleryPickerModule INSTANCE = new GalleryPickerModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/gallery/di/GalleryPickerModule$Declarations;", "", "Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepositoryImpl;", "repository", "Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;", "bindsGalleryPickerRepository", "(Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepositoryImpl;)Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenterImpl;", "itemPresenter", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenter;", "galleryItemPresenter", "(Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenterImpl;)Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenter;", "Lcom/avito/android/permissions/FragmentPermissionHelper;", "permissionHelper", "Lcom/avito/android/permissions/PermissionHelper;", "(Lcom/avito/android/permissions/FragmentPermissionHelper;)Lcom/avito/android/permissions/PermissionHelper;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        GalleryPickerRepository bindsGalleryPickerRepository(@NotNull GalleryPickerRepositoryImpl galleryPickerRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        GalleryItemPresenter galleryItemPresenter(@NotNull GalleryItemPresenterImpl galleryItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PermissionHelper permissionHelper(@NotNull FragmentPermissionHelper fragmentPermissionHelper);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(itemBinder, "binder");
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull GalleryItemBluePrint galleryItemBluePrint) {
        Intrinsics.checkNotNullParameter(galleryItemBluePrint, "galleryItemBlueprint");
        return new ItemBinder.Builder().registerItem(galleryItemBluePrint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter providePhotoGridPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "binder", itemBinder, itemBinder);
    }
}
