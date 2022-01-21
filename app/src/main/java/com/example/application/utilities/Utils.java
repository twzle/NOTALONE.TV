package com.example.application.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static long getUnixTime(){
        return System.currentTimeMillis() / 1000;
    }

    public static long getGuestId(){
        int random = ThreadLocalRandom.current().nextInt(10000, 99999);
        long time = getUnixTime();
        long result = Long.valueOf(Integer.toString(random) + Long.toString(time));
        return result;
    }

    public static String checkLinkEntry(String entry, String link) {
        String result;
        if (!link.contains(entry)) {
            result = entry.concat(link);
        }
        else {
            result = link;
        }
        return result;
    }
}
