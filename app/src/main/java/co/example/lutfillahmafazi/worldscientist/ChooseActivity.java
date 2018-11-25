package co.example.lutfillahmafazi.worldscientist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseActivity extends AppCompatActivity {

    @BindView(R.id.btnPenemuTerhebat)
    Button btnPenemuTerhebat;
    @BindView(R.id.btnPenemuTeknologi)
    Button btnPenemuTeknologi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnPenemuTerhebat, R.id.btnPenemuTeknologi})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnPenemuTerhebat:
                intent = new Intent(this, RecycleView.class);
                intent.putExtra("penemu","dunia");
                startActivity(intent);
                break;
            case R.id.btnPenemuTeknologi:
                intent = new Intent(this,RecycleView.class);
                intent.putExtra("penemu","teknologi");
                startActivity(intent);
                break;
        }
    }
}
