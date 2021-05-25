package com.avito.android.publish.view;

import android.content.Intent;
import android.os.Handler;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.item_legacy.details.SelectItemBaseFragment;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.util.ImplicitIntentFactory;
import com.facebook.appevents.integrity.IntegrityManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H$¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\nJ-\u0010\u001e\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsBaseFragment;", "Lcom/avito/android/item_legacy/details/SelectItemBaseFragment;", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)V", "onStop", "()V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "showLocationPicker", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter;)V", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "selectedObject", "showEditObjectsScreen", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)V", "onActivityResult", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "", "withHistorySuggest", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;ZLcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "handler", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class ItemDetailsBaseFragment extends SelectItemBaseFragment implements ItemDetailsParameterClickListener.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    public final Handler f = new Handler();
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AddressParameter.GeoFlowType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            AddressParameter.GeoFlowType geoFlowType = AddressParameter.GeoFlowType.SUGGEST;
            iArr[1] = 1;
            AddressParameter.GeoFlowType geoFlowType2 = AddressParameter.GeoFlowType.HISTORICAL_SUGGEST;
            iArr[2] = 2;
            AddressParameter.GeoFlowType geoFlowType3 = AddressParameter.GeoFlowType.MAP;
            iArr[0] = 3;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ItemDetailsBaseFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Intent d;

        public a(ItemDetailsBaseFragment itemDetailsBaseFragment, int i, int i2, Intent intent) {
            this.a = itemDetailsBaseFragment;
            this.b = i;
            this.c = i2;
            this.d = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i == -1) {
                int i2 = this.c;
                AddressParameter.Value value = null;
                ObjectsParameter objectsParameter = null;
                if (i2 == 1004) {
                    Intent intent = this.d;
                    if (intent != null) {
                        value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT);
                    }
                    if (value != null) {
                        this.a.getResultHandler().onAddressParameterChanged(value);
                        return;
                    }
                    return;
                } else if (i2 == 1005) {
                    Intent intent2 = this.d;
                    if (intent2 != null) {
                        objectsParameter = (ObjectsParameter) intent2.getParcelableExtra("parameter");
                    }
                    if (objectsParameter != null) {
                        this.a.getResultHandler().onObjectsParameterChanged(objectsParameter);
                        return;
                    }
                    return;
                }
            }
            this.a.handleActivityResult(this.c, i, this.d);
        }
    }

    public static void b(ItemDetailsBaseFragment itemDetailsBaseFragment, AddressParameter.Value value, AddressParameter.ValidationRules validationRules, int i, Object obj) {
        int i2 = i & 2;
        ActivityIntentFactory activityIntentFactory2 = itemDetailsBaseFragment.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        itemDetailsBaseFragment.startActivityForResult(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(activityIntentFactory2, value, null, null, null, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, null, null, 110, null), 1004);
    }

    public final void a(AddressParameter.Value value, boolean z, AddressParameter.ValidationRules validationRules) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        String text = value != null ? value.getText() : null;
        if (text == null) {
            text = "";
        }
        startActivityForResult(SuggestLocationsIntentFactory.DefaultImpls.suggestLocationsIntent$default(activityIntentFactory2, null, null, null, text, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, z, null, validationRules, false, false, 1664, null), 1004);
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    public abstract void handleActivityResult(int i, int i2, @Nullable Intent intent);

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f.post(new a(this, i2, i, intent));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f.removeCallbacksAndMessages(null);
        super.onStop();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    @Override // com.avito.android.publish.view.ItemDetailsParameterClickListener.Router
    public void showEditObjectsScreen(@NotNull CategoryParameters categoryParameters, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        Intrinsics.checkNotNullParameter(objectsParameter, "parameter");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.createObjectsEditIntent(categoryParameters.getNavigation(), objectsParameter, num), 1005);
    }

    @Override // com.avito.android.publish.view.LocationParameterClickListener.Router
    public void showLocationPicker(@NotNull AddressParameter addressParameter) {
        Intrinsics.checkNotNullParameter(addressParameter, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        AddressParameter.ValidationRules validationRules = features2.getAddressValidation().invoke().booleanValue() ? addressParameter.getValidationRules() : null;
        AddressParameter.GeoFlowType flowType = addressParameter.getFlowType();
        if (flowType != null) {
            int ordinal = flowType.ordinal();
            if (ordinal == 0) {
                b(this, (AddressParameter.Value) addressParameter.getValue(), null, 2, null);
                return;
            } else if (ordinal == 1) {
                a((AddressParameter.Value) addressParameter.getValue(), false, validationRules);
                return;
            } else if (ordinal == 2) {
                a((AddressParameter.Value) addressParameter.getValue(), true, validationRules);
                return;
            }
        }
        b(this, (AddressParameter.Value) addressParameter.getValue(), null, 2, null);
    }
}
