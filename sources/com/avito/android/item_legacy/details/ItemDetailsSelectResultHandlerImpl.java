package com.avito.android.item_legacy.details;

import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.SubLocationParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00160\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandlerImpl;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "attachResultListener", "(Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "parametersSource", "attachParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "onAddressParameterChanged", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "updatedParameter", "onObjectsParameterChanged", "(Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;)V", "", "requestId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedItems", "sectionTitle", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_legacy/details/ParametersSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ItemDetailsSelectResultHandlerImpl implements ItemDetailsSelectResultHandler {
    public ParametersSource a;
    public ItemDetailsSelectResultHandler.ResultListener b;

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void attachParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "parametersSource");
        this.a = parametersSource;
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void attachResultListener(@NotNull ItemDetailsSelectResultHandler.ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(resultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = resultListener;
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void onAddressParameterChanged(@Nullable AddressParameter.Value value) {
        ParametersSource parametersSource = this.a;
        CategoryParameters categoryParameters = parametersSource != null ? parametersSource.getCategoryParameters() : null;
        AddressParameter addressParameter = categoryParameters != null ? (AddressParameter) categoryParameters.getFirstParameterOfType(AddressParameter.class) : null;
        if (categoryParameters != null && addressParameter != null) {
            if (!Intrinsics.areEqual(value, (AddressParameter.Value) addressParameter.getValue())) {
                if (!Intrinsics.areEqual(addressParameter.getValue(), value)) {
                    addressParameter.setValue(value);
                    addressParameter.setError(null);
                }
                if (Intrinsics.areEqual(addressParameter.getUpdatesForm(), Boolean.TRUE)) {
                    ItemDetailsSelectResultHandler.ResultListener resultListener = this.b;
                    if (resultListener != null) {
                        ItemDetailsSelectResultHandler.ResultListener.DefaultImpls.onParametersUpdated$default(resultListener, addressParameter.getId(), null, 2, null);
                    }
                } else {
                    ItemDetailsSelectResultHandler.ResultListener resultListener2 = this.b;
                    if (resultListener2 != null) {
                        resultListener2.onUpdateAddress(value);
                    }
                }
            }
            ItemDetailsSelectResultHandler.ResultListener resultListener3 = this.b;
            if (resultListener3 != null) {
                resultListener3.onResultHandled(categoryParameters);
            }
        }
    }

    @Override // com.avito.android.select.SelectListener
    public void onCancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        ItemDetailsSelectResultHandler.DefaultImpls.onCancel(this, str);
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void onObjectsParameterChanged(@NotNull ObjectsParameter objectsParameter) {
        CategoryParameters categoryParameters;
        ParametersSource parametersSource;
        ParametersTree parametersTree;
        ObjectsParameter objectsParameter2;
        Intrinsics.checkNotNullParameter(objectsParameter, "updatedParameter");
        ParametersSource parametersSource2 = this.a;
        if (parametersSource2 != null && (categoryParameters = parametersSource2.getCategoryParameters()) != null && (parametersSource = this.a) != null && (parametersTree = parametersSource.getParametersTree()) != null && (objectsParameter2 = (ObjectsParameter) parametersTree.findParameter(objectsParameter.getId())) != null) {
            objectsParameter2.setValue(objectsParameter.getValue());
            ItemDetailsSelectResultHandler.ResultListener resultListener = this.b;
            if (resultListener != null) {
                resultListener.onResultHandled(categoryParameters);
            }
        }
    }

    @Override // com.avito.android.select.SelectListener
    public void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2) {
        ParametersTree parametersTree;
        T t;
        String str3;
        List<ParameterSlot> parameters;
        SelectParameter.UserChosenValue userChosenValue;
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedItems");
        ParametersSource parametersSource = this.a;
        if (!(parametersSource == null || (parametersTree = parametersSource.getParametersTree()) == null)) {
            ParameterSlot findParameter = parametersTree.findParameter(str);
            ParcelableEntity parcelableEntity = (ParcelableEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            String str4 = null;
            String str5 = parcelableEntity != null ? (String) parcelableEntity.getId() : null;
            if (findParameter instanceof SelectParameter) {
                SelectParameter selectParameter = (SelectParameter) findParameter;
                if (!Intrinsics.areEqual((String) selectParameter.getValue(), str5)) {
                    selectParameter.setError(null);
                    if (Intrinsics.areEqual(selectParameter.getUpdatesForm(), Boolean.TRUE)) {
                        if (str5 != null) {
                            userChosenValue = new SelectParameter.UserChosenValue.ValueId(str5);
                        } else {
                            userChosenValue = SelectParameter.UserChosenValue.ClearValue.INSTANCE;
                        }
                        selectParameter.setChosenValue(userChosenValue);
                        str3 = findParameter.getId();
                    } else {
                        selectParameter.setValue(str5);
                        str3 = null;
                    }
                    SelectParameter.Value chosenOrCurrentSelectedValue = selectParameter.getChosenOrCurrentSelectedValue();
                    if (!(chosenOrCurrentSelectedValue == null || (parameters = chosenOrCurrentSelectedValue.getParameters()) == null)) {
                        for (T t2 : parameters) {
                            if (t2 instanceof EditableParameter) {
                                t2.setError(null);
                            }
                        }
                    }
                    str4 = str3;
                }
            } else if (findParameter instanceof SubLocationParameter) {
                SubLocationParameter subLocationParameter = (SubLocationParameter) findParameter;
                Iterator<T> it = subLocationParameter.getValues().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual((String) t.getId(), str5)) {
                        break;
                    }
                }
                subLocationParameter.setValue(t);
                subLocationParameter.setError(null);
            } else if (findParameter instanceof MultiselectParameter) {
                MultiselectParameter multiselectParameter = (MultiselectParameter) findParameter;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add((String) it2.next().getId());
                }
                multiselectParameter.setValue(arrayList);
            }
            ItemDetailsSelectResultHandler.ResultListener resultListener = this.b;
            if (resultListener != null) {
                resultListener.onParametersUpdated(str4, findParameter);
            }
        }
    }
}
