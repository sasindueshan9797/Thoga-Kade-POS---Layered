package dao.custom;

import dao.CrudDao;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends CrudDao<Item> {
    Item getItem(String code) throws SQLException, ClassNotFoundException;
    Item lastItem() throws SQLException, ClassNotFoundException;
}
