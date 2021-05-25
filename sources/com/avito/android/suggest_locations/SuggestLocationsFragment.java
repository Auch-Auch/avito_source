package com.avito.android.suggest_locations;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.PublishIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.suggest_locations.SuggestLocationsPresenter;
import com.avito.android.suggest_locations.di.DaggerSuggestLocationsComponent;
import com.avito.android.suggest_locations.di.SuggestLocationsComponent;
import com.avito.android.suggest_locations.di.SuggestLocationsDependencies;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Kundle;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0007¢\u0006\u0004\bL\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u0010R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "onStop", "onDestroyView", "finishScreen", "outState", "onSaveInstanceState", "Lcom/avito/android/remote/model/Location;", "location", "leaveScreenWithLocation", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "addressSuggestion", "openLocationPicker", "(Lcom/avito/android/remote/model/location_picker/AddressSuggestion;)V", "onBackPressed", "", "k", "Ljava/lang/String;", "query", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "n", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "presenter", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "getPresenter", "()Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "setPresenter", "(Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;)V", "", "l", "Z", "autoOpenKeyboard", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "j", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "<init>", "Companion", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsFragment extends TabBaseFragment implements SuggestLocationsPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Features features;
    public PublishIntentFactory.LocationPickerChooseButtonLocation j;
    public String k;
    public boolean l;
    @NotNull
    public NavigationState m = new NavigationState(false);
    public AddressParameter.ValidationRules n;
    @Inject
    public SuggestLocationsPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006Jo\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsFragment$Companion;", "", "Lcom/avito/android/suggest_locations/SuggestLocationsArguments;", "arguments", "Lcom/avito/android/suggest_locations/SuggestLocationsFragment;", "newInstance", "(Lcom/avito/android/suggest_locations/SuggestLocationsArguments;)Lcom/avito/android/suggest_locations/SuggestLocationsFragment;", "", "locationId", "categoryId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "query", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "", "showHistoricalSuggest", "geoSessionId", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "autoOpenKeyboard", "useLegacyApi", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;ZLjava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZ)Lcom/avito/android/suggest_locations/SuggestLocationsFragment;", "KEY_ARGUMENTS", "Ljava/lang/String;", "KEY_STATE", "<init>", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ SuggestLocationsArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SuggestLocationsArguments suggestLocationsArguments) {
                super(1);
                this.a = suggestLocationsArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("key_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Integer c;
            public final /* synthetic */ String d;
            public final /* synthetic */ PublishIntentFactory.LocationPickerChooseButtonLocation e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ String g;
            public final /* synthetic */ AddressParameter.ValidationRules h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ boolean j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, Integer num, String str3, PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, String str4, AddressParameter.ValidationRules validationRules, boolean z2, boolean z3) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = num;
                this.d = str3;
                this.e = locationPickerChooseButtonLocation;
                this.f = z;
                this.g = str4;
                this.h = validationRules;
                this.i = z2;
                this.j = z3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("key_arguments", new SuggestLocationsArguments(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j));
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        public static /* synthetic */ SuggestLocationsFragment newInstance$default(Companion companion, String str, String str2, Integer num, String str3, PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, String str4, AddressParameter.ValidationRules validationRules, boolean z2, boolean z3, int i, Object obj) {
            return companion.newInstance(str, str2, num, str3, locationPickerChooseButtonLocation, z, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : validationRules, z2, z3);
        }

        @NotNull
        public final SuggestLocationsFragment newInstance(@NotNull SuggestLocationsArguments suggestLocationsArguments) {
            Intrinsics.checkNotNullParameter(suggestLocationsArguments, "arguments");
            return (SuggestLocationsFragment) FragmentsKt.arguments$default(new SuggestLocationsFragment(), 0, new a(suggestLocationsArguments), 1, null);
        }

        public Companion(j jVar) {
        }

        @NotNull
        public final SuggestLocationsFragment newInstance(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, @Nullable String str4, @Nullable AddressParameter.ValidationRules validationRules, boolean z2, boolean z3) {
            return (SuggestLocationsFragment) FragmentsKt.arguments$default(new SuggestLocationsFragment(), 0, new b(str, str2, num, str3, locationPickerChooseButtonLocation, z, str4, validationRules, z2, z3), 1, null);
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter.Router
    public void finishScreen() {
        Keyboards.hideKeyboard(this);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getLocationSelectWithoutActivity().invoke().booleanValue() || (getActivity() instanceof SuggestLocationsActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(0);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        TabBaseFragment.setResult$default(this, 0, null, 2, null);
        finish();
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

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.m;
    }

    @NotNull
    public final SuggestLocationsPresenter getPresenter() {
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return suggestLocationsPresenter;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter.Router
    public void leaveScreenWithLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        Keyboards.hideKeyboard(this);
        Intent intent = new Intent();
        intent.putExtra("location", location);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getLocationSelectWithoutActivity().invoke().booleanValue() || (getActivity() instanceof SuggestLocationsActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        setResult(-1, intent);
        finish();
    }

    public final void onBackPressed() {
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        suggestLocationsPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        SuggestLocationsArguments suggestLocationsArguments;
        Kundle kundle;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (suggestLocationsArguments = (SuggestLocationsArguments) arguments.getParcelable("key_arguments")) == null) {
            finishScreen();
            return;
        }
        this.k = suggestLocationsArguments.getQuery();
        this.j = suggestLocationsArguments.getChooseButtonLocation();
        this.n = suggestLocationsArguments.getValidationRules();
        this.l = suggestLocationsArguments.getAutoOpenKeyboard();
        String locationId = suggestLocationsArguments.getLocationId();
        String categoryId = suggestLocationsArguments.getCategoryId();
        Integer fromBlock = suggestLocationsArguments.getFromBlock();
        int intValue = fromBlock != null ? fromBlock.intValue() : OpenEventFromBlock.NONE.getValue();
        String str = this.k;
        boolean showHistoricalSuggest = suggestLocationsArguments.getShowHistoricalSuggest();
        String geoSessionId = suggestLocationsArguments.getGeoSessionId();
        SuggestLocationsComponent.Builder useLegacyApi = DaggerSuggestLocationsComponent.builder().dependencies((SuggestLocationsDependencies) ComponentDependenciesKt.getDependencies(SuggestLocationsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).locationId(locationId).categoryId(categoryId).fromBlock(intValue).query(str).showHistoricalSuggest(showHistoricalSuggest).geoSessionId(geoSessionId).suggestAddress(str != null).autoOpenKeyboard(suggestLocationsArguments.getAutoOpenKeyboard()).useLegacyApi(suggestLocationsArguments.getUseLegacyApi());
        if (bundle == null || (kundle = Bundles.getKundle(bundle, "key_state")) == null) {
            kundle = new Kundle();
        }
        useLegacyApi.savedState(kundle).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = false;
        View inflate = layoutInflater.inflate(R.layout.suggest_locations_fragment, viewGroup, false);
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        if (this.k != null) {
            z = true;
        }
        suggestLocationsPresenter.attachView(new SuggestLocationsViewImpl(inflate, z, this.l));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        suggestLocationsPresenter.detachView();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "key_state", suggestLocationsPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        suggestLocationsPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SuggestLocationsPresenter suggestLocationsPresenter = this.presenter;
        if (suggestLocationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        suggestLocationsPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter.Router
    public void openLocationPicker(@NotNull AddressSuggestion addressSuggestion) {
        Intrinsics.checkNotNullParameter(addressSuggestion, "addressSuggestion");
        Keyboards.hideKeyboard(this);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Coordinates coordinates = addressSuggestion.getCoordinates();
        double latitude = coordinates != null ? coordinates.getLatitude() : 0.0d;
        Coordinates coordinates2 = addressSuggestion.getCoordinates();
        AddressParameter.Value value = new AddressParameter.Value(latitude, coordinates2 != null ? coordinates2.getLongitude() : 0.0d, addressSuggestion.getAddressStringOneLine(), addressSuggestion.getJsonWebToken());
        PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation = this.j;
        if (locationPickerChooseButtonLocation == null) {
            locationPickerChooseButtonLocation = PublishIntentFactory.LocationPickerChooseButtonLocation.APPBAR;
        }
        startActivityForResult(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(activityIntentFactory2, value, null, null, null, locationPickerChooseButtonLocation, null, null, this.n, 110, null), 1004);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.m = navigationState;
    }

    public final void setPresenter(@NotNull SuggestLocationsPresenter suggestLocationsPresenter) {
        Intrinsics.checkNotNullParameter(suggestLocationsPresenter, "<set-?>");
        this.presenter = suggestLocationsPresenter;
    }
}
