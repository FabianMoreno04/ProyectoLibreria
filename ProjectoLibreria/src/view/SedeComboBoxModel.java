package view;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import models.Sede;

public class SedeComboBoxModel extends DefaultComboBoxModel<Sede> {
    private List<Sede> sedes;

    public SedeComboBoxModel(List<Sede> sedes) {
        this.sedes = sedes;
    }

    @Override
    public Sede getElementAt(int index) {
        if (index >= 0 && index < sedes.size()) {
            return sedes.get(index);
        }
        return null;
    }

    @Override
    public int getSize() {
        return sedes.size();
    }
}
