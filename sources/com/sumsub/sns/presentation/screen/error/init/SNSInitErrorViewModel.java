package com.sumsub.sns.presentation.screen.error.init;

import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.presentation.screen.error.SNSBaseErrorViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/init/SNSInitErrorViewModel;", "Lcom/sumsub/sns/presentation/screen/error/SNSBaseErrorViewModel;", "Lcom/sumsub/sns/core/data/model/Error;", "getType", "()Lcom/sumsub/sns/core/data/model/Error;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSInitErrorViewModel extends SNSBaseErrorViewModel {
    @Override // com.sumsub.sns.presentation.screen.error.SNSBaseErrorViewModel
    @NotNull
    public Error getType() {
        return new Error.Init(null, 1, null);
    }
}
