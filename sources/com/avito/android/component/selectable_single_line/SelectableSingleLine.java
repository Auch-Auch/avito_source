package com.avito.android.component.selectable_single_line;

import androidx.annotation.StringRes;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH&¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH&¢\u0006\u0004\b \u0010\u001fJ\u001d\u0010#\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H&¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H&¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010\u001b¨\u0006'"}, d2 = {"Lcom/avito/android/component/selectable_single_line/SelectableSingleLine;", "", "", "value", "", "setValue", "(Ljava/lang/String;)V", "", ResidentialComplexModuleKt.VALUES, "setValues", "(Ljava/util/List;)V", "", "visible", "setClearButtonVisible", "(Z)V", "hasError", "setHasError", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "", "hintRes", "(I)V", "enabled", "setEnabled", "show", "()V", "hide", "Lio/reactivex/rxjava3/core/Observable;", "clearClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClearClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnClickListener", "removeOnClickListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SelectableSingleLine {
    @NotNull
    Observable<Unit> clearClicks();

    @NotNull
    Observable<Unit> clicks();

    void hide();

    void removeOnClickListener();

    void setClearButtonVisible(boolean z);

    void setEnabled(boolean z);

    void setHasError(boolean z);

    void setHint(@StringRes int i);

    void setHint(@NotNull CharSequence charSequence);

    void setOnClearClickListener(@NotNull Function0<Unit> function0);

    void setOnClickListener(@NotNull Function0<Unit> function0);

    void setValue(@Nullable String str);

    void setValues(@NotNull List<String> list);

    void show();
}
