package com.avito.android.social_management.adapter.header;

import com.avito.android.component.subheader.Subheader;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/social_management/adapter/header/HeaderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/subheader/Subheader;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/Observable;", "clicks", "()Lio/reactivex/Observable;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public interface HeaderItemView extends ItemView, Subheader {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HeaderItemView headerItemView) {
            ItemView.DefaultImpls.onUnbind(headerItemView);
        }
    }

    @NotNull
    Observable<Unit> clicks();

    void setUnbindListener(@Nullable Function0<Unit> function0);
}
