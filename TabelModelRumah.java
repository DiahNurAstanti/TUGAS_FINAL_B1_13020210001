package penjualan_rumah.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TabelModelRumah extends AbstractTableModel {
    private List<Rumah> listRumah;
    private final String[] columnNames = {"ID", "Nomor Rumah", "Tipe Rumah", "Luas Tanah", "Luas Bangunan", "Lokasi", "Harga"};

    public TabelModelRumah(List<Rumah> listRumah) {
        this.listRumah = listRumah;
    }

    @Override
    public int getRowCount() {
        return listRumah.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rumah rumah = listRumah.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rumah.getId();
            case 1:
                return rumah.getNomorRumah();
            case 2:
                return rumah.getTipeRumah();
            case 3:
                return rumah.getLuasTanah();
            case 4:
                return rumah.getLuasBangunan();
            case 5:
                return rumah.getLokasi();
            case 6:
                return rumah.getHarga();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
