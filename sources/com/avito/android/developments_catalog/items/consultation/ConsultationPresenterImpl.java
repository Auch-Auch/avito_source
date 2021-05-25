package com.avito.android.developments_catalog.items.consultation;

import com.avito.android.developments_catalog.DevelopmentsCatalogRouter;
import com.avito.android.developments_catalog.items.consultation.ConsultationView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/developments_catalog/items/consultation/ConsultationPresenterImpl;", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationPresenter;", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationView;", "view", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/consultation/ConsultationView;Lcom/avito/android/developments_catalog/items/consultation/ConsultationItem;I)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "attachRouter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;)V", "detachRouter", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "<init>", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationPresenterImpl implements ConsultationPresenter {
    public DevelopmentsCatalogRouter a;

    @Override // com.avito.android.developments_catalog.items.consultation.ConsultationPresenter
    public void attachRouter(@Nullable DevelopmentsCatalogRouter developmentsCatalogRouter) {
        this.a = developmentsCatalogRouter;
    }

    @Override // com.avito.android.developments_catalog.items.consultation.ConsultationPresenter
    public void detachRouter() {
        this.a = null;
    }

    public void bindView(@NotNull ConsultationView consultationView, @NotNull ConsultationItem consultationItem, int i) {
        Intrinsics.checkNotNullParameter(consultationView, "view");
        Intrinsics.checkNotNullParameter(consultationItem, "item");
        consultationView.bindTitle(consultationItem.getViewData().getTitle());
        consultationView.bindSubtitle(consultationItem.getViewData().getDescription());
        consultationView.bindButton(consultationItem.getViewData().getButtonTitle());
        consultationView.addListener(new ConsultationView.Listener(this, consultationItem) { // from class: com.avito.android.developments_catalog.items.consultation.ConsultationPresenterImpl$bindView$1
            public final /* synthetic */ ConsultationPresenterImpl a;
            public final /* synthetic */ ConsultationItem b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.developments_catalog.items.consultation.ConsultationView.Listener
            public void onSubmitConsultationRequestClick() {
                DevelopmentsCatalogRouter access$getRouter$p = ConsultationPresenterImpl.access$getRouter$p(this.a);
                if (access$getRouter$p != null) {
                    access$getRouter$p.openConsultationForm(this.b.getDevelopmentId(), this.b.getFormData());
                }
            }
        });
    }
}
