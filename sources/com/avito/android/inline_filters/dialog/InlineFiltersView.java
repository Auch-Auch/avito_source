package com.avito.android.inline_filters.dialog;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0011H&¢\u0006\u0004\b\u0018\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H&¢\u0006\u0004\b\u001e\u0010\u001cJ)\u0010!\u001a\u00020\u00052\u0018\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0004\u0012\u00020\u00050\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H&¢\u0006\u0004\b#\u0010\u0014J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\bH&¢\u0006\u0004\b)\u0010\u000bJ\u001d\u0010+\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0016¢\u0006\u0004\b+\u0010\u001cR\u001e\u00101\u001a\u0004\u0018\u00010,8&@&X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/avito/android/inline_filters/dialog/InlineFiltersView;", "", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "items", "", "setItemsView", "(Ljava/util/List;)V", "", "titleText", "setTitle", "(Ljava/lang/String;)V", "resetActionHint", "setResetActionHint", "Lio/reactivex/Observable;", "selectAction", "()Lio/reactivex/Observable;", "", "clickable", "setResetActionClickable", "(Z)V", "visible", "setResetActionVisibility", "enabled", "setBackButtonEnabled", "Lkotlin/Function0;", "resetAction", "setResetAction", "(Lkotlin/jvm/functions/Function0;)V", "closeAction", "setCloseAction", "Lkotlin/Function1;", "applyAction", "setApplyAction", "(Lkotlin/jvm/functions/Function1;)V", "setApplyBtnVisible", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "setSearchInputVisibility", "(I)V", "text", "setApplyBtnText", "exposeAction", "setImageFilterExposeAction", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", "state", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFiltersView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setImageFilterExposeAction(@NotNull InlineFiltersView inlineFiltersView, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "exposeAction");
        }
    }

    @Nullable
    Parcelable getState();

    @NotNull
    Observable<InlineFiltersDialogItem> selectAction();

    void setApplyAction(@NotNull Function1<? super List<String>, Unit> function1);

    void setApplyBtnText(@NotNull String str);

    void setApplyBtnVisible(boolean z);

    void setBackButtonEnabled(boolean z);

    void setCloseAction(@NotNull Function0<Unit> function0);

    void setImageFilterExposeAction(@NotNull Function0<Unit> function0);

    void setItemsView(@NotNull List<InlineFiltersDialogItem> list);

    void setResetAction(@NotNull Function0<Unit> function0);

    void setResetActionClickable(boolean z);

    void setResetActionHint(@NotNull String str);

    void setResetActionVisibility(boolean z);

    void setSearchInputVisibility(int i);

    void setState(@Nullable Parcelable parcelable);

    void setTitle(@NotNull String str);
}
