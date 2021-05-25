package com.avito.android.component.clickable_element;

import androidx.annotation.StringRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0010\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/component/clickable_element/ClickableElement;", "Lru/avito/component/text/Text;", "", "enabled", "", "setEnabled", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setDescription", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ClickableElement extends Text {
    @NotNull
    Observable<Unit> clicks();

    void setDescription(@StringRes int i);

    void setDescription(@Nullable CharSequence charSequence);

    void setEnabled(boolean z);

    void setOnClickListener(@Nullable Function0<Unit> function0);
}
