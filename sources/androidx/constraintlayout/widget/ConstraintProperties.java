package androidx.constraintlayout.widget;

import a2.b.a.a.a;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.AdError;
import com.yandex.mobile.ads.video.tracking.Tracker;
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    public ConstraintLayout.LayoutParams a;
    public View b;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.a = (ConstraintLayout.LayoutParams) layoutParams;
            this.b = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    public final String a(int i) {
        switch (i) {
            case 1:
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return Tracker.Events.CREATIVE_START;
            case 7:
                return "end";
            default:
                return AdError.UNDEFINED_DOMAIN;
        }
    }

    public ConstraintProperties addToHorizontalChain(int i, int i2) {
        connect(1, i, i == 0 ? 1 : 2, 0);
        connect(2, i2, i2 == 0 ? 2 : 1, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i)).connect(2, this.b.getId(), 1, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2)).connect(1, this.b.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        connect(6, i, i == 0 ? 6 : 7, 0);
        connect(7, i2, i2 == 0 ? 7 : 6, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i)).connect(7, this.b.getId(), 6, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2)).connect(6, this.b.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i, int i2) {
        connect(3, i, i == 0 ? 3 : 4, 0);
        connect(4, i2, i2 == 0 ? 4 : 3, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i)).connect(4, this.b.getId(), 3, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2)).connect(3, this.b.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f) {
        this.b.setAlpha(f);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (i3 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i6 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else {
            if (i2 == 1 || i2 == 2) {
                connect(1, i, i2, i3);
                connect(2, i4, i5, i6);
                this.a.horizontalBias = f;
            } else if (i2 == 6 || i2 == 7) {
                connect(6, i, i2, i3);
                connect(7, i4, i5, i6);
                this.a.horizontalBias = f;
            } else {
                connect(3, i, i2, i3);
                connect(4, i4, i5, i6);
                this.a.verticalBias = f;
            }
            return this;
        }
    }

    public ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(1, i, i2, i3);
        connect(2, i4, i5, i6);
        this.a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(6, i, i2, i3);
        connect(7, i4, i5, i6);
        this.a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(3, i, i2, i3);
        connect(4, i4, i5, i6);
        this.a.verticalBias = f;
        return this;
    }

    public ConstraintProperties connect(int i, int i2, int i3, int i4) {
        switch (i) {
            case 1:
                if (i3 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.a;
                    layoutParams.leftToLeft = i2;
                    layoutParams.leftToRight = -1;
                } else if (i3 == 2) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.a;
                    layoutParams2.leftToRight = i2;
                    layoutParams2.leftToLeft = -1;
                } else {
                    StringBuilder L = a.L("Left to ");
                    L.append(a(i3));
                    L.append(" undefined");
                    throw new IllegalArgumentException(L.toString());
                }
                ((ViewGroup.MarginLayoutParams) this.a).leftMargin = i4;
                break;
            case 2:
                if (i3 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.a;
                    layoutParams3.rightToLeft = i2;
                    layoutParams3.rightToRight = -1;
                } else if (i3 == 2) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.a;
                    layoutParams4.rightToRight = i2;
                    layoutParams4.rightToLeft = -1;
                } else {
                    StringBuilder L2 = a.L("right to ");
                    L2.append(a(i3));
                    L2.append(" undefined");
                    throw new IllegalArgumentException(L2.toString());
                }
                ((ViewGroup.MarginLayoutParams) this.a).rightMargin = i4;
                break;
            case 3:
                if (i3 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.a;
                    layoutParams5.topToTop = i2;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                } else if (i3 == 4) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.a;
                    layoutParams6.topToBottom = i2;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                } else {
                    StringBuilder L3 = a.L("right to ");
                    L3.append(a(i3));
                    L3.append(" undefined");
                    throw new IllegalArgumentException(L3.toString());
                }
                ((ViewGroup.MarginLayoutParams) this.a).topMargin = i4;
                break;
            case 4:
                if (i3 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.a;
                    layoutParams7.bottomToBottom = i2;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                } else if (i3 == 3) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.a;
                    layoutParams8.bottomToTop = i2;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                } else {
                    StringBuilder L4 = a.L("right to ");
                    L4.append(a(i3));
                    L4.append(" undefined");
                    throw new IllegalArgumentException(L4.toString());
                }
                ((ViewGroup.MarginLayoutParams) this.a).bottomMargin = i4;
                break;
            case 5:
                if (i3 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.a;
                    layoutParams9.baselineToBaseline = i2;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                    break;
                } else {
                    StringBuilder L5 = a.L("right to ");
                    L5.append(a(i3));
                    L5.append(" undefined");
                    throw new IllegalArgumentException(L5.toString());
                }
            case 6:
                if (i3 == 6) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.a;
                    layoutParams10.startToStart = i2;
                    layoutParams10.startToEnd = -1;
                } else if (i3 == 7) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.a;
                    layoutParams11.startToEnd = i2;
                    layoutParams11.startToStart = -1;
                } else {
                    StringBuilder L6 = a.L("right to ");
                    L6.append(a(i3));
                    L6.append(" undefined");
                    throw new IllegalArgumentException(L6.toString());
                }
                this.a.setMarginStart(i4);
                break;
            case 7:
                if (i3 == 7) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.a;
                    layoutParams12.endToEnd = i2;
                    layoutParams12.endToStart = -1;
                } else if (i3 == 6) {
                    ConstraintLayout.LayoutParams layoutParams13 = this.a;
                    layoutParams13.endToStart = i2;
                    layoutParams13.endToEnd = -1;
                } else {
                    StringBuilder L7 = a.L("right to ");
                    L7.append(a(i3));
                    L7.append(" undefined");
                    throw new IllegalArgumentException(L7.toString());
                }
                this.a.setMarginEnd(i4);
                break;
            default:
                throw new IllegalArgumentException(a(i) + " to " + a(i3) + " unknown");
        }
        return this;
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        this.a.matchConstraintDefaultHeight = i;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        this.a.matchConstraintDefaultWidth = i;
        return this;
    }

    public ConstraintProperties constrainHeight(int i) {
        ((ViewGroup.MarginLayoutParams) this.a).height = i;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        this.a.matchConstraintMaxHeight = i;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        this.a.matchConstraintMaxWidth = i;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        this.a.matchConstraintMinHeight = i;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        this.a.matchConstraintMinWidth = i;
        return this;
    }

    public ConstraintProperties constrainWidth(int i) {
        ((ViewGroup.MarginLayoutParams) this.a).width = i;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.a.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f) {
        this.b.setElevation(f);
        return this;
    }

    public ConstraintProperties goneMargin(int i, int i2) {
        switch (i) {
            case 1:
                this.a.goneLeftMargin = i2;
                break;
            case 2:
                this.a.goneRightMargin = i2;
                break;
            case 3:
                this.a.goneTopMargin = i2;
                break;
            case 4:
                this.a.goneBottomMargin = i2;
                break;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.a.goneStartMargin = i2;
                break;
            case 7:
                this.a.goneEndMargin = i2;
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties horizontalBias(float f) {
        this.a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        this.a.horizontalChainStyle = i;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f) {
        this.a.horizontalWeight = f;
        return this;
    }

    public ConstraintProperties margin(int i, int i2) {
        switch (i) {
            case 1:
                ((ViewGroup.MarginLayoutParams) this.a).leftMargin = i2;
                break;
            case 2:
                ((ViewGroup.MarginLayoutParams) this.a).rightMargin = i2;
                break;
            case 3:
                ((ViewGroup.MarginLayoutParams) this.a).topMargin = i2;
                break;
            case 4:
                ((ViewGroup.MarginLayoutParams) this.a).bottomMargin = i2;
                break;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.a.setMarginStart(i2);
                break;
            case 7:
                this.a.setMarginEnd(i2);
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties removeConstraints(int i) {
        switch (i) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.a;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.goneLeftMargin = -1;
                break;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.a;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                layoutParams2.goneRightMargin = -1;
                break;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.a;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                layoutParams3.goneTopMargin = -1;
                break;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.a;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                layoutParams4.goneBottomMargin = -1;
                break;
            case 5:
                this.a.baselineToBaseline = -1;
                break;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.a;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.a.goneStartMargin = -1;
                break;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.a;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.a.goneEndMargin = -1;
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.a;
        int i = layoutParams.leftToRight;
        int i2 = layoutParams.rightToLeft;
        if (i == -1 && i2 == -1) {
            int i3 = layoutParams.startToEnd;
            int i4 = layoutParams.endToStart;
            if (!(i3 == -1 && i4 == -1)) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i3));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i4));
                ConstraintLayout.LayoutParams layoutParams2 = this.a;
                if (i3 != -1 && i4 != -1) {
                    constraintProperties.connect(7, i4, 6, 0);
                    constraintProperties2.connect(6, i, 7, 0);
                } else if (!(i == -1 && i4 == -1)) {
                    int i5 = layoutParams2.rightToRight;
                    if (i5 != -1) {
                        constraintProperties.connect(7, i5, 7, 0);
                    } else {
                        int i6 = layoutParams2.leftToLeft;
                        if (i6 != -1) {
                            constraintProperties2.connect(6, i6, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2));
            ConstraintLayout.LayoutParams layoutParams3 = this.a;
            if (i != -1 && i2 != -1) {
                constraintProperties3.connect(2, i2, 1, 0);
                constraintProperties4.connect(1, i, 2, 0);
            } else if (!(i == -1 && i2 == -1)) {
                int i7 = layoutParams3.rightToRight;
                if (i7 != -1) {
                    constraintProperties3.connect(2, i7, 2, 0);
                } else {
                    int i8 = layoutParams3.leftToLeft;
                    if (i8 != -1) {
                        constraintProperties4.connect(1, i8, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.a;
        int i = layoutParams.topToBottom;
        int i2 = layoutParams.bottomToTop;
        if (!(i == -1 && i2 == -1)) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2));
            ConstraintLayout.LayoutParams layoutParams2 = this.a;
            if (i != -1 && i2 != -1) {
                constraintProperties.connect(4, i2, 3, 0);
                constraintProperties2.connect(3, i, 4, 0);
            } else if (!(i == -1 && i2 == -1)) {
                int i3 = layoutParams2.bottomToBottom;
                if (i3 != -1) {
                    constraintProperties.connect(4, i3, 4, 0);
                } else {
                    int i4 = layoutParams2.topToTop;
                    if (i4 != -1) {
                        constraintProperties2.connect(3, i4, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f) {
        this.b.setRotation(f);
        return this;
    }

    public ConstraintProperties rotationX(float f) {
        this.b.setRotationX(f);
        return this;
    }

    public ConstraintProperties rotationY(float f) {
        this.b.setRotationY(f);
        return this;
    }

    public ConstraintProperties scaleX(float f) {
        this.b.setScaleY(f);
        return this;
    }

    public ConstraintProperties scaleY(float f) {
        return this;
    }

    public ConstraintProperties transformPivot(float f, float f2) {
        this.b.setPivotX(f);
        this.b.setPivotY(f2);
        return this;
    }

    public ConstraintProperties transformPivotX(float f) {
        this.b.setPivotX(f);
        return this;
    }

    public ConstraintProperties transformPivotY(float f) {
        this.b.setPivotY(f);
        return this;
    }

    public ConstraintProperties translation(float f, float f2) {
        this.b.setTranslationX(f);
        this.b.setTranslationY(f2);
        return this;
    }

    public ConstraintProperties translationX(float f) {
        this.b.setTranslationX(f);
        return this;
    }

    public ConstraintProperties translationY(float f) {
        this.b.setTranslationY(f);
        return this;
    }

    public ConstraintProperties translationZ(float f) {
        this.b.setTranslationZ(f);
        return this;
    }

    public ConstraintProperties verticalBias(float f) {
        this.a.verticalBias = f;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        this.a.verticalChainStyle = i;
        return this;
    }

    public ConstraintProperties verticalWeight(float f) {
        this.a.verticalWeight = f;
        return this;
    }

    public ConstraintProperties visibility(int i) {
        this.b.setVisibility(i);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, 2, 0, i, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, 7, 0, i, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, 4, 0, i, 3, 0, 0.5f);
        }
        return this;
    }
}
