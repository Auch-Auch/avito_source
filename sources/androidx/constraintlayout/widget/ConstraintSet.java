package androidx.constraintlayout.widget;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.AdError;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;
public class ConstraintSet {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_GUIDELINE = 0;
    public static final int INVISIBLE = 4;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GUIDELINE = 1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    public static final int WRAP_CONTENT = -2;
    public static final int[] d = {0, 4, 8};
    public static SparseIntArray e;
    public HashMap<String, ConstraintAttribute> a = new HashMap<>();
    public boolean b = true;
    public HashMap<Integer, Constraint> c = new HashMap<>();

    public static class Constraint {
        public int a;
        public final Layout layout = new Layout();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();
        public final Motion motion = new Motion();
        public final PropertySet propertySet = new PropertySet();
        public final Transform transform = new Transform();

        public static void a(Constraint constraint, String str, float f) {
            Objects.requireNonNull(constraint);
            constraint.d(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout2 = this.layout;
            layoutParams.leftToLeft = layout2.leftToLeft;
            layoutParams.leftToRight = layout2.leftToRight;
            layoutParams.rightToLeft = layout2.rightToLeft;
            layoutParams.rightToRight = layout2.rightToRight;
            layoutParams.topToTop = layout2.topToTop;
            layoutParams.topToBottom = layout2.topToBottom;
            layoutParams.bottomToTop = layout2.bottomToTop;
            layoutParams.bottomToBottom = layout2.bottomToBottom;
            layoutParams.baselineToBaseline = layout2.baselineToBaseline;
            layoutParams.startToEnd = layout2.startToEnd;
            layoutParams.startToStart = layout2.startToStart;
            layoutParams.endToStart = layout2.endToStart;
            layoutParams.endToEnd = layout2.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout2.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout2.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout2.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout2.bottomMargin;
            layoutParams.goneStartMargin = layout2.goneStartMargin;
            layoutParams.goneEndMargin = layout2.goneEndMargin;
            layoutParams.goneTopMargin = layout2.goneTopMargin;
            layoutParams.goneBottomMargin = layout2.goneBottomMargin;
            layoutParams.horizontalBias = layout2.horizontalBias;
            layoutParams.verticalBias = layout2.verticalBias;
            layoutParams.circleConstraint = layout2.circleConstraint;
            layoutParams.circleRadius = layout2.circleRadius;
            Layout layout3 = this.layout;
            layoutParams.circleAngle = layout3.circleAngle;
            layoutParams.dimensionRatio = layout3.dimensionRatio;
            layoutParams.editorAbsoluteX = layout3.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout3.editorAbsoluteY;
            layoutParams.verticalWeight = layout3.verticalWeight;
            layoutParams.horizontalWeight = layout3.horizontalWeight;
            layoutParams.verticalChainStyle = layout3.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout3.horizontalChainStyle;
            layoutParams.constrainedWidth = layout3.constrainedWidth;
            layoutParams.constrainedHeight = layout3.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout3.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout3.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout3.widthMax;
            layoutParams.matchConstraintMaxHeight = layout3.heightMax;
            layoutParams.matchConstraintMinWidth = layout3.widthMin;
            layoutParams.matchConstraintMinHeight = layout3.heightMin;
            layoutParams.matchConstraintPercentWidth = layout3.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout3.heightPercent;
            layoutParams.orientation = layout3.orientation;
            layoutParams.guidePercent = layout3.guidePercent;
            layoutParams.guideBegin = layout3.guideBegin;
            layoutParams.guideEnd = layout3.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout3.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout3.mHeight;
            String str = layout3.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(this.layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        public final void b(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.a = i;
            Layout layout2 = this.layout;
            layout2.leftToLeft = layoutParams.leftToLeft;
            layout2.leftToRight = layoutParams.leftToRight;
            layout2.rightToLeft = layoutParams.rightToLeft;
            layout2.rightToRight = layoutParams.rightToRight;
            layout2.topToTop = layoutParams.topToTop;
            layout2.topToBottom = layoutParams.topToBottom;
            layout2.bottomToTop = layoutParams.bottomToTop;
            layout2.bottomToBottom = layoutParams.bottomToBottom;
            layout2.baselineToBaseline = layoutParams.baselineToBaseline;
            layout2.startToEnd = layoutParams.startToEnd;
            layout2.startToStart = layoutParams.startToStart;
            layout2.endToStart = layoutParams.endToStart;
            layout2.endToEnd = layoutParams.endToEnd;
            layout2.horizontalBias = layoutParams.horizontalBias;
            layout2.verticalBias = layoutParams.verticalBias;
            layout2.dimensionRatio = layoutParams.dimensionRatio;
            layout2.circleConstraint = layoutParams.circleConstraint;
            layout2.circleRadius = layoutParams.circleRadius;
            layout2.circleAngle = layoutParams.circleAngle;
            layout2.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout2.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout2.orientation = layoutParams.orientation;
            layout2.guidePercent = layoutParams.guidePercent;
            layout2.guideBegin = layoutParams.guideBegin;
            layout2.guideEnd = layoutParams.guideEnd;
            Layout layout3 = this.layout;
            layout3.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout3.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout3.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout3.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout3.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout3.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout3.verticalWeight = layoutParams.verticalWeight;
            layout3.horizontalWeight = layoutParams.horizontalWeight;
            layout3.verticalChainStyle = layoutParams.verticalChainStyle;
            layout3.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout3.constrainedWidth = layoutParams.constrainedWidth;
            layout3.constrainedHeight = layoutParams.constrainedHeight;
            layout3.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout3.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout3.widthMax = layoutParams.matchConstraintMaxWidth;
            layout3.heightMax = layoutParams.matchConstraintMaxHeight;
            layout3.widthMin = layoutParams.matchConstraintMinWidth;
            layout3.heightMin = layoutParams.matchConstraintMinHeight;
            layout3.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout3.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout3.mConstraintTag = layoutParams.constraintTag;
            layout3.goneTopMargin = layoutParams.goneTopMargin;
            layout3.goneBottomMargin = layoutParams.goneBottomMargin;
            layout3.goneLeftMargin = layoutParams.goneLeftMargin;
            layout3.goneRightMargin = layoutParams.goneRightMargin;
            Layout layout4 = this.layout;
            layout4.goneStartMargin = layoutParams.goneStartMargin;
            layout4.goneEndMargin = layoutParams.goneEndMargin;
            layout4.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        public final void c(int i, Constraints.LayoutParams layoutParams) {
            b(i, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform2 = this.transform;
            transform2.rotation = layoutParams.rotation;
            transform2.rotationX = layoutParams.rotationX;
            transform2.rotationY = layoutParams.rotationY;
            transform2.scaleX = layoutParams.scaleX;
            transform2.scaleY = layoutParams.scaleY;
            transform2.transformPivotX = layoutParams.transformPivotX;
            transform2.transformPivotY = layoutParams.transformPivotY;
            transform2.translationX = layoutParams.translationX;
            transform2.translationY = layoutParams.translationY;
            transform2.translationZ = layoutParams.translationZ;
            transform2.elevation = layoutParams.elevation;
            transform2.applyElevation = layoutParams.applyElevation;
        }

        public final ConstraintAttribute d(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                if (constraintAttribute.getType() == attributeType) {
                    return constraintAttribute;
                }
                StringBuilder L = a.L("ConstraintAttribute is already a ");
                L.append(constraintAttribute.getType().name());
                throw new IllegalArgumentException(L.toString());
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.mCustomConstraints.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.a = this.a;
            return constraint;
        }
    }

    public static class Layout {
        public static final int UNSET = -1;
        public static SparseIntArray a;
        public int baselineToBaseline = -1;
        public int bottomMargin = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endMargin = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int heightDefault = 0;
        public int heightMax = -1;
        public int heightMin = -1;
        public float heightPercent = 1.0f;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;
        public int leftMargin = -1;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public boolean mApply = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType = -1;
        public boolean mIsGuideline = false;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation = -1;
        public int rightMargin = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startMargin = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topMargin = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int widthDefault = 0;
        public int widthMax = -1;
        public int widthMin = -1;
        public float widthPercent = 1.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            a.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            a.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            a.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            a.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            a.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            a.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            a.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            a.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            a.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            a.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            a.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            a.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            a.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            a.append(R.styleable.Layout_android_orientation, 26);
            a.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            a.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            a.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            a.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            a.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            a.append(R.styleable.Layout_layout_goneMarginTop, 16);
            a.append(R.styleable.Layout_layout_goneMarginRight, 14);
            a.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            a.append(R.styleable.Layout_layout_goneMarginStart, 15);
            a.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            a.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            a.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            a.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            a.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            a.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            a.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            a.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            a.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            a.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            a.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            a.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            a.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            a.append(R.styleable.Layout_android_layout_marginLeft, 23);
            a.append(R.styleable.Layout_android_layout_marginRight, 27);
            a.append(R.styleable.Layout_android_layout_marginStart, 30);
            a.append(R.styleable.Layout_android_layout_marginEnd, 8);
            a.append(R.styleable.Layout_android_layout_marginTop, 33);
            a.append(R.styleable.Layout_android_layout_marginBottom, 2);
            a.append(R.styleable.Layout_android_layout_width, 22);
            a.append(R.styleable.Layout_android_layout_height, 21);
            a.append(R.styleable.Layout_layout_constraintCircle, 61);
            a.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            a.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            a.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            a.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            a.append(R.styleable.Layout_chainUseRtl, 71);
            a.append(R.styleable.Layout_barrierDirection, 72);
            a.append(R.styleable.Layout_barrierMargin, 73);
            a.append(R.styleable.Layout_constraint_referenced_ids, 74);
            a.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = a.get(index);
                if (i2 == 80) {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            int i3 = this.baselineToBaseline;
                            int i4 = ConstraintSet.UNSET;
                            int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.baselineToBaseline = resourceId;
                            continue;
                        case 2:
                            this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                            continue;
                        case 3:
                            int i5 = this.bottomToBottom;
                            int i6 = ConstraintSet.UNSET;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.bottomToBottom = resourceId2;
                            continue;
                        case 4:
                            int i7 = this.bottomToTop;
                            int i8 = ConstraintSet.UNSET;
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId3 == -1) {
                                resourceId3 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.bottomToTop = resourceId3;
                            continue;
                        case 5:
                            this.dimensionRatio = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            continue;
                        case 7:
                            this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            continue;
                        case 8:
                            this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                            continue;
                        case 9:
                            int i9 = this.endToEnd;
                            int i10 = ConstraintSet.UNSET;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.endToEnd = resourceId4;
                            continue;
                        case 10:
                            int i11 = this.endToStart;
                            int i12 = ConstraintSet.UNSET;
                            int resourceId5 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId5 == -1) {
                                resourceId5 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.endToStart = resourceId5;
                            continue;
                        case 11:
                            this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                            continue;
                        case 12:
                            this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                            continue;
                        case 13:
                            this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                            continue;
                        case 14:
                            this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                            continue;
                        case 15:
                            this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                            continue;
                        case 16:
                            this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                            continue;
                        case 17:
                            this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                            continue;
                        case 18:
                            this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                            continue;
                        case 19:
                            this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                            continue;
                        case 20:
                            this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                            continue;
                        case 21:
                            this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                            continue;
                        case 22:
                            this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                            continue;
                        case 23:
                            this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                            continue;
                        case 24:
                            int i13 = this.leftToLeft;
                            int i14 = ConstraintSet.UNSET;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.leftToLeft = resourceId6;
                            continue;
                        case 25:
                            int i15 = this.leftToRight;
                            int i16 = ConstraintSet.UNSET;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.leftToRight = resourceId7;
                            continue;
                        case 26:
                            this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                            continue;
                        case 27:
                            this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                            continue;
                        case 28:
                            int i17 = this.rightToLeft;
                            int i18 = ConstraintSet.UNSET;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i17);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.rightToLeft = resourceId8;
                            continue;
                        case 29:
                            int i19 = this.rightToRight;
                            int i20 = ConstraintSet.UNSET;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i19);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.rightToRight = resourceId9;
                            continue;
                        case 30:
                            this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                            continue;
                        case 31:
                            int i21 = this.startToEnd;
                            int i22 = ConstraintSet.UNSET;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i21);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.startToEnd = resourceId10;
                            continue;
                        case 32:
                            int i23 = this.startToStart;
                            int i24 = ConstraintSet.UNSET;
                            int resourceId11 = obtainStyledAttributes.getResourceId(index, i23);
                            if (resourceId11 == -1) {
                                resourceId11 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.startToStart = resourceId11;
                            continue;
                        case 33:
                            this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                            continue;
                        case 34:
                            int i25 = this.topToBottom;
                            int i26 = ConstraintSet.UNSET;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i25);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.topToBottom = resourceId12;
                            continue;
                        case 35:
                            int i27 = this.topToTop;
                            int i28 = ConstraintSet.UNSET;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i27);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.topToTop = resourceId13;
                            continue;
                        case 36:
                            this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                            continue;
                        case 37:
                            this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            continue;
                        case 38:
                            this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                            continue;
                        case 39:
                            this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                            continue;
                        case 40:
                            this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                            continue;
                        default:
                            switch (i2) {
                                case 54:
                                    this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                    continue;
                                case 55:
                                    this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                    continue;
                                case 56:
                                    this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                    continue;
                                case 57:
                                    this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                    continue;
                                case 58:
                                    this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                    continue;
                                case 59:
                                    this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                    continue;
                                default:
                                    switch (i2) {
                                        case 61:
                                            int i29 = this.circleConstraint;
                                            int i30 = ConstraintSet.UNSET;
                                            int resourceId14 = obtainStyledAttributes.getResourceId(index, i29);
                                            if (resourceId14 == -1) {
                                                resourceId14 = obtainStyledAttributes.getInt(index, -1);
                                            }
                                            this.circleConstraint = resourceId14;
                                            continue;
                                        case 62:
                                            this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                            continue;
                                        case 63:
                                            this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 72:
                                                    this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                    continue;
                                                case 73:
                                                    this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                    continue;
                                                case 74:
                                                    this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                    continue;
                                                case 76:
                                                    Integer.toHexString(index);
                                                    a.get(index);
                                                    continue;
                                                case 77:
                                                    this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    Integer.toHexString(index);
                                                    a.get(index);
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr != null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
        }

        public void dump(MotionScene motionScene, StringBuilder sb) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                Integer num2 = num;
                                if (lookUpConstraintName != null) {
                                    num2 = lookUpConstraintName;
                                }
                                sb.append(num2);
                                sb.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f = (Float) obj;
                            if (f.floatValue() != -1.0f) {
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(f);
                                sb.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Motion {
        public static SparseIntArray a;
        public int mAnimateRelativeTo = -1;
        public boolean mApply = false;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPathMotionArc = -1;
        public float mPathRotate = Float.NaN;
        public String mTransitionEasing = null;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            a.append(R.styleable.Motion_pathMotionArc, 2);
            a.append(R.styleable.Motion_transitionEasing, 3);
            a.append(R.styleable.Motion_drawPath, 4);
            a.append(R.styleable.Motion_animate_relativeTo, 5);
            a.append(R.styleable.Motion_motionStagger, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i2 = this.mAnimateRelativeTo;
                        int i3 = ConstraintSet.UNSET;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i2);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.mAnimateRelativeTo = resourceId;
                        break;
                    case 6:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
        }
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public boolean mApply = false;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 0;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = i2;
                    int i3 = ConstraintSet.UNSET;
                    this.visibility = ConstraintSet.d[i2];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }
    }

    public static class Transform {
        public static SparseIntArray a;
        public boolean applyElevation = false;
        public float elevation = 0.0f;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            a.append(R.styleable.Transform_android_rotationX, 2);
            a.append(R.styleable.Transform_android_rotationY, 3);
            a.append(R.styleable.Transform_android_scaleX, 4);
            a.append(R.styleable.Transform_android_scaleY, 5);
            a.append(R.styleable.Transform_android_transformPivotX, 6);
            a.append(R.styleable.Transform_android_transformPivotY, 7);
            a.append(R.styleable.Transform_android_translationX, 8);
            a.append(R.styleable.Transform_android_translationY, 9);
            a.append(R.styleable.Transform_android_translationZ, 10);
            a.append(R.styleable.Transform_android_elevation, 11);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        e.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        e.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        e.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        e.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        e.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        e.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        e.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        e.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        e.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        e.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        e.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        e.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        e.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        e.append(R.styleable.Constraint_android_orientation, 27);
        e.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        e.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        e.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        e.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        e.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        e.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        e.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        e.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        e.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        e.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        e.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        e.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        e.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        e.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        e.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        e.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        e.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        e.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        e.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        e.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        e.append(R.styleable.Constraint_android_layout_marginRight, 28);
        e.append(R.styleable.Constraint_android_layout_marginStart, 31);
        e.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        e.append(R.styleable.Constraint_android_layout_marginTop, 34);
        e.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        e.append(R.styleable.Constraint_android_layout_width, 23);
        e.append(R.styleable.Constraint_android_layout_height, 21);
        e.append(R.styleable.Constraint_android_visibility, 22);
        e.append(R.styleable.Constraint_android_alpha, 43);
        e.append(R.styleable.Constraint_android_elevation, 44);
        e.append(R.styleable.Constraint_android_rotationX, 45);
        e.append(R.styleable.Constraint_android_rotationY, 46);
        e.append(R.styleable.Constraint_android_rotation, 60);
        e.append(R.styleable.Constraint_android_scaleX, 47);
        e.append(R.styleable.Constraint_android_scaleY, 48);
        e.append(R.styleable.Constraint_android_transformPivotX, 49);
        e.append(R.styleable.Constraint_android_transformPivotY, 50);
        e.append(R.styleable.Constraint_android_translationX, 51);
        e.append(R.styleable.Constraint_android_translationY, 52);
        e.append(R.styleable.Constraint_android_translationZ, 53);
        e.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        e.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        e.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        e.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        e.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        e.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        e.append(R.styleable.Constraint_layout_constraintCircle, 61);
        e.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        e.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        e.append(R.styleable.Constraint_animate_relativeTo, 64);
        e.append(R.styleable.Constraint_transitionEasing, 65);
        e.append(R.styleable.Constraint_drawPath, 66);
        e.append(R.styleable.Constraint_transitionPathRotate, 67);
        e.append(R.styleable.Constraint_motionStagger, 79);
        e.append(R.styleable.Constraint_android_id, 38);
        e.append(R.styleable.Constraint_motionProgress, 68);
        e.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        e.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        e.append(R.styleable.Constraint_chainUseRtl, 71);
        e.append(R.styleable.Constraint_barrierDirection, 72);
        e.append(R.styleable.Constraint_barrierMargin, 73);
        e.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        e.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        e.append(R.styleable.Constraint_pathMotionArc, 76);
        e.append(R.styleable.Constraint_layout_constraintTag, 77);
        e.append(R.styleable.Constraint_visibilityMode, 78);
        e.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        e.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    public final void a(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (this.a.containsKey(strArr[i])) {
                ConstraintAttribute constraintAttribute = this.a.get(strArr[i]);
                if (constraintAttribute.getType() != attributeType) {
                    StringBuilder L = a.L("ConstraintAttribute is already a ");
                    L.append(constraintAttribute.getType().name());
                    throw new IllegalArgumentException(L.toString());
                }
            } else {
                this.a.put(strArr[i], new ConstraintAttribute(strArr[i], attributeType));
            }
        }
    }

    public void addColorAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        connect(i, 1, i2, i2 == 0 ? 1 : 2, 0);
        connect(i, 2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        connect(i, 6, i2, i2 == 0 ? 6 : 7, 0);
        connect(i, 7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        connect(i, 3, i2, i2 == 0 ? 3 : 4, 0);
        connect(i, 4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                Debug.getName(childAt);
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.c.containsKey(Integer.valueOf(id))) {
                ConstraintAttribute.setAttributes(childAt, this.c.get(Integer.valueOf(id)).mCustomConstraints);
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        b(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id = constraintHelper.getId();
        if (this.c.containsKey(Integer.valueOf(id))) {
            Constraint constraint = this.c.get(Integer.valueOf(id));
            if (constraintWidget instanceof HelperWidget) {
                constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
            }
        }
    }

    public void applyToLayoutParams(int i, ConstraintLayout.LayoutParams layoutParams) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            this.c.get(Integer.valueOf(i)).applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        b(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void b(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                Debug.getName(childAt);
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && this.c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                Constraint constraint = this.c.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    constraint.layout.mHelperType = 1;
                }
                int i2 = constraint.layout.mHelperType;
                if (i2 != -1 && i2 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(constraint.layout.mBarrierDirection);
                    barrier.setMargin(constraint.layout.mBarrierMargin);
                    barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                    Layout layout = constraint.layout;
                    int[] iArr = layout.mReferenceIds;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str = layout.mReferenceIdString;
                        if (str != null) {
                            layout.mReferenceIds = c(barrier, str);
                            barrier.setReferencedIds(constraint.layout.mReferenceIds);
                        }
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.validate();
                constraint.applyTo(layoutParams);
                if (z) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
                childAt.setLayoutParams(layoutParams);
                PropertySet propertySet = constraint.propertySet;
                if (propertySet.mVisibilityMode == 0) {
                    childAt.setVisibility(propertySet.visibility);
                }
                childAt.setAlpha(constraint.propertySet.alpha);
                childAt.setRotation(constraint.transform.rotation);
                childAt.setRotationX(constraint.transform.rotationX);
                childAt.setRotationY(constraint.transform.rotationY);
                childAt.setScaleX(constraint.transform.scaleX);
                childAt.setScaleY(constraint.transform.scaleY);
                if (!Float.isNaN(constraint.transform.transformPivotX)) {
                    childAt.setPivotX(constraint.transform.transformPivotX);
                }
                if (!Float.isNaN(constraint.transform.transformPivotY)) {
                    childAt.setPivotY(constraint.transform.transformPivotY);
                }
                childAt.setTranslationX(constraint.transform.translationX);
                childAt.setTranslationY(constraint.transform.translationY);
                childAt.setTranslationZ(constraint.transform.translationZ);
                Transform transform = constraint.transform;
                if (transform.applyElevation) {
                    childAt.setElevation(transform.elevation);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.c.get(num);
            int i3 = constraint2.layout.mHelperType;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                Layout layout2 = constraint2.layout;
                int[] iArr2 = layout2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = layout2.mReferenceIdString;
                    if (str2 != null) {
                        layout2.mReferenceIds = c(barrier2, str2);
                        barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                    }
                }
                barrier2.setType(constraint2.layout.mBarrierDirection);
                barrier2.setMargin(constraint2.layout.mBarrierMargin);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (constraint2.layout.mIsGuideline) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public final int[] c(View view, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        if (i4 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i3 == 1 || i3 == 2) {
            connect(i, 1, i2, i3, i4);
            connect(i, 2, i5, i6, i7);
            this.c.get(Integer.valueOf(i)).layout.horizontalBias = f;
        } else if (i3 == 6 || i3 == 7) {
            connect(i, 6, i2, i3, i4);
            connect(i, 7, i5, i6, i7);
            this.c.get(Integer.valueOf(i)).layout.horizontalBias = f;
        } else {
            connect(i, 3, i2, i3, i4);
            connect(i, 4, i5, i6, i7);
            this.c.get(Integer.valueOf(i)).layout.verticalBias = f;
        }
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        this.c.get(Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        this.c.get(Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        this.c.get(Integer.valueOf(i)).layout.verticalBias = f;
    }

    public void clear(int i) {
        this.c.remove(Integer.valueOf(i));
    }

    public void clone(Context context, int i) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        if (!this.c.containsKey(Integer.valueOf(i))) {
            this.c.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.c.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                } else if (i4 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                } else {
                    StringBuilder L = a.L("Left to ");
                    L.append(h(i4));
                    L.append(" undefined");
                    throw new IllegalArgumentException(L.toString());
                }
                constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                } else if (i4 == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                } else {
                    StringBuilder L2 = a.L("right to ");
                    L2.append(h(i4));
                    L2.append(" undefined");
                    throw new IllegalArgumentException(L2.toString());
                }
                constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                } else if (i4 == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                } else {
                    StringBuilder L3 = a.L("right to ");
                    L3.append(h(i4));
                    L3.append(" undefined");
                    throw new IllegalArgumentException(L3.toString());
                }
                constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                } else if (i4 == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                } else {
                    StringBuilder L4 = a.L("right to ");
                    L4.append(h(i4));
                    L4.append(" undefined");
                    throw new IllegalArgumentException(L4.toString());
                }
                constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i3;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                StringBuilder L5 = a.L("right to ");
                L5.append(h(i4));
                L5.append(" undefined");
                throw new IllegalArgumentException(L5.toString());
            case 6:
                if (i4 == 6) {
                    Layout layout10 = constraint.layout;
                    layout10.startToStart = i3;
                    layout10.startToEnd = -1;
                } else if (i4 == 7) {
                    Layout layout11 = constraint.layout;
                    layout11.startToEnd = i3;
                    layout11.startToStart = -1;
                } else {
                    StringBuilder L6 = a.L("right to ");
                    L6.append(h(i4));
                    L6.append(" undefined");
                    throw new IllegalArgumentException(L6.toString());
                }
                constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    Layout layout12 = constraint.layout;
                    layout12.endToEnd = i3;
                    layout12.endToStart = -1;
                } else if (i4 == 6) {
                    Layout layout13 = constraint.layout;
                    layout13.endToStart = i3;
                    layout13.endToEnd = -1;
                } else {
                    StringBuilder L7 = a.L("right to ");
                    L7.append(h(i4));
                    L7.append(" undefined");
                    throw new IllegalArgumentException(L7.toString());
                }
                constraint.layout.endMargin = i5;
                return;
            default:
                throw new IllegalArgumentException(h(i2) + " to " + h(i4) + " unknown");
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        Layout layout = f(i).layout;
        layout.circleConstraint = i2;
        layout.circleRadius = i3;
        layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i, int i2) {
        f(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        f(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        f(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        f(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        f(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        f(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        f(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f) {
        f(i).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i, float f) {
        f(i).layout.widthPercent = f;
    }

    public void constrainWidth(int i, int i2) {
        f(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z) {
        f(i).layout.constrainedHeight = z;
    }

    public void constrainedWidth(int i, boolean z) {
        f(i).layout.constrainedWidth = z;
    }

    public void create(int i, int i2) {
        Layout layout = f(i).layout;
        layout.mIsGuideline = true;
        layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        Layout layout = f(i).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i2;
        layout.mBarrierMargin = i3;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        d(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        d(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr == null || fArr.length == iArr.length) {
            if (fArr != null) {
                f(iArr[0]).layout.verticalWeight = fArr[0];
            }
            f(iArr[0]).layout.verticalChainStyle = i5;
            connect(iArr[0], 3, i, i2, 0);
            for (int i6 = 1; i6 < iArr.length; i6++) {
                int i7 = iArr[i6];
                int i8 = i6 - 1;
                connect(iArr[i6], 3, iArr[i8], 4, 0);
                connect(iArr[i8], 4, iArr[i6], 3, 0);
                if (fArr != null) {
                    f(iArr[i6]).layout.verticalWeight = fArr[i6];
                }
            }
            connect(iArr[iArr.length - 1], 4, i3, i4, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public final void d(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr == null || fArr.length == iArr.length) {
            if (fArr != null) {
                f(iArr[0]).layout.horizontalWeight = fArr[0];
            }
            f(iArr[0]).layout.horizontalChainStyle = i5;
            connect(iArr[0], i6, i, i2, -1);
            for (int i8 = 1; i8 < iArr.length; i8++) {
                int i9 = iArr[i8];
                int i10 = i8 - 1;
                connect(iArr[i8], i6, iArr[i10], i7, -1);
                connect(iArr[i10], i7, iArr[i8], i6, -1);
                if (fArr != null) {
                    f(iArr[i8]).layout.horizontalWeight = fArr[i8];
                }
            }
            connect(iArr[iArr.length - 1], i7, i3, i4, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.c.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        Integer[] numArr = (Integer[]) hashSet.toArray(new Integer[0]);
        for (Integer num : numArr) {
            sb.append("<Constraint id=");
            sb.append(num);
            sb.append(" \n");
            this.c.get(num).layout.dump(motionScene, sb);
            sb.append("/>\n");
        }
        System.out.println(sb.toString());
    }

    public final Constraint e(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
        g(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public final Constraint f(int i) {
        if (!this.c.containsKey(Integer.valueOf(i))) {
            this.c.put(Integer.valueOf(i), new Constraint());
        }
        return this.c.get(Integer.valueOf(i));
    }

    public final void g(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (e.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    int resourceId = typedArray.getResourceId(index, layout.baselineToBaseline);
                    if (resourceId == -1) {
                        resourceId = typedArray.getInt(index, -1);
                    }
                    layout.baselineToBaseline = resourceId;
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    int resourceId2 = typedArray.getResourceId(index, layout3.bottomToBottom);
                    if (resourceId2 == -1) {
                        resourceId2 = typedArray.getInt(index, -1);
                    }
                    layout3.bottomToBottom = resourceId2;
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    int resourceId3 = typedArray.getResourceId(index, layout4.bottomToTop);
                    if (resourceId3 == -1) {
                        resourceId3 = typedArray.getInt(index, -1);
                    }
                    layout4.bottomToTop = resourceId3;
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = constraint.layout;
                    int resourceId4 = typedArray.getResourceId(index, layout8.endToEnd);
                    if (resourceId4 == -1) {
                        resourceId4 = typedArray.getInt(index, -1);
                    }
                    layout8.endToEnd = resourceId4;
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    int resourceId5 = typedArray.getResourceId(index, layout9.endToStart);
                    if (resourceId5 == -1) {
                        resourceId5 = typedArray.getInt(index, -1);
                    }
                    layout9.endToStart = resourceId5;
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = d[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    int resourceId6 = typedArray.getResourceId(index, layout23.leftToLeft);
                    if (resourceId6 == -1) {
                        resourceId6 = typedArray.getInt(index, -1);
                    }
                    layout23.leftToLeft = resourceId6;
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    int resourceId7 = typedArray.getResourceId(index, layout24.leftToRight);
                    if (resourceId7 == -1) {
                        resourceId7 = typedArray.getInt(index, -1);
                    }
                    layout24.leftToRight = resourceId7;
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    int resourceId8 = typedArray.getResourceId(index, layout27.rightToLeft);
                    if (resourceId8 == -1) {
                        resourceId8 = typedArray.getInt(index, -1);
                    }
                    layout27.rightToLeft = resourceId8;
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    int resourceId9 = typedArray.getResourceId(index, layout28.rightToRight);
                    if (resourceId9 == -1) {
                        resourceId9 = typedArray.getInt(index, -1);
                    }
                    layout28.rightToRight = resourceId9;
                    break;
                case 31:
                    Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = constraint.layout;
                    int resourceId10 = typedArray.getResourceId(index, layout30.startToEnd);
                    if (resourceId10 == -1) {
                        resourceId10 = typedArray.getInt(index, -1);
                    }
                    layout30.startToEnd = resourceId10;
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    int resourceId11 = typedArray.getResourceId(index, layout31.startToStart);
                    if (resourceId11 == -1) {
                        resourceId11 = typedArray.getInt(index, -1);
                    }
                    layout31.startToStart = resourceId11;
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    int resourceId12 = typedArray.getResourceId(index, layout33.topToBottom);
                    if (resourceId12 == -1) {
                        resourceId12 = typedArray.getInt(index, -1);
                    }
                    layout33.topToBottom = resourceId12;
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    int resourceId13 = typedArray.getResourceId(index, layout34.topToTop);
                    if (resourceId13 == -1) {
                        resourceId13 = typedArray.getInt(index, -1);
                    }
                    layout34.topToTop = resourceId13;
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.a = typedArray.getResourceId(index, constraint.a);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = constraint.layout;
                    int resourceId14 = typedArray.getResourceId(index, layout46.circleConstraint);
                    if (resourceId14 == -1) {
                        resourceId14 = typedArray.getInt(index, -1);
                    }
                    layout46.circleConstraint = resourceId14;
                    break;
                case 62:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = constraint.motion;
                    int resourceId15 = typedArray.getResourceId(index, motion.mAnimateRelativeTo);
                    if (resourceId15 == -1) {
                        resourceId15 = typedArray.getInt(index, -1);
                    }
                    motion.mAnimateRelativeTo = resourceId15;
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Integer.toHexString(index);
                    e.get(index);
                    break;
                default:
                    Integer.toHexString(index);
                    e.get(index);
                    break;
            }
        }
    }

    public boolean getApplyElevation(int i) {
        return f(i).transform.applyElevation;
    }

    public Constraint getConstraint(int i) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            return this.c.get(Integer.valueOf(i));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.a;
    }

    public int getHeight(int i) {
        return f(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.c.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i) {
        return f(i);
    }

    public int[] getReferencedIds(int i) {
        int[] iArr = f(i).layout.mReferenceIds;
        if (iArr == null) {
            return new int[0];
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i) {
        return f(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return f(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return f(i).layout.mWidth;
    }

    public final String h(int i) {
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

    public boolean isForceId() {
        return this.b;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint e2 = e(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        e2.layout.mIsGuideline = true;
                    }
                    this.c.put(Integer.valueOf(e2.a), e2);
                }
            }
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                String str2 = split[i];
            } else {
                String str3 = split2[0];
                int parseColor = Color.parseColor(split2[1]);
                Objects.requireNonNull(constraint);
                constraint.d(str3, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(parseColor);
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                String str2 = split[i];
            } else {
                String str3 = split2[0];
                float parseFloat = Float.parseFloat(split2[1]);
                Objects.requireNonNull(constraint);
                constraint.d(str3, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(parseFloat);
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                String str2 = split[i];
            } else {
                String str3 = split2[0];
                Objects.requireNonNull(constraint);
                constraint.d(str3, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue((float) Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == ',' && !z) {
                arrayList.add(new String(charArray, i, i2 - i));
                i = i2 + 1;
            } else if (charArray[i2] == '\"') {
                z = !z;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String[] split = strArr[i3].split("=");
            String str2 = strArr[i3];
            String str3 = split[0];
            String str4 = split[1];
            Objects.requireNonNull(constraint);
            constraint.d(str3, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str4);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.c.keySet()) {
            int intValue = num.intValue();
            Constraint constraint = constraintSet.c.get(num);
            if (!this.c.containsKey(Integer.valueOf(intValue))) {
                this.c.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.c.get(Integer.valueOf(intValue));
            Layout layout = constraint2.layout;
            if (!layout.mApply) {
                layout.copyFrom(constraint.layout);
            }
            PropertySet propertySet = constraint2.propertySet;
            if (!propertySet.mApply) {
                propertySet.copyFrom(constraint.propertySet);
            }
            Transform transform = constraint2.transform;
            if (!transform.mApply) {
                transform.copyFrom(constraint.transform);
            }
            Motion motion = constraint2.motion;
            if (!motion.mApply) {
                motion.copyFrom(constraint.motion);
            }
            for (String str : constraint.mCustomConstraints.keySet()) {
                if (!constraint2.mCustomConstraints.containsKey(str)) {
                    constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.a.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            Layout layout = this.c.get(Integer.valueOf(i)).layout;
            int i2 = layout.leftToRight;
            int i3 = layout.rightToLeft;
            if (i2 == -1 && i3 == -1) {
                int i4 = layout.startToEnd;
                int i5 = layout.endToStart;
                if (!(i4 == -1 && i5 == -1)) {
                    if (i4 != -1 && i5 != -1) {
                        connect(i4, 7, i5, 6, 0);
                        connect(i5, 6, i2, 7, 0);
                    } else if (!(i2 == -1 && i5 == -1)) {
                        int i6 = layout.rightToRight;
                        if (i6 != -1) {
                            connect(i2, 7, i6, 7, 0);
                        } else {
                            int i7 = layout.leftToLeft;
                            if (i7 != -1) {
                                connect(i5, 6, i7, 6, 0);
                            }
                        }
                    }
                }
                clear(i, 6);
                clear(i, 7);
                return;
            }
            if (i2 != -1 && i3 != -1) {
                connect(i2, 2, i3, 1, 0);
                connect(i3, 1, i2, 2, 0);
            } else if (!(i2 == -1 && i3 == -1)) {
                int i8 = layout.rightToRight;
                if (i8 != -1) {
                    connect(i2, 2, i8, 2, 0);
                } else {
                    int i9 = layout.leftToLeft;
                    if (i9 != -1) {
                        connect(i3, 1, i9, 1, 0);
                    }
                }
            }
            clear(i, 1);
            clear(i, 2);
        }
    }

    public void removeFromVerticalChain(int i) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            Layout layout = this.c.get(Integer.valueOf(i)).layout;
            int i2 = layout.topToBottom;
            int i3 = layout.bottomToTop;
            if (!(i2 == -1 && i3 == -1)) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                } else if (!(i2 == -1 && i3 == -1)) {
                    int i4 = layout.bottomToBottom;
                    if (i4 != -1) {
                        connect(i2, 4, i4, 4, 0);
                    } else {
                        int i5 = layout.topToTop;
                        if (i5 != -1) {
                            connect(i3, 3, i5, 3, 0);
                        }
                    }
                }
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f) {
        f(i).propertySet.alpha = f;
    }

    public void setApplyElevation(int i, boolean z) {
        f(i).transform.applyElevation = z;
    }

    public void setBarrierType(int i, int i2) {
        f(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, String str, int i2) {
        Constraint f = f(i);
        Objects.requireNonNull(f);
        f.d(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i2);
    }

    public void setDimensionRatio(int i, String str) {
        f(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        f(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        f(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f) {
        f(i).transform.elevation = f;
        f(i).transform.applyElevation = true;
    }

    public void setFloatValue(int i, String str, float f) {
        Constraint.a(f(i), str, f);
    }

    public void setForceId(boolean z) {
        this.b = z;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        Constraint f = f(i);
        switch (i2) {
            case 1:
                f.layout.goneLeftMargin = i3;
                return;
            case 2:
                f.layout.goneRightMargin = i3;
                return;
            case 3:
                f.layout.goneTopMargin = i3;
                return;
            case 4:
                f.layout.goneBottomMargin = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                f.layout.goneStartMargin = i3;
                return;
            case 7:
                f.layout.goneEndMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        f(i).layout.guideBegin = i2;
        f(i).layout.guideEnd = -1;
        f(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        f(i).layout.guideEnd = i2;
        f(i).layout.guideBegin = -1;
        f(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f) {
        f(i).layout.guidePercent = f;
        f(i).layout.guideEnd = -1;
        f(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f) {
        f(i).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        f(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f) {
        f(i).layout.horizontalWeight = f;
    }

    public void setIntValue(int i, String str, int i2) {
        Constraint f = f(i);
        Objects.requireNonNull(f);
        f.d(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i2);
    }

    public void setMargin(int i, int i2, int i3) {
        Constraint f = f(i);
        switch (i2) {
            case 1:
                f.layout.leftMargin = i3;
                return;
            case 2:
                f.layout.rightMargin = i3;
                return;
            case 3:
                f.layout.topMargin = i3;
                return;
            case 4:
                f.layout.bottomMargin = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                f.layout.startMargin = i3;
                return;
            case 7:
                f.layout.endMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        f(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f) {
        f(i).transform.rotation = f;
    }

    public void setRotationX(int i, float f) {
        f(i).transform.rotationX = f;
    }

    public void setRotationY(int i, float f) {
        f(i).transform.rotationY = f;
    }

    public void setScaleX(int i, float f) {
        f(i).transform.scaleX = f;
    }

    public void setScaleY(int i, float f) {
        f(i).transform.scaleY = f;
    }

    public void setStringValue(int i, String str, String str2) {
        Constraint f = f(i);
        Objects.requireNonNull(f);
        f.d(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
    }

    public void setTransformPivot(int i, float f, float f2) {
        Transform transform = f(i).transform;
        transform.transformPivotY = f2;
        transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i, float f) {
        f(i).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i, float f) {
        f(i).transform.transformPivotY = f;
    }

    public void setTranslation(int i, float f, float f2) {
        Transform transform = f(i).transform;
        transform.translationX = f;
        transform.translationY = f2;
    }

    public void setTranslationX(int i, float f) {
        f(i).transform.translationX = f;
    }

    public void setTranslationY(int i, float f) {
        f(i).transform.translationY = f;
    }

    public void setTranslationZ(int i, float f) {
        f(i).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean z) {
    }

    public void setVerticalBias(int i, float f) {
        f(i).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i, int i2) {
        f(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f) {
        f(i).layout.verticalWeight = f;
    }

    public void setVisibility(int i, int i2) {
        f(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        f(i).propertySet.mVisibilityMode = i2;
    }

    public void clear(int i, int i2) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.c.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = -1;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = -1;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = -1;
                    layout3.goneTopMargin = -1;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = -1;
                    layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.startToEnd = -1;
                    layout5.startToStart = -1;
                    layout5.startMargin = -1;
                    layout5.goneStartMargin = -1;
                    return;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.endToStart = -1;
                    layout6.endToEnd = -1;
                    layout6.endMargin = -1;
                    layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.c.clear();
        for (Integer num : constraintSet.c.keySet()) {
            this.c.put(num, constraintSet.c.get(num).clone());
        }
    }

    public void centerHorizontally(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, i2, 7, 0, i2, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, i2, 4, 0, i2, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.b || id != -1) {
                if (!this.c.containsKey(Integer.valueOf(id))) {
                    this.c.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.c.get(Integer.valueOf(id));
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.a, childAt);
                constraint.b(id, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                    Transform transform = constraint.transform;
                    transform.transformPivotX = pivotX;
                    transform.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                Transform transform2 = constraint.transform;
                if (transform2.applyElevation) {
                    transform2.elevation = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
        if (r0.equals("PropertySet") != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0179, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.b || id != -1) {
                if (!this.c.containsKey(Integer.valueOf(id))) {
                    this.c.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.c.get(Integer.valueOf(id));
                if (!constraint.layout.mApply) {
                    constraint.b(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                Transform transform = constraint.transform;
                if (!transform.mApply) {
                    transform.mApply = true;
                    transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform2 = constraint.transform;
                        transform2.transformPivotX = pivotX;
                        transform2.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform3 = constraint.transform;
                    if (transform3.applyElevation) {
                        transform3.elevation = childAt.getElevation();
                    }
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.b || id != -1) {
                if (!this.c.containsKey(Integer.valueOf(id))) {
                    this.c.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.c.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                    constraint.c(id, layoutParams);
                    if (constraintHelper instanceof Barrier) {
                        Layout layout = constraint.layout;
                        layout.mHelperType = 1;
                        Barrier barrier = (Barrier) constraintHelper;
                        layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mReferenceIds = barrier.getReferencedIds();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                constraint.c(id, layoutParams);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        if (!this.c.containsKey(Integer.valueOf(i))) {
            this.c.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.c.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                    return;
                } else if (i4 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    StringBuilder L = a.L("left to ");
                    L.append(h(i4));
                    L.append(" undefined");
                    throw new IllegalArgumentException(L.toString());
                }
            case 2:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                    return;
                } else if (i4 == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                    return;
                } else {
                    StringBuilder L2 = a.L("right to ");
                    L2.append(h(i4));
                    L2.append(" undefined");
                    throw new IllegalArgumentException(L2.toString());
                }
            case 3:
                if (i4 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    return;
                } else if (i4 == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    return;
                } else {
                    StringBuilder L3 = a.L("right to ");
                    L3.append(h(i4));
                    L3.append(" undefined");
                    throw new IllegalArgumentException(L3.toString());
                }
            case 4:
                if (i4 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    return;
                } else if (i4 == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    return;
                } else {
                    StringBuilder L4 = a.L("right to ");
                    L4.append(h(i4));
                    L4.append(" undefined");
                    throw new IllegalArgumentException(L4.toString());
                }
            case 5:
                if (i4 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i3;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                StringBuilder L5 = a.L("right to ");
                L5.append(h(i4));
                L5.append(" undefined");
                throw new IllegalArgumentException(L5.toString());
            case 6:
                if (i4 == 6) {
                    Layout layout10 = constraint.layout;
                    layout10.startToStart = i3;
                    layout10.startToEnd = -1;
                    return;
                } else if (i4 == 7) {
                    Layout layout11 = constraint.layout;
                    layout11.startToEnd = i3;
                    layout11.startToStart = -1;
                    return;
                } else {
                    StringBuilder L6 = a.L("right to ");
                    L6.append(h(i4));
                    L6.append(" undefined");
                    throw new IllegalArgumentException(L6.toString());
                }
            case 7:
                if (i4 == 7) {
                    Layout layout12 = constraint.layout;
                    layout12.endToEnd = i3;
                    layout12.endToStart = -1;
                    return;
                } else if (i4 == 6) {
                    Layout layout13 = constraint.layout;
                    layout13.endToStart = i3;
                    layout13.endToEnd = -1;
                    return;
                } else {
                    StringBuilder L7 = a.L("right to ");
                    L7.append(h(i4));
                    L7.append(" undefined");
                    throw new IllegalArgumentException(L7.toString());
                }
            default:
                throw new IllegalArgumentException(h(i2) + " to " + h(i4) + " unknown");
        }
    }
}
