package com.avito.android.util.text;

import android.text.Editable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.remote.model.text.LinkAttribute;
import com.avito.android.util.DeepLinkSpan;
import com.avito.android.util.TemplateFormatter;
import com.avito.android.util.UrlSpan;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/avito/android/util/text/LegacyAttributedTextFormatter$format$charSequence$1", "Lcom/avito/android/util/TemplateFormatter$Visitor;", "Landroid/text/Editable;", "editable", "", "template", "", Tracker.Events.CREATIVE_START, "end", "", "visit", "(Landroid/text/Editable;Ljava/lang/String;II)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyAttributedTextFormatter$format$charSequence$1 implements TemplateFormatter.Visitor {
    public final /* synthetic */ LegacyAttributedTextFormatter a;
    public final /* synthetic */ AttributedText b;

    public LegacyAttributedTextFormatter$format$charSequence$1(LegacyAttributedTextFormatter legacyAttributedTextFormatter, AttributedText attributedText) {
        this.a = legacyAttributedTextFormatter;
        this.b = attributedText;
    }

    @Override // com.avito.android.util.TemplateFormatter.Visitor
    public void visit(@NotNull Editable editable, @NotNull String str, int i, int i2) {
        T t;
        Intrinsics.checkNotNullParameter(editable, "editable");
        Intrinsics.checkNotNullParameter(str, "template");
        String obj = editable.subSequence(i, i2).toString();
        Iterator<T> it = this.b.getAttributes().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getName(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 instanceof DeepLinkAttribute) {
            LegacyAttributedTextFormatter.access$setSpan(this.a, editable, i, obj, t2.getTitle(), new DeepLinkSpan(t2.getDeepLink(), new OnDeepLinkClickListener(this) { // from class: com.avito.android.util.text.LegacyAttributedTextFormatter$format$charSequence$1$visit$onDeepLinkClickListener$1
                public final /* synthetic */ LegacyAttributedTextFormatter$format$charSequence$1 a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                    OnDeepLinkClickListener onDeepLinkClickListener = this.a.b.getOnDeepLinkClickListener();
                    if (onDeepLinkClickListener != null) {
                        onDeepLinkClickListener.onDeepLinkClick(deepLink);
                    }
                }
            }, false, 4, null));
        } else if (t2 instanceof LinkAttribute) {
            LegacyAttributedTextFormatter.access$setSpan(this.a, editable, i, obj, t2.getTitle(), new UrlSpan(t2.getUrl(), this.b.getOnUrlClickListener(), false, 4, null));
        }
    }
}
