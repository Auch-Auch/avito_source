package a2.j.b.b.c1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.R;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
public final class i0 {
    public boolean A;
    public boolean B = true;
    public final StyledPlayerControlView a;
    @Nullable
    public final ViewGroup b;
    @Nullable
    public final ViewGroup c;
    @Nullable
    public final ViewGroup d;
    @Nullable
    public final ViewGroup e;
    @Nullable
    public final ViewGroup f;
    @Nullable
    public final ViewGroup g;
    @Nullable
    public final ViewGroup h;
    @Nullable
    public final View i;
    @Nullable
    public final View j;
    public final AnimatorSet k;
    public final AnimatorSet l;
    public final AnimatorSet m;
    public final AnimatorSet n;
    public final AnimatorSet o;
    public final ValueAnimator p;
    public final ValueAnimator q;
    public final Runnable r = new Runnable() { // from class: a2.j.b.b.c1.z
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.l();
        }
    };
    public final Runnable s = new Runnable() { // from class: a2.j.b.b.c1.s
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.m.start();
        }
    };
    public final Runnable t = new Runnable() { // from class: a2.j.b.b.c1.w
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.l.start();
        }
    };
    public final Runnable u = new Runnable() { // from class: a2.j.b.b.c1.r
        @Override // java.lang.Runnable
        public final void run() {
            i0 i0Var = i0.this;
            i0Var.k.start();
            i0Var.f(i0Var.t, 2000);
        }
    };
    public final Runnable v = new Runnable() { // from class: a2.j.b.b.c1.t
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.j(2);
        }
    };
    public final View.OnLayoutChangeListener w = new View.OnLayoutChangeListener() { // from class: a2.j.b.b.c1.u
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            i0 i0Var = i0.this;
            boolean z2 = false;
            boolean z3 = (i0Var.a.getWidth() - i0Var.a.getPaddingLeft()) - i0Var.a.getPaddingRight() <= Math.max(i0.d(i0Var.b), i0.d(i0Var.j) + i0.d(i0Var.h)) || (i0Var.a.getHeight() - i0Var.a.getPaddingBottom()) - i0Var.a.getPaddingTop() <= i0.b(i0Var.c) + (i0.b(i0Var.i) + i0.b(i0Var.b));
            if (i0Var.z != z3) {
                i0Var.z = z3;
                view.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006a: INVOKE  
                      (r4v0 'view' android.view.View)
                      (wrap: a2.j.b.b.c1.p : 0x0067: CONSTRUCTOR  (r8v6 a2.j.b.b.c1.p) = (r6v1 'i0Var' a2.j.b.b.c1.i0) call: a2.j.b.b.c1.p.<init>(a2.j.b.b.c1.i0):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.post(java.lang.Runnable):boolean in method: a2.j.b.b.c1.u.onLayoutChange(android.view.View, int, int, int, int, int, int, int, int):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: CONSTRUCTOR  (r8v6 a2.j.b.b.c1.p) = (r6v1 'i0Var' a2.j.b.b.c1.i0) call: a2.j.b.b.c1.p.<init>(a2.j.b.b.c1.i0):void type: CONSTRUCTOR in method: a2.j.b.b.c1.u.onLayoutChange(android.view.View, int, int, int, int, int, int, int, int):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                    	... 21 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.b.b.c1.p, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                    	... 27 more
                    */
                /*
                    this = this;
                    a2.j.b.b.c1.i0 r6 = a2.j.b.b.c1.i0.this
                    com.google.android.exoplayer2.ui.StyledPlayerControlView r8 = r6.a
                    int r8 = r8.getWidth()
                    com.google.android.exoplayer2.ui.StyledPlayerControlView r10 = r6.a
                    int r10 = r10.getPaddingLeft()
                    int r8 = r8 - r10
                    com.google.android.exoplayer2.ui.StyledPlayerControlView r10 = r6.a
                    int r10 = r10.getPaddingRight()
                    int r8 = r8 - r10
                    com.google.android.exoplayer2.ui.StyledPlayerControlView r10 = r6.a
                    int r10 = r10.getHeight()
                    com.google.android.exoplayer2.ui.StyledPlayerControlView r12 = r6.a
                    int r12 = r12.getPaddingBottom()
                    int r10 = r10 - r12
                    com.google.android.exoplayer2.ui.StyledPlayerControlView r12 = r6.a
                    int r12 = r12.getPaddingTop()
                    int r10 = r10 - r12
                    android.view.ViewGroup r12 = r6.b
                    int r12 = a2.j.b.b.c1.i0.d(r12)
                    android.view.ViewGroup r0 = r6.h
                    int r0 = a2.j.b.b.c1.i0.d(r0)
                    android.view.View r1 = r6.j
                    int r1 = a2.j.b.b.c1.i0.d(r1)
                    int r1 = r1 + r0
                    int r12 = java.lang.Math.max(r12, r1)
                    android.view.ViewGroup r0 = r6.b
                    int r0 = a2.j.b.b.c1.i0.b(r0)
                    android.view.View r1 = r6.i
                    int r1 = a2.j.b.b.c1.i0.b(r1)
                    int r1 = r1 + r0
                    android.view.ViewGroup r0 = r6.c
                    int r0 = a2.j.b.b.c1.i0.b(r0)
                    int r0 = r0 + r1
                    r1 = 0
                    r2 = 1
                    if (r8 <= r12) goto L_0x005e
                    if (r10 > r0) goto L_0x005c
                    goto L_0x005e
                L_0x005c:
                    r8 = 0
                    goto L_0x005f
                L_0x005e:
                    r8 = 1
                L_0x005f:
                    boolean r10 = r6.z
                    if (r10 == r8) goto L_0x006d
                    r6.z = r8
                    a2.j.b.b.c1.p r8 = new a2.j.b.b.c1.p
                    r8.<init>(r6)
                    r4.post(r8)
                L_0x006d:
                    int r7 = r7 - r5
                    int r11 = r11 - r9
                    if (r7 == r11) goto L_0x0072
                    r1 = 1
                L_0x0072:
                    boolean r5 = r6.z
                    if (r5 != 0) goto L_0x0080
                    if (r1 == 0) goto L_0x0080
                    a2.j.b.b.c1.q r5 = new a2.j.b.b.c1.q
                    r5.<init>(r6)
                    r4.post(r5)
                L_0x0080:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.c1.u.onLayoutChange(android.view.View, int, int, int, int, int, int, int, int):void");
            }
        };
        public final List<View> x = new ArrayList();
        public int y = 0;
        public boolean z;

        public class a extends AnimatorListenerAdapter {
            public final /* synthetic */ ViewGroup a;

            public a(ViewGroup viewGroup) {
                this.a = viewGroup;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup viewGroup = this.a;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = i0.this.d;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                i0 i0Var = i0.this;
                View view = i0Var.i;
                if ((view instanceof DefaultTimeBar) && !i0Var.z) {
                    ((DefaultTimeBar) view).hideScrubber(250);
                }
            }
        }

        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ ViewGroup a;

            public b(ViewGroup viewGroup) {
                this.a = viewGroup;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup viewGroup = this.a;
                int i = 0;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                i0 i0Var = i0.this;
                ViewGroup viewGroup2 = i0Var.d;
                if (viewGroup2 != null) {
                    if (!i0Var.z) {
                        i = 4;
                    }
                    viewGroup2.setVisibility(i);
                }
                i0 i0Var2 = i0.this;
                View view = i0Var2.i;
                if ((view instanceof DefaultTimeBar) && !i0Var2.z) {
                    ((DefaultTimeBar) view).showScrubber(250);
                }
            }
        }

        public class c extends AnimatorListenerAdapter {
            public final /* synthetic */ StyledPlayerControlView a;

            public c(StyledPlayerControlView styledPlayerControlView) {
                this.a = styledPlayerControlView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                i0.this.j(1);
                i0 i0Var = i0.this;
                if (i0Var.A) {
                    this.a.post(i0Var.r);
                    i0.this.A = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                i0.this.j(3);
            }
        }

        public class d extends AnimatorListenerAdapter {
            public final /* synthetic */ StyledPlayerControlView a;

            public d(StyledPlayerControlView styledPlayerControlView) {
                this.a = styledPlayerControlView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                i0.this.j(2);
                i0 i0Var = i0.this;
                if (i0Var.A) {
                    this.a.post(i0Var.r);
                    i0.this.A = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                i0.this.j(3);
            }
        }

        public class e extends AnimatorListenerAdapter {
            public final /* synthetic */ StyledPlayerControlView a;

            public e(StyledPlayerControlView styledPlayerControlView) {
                this.a = styledPlayerControlView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                i0.this.j(2);
                i0 i0Var = i0.this;
                if (i0Var.A) {
                    this.a.post(i0Var.r);
                    i0.this.A = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                i0.this.j(3);
            }
        }

        public class f extends AnimatorListenerAdapter {
            public f() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                i0.this.j(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                i0.this.j(4);
            }
        }

        public class g extends AnimatorListenerAdapter {
            public g() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                i0.this.j(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                i0.this.j(4);
            }
        }

        public class h extends AnimatorListenerAdapter {
            public h() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup viewGroup = i0.this.e;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup viewGroup = i0.this.g;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                    ViewGroup viewGroup2 = i0.this.g;
                    viewGroup2.setTranslationX((float) viewGroup2.getWidth());
                    ViewGroup viewGroup3 = i0.this.g;
                    viewGroup3.scrollTo(viewGroup3.getWidth(), 0);
                }
            }
        }

        public class i extends AnimatorListenerAdapter {
            public i() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup viewGroup = i0.this.g;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup viewGroup = i0.this.e;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
            }
        }

        public i0(StyledPlayerControlView styledPlayerControlView) {
            this.a = styledPlayerControlView;
            ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_center_view);
            this.b = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_embedded_transport_controls);
            this.d = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_minimal_controls);
            ViewGroup viewGroup2 = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_bottom_bar);
            this.c = viewGroup2;
            this.h = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_time);
            View findViewById = styledPlayerControlView.findViewById(R.id.exo_progress);
            this.i = findViewById;
            this.e = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_basic_controls);
            this.f = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls);
            this.g = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls_scroll_view);
            View findViewById2 = styledPlayerControlView.findViewById(R.id.exo_overflow_show);
            this.j = findViewById2;
            View findViewById3 = styledPlayerControlView.findViewById(R.id.exo_overflow_hide);
            if (!(findViewById2 == null || findViewById3 == null)) {
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: a2.j.b.b.c1.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        i0 i0Var = i0.this;
                        i0Var.h();
                        if (view.getId() == R.id.exo_overflow_show) {
                            i0Var.p.start();
                        } else if (view.getId() == R.id.exo_overflow_hide) {
                            i0Var.q.start();
                        }
                    }
                });
                findViewById3.setOnClickListener(new View.OnClickListener() { // from class: a2.j.b.b.c1.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        i0 i0Var = i0.this;
                        i0Var.h();
                        if (view.getId() == R.id.exo_overflow_show) {
                            i0Var.p.start();
                        } else if (view.getId() == R.id.exo_overflow_hide) {
                            i0Var.q.start();
                        }
                    }
                });
            }
            Resources resources = styledPlayerControlView.getResources();
            float dimension = resources.getDimension(R.dimen.exo_bottom_bar_height) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
            float dimension2 = resources.getDimension(R.dimen.exo_styled_progress_margin_bottom);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(viewGroup) { // from class: a2.j.b.b.c1.v
                public final /* synthetic */ ViewGroup b;

                {
                    this.b = r2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i0 i0Var = i0.this;
                    ViewGroup viewGroup3 = this.b;
                    Objects.requireNonNull(i0Var);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (viewGroup3 != null) {
                        viewGroup3.setAlpha(floatValue);
                    }
                    ViewGroup viewGroup4 = i0Var.d;
                    if (viewGroup4 != null) {
                        viewGroup4.setAlpha(floatValue);
                    }
                }
            });
            ofFloat.addListener(new a(viewGroup));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(viewGroup) { // from class: a2.j.b.b.c1.b0
                public final /* synthetic */ ViewGroup b;

                {
                    this.b = r2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i0 i0Var = i0.this;
                    ViewGroup viewGroup3 = this.b;
                    Objects.requireNonNull(i0Var);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (viewGroup3 != null) {
                        viewGroup3.setAlpha(floatValue);
                    }
                    ViewGroup viewGroup4 = i0Var.d;
                    if (viewGroup4 != null) {
                        viewGroup4.setAlpha(floatValue);
                    }
                }
            });
            ofFloat2.addListener(new b(viewGroup));
            AnimatorSet animatorSet = new AnimatorSet();
            this.k = animatorSet;
            animatorSet.setDuration(250L);
            animatorSet.addListener(new c(styledPlayerControlView));
            animatorSet.play(ofFloat).with(e(0.0f, dimension, findViewById)).with(e(0.0f, dimension, viewGroup2));
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.l = animatorSet2;
            animatorSet2.setDuration(250L);
            animatorSet2.addListener(new d(styledPlayerControlView));
            float dimension3 = ((resources.getDimension(R.dimen.exo_styled_progress_layout_height) + dimension2) - dimension) + dimension;
            animatorSet2.play(e(dimension, dimension3, findViewById)).with(e(dimension, dimension3, viewGroup2));
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.m = animatorSet3;
            animatorSet3.setDuration(250L);
            animatorSet3.addListener(new e(styledPlayerControlView));
            animatorSet3.play(ofFloat).with(e(0.0f, dimension3, findViewById)).with(e(0.0f, dimension3, viewGroup2));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.n = animatorSet4;
            animatorSet4.setDuration(250L);
            animatorSet4.addListener(new f());
            animatorSet4.play(ofFloat2).with(e(dimension, 0.0f, findViewById)).with(e(dimension, 0.0f, viewGroup2));
            AnimatorSet animatorSet5 = new AnimatorSet();
            this.o = animatorSet5;
            animatorSet5.setDuration(250L);
            animatorSet5.addListener(new g());
            animatorSet5.play(ofFloat2).with(e(dimension3, 0.0f, findViewById)).with(e(dimension3, 0.0f, viewGroup2));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.p = ofFloat3;
            ofFloat3.setDuration(250L);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a2.j.b.b.c1.x
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i0 i0Var = i0.this;
                    Objects.requireNonNull(i0Var);
                    i0Var.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat3.addListener(new h());
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.q = ofFloat4;
            ofFloat4.setDuration(250L);
            ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a2.j.b.b.c1.a0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    i0 i0Var = i0.this;
                    Objects.requireNonNull(i0Var);
                    i0Var.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat4.addListener(new i());
        }

        public static int b(@Nullable View view) {
            if (view != null) {
                return view.getHeight();
            }
            return 0;
        }

        public static int d(@Nullable View view) {
            if (view != null) {
                return view.getWidth();
            }
            return 0;
        }

        public static ObjectAnimator e(float f2, float f3, View view) {
            return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
        }

        public final void a(float f2) {
            ViewGroup viewGroup = this.g;
            if (viewGroup != null) {
                this.g.setTranslationX((float) ((int) ((1.0f - f2) * ((float) viewGroup.getWidth()))));
            }
            ViewGroup viewGroup2 = this.h;
            if (viewGroup2 != null) {
                viewGroup2.setAlpha(1.0f - f2);
            }
            ViewGroup viewGroup3 = this.e;
            if (viewGroup3 != null) {
                viewGroup3.setAlpha(1.0f - f2);
            }
        }

        public boolean c(@Nullable View view) {
            return view != null && this.x.contains(view);
        }

        public final void f(Runnable runnable, long j2) {
            if (j2 >= 0) {
                this.a.postDelayed(runnable, j2);
            }
        }

        public void g() {
            this.a.removeCallbacks(this.v);
            this.a.removeCallbacks(this.s);
            this.a.removeCallbacks(this.u);
            this.a.removeCallbacks(this.t);
        }

        public void h() {
            if (this.y != 3) {
                g();
                int showTimeoutMs = this.a.getShowTimeoutMs();
                if (showTimeoutMs <= 0) {
                    return;
                }
                if (!this.B) {
                    f(this.v, (long) showTimeoutMs);
                } else if (this.y == 1) {
                    f(this.t, 2000);
                } else {
                    f(this.u, (long) showTimeoutMs);
                }
            }
        }

        public void i(@Nullable View view, boolean z2) {
            if (view != null) {
                if (!z2) {
                    view.setVisibility(8);
                    this.x.remove(view);
                    return;
                }
                if (!this.z || !k(view)) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
                this.x.add(view);
            }
        }

        public final void j(int i2) {
            int i3 = this.y;
            this.y = i2;
            if (i2 == 2) {
                this.a.setVisibility(8);
            } else if (i3 == 2) {
                this.a.setVisibility(0);
            }
            if (i3 != i2) {
                StyledPlayerControlView styledPlayerControlView = this.a;
                Iterator<StyledPlayerControlView.VisibilityListener> it = styledPlayerControlView.b.iterator();
                while (it.hasNext()) {
                    it.next().onVisibilityChange(styledPlayerControlView.getVisibility());
                }
            }
        }

        public final boolean k(View view) {
            int id = view.getId();
            return id == R.id.exo_bottom_bar || id == R.id.exo_prev || id == R.id.exo_next || id == R.id.exo_rew || id == R.id.exo_rew_with_amount || id == R.id.exo_ffwd || id == R.id.exo_ffwd_with_amount;
        }

        public final void l() {
            if (!this.B) {
                j(0);
                h();
                return;
            }
            int i2 = this.y;
            if (i2 == 1) {
                this.n.start();
            } else if (i2 == 2) {
                this.o.start();
            } else if (i2 == 3) {
                this.A = true;
            } else if (i2 == 4) {
                return;
            }
            h();
        }
    }
