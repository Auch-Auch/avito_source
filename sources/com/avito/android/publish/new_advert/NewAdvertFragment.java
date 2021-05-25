package com.avito.android.publish.new_advert;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DraftPublicationLink;
import com.avito.android.design.widget.add_advert.AddAdvertView;
import com.avito.android.design.widget.add_advert.NewAdvertView;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.dialog.DialogWithDeeplinkActionsRouter;
import com.avito.android.publish.R;
import com.avito.android.publish.analytics.FloatingAddAdvertAnalyticsWrapper;
import com.avito.android.publish.di.NewAdvertDependencies;
import com.avito.android.publish.drafts.PublishDraftAvailableDialogKt;
import com.avito.android.publish.drafts.PublishDraftAvailableRouter;
import com.avito.android.publish.new_advert.NewAdvertPresenter;
import com.avito.android.publish.new_advert.di.DaggerNewAdvertComponent;
import com.avito.android.publish.new_advert.di.NewAdvertModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Intents;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.floating_add_advert.FloatingAddAdvert;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001jB\u0007¢\u0006\u0004\bi\u0010\nJ\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\nJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J)\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\nJ\u001f\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u001f2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0019\u00104\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u000fH\u0016¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010\nR\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006k"}, d2 = {"Lcom/avito/android/publish/new_advert/NewAdvertFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;", "Lcom/avito/android/publish/drafts/PublishDraftAvailableRouter;", "Lcom/avito/android/dialog/DialogWithDeeplinkActionsRouter;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "", "c", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onDialogDismiss", "onRestoreDraftRejected", "onPublishDraftAvailableDialogCancelled", "", "onBackPressed", "()Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "continueExpandAddAdvert", "", "sessionId", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "dialogInfo", "showPublishDraftAvailableDialog", "(Ljava/lang/String;Lcom/avito/android/remote/model/DeepLinksDialogInfo;)V", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onViewStateRestored", "onResume", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lio/reactivex/disposables/CompositeDisposable;", "k", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "l", "Z", "needCloseAfterReturn", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "presenter", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "getPresenter", "()Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "setPresenter", "(Lcom/avito/android/publish/new_advert/NewAdvertPresenter;)V", "Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "j", "Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "addAdvert", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;", "floatingAddAdvertWrapper", "Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;", "getFloatingAddAdvertWrapper", "()Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;", "setFloatingAddAdvertWrapper", "(Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;)V", "<init>", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class NewAdvertFragment extends TabBaseFragment implements NewAdvertPresenter.Router, NewAdvertPresenter.View, PublishDraftAvailableRouter, DialogWithDeeplinkActionsRouter, OnBackPressedListener, TabRootFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public FloatingAddAdvertAnalyticsWrapper floatingAddAdvertWrapper;
    @Inject
    public ActivityIntentFactory intentFactory;
    public FloatingAddAdvert j;
    public final CompositeDisposable k = new CompositeDisposable();
    public boolean l;
    @Inject
    public NewAdvertPresenter presenter;
    @Inject
    public SchedulersFactory schedulers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/new_advert/NewAdvertFragment$Companion;", "", "", "calledFrom", "Lcom/avito/android/publish/new_advert/NewAdvertFragment;", "createFragment", "(Ljava/lang/String;)Lcom/avito/android/publish/new_advert/NewAdvertFragment;", "ARGUMENT_KEY_CALLED_FROM", "Ljava/lang/String;", "KEY_NEED_CLOSE_AFTER_RETURN", "", "REQ_LOGIN", "I", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final NewAdvertFragment createFragment(@Nullable String str) {
            NewAdvertFragment newAdvertFragment = new NewAdvertFragment();
            if (str != null) {
                Bundle bundle = new Bundle(1);
                bundle.putString("called_from", str);
                newAdvertFragment.setArguments(bundle);
            }
            return newAdvertFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AddAdvertView.FinishReason.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ NewAdvertFragment a;

        public b(NewAdvertFragment newAdvertFragment) {
            this.a = newAdvertFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ NewAdvertFragment a;

        public c(NewAdvertFragment newAdvertFragment) {
            this.a = newAdvertFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.getPresenter().onNewAdvertViewAboutToBeExpanded();
        }
    }

    public static final class d<T> implements Consumer<DeepLink> {
        public final /* synthetic */ NewAdvertFragment a;

        public d(NewAdvertFragment newAdvertFragment) {
            this.a = newAdvertFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            NewAdvertFragment newAdvertFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            newAdvertFragment.openDeepLink(deepLink2);
        }
    }

    public static final class e<T> implements Consumer<AddAdvertView.FinishReason> {
        public final /* synthetic */ NewAdvertFragment a;

        public e(NewAdvertFragment newAdvertFragment) {
            this.a = newAdvertFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AddAdvertView.FinishReason finishReason) {
            AddAdvertView.FinishReason finishReason2 = finishReason;
            Intrinsics.checkNotNull(finishReason2);
            int ordinal = finishReason2.ordinal();
            if (ordinal == 0) {
                this.a.l = true;
            } else if (ordinal == 1) {
                this.a.c();
            }
        }
    }

    public final void c() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter.View
    public void continueExpandAddAdvert() {
        FloatingAddAdvert floatingAddAdvert = this.j;
        if (floatingAddAdvert == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        floatingAddAdvert.continueExpandAddAdvert();
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
    public final FloatingAddAdvertAnalyticsWrapper getFloatingAddAdvertWrapper() {
        FloatingAddAdvertAnalyticsWrapper floatingAddAdvertAnalyticsWrapper = this.floatingAddAdvertWrapper;
        if (floatingAddAdvertAnalyticsWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingAddAdvertWrapper");
        }
        return floatingAddAdvertAnalyticsWrapper;
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
    public final NewAdvertPresenter getPresenter() {
        NewAdvertPresenter newAdvertPresenter = this.presenter;
        if (newAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return newAdvertPresenter;
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        SchedulersFactory schedulersFactory = this.schedulers;
        if (schedulersFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return navigationTabSetItem.getAddButtonState() == AddButtonState.ACTIVE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = i2 == -1;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (z) {
            FloatingAddAdvert floatingAddAdvert = this.j;
            if (floatingAddAdvert == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
            }
            floatingAddAdvert.expandAddAdvertWithDraftCheck();
        } else {
            c();
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        FloatingAddAdvert floatingAddAdvert = this.j;
        if (floatingAddAdvert == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        floatingAddAdvert.handleBack();
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.new_advert_root, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…t_root, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        NewAdvertPresenter newAdvertPresenter = this.presenter;
        if (newAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        newAdvertPresenter.detachRouter();
        NewAdvertPresenter newAdvertPresenter2 = this.presenter;
        if (newAdvertPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        newAdvertPresenter2.detachView();
        this.k.clear();
        super.onDestroyView();
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void onDialogDismiss() {
    }

    @Override // com.avito.android.publish.drafts.PublishDraftAvailableRouter
    public void onPublishDraftAvailableDialogCancelled() {
        c();
    }

    @Override // com.avito.android.publish.drafts.PublishDraftAvailableRouter
    public void onRestoreDraftRejected() {
        NewAdvertPresenter newAdvertPresenter = this.presenter;
        if (newAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        newAdvertPresenter.onRestoreDraftRejected();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.l) {
            new Handler().post(new b(this));
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("close_after_return", this.l);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.new_advert_screen_root);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        NewAdvertView newAdvertView = new NewAdvertView(context);
        newAdvertView.goneCloseButton();
        viewGroup.addView(newAdvertView);
        FloatingAddAdvertAnalyticsWrapper floatingAddAdvertAnalyticsWrapper = this.floatingAddAdvertWrapper;
        if (floatingAddAdvertAnalyticsWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingAddAdvertWrapper");
        }
        this.j = floatingAddAdvertAnalyticsWrapper.wrapView(newAdvertView);
        NewAdvertPresenter newAdvertPresenter = this.presenter;
        if (newAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        newAdvertPresenter.attachView(this);
        NewAdvertPresenter newAdvertPresenter2 = this.presenter;
        if (newAdvertPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        newAdvertPresenter2.attachRouter(this);
        CompositeDisposable compositeDisposable = this.k;
        FloatingAddAdvert floatingAddAdvert = this.j;
        if (floatingAddAdvert == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        Disposable subscribe = InteropKt.toV2(floatingAddAdvert.aboutToBeExpandedCallbacks()).subscribe(new c(this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "addAdvert.aboutToBeExpan…() }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.k;
        FloatingAddAdvert floatingAddAdvert2 = this.j;
        if (floatingAddAdvert2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        Disposable subscribe2 = InteropKt.toV2(floatingAddAdvert2.addAdvertClicks()).subscribe(new d(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "addAdvert.addAdvertClick…t) }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.k;
        FloatingAddAdvert floatingAddAdvert3 = this.j;
        if (floatingAddAdvert3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        Disposable subscribe3 = InteropKt.toV2(floatingAddAdvert3.addAdvertFinishCallbacks()).subscribe(new e(this), a.d);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "addAdvert.addAdvertFinis…ogs.error(it) }\n        )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        FloatingAddAdvert floatingAddAdvert4 = this.j;
        if (floatingAddAdvert4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        floatingAddAdvert4.setResizeButton(false);
        FloatingAddAdvert floatingAddAdvert5 = this.j;
        if (floatingAddAdvert5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAdvert");
        }
        floatingAddAdvert5.expandAddAdvertWithDraftCheck();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.l = bundle.getBoolean("close_after_return", this.l);
        }
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof AuthenticateLink) {
            ActivityIntentFactory activityIntentFactory = this.intentFactory;
            if (activityIntentFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, AuthSource.CREATE_ADVERT, null, 5, null), 1);
            return;
        }
        if (deepLink instanceof DraftPublicationLink) {
            this.l = true;
        }
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            Bundle arguments = getArguments();
            String string = arguments != null ? arguments.getString("called_from") : null;
            if (string != null) {
                Intents.putCalledFromExtra(intent, string);
                IntentsKt.replaceCalledFromIfRequired(intent, string);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            startActivity(intent);
        }
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFloatingAddAdvertWrapper(@NotNull FloatingAddAdvertAnalyticsWrapper floatingAddAdvertAnalyticsWrapper) {
        Intrinsics.checkNotNullParameter(floatingAddAdvertAnalyticsWrapper, "<set-?>");
        this.floatingAddAdvertWrapper = floatingAddAdvertAnalyticsWrapper;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull NewAdvertPresenter newAdvertPresenter) {
        Intrinsics.checkNotNullParameter(newAdvertPresenter, "<set-?>");
        this.presenter = newAdvertPresenter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "<set-?>");
        this.schedulers = schedulersFactory;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        DaggerNewAdvertComponent.builder().newAdvertDependencies((NewAdvertDependencies) ComponentDependenciesKt.getDependencies(NewAdvertDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).newAdvertModule(new NewAdvertModule()).build().inject(this);
        return true;
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter.Router
    public void showPublishDraftAvailableDialog(@NotNull String str, @NotNull DeepLinksDialogInfo deepLinksDialogInfo) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "dialogInfo");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        PublishDraftAvailableDialogKt.showPublishDraftAvailableDialogFragment(str, deepLinksDialogInfo, childFragmentManager, false);
    }
}
