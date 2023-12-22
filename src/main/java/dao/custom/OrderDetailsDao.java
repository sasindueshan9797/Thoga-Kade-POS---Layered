package dao.custom;

import dao.CrudDao;
import dto.OrderDetailsDto;
import entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDao extends CrudDao<OrderDetail> {
    boolean saveOrderDetails(List<OrderDetail> list) throws SQLException, ClassNotFoundException;

    boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException;

    OrderDetailsDto getOrderDetail(String id) throws SQLException, ClassNotFoundException;

}
