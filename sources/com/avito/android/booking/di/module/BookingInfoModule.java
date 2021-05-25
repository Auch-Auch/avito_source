package com.avito.android.booking.di.module;

import a2.b.a.a.a;
import com.avito.android.booking.info.BookingInfoInteractor;
import com.avito.android.booking.info.BookingInfoInteractorImpl;
import com.avito.android.booking.item.description.DescriptionItemBlueprint;
import com.avito.android.booking.item.padding.PaddingItemBlueprint;
import com.avito.android.booking.item.picture.PictureItemBlueprint;
import com.avito.android.booking.item.subtitle.SubtitleItemBlueprint;
import com.avito.android.booking.item.title.TitleItemBlueprint;
import com.avito.android.booking.remote.converter.BookingInfoActionConverter;
import com.avito.android.booking.remote.converter.BookingInfoActionConverterImpl;
import com.avito.android.booking.remote.converter.BookingInfoItemConverter;
import com.avito.android.booking.remote.converter.BookingInfoItemConverterImpl;
import com.avito.android.di.PerFragment;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/booking/di/module/BookingInfoModule;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/booking/item/picture/PictureItemBlueprint;", "pictureItemBlueprint", "Lcom/avito/android/booking/item/title/TitleItemBlueprint;", "titleItemBlueprint", "Lcom/avito/android/booking/item/subtitle/SubtitleItemBlueprint;", "subtitleItemBlueprint", "Lcom/avito/android/booking/item/description/DescriptionItemBlueprint;", "descriptionItemBlueprint", "Lcom/avito/android/booking/item/padding/PaddingItemBlueprint;", "paddingItemBlueprint", "provideItemBinder", "(Lcom/avito/android/booking/item/picture/PictureItemBlueprint;Lcom/avito/android/booking/item/title/TitleItemBlueprint;Lcom/avito/android/booking/item/subtitle/SubtitleItemBlueprint;Lcom/avito/android/booking/item/description/DescriptionItemBlueprint;Lcom/avito/android/booking/item/padding/PaddingItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "booking_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class BookingInfoModule {
    @NotNull
    public static final BookingInfoModule INSTANCE = new BookingInfoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/booking/di/module/BookingInfoModule$Declarations;", "", "Lcom/avito/android/booking/info/BookingInfoInteractorImpl;", "interactor", "Lcom/avito/android/booking/info/BookingInfoInteractor;", "bindBookingInfoInteractor", "(Lcom/avito/android/booking/info/BookingInfoInteractorImpl;)Lcom/avito/android/booking/info/BookingInfoInteractor;", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverterImpl;", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "bindBookingInfoItemConverter", "(Lcom/avito/android/booking/remote/converter/BookingInfoItemConverterImpl;)Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverterImpl;", "Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "bindBookingInfoActionConverter", "(Lcom/avito/android/booking/remote/converter/BookingInfoActionConverterImpl;)Lcom/avito/android/booking/remote/converter/BookingInfoActionConverter;", "booking_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        BookingInfoActionConverter bindBookingInfoActionConverter(@NotNull BookingInfoActionConverterImpl bookingInfoActionConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        BookingInfoInteractor bindBookingInfoInteractor(@NotNull BookingInfoInteractorImpl bookingInfoInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        BookingInfoItemConverter bindBookingInfoItemConverter(@NotNull BookingInfoItemConverterImpl bookingInfoItemConverterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull PictureItemBlueprint pictureItemBlueprint, @NotNull TitleItemBlueprint titleItemBlueprint, @NotNull SubtitleItemBlueprint subtitleItemBlueprint, @NotNull DescriptionItemBlueprint descriptionItemBlueprint, @NotNull PaddingItemBlueprint paddingItemBlueprint) {
        Intrinsics.checkNotNullParameter(pictureItemBlueprint, "pictureItemBlueprint");
        Intrinsics.checkNotNullParameter(titleItemBlueprint, "titleItemBlueprint");
        Intrinsics.checkNotNullParameter(subtitleItemBlueprint, "subtitleItemBlueprint");
        Intrinsics.checkNotNullParameter(descriptionItemBlueprint, "descriptionItemBlueprint");
        Intrinsics.checkNotNullParameter(paddingItemBlueprint, "paddingItemBlueprint");
        return new ItemBinder.Builder().registerItem(pictureItemBlueprint).registerItem(titleItemBlueprint).registerItem(subtitleItemBlueprint).registerItem(descriptionItemBlueprint).registerItem(paddingItemBlueprint).build();
    }
}
