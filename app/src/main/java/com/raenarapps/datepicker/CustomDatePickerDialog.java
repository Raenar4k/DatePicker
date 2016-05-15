package com.raenarapps.datepicker;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

public class CustomDatePickerDialog {
    AlertDialog dialog;
    private final DatePicker datePicker;


    protected CustomDatePickerDialog(Context context,
                                     final DatePickerDialog.OnDateSetListener listener,
                                     int year,
                                     int monthOfYear,
                                     final int dayOfMonth) {

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog, null);
        datePicker = (DatePicker) dialogView.findViewById(R.id.datePicker);
        datePicker.updateDate(year, monthOfYear, dayOfMonth);

        dialog = new AlertDialog.Builder(context)
                .setView(dialogView)
                .setNegativeButton(context.getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(context.getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(),
                                datePicker.getDayOfMonth());
                    }
                })
                .create();

    }

    public void show() {
        dialog.show();
    }
}
