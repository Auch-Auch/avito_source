package com.avito.android.publish.objects;

import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.item_legacy.details.SelectItemBaseFragment;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.publish.R;
import com.avito.android.publish.date_picker.DatePickerSheetDialog;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.objects.ObjectsEditPresenter;
import com.avito.android.publish.objects.di.DaggerObjectsEditComponent;
import com.avito.android.publish.objects.di.ObjectsEditComponent;
import com.avito.android.publish.view.ItemDetailsViewImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.KeyboardSubscription;
import com.avito.android.util.Keyboards;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u0011J-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019JI\u0010\"\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r0 H\u0016¢\u0006\u0004\b\"\u0010#J)\u0010)\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020.2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\r2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\r2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010S\u001a\u00020R8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010e\u001a\u00020d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001a\u00020r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR&\u0010z\u001a\u0006\u0012\u0002\b\u00030y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010¨\u0006\u0001"}, d2 = {"Lcom/avito/android/publish/objects/FillObjectsFragment;", "Lcom/avito/android/item_legacy/details/SelectItemBaseFragment;", "Lcom/avito/android/publish/objects/ObjectsEditPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "leaveScreen", "navigateToAuth", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "objectsParameter", "leaveScreenWithChangedObject", "(Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;)V", "Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;", "dialogResources", "", "value", "delimiterStart", "delimiterEnd", "Lkotlin/Function1;", "callback", "showDatePickerDialog", "(Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "showLocationPicker", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/validation/ParametersListPresenter;", "validationPresenter", "Lcom/avito/android/validation/ParametersListPresenter;", "getValidationPresenter", "()Lcom/avito/android/validation/ParametersListPresenter;", "setValidationPresenter", "(Lcom/avito/android/validation/ParametersListPresenter;)V", "Lcom/avito/android/util/KeyboardSubscription;", g.a, "Lcom/avito/android/util/KeyboardSubscription;", "keyboardSubscription", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "handler", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "interactor", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "getInteractor", "()Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "setInteractor", "(Lcom/avito/android/publish/objects/ObjectsEditInteractor;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "presenter", "Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "getPresenter", "()Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "setPresenter", "(Lcom/avito/android/publish/objects/ObjectsEditPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "<init>", "Arguments", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class FillObjectsFragment extends SelectItemBaseFragment implements ObjectsEditPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public RecyclerView.Adapter<?> adapter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    public final Handler f = new Handler();
    @Inject
    public Features features;
    public KeyboardSubscription g;
    @Inject
    public ObjectsEditInteractor interactor;
    @Inject
    public ObjectsEditPresenter presenter;
    @Inject
    public ParametersListPresenter validationPresenter;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/objects/FillObjectsFragment$Arguments;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/Integer;", "getObjectIndex", "()Ljava/lang/Integer;", "objectIndex", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "getParameter", "()Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "Lcom/avito/android/remote/model/Navigation;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "()Lcom/avito/android/remote/model/Navigation;", "navigation", "<init>", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Arguments implements Parcelable {
        public static final Parcelable.Creator<Arguments> CREATOR = new Creator();
        @NotNull
        public final Navigation a;
        @NotNull
        public final ObjectsParameter b;
        @Nullable
        public final Integer c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Arguments> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Arguments createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Arguments((Navigation) parcel.readParcelable(Arguments.class.getClassLoader()), (ObjectsParameter) parcel.readParcelable(Arguments.class.getClassLoader()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Arguments[] newArray(int i) {
                return new Arguments[i];
            }
        }

        public Arguments(@NotNull Navigation navigation, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(navigation, "navigation");
            Intrinsics.checkNotNullParameter(objectsParameter, "parameter");
            this.a = navigation;
            this.b = objectsParameter;
            this.c = num;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Navigation getNavigation() {
            return this.a;
        }

        @Nullable
        public final Integer getObjectIndex() {
            return this.c;
        }

        @NotNull
        public final ObjectsParameter getParameter() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            Integer num = this.c;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Arguments(Navigation navigation, ObjectsParameter objectsParameter, Integer num, int i, j jVar) {
            this(navigation, objectsParameter, (i & 4) != 0 ? null : num);
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ FillObjectsFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Intent d;

        public a(FillObjectsFragment fillObjectsFragment, int i, int i2, Intent intent) {
            this.a = fillObjectsFragment;
            this.b = i;
            this.c = i2;
            this.d = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b == -1) {
                int i = this.c;
                boolean z = true;
                if (i != 1) {
                    AddressParameter.Value value = null;
                    ObjectsParameter objectsParameter = null;
                    if (i == 1004) {
                        Intent intent = this.d;
                        if (intent != null) {
                            value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT);
                        }
                        if (value != null) {
                            this.a.getResultHandler().onAddressParameterChanged(value);
                        }
                    } else if (i == 1005) {
                        Intent intent2 = this.d;
                        if (intent2 != null) {
                            objectsParameter = (ObjectsParameter) intent2.getParcelableExtra("parameter");
                        }
                        if (objectsParameter != null) {
                            this.a.getResultHandler().onObjectsParameterChanged(objectsParameter);
                        }
                    }
                } else {
                    ObjectsEditPresenter presenter = this.a.getPresenter();
                    if (this.b != -1) {
                        z = false;
                    }
                    presenter.onAuthResult(z);
                }
            }
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ FillObjectsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FillObjectsFragment fillObjectsFragment) {
            super(1);
            this.a = fillObjectsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.getPresenter().handleKeyboard(bool.booleanValue());
            return Unit.INSTANCE;
        }
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
    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
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
    public final ObjectsEditInteractor getInteractor() {
        ObjectsEditInteractor objectsEditInteractor = this.interactor;
        if (objectsEditInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return objectsEditInteractor;
    }

    @NotNull
    public final ObjectsEditPresenter getPresenter() {
        ObjectsEditPresenter objectsEditPresenter = this.presenter;
        if (objectsEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return objectsEditPresenter;
    }

    @NotNull
    public final ParametersListPresenter getValidationPresenter() {
        ParametersListPresenter parametersListPresenter = this.validationPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validationPresenter");
        }
        return parametersListPresenter;
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter.Router
    public void leaveScreen() {
        Keyboards.hideKeyboard(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter.Router
    public void leaveScreenWithChangedObject(@NotNull ObjectsParameter objectsParameter) {
        Intrinsics.checkNotNullParameter(objectsParameter, "objectsParameter");
        Keyboards.hideKeyboard(this);
        Intent intent = new Intent();
        intent.putExtra("parameter", objectsParameter);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter.Router
    public void navigateToAuth() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.CREATE_ADVERT, null, 5, null), 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f.post(new a(this, i2, i, intent));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.publish_details, viewGroup, false);
    }

    @Override // com.avito.android.item_legacy.details.SelectItemBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyboardSubscription keyboardSubscription = this.g;
        if (keyboardSubscription != null) {
            keyboardSubscription.dispose();
        }
        ParametersListPresenter parametersListPresenter = this.validationPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validationPresenter");
        }
        parametersListPresenter.unsubscribe();
        ObjectsEditPresenter objectsEditPresenter = this.presenter;
        if (objectsEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        objectsEditPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ObjectsEditInteractor objectsEditInteractor = this.interactor;
        if (objectsEditInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putBundle("interactor", objectsEditInteractor.saveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ObjectsEditPresenter objectsEditPresenter = this.presenter;
        if (objectsEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        objectsEditPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f.removeCallbacksAndMessages(null);
        ObjectsEditPresenter objectsEditPresenter = this.presenter;
        if (objectsEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        objectsEditPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.item_legacy.details.SelectItemBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewGroup viewGroup = (ViewGroup) view;
        ObjectsEditPresenter objectsEditPresenter = this.presenter;
        if (objectsEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        ItemDetailsViewImpl itemDetailsViewImpl = new ItemDetailsViewImpl(viewGroup, objectsEditPresenter, analytics2, 0, adapter2, dialogRouter2, false, 8, null);
        ObjectsEditPresenter objectsEditPresenter2 = this.presenter;
        if (objectsEditPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        objectsEditPresenter2.attachView(itemDetailsViewImpl);
        ParametersListPresenter parametersListPresenter = this.validationPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("validationPresenter");
        }
        parametersListPresenter.subscribe();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.g = Keyboards.addSoftKeyboardVisibilityListener$default((Activity) requireActivity, false, (Function1) new b(this), 1, (Object) null);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener.Router
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setInteractor(@NotNull ObjectsEditInteractor objectsEditInteractor) {
        Intrinsics.checkNotNullParameter(objectsEditInteractor, "<set-?>");
        this.interactor = objectsEditInteractor;
    }

    public final void setPresenter(@NotNull ObjectsEditPresenter objectsEditPresenter) {
        Intrinsics.checkNotNullParameter(objectsEditPresenter, "<set-?>");
        this.presenter = objectsEditPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Navigation navigation;
        ObjectsParameter objectsParameter;
        Bundle arguments = getArguments();
        if (arguments == null || (navigation = (Navigation) arguments.getParcelable("navigation")) == null) {
            throw new RuntimeException("navigation was not passed to fragment");
        }
        Intrinsics.checkNotNullExpressionValue(navigation, "arguments?.getParcelable… not passed to fragment\")");
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (objectsParameter = (ObjectsParameter) arguments2.getParcelable("parameter")) == null) {
            throw new RuntimeException("parameter was not passed to fragment");
        }
        Intrinsics.checkNotNullExpressionValue(objectsParameter, "arguments?.getParcelable… not passed to fragment\")");
        Bundle arguments3 = getArguments();
        Bundle bundle2 = null;
        Integer valueOf = (arguments3 == null || !arguments3.containsKey("object_index")) ? null : Integer.valueOf(arguments3.getInt("object_index"));
        if (bundle != null) {
            bundle2 = bundle.getBundle("interactor");
        }
        ObjectsEditComponent.Builder publishDependencies = DaggerObjectsEditComponent.builder().publishDependencies((PublishDependencies) ComponentDependenciesKt.getDependencies(PublishDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        ObjectsEditComponent.Builder withObjectsIndex = publishDependencies.resources(resources).withMinValuesForSearch(8).withParameter(objectsParameter).withNavigation(navigation).withObjectsIndex(valueOf);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ObjectsEditComponent.Builder withInteractorState = withObjectsIndex.withActivity(requireActivity).withInteractorState(bundle2);
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        withInteractorState.parametersListModule(new ParametersListModule(resources2, 100, null, null, 12, null)).build().inject(this);
        return true;
    }

    public final void setValidationPresenter(@NotNull ParametersListPresenter parametersListPresenter) {
        Intrinsics.checkNotNullParameter(parametersListPresenter, "<set-?>");
        this.validationPresenter = parametersListPresenter;
    }

    @Override // com.avito.android.publish.objects.ObjectsEditPresenter.Router
    public void showDatePickerDialog(@NotNull DatePickerSheetDialog.DialogResources dialogResources, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(dialogResources, "dialogResources");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DatePickerSheetDialog datePickerSheetDialog = new DatePickerSheetDialog(requireContext, dialogResources, l, l2, l3, function1);
        datePickerSheetDialog.show();
        datePickerSheetDialog.expand();
    }

    @Override // com.avito.android.publish.view.LocationParameterClickListener.Router
    public void showLocationPicker(@NotNull AddressParameter addressParameter) {
        Intrinsics.checkNotNullParameter(addressParameter, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (addressParameter.getFlowType() == AddressParameter.GeoFlowType.SUGGEST) {
            AddressParameter.Value value = (AddressParameter.Value) addressParameter.getValue();
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            String text = value != null ? value.getText() : null;
            if (text == null) {
                text = "";
            }
            startActivityForResult(SuggestLocationsIntentFactory.DefaultImpls.suggestLocationsIntent$default(activityIntentFactory2, null, null, null, text, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, false, null, null, false, false, 1984, null), 1004);
            return;
        }
        AddressParameter.Value value2 = (AddressParameter.Value) addressParameter.getValue();
        ActivityIntentFactory activityIntentFactory3 = this.activityIntentFactory;
        if (activityIntentFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(activityIntentFactory3, value2, null, null, null, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, null, null, 238, null), 1004);
    }
}
