package com.avito.android.publish.details.adapter.date_interval;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\nJ\u001f\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001f\u0010\u0006J\u0019\u0010 \u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b \u0010\u0006J%\u0010\"\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "visible", "setStartSelectVisible", "(Z)V", "setEndSelectVisible", "setPresentTimeCheckboxVisibility", "text", "setPresentTimeCheckboxText", "isChecked", "setPresentTimeCheckboxValue", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStartSelectClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setEndSelectClickListener", "", "error", "setStartSelectStateToError", "(Ljava/lang/CharSequence;)V", "setEndSelectStateToError", "setAllStatesToError", "setStartSelectStateToNormal", "()V", "setEndSelectStateToNormal", "setStartSelectText", "setEndSelectText", "Lkotlin/Function1;", "setPresentTimeCheckboxListener", "(Lkotlin/jvm/functions/Function1;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface DateIntervalItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull DateIntervalItemView dateIntervalItemView) {
            ItemView.DefaultImpls.onUnbind(dateIntervalItemView);
        }
    }

    void setAllStatesToError(@NotNull CharSequence charSequence);

    void setEndSelectClickListener(@Nullable Function0<Unit> function0);

    void setEndSelectStateToError(@NotNull CharSequence charSequence);

    void setEndSelectStateToNormal();

    void setEndSelectText(@Nullable String str);

    void setEndSelectVisible(boolean z);

    void setPresentTimeCheckboxListener(@Nullable Function1<? super Boolean, Unit> function1);

    void setPresentTimeCheckboxText(@Nullable String str);

    void setPresentTimeCheckboxValue(boolean z);

    void setPresentTimeCheckboxVisibility(boolean z);

    void setStartSelectClickListener(@Nullable Function0<Unit> function0);

    void setStartSelectStateToError(@NotNull CharSequence charSequence);

    void setStartSelectStateToNormal();

    void setStartSelectText(@Nullable String str);

    void setStartSelectVisible(boolean z);

    void setTitle(@NotNull String str);
}
