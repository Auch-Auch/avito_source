package ru.avito.component.button;

import androidx.annotation.StringRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
@Deprecated(message = "Используй Button вместо этого")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH&¢\u0006\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lru/avito/component/button/Button;", "", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "", "enabled", "setEnabled", "(Z)V", "isEnabled", "()Z", "visible", "setVisible", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public interface Button {
    boolean isEnabled();

    void setClickListener(@Nullable Function0<Unit> function0);

    void setEnabled(boolean z);

    void setText(@StringRes int i);

    void setText(@Nullable CharSequence charSequence);

    void setVisible(boolean z);
}
