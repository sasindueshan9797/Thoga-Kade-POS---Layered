package bo.custom;

import bo.SuperBo;
import dto.OrderDetailsDto;


import java.sql.SQLException;
import java.util.List;

public interface OrderDetailBo extends SuperBo {
    boolean saveOrderDetail(OrderDetailsDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException;

    List<OrderDetailsDto> getAll() throws SQLException, ClassNotFoundException;

    OrderDetailsDto getOrderDetail(String id) throws SQLException, ClassNotFoundException;
}
