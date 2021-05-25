package com.avito.android.publish.view;

import android.net.Uri;
import android.text.TextUtils;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ExternalAppLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithErrors;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.DateTimeIntervalParameter;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.NumericParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.SubLocationParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.conveyor_item.Item;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00105\u001a\u000202¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u0010J9\u0010)\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\"2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001dH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u0004\u0018\u00010+*\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/avito/android/publish/view/BasicParameterClickListenerImpl;", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/view/BasicParameterClickListener$Router;)V", "detachRouter", "()V", "Lcom/avito/conveyor_item/Item;", "element", "onElementClicked", "(Lcom/avito/conveyor_item/Item;)V", "Lcom/avito/android/items/ItemWithAdditionalButton;", "onInputAdditionalButtonClick", "(Lcom/avito/android/items/ItemWithAdditionalButton;)V", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParameters", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/items/InputItem;", "", "newValue", "", "updateElement", "onElementValueChanged", "(Lcom/avito/android/items/InputItem;Ljava/lang/String;Z)V", "onElementErrorDismissed", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "dateTime", "", "timestamp", "presentTime", "updateDateTime", "onDateIntervalValueChanged", "(Lcom/avito/android/category_parameters/ParameterElement$DateInterval;Lcom/avito/android/category_parameters/ParameterElement$DateTime;Ljava/lang/Long;ZZ)V", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/item_legacy/details/ParametersSource;Lcom/avito/conveyor_item/Item;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener;", "d", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener;", "selectListener", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/item_legacy/details/ParametersSource;", "parametersSource", "Lcom/avito/android/publish/view/LocationParameterClickListener;", "c", "Lcom/avito/android/publish/view/LocationParameterClickListener;", "locationListener", "<init>", "(Lcom/avito/android/publish/view/LocationParameterClickListener;Lcom/avito/android/item_legacy/details/SelectParameterClickListener;Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class BasicParameterClickListenerImpl implements BasicParameterClickListener {
    public BasicParameterClickListener.Router a;
    public ParametersSource b;
    public final LocationParameterClickListener c;
    public final SelectParameterClickListener d;
    public final DeepLinkFactory e;

    @Inject
    public BasicParameterClickListenerImpl(@NotNull LocationParameterClickListener locationParameterClickListener, @NotNull SelectParameterClickListener selectParameterClickListener, @NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(locationParameterClickListener, "locationListener");
        Intrinsics.checkNotNullParameter(selectParameterClickListener, "selectListener");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        this.c = locationParameterClickListener;
        this.d = selectParameterClickListener;
        this.e = deepLinkFactory;
    }

    public final ParameterSlot a(ParametersSource parametersSource, Item item) {
        ParametersTree parametersTree;
        if (parametersSource == null || (parametersTree = parametersSource.getParametersTree()) == null) {
            return null;
        }
        return parametersTree.findParameter(item.getStringId());
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void attachRouter(@NotNull BasicParameterClickListener.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
        this.c.attachRouter(router);
        this.d.attachRouter(router);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void detachRouter() {
        this.a = null;
        this.c.detachRouter();
        this.d.detachRouter();
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public CategoryParameters getCategoryParameters() {
        ParametersSource parametersSource = this.b;
        if (parametersSource != null) {
            return parametersSource.getCategoryParameters();
        }
        return null;
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public ParametersTree getParametersTree() {
        ParametersSource parametersSource = this.b;
        if (parametersSource != null) {
            return parametersSource.getParametersTree();
        }
        return null;
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onDateIntervalValueChanged(@NotNull ParameterElement.DateInterval dateInterval, @NotNull ParameterElement.DateTime dateTime, @Nullable Long l, boolean z, boolean z2) {
        Object obj;
        DateTimeParameter dateTimeParameter;
        Intrinsics.checkNotNullParameter(dateInterval, "element");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        if (z2) {
            dateTime.setPresentTime(z);
            dateTime.clearErrors();
            dateTime.setValue(z ? null : l);
        }
        ParametersSource parametersSource = this.b;
        DateTimeIntervalParameter dateTimeIntervalParameter = (DateTimeIntervalParameter) (parametersSource != null ? a(parametersSource, dateInterval) : null);
        if (dateTimeIntervalParameter != null) {
            BasicParameterClickListenerKt.clearError(dateTimeIntervalParameter);
            if (z) {
                obj = DateTimeParameter.Value.PresentTime.INSTANCE;
            } else {
                obj = l != null ? new DateTimeParameter.Value.Timestamp(l.longValue()) : null;
            }
            DateTimeParameter start = dateTimeIntervalParameter.getStart();
            if (Intrinsics.areEqual(start != null ? start.getId() : null, dateTime.getStringId())) {
                dateTimeParameter = dateTimeIntervalParameter.getStart();
            } else {
                DateTimeParameter end = dateTimeIntervalParameter.getEnd();
                dateTimeParameter = Intrinsics.areEqual(end != null ? end.getId() : null, dateTime.getStringId()) ? dateTimeIntervalParameter.getEnd() : null;
            }
            if (dateTimeParameter != null && (!Intrinsics.areEqual(dateTimeParameter.getValue(), obj))) {
                dateTimeParameter.setValue(obj);
                dateTimeParameter.setError(null);
            }
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementClicked(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "element");
        if (item instanceof ItemWithErrors) {
            ((ItemWithErrors) item).clearErrors();
        }
        ParameterSlot a3 = a(this.b, item);
        if (a3 != null) {
            if (a3 instanceof CategoryParameter) {
                BasicParameterClickListenerKt.clearError((CategoryParameter) a3);
            }
            if (a3 instanceof AddressParameter) {
                AddressParameter addressParameter = (AddressParameter) a3;
                BasicParameterClickListener.Router router = this.a;
                if (router != null) {
                    router.showLocationPicker(addressParameter);
                }
            } else if (!(a3 instanceof LocationParameter) && !(a3 instanceof SubLocationParameter)) {
                this.d.onElementClicked(item);
            } else {
                this.c.onLocationParameterClicked(item, (CategoryParameter) a3);
            }
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementErrorDismissed(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "element");
        if (item instanceof ItemWithErrors) {
            ((ItemWithErrors) item).clearErrors();
        }
        ParameterSlot a3 = a(this.b, item);
        if (a3 != null && (a3 instanceof CategoryParameter)) {
            BasicParameterClickListenerKt.clearError((CategoryParameter) a3);
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementValueChanged(@NotNull InputItem inputItem, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(inputItem, "element");
        Intrinsics.checkNotNullParameter(str, "newValue");
        if (z) {
            inputItem.setValue(str);
            inputItem.clearErrors();
        }
        ParameterSlot a3 = a(this.b, inputItem);
        if (a3 == null) {
            return;
        }
        if (a3 instanceof CharParameter) {
            EditableParameter editableParameter = (EditableParameter) a3;
            if (!Intrinsics.areEqual(editableParameter.getValue(), str)) {
                editableParameter.setValue(str);
                editableParameter.setError(null);
                return;
            }
            return;
        }
        boolean z2 = false;
        if (a3 instanceof PriceParameter) {
            EditableParameter editableParameter2 = (EditableParameter) a3;
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                try {
                    if (!TextUtils.isDigitsOnly(str)) {
                        str = (String) ((PriceParameter) a3).getValue();
                    }
                    if (!Intrinsics.areEqual(editableParameter2.getValue(), str)) {
                        editableParameter2.setValue(str);
                        editableParameter2.setError(null);
                    }
                } catch (NumberFormatException unused) {
                }
            } else if (!Intrinsics.areEqual(editableParameter2.getValue(), (Object) null)) {
                editableParameter2.setValue(null);
                editableParameter2.setError(null);
            }
        } else if (a3 instanceof IntParameter) {
            EditableParameter editableParameter3 = (EditableParameter) a3;
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (!Intrinsics.areEqual(editableParameter3.getValue(), valueOf)) {
                    editableParameter3.setValue(valueOf);
                    editableParameter3.setError(null);
                }
            } else if (!Intrinsics.areEqual(editableParameter3.getValue(), (Object) null)) {
                editableParameter3.setValue(null);
                editableParameter3.setError(null);
            }
        } else if (a3 instanceof NumericParameter) {
            EditableParameter editableParameter4 = (EditableParameter) a3;
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                Double valueOf2 = Double.valueOf(Double.parseDouble(str));
                if (!Intrinsics.areEqual(editableParameter4.getValue(), valueOf2)) {
                    editableParameter4.setValue(valueOf2);
                    editableParameter4.setError(null);
                }
            } else if (!Intrinsics.areEqual(editableParameter4.getValue(), (Object) null)) {
                editableParameter4.setValue(null);
                editableParameter4.setError(null);
            }
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onInputAdditionalButtonClick(@NotNull ItemWithAdditionalButton itemWithAdditionalButton) {
        DeepLink deepLink;
        Intrinsics.checkNotNullParameter(itemWithAdditionalButton, "element");
        ItemWithAdditionalButton.AdditionalButton additionalButton = itemWithAdditionalButton.getAdditionalButton();
        String link = additionalButton != null ? additionalButton.getLink() : null;
        if (link != null) {
            DeepLinkFactory deepLinkFactory = this.e;
            Uri parse = Uri.parse(link);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it)");
            deepLink = deepLinkFactory.createFromUri(parse);
        } else {
            deepLink = null;
        }
        if (deepLink == null) {
            return;
        }
        if (deepLink instanceof NoMatchLink) {
            BasicParameterClickListener.Router router = this.a;
            if (router != null) {
                Uri parse2 = Uri.parse(link);
                Intrinsics.checkNotNullExpressionValue(parse2, "Uri.parse(link)");
                router.openDeepLink(new ExternalAppLink(parse2, null, 2, null));
                return;
            }
            return;
        }
        BasicParameterClickListener.Router router2 = this.a;
        if (router2 != null) {
            router2.openDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void setParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "source");
        this.b = parametersSource;
        this.d.setParametersSource(parametersSource);
    }
}
