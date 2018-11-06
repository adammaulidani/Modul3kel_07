package modul3kel07.notebook.example.com.modul3kel07.adapter.car;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import modul3kel07.notebook.example.com.modul3kel07.R;
import modul3kel07.notebook.example.com.modul3kel07.data.model.DataCar;


public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<DataCar> dataCars;
    private CarListener carListerner;

    public CarAdapter(List<DataCar> dataCars){
        this.dataCars = dataCars;
    }

    public void setAdapterListener(CarListener carListerner){
        this.carListerner = carListerner;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        DataCar dataUser = get(position);
        holder.bind(dataUser, carListerner);
    }

    private DataCar get(int position) {
        return dataCars.get(position);
    }

    @Override
    public int getItemCount() {
        if (dataCars == null) return 0;
        return dataCars.size();
    }
}
