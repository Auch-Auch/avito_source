package com.avito.android.publish.details.adapter.objects;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\nH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "clearItems", "()V", "text", "Lkotlin/Function0;", "clickListener", "addItem", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "appendAddMoreButton", "(Lkotlin/jvm/functions/Function0;)V", "tag", "setTag", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface MultiStateObjectsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MultiStateObjectsItemView multiStateObjectsItemView) {
            ItemView.DefaultImpls.onUnbind(multiStateObjectsItemView);
        }
    }

    void addItem(@NotNull String str, @NotNull Function0<Unit> function0);

    void appendAddMoreButton(@NotNull Function0<Unit> function0);

    void clearItems();

    void setTag(@NotNull String str);

    void setTitle(@Nullable String str);
}
