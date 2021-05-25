package a2.a.a.e2.w;

import a2.b.a.a.a;
import android.os.Parcelable;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.input_vin.InputVinViewModel;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
public final class i<T> implements Consumer<MultiStateLoading.Error> {
    public final /* synthetic */ InputVinViewModel a;

    public i(InputVinViewModel inputVinViewModel) {
        this.a = inputVinViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r13v12, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX DEBUG: Multi-variable search result rejected for r13v18, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(MultiStateLoading.Error error) {
        PublishState.StepState stepState;
        if (error.getError() instanceof ErrorResult.NetworkIOError) {
            this.a.d.setValue(new InputVinViewModel.InputVinEvents.ShowErrorMessage(this.a.p.getConnectionError()));
            return;
        }
        PublishState state = InputVinViewModel.access$getPublishViewModel$p(this.a).getState();
        int i = this.a.i;
        Parcelable parcelable = (PublishState.StepState) state.getStepStates().get(Integer.valueOf(i));
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
            state.getStepStates().put(Integer.valueOf(i), stepState);
            parcelable = (PublishState.StepState.Vin) stepState;
        }
        ((PublishState.StepState.Vin) parcelable).setRecognizedVin(this.a.getVinTextChangedRelay().getValue());
        this.a.d.setValue(InputVinViewModel.InputVinEvents.DismissProgressDialog.INSTANCE);
        PublishViewModel.goToNextStep$default(InputVinViewModel.access$getPublishViewModel$p(this.a), null, 1, null);
    }
}
