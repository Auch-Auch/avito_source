package com.avito.android.blueprints;

import android.text.TextWatcher;
import com.avito.android.common.InputFormatter;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u000eJ\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0018\u0010\u0006J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000bH&¢\u0006\u0004\b\u001c\u0010\u000eJ#\u0010\u001e\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00040\u000fH&¢\u0006\u0004\b\u001e\u0010\u0012J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/blueprints/InputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", "error", "setError", "", "inputType", "setInputType", "(I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "maxLines", "setMaxLines", "minLines", "setMinLines", "prefix", "setPrefix", "postfix", "setPostfix", "labelMode", "setLabelMode", "", "setFocusChangeListener", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "Lcom/avito/android/common/InputFormatter;", "formatter", "setFormatter", "(Lcom/avito/android/common/InputFormatter;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface InputItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InputItemView inputItemView) {
            ItemView.DefaultImpls.onUnbind(inputItemView);
        }
    }

    void setError(@Nullable String str);

    void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setFormatter(@Nullable InputFormatter inputFormatter);

    void setInputType(int i);

    void setLabelMode(int i);

    void setMaxLines(int i);

    void setMinLines(int i);

    void setOnValueChangeListener(@NotNull Function1<? super String, Unit> function1);

    void setPostfix(@Nullable String str);

    void setPrefix(@Nullable String str);

    void setTextWatcher(@NotNull TextWatcher textWatcher);

    void setTitle(@NotNull String str);

    void setValue(@Nullable String str);
}
