package com.avito.android.select.di;

import com.avito.android.ab_tests.AutoBrandModelTypoCorrection;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.SearchApi;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectDialogBlueprintProvider;
import com.avito.android.select.SelectDialogInteractor;
import com.avito.android.select.SelectDialogLocalWithDelayInteractorImpl;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogPresenterResourceProvider;
import com.avito.android.select.SelectedDialogLocalInteractorImpl;
import com.avito.android.select.SelectedDialogRemoteInteractorImpl;
import com.avito.android.select.VariantCheckableItemBlueprint;
import com.avito.android.select.VariantCheckableItemBlueprintImpl;
import com.avito.android.select.VariantItemCheckBoxBlueprint;
import com.avito.android.select.VariantItemCheckBoxBlueprintImpl;
import com.avito.android.select.VariantItemImageBlueprint;
import com.avito.android.select.VariantItemImageBlueprintImpl;
import com.avito.android.select.VariantItemPresenter;
import com.avito.android.select.VariantItemPresenterImpl;
import com.avito.android.select.VariantItemRadioButtonBlueprint;
import com.avito.android.select.VariantItemRadioButtonBlueprintImpl;
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
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b+\u0010,J/\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010$\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\"\u0010#J\"\u0010*\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030&¢\u0006\u0002\b'0%H\u0001¢\u0006\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/select/di/SelectDialogModule;", "", "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/select/Arguments;", "arguments", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AutoBrandModelTypoCorrectionTestGroup;", "abTestGroup", "Lcom/avito/android/select/SelectDialogInteractor;", "provideSelectDialogInteractor$select_release", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/select/Arguments;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)Lcom/avito/android/select/SelectDialogInteractor;", "provideSelectDialogInteractor", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$select_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/select/SelectDialogBlueprintProvider;", "itemBlueprintProvider", "Lcom/avito/android/select/title/TitleItemViewBlueprint;", "titleItemViewBlueprint", "provideItemBinder$select_release", "(Lcom/avito/android/select/SelectDialogBlueprintProvider;Lcom/avito/android/select/title/TitleItemViewBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/select/VariantItemRadioButtonBlueprint;", "radioButtonBlueprint", "Lcom/avito/android/select/VariantItemCheckBoxBlueprint;", "checkBoxBlueprint", "Lcom/avito/android/select/VariantCheckableItemBlueprint;", "checkableItemBlueprint", "Lcom/avito/android/select/VariantItemImageBlueprint;", "imageBlueprint", "provideSelectDialogBlueprintProvider$select_release", "(Lcom/avito/android/select/VariantItemRadioButtonBlueprint;Lcom/avito/android/select/VariantItemCheckBoxBlueprint;Lcom/avito/android/select/VariantCheckableItemBlueprint;Lcom/avito/android/select/VariantItemImageBlueprint;Lcom/avito/android/select/Arguments;)Lcom/avito/android/select/SelectDialogBlueprintProvider;", "provideSelectDialogBlueprintProvider", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideItemPresentersSet$select_release", "()Ljava/util/Set;", "provideItemPresentersSet", "<init>", "()V", "Declarations", "select_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SelectDialogModule {
    @NotNull
    public static final SelectDialogModule INSTANCE = new SelectDialogModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020(H'¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/select/di/SelectDialogModule$Declarations;", "", "Lcom/avito/android/select/SelectDialogPresenterImpl;", "presenter", "Lcom/avito/android/select/SelectDialogPresenter;", "bindSelectDialogPresenter", "(Lcom/avito/android/select/SelectDialogPresenterImpl;)Lcom/avito/android/select/SelectDialogPresenter;", "Lcom/avito/android/select/SelectDialogPresenterResourceProvider;", GeoContract.PROVIDER, "Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "bindSelectDialogPresenterResourceProvider", "(Lcom/avito/android/select/SelectDialogPresenterResourceProvider;)Lcom/avito/android/select/SelectDialogPresenter$ResourceProvider;", "Lcom/avito/android/select/VariantItemCheckBoxBlueprintImpl;", "blueprint", "Lcom/avito/android/select/VariantItemCheckBoxBlueprint;", "bindVariantItemCheckBoxBlueprint", "(Lcom/avito/android/select/VariantItemCheckBoxBlueprintImpl;)Lcom/avito/android/select/VariantItemCheckBoxBlueprint;", "Lcom/avito/android/select/VariantItemRadioButtonBlueprintImpl;", "Lcom/avito/android/select/VariantItemRadioButtonBlueprint;", "bindVariantItemRadioButtonBlueprint", "(Lcom/avito/android/select/VariantItemRadioButtonBlueprintImpl;)Lcom/avito/android/select/VariantItemRadioButtonBlueprint;", "Lcom/avito/android/select/VariantCheckableItemBlueprintImpl;", "Lcom/avito/android/select/VariantCheckableItemBlueprint;", "bindVariantCheckableItemBlueprint", "(Lcom/avito/android/select/VariantCheckableItemBlueprintImpl;)Lcom/avito/android/select/VariantCheckableItemBlueprint;", "Lcom/avito/android/select/VariantItemPresenterImpl;", "Lcom/avito/android/select/VariantItemPresenter;", "bindVariantItemPresenter", "(Lcom/avito/android/select/VariantItemPresenterImpl;)Lcom/avito/android/select/VariantItemPresenter;", "Lcom/avito/android/select/title/TitleItemViewBlueprintImpl;", "Lcom/avito/android/select/title/TitleItemViewBlueprint;", "bindTitleItemViewBlueprint", "(Lcom/avito/android/select/title/TitleItemViewBlueprintImpl;)Lcom/avito/android/select/title/TitleItemViewBlueprint;", "Lcom/avito/android/select/title/TitleItemPresenterImpl;", "Lcom/avito/android/select/title/TitleItemPresenter;", "bindTitleItemPresenter", "(Lcom/avito/android/select/title/TitleItemPresenterImpl;)Lcom/avito/android/select/title/TitleItemPresenter;", "Lcom/avito/android/select/VariantItemPresenter$Listener;", "bindVariantItemPresenterListener", "(Lcom/avito/android/select/SelectDialogPresenter;)Lcom/avito/android/select/VariantItemPresenter$Listener;", "Lcom/avito/android/select/VariantItemImageBlueprintImpl;", "Lcom/avito/android/select/VariantItemImageBlueprint;", "bindVariantItemImageBlueprint", "(Lcom/avito/android/select/VariantItemImageBlueprintImpl;)Lcom/avito/android/select/VariantItemImageBlueprint;", "select_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
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

        @PerFragment
        @Binds
        @NotNull
        VariantCheckableItemBlueprint bindVariantCheckableItemBlueprint(@NotNull VariantCheckableItemBlueprintImpl variantCheckableItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        VariantItemCheckBoxBlueprint bindVariantItemCheckBoxBlueprint(@NotNull VariantItemCheckBoxBlueprintImpl variantItemCheckBoxBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        VariantItemImageBlueprint bindVariantItemImageBlueprint(@NotNull VariantItemImageBlueprintImpl variantItemImageBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        VariantItemPresenter bindVariantItemPresenter(@NotNull VariantItemPresenterImpl variantItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        VariantItemPresenter.Listener bindVariantItemPresenterListener(@NotNull SelectDialogPresenter selectDialogPresenter);

        @PerFragment
        @Binds
        @NotNull
        VariantItemRadioButtonBlueprint bindVariantItemRadioButtonBlueprint(@NotNull VariantItemRadioButtonBlueprintImpl variantItemRadioButtonBlueprintImpl);
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
    public static final ItemBinder provideItemBinder$select_release(@NotNull SelectDialogBlueprintProvider selectDialogBlueprintProvider, @NotNull TitleItemViewBlueprint titleItemViewBlueprint) {
        Intrinsics.checkNotNullParameter(selectDialogBlueprintProvider, "itemBlueprintProvider");
        Intrinsics.checkNotNullParameter(titleItemViewBlueprint, "titleItemViewBlueprint");
        return new ItemBinder.Builder().registerItem(selectDialogBlueprintProvider.provide()).registerItem(titleItemViewBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectDialogBlueprintProvider provideSelectDialogBlueprintProvider$select_release(@NotNull VariantItemRadioButtonBlueprint variantItemRadioButtonBlueprint, @NotNull VariantItemCheckBoxBlueprint variantItemCheckBoxBlueprint, @NotNull VariantCheckableItemBlueprint variantCheckableItemBlueprint, @NotNull VariantItemImageBlueprint variantItemImageBlueprint, @NotNull Arguments arguments) {
        Intrinsics.checkNotNullParameter(variantItemRadioButtonBlueprint, "radioButtonBlueprint");
        Intrinsics.checkNotNullParameter(variantItemCheckBoxBlueprint, "checkBoxBlueprint");
        Intrinsics.checkNotNullParameter(variantCheckableItemBlueprint, "checkableItemBlueprint");
        Intrinsics.checkNotNullParameter(variantItemImageBlueprint, "imageBlueprint");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return new SelectDialogBlueprintProvider(arguments.getMultiSelect(), arguments.isRedesign(), arguments.getWithImages(), variantCheckableItemBlueprint, variantItemCheckBoxBlueprint, variantItemRadioButtonBlueprint, variantItemImageBlueprint);
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
            SelectedDialogLocalInteractorImpl selectedDialogLocalInteractorImpl = new SelectedDialogLocalInteractorImpl(arguments.getVariants(), new Function0<Unit>(singleManuallyExposedAbTestGroup) { // from class: com.avito.android.select.di.SelectDialogModule.a
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
            SelectedDialogRemoteInteractorImpl selectedDialogRemoteInteractorImpl = new SelectedDialogRemoteInteractorImpl(selectedDialogLocalInteractorImpl, arguments.getVariants(), searchApi, intValue, new Function0<Unit>(singleManuallyExposedAbTestGroup) { // from class: com.avito.android.select.di.SelectDialogModule.b
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
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet$select_release() {
        return y.emptySet();
    }
}
