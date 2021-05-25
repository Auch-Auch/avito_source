package com.avito.android.notification_center.landing.unified.pair_button;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setFirstText", "(Ljava/lang/String;)V", "setSecondText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setFirstClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSecondClickListener", "setUnbindListener", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface UnifiedPairButtonView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UnifiedPairButtonView unifiedPairButtonView) {
            ItemView.DefaultImpls.onUnbind(unifiedPairButtonView);
        }
    }

    void setFirstClickListener(@Nullable Function0<Unit> function0);

    void setFirstText(@NotNull String str);

    void setSecondClickListener(@Nullable Function0<Unit> function0);

    void setSecondText(@NotNull String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
