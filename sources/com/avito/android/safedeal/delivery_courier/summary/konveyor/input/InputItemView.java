package com.avito.android.safedeal.delivery_courier.summary.konveyor.input;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0006J\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001f\u0010\u0006J\u0019\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b \u0010\u0006J\u0019\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b!\u0010\nJ\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b&\u0010\u0012¨\u0006'"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "value", "", "setPrefix", "(Ljava/lang/String;)V", "setPostfix", "", "setText", "(Ljava/lang/CharSequence;)V", "", "visible", "setClearVisible", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", PlatformActions.HIDE_KEYBOARD, "()V", "", "lines", "setMinLines", "(I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "status", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "text", "setTitle", "showError", "showNormal", "setHint", "Lcom/avito/android/lib/design/input/FormatterType;", "type", "setFormatterType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "setTextChangeListener", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface InputItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InputItemView inputItemView) {
            ItemView.DefaultImpls.onUnbind(inputItemView);
        }
    }

    void hideKeyboard();

    void setClearVisible(boolean z);

    void setFormatterType(@NotNull FormatterType formatterType);

    void setHint(@Nullable CharSequence charSequence);

    void setMinLines(int i);

    void setMotivation(@Nullable AttributedText attributedText);

    void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setPostfix(@NotNull String str);

    void setPrefix(@NotNull String str);

    void setText(@Nullable CharSequence charSequence);

    void setTextChangeListener(@Nullable Function1<? super String, Unit> function1);

    void setTitle(@NotNull String str);

    void showError(@Nullable String str);

    void showNormal(@Nullable String str);
}
