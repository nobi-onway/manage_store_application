package com.example.manage_store_application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private static final int PAYPAL_REQUEST_CODE = 123;
    private static final String PAYPAL_CLIENT_ID = "AR5gFuCsfjxgVTvA0esV_SzFeZaEsfeFGnshjbXL77RTVhl85ZPunBKuiN1gv6TQltXw-qrXNhDmz5Mj";
    private static final String PAYPAL_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
    private PayPalConfiguration paypalConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paypalConfig = new PayPalConfiguration()
                .environment(PAYPAL_ENVIRONMENT)
                .clientId(PAYPAL_CLIENT_ID);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        startService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startPayPalPayment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    String paymentId = confirmation.getProofOfPayment().getPaymentId();
                    // Process the payment and handle success
                }
            } else if (resultCode == RESULT_CANCELED) {
                // Handle payment cancellation
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                // Handle invalid payment
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void startPayPalPayment() {
        PayPalPayment payment = new PayPalPayment(new BigDecimal("10"), "USD", "Payment Description",
                PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }
}