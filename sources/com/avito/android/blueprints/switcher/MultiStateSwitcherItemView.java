package com.avito.android.blueprints.switcher;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\nJ\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "value", "", "bindHeader", "(Ljava/lang/String;)V", "setTitle", "", "setSubTitle", "(Ljava/lang/CharSequence;)V", "", "isChecked", "setChecked", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckListener", "(Lkotlin/jvm/functions/Function1;)V", "message", "setErrorState", "setWarningState", "setNormalState", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStateSwitcherItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MultiStateSwitcherItemView multiStateSwitcherItemView) {
            ItemView.DefaultImpls.onUnbind(multiStateSwitcherItemView);
        }
    }

    void bindHeader(@Nullable String str);

    void setCheckListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setChecked(boolean z);

    void setErrorState(@NotNull CharSequence charSequence);

    void setNormalState(@Nullable CharSequence charSequence);

    void setSubTitle(@Nullable CharSequence charSequence);

    void setTitle(@NotNull String str);

    void setWarningState(@NotNull CharSequence charSequence);
}
