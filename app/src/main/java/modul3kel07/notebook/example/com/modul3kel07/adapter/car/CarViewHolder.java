package modul3kel07.notebook.example.com.modul3kel07.adapter.car;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import modul3kel07.notebook.example.com.modul3kel07.R;
import modul3kel07.notebook.example.com.modul3kel07.data.model.DataCar;

public class CarViewHolder extends RecyclerView.ViewHolder {
    LinearLayout linearLayout;
    TextView tvHomeName;
    TextView tvHomeMerk;

    public CarViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        linearLayout = itemView.findViewById(R.id.llItemC);
        tvHomeName = itemView.findViewById(R.id.tvItemCName);
        tvHomeMerk = itemView.findViewById(R.id.tvItemCMerk);
    }

    public void bind(final DataCar dataCar, final CarListener carListerner) {
        tvHomeName.setText(dataCar.getName());
        tvHomeMerk.setText(dataCar.getMerk());

        linearLayout.setOnClickListener(v -> carListerner.onCarClick(dataCar));
    }
}
