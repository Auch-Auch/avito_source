package com.avito.android.suggest_locations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.PublishIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.ui.activity.BaseActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "()V", "<init>", "Companion", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int REQ_ADDRESS = 1004;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$Jw\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0016\u0010!\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsActivity$Companion;", "", "Landroid/content/Context;", "context", "", "locationId", "categoryId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "query", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "", "showHistoricalSuggest", "geoSessionId", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "autoOpenKeyboard", "useLegacyApi", "Landroid/content/Intent;", "createLocationSelectIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;ZLjava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZ)Landroid/content/Intent;", "EXTRA_AUTO_OPEN_KEYBOARD", "Ljava/lang/String;", "EXTRA_CATEGORY_ID", "EXTRA_CHOOSE_BUTTON_LOCATION", "EXTRA_FROM_BLOCK", "EXTRA_GEO_SESSION_ID", "EXTRA_LOCATION_ID", "EXTRA_QUERY", "EXTRA_SHOW_HISTORICAL_SUGGEST", "EXTRA_USE_LEGACY_API", "EXTRA_VALIDATION_RULES", "REQ_ADDRESS", "I", "<init>", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Intent createLocationSelectIntent$default(Companion companion, Context context, String str, String str2, Integer num, String str3, PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, String str4, AddressParameter.ValidationRules validationRules, boolean z2, boolean z3, int i, Object obj) {
            return companion.createLocationSelectIntent(context, str, str2, num, str3, locationPickerChooseButtonLocation, z, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : validationRules, z2, z3);
        }

        @NotNull
        public final Intent createLocationSelectIntent(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, @Nullable String str4, @Nullable AddressParameter.ValidationRules validationRules, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent putExtra = new Intent(context, SuggestLocationsActivity.class).putExtra("extra_location_id", str).putExtra("extra_category_id", str2).putExtra("extra_from_block", num).putExtra("extra_query", str3).putExtra("extra_choose_button_location", locationPickerChooseButtonLocation).putExtra("extra_show_historical_suggest", z).putExtra("extra_geo_session_id", str4).putExtra("extra_validation_rules", validationRules).putExtra("extra_auto_open_keyboard", z2).putExtra("extra_use_legacy_api", z3);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context\n                …LEGACY_API, useLegacyApi)");
            return putExtra;
        }

        public Companion(j jVar) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        AddressParameter.Value value;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && (value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT)) != null) {
            Intent intent2 = new Intent();
            intent2.putExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT, value);
            Unit unit = Unit.INSTANCE;
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("SUGGEST_LOCATIONS_FRAGMENT");
        if (!(findFragmentByTag instanceof SuggestLocationsFragment)) {
            findFragmentByTag = null;
        }
        SuggestLocationsFragment suggestLocationsFragment = (SuggestLocationsFragment) findFragmentByTag;
        if (suggestLocationsFragment != null) {
            suggestLocationsFragment.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.suggest_locations_activity);
        Intent intent = getIntent();
        SuggestLocationsFragment suggestLocationsFragment = null;
        String stringExtra = intent != null ? intent.getStringExtra("extra_location_id") : null;
        Intent intent2 = getIntent();
        String stringExtra2 = intent2 != null ? intent2.getStringExtra("extra_category_id") : null;
        Intent intent3 = getIntent();
        int intExtra = intent3 != null ? intent3.getIntExtra("extra_from_block", 0) : OpenEventFromBlock.NONE.getValue();
        Intent intent4 = getIntent();
        String stringExtra3 = intent4 != null ? intent4.getStringExtra("extra_query") : null;
        Intent intent5 = getIntent();
        Serializable serializableExtra = intent5 != null ? intent5.getSerializableExtra("extra_choose_button_location") : null;
        if (!(serializableExtra instanceof PublishIntentFactory.LocationPickerChooseButtonLocation)) {
            serializableExtra = null;
        }
        PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation = (PublishIntentFactory.LocationPickerChooseButtonLocation) serializableExtra;
        Intent intent6 = getIntent();
        boolean booleanExtra = intent6 != null ? intent6.getBooleanExtra("extra_show_historical_suggest", false) : false;
        Intent intent7 = getIntent();
        AddressParameter.ValidationRules validationRules = intent7 != null ? (AddressParameter.ValidationRules) intent7.getParcelableExtra("extra_validation_rules") : null;
        Intent intent8 = getIntent();
        String stringExtra4 = intent8 != null ? intent8.getStringExtra("extra_geo_session_id") : null;
        Intent intent9 = getIntent();
        boolean booleanExtra2 = intent9 != null ? intent9.getBooleanExtra("extra_auto_open_keyboard", false) : false;
        Intent intent10 = getIntent();
        boolean booleanExtra3 = intent10 != null ? intent10.getBooleanExtra("extra_use_legacy_api", false) : false;
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("SUGGEST_LOCATIONS_FRAGMENT");
        if (findFragmentByTag instanceof SuggestLocationsFragment) {
            suggestLocationsFragment = findFragmentByTag;
        }
        SuggestLocationsFragment suggestLocationsFragment2 = suggestLocationsFragment;
        if (suggestLocationsFragment2 == null) {
            suggestLocationsFragment2 = SuggestLocationsFragment.Companion.newInstance(stringExtra, stringExtra2, Integer.valueOf(intExtra), stringExtra3, locationPickerChooseButtonLocation, booleanExtra, stringExtra4, validationRules, booleanExtra2, booleanExtra3);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, suggestLocationsFragment2, "SUGGEST_LOCATIONS_FRAGMENT").commit();
    }
}
