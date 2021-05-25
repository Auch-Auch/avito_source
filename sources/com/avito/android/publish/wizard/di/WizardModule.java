package com.avito.android.publish.wizard.di;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.CategoriesWizardScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.wizard.WizardInteractor;
import com.avito.android.publish.wizard.WizardInteractorImpl;
import com.avito.android.publish.wizard.WizardPresenter;
import com.avito.android.publish.wizard.WizardPresenterImpl;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTracker;
import com.avito.android.publish.wizard.analytics.CategoriesWizardTrackerImpl;
import com.avito.android.publish.wizard.blueprint.WizardItemBlueprint;
import com.avito.android.publish.wizard.blueprint.WizardItemBlueprintImpl;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenterImpl;
import com.avito.android.publish.wizard.remote.WizardApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.x;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001]B[\u0012\b\u0010D\u001a\u0004\u0018\u00010A\u0012\b\u0010Z\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010N\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010L\u001a\u00020I\u0012\b\b\u0002\u0010U\u001a\u00020R\u0012\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010=¢\u0006\u0004\b[\u0010\\J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJR\u0010\u001a\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0019\u0010\u0016\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014¢\u0006\u0002\b\u00150\u0013H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J*\u0010\u001d\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014¢\u0006\u0002\b\u00150\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010(\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u0017\u0010+\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b)\u0010*J\u000f\u0010.\u001a\u00020\u001bH\u0001¢\u0006\u0004\b,\u0010-J\u001f\u00104\u001a\u0002032\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b4\u00105J\u001f\u00109\u001a\u0002062\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020:2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010?¨\u0006^"}, d2 = {"Lcom/avito/android/publish/wizard/di/WizardModule;", "", "Lcom/avito/android/publish/wizard/remote/WizardApi;", "api", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/wizard/WizardInteractor;", "provideWizardInteractor$publish_release", "(Lcom/avito/android/publish/wizard/remote/WizardApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)Lcom/avito/android/publish/wizard/WizardInteractor;", "provideWizardInteractor", "interactor", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "tracker", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "Lcom/avito/android/publish/wizard/WizardPresenter;", "provideWizardPresenter$publish_release", "(Lcom/avito/android/publish/wizard/WizardInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;Ljava/util/Set;)Lcom/avito/android/publish/wizard/WizardPresenter;", "provideWizardPresenter", "Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;", "wizardItemPresenter", "provideItemPresentersSet", "(Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;)Ljava/util/Set;", "Lcom/avito/konveyor/ItemBinder;", GeoContract.PROVIDER, "provideAdapterPresenter$publish_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/publish/wizard/blueprint/WizardItemBlueprint;", "wizardItemBluePrint", "provideVHFactory$publish_release", "(Lcom/avito/android/publish/wizard/blueprint/WizardItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideVHFactory", "provideWizardItemBlueprint$publish_release", "(Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;)Lcom/avito/android/publish/wizard/blueprint/WizardItemBlueprint;", "provideWizardItemBlueprint", "provideWizardItemPresenter$publish_release", "()Lcom/avito/android/publish/wizard/blueprint/WizardItemPresenter;", "provideWizardItemPresenter", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$publish_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "", "h", "Ljava/lang/String;", "stepId", "Landroid/os/Bundle;", AuthSource.SEND_ABUSE, "Landroid/os/Bundle;", "presenterState", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "resources", "", "e", "Z", "showAlwaysArrow", "", "Lcom/avito/android/remote/model/Navigation;", g.a, "Ljava/util/List;", "leaves", "", "f", "I", "wizardRootLevel", "c", "Lcom/avito/android/remote/model/Navigation;", "navigation", AuthSource.BOOKING_ORDER, "itemId", "<init>", "(Landroid/os/Bundle;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Landroid/content/res/Resources;ZILjava/util/List;Ljava/lang/String;)V", "Dependencies", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class WizardModule {
    public final Bundle a;
    public final String b;
    public final Navigation c;
    public final Resources d;
    public final boolean e;
    public final int f;
    public final List<Navigation> g;
    public final String h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/wizard/di/WizardModule$Dependencies;", "", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTrackerImpl;", "tracker", "Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "bindTracker", "(Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTrackerImpl;)Lcom/avito/android/publish/wizard/analytics/CategoriesWizardTracker;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        CategoriesWizardTracker bindTracker(@NotNull CategoriesWizardTrackerImpl categoriesWizardTrackerImpl);
    }

    public WizardModule(@Nullable Bundle bundle, @Nullable String str, @Nullable Navigation navigation, @NotNull Resources resources, boolean z, int i, @NotNull List<Navigation> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(list, "leaves");
        this.a = bundle;
        this.b = str;
        this.c = navigation;
        this.d = resources;
        this.e = z;
        this.f = i;
        this.g = list;
        this.h = str2;
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$publish_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, GeoContract.PROVIDER, itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull WizardItemPresenter wizardItemPresenter) {
        Intrinsics.checkNotNullParameter(wizardItemPresenter, "wizardItemPresenter");
        return x.setOf(wizardItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideVHFactory$publish_release(@NotNull WizardItemBlueprint wizardItemBlueprint) {
        Intrinsics.checkNotNullParameter(wizardItemBlueprint, "wizardItemBluePrint");
        return new ItemBinder.Builder().registerItem(wizardItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final WizardInteractor provideWizardInteractor$publish_release(@NotNull WizardApi wizardApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(wizardApi, "api");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        return new WizardInteractorImpl(wizardApi, this.b, this.c, this.g, new CategoryParametersConverter(null, null, null, 7, null), this.h, publishAnalyticsDataProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final WizardItemBlueprint provideWizardItemBlueprint$publish_release(@NotNull WizardItemPresenter wizardItemPresenter) {
        Intrinsics.checkNotNullParameter(wizardItemPresenter, "wizardItemPresenter");
        return new WizardItemBlueprintImpl(wizardItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final WizardItemPresenter provideWizardItemPresenter$publish_release() {
        return new WizardItemPresenterImpl();
    }

    @Provides
    @NotNull
    @PerFragment
    public final WizardPresenter provideWizardPresenter$publish_release(@NotNull WizardInteractor wizardInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @NotNull CategoriesWizardTracker categoriesWizardTracker, @NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(wizardInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(categoriesWizardTracker, "tracker");
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        WizardPresenterImpl wizardPresenterImpl = new WizardPresenterImpl(this.b, wizardInteractor, adapterPresenter, schedulersFactory, new ErrorFormatterImpl(this.d), this.d, analytics, categoriesWizardTracker, this.e, this.f, this.c, set);
        wizardPresenterImpl.onRestoreState(this.a);
        return wizardPresenterImpl;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$publish_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, CategoriesWizardScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(CategoriesWizardScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, CategoriesWizardScreen.INSTANCE, timerFactory, null, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WizardModule(Bundle bundle, String str, Navigation navigation, Resources resources, boolean z, int i, List list, String str2, int i2, j jVar) {
        this(bundle, str, (i2 & 4) != 0 ? null : navigation, resources, z, (i2 & 32) != 0 ? 0 : i, list, (i2 & 128) != 0 ? null : str2);
    }
}
