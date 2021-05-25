package com.avito.android.profile.cards;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/cards/ExtensionsCardItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "text", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addActionButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "addExtensionInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtensionsCardItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ExtensionsCardItemView extensionsCardItemView) {
            ItemView.DefaultImpls.onUnbind(extensionsCardItemView);
        }
    }

    void addActionButton(@NotNull String str, @NotNull Function0<Unit> function0);

    void addExtensionInfo(@NotNull String str, @NotNull String str2);

    void setDescription(@Nullable String str);

    void setTitle(@NotNull String str);
}
