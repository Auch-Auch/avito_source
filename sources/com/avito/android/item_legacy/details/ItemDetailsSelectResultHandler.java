package com.avito.android.item_legacy.details;

import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.select.SelectListener;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "Lcom/avito/android/select/SelectListener;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "attachResultListener", "(Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "parametersSource", "attachParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "onAddressParameterChanged", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "updatedParameter", "onObjectsParameterChanged", "(Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;)V", "ResultListener", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface ItemDetailsSelectResultHandler extends SelectListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onCancel(@NotNull ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "requestId");
            SelectListener.DefaultImpls.onCancel(itemDetailsSelectResultHandler, str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;", "", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "", "onResultHandled", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "", "updatesFormForParamId", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "onParametersUpdated", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "onUpdateAddress", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public interface ResultListener {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void onParametersUpdated$default(ResultListener resultListener, String str, ParameterSlot parameterSlot, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    if ((i & 2) != 0) {
                        parameterSlot = null;
                    }
                    resultListener.onParametersUpdated(str, parameterSlot);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onParametersUpdated");
            }

            public static void onUpdateAddress(@NotNull ResultListener resultListener, @Nullable AddressParameter.Value value) {
            }
        }

        void onParametersUpdated(@Nullable String str, @Nullable ParameterSlot parameterSlot);

        void onResultHandled(@NotNull CategoryParameters categoryParameters);

        void onUpdateAddress(@Nullable AddressParameter.Value value);
    }

    void attachParametersSource(@NotNull ParametersSource parametersSource);

    void attachResultListener(@NotNull ResultListener resultListener);

    void onAddressParameterChanged(@Nullable AddressParameter.Value value);

    void onObjectsParameterChanged(@NotNull ObjectsParameter objectsParameter);
}
