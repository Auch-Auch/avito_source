package com.avito.android.select.bottom_sheet.di;

import com.avito.android.ab_tests.AutoBrandModelTypoCorrection;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.SearchApi;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectDialogInteractor;
import com.avito.android.select.SelectDialogLocalWithDelayInteractorImpl;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogPresenterResourceProvider;
import com.avito.android.select.SelectedDialogLocalInteractorImpl;
import com.avito.android.select.SelectedDialogRemoteInteractorImpl;
import com.avito.android.select.bottom_sheet.blueprints.CheckableImageItemBlueprint;
import com.avito.android.select.bottom_sheet.blueprints.CheckableImageItemBlueprintImpl;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemBlueprint;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemBlueprintImpl;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemPresenter;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemPresenterImpl;
import com.avito.android.select.title.TitleItemPresenter;
import com.avito.android.select.title.TitleItemPresenterImpl;
import com.avito.android.select.title.TitleItemViewBlueprint;
import com.avito.android.select.title.TitleItemViewBlueprintImpl;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b$\u0010%J/\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010#\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001f¢\u0006\u0002\b 0\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetModule;", "", "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/select/Arguments;", "arguments", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AutoBrandModelTypoCorrectionTestGroup;", "abTestGroup", "Lcom/avito/android/select/SelectDialogInteractor;", "provideSelectDialogInteractor$select_release", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/select/Arguments;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)Lcom/avito/android/select/SelectDialogInteractor;", "provideSelectDialogInteractor", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$select_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/select/title/TitleItemViewBlueprint;", "titleItemViewBlueprint", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableImageItemBlueprint;", "checkableImageItemBlueprint", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemBlueprint;", "checkableItemBlueprint", "provideItemBinder$select_release", "(Lcom/avito/android/select/title/TitleItemViewBlueprint;Lcom/avito/android/select/bottom_sheet/blueprints/CheckableImageItemBlueprint;Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemBlueprint;Lcom/avito/android/select/Arguments;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenter;", "checkableItemPresenter", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideItemPresentersSet$select_release", "(Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenter;)Ljava/util/Set;", "provideItemPresentersSet", "<init>", "()V", "Declarations", "select_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SelectBottomSheetModule {
    @NotNull
    public static final SelectBottomSheetModule INSTANCE = new SelectBottomSheetModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/select/bottom_sheet/di/SelectBottomSheetModule$Declarations;", "", "Lcom/avito/android/select/SelectDialogPresenterImpl;", "presenter", "Lcom/avito/android/select/SelectDialogPresenter;", "bindSelectDialogPresenter", "(Lcom/avito/android/select/SelectDialogPresenterImpl;)Lcom/avito/android/select/SelectDialogPresenter;", "Lcom/avito/android/select/SelectDialogPresenterResourceProvider;", GeoContract.PROVIDER, "Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "bindSelectDialogPresenterResourceProvider", "(Lcom/avito/android/select/SelectDialogPresenterResourceProvider;)Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemBlueprintImpl;", "blueprint", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemBlueprint;", "bindCheckableItemBlueprint", "(Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemBlueprintImpl;)Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemBlueprint;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenterImpl;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenter;", "bindCheckableItemPresenter", "(Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenterImpl;)Lcom/avito/android/select/bottom_sheet/blueprints/CheckableItemPresenter;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableImageItemBlueprintImpl;", "Lcom/avito/android/select/bottom_sheet/blueprints/CheckableImageItemBlueprint;", "bindCheckableImageItemBlueprint", "(Lcom/avito/android/select/bottom_sheet/blueprints/CheckableImageItemBlueprintImpl;)Lcom/avito/android/select/bottom_sheet/blueprints/CheckableImageItemBlueprint;", "Lcom/avito/android/select/title/TitleItemViewBlueprintImpl;", "Lcom/avito/android/select/title/TitleItemViewBlueprint;", "bindTitleItemViewBlueprint", "(Lcom/avito/android/select/title/TitleItemViewBlueprintImpl;)Lcom/avito/android/select/title/TitleItemViewBlueprint;", "Lcom/avito/android/select/title/TitleItemPresenterImpl;", "Lcom/avito/android/select/title/TitleItemPresenter;", "bindTitleItemPresenter", "(Lcom/avito/android/select/title/TitleItemPresenterImpl;)Lcom/avito/android/select/title/TitleItemPresenter;", "select_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        CheckableImageItemBlueprint bindCheckableImageItemBlueprint(@NotNull CheckableImageItemBlueprintImpl checkableImageItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        CheckableItemBlueprint bindCheckableItemBlueprint(@NotNull CheckableItemBlueprintImpl checkableItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        CheckableItemPresenter bindCheckableItemPresenter(@NotNull CheckableItemPresenterImpl checkableItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectDialogPresenter bindSelectDialogPresenter(@NotNull SelectDialogPresenterImpl selectDialogPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectDialogPresenter.ResourceProvider bindSelectDialogPresenterResourceProvider(@NotNull SelectDialogPresenterResourceProvider selectDialogPresenterResourceProvider);

        @PerFragment
        @Binds
        @NotNull
        TitleItemPresenter bindTitleItemPresenter(@NotNull TitleItemPresenterImpl titleItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TitleItemViewBlueprint bindTitleItemViewBlueprint(@NotNull TitleItemViewBlueprintImpl titleItemViewBlueprintImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$select_release(@NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$select_release(@NotNull TitleItemViewBlueprint titleItemViewBlueprint, @NotNull CheckableImageItemBlueprint checkableImageItemBlueprint, @NotNull CheckableItemBlueprint checkableItemBlueprint, @NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(titleItemViewBlueprint, "titleItemViewBlueprint");
        Intrinsics.checkNotNullParameter(checkableImageItemBlueprint, "checkableImageItemBlueprint");
        Intrinsics.checkNotNullParameter(checkableItemBlueprint, "checkableItemBlueprint");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        ItemBinder.Builder registerItem = new ItemBinder.Builder().registerItem(titleItemViewBlueprint);
        if (arguments.getWithImages()) {
            registerItem.registerItem(checkableImageItemBlueprint);
        } else {
            registerItem.registerItem(checkableItemBlueprint);
        }
        return registerItem.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectDialogInteractor provideSelectDialogInteractor$select_release(@NotNull SearchApi searchApi, @NotNull Arguments arguments, @AutoBrandModelTypoCorrection @NotNull SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "abTestGroup");
        Integer attributeId = arguments.getAttributeId();
        int intValue = attributeId != null ? attributeId.intValue() : -1;
        if (arguments.getTypoCorrectionEnabled() && intValue != -1 && singleManuallyExposedAbTestGroup.getTestGroup().isInTest()) {
            SelectedDialogLocalInteractorImpl selectedDialogLocalInteractorImpl = new SelectedDialogLocalInteractorImpl(arguments.getVariants(), new Function0<Unit>(singleManuallyExposedAbTestGroup) { // from class: com.avito.android.select.bottom_sheet.di.SelectBottomSheetModule.a
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    ((SingleManuallyExposedAbTestGroup) this.receiver).exposeIfNeeded();
                    return Unit.INSTANCE;
                }
            });
            if (singleManuallyExposedAbTestGroup.getTestGroup() == AutoBrandModelTypoCorrectionTestGroup.CONTROL) {
                return selectedDialogLocalInteractorImpl;
            }
            SelectedDialogRemoteInteractorImpl selectedDialogRemoteInteractorImpl = new SelectedDialogRemoteInteractorImpl(selectedDialogLocalInteractorImpl, arguments.getVariants(), searchApi, intValue, new Function0<Unit>(singleManuallyExposedAbTestGroup) { // from class: com.avito.android.select.bottom_sheet.di.SelectBottomSheetModule.b
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    ((SingleManuallyExposedAbTestGroup) this.receiver).exposeIfNeeded();
                    return Unit.INSTANCE;
                }
            });
            if (singleManuallyExposedAbTestGroup.getTestGroup() == AutoBrandModelTypoCorrectionTestGroup.LOCAL_SEARCH_WITH_DELAY) {
                return new SelectDialogLocalWithDelayInteractorImpl(selectedDialogLocalInteractorImpl, selectedDialogRemoteInteractorImpl);
            }
            if (singleManuallyExposedAbTestGroup.getTestGroup() == AutoBrandModelTypoCorrectionTestGroup.TYPO_CORRECTION) {
                return selectedDialogRemoteInteractorImpl;
            }
        }
        return new SelectedDialogLocalInteractorImpl(arguments.getVariants(), null, 2, null);
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet$select_release(@NotNull CheckableItemPresenter checkableItemPresenter) {
        Intrinsics.checkNotNullParameter(checkableItemPresenter, "checkableItemPresenter");
        return x.setOf(checkableItemPresenter);
    }
}
