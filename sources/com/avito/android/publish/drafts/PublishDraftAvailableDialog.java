package com.avito.android.publish.drafts;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.dialog.DialogWithDeeplinkActions;
import com.avito.android.dialog.DialogWithDeeplinkActionsKt;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.di.DaggerPublishDraftAvailableDialogComponent;
import com.avito.android.publish.drafts.di.PublishDraftsDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b#\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftAvailableDialog;", "Lcom/avito/android/dialog/DialogWithDeeplinkActions;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "setUpDialogComponent", "()V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "onCloseButtonClicked", "onDialogCreate", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onDeepLinkClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "Lcom/avito/android/publish/drafts/PublishDraftAvailableRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/drafts/PublishDraftAvailableRouter;", "router", "", "c", "Ljava/lang/String;", "draftSessionId", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "publishEventTracker", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "getPublishEventTracker", "()Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "setPublishEventTracker", "(Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;)V", "<init>", "Companion", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftAvailableDialog extends DialogWithDeeplinkActions {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public PublishDraftAvailableRouter b;
    public String c;
    @Inject
    public PublishDraftEventTracker publishEventTracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftAvailableDialog$Companion;", "", "Lcom/avito/android/remote/model/DeepLinksDialogInfo;", "info", "", "sessionId", "Lcom/avito/android/publish/drafts/PublishDraftAvailableDialog;", "getInstance", "(Lcom/avito/android/remote/model/DeepLinksDialogInfo;Ljava/lang/String;)Lcom/avito/android/publish/drafts/PublishDraftAvailableDialog;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PublishDraftAvailableDialog getInstance(@NotNull DeepLinksDialogInfo deepLinksDialogInfo, @NotNull String str) {
            Intrinsics.checkNotNullParameter(deepLinksDialogInfo, "info");
            Intrinsics.checkNotNullParameter(str, "sessionId");
            PublishDraftAvailableDialog publishDraftAvailableDialog = new PublishDraftAvailableDialog();
            DialogWithDeeplinkActionsKt.setInfo(publishDraftAvailableDialog, deepLinksDialogInfo);
            Bundle arguments = publishDraftAvailableDialog.getArguments();
            if (arguments != null) {
                arguments.putString("key_session_id", str);
            }
            return publishDraftAvailableDialog;
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final PublishDraftEventTracker getPublishEventTracker() {
        PublishDraftEventTracker publishDraftEventTracker = this.publishEventTracker;
        if (publishDraftEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishEventTracker");
        }
        return publishDraftEventTracker;
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActions, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        PublishDraftAvailableRouter publishDraftAvailableRouter = this.b;
        if (publishDraftAvailableRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        publishDraftAvailableRouter.onPublishDraftAvailableDialogCancelled();
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActions
    public void onCloseButtonClicked() {
        super.onCloseButtonClicked();
        PublishDraftAvailableRouter publishDraftAvailableRouter = this.b;
        if (publishDraftAvailableRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        publishDraftAvailableRouter.onPublishDraftAvailableDialogCancelled();
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActions, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        PublishDraftAvailableRouter publishDraftAvailableRouter;
        String string;
        super.onCreate(bundle);
        PublishDraftAvailableRouter publishDraftAvailableRouter2 = null;
        if (getParentFragment() != null) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof PublishDraftAvailableRouter) {
                publishDraftAvailableRouter2 = parentFragment;
            }
            publishDraftAvailableRouter = publishDraftAvailableRouter2;
            if (publishDraftAvailableRouter == null) {
                throw new RuntimeException("Hosting fragment should implement PublishDraftAvailableRouter");
            }
        } else {
            FragmentActivity activity = getActivity();
            if (activity instanceof PublishDraftAvailableRouter) {
                publishDraftAvailableRouter2 = activity;
            }
            publishDraftAvailableRouter = publishDraftAvailableRouter2;
            if (publishDraftAvailableRouter == null) {
                throw new RuntimeException("Hosting activity should implement PublishDraftAvailableRouter");
            }
        }
        this.b = publishDraftAvailableRouter;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("key_session_id")) == null) {
            throw new RuntimeException("key_session_id was not passed to " + this);
        }
        this.c = string;
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActions
    public boolean onDeepLinkClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (!(deepLink instanceof AdvertPublicationLink)) {
            return false;
        }
        PublishDraftAvailableRouter publishDraftAvailableRouter = this.b;
        if (publishDraftAvailableRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        publishDraftAvailableRouter.onRestoreDraftRejected();
        return true;
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActions
    public void onDialogCreate() {
        PublishDraftEventTracker publishDraftEventTracker = this.publishEventTracker;
        if (publishDraftEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishEventTracker");
        }
        String str = this.c;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draftSessionId");
        }
        publishDraftEventTracker.trackDialogShown(str);
    }

    public final void setPublishEventTracker(@NotNull PublishDraftEventTracker publishDraftEventTracker) {
        Intrinsics.checkNotNullParameter(publishDraftEventTracker, "<set-?>");
        this.publishEventTracker = publishDraftEventTracker;
    }

    @Override // com.avito.android.dialog.DialogWithDeeplinkActions
    public void setUpDialogComponent() {
        DaggerPublishDraftAvailableDialogComponent.builder().publishDraftsDependencies((PublishDraftsDependencies) ComponentDependenciesKt.getDependencies(PublishDraftsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
    }
}
