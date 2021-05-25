package com.avito.android.spare_parts.bottom_sheet.di;

import a2.b.a.a.a;
import com.avito.android.di.PerActivity;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsFormatterImpl;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.android.spare_parts.SparePartsResourceProviderImpl;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenterImpl;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemBlueprint;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetModule;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemBlueprint;", "sparePartsBlueprint", "provideItemBinder", "(Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SparePartsBottomSheetModule {
    @NotNull
    public static final SparePartsBottomSheetModule INSTANCE = new SparePartsBottomSheetModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/di/SparePartsBottomSheetModule$Declarations;", "", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenterImpl;", "presenter", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "bindsSparePartsBottomSheetPresenter", "(Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenterImpl;)Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetPresenter;", "Lcom/avito/android/spare_parts/SparePartsResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "bindSparePartsResourceProvider", "(Lcom/avito/android/spare_parts/SparePartsResourceProviderImpl;)Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "Lcom/avito/android/spare_parts/SparePartsFormatterImpl;", "formatter", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "bindSparePartsFormatter", "(Lcom/avito/android/spare_parts/SparePartsFormatterImpl;)Lcom/avito/android/spare_parts/SparePartsFormatter;", "Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "bindAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatterImpl;)Lcom/avito/android/util/text/AttributedTextFormatter;", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AttributedTextFormatter bindAttributedTextFormatter(@NotNull AttributedTextFormatterImpl attributedTextFormatterImpl);

        @PerActivity
        @Binds
        @NotNull
        SparePartsFormatter bindSparePartsFormatter(@NotNull SparePartsFormatterImpl sparePartsFormatterImpl);

        @PerActivity
        @Binds
        @NotNull
        SparePartsResourceProvider bindSparePartsResourceProvider(@NotNull SparePartsResourceProviderImpl sparePartsResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        SparePartsBottomSheetPresenter bindsSparePartsBottomSheetPresenter(@NotNull SparePartsBottomSheetPresenterImpl sparePartsBottomSheetPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder(@NotNull SparePartsTextItemBlueprint sparePartsTextItemBlueprint) {
        Intrinsics.checkNotNullParameter(sparePartsTextItemBlueprint, "sparePartsBlueprint");
        return new ItemBinder.Builder().registerItem(sparePartsTextItemBlueprint).build();
    }
}
