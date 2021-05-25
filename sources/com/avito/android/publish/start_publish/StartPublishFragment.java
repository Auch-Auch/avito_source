package com.avito.android.publish.start_publish;

import a2.a.a.e2.e0.b;
import a2.a.a.e2.e0.c;
import a2.a.a.e2.e0.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DraftPublicationLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.dialog.DialogWithDeeplinkActionsRouter;
import com.avito.android.publish.R;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.events.AddItemEvent;
import com.avito.android.publish.drafts.PublishDraftAvailableRouter;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.publish.start_publish.di.DaggerStartPublishComponent;
import com.avito.android.publish.start_publish.di.StartPublishComponent;
import com.avito.android.publish.start_publish.di.StartPublishDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.DialogRouterImpl;
import com.avito.android.util.Intents;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001bB\u0007¢\u0006\u0004\ba\u0010\fJ\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\fJ\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\fJ\u000f\u0010-\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010\fR\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010I\u001a\u00020H8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006c"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/publish/start_publish/StartPublishSheet$Router;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "Lcom/avito/android/publish/drafts/PublishDraftAvailableRouter;", "Lcom/avito/android/dialog/DialogWithDeeplinkActionsRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onBackPressed", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onRestoreDraftRejected", "onPublishDraftAvailableDialogCancelled", "onDialogDismiss", "Lcom/avito/android/publish/start_publish/StartPublishSheet;", "j", "Lcom/avito/android/publish/start_publish/StartPublishSheet;", "startPublishSheet", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/DialogRouter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/app/Dialog;", "l", "Landroid/app/Dialog;", "loadingDialog", "Lcom/avito/android/publish/start_publish/StartPublishViewModelFactory;", "viewModelFactory", "Lcom/avito/android/publish/start_publish/StartPublishViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/publish/start_publish/StartPublishViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/publish/start_publish/StartPublishViewModelFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "getEventTracker", "()Lcom/avito/android/publish/analytics/PublishEventTracker;", "setEventTracker", "(Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "Lcom/avito/android/publish/start_publish/StartPublishViewModel;", "k", "Lcom/avito/android/publish/start_publish/StartPublishViewModel;", "viewModel", "<init>", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StartPublishFragment extends TabBaseFragment implements StartPublishSheet.Router, TabRootFragment, PublishDraftAvailableRouter, DialogWithDeeplinkActionsRouter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public PublishEventTracker eventTracker;
    @Inject
    public ActivityIntentFactory intentFactory;
    public StartPublishSheet j;
    public StartPublishViewModel k;
    public Dialog l;
    public DialogRouter m;
    @Inject
    public StartPublishViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishFragment$Companion;", "", "", "calledFrom", "Lcom/avito/android/publish/start_publish/StartPublishFragment;", "createFragment", "(Ljava/lang/String;)Lcom/avito/android/publish/start_publish/StartPublishFragment;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final StartPublishFragment createFragment(@Nullable String str) {
            StartPublishFragment startPublishFragment = new StartPublishFragment();
            if (str != null) {
                Bundle bundle = new Bundle(1);
                bundle.putString("called_from", str);
                Unit unit = Unit.INSTANCE;
                startPublishFragment.setArguments(bundle);
            }
            return startPublishFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ StartPublishFragment a;

        public a(StartPublishFragment startPublishFragment) {
            this.a = startPublishFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onBackPressed();
        }
    }

    public static final void access$hideLoadingDialog(StartPublishFragment startPublishFragment) {
        Dialog dialog = startPublishFragment.l;
        if (dialog != null) {
            dialog.dismiss();
        }
        startPublishFragment.l = null;
    }

    public static final void access$hideStartPublishSheet(StartPublishFragment startPublishFragment) {
        StartPublishSheet startPublishSheet = startPublishFragment.j;
        if (startPublishSheet != null) {
            startPublishSheet.dismiss();
        }
        startPublishFragment.j = null;
    }

    public static final void access$showLoadingDialog(StartPublishFragment startPublishFragment) {
        if (startPublishFragment.l == null) {
            DialogRouter dialogRouter = startPublishFragment.m;
            if (dialogRouter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
            }
            Dialog showSimpleWaitingDialog = dialogRouter.showSimpleWaitingDialog();
            showSimpleWaitingDialog.setOnCancelListener(new c(startPublishFragment));
            startPublishFragment.l = showSimpleWaitingDialog;
        }
    }

    public static final StartPublishSheet access$showStartPublishSheet(StartPublishFragment startPublishFragment) {
        StartPublishSheet startPublishSheet = startPublishFragment.j;
        if (startPublishSheet == null || !startPublishSheet.isShowing()) {
            Context requireContext = startPublishFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Analytics analytics2 = startPublishFragment.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            PublishEventTracker publishEventTracker = startPublishFragment.eventTracker;
            if (publishEventTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
            }
            startPublishSheet = new StartPublishSheet(requireContext, analytics2, publishEventTracker, new d(startPublishFragment));
            startPublishSheet.attachRouter(startPublishFragment);
            startPublishSheet.show();
            startPublishSheet.expand();
            startPublishFragment.j = startPublishSheet;
        }
        return startPublishSheet;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
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
    public final PublishEventTracker getEventTracker() {
        PublishEventTracker publishEventTracker = this.eventTracker;
        if (publishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return publishEventTracker;
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
    public final StartPublishViewModelFactory getViewModelFactory() {
        StartPublishViewModelFactory startPublishViewModelFactory = this.viewModelFactory;
        if (startPublishViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return startPublishViewModelFactory;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return navigationTabSetItem.getAddButtonState() == AddButtonState.ACTIVE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 2 && i2 == 0) {
                StartPublishViewModel startPublishViewModel = this.k;
                if (startPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                startPublishViewModel.setShouldFinishOnResume(false);
            }
        } else if (i2 == -1) {
            StartPublishViewModel startPublishViewModel2 = this.k;
            if (startPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            startPublishViewModel2.checkAuthorization();
        } else {
            StartPublishViewModel startPublishViewModel3 = this.k;
            if (startPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            startPublishViewModel3.setShouldFinishOnResume(true);
        }
    }

    public final void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.m = new DialogRouterImpl(requireActivity);
        StartPublishViewModelFactory startPublishViewModelFactory = this.viewModelFactory;
        if (startPublishViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, startPublishViewModelFactory).get(StartPublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.k = (StartPublishViewModel) viewModel;
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new AddItemEvent.PublishButtonClick());
            StartPublishViewModel startPublishViewModel = this.k;
            if (startPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            startPublishViewModel.checkAuthorization();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.start_publish_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        StartPublishSheet startPublishSheet = this.j;
        if (startPublishSheet != null) {
            startPublishSheet.dismiss();
        }
        this.j = null;
        super.onDestroyView();
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void onDialogDismiss() {
    }

    @Override // com.avito.android.publish.drafts.PublishDraftAvailableRouter
    public void onPublishDraftAvailableDialogCancelled() {
        onBackPressed();
    }

    @Override // com.avito.android.publish.drafts.PublishDraftAvailableRouter
    public void onRestoreDraftRejected() {
        StartPublishViewModel startPublishViewModel = this.k;
        if (startPublishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        startPublishViewModel.onRestoreDraftRejected();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        StartPublishViewModel startPublishViewModel = this.k;
        if (startPublishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (startPublishViewModel.getShouldFinishOnResume()) {
            new Handler().post(new a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        StartPublishViewModel startPublishViewModel = this.k;
        if (startPublishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        startPublishViewModel.state().observe(getViewLifecycleOwner(), new b(this));
    }

    @Override // com.avito.android.publish.start_publish.StartPublishSheet.Router, com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void openDeepLink(@NotNull DeepLink deepLink) {
        String string;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        StartPublishViewModel startPublishViewModel = this.k;
        if (startPublishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        startPublishViewModel.setShouldFinishOnResume(true);
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            Bundle arguments = getArguments();
            if (!(arguments == null || (string = arguments.getString("called_from")) == null)) {
                Intrinsics.checkNotNullExpressionValue(string, "it");
                Intents.putCalledFromExtra(intent, string);
                IntentsKt.replaceCalledFromIfRequired(intent, string);
            }
            if (deepLink instanceof DraftPublicationLink) {
                startActivityForResult(intent, 3);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.overridePendingTransition(R.anim.slide_in_publish, R.anim.empty);
                }
            } else if (deepLink instanceof AdvertPublicationLink) {
                startActivityForResult(intent, 2);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.overridePendingTransition(R.anim.slide_in_publish, R.anim.empty);
                }
            } else {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.startActivity(intent);
                }
            }
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setEventTracker(@NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(publishEventTracker, "<set-?>");
        this.eventTracker = publishEventTracker;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        StartPublishComponent.Builder startPublishDependencies = DaggerStartPublishComponent.builder().startPublishDependencies((StartPublishDependencies) ComponentDependenciesKt.getDependencies(StartPublishDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        startPublishDependencies.resources(resources).build().inject(this);
        return true;
    }

    public final void setViewModelFactory(@NotNull StartPublishViewModelFactory startPublishViewModelFactory) {
        Intrinsics.checkNotNullParameter(startPublishViewModelFactory, "<set-?>");
        this.viewModelFactory = startPublishViewModelFactory;
    }
}
