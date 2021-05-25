package ru.sravni.android.bankproduct.utils.adapter;

import androidx.databinding.BindingAdapter;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/android/material/slider/Slider;", "slider", "Lru/sravni/android/bankproduct/utils/adapter/ISliderPositionListener;", "positionListener", "", "bindPositionListener", "(Lcom/google/android/material/slider/Slider;Lru/sravni/android/bankproduct/utils/adapter/ISliderPositionListener;)V", "", "pointsCount", "bindValueIntervalToSlider", "(Lcom/google/android/material/slider/Slider;Ljava/lang/Integer;)V", "", "", "sliderValues", "bindValueStringToSlider", "(Lcom/google/android/material/slider/Slider;Ljava/util/List;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingSliderKt {

    public static final class a implements Slider.OnChangeListener {
        public final /* synthetic */ ISliderPositionListener a;

        public a(ISliderPositionListener iSliderPositionListener) {
            this.a = iSliderPositionListener;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float, boolean] */
        @Override // com.google.android.material.slider.BaseOnChangeListener
        public void onValueChange(Slider slider, float f, boolean z) {
            Intrinsics.checkParameterIsNotNull(slider, "<anonymous parameter 0>");
            this.a.onSliderPositionChanged(f);
        }
    }

    public static final class b implements LabelFormatter {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // com.google.android.material.slider.LabelFormatter
        @NotNull
        public final String getFormattedValue(float f) {
            return (String) this.a.get((int) f);
        }
    }

    @BindingAdapter({"sliderPositionListener"})
    public static final void bindPositionListener(@NotNull Slider slider, @NotNull ISliderPositionListener iSliderPositionListener) {
        Intrinsics.checkParameterIsNotNull(slider, "slider");
        Intrinsics.checkParameterIsNotNull(iSliderPositionListener, "positionListener");
        slider.addOnChangeListener(new a(iSliderPositionListener));
    }

    @BindingAdapter({"pointsCount"})
    public static final void bindValueIntervalToSlider(@NotNull Slider slider, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(slider, "slider");
        slider.setValueFrom(0.0f);
        Float valueOf = num != null ? Float.valueOf((float) num.intValue()) : null;
        if (valueOf == null) {
            valueOf = Float.valueOf(1000.0f);
        }
        slider.setValueTo(valueOf.floatValue());
    }

    @BindingAdapter({"sliderValues"})
    public static final void bindValueStringToSlider(@NotNull Slider slider, @Nullable List<String> list) {
        Intrinsics.checkParameterIsNotNull(slider, "slider");
        if (list != null) {
            slider.setLabelFormatter(new b(list));
        }
    }
}
