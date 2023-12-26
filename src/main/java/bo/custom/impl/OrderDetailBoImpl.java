package bo.custom.impl;

import bo.custom.OrderDetailBo;
import dao.DaoFactory;
import dao.custom.OrderDetailsDao;
import dao.util.FactoryType;
import dto.OrderDetailsDto;
import entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailBoImpl implements OrderDetailBo {

    OrderDetailsDao orderDetailsDao = DaoFactory.getInstance().getBo(FactoryType.ORDER_DETAIL);

    @Override
    public boolean saveOrderDetail(OrderDetailsDto dto) throws SQLException, ClassNotFoundException {
        List<OrderDetail> list = new ArrayList<>();

        list.add(new OrderDetail(
                dto.getOrderId(),
                dto.getItemCode(),
                dto.getQty(),
                dto.getUnitPrice()
        ));

        return orderDetailsDao.saveOrderDetails(list);
    }

    @Override
    public boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDetailsDao.delete(id);
    }

    @Override
    public List<OrderDetailsDto> getAll() throws SQLException, ClassNotFoundException {

        List<OrderDetail> entityList = orderDetailsDao.getAll();
        List<OrderDetailsDto> list = new ArrayList<>();

        for (OrderDetail orderDetail:entityList) {
            list.add(new OrderDetailsDto(
                    orderDetail.getOrderId(),
                    orderDetail.getItemCode(),
                    orderDetail.getQty(),
                    orderDetail.getUnitPrice()
            ));
        }

        return list;
    }

    @Override
    public OrderDetailsDto getOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return orderDetailsDao.getOrderDetail(id);
    }
}
