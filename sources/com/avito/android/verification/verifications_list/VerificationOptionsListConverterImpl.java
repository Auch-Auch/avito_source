package com.avito.android.verification.verifications_list;

import com.avito.android.remote.model.VerificationOption;
import com.avito.android.remote.model.VerificationOptionsListResult;
import com.avito.android.verification.VerificationStatus;
import com.avito.android.verification.verifications_list.list.VerificationOptionItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverterImpl;", "Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverter;", "Lcom/avito/android/remote/model/VerificationOptionsListResult;", "result", "Lcom/avito/android/verification/verifications_list/VerificationListScreenData;", "convert", "(Lcom/avito/android/remote/model/VerificationOptionsListResult;)Lcom/avito/android/verification/verifications_list/VerificationListScreenData;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationOptionsListConverterImpl implements VerificationOptionsListConverter {
    @Override // com.avito.android.verification.verifications_list.VerificationOptionsListConverter
    @NotNull
    public VerificationListScreenData convert(@NotNull VerificationOptionsListResult verificationOptionsListResult) {
        Intrinsics.checkNotNullParameter(verificationOptionsListResult, "result");
        String title = verificationOptionsListResult.getTitle();
        List<VerificationOption> optionsList = verificationOptionsListResult.getOptionsList();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(optionsList, 10));
        for (T t : optionsList) {
            String type = t.getType();
            String type2 = t.getType();
            String title2 = t.getTitle();
            String subTitle = t.getSubTitle();
            String status = t.getStatus();
            if (status == null) {
                status = VerificationStatus.INFO.getType();
            }
            arrayList.add(new VerificationOptionItem(type, type2, title2, subTitle, VerificationStatus.Companion.valueOfType(status)));
        }
        return new VerificationListScreenData(title, arrayList);
    }
}
