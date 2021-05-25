package com.avito.android.component.emotion_selector;

import android.content.Context;
import android.view.View;
import com.avito.android.component.emotion_selector.EmotionSelector;
import com.avito.android.component.emotion_selector.ImageSelectorView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%JI\u0010\u000b\u001a\u00020\t28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJE\u0010\u0011\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/component/emotion_selector/EmotionSelectorImpl;", "Lcom/avito/android/component/emotion_selector/EmotionSelector;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "selectedNumber", "", "fromUser", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedNumberChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "changeNumber", "Lkotlin/Function0;", "startTracking", "stopTracking", "setListener", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "clearListener", "()V", "show", "hide", "Lcom/avito/android/component/emotion_selector/ImageSelectorView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/component/emotion_selector/ImageSelectorView;", "selector", "value", "getSelectedNumber", "()I", "setSelectedNumber", "(I)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class EmotionSelectorImpl implements EmotionSelector {
    public final ImageSelectorView a;
    public final View b;

    public EmotionSelectorImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        View findViewById = view.findViewById(R.id.selector);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.component.emotion_selector.ImageSelectorView");
        ImageSelectorView imageSelectorView = (ImageSelectorView) findViewById;
        this.a = imageSelectorView;
        imageSelectorView.setImageScale(1.0f, 0.7692308f);
        Context context = imageSelectorView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.emotion_padding);
        imageSelectorView.setImagePaddings(dimensionPixelOffset, dimensionPixelOffset);
        imageSelectorView.setImages(R.drawable.ic_pouting_face, R.drawable.ic_white_frowning_face, R.drawable.ic_confused_face, R.drawable.ic_neutral_face, R.drawable.ic_slightly_smiling_face);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void clearListener() {
        this.a.setListener(null);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public int getSelectedNumber() {
        return this.a.getSelectedNumber();
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void hide() {
        Views.hide(this.b);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void setListener(@NotNull Function2<? super Integer, ? super Boolean, Unit> function2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function2, "changeNumber");
        Intrinsics.checkNotNullParameter(function0, "startTracking");
        Intrinsics.checkNotNullParameter(function02, "stopTracking");
        this.a.setListener(new ImageSelectorView.ChangeListener(function2, function0, function02) { // from class: com.avito.android.component.emotion_selector.EmotionSelectorImpl$setListener$1
            public final /* synthetic */ Function2 a;
            public final /* synthetic */ Function0 b;
            public final /* synthetic */ Function0 c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.avito.android.component.emotion_selector.ImageSelectorView.ChangeListener
            public void onSelectedNumberChanged(int i, boolean z) {
                this.a.invoke(Integer.valueOf(i), Boolean.valueOf(z));
            }

            @Override // com.avito.android.component.emotion_selector.ImageSelectorView.ChangeListener
            public void onStartTracking() {
                this.b.invoke();
            }

            @Override // com.avito.android.component.emotion_selector.ImageSelectorView.ChangeListener
            public void onStopTracking() {
                this.c.invoke();
            }
        });
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void setSelectedNumber(int i) {
        this.a.setSelectedNumber(i);
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void setSelectedNumberChangedListener(@Nullable Function2<? super Integer, ? super Boolean, Unit> function2) {
        if (function2 != null) {
            EmotionSelector.DefaultImpls.setListener$default(this, function2, null, null, 6, null);
        } else {
            clearListener();
        }
    }

    @Override // com.avito.android.component.emotion_selector.EmotionSelector
    public void show() {
        Views.show(this.b);
    }
}
