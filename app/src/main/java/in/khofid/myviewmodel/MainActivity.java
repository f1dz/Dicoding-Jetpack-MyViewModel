package in.khofid.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtWidth, edtHeight, edtLength;
    private TextView tvResult;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        tvResult = findViewById(R.id.tv_result);

        displayResult();

        findViewById(R.id.btn_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String width = edtWidth.getText().toString();
                String height = edtHeight.getText().toString();
                String length = edtLength.getText().toString();

                if (width.isEmpty()) {
                    edtWidth.setError("Masih kosong");
                } else if (height.isEmpty()) {
                    edtHeight.setError("Masih kosong");
                } else if (length.isEmpty()) {
                    edtLength.setError("Masih kosong");
                } else {
                    viewModel.calculate(width, height, length);
                    displayResult();
                }
            }
        });
    }

    private void displayResult(){
        tvResult.setText(String.valueOf(viewModel.result));
    }
}
