package com.avito.android.abuse.details.adapter;

import com.avito.android.abuse.details.adapter.AbuseField;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.info_label.InfoLabelItemView;
import ru.avito.component.info_label.InfoLevel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/abuse/details/adapter/ErrorLabelItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/ErrorLabelItemPresenter;", "Lru/avito/component/info_label/InfoLabelItemView;", "view", "Lcom/avito/android/abuse/details/adapter/AbuseField$ErrorLabel;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/info_label/InfoLabelItemView;Lcom/avito/android/abuse/details/adapter/AbuseField$ErrorLabel;I)V", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorLabelItemPresenterImpl implements ErrorLabelItemPresenter {
    public void bindView(@NotNull InfoLabelItemView infoLabelItemView, @NotNull AbuseField.ErrorLabel errorLabel, int i) {
        Intrinsics.checkNotNullParameter(infoLabelItemView, "view");
        Intrinsics.checkNotNullParameter(errorLabel, "item");
        infoLabelItemView.setValues(errorLabel.getMessage(), InfoLevel.ERROR);
    }
}
