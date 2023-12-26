package dao.custom;

import dao.CrudDao;
import dto.OrderDto;
import entity.Order;

import java.sql.SQLException;

public interface OrderDao extends CrudDao<Order> {

    Order lastOrder() throws SQLException, ClassNotFoundException;

    Order getOrder(String id) throws SQLException, ClassNotFoundException;

}
