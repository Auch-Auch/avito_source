package com.avito.android.advert_core.specifications;

import com.avito.android.remote.model.ModelSpecifications;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "", "schemePos", "Lkotlin/Pair;", "", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "convertSpecifications", "(Lcom/avito/android/remote/model/ModelSpecifications;I)Lkotlin/Pair;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface SpecificationsConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Pair convertSpecifications$default(SpecificationsConverter specificationsConverter, ModelSpecifications modelSpecifications, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = -2;
                }
                return specificationsConverter.convertSpecifications(modelSpecifications, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertSpecifications");
        }
    }

    @NotNull
    Pair<Integer, List<SpecificationData>> convertSpecifications(@NotNull ModelSpecifications modelSpecifications, int i);
}
