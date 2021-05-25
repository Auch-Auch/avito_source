package ru.avito.component.button_panel;

import androidx.annotation.StringRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010H&¢\u0006\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lru/avito/component/button_panel/ButtonPanel;", "", "", "text", "", "setPrimaryButtonText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "setSecondaryButtonText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPrimaryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSecondaryClickListener", "", "enabled", "setPrimaryButtonEnabled", "(Z)V", "setSecondaryButtonEnabled", "visible", "setSecondaryButtonVisible", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public interface ButtonPanel {
    void setPrimaryButtonEnabled(boolean z);

    void setPrimaryButtonText(@StringRes int i);

    void setPrimaryButtonText(@Nullable CharSequence charSequence);

    void setPrimaryClickListener(@Nullable Function0<Unit> function0);

    void setSecondaryButtonEnabled(boolean z);

    void setSecondaryButtonText(@StringRes int i);

    void setSecondaryButtonText(@Nullable CharSequence charSequence);

    void setSecondaryButtonVisible(boolean z);

    void setSecondaryClickListener(@Nullable Function0<Unit> function0);
}
