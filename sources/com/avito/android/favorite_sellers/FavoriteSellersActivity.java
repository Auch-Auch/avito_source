package com.avito.android.favorite_sellers;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.favorite_sellers.interactor.FavoriteSellersReadInteractorImpl;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Toolbars;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "k", "Ljava/lang/String;", "FAVORITE_SELLERS_TAG", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersActivity extends BaseActivity {
    public final String k = FavoriteSellersReadInteractorImpl.TYPE;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FavoriteSellersActivity a;

        public a(FavoriteSellersActivity favoriteSellersActivity) {
            this.a = favoriteSellersActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.favorite_sellers_container);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, FavoriteSellersFragmentKt.createFavoriteSellersFragmentIntent$default(getIntent().getBooleanExtra("editable", false), getIntent().getStringExtra("user_key"), getIntent().getStringExtra("data_type"), null, 8, null), this.k).commitAllowingStateLoss();
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.avito.a…ated_design.R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        toolbar.setTitle(getIntent().getStringExtra("title"));
        Toolbars.setBackIcon$default(toolbar, 0, 1, null);
        toolbar.setNavigationOnClickListener(new a(this));
    }
}
