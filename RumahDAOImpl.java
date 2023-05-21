package penjualan_rumah.DAOImpl;

import java.util.List;
import penjualan_rumah.model.Rumah;


public interface RumahDAOImpl{

    public void insert(Rumah rumah);

    public void update(Rumah rumah);

    public void delete(int id); 
    public List<Rumah> getAll(); 
    public List<Rumah> getsearchByKeyword(String keyword);
}
