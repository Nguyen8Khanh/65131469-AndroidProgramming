package ntmkhanh.edu.thigk2nguyenthimykhanh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtAmountVND;
    private EditText edtExchangeRate;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        edtAmountVND = findViewById(R.id.edtAmountVND);
        edtExchangeRate = findViewById(R.id.edtExchangeRate);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        // Xử lý sự kiện click button
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String amountVNDStr = edtAmountVND.getText().toString().trim();
        String exchangeRateStr = edtExchangeRate.getText().toString().trim();

        // Kiểm tra dữ liệu nhập
        if (amountVNDStr.isEmpty() || exchangeRateStr.isEmpty()) {
            tvResult.setText("Vui lòng nhập đầy đủ số tiền và tỉ giá");
            return;
        }

        try {
            double amountVND = Double.parseDouble(amountVNDStr);
            double exchangeRate = Double.parseDouble(exchangeRateStr);

            if (exchangeRate <= 0) {
                tvResult.setText("Tỉ giá phải lớn hơn 0");
                return;
            }

            double amountUSD = amountVND / exchangeRate;
            String result = String.format("Kết quả: %.2f USD", amountUSD);
            tvResult.setText(result);

        } catch (NumberFormatException e) {
            tvResult.setText("Vui lòng nhập số hợp lệ");
        }
    }
}