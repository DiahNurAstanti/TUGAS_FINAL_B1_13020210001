package penjualan_rumah.DAO;

import penjualan_rumah.koneksi.koneksi;
import penjualan_rumah.model.Rumah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import penjualan_rumah.DAOImpl.RumahDAOImpl;

public class RumahDAO implements RumahDAOImpl {

    private Connection connection;
    private final String insertQuery = "INSERT INTO rumah (nomor_rumah, tipe_rumah, luas_tanah, luas_bangunan, lokasi, harga) VALUES (?, ?, ?, ?, ?, ?)";
    private final String updateQuery = "UPDATE rumah SET nomor_rumah = ?, tipe_rumah = ?, luas_tanah = ?, luas_bangunan = ?, lokasi = ?, harga = ? WHERE id = ?";
    private final String deleteQuery = "DELETE FROM rumah WHERE id = ?";
    private final String selectAllQuery = "SELECT * FROM rumah";
    private final String searchByKeywordQuery = "SELECT * FROM rumah WHERE nomor_rumah LIKE ? OR tipe_rumah LIKE ? OR lokasi LIKE ?";

    public RumahDAO() {
        connection = koneksi.connection();
    }

    @Override
    public void insert(Rumah rumah) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, rumah.getNomorRumah());
            statement.setString(2, rumah.getTipeRumah());
            statement.setInt(3, rumah.getLuasTanah());
            statement.setInt(4, rumah.getLuasBangunan());
            statement.setString(5, rumah.getLokasi());
            statement.setInt(6, rumah.getHarga());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Rumah rumah) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(updateQuery);
            statement.setString(1, rumah.getNomorRumah());
            statement.setString(2, rumah.getTipeRumah());
            statement.setInt(3, rumah.getLuasTanah());
            statement.setInt(4, rumah.getLuasBangunan());
            statement.setString(5, rumah.getLokasi());
            statement.setInt(6, rumah.getHarga());
            statement.setInt(7, rumah.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Rumah> getAll() {
        List<Rumah> rumahList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectAllQuery);
            while (rs.next()) {
                Rumah rumah = new Rumah();
                rumah.setId(rs.getInt("id"));
                rumah.setNomorRumah(rs.getString("nomor_rumah"));
                rumah.setTipeRumah(rs.getString("tipe_rumah"));
                rumah.setLuasTanah(rs.getInt("luas_tanah"));
                rumah.setLuasBangunan(rs.getInt("luas_bangunan"));
                rumah.setLokasi(rs.getString("lokasi"));
                rumah.setHarga(rs.getInt("harga"));
                rumahList.add(rumah);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rumahList;
    }

    @Override
    public List<Rumah> getsearchByKeyword(String keyword) {
        List<Rumah> rumahList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(searchByKeywordQuery);
            String likeKeyword = "%" + keyword + "%";
            statement.setString(1, likeKeyword);
            statement.setString(2, likeKeyword);
            statement.setString(3, likeKeyword);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Rumah rumah = new Rumah();
                rumah.setId(rs.getInt("id"));
                rumah.setNomorRumah(rs.getString("nomor_rumah"));
                rumah.setTipeRumah(rs.getString("tipe_rumah"));
                rumah.setLuasTanah(rs.getInt("luas_tanah"));
                rumah.setLuasBangunan(rs.getInt("luas_bangunan"));
                rumah.setLokasi(rs.getString("lokasi"));
                rumah.setHarga(rs.getInt("harga"));
                rumahList.add(rumah);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RumahDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rumahList;
    }
}
