package com.avito.android.str_calendar.seller.edit.konveyor.input;

import com.avito.android.common.InputFormatter;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0019H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/common/InputFormatter;", "formatter", "", "inputType", "prefix", "postfix", "initInput", "(Lcom/avito/android/common/InputFormatter;ILjava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "value", "setValue", "(Ljava/lang/String;)V", "error", "setError", "", "visible", "setClearVisible", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setOnFocusChangeListener", "Lkotlin/Function0;", "setOnClearClickListener", "(Lkotlin/jvm/functions/Function0;)V", PlatformActions.HIDE_KEYBOARD, "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface RdsInputItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull RdsInputItemView rdsInputItemView) {
            ItemView.DefaultImpls.onUnbind(rdsInputItemView);
        }
    }

    void hideKeyboard();

    void initInput(@Nullable InputFormatter inputFormatter, int i, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2);

    void setClearVisible(boolean z);

    void setError(@Nullable String str);

    void setOnClearClickListener(@NotNull Function0<Unit> function0);

    void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setOnValueChangeListener(@NotNull Function1<? super String, Unit> function1);

    void setTitle(@NotNull CharSequence charSequence);

    void setValue(@Nullable String str);
}
