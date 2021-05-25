package com.avito.android.validation;

import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J#\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/validation/ParametersListPresenter;", "Lcom/avito/android/validation/SubmissionListener;", "", "subscribe", "()V", "unsubscribe", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "paramsToValidate", "paramsForConditionChecks", "sendParametersToValidator", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "Lio/reactivex/functions/Consumer;", "", "Lcom/avito/conveyor_item/Item;", "getItemListConsumer", "()Lio/reactivex/functions/Consumer;", "itemListConsumer", "Lio/reactivex/Observable;", "Lcom/avito/konveyor/data_source/DataSource;", "getAdapterDataChangeStream", "()Lio/reactivex/Observable;", "adapterDataChangeStream", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface ParametersListPresenter extends SubmissionListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendParametersToValidator$default(ParametersListPresenter parametersListPresenter, ParametersTree parametersTree, ParametersTree parametersTree2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    parametersTree2 = null;
                }
                parametersListPresenter.sendParametersToValidator(parametersTree, parametersTree2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendParametersToValidator");
        }
    }

    @NotNull
    Observable<DataSource<? extends Item>> getAdapterDataChangeStream();

    @NotNull
    Consumer<List<Item>> getItemListConsumer();

    void sendParametersToValidator(@NotNull ParametersTree parametersTree, @Nullable ParametersTree parametersTree2);

    void subscribe();

    void unsubscribe();
}
