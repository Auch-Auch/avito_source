package a2.a.a.e2.o;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.publish.PublishAppbarView;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModel;
import com.avito.android.publish.premoderation.WrongCategoryRouter;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<CategoriesSuggestionsViewModel.RoutingAction> {
    public final /* synthetic */ CategoriesSuggestionsFragment a;

    public a(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        this.a = categoriesSuggestionsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(CategoriesSuggestionsViewModel.RoutingAction routingAction) {
        PublishAppbarView publishAppbarView;
        CategoriesSuggestionsViewModel.RoutingAction routingAction2 = routingAction;
        if (Intrinsics.areEqual(routingAction2, CategoriesSuggestionsViewModel.RoutingAction.SaveAndExitPublishing.INSTANCE)) {
            CategoriesSuggestionsFragment.access$getRouter$p(this.a).saveDraftAndExitPublishing();
        } else if (routingAction2 instanceof CategoriesSuggestionsViewModel.RoutingAction.ChangeVertical) {
            FragmentActivity activity = this.a.getActivity();
            if (!(activity instanceof WrongCategoryRouter)) {
                activity = null;
            }
            WrongCategoryRouter wrongCategoryRouter = (WrongCategoryRouter) activity;
            if (wrongCategoryRouter != null) {
                wrongCategoryRouter.changeWrongCategory(((CategoriesSuggestionsViewModel.RoutingAction.ChangeVertical) routingAction2).getWizardParameter());
            }
        } else if (routingAction2 instanceof CategoriesSuggestionsViewModel.RoutingAction.ToWizardScreen) {
            CategoriesSuggestionsFragment.access$showWizardInnerFragment(this.a, ((CategoriesSuggestionsViewModel.RoutingAction.ToWizardScreen) routingAction2).getNavigation());
        } else if (routingAction2 instanceof CategoriesSuggestionsViewModel.RoutingAction.ClearWizardScreen) {
            this.a.getChildFragmentManager().popBackStack();
            if (((CategoriesSuggestionsViewModel.RoutingAction.ClearWizardScreen) routingAction2).getStayOnSuggests()) {
                this.a.getPublishEventTracker().trackItemAddScreenOpen(CategoriesSuggestionsFragment.access$getPublishViewModel$p(this.a).getAnalyticsScreenId());
                this.a.a();
            }
        } else if ((routingAction2 instanceof CategoriesSuggestionsViewModel.RoutingAction.ShowOnboarding) && (publishAppbarView = this.a.f) != null) {
            publishAppbarView.showActionOnboarding(((CategoriesSuggestionsViewModel.RoutingAction.ShowOnboarding) routingAction2).getOnboardingData());
        }
    }
}
