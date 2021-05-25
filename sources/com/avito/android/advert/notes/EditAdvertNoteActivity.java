package com.avito.android.advert.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.notes.EditAdvertNotePresenter;
import com.avito.android.advert.notes.di.AdvertDetailsNoteComponent;
import com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies;
import com.avito.android.advert.notes.di.DaggerAdvertDetailsNoteComponent;
import com.avito.android.advert_details.R;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ!\u0010\u0010\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/notes/EditAdvertNoteActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "", "newNote", "", "isDataChanged", "closeScreen", "(Ljava/lang/String;Z)V", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter;", "presenter", "Lcom/avito/android/advert/notes/EditAdvertNotePresenter;", "getPresenter", "()Lcom/avito/android/advert/notes/EditAdvertNotePresenter;", "setPresenter", "(Lcom/avito/android/advert/notes/EditAdvertNotePresenter;)V", "<init>", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class EditAdvertNoteActivity extends BaseActivity implements EditAdvertNotePresenter.Router {
    @Inject
    public EditAdvertNotePresenter presenter;

    @Override // com.avito.android.advert.notes.EditAdvertNotePresenter.Router
    public void closeScreen(@Nullable String str, boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra(EditAdvertNoteActivityKt.ADVERT_RESULT_NOTE, str);
            Unit unit = Unit.INSTANCE;
            setResult(-1, intent);
        }
        finish();
    }

    @NotNull
    public final EditAdvertNotePresenter getPresenter() {
        EditAdvertNotePresenter editAdvertNotePresenter = this.presenter;
        if (editAdvertNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return editAdvertNotePresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.ac_advert_details_edit_note, (ViewGroup) null, false);
        setContentView(inflate);
        String stringExtra = getIntent().getStringExtra("advert_id");
        String stringExtra2 = getIntent().getStringExtra("advert_note");
        String str = "";
        if (stringExtra2 == null) {
            stringExtra2 = str;
        }
        boolean z = bundle != null;
        boolean booleanExtra = getIntent().getBooleanExtra("is_favorite", false);
        AdvertDetailsNoteComponent.Builder advertDetailsNoteDependencies = DaggerAdvertDetailsNoteComponent.builder().advertDetailsNoteDependencies((AdvertDetailsNoteDependencies) ComponentDependenciesKt.getDependencies(AdvertDetailsNoteDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Intrinsics.checkNotNullExpressionValue(stringExtra, BookingInfoActivity.EXTRA_ITEM_ID);
        advertDetailsNoteDependencies.withAdvertId(stringExtra).withNote(stringExtra2).withIsRestored(z).withIsFavorite(booleanExtra).build().inject(this);
        String stringExtra3 = getIntent().getStringExtra("advert_title");
        if (stringExtra3 != null) {
            str = stringExtra3;
        }
        EditAdvertNotePresenter editAdvertNotePresenter = this.presenter;
        if (editAdvertNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        editAdvertNotePresenter.attachView(new EditAdvertNoteViewImpl(inflate, str));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EditAdvertNotePresenter editAdvertNotePresenter = this.presenter;
        if (editAdvertNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        editAdvertNotePresenter.detachView();
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        EditAdvertNotePresenter editAdvertNotePresenter = this.presenter;
        if (editAdvertNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        editAdvertNotePresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        EditAdvertNotePresenter editAdvertNotePresenter = this.presenter;
        if (editAdvertNotePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        editAdvertNotePresenter.detachRouter();
        super.onStop();
    }

    public final void setPresenter(@NotNull EditAdvertNotePresenter editAdvertNotePresenter) {
        Intrinsics.checkNotNullParameter(editAdvertNotePresenter, "<set-?>");
        this.presenter = editAdvertNotePresenter;
    }
}
