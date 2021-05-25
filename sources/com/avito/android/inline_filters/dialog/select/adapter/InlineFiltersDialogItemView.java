package com.avito.android.inline_filters.dialog.select.adapter;

import com.avito.android.remote.model.Image;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¢\u0006\u0004\b\u0016\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "setSecondaryText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "enable", "enableMultiselect", "(Z)V", "isChecked", "setChecked", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "setOnLayoutFinishedListener", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFiltersDialogItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void enableMultiselect(@NotNull InlineFiltersDialogItemView inlineFiltersDialogItemView, boolean z) {
        }

        public static void onUnbind(@NotNull InlineFiltersDialogItemView inlineFiltersDialogItemView) {
            ItemView.DefaultImpls.onUnbind(inlineFiltersDialogItemView);
        }

        public static void setImage(@NotNull InlineFiltersDialogItemView inlineFiltersDialogItemView, @Nullable Image image) {
        }

        public static void setOnLayoutFinishedListener(@NotNull InlineFiltersDialogItemView inlineFiltersDialogItemView, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public static void setSecondaryText(@NotNull InlineFiltersDialogItemView inlineFiltersDialogItemView, @Nullable String str) {
        }
    }

    void enableMultiselect(boolean z);

    void setChecked(boolean z);

    void setImage(@Nullable Image image);

    void setOnClickListener(@NotNull Function0<Unit> function0);

    void setOnLayoutFinishedListener(@NotNull Function0<Unit> function0);

    void setSecondaryText(@Nullable String str);

    void setText(@NotNull String str);
}
