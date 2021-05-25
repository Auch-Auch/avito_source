package a2.a.a.e3.d.e;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import java.util.Objects;
public final class a<T> implements Consumer<LoadingState<? super Object>> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public a(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Object> loadingState) {
        LoadingState<? super Object> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.loadData();
        } else if (loadingState2 instanceof LoadingState.Error) {
            MutableLiveData mutableLiveData = this.a.j;
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            Objects.requireNonNull(error, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorResult");
            mutableLiveData.postValue(((ErrorResult) error).getMessage());
        }
        this.a.p.postValue(new Object());
    }
}
