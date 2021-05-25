package ru.sravni.android.bankproduct.presentation.test.material;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/presentation/test/material/TestAllMaterialActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TestAllMaterialActivity extends AppCompatActivity {
    public HashMap c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TestAllMaterialActivity a;

        /* compiled from: java-style lambda group */
        /* renamed from: ru.sravni.android.bankproduct.presentation.test.material.TestAllMaterialActivity$a$a  reason: collision with other inner class name */
        public static final class DialogInterface$OnClickListenerC0676a implements DialogInterface.OnClickListener {
            public static final DialogInterface$OnClickListenerC0676a b = new DialogInterface$OnClickListenerC0676a(0);
            public static final DialogInterface$OnClickListenerC0676a c = new DialogInterface$OnClickListenerC0676a(1);
            public final /* synthetic */ int a;

            public DialogInterface$OnClickListenerC0676a(int i) {
                this.a = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                int i2 = this.a;
                if (i2 != 0 && i2 != 1) {
                    throw null;
                }
            }
        }

        public a(TestAllMaterialActivity testAllMaterialActivity) {
            this.a = testAllMaterialActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new MaterialAlertDialogBuilder(this.a).setTitle((CharSequence) this.a.getString(R.string.start_again)).setMessage((CharSequence) this.a.getString(R.string.start_again_chat_message)).setPositiveButton(R.string.Yes, (DialogInterface.OnClickListener) DialogInterface$OnClickListenerC0676a.b).setNegativeButton(R.string.No, (DialogInterface.OnClickListener) DialogInterface$OnClickListenerC0676a.c).show();
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        View view = (View) this.c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_all_material_elements_sravni);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayShowHomeEnabled(true);
        }
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(R.id.tilError);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "tilError");
        textInputLayout.setError("Error example");
        ((MaterialButton) _$_findCachedViewById(R.id.button0)).setOnClickListener(new a(this));
    }
}
