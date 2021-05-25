package com.avito.android.publish;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.app.di.HasActivityComponent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DraftRefreshLink;
import com.avito.android.deep_linking.links.PaidServicesLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.dialog.DialogWithDeeplinkActionsKt;
import com.avito.android.dialog.DialogWithDeeplinkActionsRouter;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.events.PublicationDoneSuccessful;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsRouter;
import com.avito.android.publish.details.PublishDetailsFragment;
import com.avito.android.publish.details.PublishDetailsRouter;
import com.avito.android.publish.di.DaggerPublishComponent;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.di.PublishModule;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestFragmentKt;
import com.avito.android.publish.infomodel_request.InfomodelRequestFragment;
import com.avito.android.publish.input_vin.InputVinFragmentKt;
import com.avito.android.publish.input_vin.InputVinRouter;
import com.avito.android.publish.premoderation.PremoderationRequestFragmentKt;
import com.avito.android.publish.premoderation.WrongCategoryRouter;
import com.avito.android.publish.pretend.PretendFragmentKt;
import com.avito.android.publish.publish_advert_request.PublishAdvertRequestFragmentKt;
import com.avito.android.publish.select.SelectFragmentKt;
import com.avito.android.publish.sts_scanner.StsScannerFragment;
import com.avito.android.publish.sts_scanner.StsScannerFragmentKt;
import com.avito.android.publish.sts_scanner.StsScannerRouter;
import com.avito.android.publish.wizard.WizardFragmentKt;
import com.avito.android.publish.wizard.WizardRouter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoryModel;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.Constants;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\b\u0012\u0004\u0012\u00020\u000b0\nB\b¢\u0006\u0005\b±\u0001\u0010\u0012J\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0014\u0010\u0012J)\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001d\u0010\u0010J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010\u0012J)\u0010)\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010$2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0015H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010\u0012J\u000f\u00101\u001a\u00020\u000eH\u0016¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\u000eH\u0016¢\u0006\u0004\b2\u0010\u0012J\u000f\u00103\u001a\u00020\u000eH\u0016¢\u0006\u0004\b3\u0010\u0012J\u000f\u00104\u001a\u00020\u000eH\u0016¢\u0006\u0004\b4\u0010\u0012J\u0019\u00107\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000eH\u0016¢\u0006\u0004\b9\u0010\u0012J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0012J\u0017\u0010:\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b:\u0010<J\u000f\u0010=\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010\u0012J\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u000eH\u0016¢\u0006\u0004\bB\u0010\u0012J\u000f\u0010C\u001a\u00020\u000eH\u0016¢\u0006\u0004\bC\u0010\u0012J\u000f\u0010D\u001a\u00020\u000bH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u000eH\u0002¢\u0006\u0004\bF\u0010\u0012J\u0017\u0010I\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ#\u0010M\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020G2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\"\u0010z\u001a\u00020y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010¥\u0001\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R*\u0010«\u0001\u001a\u00030ª\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001¨\u0006²\u0001"}, d2 = {"Lcom/avito/android/publish/PublishActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/publish/wizard/WizardRouter;", "Lcom/avito/android/publish/input_vin/InputVinRouter;", "Lcom/avito/android/publish/sts_scanner/StsScannerRouter;", "Lcom/avito/android/publish/premoderation/WrongCategoryRouter;", "Lcom/avito/android/publish/details/PublishDetailsRouter;", "Lcom/avito/android/publish/SubmissionPresenter$Router;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsRouter;", "Lcom/avito/android/dialog/DialogWithDeeplinkActionsRouter;", "Lcom/avito/android/app/di/HasActivityComponent;", "Lcom/avito/android/publish/di/PublishComponent;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onDialogDismiss", "onBackPressed", "", BookingInfoActivity.EXTRA_ITEM_ID, "statusMessage", "", "isPublishSuccessful", "showItemScreen", "(Ljava/lang/String;Ljava/lang/String;Z)V", "showListingFeesScreen", "(Ljava/lang/String;)V", "stepIndex", "scanVinFromSts", "(I)V", "saveDraftAndExitPublishing", "backFromStsScanner", "popStsScannerFromBackstack", "showStsRecognitionErrorDialog", "skipWrongCategory", "Lcom/avito/android/remote/model/CategoryModel;", "newCategory", "changeWrongCategory", "(Lcom/avito/android/remote/model/CategoryModel;)V", "closeWrongCategory", "leavePublish", "intent", "(Landroid/content/Intent;)V", "leaveWizard", "Lcom/avito/android/remote/model/WizardParameter;", "wizardParameter", "onParameterSelected", "(Lcom/avito/android/remote/model/WizardParameter;)V", "showEditWizard", "navigateToAuth", "getActivityComponent", "()Lcom/avito/android/publish/di/PublishComponent;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "stepFragment", "c", "(Landroidx/fragment/app/Fragment;)V", "fragment", "tag", AuthSource.BOOKING_ORDER, "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "n", "Z", "shouldSaveOnClose", "Lcom/avito/android/publish/SubmissionPresenter;", "presenter", "Lcom/avito/android/publish/SubmissionPresenter;", "getPresenter", "()Lcom/avito/android/publish/SubmissionPresenter;", "setPresenter", "(Lcom/avito/android/publish/SubmissionPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "getAbTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "setAbTestsConfigProvider", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "handler", "Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "photoPickerEventTracker", "Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "getPhotoPickerEventTracker", "()Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "setPhotoPickerEventTracker", "(Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$publish_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$publish_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "publishDraftDataHolder", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "getPublishDraftDataHolder", "()Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "setPublishDraftDataHolder", "(Lcom/avito/android/publish/drafts/PublishDraftDataHolder;)V", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "getAnalyticsData", "()Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "setAnalyticsData", "(Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/publish/PublishViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/PublishViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/PublishViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/PublishViewModelFactory;)V", "l", "Lcom/avito/android/publish/di/PublishComponent;", "publishComponent", "Lcom/avito/android/publish/PublishViewModel;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/publish/PublishViewModel;", "viewModel", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "getPublishEventTracker", "()Lcom/avito/android/publish/analytics/PublishEventTracker;", "setPublishEventTracker", "(Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishActivity extends BaseActivity implements WizardRouter, InputVinRouter, StsScannerRouter, WrongCategoryRouter, PublishDetailsRouter, SubmissionPresenter.Router, CategoriesSuggestionsRouter, DialogWithDeeplinkActionsRouter, HasActivityComponent<PublishComponent> {
    @Inject
    public AbTestsConfigProvider abTestsConfigProvider;
    @Inject
    public Analytics analytics;
    @Inject
    public PublishAnalyticsDataProvider analyticsData;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public Features features;
    @Inject
    public ActivityIntentFactory intentFactory;
    public final Handler k = new Handler();
    public PublishComponent l;
    public PublishViewModel m;
    public boolean n = true;
    @Inject
    public PhotoPickerOnPublishEventTracker photoPickerEventTracker;
    @Inject
    public SubmissionPresenter presenter;
    @Inject
    public PublishDraftDataHolder publishDraftDataHolder;
    @Inject
    public PublishEventTracker publishEventTracker;
    @Inject
    public PublishViewModelFactory viewModelFactory;

    public static final class a implements Runnable {
        public final /* synthetic */ PublishActivity a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Intent d;

        public a(PublishActivity publishActivity, int i, int i2, Intent intent) {
            this.a = publishActivity;
            this.b = i;
            this.c = i2;
            this.d = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SubmissionPresenter presenter = this.a.getPresenter();
            int i = this.b;
            int i2 = this.c;
            Intent intent = this.d;
            if (!presenter.onResult(i, i2, intent != null ? intent.getStringExtra("itemId") : null)) {
                PublishActivity.super.onActivityResult(this.b, this.c, this.d);
            }
        }
    }

    public static final class b<T> implements Observer<Unit> {
        public final /* synthetic */ PublishActivity a;

        public b(PublishActivity publishActivity) {
            this.a = publishActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            this.a.setTheme(R.style.Theme_Avito_Base_BlackMenu);
            this.a.applyNewImagesIfNecessary();
        }
    }

    public static final void access$cancelPublish(PublishActivity publishActivity) {
        publishActivity.setResult(0);
        publishActivity.a();
        PublishViewModel publishViewModel = publishActivity.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (!publishViewModel.isEditing()) {
            AbTestsConfigProvider abTestsConfigProvider2 = publishActivity.abTestsConfigProvider;
            if (abTestsConfigProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("abTestsConfigProvider");
            }
            if (abTestsConfigProvider2.draftsOnStartPublishSheet().getTestGroup().isTest()) {
                publishActivity.overridePendingTransition(0, R.anim.slide_out_publish);
            }
        }
    }

    public static final void access$goToEditAdvert(PublishActivity publishActivity) {
        Objects.requireNonNull(publishActivity);
        publishActivity.c(EditAdvertRequestFragmentKt.createEditAdvertFragment());
    }

    public static final void access$goToPublishAdvert(PublishActivity publishActivity) {
        PublishDraftDataHolder publishDraftDataHolder2 = publishActivity.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        publishActivity.c(PublishAdvertRequestFragmentKt.createPublishAdvertRequestFragment(publishDraftDataHolder2.getDraftId()));
    }

    public static final void access$handleUnexpectedError(PublishActivity publishActivity) {
        int i;
        SubmissionPresenter submissionPresenter = publishActivity.presenter;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        boolean saveDraftIfNeeded$default = SubmissionPresenter.DefaultImpls.saveDraftIfNeeded$default(submissionPresenter, false, 1, null);
        DialogRouter dialogRouter2 = publishActivity.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        String string = publishActivity.getString(R.string.unexpected_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.unexpected_error_title)");
        if (saveDraftIfNeeded$default) {
            i = R.string.unexpected_error_message_when_draft_saved;
        } else {
            i = R.string.unexpected_error_message;
        }
        String string2 = publishActivity.getString(i);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …          }\n            )");
        String string3 = publishActivity.getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(ui_R.string.close)");
        dialogRouter2.showSimpleNotifyingDialog(string, string2, string3, new a2.a.a.e2.a(publishActivity));
    }

    public static final boolean access$shouldTrackDraftResumed(PublishActivity publishActivity) {
        return publishActivity.getIntent().getBooleanExtra("should_track_draft_resume", false);
    }

    public static final void access$showPremoderationScreen(PublishActivity publishActivity) {
        Objects.requireNonNull(publishActivity);
        publishActivity.c(PremoderationRequestFragmentKt.createPremoderationRequestFragment());
    }

    public static final void access$showPretendScreen(PublishActivity publishActivity) {
        Objects.requireNonNull(publishActivity);
        publishActivity.c(PretendFragmentKt.createPretendFragment());
    }

    public static final void access$showPublishDetails(PublishActivity publishActivity, ScreenTransfer screenTransfer) {
        Objects.requireNonNull(publishActivity);
        PublishDetailsFragment.Companion companion = PublishDetailsFragment.Companion;
        PublishDraftDataHolder publishDraftDataHolder2 = publishActivity.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        String draftId = publishDraftDataHolder2.getDraftId();
        PublishViewModel publishViewModel = publishActivity.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishActivity.c(companion.newInstance(draftId, publishViewModel.isEditing(), screenTransfer));
    }

    public static final void access$showSelectScreen(PublishActivity publishActivity) {
        Objects.requireNonNull(publishActivity);
        publishActivity.c(SelectFragmentKt.createSelectFragment());
    }

    public static final void access$showVinRecognitionScreen(PublishActivity publishActivity) {
        Objects.requireNonNull(publishActivity);
        publishActivity.c(InputVinFragmentKt.createInputVinFragment());
    }

    public static final String access$stepFragmentTag(PublishActivity publishActivity, int i) {
        Objects.requireNonNull(publishActivity);
        return "tag_step_index_" + i;
    }

    public final void a() {
        PublishViewModel publishViewModel = this.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (!publishViewModel.isEditing()) {
            PublishEventTracker publishEventTracker2 = this.publishEventTracker;
            if (publishEventTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishEventTracker");
            }
            PublishViewModel publishViewModel2 = this.m;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishEventTracker2.trackItemAddCloseEvent(publishViewModel2.getAnalyticsScreenId());
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(Constants.UP_INTENT);
        if (intent != null) {
            startActivity(intent);
        }
        finish();
    }

    public final void b(Fragment fragment, String str) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, str).addToBackStack(str).commitAllowingStateLoss();
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerRouter
    public void backFromStsScanner() {
        onBackPressed();
    }

    public final void c(Fragment fragment) {
        PublishViewModel publishViewModel = this.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        int stepIndex = publishViewModel.getStepIndex();
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle(1);
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "stepFragment.arguments ?: Bundle(1)");
        arguments.putInt(PublishActivityKt.KEY_STEP_INDEX, stepIndex);
        fragment.setArguments(arguments);
        b(fragment, "tag_step_index_" + stepIndex);
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryRouter
    public void changeWrongCategory(@Nullable CategoryModel categoryModel) {
        if (categoryModel != null) {
            getSupportFragmentManager().popBackStackImmediate((String) null, 1);
            PublishViewModel publishViewModel = this.m;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishViewModel.resetStateWithChangedCategory(categoryModel);
            SubmissionPresenter submissionPresenter = this.presenter;
            if (submissionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            SubmissionPresenter.DefaultImpls.saveDraftIfNeeded$default(submissionPresenter, false, 1, null);
            PublishViewModel publishViewModel2 = this.m;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishViewModel2.resumePublishingFlow();
        }
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryRouter
    public void closeWrongCategory() {
        onBackPressed();
    }

    @NotNull
    public final AbTestsConfigProvider getAbTestsConfigProvider() {
        AbTestsConfigProvider abTestsConfigProvider2 = this.abTestsConfigProvider;
        if (abTestsConfigProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abTestsConfigProvider");
        }
        return abTestsConfigProvider2;
    }

    @NotNull
    public final Analytics getAnalytics$publish_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final PublishAnalyticsDataProvider getAnalyticsData() {
        PublishAnalyticsDataProvider publishAnalyticsDataProvider = this.analyticsData;
        if (publishAnalyticsDataProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsData");
        }
        return publishAnalyticsDataProvider;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final PhotoPickerOnPublishEventTracker getPhotoPickerEventTracker() {
        PhotoPickerOnPublishEventTracker photoPickerOnPublishEventTracker = this.photoPickerEventTracker;
        if (photoPickerOnPublishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerEventTracker");
        }
        return photoPickerOnPublishEventTracker;
    }

    @NotNull
    public final SubmissionPresenter getPresenter() {
        SubmissionPresenter submissionPresenter = this.presenter;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return submissionPresenter;
    }

    @NotNull
    public final PublishDraftDataHolder getPublishDraftDataHolder() {
        PublishDraftDataHolder publishDraftDataHolder2 = this.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        return publishDraftDataHolder2;
    }

    @NotNull
    public final PublishEventTracker getPublishEventTracker() {
        PublishEventTracker publishEventTracker2 = this.publishEventTracker;
        if (publishEventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishEventTracker");
        }
        return publishEventTracker2;
    }

    @NotNull
    public final PublishViewModelFactory getViewModelFactory() {
        PublishViewModelFactory publishViewModelFactory = this.viewModelFactory;
        if (publishViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return publishViewModelFactory;
    }

    @Override // com.avito.android.publish.wizard.WizardRouter
    public void leavePublish() {
        leavePublish(null);
    }

    @Override // com.avito.android.publish.wizard.WizardRouter
    public void leaveWizard() {
        PublishViewModel publishViewModel = this.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (!publishViewModel.isEditing()) {
            PublishViewModel publishViewModel2 = this.m;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishViewModel2.goToPreviousStep();
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            return;
        }
        Keyboards.hideKeyboard(this);
        finish();
    }

    @Override // com.avito.android.publish.SubmissionPresenter.Router
    public void navigateToAuth() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, AuthSource.CREATE_ADVERT, null, 5, null), 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.k.post(new a(this, i, i2, intent));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof InfomodelRequestFragment) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            if (supportFragmentManager.getBackStackEntryCount() == 1) {
                leavePublish();
                return;
            }
        }
        if (findFragmentById == null || !(findFragmentById instanceof OnBackPressedListener) || !((OnBackPressedListener) findFragmentById).onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PublishComponent.Builder locationDependencies = DaggerPublishComponent.builder().publishDependencies((PublishDependencies) ComponentDependenciesKt.getDependencies(PublishDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        PublishComponent build = locationDependencies.resources(resources).activity(this).fragmentActivity(this).publishModule(new PublishModule()).build();
        this.l = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishComponent");
        }
        build.inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        PublishViewModelFactory publishViewModelFactory = this.viewModelFactory;
        if (publishViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, publishViewModelFactory).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ishViewModel::class.java)");
        PublishViewModel publishViewModel = (PublishViewModel) viewModel;
        this.m = publishViewModel;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Bundle bundle2 = null;
        publishViewModel.restoreState(bundle != null ? Bundles.getKundle(bundle, "key_publish_view_model_state") : null);
        PublishDraftDataHolder publishDraftDataHolder2 = this.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        if (bundle != null) {
            bundle2 = bundle.getBundle("key_subcategory_title_holder_state");
        }
        publishDraftDataHolder2.onRestoreState(bundle2);
        SubmissionPresenter submissionPresenter = this.presenter;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PublishViewModel publishViewModel2 = this.m;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        submissionPresenter.setPublishViewModel(publishViewModel2);
        PublishViewModel publishViewModel3 = this.m;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishViewModel3.routingActions().observe(this, new a2.a.a.e2.b(this, publishViewModel3));
        PublishViewModel publishViewModel4 = this.m;
        if (publishViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishViewModel4.getDialogs().observe(this, new Observer<T>() { // from class: com.avito.android.publish.PublishActivity$observeDialogs$$inlined$observeNotNull$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    Fragment findFragmentByTag = PublishActivity.this.getSupportFragmentManager().findFragmentByTag("tag_draft_version_conflict_dialog");
                    if (!(findFragmentByTag instanceof DialogFragment)) {
                        findFragmentByTag = null;
                    }
                    DialogFragment dialogFragment = (DialogFragment) findFragmentByTag;
                    if (dialogFragment == null) {
                        dialogFragment = DialogWithDeeplinkActionsKt.createDialogWithDeepLinkActions(t2);
                    }
                    if (!dialogFragment.isAdded()) {
                        dialogFragment.setCancelable(false);
                        dialogFragment.show(PublishActivity.this.getSupportFragmentManager(), "tag_draft_version_conflict_dialog");
                    }
                }
            }
        });
        if (bundle == null) {
            SubmissionPresenter submissionPresenter2 = this.presenter;
            if (submissionPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            submissionPresenter2.attachRouter(this);
            SubmissionPresenter submissionPresenter3 = this.presenter;
            if (submissionPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            submissionPresenter3.onViewCreated();
            boolean booleanExtra = getIntent().getBooleanExtra("should_restore_draft", false);
            String stringExtra = getIntent().getStringExtra("should_draft_id");
            if (booleanExtra) {
                PublishDraftDataHolder publishDraftDataHolder3 = this.publishDraftDataHolder;
                if (publishDraftDataHolder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
                }
                Intrinsics.checkNotNullExpressionValue(stringExtra, "draftId");
                publishDraftDataHolder3.setDraftId(stringExtra);
            }
            String stringExtra2 = getIntent().getStringExtra("key_item_id");
            Navigation navigation = (Navigation) getIntent().getParcelableExtra("key_navigation");
            if (navigation == null) {
                if (booleanExtra || stringExtra2 != null) {
                    navigation = new Navigation(null, null, null, null, null, null, null, 127, null);
                } else {
                    PublishViewModel publishViewModel5 = this.m;
                    if (publishViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    publishViewModel5.onUnexpectedErrorOccurred(new RuntimeException("navigation was not passed to " + this + " in publish mode"));
                    return;
                }
            }
            PublishViewModel publishViewModel6 = this.m;
            if (publishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishViewModel6.init(navigation, booleanExtra);
            PublishViewModel publishViewModel7 = this.m;
            if (publishViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishViewModel7.setDraftId(stringExtra);
            if (stringExtra2 != null) {
                publishViewModel7.setItem(new ItemBrief(stringExtra2, null, null, null, null, null, 62, null));
            }
            publishViewModel7.setPostAction(getIntent().getStringExtra("key_action"));
            Intent intent = getIntent();
            if (intent != null && intent.hasExtra("key_advert_id")) {
                PublishViewModel publishViewModel8 = this.m;
                if (publishViewModel8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                publishViewModel8.setAdvertId(intent.getStringExtra("key_advert_id"));
            }
            if (booleanExtra) {
                PublishViewModel publishViewModel9 = this.m;
                if (publishViewModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                publishViewModel9.stateInitialization().observe(this, new b(this));
            } else {
                setTheme(R.style.Theme_Avito_Base_BlackMenu);
                applyNewImagesIfNecessary();
            }
            PublishViewModel publishViewModel10 = this.m;
            if (publishViewModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            publishViewModel10.startDynamicPublishingFlow();
        } else {
            setTheme(R.style.Theme_Avito_Base_BlackMenu);
        }
        PhotoPickerOnPublishEventTracker photoPickerOnPublishEventTracker = this.photoPickerEventTracker;
        if (photoPickerOnPublishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerEventTracker");
        }
        PublishViewModel publishViewModel11 = this.m;
        if (publishViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoPickerOnPublishEventTracker.subscribe(publishViewModel11);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PhotoPickerOnPublishEventTracker photoPickerOnPublishEventTracker = this.photoPickerEventTracker;
        if (photoPickerOnPublishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerEventTracker");
        }
        photoPickerOnPublishEventTracker.unsubscribe();
        SubmissionPresenter submissionPresenter = this.presenter;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        submissionPresenter.onViewDestroyed();
        super.onDestroy();
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void onDialogDismiss() {
    }

    @Override // com.avito.android.publish.wizard.WizardRouter
    public void onParameterSelected(@NotNull WizardParameter wizardParameter) {
        Intrinsics.checkNotNullParameter(wizardParameter, "wizardParameter");
        PublishViewModel publishViewModel = this.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        publishViewModel.updateStateWithCategory(wizardParameter);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PublishDraftDataHolder publishDraftDataHolder2 = this.publishDraftDataHolder;
        if (publishDraftDataHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishDraftDataHolder");
        }
        bundle.putBundle("key_subcategory_title_holder_state", publishDraftDataHolder2.onSaveState());
        if (!isChangingConfigurations()) {
            SubmissionPresenter submissionPresenter = this.presenter;
            if (submissionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            submissionPresenter.saveDraftIfNeeded(false);
            PublishViewModel publishViewModel = this.m;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Bundles.putKundle(bundle, "key_publish_view_model_state", publishViewModel.saveState());
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        SubmissionPresenter submissionPresenter = this.presenter;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        submissionPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        SubmissionPresenter submissionPresenter = this.presenter;
        if (submissionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        submissionPresenter.detachRouter();
        SubmissionPresenter submissionPresenter2 = this.presenter;
        if (submissionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        submissionPresenter2.detachView(isFinishing(), this.n);
        this.k.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override // com.avito.android.publish.SubmissionPresenter.Router, com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (deepLink instanceof PaidServicesLink) {
            PublishViewModel publishViewModel = this.m;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String advertId = publishViewModel.getAdvertId();
            if (advertId != null) {
                ActivityIntentFactory activityIntentFactory = this.intentFactory;
                if (activityIntentFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
                }
                Intent myAdvertDetailsIntent$default = UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(activityIntentFactory, advertId, null, null, true, 6, null);
                ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
                if (activityIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
                }
                Intent flags = myAdvertDetailsIntent$default.putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(activityIntentFactory2, null, null, false, 7, null)).setFlags(603979776);
                Intrinsics.checkNotNullExpressionValue(flags, "intentFactory.myAdvertDe…FLAG_ACTIVITY_SINGLE_TOP)");
                if (intent != null) {
                    intent.putExtra(Constants.UP_INTENT, flags);
                }
            }
        } else if (deepLink instanceof DraftRefreshLink) {
            PublishViewModel publishViewModel2 = this.m;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String draftId = publishViewModel2.getDraftId();
            if (draftId != null) {
                this.n = false;
                finish();
                ActivityIntentFactory activityIntentFactory3 = this.intentFactory;
                if (activityIntentFactory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
                }
                startActivity(activityIntentFactory3.publishAdvertFromDraftIntent(draftId, false));
                return;
            }
            return;
        }
        if (intent != null) {
            startActivity(intent);
            finish();
        }
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerRouter
    public void popStsScannerFromBackstack() {
        getSupportFragmentManager().popBackStack();
    }

    @Override // com.avito.android.publish.input_vin.InputVinRouter, com.avito.android.publish.category_suggest.CategoriesSuggestionsRouter
    public void saveDraftAndExitPublishing() {
        leavePublish();
    }

    @Override // com.avito.android.publish.input_vin.InputVinRouter
    public void scanVinFromSts(int i) {
        if (getSupportFragmentManager().findFragmentByTag("sts_scan_tag") == null) {
            StsScannerFragment createStsScannerFragment = StsScannerFragmentKt.createStsScannerFragment();
            Bundle arguments = createStsScannerFragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle(1);
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "fragment.arguments ?: Bundle(1)");
            arguments.putInt(PublishActivityKt.KEY_STEP_INDEX, i);
            createStsScannerFragment.setArguments(arguments);
            b(createStsScannerFragment, "sts_scan_tag");
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    public final void setAbTestsConfigProvider(@NotNull AbTestsConfigProvider abTestsConfigProvider2) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider2, "<set-?>");
        this.abTestsConfigProvider = abTestsConfigProvider2;
    }

    public final void setAnalytics$publish_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsData(@NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "<set-?>");
        this.analyticsData = publishAnalyticsDataProvider;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPhotoPickerEventTracker(@NotNull PhotoPickerOnPublishEventTracker photoPickerOnPublishEventTracker) {
        Intrinsics.checkNotNullParameter(photoPickerOnPublishEventTracker, "<set-?>");
        this.photoPickerEventTracker = photoPickerOnPublishEventTracker;
    }

    public final void setPresenter(@NotNull SubmissionPresenter submissionPresenter) {
        Intrinsics.checkNotNullParameter(submissionPresenter, "<set-?>");
        this.presenter = submissionPresenter;
    }

    public final void setPublishDraftDataHolder(@NotNull PublishDraftDataHolder publishDraftDataHolder2) {
        Intrinsics.checkNotNullParameter(publishDraftDataHolder2, "<set-?>");
        this.publishDraftDataHolder = publishDraftDataHolder2;
    }

    public final void setPublishEventTracker(@NotNull PublishEventTracker publishEventTracker2) {
        Intrinsics.checkNotNullParameter(publishEventTracker2, "<set-?>");
        this.publishEventTracker = publishEventTracker2;
    }

    public final void setViewModelFactory(@NotNull PublishViewModelFactory publishViewModelFactory) {
        Intrinsics.checkNotNullParameter(publishViewModelFactory, "<set-?>");
        this.viewModelFactory = publishViewModelFactory;
    }

    @Override // com.avito.android.publish.details.PublishDetailsRouter
    public void showEditWizard() {
        Navigation navigation;
        PublishViewModel publishViewModel = this.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (publishViewModel.isEditing()) {
            PublishViewModel publishViewModel2 = this.m;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            navigation = publishViewModel2.getNavigation();
        } else {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("key_navigation");
            Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtra(KEY_NAVIGATION)");
            navigation = (Navigation) parcelableExtra;
        }
        PublishViewModel publishViewModel3 = this.m;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        int i = (publishViewModel3.isEditing() || !navigation.isEmpty()) ? 0 : 1;
        PublishViewModel publishViewModel4 = this.m;
        if (publishViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ItemBrief item = publishViewModel4.getItem();
        String id = item != null ? item.getId() : null;
        Integer valueOf = Integer.valueOf(i);
        PublishViewModel publishViewModel5 = this.m;
        if (publishViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        b(WizardFragmentKt.createWizardFragment$default(id, navigation, false, valueOf, null, publishViewModel5.getStepId(), 20, null), "wizard_tag");
    }

    @Override // com.avito.android.publish.SubmissionPresenter.Router
    public void showItemScreen(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (z) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            PublishAnalyticsDataProvider publishAnalyticsDataProvider = this.analyticsData;
            if (publishAnalyticsDataProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsData");
            }
            analytics2.track(new PublicationDoneSuccessful(publishAnalyticsDataProvider.getSessionIdKeyValue(), str));
        }
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent myAdvertDetailsIntent$default = UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(activityIntentFactory, str, str2, null, z, 4, null);
        ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent flags = myAdvertDetailsIntent$default.putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(activityIntentFactory2, null, null, false, 7, null)).setFlags(603979776);
        Intrinsics.checkNotNullExpressionValue(flags, "intentFactory.myAdvertDe…FLAG_ACTIVITY_SINGLE_TOP)");
        startActivity(flags);
        setResult(-1);
        finish();
    }

    @Override // com.avito.android.publish.SubmissionPresenter.Router
    public void showListingFeesScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.feesIntent(str, true, false), 1);
    }

    @Override // com.avito.android.publish.sts_scanner.StsScannerRouter
    public void showStsRecognitionErrorDialog() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("sts_scan_tag");
        if (findFragmentByTag != null) {
            ((StsScannerFragment) findFragmentByTag).showStsRecognitionErrorDialog();
        }
    }

    @Override // com.avito.android.publish.premoderation.WrongCategoryRouter
    public void skipWrongCategory() {
        PublishViewModel publishViewModel = this.m;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PublishViewModel.goToNextStep$default(publishViewModel, null, 1, null);
    }

    @Override // com.avito.android.app.di.HasActivityComponent
    @NotNull
    public PublishComponent getActivityComponent() {
        PublishComponent publishComponent = this.l;
        if (publishComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishComponent");
        }
        return publishComponent;
    }

    public final void leavePublish(@Nullable Intent intent) {
        setResult(-1, intent);
        a();
    }
}
