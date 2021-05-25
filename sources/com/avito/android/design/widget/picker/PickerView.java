package com.avito.android.design.widget.picker;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/design/widget/picker/PickerView;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", VKApiConst.POSITION, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lkotlin/jvm/functions/Function1;)V", "", "", ResidentialComplexModuleKt.VALUES, "", "allowEmpty", "setValues", "(Ljava/util/List;Z)V", "smoothScroll", "scrollToValue", "(IZ)V", "setHighlightedPosition", "(Ljava/lang/Integer;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface PickerView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void scrollToValue$default(PickerView pickerView, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = true;
                }
                pickerView.scrollToValue(i, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToValue");
        }
    }

    void scrollToValue(int i, boolean z);

    void setHighlightedPosition(@Nullable Integer num);

    void setListener(@NotNull Function1<? super Integer, Unit> function1);

    void setValues(@NotNull List<String> list, boolean z);
}
