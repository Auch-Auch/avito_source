package com.avito.android.str_calendar.seller.edit;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005¨\u0006/"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "", "Landroidx/lifecycle/LiveData;", "", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "Ljava/lang/Runnable;", "getErrorChanges", "errorChanges", "Lio/reactivex/functions/Consumer;", "getApplyClicksConsumer", "()Lio/reactivex/functions/Consumer;", "applyClicksConsumer", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "getChipsSelectConsumer", "chipsSelectConsumer", "getGetDataConsumer", "getDataConsumer", "", "getEnableApplyButtonChanges", "enableApplyButtonChanges", "getRadioGroupSelectConsumer", "radioGroupSelectConsumer", "getShowContentChanges", "showContentChanges", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "adapterPresenter", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "getChangeConsumer", "changeConsumer", "getCloseScreenChanges", "closeScreenChanges", "", "", "getGroupsBoundsChanges", "groupsBoundsChanges", "", "getErrorMessageChanges", "errorMessageChanges", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getUpdateViewChanges", "updateViewChanges", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerCalendarParametersViewModel {
    @Nullable
    AdapterPresenter getAdapterPresenter();

    @NotNull
    Consumer<Unit> getApplyClicksConsumer();

    @NotNull
    Consumer<ParameterElement.Input> getChangeConsumer();

    @NotNull
    Consumer<ParameterElement.Select> getChipsSelectConsumer();

    @NotNull
    LiveData<Boolean> getCloseScreenChanges();

    @NotNull
    LiveData<Boolean> getEnableApplyButtonChanges();

    @NotNull
    LiveData<Runnable> getErrorChanges();

    @NotNull
    LiveData<String> getErrorMessageChanges();

    @NotNull
    Consumer<Unit> getGetDataConsumer();

    @NotNull
    LiveData<Set<Integer>> getGroupsBoundsChanges();

    @NotNull
    LiveData<Unit> getProgressChanges();

    @NotNull
    Consumer<ParameterElement.Select> getRadioGroupSelectConsumer();

    @NotNull
    LiveData<Unit> getShowContentChanges();

    @NotNull
    LiveData<DiffUtil.DiffResult> getUpdateViewChanges();

    void setAdapterPresenter(@Nullable AdapterPresenter adapterPresenter);
}
