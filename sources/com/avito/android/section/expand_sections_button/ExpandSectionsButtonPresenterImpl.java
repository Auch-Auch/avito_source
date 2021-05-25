package com.avito.android.section.expand_sections_button;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonPresenter;
import com.avito.android.section.title.SectionTitleItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonPresenterImpl;", "Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonPresenter;", "Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItemView;", "view", "Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItemView;Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItem;I)V", "Lcom/avito/android/section/expand_sections_button/ExpandComplementarySectionsListener;", "c", "Lcom/avito/android/section/expand_sections_button/ExpandComplementarySectionsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/section/title/SectionTitleItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/section/title/SectionTitleItemPresenter;", "titlePresenter", "Lcom/avito/android/section/action/SectionActionPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/section/action/SectionActionPresenter;", "actionPresenter", "<init>", "(Lcom/avito/android/section/title/SectionTitleItemPresenter;Lcom/avito/android/section/action/SectionActionPresenter;Lcom/avito/android/section/expand_sections_button/ExpandComplementarySectionsListener;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ExpandSectionsButtonPresenterImpl implements ExpandSectionsButtonPresenter {
    public final SectionTitleItemPresenter a;
    public final SectionActionPresenter b;
    public final ExpandComplementarySectionsListener c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ExpandSectionsButtonPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ExpandSectionsButtonPresenterImpl expandSectionsButtonPresenterImpl) {
            super(0);
            this.a = expandSectionsButtonPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.c.onSectionsExpandClicked();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ExpandSectionsButtonPresenterImpl(@NotNull SectionTitleItemPresenter sectionTitleItemPresenter, @NotNull SectionActionPresenter sectionActionPresenter, @NotNull ExpandComplementarySectionsListener expandComplementarySectionsListener) {
        Intrinsics.checkNotNullParameter(sectionTitleItemPresenter, "titlePresenter");
        Intrinsics.checkNotNullParameter(sectionActionPresenter, "actionPresenter");
        Intrinsics.checkNotNullParameter(expandComplementarySectionsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = sectionTitleItemPresenter;
        this.b = sectionActionPresenter;
        this.c = expandComplementarySectionsListener;
    }

    public void viewAttached(@NotNull ExpandSectionsButtonItemView expandSectionsButtonItemView, int i) {
        Intrinsics.checkNotNullParameter(expandSectionsButtonItemView, "view");
        ExpandSectionsButtonPresenter.DefaultImpls.viewAttached(this, expandSectionsButtonItemView, i);
    }

    public void viewDetached(@NotNull ExpandSectionsButtonItemView expandSectionsButtonItemView, int i) {
        Intrinsics.checkNotNullParameter(expandSectionsButtonItemView, "view");
        ExpandSectionsButtonPresenter.DefaultImpls.viewDetached(this, expandSectionsButtonItemView, i);
    }

    public void bindView(@NotNull ExpandSectionsButtonItemView expandSectionsButtonItemView, @NotNull ExpandSectionsButtonItem expandSectionsButtonItem, int i) {
        Intrinsics.checkNotNullParameter(expandSectionsButtonItemView, "view");
        Intrinsics.checkNotNullParameter(expandSectionsButtonItem, "item");
        this.a.bindView(expandSectionsButtonItemView, expandSectionsButtonItem, i);
        this.b.bindView(expandSectionsButtonItemView, expandSectionsButtonItem, i);
        String expandButtonTitle = expandSectionsButtonItem.getExpandButtonTitle();
        if (!(!expandSectionsButtonItem.isExpanded())) {
            expandButtonTitle = null;
        }
        expandSectionsButtonItemView.bindExpandButton(expandButtonTitle, new a(this));
    }
}
