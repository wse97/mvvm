package com.ugb.mvvmproject.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import com.google.android.material.snackbar.Snackbar;
import com.ugb.mvvmproject.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static Dialog dialog;

    public static void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /*
     * Purpose: check if edit text is empty or not
     * and show error messege if it's empty
     * @param editTexts editText or multi editTexts which is want to check
     * @return boolean is empty or not
     */
    public static boolean isEditTextsEmpty(TextView... editTexts) {
        for (TextView editText : editTexts) {
            if (editText.getText().toString().trim().isEmpty()) {
                editText.requestFocus();
                editText.setError("تأكد من البيانات");
                return true;
            }
        }
        return false;
    }

    public static Typeface getTypeFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/DIN Next LT W23 Regular.ttf");

    }

    public static String getRelative(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date past = format.parse(date);
        Date now = new Date();
        long sec, min, hour, day;
        sec = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
        min = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
        hour = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
        day = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());
        if (sec < 60) {
            if (sec < 3 || sec > 10) {
                return Long.toString(TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime())) + " ثانية";
            } else {
                return Long.toString(TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime())) + " ثواني";
            }
        } else if (sec > 60 && sec < 3600) {
            if (min < 3 || min > 10) {
                return Long.toString(TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime())) + " دقائق";
            } else {
                return Long.toString(TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime())) + " دقيقة";
            }
        } else if (sec > 3600 && sec < 86400) {
            if (hour < 3 || hour > 10) {
                return Long.toString(TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime())) + " ساعات";
            } else {
                return Long.toString(TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime())) + " ساعة";
            }
        } else {
            if (day < 3 || day > 10) {
                return Long.toString(TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime())) + " يوم";
            } else {
                return Long.toString(TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime())) + " أيام";
            }
        }
    }

    public static boolean isTextViewEmpty(String checkText, TextView textView) {
        if (textView.getText().toString().equals(checkText)) {
            textView.requestFocus();
            textView.setError("خانه مطلوبة");
            return true;
        }
        return false;
    }

    public static boolean isMultiSelectedTextViewEmpty(List<?> checkText, TextView textView) {
        if (checkText.size() == 0) {
            textView.requestFocus();
            textView.setError("خانه مطلوبة");
            return true;
        }
        return false;
    }

    public static boolean isEmptySpinner(Spinner spinner, String spinnerName) {
        if (spinner.getSelectedItem().equals(spinnerName) || spinner.getSelectedItem().equals("")) {
            TextView errorText = (TextView) spinner.getSelectedView();
            errorText.setError("اختار" + spinnerName);
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            return true;
        }
        return false;
    }

    public static String convertArabicNumber(String phone) {
        String temp = phone;
        for (int i = 0; i < phone.length(); i++) {
            switch (phone.charAt(i)) {
                case '٠':
                    phone = temp.replace(phone.charAt(i), '0');
                    break;
                case '١':
                    phone = temp.replace(phone.charAt(i), '1');
                    break;
                case '٢':
                    phone = temp.replace(phone.charAt(i), '2');
                    break;
                case '٣':
                    phone = temp.replace(phone.charAt(i), '3');
                    break;
                case '٤':
                    phone = temp.replace(phone.charAt(i), '4');
                    break;
                case '٥':
                    phone = temp.replace(phone.charAt(i), '5');
                    break;
                case '٦':
                    phone = temp.replace(phone.charAt(i), '6');
                    break;
                case '٧':
                    phone = temp.replace(phone.charAt(i), '7');
                    break;
                case '٨':
                    phone = temp.replace(phone.charAt(i), '8');
                    break;
                case '٩':
                    phone = temp.replace(phone.charAt(i), '9');
                    break;
                default:
                    continue;

            }
        }
        return phone;
    }

    public static String dismalFormat(String number) {
        return new DecimalFormat("##.##").format(Double.parseDouble(number));
    }

    public static String dismalFormatAndToEN(String number) {
        return arabicToDecimal(dismalFormat(number));
    }

    public static String arabicToDecimal(String num) {
        String temp = "";
        temp = num.replaceAll("٠", "0");
        temp = temp.replaceAll("١", "1");
        temp = temp.replaceAll("٢", "2");
        temp = temp.replaceAll("٣", "3");
        temp = temp.replaceAll("٤", "4");
        temp = temp.replaceAll("٥", "5");
        temp = temp.replaceAll("٦", "6");
        temp = temp.replaceAll("٧", "7");
        temp = temp.replaceAll("٨", "8");
        temp = temp.replaceAll("٩", "9");
        temp = temp.replaceAll("٫", ".");
        return temp;
    }

    public static boolean isCheckedDays(Activity context, CheckBox... checkBoxes) {
        int unchecked = 0;
        for (CheckBox checkBox : checkBoxes) {
            if (!checkBox.isChecked()) {
                unchecked += 1;
            }
        }
        if (unchecked == checkBoxes.length) {
            Toast.makeText(context, "Please Check at least 1 available day", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public static boolean isEmptySpinner(Spinner city) {
        if (city.getSelectedItem().equals("Select City") || city.getSelectedItem().equals("")) {
            TextView errorText = (TextView) city.getSelectedView();
            errorText.setError("اختار المدينه");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            return true;
        }
        return false;
    }


    public static boolean isChecked(CheckBox accept) {
        if (!accept.isChecked()) {
            accept.requestFocus();
            accept.setError("please accept terms and condition");
            return false;
        }
        return true;
    }

    public static boolean isEmptyDate(TextView... dates) {
        for (TextView date : dates) {
            if (date.getText().equals("Date Of Birth") || date.getText().equals("Start Date") || date.getText().equals("End Date") || date.getText().equals("Start Time") || date.getText().equals("End Time")) {
                date.requestFocus();
                date.setError("تاكد من البيانات");
                return true;
            }
        }
        return false;

    }

    public static boolean isEditTextNotEmpty(EditText eText, Context context) {

        if (!eText.getText().toString().isEmpty()) {
            return true;
        }
        eText.setError(context.getResources().getString(R.string.requiredField));
        return false;

    }

    /*
     * Purpose: check if confirm password is carbon copy of password
     * and show error message if it isn't
     * @param editText1 is the password
     * @param editText2 is the confirm password
     * @return boolean is empty or not
     */
    public static boolean isCarbonCopy(EditText editText1, EditText editText2, String s) {
        if (!editText2.getText().toString().equals(editText1.getText().toString())) {
            editText2.requestFocus();
            editText2.setError("");
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(EditText password) {
        String passwordPattern = "((?=.*[A-Za-z]).(?=.*[A-Za-z0-9@#$%_])(?=\\S+$).{3,})";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password.getText().toString());
        if (matcher.matches()) {
            return true;
        }
        password.requestFocus();
        password.setError("كلمة المرور غير صالحة");
        return false;
    }

    public static boolean isValidEmail(EditText email, Context context) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email.getText().toString().trim();

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (inputStr.length() >= 6 && matcher.matches()) {
            return true;
        }
        email.requestFocus();
        email.setError(context.getResources().getString(R.string.invalidEmail));
        return false;
    }

    public static boolean isValidPhone(EditText phone, Context context) {
        String inputStr = phone.getText().toString().trim();
        if (inputStr.length() >= 9 && inputStr.length() <= 11){
            return true;
        }
        phone.requestFocus();
        phone.setError(context.getResources().getString(R.string.invalidPhone));
        return false;


    }


    public static void showSnackbar(Activity activity, @StringRes int id, @ColorRes int colorId) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), id, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(activity.getResources().getColor(colorId));
        snackbar.show();
    }

    public static void showSnackbar(Activity activity, @StringRes int id) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), id, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public static void showSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public static void clearEditText(EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setText("");
        }
    }

    public static String getTextViewText(TextView text) {
        return text.getText().toString();
    }

    public static String getEditText(EditText text) {
        return text.getText().toString();
    }

    public static boolean comfirmPassword(EditText password, EditText passwordConfirmation, Context context) {
        if (password.getText().toString().equals(passwordConfirmation.getText().toString())) {
            return true;
        }
        passwordConfirmation.setError(context.getResources().getString(R.string.passwordsDoNotMatch));

        return false;
    }

    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return Character.DIRECTIONALITY_RIGHT_TO_LEFT == directionality || Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC == directionality;
    }

    /* Read and write objects. */
    public static void writeObject(Context context, Serializable object, String filename) {
        ObjectOutputStream objectOut = null;
        try {
            FileOutputStream fileOut = context.openFileOutput(filename, Activity.MODE_PRIVATE);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != objectOut) {
                try {
                    objectOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T> T readObject(Context context, String filename) {
        ObjectInputStream objectIn = null;
        Object object = null;
        try {
            FileInputStream fileIn = context.getApplicationContext().openFileInput(filename);
            objectIn = new ObjectInputStream(fileIn);
            object = objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != objectIn) {
                try {
                    objectIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            return (T) object;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean icCheckedArabicCharacters(EditText text) {
        if (text.length() != 0) {
            String value = text.getText().toString();
            if (value.contains("أ") || value.contains("ا") || value.contains("ب") ||
                    value.contains("ت") || value.contains("ض") || value.contains("ص") || value.contains("ق") || value.contains("ث")
                    || value.contains("ه") || value.contains("ع") || value.contains("غ") || value.contains("ف")
                    || value.contains("خ") || value.contains("ح") || value.contains("ج") || value.contains("د")
                    || value.contains("ن") || value.contains("م") || value.contains("ك") || value.contains("ط")
                    || value.contains("اَ") || value.contains("اً") || value.contains("اُ")
                    || value.contains("س") || value.contains("ي") || value.contains("ل")
                    || value.contains("ش") || value.contains("ئ") || value.contains("ء") || value.contains("ؤ")
                    || value.contains("ر") || value.contains("لا") || value.contains("لآ") || value.contains("ى")
                    || value.contains("ظ") || value.contains("ز") || value.contains("و") || value.equals("ة")
                    || value.contains("ذ") || value.contains("ّ") || value.contains("َ") || value.contains("ً")
                    || value.contains("ٌ") || value.contains("ِ") || value.contains("ٍ") || value.contains("ْ")
                    || value.contains("~") || value.contains("،")) {
                text.setError("كلمة المرور غير صالحة لا يسمح باستخدام الاحرف والارقام العربية");
                return false;
            }
        }

        return true;
    }

    public static void showDialog(Context context) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_progres);
        dialog.show();
    }

    public static void cancelDialog() {
        if (dialog != null) {
            dialog.cancel();
        }
    }

}















