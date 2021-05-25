package com.avito.android.advert.notes.di;

import com.avito.android.advert.notes.EditAdvertNoteActivity;
import com.avito.android.advert.notes.di.AdvertDetailsNoteModule;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.vk.sdk.api.model.VKAttachments;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent;", "", "Lcom/avito/android/advert/notes/EditAdvertNoteActivity;", "activity", "", "inject", "(Lcom/avito/android/advert/notes/EditAdvertNoteActivity;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AdvertDetailsNoteDependencies.class}, modules = {AdvertDetailsNoteModule.class})
@PerFragment
public interface AdvertDetailsNoteComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\bH'¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent$Builder;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent$Builder;", VKAttachments.TYPE_NOTE, "withNote", "", "isRestored", "withIsRestored", "(Z)Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent$Builder;", "isFavorite", "withIsFavorite", "Lcom/avito/android/advert/notes/di/AdvertDetailsNoteDependencies;", "advertDetailsNoteDependencies", "(Lcom/avito/android/advert/notes/di/AdvertDetailsNoteDependencies;)Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent$Builder;", "Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent;", "build", "()Lcom/avito/android/advert/notes/di/AdvertDetailsNoteComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder advertDetailsNoteDependencies(@NotNull AdvertDetailsNoteDependencies advertDetailsNoteDependencies);

        @NotNull
        AdvertDetailsNoteComponent build();

        @BindsInstance
        @NotNull
        Builder withAdvertId(@AdvertDetailsNoteModule.AdvertId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withIsFavorite(@AdvertDetailsNoteModule.IsFavorite boolean z);

        @BindsInstance
        @NotNull
        Builder withIsRestored(@AdvertDetailsNoteModule.IsRestored boolean z);

        @BindsInstance
        @NotNull
        Builder withNote(@AdvertDetailsNoteModule.AdvertNote @NotNull String str);
    }

    void inject(@NotNull EditAdvertNoteActivity editAdvertNoteActivity);
}
