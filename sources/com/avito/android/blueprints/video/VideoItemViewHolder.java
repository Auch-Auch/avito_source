package com.avito.android.blueprints.video;

import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.image_loader.fresco.ImageLoadableExtensionKt;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.expected.video_preview.VideoPreview;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J%\u0010\u000e\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0013J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010\u0007J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0013J!\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010%\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\u0013J\u0017\u00101\u001a\u00020\u00052\u0006\u0010%\u001a\u00020-H\u0016¢\u0006\u0004\b1\u0010/J#\u00104\u001a\u00020\u00052\b\b\u0001\u00102\u001a\u00020\u00142\b\b\u0001\u00103\u001a\u00020\u0014H\u0016¢\u0006\u0004\b4\u00105J\u001d\u00107\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000506H\u0016¢\u0006\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010I¨\u0006Q"}, d2 = {"Lcom/avito/android/blueprints/video/VideoItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/video/VideoItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "setFocusChangeListener", "onUnbind", "()V", "", "limit", "setMaxLength", "(I)V", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "Landroid/text/method/KeyListener;", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "setSingleLine", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "message", "setErrorState", "setLoadingState", "setEmptyState", "Lcom/avito/android/remote/model/Image;", "image", "setLoadedState", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "", "setInputErrorState", "(Ljava/lang/CharSequence;)V", "setInputNormalState", "setInputWarningState", "icon", "colorAttr", "setRightIcon", "(II)V", "Lkotlin/Function0;", "setRightIconClickListener", "(Lkotlin/jvm/functions/Function0;)V", "u", "Landroid/text/TextWatcher;", "valueChangedTextWatcher", "Lcom/avito/android/lib/expected/video_preview/VideoPreview;", VKApiConst.VERSION, "Lcom/avito/android/lib/expected/video_preview/VideoPreview;", "videoPreview", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "Lcom/avito/android/lib/design/input/Input;", "t", "Lcom/avito/android/lib/design/input/Input;", "input", "w", "I", "imageHeight", "x", "imageWidth", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class VideoItemViewHolder extends BaseViewHolder implements VideoItemView {
    public final ComponentContainer s;
    public final Input t;
    public TextWatcher u;
    public final VideoPreview v;
    public final int w;
    public final int x;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.invoke(Boolean.valueOf(z));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.container)");
        this.s = (ComponentContainer) findViewById;
        View findViewById2 = view.findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.input)");
        this.t = (Input) findViewById2;
        View findViewById3 = view.findViewById(R.id.video_preview);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.video_preview)");
        this.v = (VideoPreview) findViewById3;
        this.w = view.getResources().getDimensionPixelSize(R.dimen.video_preview_image_height);
        this.x = view.getResources().getDimensionPixelSize(R.dimen.video_preview_image_width);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        removeTextWatcher();
        Keyboards.hideKeyboard$default(this.s, false, 1, null);
    }

    @Override // com.avito.android.util.FormattableInputView, com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void removeTextWatcher() {
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setEmptyState() {
        this.v.setVisibility(8);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setErrorState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.v.setError(str);
        this.v.setPreviewState(VideoPreview.PreviewState.ERROR);
        this.v.setVisibility(0);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setFocusChangeListener(new a(function1));
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setInputErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setInputNormalState() {
        this.s.showNormalForAll("");
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setInputType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "inputType");
        Input.setFormatterType$default(this.t, formatterType, false, 2, null);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setInputWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.util.FormattableInputView
    public void setKeyListener(@NotNull KeyListener keyListener) {
        Intrinsics.checkNotNullParameter(keyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setKeyListener(keyListener);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setLoadedState(@Nullable Image image, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        ImageLoadableExtensionKt.loadUri$default(this.v, Uri.parse(image != null ? image.find(this.x, this.w) : null), null, null, 6, null);
        this.v.setTitle(str);
        this.v.setPreviewState(VideoPreview.PreviewState.CONTENT);
        this.v.setVisibility(0);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setLoadingState() {
        this.v.setPreviewState(VideoPreview.PreviewState.LOADING);
        this.v.setVisibility(0);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setMaxLength(int i) {
        this.t.setMaxLength(i);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1) {
        TextWatcher textWatcher = this.u;
        if (textWatcher != null) {
            this.t.removeTextChangedListener(textWatcher);
        }
        if (function1 != null) {
            Input input = this.t;
            VideoItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1 videoItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.blueprints.video.VideoItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1
                public String a;
                public final /* synthetic */ Input b;
                public final /* synthetic */ Function1 c;

                {
                    this.b = r1;
                    this.c = r2;
                    this.a = r1.getDeformattedText();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable editable) {
                    String deformattedText = this.b.getDeformattedText();
                    if (!Intrinsics.areEqual(deformattedText, this.a)) {
                        this.c.invoke(deformattedText);
                        this.a = deformattedText;
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                }
            };
            input.addTextChangedListener(videoItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1);
            this.u = videoItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1;
        }
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setPlaceholder(@Nullable String str) {
        this.t.setHint(str);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setRightIcon(@DrawableRes int i, @AttrRes int i2) {
        this.t.setRightIcon(i);
        Input input = this.t;
        input.setRightIconColor(Contexts.getColorByAttr(input.getContext(), i2));
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setRightIconClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setRightIconListener(new b(function0));
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setSingleLine() {
        this.t.setSingleLine();
    }

    @Override // com.avito.android.util.FormattableInputView, com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.t.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.video.VideoItemView
    public void setValue(@Nullable String str) {
        Input.setText$default(this.t, str, false, 2, null);
    }
}
