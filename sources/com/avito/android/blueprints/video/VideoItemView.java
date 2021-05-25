package com.avito.android.blueprints.video;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.Image;
import com.avito.android.util.FormattableInputView;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\u0007J%\u0010\u000e\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\fH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u0005H&¢\u0006\u0004\b!\u0010\u0017J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H&¢\u0006\u0004\b\"\u0010\u0007J\u000f\u0010#\u001a\u00020\u0005H&¢\u0006\u0004\b#\u0010\u0017J\u000f\u0010$\u001a\u00020\u0005H&¢\u0006\u0004\b$\u0010\u0017J!\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b'\u0010(J#\u0010+\u001a\u00020\u00052\b\b\u0001\u0010)\u001a\u00020\u00122\b\b\u0001\u0010*\u001a\u00020\u0012H&¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050-H&¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/avito/android/blueprints/video/VideoItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/util/FormattableInputView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "setFocusChangeListener", "", "limit", "setMaxLength", "(I)V", "setSingleLine", "()V", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "", "message", "setInputErrorState", "(Ljava/lang/CharSequence;)V", "setInputWarningState", "setInputNormalState", "setErrorState", "setLoadingState", "setEmptyState", "Lcom/avito/android/remote/model/Image;", "image", "setLoadedState", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "icon", "colorAttr", "setRightIcon", "(II)V", "Lkotlin/Function0;", "setRightIconClickListener", "(Lkotlin/jvm/functions/Function0;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface VideoItemView extends ItemView, FormattableInputView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull VideoItemView videoItemView) {
            ItemView.DefaultImpls.onUnbind(videoItemView);
        }
    }

    void setEmptyState();

    void setErrorState(@NotNull String str);

    void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setInputErrorState(@NotNull CharSequence charSequence);

    void setInputNormalState();

    void setInputType(@NotNull FormatterType formatterType);

    void setInputWarningState(@NotNull CharSequence charSequence);

    void setLoadedState(@Nullable Image image, @NotNull String str);

    void setLoadingState();

    void setMaxLength(int i);

    void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1);

    void setPlaceholder(@Nullable String str);

    void setRightIcon(@DrawableRes int i, @AttrRes int i2);

    void setRightIconClickListener(@NotNull Function0<Unit> function0);

    void setSingleLine();

    void setTitle(@NotNull String str);

    void setValue(@Nullable String str);
}
