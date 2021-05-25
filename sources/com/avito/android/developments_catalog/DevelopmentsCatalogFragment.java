package com.avito.android.developments_catalog;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.developments_catalog.di.DaggerDevelopmentsCatalogComponent;
import com.avito.android.developments_catalog.di.DevelopmentsCatalogComponent;
import com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies;
import com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressPresenter;
import com.avito.android.developments_catalog.items.consultation.ConsultationPresenter;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryPresenter;
import com.avito.android.developments_catalog.tracker.DevelopmentsCatalogTracker;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Constants;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ³\u00012\u00020\u00012\u00020\u0002:\u0002³\u0001B\b¢\u0006\u0005\b²\u0001\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u0019\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J)\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\"H\u0016¢\u0006\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001a\u00020r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010z\u001a\u00020y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0014@\u0014X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R*\u0010¥\u0001\u001a\u00030¤\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R*\u0010¬\u0001\u001a\u00030«\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¬\u0001\u0010­\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001¨\u0006´\u0001"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentDelegate;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onResume", "onPause", "onStop", "onDestroy", "outState", "onSaveInstanceState", "closeScreen", "Landroid/content/Intent;", "intent", "launchActivity", "(Landroid/content/Intent;)V", "", "requestId", "launchActivityForResult", "(Landroid/content/Intent;I)V", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "stringId", "launchToast", "(I)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "j", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "developmentsCatalogView", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "getAnalyticsInteractor", "()Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "setAnalyticsInteractor", "(Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;)V", "Lcom/avito/android/util/Formatter;", "", "phoneNumberFormatter", "Lcom/avito/android/util/Formatter;", "getPhoneNumberFormatter", "()Lcom/avito/android/util/Formatter;", "setPhoneNumberFormatter", "(Lcom/avito/android/util/Formatter;)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "k", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "developmentsCatalogRouter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/android/recycler/base/SafeRecyclerAdapter;)V", "Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressPresenter;", "buildingProgressPresenter", "Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressPresenter;", "getBuildingProgressPresenter", "()Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressPresenter;", "setBuildingProgressPresenter", "(Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "presenter", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "getPresenter", "()Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "setPresenter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getDestroyableViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setDestroyableViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationPresenter;", "consultationFormPreseter", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationPresenter;", "getConsultationFormPreseter", "()Lcom/avito/android/developments_catalog/items/consultation/ConsultationPresenter;", "setConsultationFormPreseter", "(Lcom/avito/android/developments_catalog/items/consultation/ConsultationPresenter;)V", "Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTracker;", "tracker", "Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTracker;", "getTracker", "()Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTracker;", "setTracker", "(Lcom/avito/android/developments_catalog/tracker/DevelopmentsCatalogTracker;)V", "Lcom/avito/android/advert_core/map/MapPresenter;", "googlMapPresenter", "Lcom/avito/android/advert_core/map/MapPresenter;", "getGooglMapPresenter", "()Lcom/avito/android/advert_core/map/MapPresenter;", "setGooglMapPresenter", "(Lcom/avito/android/advert_core/map/MapPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "l", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenter;", "photoGalleryPresenter", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenter;", "getPhotoGalleryPresenter", "()Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenter;", "setPhotoGalleryPresenter", "(Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "<init>", "Companion", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogFragment extends TabBaseFragment implements DevelopmentsCatalogFragmentDelegate {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public DevelopmentsCatalogAnalyticsInteractor analyticsInteractor;
    @Inject
    public BuildingProgressPresenter buildingProgressPresenter;
    @Inject
    public ConsultationPresenter consultationFormPreseter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DestroyableViewHolderBuilder destroyableViewHolderBuilder;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public Features features;
    @Inject
    public MapPresenter googlMapPresenter;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public DevelopmentsCatalogView j;
    public DevelopmentsCatalogRouter k;
    @NotNull
    public NavigationState l = new NavigationState(false);
    @Inject
    public Formatter<String> phoneNumberFormatter;
    @Inject
    public PhotoGalleryPresenter photoGalleryPresenter;
    @Inject
    public DevelopmentsCatalogPresenter presenter;
    @Inject
    public SafeRecyclerAdapter recyclerAdapter;
    @Inject
    public DevelopmentsCatalogTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragment$Companion;", "", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogArguments;", "arguments", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragment;", "newInstance", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogArguments;)Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragment;", "<init>", "()V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ DevelopmentsCatalogArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(DevelopmentsCatalogArguments developmentsCatalogArguments) {
                super(1);
                this.a = developmentsCatalogArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("developments_catalog_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final DevelopmentsCatalogFragment newInstance(@NotNull DevelopmentsCatalogArguments developmentsCatalogArguments) {
            Intrinsics.checkNotNullParameter(developmentsCatalogArguments, "arguments");
            return (DevelopmentsCatalogFragment) FragmentsKt.arguments$default(new DevelopmentsCatalogFragment(), 0, new a(developmentsCatalogArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate
    @NotNull
    public FragmentManager childFragmentManager() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogFragmentDelegate
    public void closeScreen() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getDevelopmentsCatalogWithoutActivity().invoke().booleanValue() || (getActivity() instanceof DevelopmentsCatalogActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        finish();
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final DevelopmentsCatalogAnalyticsInteractor getAnalyticsInteractor() {
        DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor = this.analyticsInteractor;
        if (developmentsCatalogAnalyticsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
        }
        return developmentsCatalogAnalyticsInteractor;
    }

    @NotNull
    public final BuildingProgressPresenter getBuildingProgressPresenter() {
        BuildingProgressPresenter buildingProgressPresenter2 = this.buildingProgressPresenter;
        if (buildingProgressPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildingProgressPresenter");
        }
        return buildingProgressPresenter2;
    }

    @NotNull
    public final ConsultationPresenter getConsultationFormPreseter() {
        ConsultationPresenter consultationPresenter = this.consultationFormPreseter;
        if (consultationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultationFormPreseter");
        }
        return consultationPresenter;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getDestroyableViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        return destroyableViewHolderBuilder2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final MapPresenter getGooglMapPresenter() {
        MapPresenter mapPresenter = this.googlMapPresenter;
        if (mapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googlMapPresenter");
        }
        return mapPresenter;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.l;
    }

    @NotNull
    public final Formatter<String> getPhoneNumberFormatter() {
        Formatter<String> formatter = this.phoneNumberFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
        }
        return formatter;
    }

    @NotNull
    public final PhotoGalleryPresenter getPhotoGalleryPresenter() {
        PhotoGalleryPresenter photoGalleryPresenter2 = this.photoGalleryPresenter;
        if (photoGalleryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoGalleryPresenter");
        }
        return photoGalleryPresenter2;
    }

    @NotNull
    public final DevelopmentsCatalogPresenter getPresenter() {
        DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
        if (developmentsCatalogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return developmentsCatalogPresenter;
    }

    @NotNull
    public final SafeRecyclerAdapter getRecyclerAdapter() {
        SafeRecyclerAdapter safeRecyclerAdapter = this.recyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return safeRecyclerAdapter;
    }

    @NotNull
    public final DevelopmentsCatalogTracker getTracker() {
        DevelopmentsCatalogTracker developmentsCatalogTracker = this.tracker;
        if (developmentsCatalogTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return developmentsCatalogTracker;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogFragmentDelegate
    public void launchActivity(@Nullable Intent intent) {
        startActivity(intent);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogFragmentDelegate
    public void launchActivityForResult(@Nullable Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogFragmentDelegate
    public void launchToast(int i) {
        Context context = getContext();
        if (context != null) {
            ToastsKt.showToast(context, i, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            View view = getView();
            if (view != null) {
                Keyboards.hideKeyboardWithAttempt$default(view, 0, 0, 3, null);
            }
        } else if (i == 2 && intent != null) {
            int intExtra = intent.getIntExtra(Constants.IMAGE_POSITION, 0);
            long longExtra = intent.getLongExtra(Constants.PHOTO_GALLERY_STATE_ID, -1);
            if (longExtra > -1) {
                DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
                if (developmentsCatalogPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                developmentsCatalogPresenter.onPageSelected(intExtra, longExtra);
            }
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!features().getDevelopmentsCatalogWithoutActivity().invoke().booleanValue() && bundle != null) {
            DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
            if (developmentsCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            developmentsCatalogPresenter.restoreState(bundle.getBundle("developmentsCatalogPresenter"));
        }
        if (this.k == null) {
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
            if (implicitIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
            }
            DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor = this.analyticsInteractor;
            if (developmentsCatalogAnalyticsInteractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsInteractor");
            }
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            this.k = new DevelopmentsCatalogRouterImpl(deepLinkIntentFactory2, activityIntentFactory2, implicitIntentFactory2, developmentsCatalogAnalyticsInteractor, resources, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (features().getDevelopmentsCatalogWithoutActivity().invoke().booleanValue()) {
            DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
            if (developmentsCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Bundle retainStorage = retainStorage();
            developmentsCatalogPresenter.restoreState(retainStorage != null ? retainStorage.getBundle("developmentsCatalogPresenter") : null);
        }
        return layoutInflater.inflate(R.layout.fragment_developments_catalog, viewGroup, false);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder2 = this.destroyableViewHolderBuilder;
        if (destroyableViewHolderBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destroyableViewHolderBuilder");
        }
        destroyableViewHolderBuilder2.destroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        DevelopmentsCatalogTracker developmentsCatalogTracker = this.tracker;
        if (developmentsCatalogTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        developmentsCatalogTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        DevelopmentsCatalogTracker developmentsCatalogTracker = this.tracker;
        if (developmentsCatalogTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        developmentsCatalogTracker.attach();
        super.onResume();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getDevelopmentsCatalogWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
            if (developmentsCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            bundle2.putBundle("developmentsCatalogPresenter", developmentsCatalogPresenter.saveState());
            Unit unit = Unit.INSTANCE;
            saveInRetainStorage(bundle2);
            return;
        }
        DevelopmentsCatalogPresenter developmentsCatalogPresenter2 = this.presenter;
        if (developmentsCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("developmentsCatalogPresenter", developmentsCatalogPresenter2.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DevelopmentsCatalogView developmentsCatalogView = this.j;
        if (developmentsCatalogView != null) {
            DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
            if (developmentsCatalogPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            developmentsCatalogPresenter.attachView(developmentsCatalogView);
        }
        DevelopmentsCatalogPresenter developmentsCatalogPresenter2 = this.presenter;
        if (developmentsCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        developmentsCatalogPresenter2.attachRouter(this.k);
        PhotoGalleryPresenter photoGalleryPresenter2 = this.photoGalleryPresenter;
        if (photoGalleryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoGalleryPresenter");
        }
        photoGalleryPresenter2.attachRouter(this.k);
        BuildingProgressPresenter buildingProgressPresenter2 = this.buildingProgressPresenter;
        if (buildingProgressPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildingProgressPresenter");
        }
        buildingProgressPresenter2.attachRouter(this.k);
        MapPresenter mapPresenter = this.googlMapPresenter;
        if (mapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googlMapPresenter");
        }
        mapPresenter.attachRouter(this.k);
        ConsultationPresenter consultationPresenter = this.consultationFormPreseter;
        if (consultationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultationFormPreseter");
        }
        consultationPresenter.attachRouter(this.k);
        DevelopmentsCatalogPresenter developmentsCatalogPresenter3 = this.presenter;
        if (developmentsCatalogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        developmentsCatalogPresenter3.startLoadingData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
        if (developmentsCatalogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        developmentsCatalogPresenter.detachRouter();
        PhotoGalleryPresenter photoGalleryPresenter2 = this.photoGalleryPresenter;
        if (photoGalleryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoGalleryPresenter");
        }
        photoGalleryPresenter2.detachRouter();
        BuildingProgressPresenter buildingProgressPresenter2 = this.buildingProgressPresenter;
        if (buildingProgressPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildingProgressPresenter");
        }
        buildingProgressPresenter2.detachRouter();
        MapPresenter mapPresenter = this.googlMapPresenter;
        if (mapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googlMapPresenter");
        }
        mapPresenter.detachRouter();
        ConsultationPresenter consultationPresenter = this.consultationFormPreseter;
        if (consultationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultationFormPreseter");
        }
        consultationPresenter.detachRouter();
        DevelopmentsCatalogPresenter developmentsCatalogPresenter2 = this.presenter;
        if (developmentsCatalogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        developmentsCatalogPresenter2.detachView();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DevelopmentsCatalogRouter developmentsCatalogRouter = this.k;
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SafeRecyclerAdapter safeRecyclerAdapter = this.recyclerAdapter;
        if (safeRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        Formatter<String> formatter = this.phoneNumberFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
        }
        DevelopmentsCatalogPresenter developmentsCatalogPresenter = this.presenter;
        if (developmentsCatalogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        this.j = new DevelopmentsCatalogViewImpl(view, developmentsCatalogRouter, dialogRouter2, adapterPresenter2, safeRecyclerAdapter, formatter, developmentsCatalogPresenter);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalyticsInteractor(@NotNull DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(developmentsCatalogAnalyticsInteractor, "<set-?>");
        this.analyticsInteractor = developmentsCatalogAnalyticsInteractor;
    }

    public final void setBuildingProgressPresenter(@NotNull BuildingProgressPresenter buildingProgressPresenter2) {
        Intrinsics.checkNotNullParameter(buildingProgressPresenter2, "<set-?>");
        this.buildingProgressPresenter = buildingProgressPresenter2;
    }

    public final void setConsultationFormPreseter(@NotNull ConsultationPresenter consultationPresenter) {
        Intrinsics.checkNotNullParameter(consultationPresenter, "<set-?>");
        this.consultationFormPreseter = consultationPresenter;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDestroyableViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder2) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder2, "<set-?>");
        this.destroyableViewHolderBuilder = destroyableViewHolderBuilder2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setGooglMapPresenter(@NotNull MapPresenter mapPresenter) {
        Intrinsics.checkNotNullParameter(mapPresenter, "<set-?>");
        this.googlMapPresenter = mapPresenter;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.l = navigationState;
    }

    public final void setPhoneNumberFormatter(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.phoneNumberFormatter = formatter;
    }

    public final void setPhotoGalleryPresenter(@NotNull PhotoGalleryPresenter photoGalleryPresenter2) {
        Intrinsics.checkNotNullParameter(photoGalleryPresenter2, "<set-?>");
        this.photoGalleryPresenter = photoGalleryPresenter2;
    }

    public final void setPresenter(@NotNull DevelopmentsCatalogPresenter developmentsCatalogPresenter) {
        Intrinsics.checkNotNullParameter(developmentsCatalogPresenter, "<set-?>");
        this.presenter = developmentsCatalogPresenter;
    }

    public final void setRecyclerAdapter(@NotNull SafeRecyclerAdapter safeRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = safeRecyclerAdapter;
    }

    public final void setTracker(@NotNull DevelopmentsCatalogTracker developmentsCatalogTracker) {
        Intrinsics.checkNotNullParameter(developmentsCatalogTracker, "<set-?>");
        this.tracker = developmentsCatalogTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: return false");
        DevelopmentsCatalogArguments developmentsCatalogArguments = (DevelopmentsCatalogArguments) arguments.getParcelable("developments_catalog_arguments");
        if (developmentsCatalogArguments != null) {
            DevelopmentsCatalogComponent.Builder withDevelopmentsId = DaggerDevelopmentsCatalogComponent.builder().developmentsCatalogDependencies((DevelopmentsCatalogDependencies) ComponentDependenciesKt.getDependencies(DevelopmentsCatalogDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withDevelopmentsId(developmentsCatalogArguments.getDevelopmentsId());
            String developmentsTitle = developmentsCatalogArguments.getDevelopmentsTitle();
            if (developmentsTitle == null) {
                developmentsTitle = "";
            }
            DevelopmentsCatalogComponent.Builder withFromPage = withDevelopmentsId.withDevelopmentsTitle(developmentsTitle).withSearchContext(developmentsCatalogArguments.getSearchContext()).withFromPage(developmentsCatalogArguments.getFromPage());
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            DevelopmentsCatalogComponent.Builder withFragmentManagerDelegate = withFromPage.withActivity(requireActivity).withFragmentManagerDelegate(this);
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            withFragmentManagerDelegate.withActivity(requireActivity2).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("DevelopmentsCatalogArguments must be specified");
    }
}
