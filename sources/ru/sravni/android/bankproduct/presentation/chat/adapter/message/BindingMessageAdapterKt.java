package ru.sravni.android.bankproduct.presentation.chat.adapter.message;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "Landroidx/lifecycle/LifecycleOwner;", "chatLifecycleOwner", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", "chatViewModel", "", "bindListToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/lifecycle/LifecycleOwner;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;)V", "Landroid/widget/ImageView;", "", "animateAction", "bindVisibleWaiting", "(Landroid/widget/ImageView;Z)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingMessageAdapterKt {
    @BindingAdapter({"chatLifecycleOwner", "chatViewModel"})
    public static final void bindListToRecycler(@NotNull RecyclerView recyclerView, @NotNull LifecycleOwner lifecycleOwner, @NotNull IChatViewModel iChatViewModel) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "chatLifecycleOwner");
        Intrinsics.checkParameterIsNotNull(iChatViewModel, "chatViewModel");
        if (recyclerView.getAdapter() == null) {
            MessageAdapter messageAdapter = new MessageAdapter(lifecycleOwner, iChatViewModel);
            recyclerView.setAdapter(messageAdapter);
            messageAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(messageAdapter) { // from class: ru.sravni.android.bankproduct.presentation.chat.adapter.message.BindingMessageAdapterKt$registerDataObserverToScroll$1
                public final /* synthetic */ MessageAdapter b;

                {
                    this.b = r2;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeChanged(int i, int i2) {
                    RecyclerView.this.scrollToPosition(this.b.getItemCount() - 1);
                    super.onItemRangeChanged(i, i2);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeInserted(int i, int i2) {
                    RecyclerView.this.scrollToPosition(this.b.getItemCount() - 1);
                    super.onItemRangeChanged(i, i2);
                }
            });
        }
    }

    @BindingAdapter({"animateAction"})
    public static final void bindVisibleWaiting(@NotNull ImageView imageView, boolean z) {
        Intrinsics.checkParameterIsNotNull(imageView, "view");
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(imageView.getContext(), R.anim.circle_anim_sravni);
            int id = imageView.getId();
            if (id == R.id.imgFirstPoint) {
                imageView.startAnimation(loadAnimation);
            } else if (id == R.id.imgSecondPoint) {
                Observable.timer(150, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(0, imageView, loadAnimation));
            } else if (id == R.id.imgThirdPoint) {
                Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(1, imageView, loadAnimation));
            }
        } else {
            imageView.clearAnimation();
        }
    }
}
