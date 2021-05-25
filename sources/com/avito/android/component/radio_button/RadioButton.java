package com.avito.android.component.radio_button;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J+\u0010\f\u001a\u00020\u00042\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0013\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/component/radio_button/RadioButton;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnCheckedChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "", "resId", "setIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "icon", "(Landroid/graphics/drawable/Drawable;)V", "tint", "setIconTint", "(Ljava/lang/Integer;)V", "isEnabled", "()Z", "setEnabled", "(Z)V", "isChecked", "setChecked", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface RadioButton {
    boolean isChecked();

    boolean isEnabled();

    void setChecked(boolean z);

    void setEnabled(boolean z);

    void setIcon(@DrawableRes int i);

    void setIcon(@Nullable Drawable drawable);

    void setIconTint(@Nullable Integer num);

    void setOnCheckedChangeListener(@Nullable Function2<? super RadioButton, ? super Boolean, Unit> function2);

    void setOnClickListener(@Nullable Function1<? super RadioButton, Unit> function1);

    void setSubtitle(@Nullable String str);

    void setTitle(@NotNull String str);
}
