package com.avito.android.advert_core.discount.di;

import a2.b.a.a.a;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogImpl;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogPresenter;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogPresenterImpl;
import com.avito.android.advert_core.discount.AdvertDiscountItemConverter;
import com.avito.android.advert_core.discount.AdvertDiscountItemConverterImpl;
import com.avito.android.advert_core.discount.item.contact.ContactItemBlueprint;
import com.avito.android.advert_core.discount.item.discount.DiscountItemBlueprint;
import com.avito.android.advert_core.discount.item.divider.DividerItemBlueprint;
import com.avito.android.advert_core.discount.item.information.InformationItemBlueprint;
import com.avito.android.advert_core.discount.item.title.TitleItemBlueprint;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/discount/di/AdvertDiscountDetailsModule;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/advert_core/discount/item/title/TitleItemBlueprint;", "titleItemBlueprint", "Lcom/avito/android/advert_core/discount/item/discount/DiscountItemBlueprint;", "discountItemBlueprint", "Lcom/avito/android/advert_core/discount/item/divider/DividerItemBlueprint;", "dividerItemBlueprint", "Lcom/avito/android/advert_core/discount/item/information/InformationItemBlueprint;", "informationItemBlueprint", "Lcom/avito/android/advert_core/discount/item/contact/ContactItemBlueprint;", "contactItemBlueprint", "provideItemBinder", "(Lcom/avito/android/advert_core/discount/item/title/TitleItemBlueprint;Lcom/avito/android/advert_core/discount/item/discount/DiscountItemBlueprint;Lcom/avito/android/advert_core/discount/item/divider/DividerItemBlueprint;Lcom/avito/android/advert_core/discount/item/information/InformationItemBlueprint;Lcom/avito/android/advert_core/discount/item/contact/ContactItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "AdvertDiscount", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class AdvertDiscountDetailsModule {
    @NotNull
    public static final AdvertDiscountDetailsModule INSTANCE = new AdvertDiscountDetailsModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_core/discount/di/AdvertDiscountDetailsModule$AdvertDiscount;", "", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface AdvertDiscount {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/discount/di/AdvertDiscountDetailsModule$Declarations;", "", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogImpl;", "view", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "bindAdvertDiscountDetailsDialog", "(Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogImpl;)Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenterImpl;", "presenter", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenter;", "bindDiscountDetailsDialogPresenter", "(Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenterImpl;)Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialogPresenter;", "Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverterImpl;", "converter", "Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverter;", "bindAdvertDiscountItemConverter", "(Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverterImpl;)Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverter;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AdvertDiscountDetailsDialog bindAdvertDiscountDetailsDialog(@NotNull AdvertDiscountDetailsDialogImpl advertDiscountDetailsDialogImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDiscountItemConverter bindAdvertDiscountItemConverter(@NotNull AdvertDiscountItemConverterImpl advertDiscountItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertDiscountDetailsDialogPresenter bindDiscountDetailsDialogPresenter(@NotNull AdvertDiscountDetailsDialogPresenterImpl advertDiscountDetailsDialogPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @AdvertDiscount
    @PerFragment
    public static final SimpleRecyclerAdapter provideAdapter(@AdvertDiscount @NotNull AdapterPresenter adapterPresenter, @AdvertDiscount @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @AdvertDiscount
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter(@AdvertDiscount @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @AdvertDiscount
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull TitleItemBlueprint titleItemBlueprint, @NotNull DiscountItemBlueprint discountItemBlueprint, @NotNull DividerItemBlueprint dividerItemBlueprint, @NotNull InformationItemBlueprint informationItemBlueprint, @NotNull ContactItemBlueprint contactItemBlueprint) {
        Intrinsics.checkNotNullParameter(titleItemBlueprint, "titleItemBlueprint");
        Intrinsics.checkNotNullParameter(discountItemBlueprint, "discountItemBlueprint");
        Intrinsics.checkNotNullParameter(dividerItemBlueprint, "dividerItemBlueprint");
        Intrinsics.checkNotNullParameter(informationItemBlueprint, "informationItemBlueprint");
        Intrinsics.checkNotNullParameter(contactItemBlueprint, "contactItemBlueprint");
        return new ItemBinder.Builder().registerItem(titleItemBlueprint).registerItem(discountItemBlueprint).registerItem(dividerItemBlueprint).registerItem(informationItemBlueprint).registerItem(contactItemBlueprint).build();
    }
}
