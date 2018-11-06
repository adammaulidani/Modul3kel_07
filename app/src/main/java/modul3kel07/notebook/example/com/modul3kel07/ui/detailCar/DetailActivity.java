package modul3kel07.notebook.example.com.modul3kel07.ui.detailCar;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import modul3kel07.notebook.example.com.modul3kel07.R;
import modul3kel07.notebook.example.com.modul3kel07.data.model.DataCar;
import modul3kel07.notebook.example.com.modul3kel07.utility.Constant;

public class DetailActivity extends AppCompatActivity implements DetailView {
    private DataCar dataCar;
    private DetailPresenter detailPresenter;
    private TextView tvNama;
    private RelativeLayout relativeLayout;
    private AnimationDrawable animationDrawable;
    private TextView tvMerk;
    private TextView tvModel;
    private TextView tvTahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initIntentData();
        initPresenter();
        initData();
        dynamic();
    }

    private void dynamic() {
        relativeLayout = (RelativeLayout) findViewById(R.id.detail_id);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
    }

    private void initView() {
        tvNama = findViewById(R.id.tvTampil_nama);
        tvMerk = findViewById(R.id.tvTampil_Merek);
        tvModel = findViewById(R.id.tvTampil_Model);
        tvTahun = findViewById(R.id.tvTampil_Taun);
    }

    private void initData() {
        detailPresenter.getCarById(dataCar);
    }

    private void initPresenter() {
        detailPresenter = new DetailPresenter(this);
    }

    private void initIntentData() {
        dataCar = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (dataCar == null)
            finish();
    }

    @Override
    public void showErrorCarById(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessCarById(List<DataCar> car) {
        tvNama.setText(car.get(0).getName());
        tvMerk.setText(car.get(0).getMerk());
        tvModel.setText(car.get(0).getModel());
        tvTahun.setText(car.get(0).getYear());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }
    }
}
