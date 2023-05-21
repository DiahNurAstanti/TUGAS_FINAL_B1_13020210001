package penjualan_rumah.controller;

import penjualan_rumah.model.Rumah;
import penjualan_rumah.model.TabelModelRumah;
import penjualan_rumah.view.ViewPenjualanRumah;

import javax.swing.JOptionPane;
import java.util.List;
import penjualan_rumah.DAO.RumahDAO;
import penjualan_rumah.DAOImpl.RumahDAOImpl;

public class ControllerRumah {
    private ViewPenjualanRumah frameRumah;
    private RumahDAOImpl rumahDAOImpl;
    private List<Rumah> listRumah;

    public ControllerRumah(ViewPenjualanRumah frameRumah) {
        this.frameRumah = frameRumah;
        rumahDAOImpl = new RumahDAO(); // Menggunakan implementasi DAO yang sesuai
        listRumah = rumahDAOImpl.getAll();
        
        // Menampilkan data pada tabel saat aplikasi dijalankan
        isiTable();
    }

    public void reset() {
        frameRumah.getTxtId().setText("");
        frameRumah.getTxtNomorRumah().setText("");
        frameRumah.getTxtTipeRumah().setText("");
        frameRumah.getTxtLuasTanah().setText("");
        frameRumah.getTxtLuasBangunan().setText("");
        frameRumah.getTxtLokasi().setText("");
        frameRumah.getTxtHarga().setText("");
    }

    public void isiTable() {
        listRumah = rumahDAOImpl.getAll();
        TabelModelRumah tabelModel = new TabelModelRumah(listRumah);
        frameRumah.getTabelDataRumah().setModel(tabelModel);
    }

    public void isiField(int row) {
        Rumah rumah = listRumah.get(row);
        frameRumah.getTxtId().setText(String.valueOf(rumah.getId()));
        frameRumah.getTxtNomorRumah().setText(rumah.getNomorRumah());
        frameRumah.getTxtTipeRumah().setText(rumah.getTipeRumah());
        frameRumah.getTxtLuasTanah().setText(String.valueOf(rumah.getLuasTanah()));
        frameRumah.getTxtLuasBangunan().setText(String.valueOf(rumah.getLuasBangunan()));
        frameRumah.getTxtLokasi().setText(rumah.getLokasi());
        frameRumah.getTxtHarga().setText(String.valueOf(rumah.getHarga()));
    }

    public void insert() {
        if (!isInputEmpty()) {
            Rumah rumah = getInputRumah();
            rumahDAOImpl.insert(rumah);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            reset();
            isiTable();
        } else {
            JOptionPane.showMessageDialog(frameRumah, "Data tidak boleh kosong");
        }
    }

    public void update() {
    if (!frameRumah.getTxtId().getText().trim().isEmpty()) {
        int id = Integer.parseInt(frameRumah.getTxtId().getText());

        if (!isInputEmpty()) {
            Rumah rumah = getInputRumah();
            rumah.setId(id);
            rumahDAOImpl.update(rumah);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            reset();
            isiTable();
        } else {
            JOptionPane.showMessageDialog(frameRumah, "Data tidak boleh kosong");
        }
    } else {
        JOptionPane.showMessageDialog(frameRumah, "Silahkan pilih data yang akan diupdate");
    }
}

    public void delete() {
    if (!frameRumah.getTxtId().getText().trim().isEmpty()) {
        int id = Integer.parseInt(frameRumah.getTxtId().getText());
        rumahDAOImpl.delete(id);
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        reset();
        isiTable();
    } else {
        JOptionPane.showMessageDialog(frameRumah, "Silahkan pilih data yang akan dihapus");
    }
}

    public void CariNama() {
        String keyword = frameRumah.getTxtCariData().getText();
        listRumah = rumahDAOImpl.getsearchByKeyword(keyword);
        TabelModelRumah tabelModel = new TabelModelRumah(listRumah);
        frameRumah.getTabelDataRumah().setModel(tabelModel);
    }

    private boolean isInputEmpty() {
        return frameRumah.getTxtNomorRumah().getText().trim().isEmpty() ||
                frameRumah.getTxtTipeRumah().getText().trim().isEmpty() ||
                frameRumah.getTxtLuasTanah().getText().trim().isEmpty() ||
                frameRumah.getTxtLuasBangunan().getText().trim().isEmpty() ||
                frameRumah.getTxtLokasi().getText().trim().isEmpty() ||
                frameRumah.getTxtHarga().getText().trim().isEmpty();
    }

    private Rumah getInputRumah() {
        Rumah rumah = new Rumah();
        rumah.setNomorRumah(frameRumah.getTxtNomorRumah().getText());
        rumah.setTipeRumah(frameRumah.getTxtTipeRumah().getText());
        rumah.setLuasTanah((int) Double.parseDouble(frameRumah.getTxtLuasTanah().getText()));
        rumah.setLuasBangunan((int) Double.parseDouble(frameRumah.getTxtLuasBangunan().getText()));
        rumah.setLokasi(frameRumah.getTxtLokasi().getText());
        rumah.setHarga((int) Double.parseDouble(frameRumah.getTxtHarga().getText()));
        return rumah;
    }
}
