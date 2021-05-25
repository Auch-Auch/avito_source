package com.avito.android.search.filter.adapter;

import com.avito.android.common.InputFormatter;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0012\u0010\bJ\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u000eJ%\u0010\u0019\u001a\u00020\u00022\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00020\u0017H&¢\u0006\u0004\b\u001c\u0010\u001aJ\u0019\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/search/filter/adapter/InputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", PlatformActions.HIDE_KEYBOARD, "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", "", "maxLines", "setMaxLines", "(I)V", "minLines", "setMinLines", "prefix", "setPrefix", "postfix", "setPostfix", "inputType", "setInputType", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "setOnFocusChangeListener", "Lcom/avito/android/common/InputFormatter;", "formatter", "setFormatter", "(Lcom/avito/android/common/InputFormatter;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface InputItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InputItemView inputItemView) {
            ItemView.DefaultImpls.onUnbind(inputItemView);
        }
    }

    void hideKeyboard();

    void setFormatter(@Nullable InputFormatter inputFormatter);

    void setInputType(int i);

    void setMaxLines(int i);

    void setMinLines(int i);

    void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setOnValueChangeListener(@NotNull Function1<? super String, Unit> function1);

    void setPostfix(@Nullable String str);

    void setPrefix(@Nullable String str);

    void setTitle(@NotNull String str);

    void setValue(@Nullable String str);
}
