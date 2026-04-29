package com.yarr.finance;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AddTransactionActivity extends AppCompatActivity {
    
    private Spinner spCategory, spPayment;
    private View layoutTransferInfo;
    private Button btnDate, btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        spCategory = findViewById(R.id.sp_category);
        spPayment = findViewById(R.id.sp_payment);
        layoutTransferInfo = findViewById(R.id.layout_transfer_info);
        btnDate = findViewById(R.id.btn_date);
        btnTime = findViewById(R.id.btn_time);
        RadioGroup rgType = findViewById(R.id.rg_type);

        updateSpinners(R.id.rb_income); // Default

        rgType.setOnCheckedChangeListener((group, checkedId) -> {
            updateSpinners(checkedId);
            if (checkedId == R.id.rb_transfer) {
                layoutTransferInfo.setVisibility(View.VISIBLE);
            } else {
                layoutTransferInfo.setVisibility(View.GONE);
            }
        });

        btnDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, dayOfMonth) -> 
                btnDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year),
                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });

        btnTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new TimePickerDialog(this, (view, hourOfDay, minute) -> 
                btnTime.setText(String.format("%02d:%02d", hourOfDay, minute)),
                c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
        });

        findViewById(R.id.btn_save).setOnClickListener(v -> {
            Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void updateSpinners(int checkedId) {
        int catArrayRes;
        int payArrayRes = R.array.payment_methods;

        if (checkedId == R.id.rb_income) {
            catArrayRes = R.array.categories_income;
        } else if (checkedId == R.id.rb_transfer) {
            catArrayRes = R.array.categories_transfer;
            payArrayRes = R.array.transfer_methods; // Only Bank/E-Wallet for transfer
        } else {
            catArrayRes = R.array.categories_expense;
        }

        // Update Category Spinner
        ArrayAdapter<CharSequence> catAdapter = ArrayAdapter.createFromResource(this,
                catArrayRes, android.R.layout.simple_spinner_item);
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(catAdapter);

        // Update Payment Spinner
        ArrayAdapter<CharSequence> payAdapter = ArrayAdapter.createFromResource(this,
                payArrayRes, android.R.layout.simple_spinner_item);
        payAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPayment.setAdapter(payAdapter);
    }
}