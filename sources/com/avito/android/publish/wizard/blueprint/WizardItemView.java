package com.avito.android.publish.wizard.blueprint;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/wizard/blueprint/WizardItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubtitle", "Lkotlin/Function0;", "func", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface WizardItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull WizardItemView wizardItemView) {
            ItemView.DefaultImpls.onUnbind(wizardItemView);
        }
    }

    void setOnItemClickListener(@NotNull Function0<Unit> function0);

    void setSubtitle(@Nullable String str);

    void setTitle(@Nullable String str);
}
