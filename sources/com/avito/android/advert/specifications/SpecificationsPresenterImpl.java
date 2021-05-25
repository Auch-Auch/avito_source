package com.avito.android.advert.specifications;

import com.avito.android.advert_core.specifications.SpecificationsConverter;
import com.avito.android.advert_core.specifications.SpecificationsView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert/specifications/SpecificationsPresenterImpl;", "Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "Lcom/avito/android/advert_core/specifications/SpecificationsView;", "view", "Lkotlin/Function0;", "", "closeAction", "attachView", "(Lcom/avito/android/advert_core/specifications/SpecificationsView;Lkotlin/jvm/functions/Function0;)V", "detachView", "()V", "Lcom/avito/android/remote/model/ModelSpecifications;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/specifications/SpecificationsView;", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "c", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "converter", "<init>", "(Lcom/avito/android/remote/model/ModelSpecifications;Lcom/avito/android/advert_core/specifications/SpecificationsConverter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationsPresenterImpl implements SpecificationsPresenter {
    public SpecificationsView a;
    public final ModelSpecifications b;
    public final SpecificationsConverter c;

    @Inject
    public SpecificationsPresenterImpl(@Nullable ModelSpecifications modelSpecifications, @NotNull SpecificationsConverter specificationsConverter) {
        Intrinsics.checkNotNullParameter(specificationsConverter, "converter");
        this.b = modelSpecifications;
        this.c = specificationsConverter;
    }

    @Override // com.avito.android.advert.specifications.SpecificationsPresenter
    public void attachView(@NotNull SpecificationsView specificationsView, @NotNull Function0<Unit> function0) {
        SpecificationsView specificationsView2;
        Intrinsics.checkNotNullParameter(specificationsView, "view");
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        this.a = specificationsView;
        ModelSpecifications modelSpecifications = this.b;
        if (modelSpecifications != null) {
            Pair convertSpecifications$default = SpecificationsConverter.DefaultImpls.convertSpecifications$default(this.c, modelSpecifications, 0, 2, null);
            String title = this.b.getTitle();
            if (!(title == null || (specificationsView2 = this.a) == null)) {
                specificationsView2.setTitle(title);
            }
            SpecificationsView specificationsView3 = this.a;
            if (specificationsView3 != null) {
                specificationsView3.setData(((Number) convertSpecifications$default.getFirst()).intValue(), (List) convertSpecifications$default.getSecond());
                return;
            }
            return;
        }
        function0.invoke();
    }

    @Override // com.avito.android.advert.specifications.SpecificationsPresenter
    public void detachView() {
        this.a = null;
    }
}
