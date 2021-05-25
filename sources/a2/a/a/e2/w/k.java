package a2.a.a.e2.w;

import a2.b.a.a.a;
import android.os.Parcelable;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.input_vin.InputVinViewModel;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
public final class k<T> implements Consumer<CategoryParameters> {
    public final /* synthetic */ InputVinViewModel a;

    public k(InputVinViewModel inputVinViewModel) {
        this.a = inputVinViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(CategoryParameters categoryParameters) {
        CategoryParameters cloneWithNewParameters;
        PublishState.StepState stepState;
        CategoryParameters categoryParameters2 = categoryParameters;
        PublishViewModel access$getPublishViewModel$p = InputVinViewModel.access$getPublishViewModel$p(this.a);
        PublishState state = access$getPublishViewModel$p.getState();
        int stepIndex = access$getPublishViewModel$p.getStepIndex();
        Parcelable parcelable = (PublishState.StepState) state.getStepStates().get(Integer.valueOf(stepIndex));
        if (!(parcelable instanceof PublishState.StepState.Vin)) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                stepState = new PublishState.StepState.Wizard(null, null, null, 7, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                stepState = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                stepState = new PublishState.StepState.Vin(null, 1, null);
            } else {
                StringBuilder L = a.L("Unknown StepState type '");
                L.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class));
                L.append('\'');
                throw new IllegalArgumentException(L.toString());
            }
            state.getStepStates().put(Integer.valueOf(stepIndex), stepState);
            parcelable = (PublishState.StepState.Vin) stepState;
        }
        ((PublishState.StepState.Vin) parcelable).setRecognizedVin(this.a.getVinTextChangedRelay().getValue());
        this.a.d.setValue(InputVinViewModel.InputVinEvents.DismissProgressDialog.INSTANCE);
        CategoryParameters categoryParameters3 = access$getPublishViewModel$p.getCategoryParameters();
        if (!(categoryParameters3 == null || (cloneWithNewParameters = categoryParameters3.cloneWithNewParameters(categoryParameters2.getParameters(), categoryParameters2.getChangedIds())) == null)) {
            access$getPublishViewModel$p.setCategoryParametersAndInitSteps(cloneWithNewParameters);
        }
        PublishViewModel.goToNextStep$default(access$getPublishViewModel$p, null, 1, null);
    }
}
