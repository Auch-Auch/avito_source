package com.avito.android.item_legacy.details;

import com.avito.android.select.Arguments;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/item_legacy/details/SelectParameterClickListener;", "", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "router", "attachRouter", "(Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;)V", "detachRouter", "()V", "Lcom/avito/conveyor_item/Item;", "element", "onElementClicked", "(Lcom/avito/conveyor_item/Item;)V", "Companion", "Router", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface SelectParameterClickListener {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String MIN_VALUES_FOR_SEARCH = "min_values_for_search";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Companion;", "", "", "MIN_VALUES_FOR_SEARCH", "Ljava/lang/String;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String MIN_VALUES_FOR_SEARCH = "min_values_for_search";
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "", "Lcom/avito/android/select/Arguments;", "arguments", "", "showSelectScreen", "(Lcom/avito/android/select/Arguments;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void showSelectScreen(@NotNull Arguments arguments);
    }

    void attachRouter(@Nullable Router router);

    void detachRouter();

    void onElementClicked(@NotNull Item item);

    void setParametersSource(@NotNull ParametersSource parametersSource);
}
