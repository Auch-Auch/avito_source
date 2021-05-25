package com.avito.android.publish.details.adapter.objects.old;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "clearItems", "()V", "firstSubtitle", "secondSubtitle", "Lkotlin/Function0;", "clickListener", "addItem", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAddMoreClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "visible", "setAddMoreButtonVisible", "(Z)V", "setAddMoreButtonTitle", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ObjectsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ObjectsItemView objectsItemView) {
            ItemView.DefaultImpls.onUnbind(objectsItemView);
        }
    }

    void addItem(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull Function0<Unit> function0);

    void clearItems();

    void setAddMoreButtonTitle(@NotNull String str);

    void setAddMoreButtonVisible(boolean z);

    void setOnAddMoreClickListener(@NotNull Function0<Unit> function0);

    void setTitle(@NotNull String str);
}
