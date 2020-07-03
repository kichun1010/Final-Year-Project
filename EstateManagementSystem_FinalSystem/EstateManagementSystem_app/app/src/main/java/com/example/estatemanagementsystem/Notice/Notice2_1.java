package com.example.estatemanagementsystem.Notice;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.ImageView;

        import com.example.estatemanagementsystem.R;

public class Notice2_1 extends AppCompatActivity {
    ImageView imageView;
    int [] images = {R.drawable.notice3,R.drawable.notice4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice2_1);

        imageView = (ImageView) findViewById(R.id.imageView);

        String Tempholder = getIntent().getStringExtra("List");
        imageView.setImageResource(images[Integer.parseInt(Tempholder)]);
    }
}
