package bo.custom.impl;

import bo.custom.OrderBo;
import dao.DaoFactory;
import dao.custom.OrderDao;
import dao.util.FactoryType;
import dto.OrderDto;
import entity.Order;

import java.sql.SQLException;

public class OrderBoImpl implements OrderBo {

    private OrderDao orderDao = DaoFactory.getInstance().getBo(FactoryType.ORDER);

    @Override
    public boolean saveOrder(OrderDto dto) throws SQLException, ClassNotFoundException {
        return orderDao.save(new Order(
                dto.getOrderId(),
                dto.getDate(),
                dto.getCustId()
        ));
    }

    @Override
    public OrderDto lastOrder() throws SQLException, ClassNotFoundException {

        Order order = orderDao.lastOrder();

        return new OrderDto(
                order.getId(),
                order.getDate(),
                order.getCustomerId(),
                null
        );
    }

    @Override
    public OrderDto getOrder(String id) throws SQLException, ClassNotFoundException {

        Order order = orderDao.getOrder(id);

        return new OrderDto(
                order.getId(),
                order.getDate(),
                order.getCustomerId(),
                null
        );
    }
}
