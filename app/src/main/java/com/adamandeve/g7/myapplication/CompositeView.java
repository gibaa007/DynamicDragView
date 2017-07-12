package com.adamandeve.g7.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class provides a custom view for the heterogenous layout used through
 * the application. It has an icon, a text and a custom background. Text and
 * image places can be changed two ways. </p> 1- An image at the top text at the
 * bottom </p> 2- An image on the left text on the right </p>
 *
 * @author candemir.doger
 */
public class CompositeView extends FrameLayout {

    private ImageView imageView;
    private TextView textView;

    public CompositeView(Context context, TileModel tileModel) {
        super(context);
        imageView = new ImageView(context);
        textView = new TextView(context);
        textView.setTextColor(getResources().getColor(android.R.color.white));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        textView.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        textView.setText(tileModel.getTitle());
        textView.setPadding(5, 0, 0, 0);
        this.setPadding(20, 20, 20, 20);
        this.setClickable(true);
        this.addView(imageView);
        this.addView(textView);
        this.setIcon(tileModel.getImage());
        this.setId(tileModel.getId());
        this.setBackgroundColor(Color.parseColor(tileModel.getColor()));
        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(tileModel.getWidth(), tileModel.getHeight());
        params.setMargins(tileModel.getMarginLeft(), tileModel.getMarginTop(), tileModel.getMarginRight(), tileModel.getMarginBottom());
        this.setLayoutParams(params);
    }

    public String getText() {
        return textView.getText().toString();
    }

    public void setText(CharSequence text) {
        textView.setText(text);
    }

    public void setBackgroundColorHex(String text) {
        this.setBackgroundColor(Color.parseColor(text));
    }

    public void setIcon(int resid) {
        imageView.setImageDrawable(getResources().getDrawable(resid));
    }
}
