package imgur.brishko.util;

import android.content.Context;
import android.content.res.TypedArray;
import imgur.brishko.R;

import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import imgur.brishko.fundamentals.ImgurApp;
import imgur.brishko.fundamentals.ImgurConstants;

public class TypeFacedTextView extends TextView{

    public TypeFacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray styledAttr = ImgurApp.getContext().obtainStyledAttributes(attrs, R.styleable.TypeFacedTextView);
        String fontName = styledAttr.getString(R.styleable.TypeFacedTextView_typeface);
        styledAttr.recycle();

        if(fontName!=null){
            Typeface typeface = Typeface.createFromAsset(ImgurApp.getContext().getAssets(),fontName);
            setTypeface(typeface);
        }
    }

    @Override
    public boolean isInEditMode() {
        return true;
    }

    public static void AddRobotoFont(TextView textView){
        Typeface typeface = Typeface.createFromAsset(ImgurApp.getContext().getAssets(), ImgurConstants.ROBOTO_THIN);
        textView.setTypeface(typeface);
    }

}
