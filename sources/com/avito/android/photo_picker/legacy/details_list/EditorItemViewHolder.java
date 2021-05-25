package com.avito.android.photo_picker.legacy.details_list;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.avito.android.krop.KropView;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.R;
import com.avito.android.util.Rotation;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010>\u001a\u000202¢\u0006\u0004\b?\u0010@J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\rR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00101\u001a\n .*\u0004\u0018\u00010-0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00104R$\u0010=\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/EditorItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/util/Rotation;", "rotation", "", "showPreview", "(Landroid/net/Uri;Lcom/avito/android/util/Rotation;)V", "showCrop", "(Landroid/net/Uri;)V", "hideImage", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRemoveClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lcom/avito/android/krop/util/Transformation;", "setCropListener", "(Lkotlin/jvm/functions/Function1;)V", "", "isVisible", "setProgressVisibility", "(Z)V", "rotateUi", "(Lcom/avito/android/util/Rotation;)V", "setOnUnbindListener", "onUnbind", "Lcom/avito/android/krop/KropView;", "t", "Lcom/avito/android/krop/KropView;", "photoCrop", "Landroid/widget/ImageView;", VKApiConst.VERSION, "Landroid/widget/ImageView;", "removeIcon", "y", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/facebook/drawee/view/SimpleDraweeView;", "u", "Lcom/facebook/drawee/view/SimpleDraweeView;", "photoPreview", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Landroid/view/View;", "w", "Landroid/view/View;", "removeButton", "x", "progressOverlay", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "z", "Lcom/facebook/datasource/DataSource;", "dataSource", "rootView", "<init>", "(Landroid/view/View;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class EditorItemViewHolder extends BaseViewHolder implements EditorItemView {
    public final Context s;
    public final KropView t;
    public final SimpleDraweeView u;
    public final ImageView v;
    public final View w;
    public final View x;
    public Function0<Unit> y;
    public DataSource<CloseableReference<CloseableImage>> z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.s = context.getApplicationContext();
        View findViewById = view.findViewById(R.id.photo_crop);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.krop.KropView");
        this.t = (KropView) findViewById;
        View findViewById2 = view.findViewById(R.id.photo_preview);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.u = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.remove_icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.v = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.remove_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.w = findViewById4;
        View findViewById5 = view.findViewById(R.id.progress_overlay);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.x = findViewById5;
    }

    public static final void access$setBitmap(EditorItemViewHolder editorItemViewHolder, Bitmap bitmap) {
        editorItemViewHolder.t.setZoom(1.0f);
        KropView kropView = editorItemViewHolder.t;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(bitmap)");
        kropView.setBitmap(createBitmap);
        Views.show(editorItemViewHolder.t);
        Views.conceal(editorItemViewHolder.u);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void hideImage() {
        Views.conceal(this.t);
        Views.conceal(this.u);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DataSource<CloseableReference<CloseableImage>> dataSource = this.z;
        if (dataSource != null) {
            dataSource.close();
        }
        this.z = null;
        Function0<Unit> function0 = this.y;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void rotateUi(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        this.v.setRotation((float) rotation.getDegree());
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void setCropListener(@NotNull Function1<? super Transformation, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setTransformationListener(new KropView.TransformationListener(function1) { // from class: com.avito.android.photo_picker.legacy.details_list.EditorItemViewHolder$setCropListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.krop.KropView.TransformationListener
            public void onUpdate(@NotNull Transformation transformation) {
                Intrinsics.checkNotNullParameter(transformation, "transformation");
                this.a.invoke(transformation);
            }
        });
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void setOnUnbindListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = function0;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void setProgressVisibility(boolean z2) {
        Views.setVisible(this.x, z2);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void setRemoveClickListener(@Nullable Function0<Unit> function0) {
        Views.setVisible(this.w, function0 != null);
        this.w.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void showCrop(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), this.s);
        this.z = fetchDecodedImage;
        if (fetchDecodedImage != null) {
            fetchDecodedImage.subscribe(new BaseBitmapDataSubscriber() { // from class: com.avito.android.photo_picker.legacy.details_list.EditorItemViewHolder$getDataSubscriber$1
                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                }

                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    EditorItemViewHolder editorItemViewHolder = EditorItemViewHolder.this;
                    if (bitmap != null) {
                        EditorItemViewHolder.access$setBitmap(editorItemViewHolder, bitmap);
                    }
                }
            }, UiThreadImmediateExecutorService.getInstance());
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemView
    public void showPreview(@NotNull Uri uri, @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Views.conceal(this.t);
        Views.show(this.u);
        SimpleDraweeViewsKt.getRequestBuilder(this.u).uri(uri).rotate(rotation).load();
    }
}
