package de.azzoft.smstest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DatePicker extends LinearLayout {

    @Bind(R.id.firstSpinner)
    Spinner firstSpinner;

    @Bind(R.id.secondSpinner)
    Spinner secondSpinner;

    @Bind(R.id.thirdSpinner)
    Spinner thirdSpinner;

    public DatePicker(Context context) {
        super(context);
        init(context);
    }

    public DatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View root = layoutInflater.inflate(R.layout.date_picker, this, true);
        ButterKnife.bind(this, root);

        firstSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, getTimeRangeList(20)));
        secondSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, getTimeRangeList(60)));
        thirdSpinner.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, getTimeRangeList(120)));
    }

    /**
     * Get either minutes or hours as list.
     *
     * @param to count to
     * @return List of type string
     */
    private List<String> getTimeRangeList(int to) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < to; i++) {
            if (i < 10) {
                list.add("0" + i);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}