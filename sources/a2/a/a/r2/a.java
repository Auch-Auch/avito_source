package a2.a.a.r2;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.settings.SettingsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<TypedResult<Unit>> {
    public final /* synthetic */ SettingsPresenterImpl a;

    public a(SettingsPresenterImpl settingsPresenterImpl) {
        this.a = settingsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<Unit> typedResult) {
        TypedResult<Unit> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            SettingsPresenterImpl.access$onClearSearchHistorySuccess(this.a);
        } else if (typedResult2 instanceof TypedResult.OfError) {
            SettingsPresenterImpl.access$onClearSearchHistoryError(this.a, ((TypedResult.OfError) typedResult2).getError());
        }
    }
}
