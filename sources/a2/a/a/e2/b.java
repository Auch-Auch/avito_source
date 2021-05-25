package a2.a.a.e2;

import androidx.lifecycle.Observer;
import com.avito.android.publish.PublishActivity;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.RoutingAction;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragmentKt;
import com.avito.android.publish.infomodel_request.InfomodelRequestFragmentKt;
import com.avito.android.publish.wizard.WizardFragmentKt;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.util.Keyboards;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<RoutingAction> {
    public final /* synthetic */ PublishActivity a;
    public final /* synthetic */ PublishViewModel b;

    public b(PublishActivity publishActivity, PublishViewModel publishViewModel) {
        this.a = publishActivity;
        this.b = publishViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(RoutingAction routingAction) {
        String str;
        RoutingAction routingAction2 = routingAction;
        Keyboards.hideKeyboard(this.a);
        if (routingAction2.getLogStepOpening()) {
            if (routingAction2 instanceof RoutingAction.BackToStep) {
                CategoryPublishStep step = this.b.getStep(Integer.valueOf(((RoutingAction.BackToStep) routingAction2).getStepIndex()));
                str = step != null ? step.toString() : null;
            } else {
                str = this.b.getAnalyticsScreenId();
            }
            this.a.getPublishEventTracker().trackItemAddScreenOpen(str);
        }
        if (routingAction2 instanceof RoutingAction.ToDetailsParams) {
            PublishActivity.access$showPublishDetails(this.a, routingAction2.getScreenTransfer());
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.ToInputVin.INSTANCE)) {
            PublishActivity.access$showVinRecognitionScreen(this.a);
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.ToSelect.INSTANCE)) {
            PublishActivity.access$showSelectScreen(this.a);
        } else if (routingAction2 instanceof RoutingAction.ToWizard) {
            RoutingAction.ToWizard toWizard = (RoutingAction.ToWizard) routingAction2;
            this.a.c(WizardFragmentKt.createWizardFragment$default(null, toWizard.getNavigation(), false, null, toWizard.getLeaves(), this.b.getStepId(), 13, null));
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.ToCategoriesSuggestions.INSTANCE)) {
            this.a.c(CategoriesSuggestionsFragmentKt.createCategoriesSuggestionsFragment());
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.Pretend.INSTANCE)) {
            PublishActivity.access$showPretendScreen(this.a);
        } else if (routingAction2 instanceof RoutingAction.InfomodelRequest) {
            this.a.c(InfomodelRequestFragmentKt.createInfomodelRequestFragment(((RoutingAction.InfomodelRequest) routingAction2).isInitial(), PublishActivity.access$shouldTrackDraftResumed(this.a)));
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.Premoderation.INSTANCE)) {
            PublishActivity.access$showPremoderationScreen(this.a);
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.Publish.INSTANCE)) {
            PublishActivity.access$goToPublishAdvert(this.a);
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.Edit.INSTANCE)) {
            PublishActivity.access$goToEditAdvert(this.a);
        } else if (routingAction2 instanceof RoutingAction.BackToStep) {
            this.a.getSupportFragmentManager().popBackStackImmediate(PublishActivity.access$stepFragmentTag(this.a, ((RoutingAction.BackToStep) routingAction2).getStepIndex()), 0);
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.LeavePublish.INSTANCE)) {
            this.a.leavePublish();
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.CancelPublish.INSTANCE)) {
            PublishActivity.access$cancelPublish(this.a);
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.UnexpectedError.INSTANCE)) {
            PublishActivity.access$handleUnexpectedError(this.a);
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.ToAuth.INSTANCE)) {
            this.a.navigateToAuth();
        }
    }
}
