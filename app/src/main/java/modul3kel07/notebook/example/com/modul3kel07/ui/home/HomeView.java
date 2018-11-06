package modul3kel07.notebook.example.com.modul3kel07.ui.home;

import java.util.List;

import modul3kel07.notebook.example.com.modul3kel07.data.model.DataCar;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);
}
