package com.avito.android.developments_catalog.items.consultation;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/developments_catalog/items/consultation/ConsultationView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "bindTitle", "(Ljava/lang/String;)V", "description", "bindSubtitle", "buttonTitle", "bindButton", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addListener", "(Lcom/avito/android/developments_catalog/items/consultation/ConsultationView$Listener;)V", "Listener", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface ConsultationView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ConsultationView consultationView) {
            ItemView.DefaultImpls.onUnbind(consultationView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/developments_catalog/items/consultation/ConsultationView$Listener;", "", "", "onSubmitConsultationRequestClick", "()V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onSubmitConsultationRequestClick();
    }

    void addListener(@NotNull Listener listener);

    void bindButton(@NotNull String str);

    void bindSubtitle(@NotNull String str);

    void bindTitle(@NotNull String str);
}
