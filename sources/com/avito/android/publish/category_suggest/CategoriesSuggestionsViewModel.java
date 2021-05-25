package com.avito.android.publish.category_suggest;

import a2.g.r.g;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoriesSuggestResponse;
import com.avito.android.remote.model.CategoryModel;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.loading_state.LoadingProgress;
import com.avito.android.util.loading_state.TypedError;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002RSB\u001f\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0004\b\u0015\u0010\u0013J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\u0004\b\u0017\u0010\u0013J%\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0004J\r\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004J\r\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\u0004J\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004J\r\u0010$\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u0004J\u0015\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\u001f\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0002H\u0014¢\u0006\u0004\b-\u0010\u0004R\u0015\u00101\u001a\u0004\u0018\u00010.8F@\u0006¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u00107R(\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u0014098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010:R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010IR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006T"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel;", "Landroidx/lifecycle/ViewModel;", "", g.a, "()V", "", "e", "()Z", "f", "Lcom/avito/android/util/loading_state/LoadingProgress;", "", "Lcom/avito/conveyor_item/Item;", "c", "()Lcom/avito/android/util/loading_state/LoadingProgress;", "Lcom/avito/android/remote/model/Navigation;", "d", "()Lcom/avito/android/remote/model/Navigation;", "Landroidx/lifecycle/LiveData;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$MainActionState;", "mainActionState", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "routingActions", "", "stepIndex", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "publishDraftDataHolder", "initScreen", "(ILcom/avito/android/publish/PublishViewModel;Lcom/avito/android/publish/drafts/PublishDraftDataHolder;)V", "onRetryClicked", "onMainButtonClicked", "onLeaveClicked", "onLeaveWizardClicked", "onCloseClicked", "navigation", "onCategoryListItemClicked", "(Lcom/avito/android/remote/model/Navigation;)V", "Lcom/avito/android/remote/model/CategoryModel;", "selectedCategory", "fromWizard", "onCategorySelected", "(Lcom/avito/android/remote/model/CategoryModel;Z)V", "onCleared", "", "getStepId", "()Ljava/lang/String;", "stepId", "Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", "j", "Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", "stepState", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;", "k", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;", "interactor", "Lcom/avito/android/publish/analytics/PublishEventTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/publish/PublishViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "h", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "i", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "<init>", "(Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "MainActionState", "RoutingAction", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesSuggestionsViewModel extends ViewModel {
    public final MutableLiveData<LoadingProgress<List<? extends Item>>> c = new MutableLiveData<>();
    public final MutableLiveData<MainActionState> d;
    public final SingleLiveEvent<RoutingAction> e;
    public final CompositeDisposable f;
    public PublishViewModel g;
    public ParametersTree h;
    public PublishDraftDataHolder i;
    public PublishState.StepState.CategoriesSuggestions j;
    public final CategoriesSuggestionsInteractor k;
    public final SchedulersFactory l;
    public final PublishEventTracker m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$MainActionState;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "HIDDEN", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum MainActionState {
        VISIBLE,
        HIDDEN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "", "<init>", "()V", "ChangeVertical", "ClearWizardScreen", "SaveAndExitPublishing", "ShowOnboarding", "ToWizardScreen", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$SaveAndExitPublishing;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ChangeVertical;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ToWizardScreen;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ClearWizardScreen;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ShowOnboarding;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ChangeVertical;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "Lcom/avito/android/remote/model/CategoryModel;", "component1", "()Lcom/avito/android/remote/model/CategoryModel;", "wizardParameter", "copy", "(Lcom/avito/android/remote/model/CategoryModel;)Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ChangeVertical;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/CategoryModel;", "getWizardParameter", "<init>", "(Lcom/avito/android/remote/model/CategoryModel;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ChangeVertical extends RoutingAction {
            @NotNull
            public final CategoryModel a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChangeVertical(@NotNull CategoryModel categoryModel) {
                super(null);
                Intrinsics.checkNotNullParameter(categoryModel, "wizardParameter");
                this.a = categoryModel;
            }

            public static /* synthetic */ ChangeVertical copy$default(ChangeVertical changeVertical, CategoryModel categoryModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    categoryModel = changeVertical.a;
                }
                return changeVertical.copy(categoryModel);
            }

            @NotNull
            public final CategoryModel component1() {
                return this.a;
            }

            @NotNull
            public final ChangeVertical copy(@NotNull CategoryModel categoryModel) {
                Intrinsics.checkNotNullParameter(categoryModel, "wizardParameter");
                return new ChangeVertical(categoryModel);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ChangeVertical) && Intrinsics.areEqual(this.a, ((ChangeVertical) obj).a);
                }
                return true;
            }

            @NotNull
            public final CategoryModel getWizardParameter() {
                return this.a;
            }

            public int hashCode() {
                CategoryModel categoryModel = this.a;
                if (categoryModel != null) {
                    return categoryModel.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ChangeVertical(wizardParameter=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ClearWizardScreen;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "", "component1", "()Z", "stayOnSuggests", "copy", "(Z)Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ClearWizardScreen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "getStayOnSuggests", "<init>", "(Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ClearWizardScreen extends RoutingAction {
            public final boolean a;

            public ClearWizardScreen(boolean z) {
                super(null);
                this.a = z;
            }

            public static /* synthetic */ ClearWizardScreen copy$default(ClearWizardScreen clearWizardScreen, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = clearWizardScreen.a;
                }
                return clearWizardScreen.copy(z);
            }

            public final boolean component1() {
                return this.a;
            }

            @NotNull
            public final ClearWizardScreen copy(boolean z) {
                return new ClearWizardScreen(z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ClearWizardScreen) && this.a == ((ClearWizardScreen) obj).a;
                }
                return true;
            }

            public final boolean getStayOnSuggests() {
                return this.a;
            }

            public int hashCode() {
                boolean z = this.a;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.B(a2.b.a.a.a.L("ClearWizardScreen(stayOnSuggests="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$SaveAndExitPublishing;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class SaveAndExitPublishing extends RoutingAction {
            @NotNull
            public static final SaveAndExitPublishing INSTANCE = new SaveAndExitPublishing();

            public SaveAndExitPublishing() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ShowOnboarding;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "Lru/avito/component/toolbar/OnboardingData;", AuthSource.SEND_ABUSE, "Lru/avito/component/toolbar/OnboardingData;", "getOnboardingData", "()Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "<init>", "(Lru/avito/component/toolbar/OnboardingData;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowOnboarding extends RoutingAction {
            @NotNull
            public final OnboardingData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowOnboarding(@NotNull OnboardingData onboardingData) {
                super(null);
                Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
                this.a = onboardingData;
            }

            @NotNull
            public final OnboardingData getOnboardingData() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction$ToWizardScreen;", "Lcom/avito/android/publish/category_suggest/CategoriesSuggestionsViewModel$RoutingAction;", "Lcom/avito/android/remote/model/Navigation;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "()Lcom/avito/android/remote/model/Navigation;", "navigation", "<init>", "(Lcom/avito/android/remote/model/Navigation;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToWizardScreen extends RoutingAction {
            @NotNull
            public final Navigation a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ToWizardScreen(@NotNull Navigation navigation) {
                super(null);
                Intrinsics.checkNotNullParameter(navigation, "navigation");
                this.a = navigation;
            }

            @NotNull
            public final Navigation getNavigation() {
                return this.a;
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error("Failed to loadSuggestions()", th);
            } else if (i == 1) {
                Logs.error("Failed to loadSuggestions()", th);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<OnboardingData> {
        public final /* synthetic */ CategoriesSuggestionsViewModel a;

        public b(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel) {
            this.a = categoriesSuggestionsViewModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(OnboardingData onboardingData) {
            OnboardingData onboardingData2 = onboardingData;
            SingleLiveEvent singleLiveEvent = this.a.e;
            Intrinsics.checkNotNullExpressionValue(onboardingData2, "it");
            singleLiveEvent.setValue(new RoutingAction.ShowOnboarding(onboardingData2));
        }
    }

    public static final class c<T> implements Consumer<CategoriesSuggestResponse> {
        public final /* synthetic */ CategoriesSuggestionsViewModel a;

        public c(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel) {
            this.a = categoriesSuggestionsViewModel;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(CategoriesSuggestResponse categoriesSuggestResponse) {
            CategoriesSuggestResponse categoriesSuggestResponse2 = categoriesSuggestResponse;
            CategoriesSuggestionsViewModel.access$updateStepStateIfNeeded(this.a, categoriesSuggestResponse2.getSelectedCategory(), categoriesSuggestResponse2.getSuggests());
        }
    }

    public static final class d<T, R> implements Function<CategoriesSuggestResponse, LoadingProgress<? super List<? extends Item>>> {
        public final /* synthetic */ CategoriesSuggestionsViewModel a;

        public d(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel) {
            this.a = categoriesSuggestionsViewModel;
        }

        @Override // io.reactivex.functions.Function
        public LoadingProgress<? super List<? extends Item>> apply(CategoriesSuggestResponse categoriesSuggestResponse) {
            Intrinsics.checkNotNullParameter(categoriesSuggestResponse, "it");
            return this.a.c();
        }
    }

    public static final class e<T, R> implements Function<Throwable, LoadingProgress<? super List<? extends Item>>> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public LoadingProgress<? super List<? extends Item>> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return new LoadingProgress.Error(new TypedError());
        }
    }

    public static final class f<T> implements Consumer<LoadingProgress<? super List<? extends Item>>> {
        public final /* synthetic */ CategoriesSuggestionsViewModel a;

        public f(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel) {
            this.a = categoriesSuggestionsViewModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingProgress<? super List<? extends Item>> loadingProgress) {
            LoadingProgress<? super List<? extends Item>> loadingProgress2 = loadingProgress;
            if (loadingProgress2 instanceof LoadingProgress.Loaded) {
                CategoriesSuggestionsViewModel.access$invalidateMainAction(this.a);
                if (CategoriesSuggestionsViewModel.access$getPublishViewModel$p(this.a).getState().getCurrentNavigationForStep(CategoriesSuggestionsViewModel.access$getPublishViewModel$p(this.a).getStepIndex()) != null || this.a.f()) {
                    this.a.e.setValue(new RoutingAction.ToWizardScreen(CategoriesSuggestionsViewModel.access$getPublishViewModel$p(this.a).getNavigation()));
                }
            }
            this.a.c.setValue(loadingProgress2);
        }
    }

    public CategoriesSuggestionsViewModel(@NotNull CategoriesSuggestionsInteractor categoriesSuggestionsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(categoriesSuggestionsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        this.k = categoriesSuggestionsInteractor;
        this.l = schedulersFactory;
        this.m = publishEventTracker;
        MutableLiveData<MainActionState> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(MainActionState.HIDDEN);
        Unit unit = Unit.INSTANCE;
        this.d = mutableLiveData;
        this.e = new SingleLiveEvent<>();
        this.f = new CompositeDisposable();
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel) {
        PublishViewModel publishViewModel = categoriesSuggestionsViewModel.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final void access$invalidateMainAction(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel) {
        categoriesSuggestionsViewModel.d.setValue(categoriesSuggestionsViewModel.e() ? MainActionState.HIDDEN : MainActionState.VISIBLE);
    }

    public static final void access$updateStepStateIfNeeded(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel, WizardParameter wizardParameter, List list) {
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = categoriesSuggestionsViewModel.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        if (!Intrinsics.areEqual(categoriesSuggestions.getSuggests(), list)) {
            PublishState.StepState.CategoriesSuggestions categoriesSuggestions2 = categoriesSuggestionsViewModel.j;
            if (categoriesSuggestions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stepState");
            }
            if ((!categoriesSuggestions2.getSuggests().isEmpty()) || categoriesSuggestionsViewModel.e()) {
                if (wizardParameter != null) {
                    PublishState.StepState.CategoriesSuggestions categoriesSuggestions3 = categoriesSuggestionsViewModel.j;
                    if (categoriesSuggestions3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stepState");
                    }
                    categoriesSuggestions3.setChosenCategory(wizardParameter);
                } else {
                    PublishState.StepState.CategoriesSuggestions categoriesSuggestions4 = categoriesSuggestionsViewModel.j;
                    if (categoriesSuggestions4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stepState");
                    }
                    if (!CollectionsKt___CollectionsKt.contains(list, categoriesSuggestions4.getChosenCategory())) {
                        PublishState.StepState.CategoriesSuggestions categoriesSuggestions5 = categoriesSuggestionsViewModel.j;
                        if (categoriesSuggestions5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stepState");
                        }
                        categoriesSuggestions5.setChosenCategory(null);
                    }
                }
            }
            PublishState.StepState.CategoriesSuggestions categoriesSuggestions6 = categoriesSuggestionsViewModel.j;
            if (categoriesSuggestions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stepState");
            }
            categoriesSuggestions6.setSuggests(list);
        }
    }

    public static /* synthetic */ void onCategorySelected$default(CategoriesSuggestionsViewModel categoriesSuggestionsViewModel, CategoryModel categoryModel, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        categoriesSuggestionsViewModel.onCategorySelected(categoryModel, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if (r5 != null) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.util.loading_state.LoadingProgress<java.util.List<? extends com.avito.conveyor_item.Item>> c() {
        /*
            r14 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = r14.f()
            if (r1 == 0) goto L_0x0011
            com.avito.android.util.loading_state.LoadingProgress$Loaded r1 = new com.avito.android.util.loading_state.LoadingProgress$Loaded
            r1.<init>(r0)
            return r1
        L_0x0011:
            com.avito.android.publish.PublishState$StepState$CategoriesSuggestions r1 = r14.j
            java.lang.String r2 = "stepState"
            if (r1 != 0) goto L_0x001a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x001a:
            com.avito.android.remote.model.CategoryModel r1 = r1.getChosenCategory()
            r3 = 1
            if (r1 == 0) goto L_0x0066
            com.avito.android.publish.select.CheckableItem r4 = new com.avito.android.publish.select.CheckableItem
            java.lang.String r5 = r1.getDescription()
            if (r5 == 0) goto L_0x005a
            java.lang.String r6 = r1.getTitle()
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r5 = t6.y.m.endsWith$default(r6, r5, r7, r8, r9)
            if (r5 == 0) goto L_0x003b
            java.lang.String r5 = r1.getTitle()
            goto L_0x0057
        L_0x003b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r1.getTitle()
            r5.append(r6)
            java.lang.String r6 = " · "
            r5.append(r6)
            java.lang.String r6 = r1.getDescription()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
        L_0x0057:
            if (r5 == 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            java.lang.String r5 = r1.getTitle()
        L_0x005e:
            java.lang.String r6 = "chosen_id"
            r4.<init>(r6, r5, r3)
            r0.add(r4)
        L_0x0066:
            com.avito.android.publish.PublishState$StepState$CategoriesSuggestions r4 = r14.j
            if (r4 != 0) goto L_0x006d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x006d:
            java.util.List r2 = r4.getSuggests()
            java.util.Iterator r2 = r2.iterator()
        L_0x0075:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00a2
            java.lang.Object r4 = r2.next()
            com.avito.android.remote.model.WizardParameter r4 = (com.avito.android.remote.model.WizardParameter) r4
            java.lang.String r5 = "null cannot be cast to non-null type com.avito.android.remote.model.CategoryModel"
            java.util.Objects.requireNonNull(r4, r5)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x0075
            com.avito.android.publish.wizard.WizardItem r5 = new com.avito.android.publish.wizard.WizardItem
            java.lang.String r6 = r4.getTitle()
            java.lang.String r7 = r4.getDescription()
            com.avito.android.remote.model.Navigation r4 = r4.getNavigation()
            r5.<init>(r6, r7, r4)
            r0.add(r5)
            goto L_0x0075
        L_0x00a2:
            com.avito.android.publish.wizard.WizardItem r1 = new com.avito.android.publish.wizard.WizardItem
            com.avito.android.remote.model.Navigation r11 = com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModelKt.getOTHER_CATEGORY_NAVIGATION()
            r10 = 0
            r12 = 2
            r13 = 0
            java.lang.String r9 = "Другая категория"
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13)
            r0.add(r1)
            com.avito.android.util.loading_state.LoadingProgress$Loaded r1 = new com.avito.android.util.loading_state.LoadingProgress$Loaded
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModel.c():com.avito.android.util.loading_state.LoadingProgress");
    }

    public final Navigation d() {
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = this.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        Navigation previousNavigation = categoriesSuggestions.getPreviousNavigation();
        if (previousNavigation != null) {
            return previousNavigation;
        }
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel.getNavigation();
    }

    public final boolean e() {
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = this.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        CategoryModel chosenCategory = categoriesSuggestions.getChosenCategory();
        if (chosenCategory == null) {
            return true;
        }
        Navigation navigation = chosenCategory.getNavigation();
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions2 = this.j;
        if (categoriesSuggestions2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        return Intrinsics.areEqual(navigation, categoriesSuggestions2.getPreviousNavigation());
    }

    public final boolean f() {
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = this.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        return categoriesSuggestions.getSuggests().isEmpty() && e();
    }

    public final void g() {
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
        if (categoryParameters == null) {
            PublishViewModel publishViewModel2 = this.g;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel2.handleErrorOrFail("Attempt to load suggests when category parameters null");
            return;
        }
        Navigation d2 = d();
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = this.k.loadSuggestions(categoryParameters, d2).subscribeOn(this.l.io()).doOnNext(new c(this)).map(new d(this)).observeOn(this.l.mainThread()).startWith((Observable<R>) ((R) new LoadingProgress.Loading())).doOnError(a.b).onErrorReturn(e.a).subscribe(new f(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadSuggestio…s()\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Nullable
    public final String getStepId() {
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel.getStepId();
    }

    public final void initScreen(int i2, @NotNull PublishViewModel publishViewModel, @NotNull PublishDraftDataHolder publishDraftDataHolder) {
        PublishState.StepState stepState;
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(publishDraftDataHolder, "publishDraftDataHolder");
        this.g = publishViewModel;
        this.h = publishViewModel.getParamsForStep(i2);
        this.i = publishDraftDataHolder;
        PublishState state = publishViewModel.getState();
        Parcelable parcelable = (PublishState.StepState) state.getStepStates().get(Integer.valueOf(i2));
        boolean z = true;
        if (!(parcelable instanceof PublishState.StepState.CategoriesSuggestions)) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                stepState = new PublishState.StepState.Wizard(null, null, null, 7, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                stepState = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                stepState = new PublishState.StepState.Vin(null, 1, null);
            } else {
                StringBuilder L = a2.b.a.a.a.L("Unknown StepState type '");
                L.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class));
                L.append('\'');
                throw new IllegalArgumentException(L.toString());
            }
            state.getStepStates().put(Integer.valueOf(i2), stepState);
            parcelable = (PublishState.StepState.CategoriesSuggestions) stepState;
        }
        this.j = (PublishState.StepState.CategoriesSuggestions) parcelable;
        if (i2 == publishViewModel.getStepIndex()) {
            if (this.c.getValue() != null) {
                z = false;
            }
            if (z) {
                g();
            } else {
                this.d.setValue(e() ? MainActionState.HIDDEN : MainActionState.VISIBLE);
                this.c.setValue(c());
            }
        }
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = publishViewModel.shouldShowDraftOnboardingForStep(i2).subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel\n       …ion.ShowOnboarding(it)) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<MainActionState> mainActionState() {
        return this.d;
    }

    public final void onCategoryListItemClicked(@NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        if (Intrinsics.areEqual(navigation, CategoriesSuggestionsViewModelKt.getOTHER_CATEGORY_NAVIGATION())) {
            this.m.trackOtherCategoryClick();
            this.e.setValue(new RoutingAction.ToWizardScreen(d()));
            return;
        }
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = this.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        WizardParameter wizardParameter = (WizardParameter) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(categoriesSuggestions.getSuggests()), new a2.a.a.e2.o.f(navigation)));
        if (wizardParameter == null) {
            PublishViewModel publishViewModel = this.g;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel.onUnexpectedErrorOccurred(new RuntimeException("clicked wizardParameter was not found in suggests list in " + this));
        } else if (wizardParameter.getHasChildren()) {
            this.e.setValue(new RoutingAction.ToWizardScreen(wizardParameter.getNavigation()));
        } else {
            onCategorySelected$default(this, wizardParameter, false, 2, null);
        }
    }

    public final void onCategorySelected(@NotNull CategoryModel categoryModel, boolean z) {
        PublishState.StepState stepState;
        Intrinsics.checkNotNullParameter(categoryModel, "selectedCategory");
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = this.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        WizardParameter wizardParameter = (WizardParameter) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(categoriesSuggestions.getSuggests()), new a2.a.a.e2.o.f(categoryModel.getNavigation())));
        if (wizardParameter != null) {
            categoryModel = wizardParameter;
        }
        if (categoryModel.isVerticalChange()) {
            this.e.setValue(new RoutingAction.ChangeVertical(categoryModel));
        } else if (z) {
            this.e.setValue(new RoutingAction.ClearWizardScreen(false));
            PublishViewModel publishViewModel = this.g;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel.updateStateWithCategory(categoryModel);
            PublishViewModel publishViewModel2 = this.g;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            PublishState state = publishViewModel2.getState();
            PublishViewModel publishViewModel3 = this.g;
            if (publishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            int stepIndex = publishViewModel3.getStepIndex();
            Parcelable parcelable = (PublishState.StepState) state.getStepStates().get(Integer.valueOf(stepIndex));
            if (!(parcelable instanceof PublishState.StepState.CategoriesSuggestions)) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                    stepState = new PublishState.StepState.Wizard(null, null, null, 7, null);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                    stepState = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                    stepState = new PublishState.StepState.Vin(null, 1, null);
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unknown StepState type '");
                    L.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class));
                    L.append('\'');
                    throw new IllegalArgumentException(L.toString());
                }
                state.getStepStates().put(Integer.valueOf(stepIndex), stepState);
                parcelable = (PublishState.StepState.CategoriesSuggestions) stepState;
            }
            this.j = (PublishState.StepState.CategoriesSuggestions) parcelable;
        } else {
            PublishViewModel publishViewModel4 = this.g;
            if (publishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel4.updateStateWithCategory(categoryModel);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.dispose();
        super.onCleared();
    }

    public final void onCloseClicked() {
        this.e.setValue(RoutingAction.SaveAndExitPublishing.INSTANCE);
    }

    public final void onLeaveClicked() {
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    public final void onLeaveWizardClicked() {
        if (f()) {
            PublishViewModel publishViewModel = this.g;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel.goToPreviousStep();
            return;
        }
        this.e.setValue(new RoutingAction.ClearWizardScreen(true));
    }

    public final void onMainButtonClicked() {
        PublishState.StepState.CategoriesSuggestions categoriesSuggestions = this.j;
        if (categoriesSuggestions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepState");
        }
        CategoryModel chosenCategory = categoriesSuggestions.getChosenCategory();
        if (chosenCategory != null) {
            onCategorySelected(chosenCategory, false);
        }
    }

    public final void onRetryClicked() {
        g();
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.e;
    }

    @NotNull
    public final LiveData<LoadingProgress<List<? extends Item>>> screenState() {
        return this.c;
    }
}
